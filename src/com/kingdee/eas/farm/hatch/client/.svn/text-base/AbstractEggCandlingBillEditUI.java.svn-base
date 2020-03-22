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
public abstract class AbstractEggCandlingBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractEggCandlingBillEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallNoFertileEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallAddleEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallRottenEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallHatchEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoperator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallHealthEggQty;
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
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEggEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEggEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallNoFertileEggQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallAddleEggQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallRottenEggQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallHatchEggQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtoperator;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallHealthEggQty;
    protected com.kingdee.eas.farm.hatch.EggCandlingBillInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractEggCandlingBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractEggCandlingBillEditUI.class.getName());
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
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthatchFactory = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.kDTabbedPane2 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contallNoFertileEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallAddleEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallRottenEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallHatchEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoperator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallHealthEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
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
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEggEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.txtallNoFertileEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallAddleEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallRottenEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallHatchEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtoperator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtallHealthEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
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
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.kDTabbedPane2.setName("kDTabbedPane2");
        this.contallNoFertileEggQty.setName("contallNoFertileEggQty");
        this.contallAddleEggQty.setName("contallAddleEggQty");
        this.contallRottenEggQty.setName("contallRottenEggQty");
        this.contallHatchEggQty.setName("contallHatchEggQty");
        this.contoperator.setName("contoperator");
        this.contallHealthEggQty.setName("contallHealthEggQty");
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
        this.kDPanel1.setName("kDPanel1");
        this.kdtEntrys.setName("kdtEntrys");
        this.kDPanel2.setName("kDPanel2");
        this.kdtEggEntrys.setName("kdtEggEntrys");
        this.txtallNoFertileEggQty.setName("txtallNoFertileEggQty");
        this.txtallAddleEggQty.setName("txtallAddleEggQty");
        this.txtallRottenEggQty.setName("txtallRottenEggQty");
        this.txtallHatchEggQty.setName("txtallHatchEggQty");
        this.prmtoperator.setName("prmtoperator");
        this.txtallHealthEggQty.setName("txtallHealthEggQty");
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
        // kDTabbedPane1
        // kDTabbedPane2
        // contallNoFertileEggQty		
        this.contallNoFertileEggQty.setBoundLabelText(resHelper.getString("contallNoFertileEggQty.boundLabelText"));		
        this.contallNoFertileEggQty.setBoundLabelLength(100);		
        this.contallNoFertileEggQty.setBoundLabelUnderline(true);		
        this.contallNoFertileEggQty.setVisible(true);
        // contallAddleEggQty		
        this.contallAddleEggQty.setBoundLabelText(resHelper.getString("contallAddleEggQty.boundLabelText"));		
        this.contallAddleEggQty.setBoundLabelLength(100);		
        this.contallAddleEggQty.setBoundLabelUnderline(true);		
        this.contallAddleEggQty.setVisible(true);
        // contallRottenEggQty		
        this.contallRottenEggQty.setBoundLabelText(resHelper.getString("contallRottenEggQty.boundLabelText"));		
        this.contallRottenEggQty.setBoundLabelLength(100);		
        this.contallRottenEggQty.setBoundLabelUnderline(true);		
        this.contallRottenEggQty.setVisible(true);
        // contallHatchEggQty		
        this.contallHatchEggQty.setBoundLabelText(resHelper.getString("contallHatchEggQty.boundLabelText"));		
        this.contallHatchEggQty.setBoundLabelLength(100);		
        this.contallHatchEggQty.setBoundLabelUnderline(true);		
        this.contallHatchEggQty.setVisible(true);
        // contoperator		
        this.contoperator.setBoundLabelText(resHelper.getString("contoperator.boundLabelText"));		
        this.contoperator.setBoundLabelLength(100);		
        this.contoperator.setBoundLabelUnderline(true);		
        this.contoperator.setVisible(true);
        // contallHealthEggQty		
        this.contallHealthEggQty.setBoundLabelText(resHelper.getString("contallHealthEggQty.boundLabelText"));		
        this.contallHealthEggQty.setBoundLabelLength(100);		
        this.contallHealthEggQty.setBoundLabelUnderline(true);		
        this.contallHealthEggQty.setVisible(true);
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
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);
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
					
        // kDPanel1
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"incubator\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"eggAllQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"noFertileEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"healthEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"addleEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"rottenEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"otherEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{incubator}</t:Cell><t:Cell>$Resource{eggAllQty}</t:Cell><t:Cell>$Resource{noFertileEggQty}</t:Cell><t:Cell>$Resource{healthEggQty}</t:Cell><t:Cell>$Resource{addleEggQty}</t:Cell><t:Cell>$Resource{rottenEggQty}</t:Cell><t:Cell>$Resource{otherEggQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","incubator","eggAllQty","noFertileEggQty","healthEggQty","addleEggQty","rottenEggQty","otherEggQty"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_incubator_PromptBox = new KDBizPromptBox();
        kdtEntrys_incubator_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7IncubatorQuery");
        kdtEntrys_incubator_PromptBox.setVisible(true);
        kdtEntrys_incubator_PromptBox.setEditable(true);
        kdtEntrys_incubator_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_incubator_PromptBox.setEditFormat("$number$");
        kdtEntrys_incubator_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_incubator_CellEditor = new KDTDefaultCellEditor(kdtEntrys_incubator_PromptBox);
        this.kdtEntrys.getColumn("incubator").setEditor(kdtEntrys_incubator_CellEditor);
        ObjectValueRender kdtEntrys_incubator_OVR = new ObjectValueRender();
        kdtEntrys_incubator_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("incubator").setRenderer(kdtEntrys_incubator_OVR);
        			kdtEntrys_incubator_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.IncubatorListUI kdtEntrys_incubator_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_incubator_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_incubator_PromptBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.IncubatorListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_incubator_PromptBox_F7ListUI));
					kdtEntrys_incubator_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_incubator_PromptBox.setSelector(kdtEntrys_incubator_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtEntrys_eggAllQty_TextField = new KDFormattedTextField();
        kdtEntrys_eggAllQty_TextField.setName("kdtEntrys_eggAllQty_TextField");
        kdtEntrys_eggAllQty_TextField.setVisible(true);
        kdtEntrys_eggAllQty_TextField.setEditable(true);
        kdtEntrys_eggAllQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_eggAllQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_eggAllQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_eggAllQty_TextField);
        this.kdtEntrys.getColumn("eggAllQty").setEditor(kdtEntrys_eggAllQty_CellEditor);
        KDFormattedTextField kdtEntrys_noFertileEggQty_TextField = new KDFormattedTextField();
        kdtEntrys_noFertileEggQty_TextField.setName("kdtEntrys_noFertileEggQty_TextField");
        kdtEntrys_noFertileEggQty_TextField.setVisible(true);
        kdtEntrys_noFertileEggQty_TextField.setEditable(true);
        kdtEntrys_noFertileEggQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_noFertileEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_noFertileEggQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_noFertileEggQty_TextField);
        this.kdtEntrys.getColumn("noFertileEggQty").setEditor(kdtEntrys_noFertileEggQty_CellEditor);
        KDFormattedTextField kdtEntrys_healthEggQty_TextField = new KDFormattedTextField();
        kdtEntrys_healthEggQty_TextField.setName("kdtEntrys_healthEggQty_TextField");
        kdtEntrys_healthEggQty_TextField.setVisible(true);
        kdtEntrys_healthEggQty_TextField.setEditable(true);
        kdtEntrys_healthEggQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_healthEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_healthEggQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_healthEggQty_TextField);
        this.kdtEntrys.getColumn("healthEggQty").setEditor(kdtEntrys_healthEggQty_CellEditor);
        KDFormattedTextField kdtEntrys_addleEggQty_TextField = new KDFormattedTextField();
        kdtEntrys_addleEggQty_TextField.setName("kdtEntrys_addleEggQty_TextField");
        kdtEntrys_addleEggQty_TextField.setVisible(true);
        kdtEntrys_addleEggQty_TextField.setEditable(true);
        kdtEntrys_addleEggQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_addleEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_addleEggQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_addleEggQty_TextField);
        this.kdtEntrys.getColumn("addleEggQty").setEditor(kdtEntrys_addleEggQty_CellEditor);
        KDFormattedTextField kdtEntrys_rottenEggQty_TextField = new KDFormattedTextField();
        kdtEntrys_rottenEggQty_TextField.setName("kdtEntrys_rottenEggQty_TextField");
        kdtEntrys_rottenEggQty_TextField.setVisible(true);
        kdtEntrys_rottenEggQty_TextField.setEditable(true);
        kdtEntrys_rottenEggQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_rottenEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_rottenEggQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_rottenEggQty_TextField);
        this.kdtEntrys.getColumn("rottenEggQty").setEditor(kdtEntrys_rottenEggQty_CellEditor);
        KDFormattedTextField kdtEntrys_otherEggQty_TextField = new KDFormattedTextField();
        kdtEntrys_otherEggQty_TextField.setName("kdtEntrys_otherEggQty_TextField");
        kdtEntrys_otherEggQty_TextField.setVisible(true);
        kdtEntrys_otherEggQty_TextField.setEditable(true);
        kdtEntrys_otherEggQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_otherEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_otherEggQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_otherEggQty_TextField);
        this.kdtEntrys.getColumn("otherEggQty").setEditor(kdtEntrys_otherEggQty_CellEditor);
        // kDPanel2
        // kdtEggEntrys
		String kdtEggEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"eggSourceType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"eggHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"eggLog\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"farmFactory\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"eggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"noFertileEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"addleEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"brokenEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"rottenEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"healthEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"otherEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{eggSourceType}</t:Cell><t:Cell>$Resource{eggHouse}</t:Cell><t:Cell>$Resource{eggLog}</t:Cell><t:Cell>$Resource{farmFactory}</t:Cell><t:Cell>$Resource{eggQty}</t:Cell><t:Cell>$Resource{noFertileEggQty}</t:Cell><t:Cell>$Resource{addleEggQty}</t:Cell><t:Cell>$Resource{brokenEggQty}</t:Cell><t:Cell>$Resource{rottenEggQty}</t:Cell><t:Cell>$Resource{healthEggQty}</t:Cell><t:Cell>$Resource{otherEggQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEggEntrys.setFormatXml(resHelper.translateString("kdtEggEntrys",kdtEggEntrysStrXML));

                this.kdtEggEntrys.putBindContents("editData",new String[] {"EggEntrys.seq","EggEntrys.eggSourceType","EggEntrys.eggHouse","EggEntrys.eggLog","EggEntrys.farmFactory","EggEntrys.eggQty","EggEntrys.noFertileEggQty","EggEntrys.addleEggQty","EggEntrys.brokenEggQty","EggEntrys.rottenEggQty","EggEntrys.healthEggQty","EggEntrys.otherEggQty"});


        this.kdtEggEntrys.checkParsed();
        KDFormattedTextField kdtEggEntrys_seq_TextField = new KDFormattedTextField();
        kdtEggEntrys_seq_TextField.setName("kdtEggEntrys_seq_TextField");
        kdtEggEntrys_seq_TextField.setVisible(true);
        kdtEggEntrys_seq_TextField.setEditable(true);
        kdtEggEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtEggEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtEggEntrys_seq_TextField);
        this.kdtEggEntrys.getColumn("seq").setEditor(kdtEggEntrys_seq_CellEditor);
        KDComboBox kdtEggEntrys_eggSourceType_ComboBox = new KDComboBox();
        kdtEggEntrys_eggSourceType_ComboBox.setName("kdtEggEntrys_eggSourceType_ComboBox");
        kdtEggEntrys_eggSourceType_ComboBox.setVisible(true);
        kdtEggEntrys_eggSourceType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.EggSourceType").toArray());
        KDTDefaultCellEditor kdtEggEntrys_eggSourceType_CellEditor = new KDTDefaultCellEditor(kdtEggEntrys_eggSourceType_ComboBox);
        this.kdtEggEntrys.getColumn("eggSourceType").setEditor(kdtEggEntrys_eggSourceType_CellEditor);
        final KDBizPromptBox kdtEggEntrys_eggHouse_PromptBox = new KDBizPromptBox();
        kdtEggEntrys_eggHouse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtEggEntrys_eggHouse_PromptBox.setVisible(true);
        kdtEggEntrys_eggHouse_PromptBox.setEditable(true);
        kdtEggEntrys_eggHouse_PromptBox.setDisplayFormat("$number$");
        kdtEggEntrys_eggHouse_PromptBox.setEditFormat("$number$");
        kdtEggEntrys_eggHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntrys_eggHouse_CellEditor = new KDTDefaultCellEditor(kdtEggEntrys_eggHouse_PromptBox);
        this.kdtEggEntrys.getColumn("eggHouse").setEditor(kdtEggEntrys_eggHouse_CellEditor);
        ObjectValueRender kdtEggEntrys_eggHouse_OVR = new ObjectValueRender();
        kdtEggEntrys_eggHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntrys.getColumn("eggHouse").setRenderer(kdtEggEntrys_eggHouse_OVR);
        KDTextField kdtEggEntrys_eggLog_TextField = new KDTextField();
        kdtEggEntrys_eggLog_TextField.setName("kdtEggEntrys_eggLog_TextField");
        kdtEggEntrys_eggLog_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEggEntrys_eggLog_CellEditor = new KDTDefaultCellEditor(kdtEggEntrys_eggLog_TextField);
        this.kdtEggEntrys.getColumn("eggLog").setEditor(kdtEggEntrys_eggLog_CellEditor);
        final KDBizPromptBox kdtEggEntrys_farmFactory_PromptBox = new KDBizPromptBox();
        kdtEggEntrys_farmFactory_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedStoorgSetQuery");
        kdtEggEntrys_farmFactory_PromptBox.setVisible(true);
        kdtEggEntrys_farmFactory_PromptBox.setEditable(true);
        kdtEggEntrys_farmFactory_PromptBox.setDisplayFormat("$number$");
        kdtEggEntrys_farmFactory_PromptBox.setEditFormat("$number$");
        kdtEggEntrys_farmFactory_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntrys_farmFactory_CellEditor = new KDTDefaultCellEditor(kdtEggEntrys_farmFactory_PromptBox);
        this.kdtEggEntrys.getColumn("farmFactory").setEditor(kdtEggEntrys_farmFactory_CellEditor);
        ObjectValueRender kdtEggEntrys_farmFactory_OVR = new ObjectValueRender();
        kdtEggEntrys_farmFactory_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntrys.getColumn("farmFactory").setRenderer(kdtEggEntrys_farmFactory_OVR);
        KDFormattedTextField kdtEggEntrys_eggQty_TextField = new KDFormattedTextField();
        kdtEggEntrys_eggQty_TextField.setName("kdtEggEntrys_eggQty_TextField");
        kdtEggEntrys_eggQty_TextField.setVisible(true);
        kdtEggEntrys_eggQty_TextField.setEditable(true);
        kdtEggEntrys_eggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntrys_eggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntrys_eggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntrys_eggQty_TextField);
        this.kdtEggEntrys.getColumn("eggQty").setEditor(kdtEggEntrys_eggQty_CellEditor);
        KDFormattedTextField kdtEggEntrys_noFertileEggQty_TextField = new KDFormattedTextField();
        kdtEggEntrys_noFertileEggQty_TextField.setName("kdtEggEntrys_noFertileEggQty_TextField");
        kdtEggEntrys_noFertileEggQty_TextField.setVisible(true);
        kdtEggEntrys_noFertileEggQty_TextField.setEditable(true);
        kdtEggEntrys_noFertileEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntrys_noFertileEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntrys_noFertileEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntrys_noFertileEggQty_TextField);
        this.kdtEggEntrys.getColumn("noFertileEggQty").setEditor(kdtEggEntrys_noFertileEggQty_CellEditor);
        KDFormattedTextField kdtEggEntrys_addleEggQty_TextField = new KDFormattedTextField();
        kdtEggEntrys_addleEggQty_TextField.setName("kdtEggEntrys_addleEggQty_TextField");
        kdtEggEntrys_addleEggQty_TextField.setVisible(true);
        kdtEggEntrys_addleEggQty_TextField.setEditable(true);
        kdtEggEntrys_addleEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntrys_addleEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntrys_addleEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntrys_addleEggQty_TextField);
        this.kdtEggEntrys.getColumn("addleEggQty").setEditor(kdtEggEntrys_addleEggQty_CellEditor);
        KDFormattedTextField kdtEggEntrys_brokenEggQty_TextField = new KDFormattedTextField();
        kdtEggEntrys_brokenEggQty_TextField.setName("kdtEggEntrys_brokenEggQty_TextField");
        kdtEggEntrys_brokenEggQty_TextField.setVisible(true);
        kdtEggEntrys_brokenEggQty_TextField.setEditable(true);
        kdtEggEntrys_brokenEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntrys_brokenEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntrys_brokenEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntrys_brokenEggQty_TextField);
        this.kdtEggEntrys.getColumn("brokenEggQty").setEditor(kdtEggEntrys_brokenEggQty_CellEditor);
        KDFormattedTextField kdtEggEntrys_rottenEggQty_TextField = new KDFormattedTextField();
        kdtEggEntrys_rottenEggQty_TextField.setName("kdtEggEntrys_rottenEggQty_TextField");
        kdtEggEntrys_rottenEggQty_TextField.setVisible(true);
        kdtEggEntrys_rottenEggQty_TextField.setEditable(true);
        kdtEggEntrys_rottenEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntrys_rottenEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntrys_rottenEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntrys_rottenEggQty_TextField);
        this.kdtEggEntrys.getColumn("rottenEggQty").setEditor(kdtEggEntrys_rottenEggQty_CellEditor);
        KDFormattedTextField kdtEggEntrys_healthEggQty_TextField = new KDFormattedTextField();
        kdtEggEntrys_healthEggQty_TextField.setName("kdtEggEntrys_healthEggQty_TextField");
        kdtEggEntrys_healthEggQty_TextField.setVisible(true);
        kdtEggEntrys_healthEggQty_TextField.setEditable(true);
        kdtEggEntrys_healthEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntrys_healthEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntrys_healthEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntrys_healthEggQty_TextField);
        this.kdtEggEntrys.getColumn("healthEggQty").setEditor(kdtEggEntrys_healthEggQty_CellEditor);
        KDFormattedTextField kdtEggEntrys_otherEggQty_TextField = new KDFormattedTextField();
        kdtEggEntrys_otherEggQty_TextField.setName("kdtEggEntrys_otherEggQty_TextField");
        kdtEggEntrys_otherEggQty_TextField.setVisible(true);
        kdtEggEntrys_otherEggQty_TextField.setEditable(true);
        kdtEggEntrys_otherEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntrys_otherEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntrys_otherEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntrys_otherEggQty_TextField);
        this.kdtEggEntrys.getColumn("otherEggQty").setEditor(kdtEggEntrys_otherEggQty_CellEditor);
        // txtallNoFertileEggQty		
        this.txtallNoFertileEggQty.setHorizontalAlignment(2);		
        this.txtallNoFertileEggQty.setDataType(0);		
        this.txtallNoFertileEggQty.setSupportedEmpty(true);		
        this.txtallNoFertileEggQty.setRequired(false);
        // txtallAddleEggQty		
        this.txtallAddleEggQty.setHorizontalAlignment(2);		
        this.txtallAddleEggQty.setDataType(0);		
        this.txtallAddleEggQty.setSupportedEmpty(true);		
        this.txtallAddleEggQty.setRequired(false);
        // txtallRottenEggQty		
        this.txtallRottenEggQty.setHorizontalAlignment(2);		
        this.txtallRottenEggQty.setDataType(0);		
        this.txtallRottenEggQty.setSupportedEmpty(true);		
        this.txtallRottenEggQty.setRequired(false);
        // txtallHatchEggQty		
        this.txtallHatchEggQty.setHorizontalAlignment(2);		
        this.txtallHatchEggQty.setDataType(0);		
        this.txtallHatchEggQty.setSupportedEmpty(true);		
        this.txtallHatchEggQty.setRequired(false);
        // prmtoperator		
        this.prmtoperator.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtoperator.setEditable(true);		
        this.prmtoperator.setDisplayFormat("$name$");		
        this.prmtoperator.setEditFormat("$number$");		
        this.prmtoperator.setCommitFormat("$number$");		
        this.prmtoperator.setRequired(false);
        // txtallHealthEggQty		
        this.txtallHealthEggQty.setHorizontalAlignment(2);		
        this.txtallHealthEggQty.setDataType(0);		
        this.txtallHealthEggQty.setSupportedEmpty(true);		
        this.txtallHealthEggQty.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {pkauditTime,kdtEggEntrys,baseStatus,prmthatchFactory,txtallNoFertileEggQty,txtallAddleEggQty,txtallRottenEggQty,txtallHatchEggQty,prmtoperator,txtallHealthEggQty,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,kdtEntrys}));
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
        contCreator.setBounds(new Rectangle(373, 576, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(373, 576, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(373, 601, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(373, 601, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(725, 576, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(725, 576, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(725, 601, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(725, 601, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(18, 17, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(18, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(18, 94, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(18, 94, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(371, 94, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(371, 94, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(21, 576, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(21, 576, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(21, 601, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(21, 601, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbaseStatus.setBounds(new Rectangle(719, 42, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(719, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conthatchFactory.setBounds(new Rectangle(371, 17, 270, 19));
        this.add(conthatchFactory, new KDLayout.Constraints(371, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(17, 140, 413, 431));
        this.add(kDTabbedPane1, new KDLayout.Constraints(17, 140, 413, 431, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT));
        kDTabbedPane2.setBounds(new Rectangle(433, 141, 560, 431));
        this.add(kDTabbedPane2, new KDLayout.Constraints(433, 141, 560, 431, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contallNoFertileEggQty.setBounds(new Rectangle(18, 68, 270, 19));
        this.add(contallNoFertileEggQty, new KDLayout.Constraints(18, 68, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallAddleEggQty.setBounds(new Rectangle(719, 68, 270, 19));
        this.add(contallAddleEggQty, new KDLayout.Constraints(719, 68, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contallRottenEggQty.setBounds(new Rectangle(371, 68, 270, 19));
        this.add(contallRottenEggQty, new KDLayout.Constraints(371, 68, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallHatchEggQty.setBounds(new Rectangle(18, 42, 270, 19));
        this.add(contallHatchEggQty, new KDLayout.Constraints(18, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoperator.setBounds(new Rectangle(719, 13, 270, 19));
        this.add(contoperator, new KDLayout.Constraints(719, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contallHealthEggQty.setBounds(new Rectangle(371, 42, 270, 19));
        this.add(contallHealthEggQty, new KDLayout.Constraints(371, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 412, 398));        kdtEntrys.setBounds(new Rectangle(0, 1, 409, 397));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.hatch.EggCandlingBillEntryInfo(),null,false);
        kDPanel1.add(kdtEntrys_detailPanel, new KDLayout.Constraints(0, 1, 409, 397, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDTabbedPane2
        kDTabbedPane2.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 559, 398));        kdtEggEntrys.setBounds(new Rectangle(-2, 1, 554, 393));
        kdtEggEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEggEntrys,new com.kingdee.eas.farm.hatch.EggCandlingBillEntryEggEntryInfo(),null,false);
        kDPanel2.add(kdtEggEntrys_detailPanel, new KDLayout.Constraints(-2, 1, 554, 393, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEggEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("eggSourceType",new Integer(1));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //contallNoFertileEggQty
        contallNoFertileEggQty.setBoundEditor(txtallNoFertileEggQty);
        //contallAddleEggQty
        contallAddleEggQty.setBoundEditor(txtallAddleEggQty);
        //contallRottenEggQty
        contallRottenEggQty.setBoundEditor(txtallRottenEggQty);
        //contallHatchEggQty
        contallHatchEggQty.setBoundEditor(txtallHatchEggQty);
        //contoperator
        contoperator.setBoundEditor(prmtoperator);
        //contallHealthEggQty
        contallHealthEggQty.setBoundEditor(txtallHealthEggQty);

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
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("hatchFactory", com.kingdee.eas.farm.hatch.HatchBaseDataInfo.class, this.prmthatchFactory, "data");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.hatch.EggCandlingBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.incubator", java.lang.Object.class, this.kdtEntrys, "incubator.text");
		dataBinder.registerBinding("entrys.eggAllQty", int.class, this.kdtEntrys, "eggAllQty.text");
		dataBinder.registerBinding("entrys.noFertileEggQty", int.class, this.kdtEntrys, "noFertileEggQty.text");
		dataBinder.registerBinding("entrys.addleEggQty", int.class, this.kdtEntrys, "addleEggQty.text");
		dataBinder.registerBinding("entrys.rottenEggQty", int.class, this.kdtEntrys, "rottenEggQty.text");
		dataBinder.registerBinding("entrys.healthEggQty", int.class, this.kdtEntrys, "healthEggQty.text");
		dataBinder.registerBinding("entrys.otherEggQty", int.class, this.kdtEntrys, "otherEggQty.text");
		dataBinder.registerBinding("entrys.EggEntrys.seq", int.class, this.kdtEggEntrys, "seq.text");
		dataBinder.registerBinding("entrys.EggEntrys", com.kingdee.eas.farm.hatch.EggCandlingBillEntryEggEntryInfo.class, this.kdtEggEntrys, "userObject");
		dataBinder.registerBinding("entrys.EggEntrys.eggSourceType", com.kingdee.util.enums.Enum.class, this.kdtEggEntrys, "eggSourceType.text");
		dataBinder.registerBinding("entrys.EggEntrys.eggHouse", java.lang.Object.class, this.kdtEggEntrys, "eggHouse.text");
		dataBinder.registerBinding("entrys.EggEntrys.eggLog", String.class, this.kdtEggEntrys, "eggLog.text");
		dataBinder.registerBinding("entrys.EggEntrys.farmFactory", java.lang.Object.class, this.kdtEggEntrys, "farmFactory.text");
		dataBinder.registerBinding("entrys.EggEntrys.eggQty", int.class, this.kdtEggEntrys, "eggQty.text");
		dataBinder.registerBinding("entrys.EggEntrys.noFertileEggQty", int.class, this.kdtEggEntrys, "noFertileEggQty.text");
		dataBinder.registerBinding("entrys.EggEntrys.addleEggQty", int.class, this.kdtEggEntrys, "addleEggQty.text");
		dataBinder.registerBinding("entrys.EggEntrys.brokenEggQty", int.class, this.kdtEggEntrys, "brokenEggQty.text");
		dataBinder.registerBinding("entrys.EggEntrys.rottenEggQty", int.class, this.kdtEggEntrys, "rottenEggQty.text");
		dataBinder.registerBinding("entrys.EggEntrys.healthEggQty", int.class, this.kdtEggEntrys, "healthEggQty.text");
		dataBinder.registerBinding("entrys.EggEntrys.otherEggQty", int.class, this.kdtEggEntrys, "otherEggQty.text");
		dataBinder.registerBinding("allNoFertileEggQty", int.class, this.txtallNoFertileEggQty, "value");
		dataBinder.registerBinding("allAddleEggQty", int.class, this.txtallAddleEggQty, "value");
		dataBinder.registerBinding("allRottenEggQty", int.class, this.txtallRottenEggQty, "value");
		dataBinder.registerBinding("allHatchEggQty", int.class, this.txtallHatchEggQty, "value");
		dataBinder.registerBinding("operator", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtoperator, "data");
		dataBinder.registerBinding("allHealthEggQty", int.class, this.txtallHealthEggQty, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.hatch.app.EggCandlingBillEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.hatch.EggCandlingBillInfo)ov;
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
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchFactory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.incubator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.eggAllQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.noFertileEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.addleEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.rottenEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.healthEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.otherEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EggEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EggEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EggEntrys.eggSourceType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EggEntrys.eggHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EggEntrys.eggLog", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EggEntrys.farmFactory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EggEntrys.eggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EggEntrys.noFertileEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EggEntrys.addleEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EggEntrys.brokenEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EggEntrys.rottenEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EggEntrys.healthEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EggEntrys.otherEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allNoFertileEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allAddleEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allRottenEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allHatchEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("operator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allHealthEggQty", ValidateHelper.ON_SAVE);    		
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
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.incubator.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.incubator.id"));
			sic.add(new SelectorItemInfo("entrys.incubator.name"));
        	sic.add(new SelectorItemInfo("entrys.incubator.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.eggAllQty"));
    	sic.add(new SelectorItemInfo("entrys.noFertileEggQty"));
    	sic.add(new SelectorItemInfo("entrys.addleEggQty"));
    	sic.add(new SelectorItemInfo("entrys.rottenEggQty"));
    	sic.add(new SelectorItemInfo("entrys.healthEggQty"));
    	sic.add(new SelectorItemInfo("entrys.otherEggQty"));
    	sic.add(new SelectorItemInfo("entrys.EggEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.EggEntrys.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.EggEntrys.id"));
		}
    	sic.add(new SelectorItemInfo("entrys.EggEntrys.eggSourceType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.EggEntrys.eggHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.EggEntrys.eggHouse.id"));
			sic.add(new SelectorItemInfo("entrys.EggEntrys.eggHouse.name"));
        	sic.add(new SelectorItemInfo("entrys.EggEntrys.eggHouse.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.EggEntrys.eggLog"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.EggEntrys.farmFactory.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.EggEntrys.farmFactory.id"));
			sic.add(new SelectorItemInfo("entrys.EggEntrys.farmFactory.name"));
        	sic.add(new SelectorItemInfo("entrys.EggEntrys.farmFactory.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.EggEntrys.eggQty"));
    	sic.add(new SelectorItemInfo("entrys.EggEntrys.noFertileEggQty"));
    	sic.add(new SelectorItemInfo("entrys.EggEntrys.addleEggQty"));
    	sic.add(new SelectorItemInfo("entrys.EggEntrys.brokenEggQty"));
    	sic.add(new SelectorItemInfo("entrys.EggEntrys.rottenEggQty"));
    	sic.add(new SelectorItemInfo("entrys.EggEntrys.healthEggQty"));
    	sic.add(new SelectorItemInfo("entrys.EggEntrys.otherEggQty"));
        sic.add(new SelectorItemInfo("allNoFertileEggQty"));
        sic.add(new SelectorItemInfo("allAddleEggQty"));
        sic.add(new SelectorItemInfo("allRottenEggQty"));
        sic.add(new SelectorItemInfo("allHatchEggQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("operator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("operator.id"));
        	sic.add(new SelectorItemInfo("operator.number"));
        	sic.add(new SelectorItemInfo("operator.name"));
		}
        sic.add(new SelectorItemInfo("allHealthEggQty"));
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
        return new MetaDataPK("com.kingdee.eas.farm.hatch.client", "EggCandlingBillEditUI");
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
        return com.kingdee.eas.farm.hatch.client.EggCandlingBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.hatch.EggCandlingBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.hatch.EggCandlingBillInfo objectValue = new com.kingdee.eas.farm.hatch.EggCandlingBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/hatch/EggCandlingBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.hatch.app.EggCandlingBillQuery");
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
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}