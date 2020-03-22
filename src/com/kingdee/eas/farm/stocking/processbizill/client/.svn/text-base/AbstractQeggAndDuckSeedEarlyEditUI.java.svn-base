/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

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
public abstract class AbstractQeggAndDuckSeedEarlyEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractQeggAndDuckSeedEarlyEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtnumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdescription;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.stocking.processbizill.QeggAndDuckSeedEarlyInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractQeggAndDuckSeedEarlyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractQeggAndDuckSeedEarlyEditUI.class.getName());
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
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contnumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtnumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkbizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtdescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contAuditor.setName("contAuditor");
        this.kdtEntrys.setName("kdtEntrys");
        this.contnumber.setName("contnumber");
        this.contbizDate.setName("contbizDate");
        this.contdescription.setName("contdescription");
        this.contbillStatus.setName("contbillStatus");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.prmtAuditor.setName("prmtAuditor");
        this.txtnumber.setName("txtnumber");
        this.pkbizDate.setName("pkbizDate");
        this.txtdescription.setName("txtdescription");
        this.billStatus.setName("billStatus");
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
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"hactchArea\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" /><t:Column t:key=\"progeny\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" /><t:Column t:key=\"qEggLevel1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" t:styleID=\"sCol3\" /><t:Column t:key=\"qEggLevelB2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" t:styleID=\"sCol4\" /><t:Column t:key=\"qEggLevel2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" t:styleID=\"sCol5\" /><t:Column t:key=\"seedLevel1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" t:styleID=\"sCol6\" /><t:Column t:key=\"seedLevelSmall\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" t:styleID=\"sCol7\" /><t:Column t:key=\"seedLevel2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" t:styleID=\"sCol8\" /><t:Column t:key=\"seedLevel3\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" t:styleID=\"sCol9\" /><t:Column t:key=\"seedLevelNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" t:styleID=\"sCol10\" /><t:Column t:key=\"seedLevelDead\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" t:styleID=\"sCol11\" /><t:Column t:key=\"seedDuck\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" t:styleID=\"sCol12\" /><t:Column t:key=\"seedInventorytotal\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" t:styleID=\"sCol13\" /><t:Column t:key=\"hatchLevel1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" t:styleID=\"sCol14\" /><t:Column t:key=\"hatchLevelB2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"15\" t:styleID=\"sCol15\" /><t:Column t:key=\"hatchLevel2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"16\" t:styleID=\"sCol16\" /><t:Column t:key=\"remarks\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"17\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{hactchArea}</t:Cell><t:Cell>$Resource{progeny}</t:Cell><t:Cell>$Resource{qEggLevel1}</t:Cell><t:Cell>$Resource{qEggLevelB2}</t:Cell><t:Cell>$Resource{qEggLevel2}</t:Cell><t:Cell>$Resource{seedLevel1}</t:Cell><t:Cell>$Resource{seedLevelSmall}</t:Cell><t:Cell>$Resource{seedLevel2}</t:Cell><t:Cell>$Resource{seedLevel3}</t:Cell><t:Cell>$Resource{seedLevelNo}</t:Cell><t:Cell>$Resource{seedLevelDead}</t:Cell><t:Cell>$Resource{seedDuck}</t:Cell><t:Cell>$Resource{seedInventorytotal}</t:Cell><t:Cell>$Resource{hatchLevel1}</t:Cell><t:Cell>$Resource{hatchLevelB2}</t:Cell><t:Cell>$Resource{hatchLevel2}</t:Cell><t:Cell>$Resource{remarks}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","hactchArea","progeny","qEggLevel1","qEggLevelB2","qEggLevel2","seedLevel1","seedLevelSmall","seedLevel2","seedLevel3","seedLevelNo","seedLevelDead","seedDuck","seedInventorytotal","hatchLevel1","hatchLevelB2","hatchLevel2","remarks"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_hactchArea_PromptBox = new KDBizPromptBox();
        kdtEntrys_hactchArea_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7HatchAreaQuery");
        kdtEntrys_hactchArea_PromptBox.setVisible(true);
        kdtEntrys_hactchArea_PromptBox.setEditable(true);
        kdtEntrys_hactchArea_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_hactchArea_PromptBox.setEditFormat("$number$");
        kdtEntrys_hactchArea_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_hactchArea_CellEditor = new KDTDefaultCellEditor(kdtEntrys_hactchArea_PromptBox);
        this.kdtEntrys.getColumn("hactchArea").setEditor(kdtEntrys_hactchArea_CellEditor);
        ObjectValueRender kdtEntrys_hactchArea_OVR = new ObjectValueRender();
        kdtEntrys_hactchArea_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("hactchArea").setRenderer(kdtEntrys_hactchArea_OVR);
        KDComboBox kdtEntrys_progeny_ComboBox = new KDComboBox();
        kdtEntrys_progeny_ComboBox.setName("kdtEntrys_progeny_ComboBox");
        kdtEntrys_progeny_ComboBox.setVisible(true);
        kdtEntrys_progeny_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.GenerateType").toArray());
        KDTDefaultCellEditor kdtEntrys_progeny_CellEditor = new KDTDefaultCellEditor(kdtEntrys_progeny_ComboBox);
        this.kdtEntrys.getColumn("progeny").setEditor(kdtEntrys_progeny_CellEditor);
        KDFormattedTextField kdtEntrys_qEggLevel1_TextField = new KDFormattedTextField();
        kdtEntrys_qEggLevel1_TextField.setName("kdtEntrys_qEggLevel1_TextField");
        kdtEntrys_qEggLevel1_TextField.setVisible(true);
        kdtEntrys_qEggLevel1_TextField.setEditable(true);
        kdtEntrys_qEggLevel1_TextField.setHorizontalAlignment(2);
        kdtEntrys_qEggLevel1_TextField.setDataType(1);
        	kdtEntrys_qEggLevel1_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_qEggLevel1_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_qEggLevel1_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_qEggLevel1_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qEggLevel1_TextField);
        this.kdtEntrys.getColumn("qEggLevel1").setEditor(kdtEntrys_qEggLevel1_CellEditor);
        KDFormattedTextField kdtEntrys_qEggLevelB2_TextField = new KDFormattedTextField();
        kdtEntrys_qEggLevelB2_TextField.setName("kdtEntrys_qEggLevelB2_TextField");
        kdtEntrys_qEggLevelB2_TextField.setVisible(true);
        kdtEntrys_qEggLevelB2_TextField.setEditable(true);
        kdtEntrys_qEggLevelB2_TextField.setHorizontalAlignment(2);
        kdtEntrys_qEggLevelB2_TextField.setDataType(1);
        	kdtEntrys_qEggLevelB2_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_qEggLevelB2_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_qEggLevelB2_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_qEggLevelB2_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qEggLevelB2_TextField);
        this.kdtEntrys.getColumn("qEggLevelB2").setEditor(kdtEntrys_qEggLevelB2_CellEditor);
        KDFormattedTextField kdtEntrys_qEggLevel2_TextField = new KDFormattedTextField();
        kdtEntrys_qEggLevel2_TextField.setName("kdtEntrys_qEggLevel2_TextField");
        kdtEntrys_qEggLevel2_TextField.setVisible(true);
        kdtEntrys_qEggLevel2_TextField.setEditable(true);
        kdtEntrys_qEggLevel2_TextField.setHorizontalAlignment(2);
        kdtEntrys_qEggLevel2_TextField.setDataType(1);
        	kdtEntrys_qEggLevel2_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_qEggLevel2_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_qEggLevel2_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_qEggLevel2_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qEggLevel2_TextField);
        this.kdtEntrys.getColumn("qEggLevel2").setEditor(kdtEntrys_qEggLevel2_CellEditor);
        KDFormattedTextField kdtEntrys_seedLevel1_TextField = new KDFormattedTextField();
        kdtEntrys_seedLevel1_TextField.setName("kdtEntrys_seedLevel1_TextField");
        kdtEntrys_seedLevel1_TextField.setVisible(true);
        kdtEntrys_seedLevel1_TextField.setEditable(true);
        kdtEntrys_seedLevel1_TextField.setHorizontalAlignment(2);
        kdtEntrys_seedLevel1_TextField.setDataType(1);
        	kdtEntrys_seedLevel1_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_seedLevel1_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_seedLevel1_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_seedLevel1_CellEditor = new KDTDefaultCellEditor(kdtEntrys_seedLevel1_TextField);
        this.kdtEntrys.getColumn("seedLevel1").setEditor(kdtEntrys_seedLevel1_CellEditor);
        KDFormattedTextField kdtEntrys_seedLevelSmall_TextField = new KDFormattedTextField();
        kdtEntrys_seedLevelSmall_TextField.setName("kdtEntrys_seedLevelSmall_TextField");
        kdtEntrys_seedLevelSmall_TextField.setVisible(true);
        kdtEntrys_seedLevelSmall_TextField.setEditable(true);
        kdtEntrys_seedLevelSmall_TextField.setHorizontalAlignment(2);
        kdtEntrys_seedLevelSmall_TextField.setDataType(1);
        	kdtEntrys_seedLevelSmall_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_seedLevelSmall_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_seedLevelSmall_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_seedLevelSmall_CellEditor = new KDTDefaultCellEditor(kdtEntrys_seedLevelSmall_TextField);
        this.kdtEntrys.getColumn("seedLevelSmall").setEditor(kdtEntrys_seedLevelSmall_CellEditor);
        KDFormattedTextField kdtEntrys_seedLevel2_TextField = new KDFormattedTextField();
        kdtEntrys_seedLevel2_TextField.setName("kdtEntrys_seedLevel2_TextField");
        kdtEntrys_seedLevel2_TextField.setVisible(true);
        kdtEntrys_seedLevel2_TextField.setEditable(true);
        kdtEntrys_seedLevel2_TextField.setHorizontalAlignment(2);
        kdtEntrys_seedLevel2_TextField.setDataType(1);
        	kdtEntrys_seedLevel2_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_seedLevel2_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_seedLevel2_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_seedLevel2_CellEditor = new KDTDefaultCellEditor(kdtEntrys_seedLevel2_TextField);
        this.kdtEntrys.getColumn("seedLevel2").setEditor(kdtEntrys_seedLevel2_CellEditor);
        KDFormattedTextField kdtEntrys_seedLevel3_TextField = new KDFormattedTextField();
        kdtEntrys_seedLevel3_TextField.setName("kdtEntrys_seedLevel3_TextField");
        kdtEntrys_seedLevel3_TextField.setVisible(true);
        kdtEntrys_seedLevel3_TextField.setEditable(true);
        kdtEntrys_seedLevel3_TextField.setHorizontalAlignment(2);
        kdtEntrys_seedLevel3_TextField.setDataType(1);
        	kdtEntrys_seedLevel3_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_seedLevel3_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_seedLevel3_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_seedLevel3_CellEditor = new KDTDefaultCellEditor(kdtEntrys_seedLevel3_TextField);
        this.kdtEntrys.getColumn("seedLevel3").setEditor(kdtEntrys_seedLevel3_CellEditor);
        KDFormattedTextField kdtEntrys_seedLevelNo_TextField = new KDFormattedTextField();
        kdtEntrys_seedLevelNo_TextField.setName("kdtEntrys_seedLevelNo_TextField");
        kdtEntrys_seedLevelNo_TextField.setVisible(true);
        kdtEntrys_seedLevelNo_TextField.setEditable(true);
        kdtEntrys_seedLevelNo_TextField.setHorizontalAlignment(2);
        kdtEntrys_seedLevelNo_TextField.setDataType(1);
        	kdtEntrys_seedLevelNo_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_seedLevelNo_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_seedLevelNo_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_seedLevelNo_CellEditor = new KDTDefaultCellEditor(kdtEntrys_seedLevelNo_TextField);
        this.kdtEntrys.getColumn("seedLevelNo").setEditor(kdtEntrys_seedLevelNo_CellEditor);
        KDFormattedTextField kdtEntrys_seedLevelDead_TextField = new KDFormattedTextField();
        kdtEntrys_seedLevelDead_TextField.setName("kdtEntrys_seedLevelDead_TextField");
        kdtEntrys_seedLevelDead_TextField.setVisible(true);
        kdtEntrys_seedLevelDead_TextField.setEditable(true);
        kdtEntrys_seedLevelDead_TextField.setHorizontalAlignment(2);
        kdtEntrys_seedLevelDead_TextField.setDataType(1);
        	kdtEntrys_seedLevelDead_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_seedLevelDead_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_seedLevelDead_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_seedLevelDead_CellEditor = new KDTDefaultCellEditor(kdtEntrys_seedLevelDead_TextField);
        this.kdtEntrys.getColumn("seedLevelDead").setEditor(kdtEntrys_seedLevelDead_CellEditor);
        KDFormattedTextField kdtEntrys_seedDuck_TextField = new KDFormattedTextField();
        kdtEntrys_seedDuck_TextField.setName("kdtEntrys_seedDuck_TextField");
        kdtEntrys_seedDuck_TextField.setVisible(true);
        kdtEntrys_seedDuck_TextField.setEditable(true);
        kdtEntrys_seedDuck_TextField.setHorizontalAlignment(2);
        kdtEntrys_seedDuck_TextField.setDataType(1);
        	kdtEntrys_seedDuck_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_seedDuck_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_seedDuck_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_seedDuck_CellEditor = new KDTDefaultCellEditor(kdtEntrys_seedDuck_TextField);
        this.kdtEntrys.getColumn("seedDuck").setEditor(kdtEntrys_seedDuck_CellEditor);
        KDFormattedTextField kdtEntrys_seedInventorytotal_TextField = new KDFormattedTextField();
        kdtEntrys_seedInventorytotal_TextField.setName("kdtEntrys_seedInventorytotal_TextField");
        kdtEntrys_seedInventorytotal_TextField.setVisible(true);
        kdtEntrys_seedInventorytotal_TextField.setEditable(true);
        kdtEntrys_seedInventorytotal_TextField.setHorizontalAlignment(2);
        kdtEntrys_seedInventorytotal_TextField.setDataType(1);
        	kdtEntrys_seedInventorytotal_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_seedInventorytotal_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_seedInventorytotal_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_seedInventorytotal_CellEditor = new KDTDefaultCellEditor(kdtEntrys_seedInventorytotal_TextField);
        this.kdtEntrys.getColumn("seedInventorytotal").setEditor(kdtEntrys_seedInventorytotal_CellEditor);
        KDFormattedTextField kdtEntrys_hatchLevel1_TextField = new KDFormattedTextField();
        kdtEntrys_hatchLevel1_TextField.setName("kdtEntrys_hatchLevel1_TextField");
        kdtEntrys_hatchLevel1_TextField.setVisible(true);
        kdtEntrys_hatchLevel1_TextField.setEditable(true);
        kdtEntrys_hatchLevel1_TextField.setHorizontalAlignment(2);
        kdtEntrys_hatchLevel1_TextField.setDataType(1);
        	kdtEntrys_hatchLevel1_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_hatchLevel1_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_hatchLevel1_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_hatchLevel1_CellEditor = new KDTDefaultCellEditor(kdtEntrys_hatchLevel1_TextField);
        this.kdtEntrys.getColumn("hatchLevel1").setEditor(kdtEntrys_hatchLevel1_CellEditor);
        KDFormattedTextField kdtEntrys_hatchLevelB2_TextField = new KDFormattedTextField();
        kdtEntrys_hatchLevelB2_TextField.setName("kdtEntrys_hatchLevelB2_TextField");
        kdtEntrys_hatchLevelB2_TextField.setVisible(true);
        kdtEntrys_hatchLevelB2_TextField.setEditable(true);
        kdtEntrys_hatchLevelB2_TextField.setHorizontalAlignment(2);
        kdtEntrys_hatchLevelB2_TextField.setDataType(1);
        	kdtEntrys_hatchLevelB2_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_hatchLevelB2_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_hatchLevelB2_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_hatchLevelB2_CellEditor = new KDTDefaultCellEditor(kdtEntrys_hatchLevelB2_TextField);
        this.kdtEntrys.getColumn("hatchLevelB2").setEditor(kdtEntrys_hatchLevelB2_CellEditor);
        KDFormattedTextField kdtEntrys_hatchLevel2_TextField = new KDFormattedTextField();
        kdtEntrys_hatchLevel2_TextField.setName("kdtEntrys_hatchLevel2_TextField");
        kdtEntrys_hatchLevel2_TextField.setVisible(true);
        kdtEntrys_hatchLevel2_TextField.setEditable(true);
        kdtEntrys_hatchLevel2_TextField.setHorizontalAlignment(2);
        kdtEntrys_hatchLevel2_TextField.setDataType(1);
        	kdtEntrys_hatchLevel2_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_hatchLevel2_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_hatchLevel2_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_hatchLevel2_CellEditor = new KDTDefaultCellEditor(kdtEntrys_hatchLevel2_TextField);
        this.kdtEntrys.getColumn("hatchLevel2").setEditor(kdtEntrys_hatchLevel2_CellEditor);
        KDTextField kdtEntrys_remarks_TextField = new KDTextField();
        kdtEntrys_remarks_TextField.setName("kdtEntrys_remarks_TextField");
        kdtEntrys_remarks_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_remarks_CellEditor = new KDTDefaultCellEditor(kdtEntrys_remarks_TextField);
        this.kdtEntrys.getColumn("remarks").setEditor(kdtEntrys_remarks_CellEditor);
        // contnumber		
        this.contnumber.setBoundLabelText(resHelper.getString("contnumber.boundLabelText"));		
        this.contnumber.setBoundLabelLength(100);		
        this.contnumber.setBoundLabelUnderline(true);		
        this.contnumber.setVisible(true);
        // contbizDate		
        this.contbizDate.setBoundLabelText(resHelper.getString("contbizDate.boundLabelText"));		
        this.contbizDate.setBoundLabelLength(100);		
        this.contbizDate.setBoundLabelUnderline(true);		
        this.contbizDate.setVisible(true);
        // contdescription		
        this.contdescription.setBoundLabelText(resHelper.getString("contdescription.boundLabelText"));		
        this.contdescription.setBoundLabelLength(100);		
        this.contdescription.setBoundLabelUnderline(true);		
        this.contdescription.setVisible(true);
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
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // txtnumber		
        this.txtnumber.setVisible(true);		
        this.txtnumber.setHorizontalAlignment(2);		
        this.txtnumber.setMaxLength(80);		
        this.txtnumber.setRequired(false);
        // pkbizDate		
        this.pkbizDate.setVisible(true);		
        this.pkbizDate.setRequired(false);
        // txtdescription		
        this.txtdescription.setVisible(true);		
        this.txtdescription.setHorizontalAlignment(2);		
        this.txtdescription.setMaxLength(80);		
        this.txtdescription.setRequired(false);
        // billStatus		
        this.billStatus.setVisible(true);		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.ncm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,kdtEntrys,billStatus}));
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
        contCreator.setBounds(new Rectangle(437, 539, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(437, 539, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(727, 539, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(727, 539, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(437, 570, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(437, 570, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(727, 570, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(727, 570, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(53, 539, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(53, 539, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(57, 102, 952, 413));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.stocking.processbizill.QeggAndDuckSeedEarlyEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(57, 102, 952, 413, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("progeny","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contnumber.setBounds(new Rectangle(63, 22, 270, 19));
        this.add(contnumber, new KDLayout.Constraints(63, 22, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbizDate.setBounds(new Rectangle(376, 22, 270, 19));
        this.add(contbizDate, new KDLayout.Constraints(376, 22, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdescription.setBounds(new Rectangle(690, 22, 270, 19));
        this.add(contdescription, new KDLayout.Constraints(690, 22, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbillStatus.setBounds(new Rectangle(690, 58, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(690, 58, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contCreator
        contCreator.setBoundEditor(prmtCreator);
        //contCreateTime
        contCreateTime.setBoundEditor(kDDateCreateTime);
        //contLastUpdateUser
        contLastUpdateUser.setBoundEditor(prmtLastUpdateUser);
        //contLastUpdateTime
        contLastUpdateTime.setBoundEditor(kDDateLastUpdateTime);
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contnumber
        contnumber.setBoundEditor(txtnumber);
        //contbizDate
        contbizDate.setBoundEditor(pkbizDate);
        //contdescription
        contdescription.setBoundEditor(txtdescription);
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
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.stocking.processbizill.QeggAndDuckSeedEarlyEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.hactchArea", java.lang.Object.class, this.kdtEntrys, "hactchArea.text");
		dataBinder.registerBinding("entrys.qEggLevel1", java.math.BigDecimal.class, this.kdtEntrys, "qEggLevel1.text");
		dataBinder.registerBinding("entrys.qEggLevelB2", java.math.BigDecimal.class, this.kdtEntrys, "qEggLevelB2.text");
		dataBinder.registerBinding("entrys.qEggLevel2", java.math.BigDecimal.class, this.kdtEntrys, "qEggLevel2.text");
		dataBinder.registerBinding("entrys.seedLevel1", java.math.BigDecimal.class, this.kdtEntrys, "seedLevel1.text");
		dataBinder.registerBinding("entrys.seedLevelSmall", java.math.BigDecimal.class, this.kdtEntrys, "seedLevelSmall.text");
		dataBinder.registerBinding("entrys.seedLevel2", java.math.BigDecimal.class, this.kdtEntrys, "seedLevel2.text");
		dataBinder.registerBinding("entrys.seedLevel3", java.math.BigDecimal.class, this.kdtEntrys, "seedLevel3.text");
		dataBinder.registerBinding("entrys.seedLevelNo", java.math.BigDecimal.class, this.kdtEntrys, "seedLevelNo.text");
		dataBinder.registerBinding("entrys.seedLevelDead", java.math.BigDecimal.class, this.kdtEntrys, "seedLevelDead.text");
		dataBinder.registerBinding("entrys.hatchLevel1", java.math.BigDecimal.class, this.kdtEntrys, "hatchLevel1.text");
		dataBinder.registerBinding("entrys.hatchLevelB2", java.math.BigDecimal.class, this.kdtEntrys, "hatchLevelB2.text");
		dataBinder.registerBinding("entrys.hatchLevel2", java.math.BigDecimal.class, this.kdtEntrys, "hatchLevel2.text");
		dataBinder.registerBinding("entrys.remarks", String.class, this.kdtEntrys, "remarks.text");
		dataBinder.registerBinding("entrys.progeny", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "progeny.text");
		dataBinder.registerBinding("entrys.seedInventorytotal", java.math.BigDecimal.class, this.kdtEntrys, "seedInventorytotal.text");
		dataBinder.registerBinding("entrys.seedDuck", java.math.BigDecimal.class, this.kdtEntrys, "seedDuck.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("number", String.class, this.txtnumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkbizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtdescription, "text");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.ncm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.stocking.processbizill.app.QeggAndDuckSeedEarlyEditUIHandler";
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
        this.kDDateLastUpdateTime.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.stocking.processbizill.QeggAndDuckSeedEarlyInfo)ov;
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
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
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.hactchArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qEggLevel1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qEggLevelB2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qEggLevel2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.seedLevel1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.seedLevelSmall", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.seedLevel2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.seedLevel3", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.seedLevelNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.seedLevelDead", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.hatchLevel1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.hatchLevelB2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.hatchLevel2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remarks", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.progeny", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.seedInventorytotal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.seedDuck", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
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
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.hactchArea.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.hactchArea.id"));
			sic.add(new SelectorItemInfo("entrys.hactchArea.name"));
        	sic.add(new SelectorItemInfo("entrys.hactchArea.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.qEggLevel1"));
    	sic.add(new SelectorItemInfo("entrys.qEggLevelB2"));
    	sic.add(new SelectorItemInfo("entrys.qEggLevel2"));
    	sic.add(new SelectorItemInfo("entrys.seedLevel1"));
    	sic.add(new SelectorItemInfo("entrys.seedLevelSmall"));
    	sic.add(new SelectorItemInfo("entrys.seedLevel2"));
    	sic.add(new SelectorItemInfo("entrys.seedLevel3"));
    	sic.add(new SelectorItemInfo("entrys.seedLevelNo"));
    	sic.add(new SelectorItemInfo("entrys.seedLevelDead"));
    	sic.add(new SelectorItemInfo("entrys.hatchLevel1"));
    	sic.add(new SelectorItemInfo("entrys.hatchLevelB2"));
    	sic.add(new SelectorItemInfo("entrys.hatchLevel2"));
    	sic.add(new SelectorItemInfo("entrys.remarks"));
    	sic.add(new SelectorItemInfo("entrys.progeny"));
    	sic.add(new SelectorItemInfo("entrys.seedInventorytotal"));
    	sic.add(new SelectorItemInfo("entrys.seedDuck"));
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("auditor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("auditor.id"));
        	sic.add(new SelectorItemInfo("auditor.number"));
        	sic.add(new SelectorItemInfo("auditor.name"));
		}
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("description"));
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
        com.kingdee.eas.farm.stocking.processbizill.QeggAndDuckSeedEarlyFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.processbizill.QeggAndDuckSeedEarlyFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractQeggAndDuckSeedEarlyEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractQeggAndDuckSeedEarlyEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.processbizill.client", "QeggAndDuckSeedEarlyEditUI");
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
        return com.kingdee.eas.farm.stocking.processbizill.client.QeggAndDuckSeedEarlyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.processbizill.QeggAndDuckSeedEarlyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.processbizill.QeggAndDuckSeedEarlyInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.QeggAndDuckSeedEarlyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/stocking/processbizill/QeggAndDuckSeedEarly";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.stocking.processbizill.app.QeggAndDuckSeedEarlyQuery");
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
		vo.put("billStatus",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}