/**
 * output package name
 */
package com.kingdee.eas.farm.pig.breedingboar.client;

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
public abstract class AbstractSpermCheckBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSpermCheckBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcheckPerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwarehouseOperator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwarehouse;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcheckPerson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtwarehouseOperator;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtwarehouse;
    protected com.kingdee.eas.farm.pig.breedingboar.SpermCheckBillInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractSpermCheckBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSpermCheckBillEditUI.class.getName());
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
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcheckPerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contwarehouseOperator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contwarehouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcheckPerson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtwarehouseOperator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtwarehouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.kdtEntrys.setName("kdtEntrys");
        this.contauditTime.setName("contauditTime");
        this.contfarm.setName("contfarm");
        this.contbaseStatus.setName("contbaseStatus");
        this.contcheckPerson.setName("contcheckPerson");
        this.contwarehouseOperator.setName("contwarehouseOperator");
        this.contwarehouse.setName("contwarehouse");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.pkauditTime.setName("pkauditTime");
        this.prmtfarm.setName("prmtfarm");
        this.baseStatus.setName("baseStatus");
        this.prmtcheckPerson.setName("prmtcheckPerson");
        this.prmtwarehouseOperator.setName("prmtwarehouseOperator");
        this.prmtwarehouse.setName("prmtwarehouse");
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
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;time</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"boar\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"earGap\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"earTag\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"boarName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"collectTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"labelNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"batchNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"sampleQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"dilutionMaterial\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"dilutionTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"dilutionQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"inQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"inMaterial\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{boar}</t:Cell><t:Cell>$Resource{earGap}</t:Cell><t:Cell>$Resource{earTag}</t:Cell><t:Cell>$Resource{boarName}</t:Cell><t:Cell>$Resource{collectTime}</t:Cell><t:Cell>$Resource{labelNumber}</t:Cell><t:Cell>$Resource{batchNumber}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{sampleQty}</t:Cell><t:Cell>$Resource{dilutionMaterial}</t:Cell><t:Cell>$Resource{dilutionTime}</t:Cell><t:Cell>$Resource{dilutionQty}</t:Cell><t:Cell>$Resource{inQty}</t:Cell><t:Cell>$Resource{inMaterial}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","boar","earGap","earTag","boarName","collectTime","labelNumber","batchNumber","qty","sampleQty","dilutionMaterial","dilutionTime","dilutionQty","inQty","inMaterial"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_boar_PromptBox = new KDBizPromptBox();
        kdtEntrys_boar_PromptBox.setQueryInfo("com.kingdee.eas.farm.pig.breedingboar.app.BoarQuery");
        kdtEntrys_boar_PromptBox.setVisible(true);
        kdtEntrys_boar_PromptBox.setEditable(true);
        kdtEntrys_boar_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_boar_PromptBox.setEditFormat("$number$");
        kdtEntrys_boar_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_boar_CellEditor = new KDTDefaultCellEditor(kdtEntrys_boar_PromptBox);
        this.kdtEntrys.getColumn("boar").setEditor(kdtEntrys_boar_CellEditor);
        ObjectValueRender kdtEntrys_boar_OVR = new ObjectValueRender();
        kdtEntrys_boar_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("boar").setRenderer(kdtEntrys_boar_OVR);
        			kdtEntrys_boar_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.pig.breedingboar.client.BoarListUI kdtEntrys_boar_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_boar_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_boar_PromptBox_F7ListUI = new com.kingdee.eas.farm.pig.breedingboar.client.BoarListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_boar_PromptBox_F7ListUI));
					kdtEntrys_boar_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_boar_PromptBox.setSelector(kdtEntrys_boar_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtEntrys_earGap_TextField = new KDTextField();
        kdtEntrys_earGap_TextField.setName("kdtEntrys_earGap_TextField");
        kdtEntrys_earGap_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_earGap_CellEditor = new KDTDefaultCellEditor(kdtEntrys_earGap_TextField);
        this.kdtEntrys.getColumn("earGap").setEditor(kdtEntrys_earGap_CellEditor);
        KDTextField kdtEntrys_earTag_TextField = new KDTextField();
        kdtEntrys_earTag_TextField.setName("kdtEntrys_earTag_TextField");
        kdtEntrys_earTag_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_earTag_CellEditor = new KDTDefaultCellEditor(kdtEntrys_earTag_TextField);
        this.kdtEntrys.getColumn("earTag").setEditor(kdtEntrys_earTag_CellEditor);
        KDTextField kdtEntrys_boarName_TextField = new KDTextField();
        kdtEntrys_boarName_TextField.setName("kdtEntrys_boarName_TextField");
        kdtEntrys_boarName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_boarName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_boarName_TextField);
        this.kdtEntrys.getColumn("boarName").setEditor(kdtEntrys_boarName_CellEditor);
        KDDatePicker kdtEntrys_collectTime_DatePicker = new KDDatePicker();
        kdtEntrys_collectTime_DatePicker.setName("kdtEntrys_collectTime_DatePicker");
        kdtEntrys_collectTime_DatePicker.setVisible(true);
        kdtEntrys_collectTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_collectTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_collectTime_DatePicker);
        this.kdtEntrys.getColumn("collectTime").setEditor(kdtEntrys_collectTime_CellEditor);
        KDTextField kdtEntrys_labelNumber_TextField = new KDTextField();
        kdtEntrys_labelNumber_TextField.setName("kdtEntrys_labelNumber_TextField");
        kdtEntrys_labelNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_labelNumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_labelNumber_TextField);
        this.kdtEntrys.getColumn("labelNumber").setEditor(kdtEntrys_labelNumber_CellEditor);
        KDTextField kdtEntrys_batchNumber_TextField = new KDTextField();
        kdtEntrys_batchNumber_TextField.setName("kdtEntrys_batchNumber_TextField");
        kdtEntrys_batchNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_batchNumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_batchNumber_TextField);
        this.kdtEntrys.getColumn("batchNumber").setEditor(kdtEntrys_batchNumber_CellEditor);
        KDFormattedTextField kdtEntrys_qty_TextField = new KDFormattedTextField();
        kdtEntrys_qty_TextField.setName("kdtEntrys_qty_TextField");
        kdtEntrys_qty_TextField.setVisible(true);
        kdtEntrys_qty_TextField.setEditable(true);
        kdtEntrys_qty_TextField.setHorizontalAlignment(2);
        kdtEntrys_qty_TextField.setDataType(1);
        	kdtEntrys_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_qty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_qty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qty_TextField);
        this.kdtEntrys.getColumn("qty").setEditor(kdtEntrys_qty_CellEditor);
        KDFormattedTextField kdtEntrys_sampleQty_TextField = new KDFormattedTextField();
        kdtEntrys_sampleQty_TextField.setName("kdtEntrys_sampleQty_TextField");
        kdtEntrys_sampleQty_TextField.setVisible(true);
        kdtEntrys_sampleQty_TextField.setEditable(true);
        kdtEntrys_sampleQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_sampleQty_TextField.setDataType(1);
        	kdtEntrys_sampleQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_sampleQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_sampleQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_sampleQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sampleQty_TextField);
        this.kdtEntrys.getColumn("sampleQty").setEditor(kdtEntrys_sampleQty_CellEditor);
        final KDBizPromptBox kdtEntrys_dilutionMaterial_PromptBox = new KDBizPromptBox();
        kdtEntrys_dilutionMaterial_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntrys_dilutionMaterial_PromptBox.setVisible(true);
        kdtEntrys_dilutionMaterial_PromptBox.setEditable(true);
        kdtEntrys_dilutionMaterial_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_dilutionMaterial_PromptBox.setEditFormat("$number$");
        kdtEntrys_dilutionMaterial_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_dilutionMaterial_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dilutionMaterial_PromptBox);
        this.kdtEntrys.getColumn("dilutionMaterial").setEditor(kdtEntrys_dilutionMaterial_CellEditor);
        ObjectValueRender kdtEntrys_dilutionMaterial_OVR = new ObjectValueRender();
        kdtEntrys_dilutionMaterial_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("dilutionMaterial").setRenderer(kdtEntrys_dilutionMaterial_OVR);
        KDTimePicker kdtEntrys_dilutionTime_TimePicker = new KDTimePicker();
        kdtEntrys_dilutionTime_TimePicker.setName("kdtEntrys_dilutionTime_TimePicker");
        kdtEntrys_dilutionTime_TimePicker.setVisible(true);
        KDTDefaultCellEditor kdtEntrys_dilutionTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dilutionTime_TimePicker);
        this.kdtEntrys.getColumn("dilutionTime").setEditor(kdtEntrys_dilutionTime_CellEditor);
        KDFormattedTextField kdtEntrys_dilutionQty_TextField = new KDFormattedTextField();
        kdtEntrys_dilutionQty_TextField.setName("kdtEntrys_dilutionQty_TextField");
        kdtEntrys_dilutionQty_TextField.setVisible(true);
        kdtEntrys_dilutionQty_TextField.setEditable(true);
        kdtEntrys_dilutionQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_dilutionQty_TextField.setDataType(1);
        	kdtEntrys_dilutionQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_dilutionQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_dilutionQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_dilutionQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dilutionQty_TextField);
        this.kdtEntrys.getColumn("dilutionQty").setEditor(kdtEntrys_dilutionQty_CellEditor);
        KDFormattedTextField kdtEntrys_inQty_TextField = new KDFormattedTextField();
        kdtEntrys_inQty_TextField.setName("kdtEntrys_inQty_TextField");
        kdtEntrys_inQty_TextField.setVisible(true);
        kdtEntrys_inQty_TextField.setEditable(true);
        kdtEntrys_inQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_inQty_TextField.setDataType(1);
        	kdtEntrys_inQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_inQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_inQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_inQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_inQty_TextField);
        this.kdtEntrys.getColumn("inQty").setEditor(kdtEntrys_inQty_CellEditor);
        final KDBizPromptBox kdtEntrys_inMaterial_PromptBox = new KDBizPromptBox();
        kdtEntrys_inMaterial_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntrys_inMaterial_PromptBox.setVisible(true);
        kdtEntrys_inMaterial_PromptBox.setEditable(true);
        kdtEntrys_inMaterial_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_inMaterial_PromptBox.setEditFormat("$number$");
        kdtEntrys_inMaterial_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_inMaterial_CellEditor = new KDTDefaultCellEditor(kdtEntrys_inMaterial_PromptBox);
        this.kdtEntrys.getColumn("inMaterial").setEditor(kdtEntrys_inMaterial_CellEditor);
        ObjectValueRender kdtEntrys_inMaterial_OVR = new ObjectValueRender();
        kdtEntrys_inMaterial_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("inMaterial").setRenderer(kdtEntrys_inMaterial_OVR);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // contcheckPerson		
        this.contcheckPerson.setBoundLabelText(resHelper.getString("contcheckPerson.boundLabelText"));		
        this.contcheckPerson.setBoundLabelLength(100);		
        this.contcheckPerson.setBoundLabelUnderline(true);		
        this.contcheckPerson.setVisible(true);
        // contwarehouseOperator		
        this.contwarehouseOperator.setBoundLabelText(resHelper.getString("contwarehouseOperator.boundLabelText"));		
        this.contwarehouseOperator.setBoundLabelLength(100);		
        this.contwarehouseOperator.setBoundLabelUnderline(true);		
        this.contwarehouseOperator.setVisible(true);
        // contwarehouse		
        this.contwarehouse.setBoundLabelText(resHelper.getString("contwarehouse.boundLabelText"));		
        this.contwarehouse.setBoundLabelLength(100);		
        this.contwarehouse.setBoundLabelUnderline(true);		
        this.contwarehouse.setVisible(true);
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
        // pkauditTime		
        this.pkauditTime.setVisible(true);		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // prmtfarm		
        this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.pig.app.PigFarmQuery");		
        this.prmtfarm.setVisible(true);		
        this.prmtfarm.setEditable(true);		
        this.prmtfarm.setDisplayFormat("$name$");		
        this.prmtfarm.setEditFormat("$number$");		
        this.prmtfarm.setCommitFormat("$number$");		
        this.prmtfarm.setRequired(false);
        		prmtfarm.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.pig.client.PigFarmListUI prmtfarm_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarm_F7ListUI == null) {
					try {
						prmtfarm_F7ListUI = new com.kingdee.eas.farm.pig.client.PigFarmListUI();
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
					
        // baseStatus		
        this.baseStatus.setVisible(true);		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);
        // prmtcheckPerson		
        this.prmtcheckPerson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtcheckPerson.setVisible(true);		
        this.prmtcheckPerson.setEditable(true);		
        this.prmtcheckPerson.setDisplayFormat("$name$");		
        this.prmtcheckPerson.setEditFormat("$number$");		
        this.prmtcheckPerson.setCommitFormat("$number$");		
        this.prmtcheckPerson.setRequired(false);
        // prmtwarehouseOperator		
        this.prmtwarehouseOperator.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtwarehouseOperator.setVisible(true);		
        this.prmtwarehouseOperator.setEditable(true);		
        this.prmtwarehouseOperator.setDisplayFormat("$name$");		
        this.prmtwarehouseOperator.setEditFormat("$number$");		
        this.prmtwarehouseOperator.setCommitFormat("$number$");		
        this.prmtwarehouseOperator.setRequired(false);
        // prmtwarehouse		
        this.prmtwarehouse.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.WarehouseQuery");		
        this.prmtwarehouse.setVisible(true);		
        this.prmtwarehouse.setEditable(true);		
        this.prmtwarehouse.setDisplayFormat("$name$");		
        this.prmtwarehouse.setEditFormat("$number$");		
        this.prmtwarehouse.setCommitFormat("$number$");		
        this.prmtwarehouse.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {pkauditTime,prmtfarm,baseStatus,prmtcheckPerson,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,kdtEntrys,prmtwarehouseOperator,prmtwarehouse}));
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
        this.setLayout(null);
        contCreator.setBounds(new Rectangle(372, 570, 270, 19));
        this.add(contCreator, null);
        contCreateTime.setBounds(new Rectangle(372, 596, 270, 19));
        this.add(contCreateTime, null);
        contLastUpdateUser.setBounds(new Rectangle(728, 570, 270, 19));
        this.add(contLastUpdateUser, null);
        contLastUpdateTime.setBounds(new Rectangle(728, 596, 270, 19));
        this.add(contLastUpdateTime, null);
        contNumber.setBounds(new Rectangle(23, 17, 270, 19));
        this.add(contNumber, null);
        contBizDate.setBounds(new Rectangle(364, 43, 270, 19));
        this.add(contBizDate, null);
        contDescription.setBounds(new Rectangle(727, 45, 270, 19));
        this.add(contDescription, null);
        contAuditor.setBounds(new Rectangle(17, 570, 270, 19));
        this.add(contAuditor, null);
        kdtEntrys.setBounds(new Rectangle(12, 103, 991, 458));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.pig.breedingboar.SpermCheckBillEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, null);
        contauditTime.setBounds(new Rectangle(17, 596, 270, 19));
        this.add(contauditTime, null);
        contfarm.setBounds(new Rectangle(364, 17, 270, 19));
        this.add(contfarm, null);
        contbaseStatus.setBounds(new Rectangle(727, 18, 270, 19));
        this.add(contbaseStatus, null);
        contcheckPerson.setBounds(new Rectangle(23, 43, 270, 19));
        this.add(contcheckPerson, null);
        contwarehouseOperator.setBounds(new Rectangle(23, 71, 270, 19));
        this.add(contwarehouseOperator, null);
        contwarehouse.setBounds(new Rectangle(365, 71, 270, 19));
        this.add(contwarehouse, null);
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
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contcheckPerson
        contcheckPerson.setBoundEditor(prmtcheckPerson);
        //contwarehouseOperator
        contwarehouseOperator.setBoundEditor(prmtwarehouseOperator);
        //contwarehouse
        contwarehouse.setBoundEditor(prmtwarehouse);

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
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.pig.breedingboar.SpermCheckBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.boar", java.lang.Object.class, this.kdtEntrys, "boar.text");
		dataBinder.registerBinding("entrys.earGap", String.class, this.kdtEntrys, "earGap.text");
		dataBinder.registerBinding("entrys.earTag", String.class, this.kdtEntrys, "earTag.text");
		dataBinder.registerBinding("entrys.boarName", String.class, this.kdtEntrys, "boarName.text");
		dataBinder.registerBinding("entrys.collectTime", java.util.Date.class, this.kdtEntrys, "collectTime.text");
		dataBinder.registerBinding("entrys.labelNumber", String.class, this.kdtEntrys, "labelNumber.text");
		dataBinder.registerBinding("entrys.batchNumber", String.class, this.kdtEntrys, "batchNumber.text");
		dataBinder.registerBinding("entrys.qty", java.math.BigDecimal.class, this.kdtEntrys, "qty.text");
		dataBinder.registerBinding("entrys.sampleQty", java.math.BigDecimal.class, this.kdtEntrys, "sampleQty.text");
		dataBinder.registerBinding("entrys.dilutionMaterial", java.lang.Object.class, this.kdtEntrys, "dilutionMaterial.text");
		dataBinder.registerBinding("entrys.dilutionTime", java.sql.Time.class, this.kdtEntrys, "dilutionTime.text");
		dataBinder.registerBinding("entrys.dilutionQty", java.math.BigDecimal.class, this.kdtEntrys, "dilutionQty.text");
		dataBinder.registerBinding("entrys.inQty", java.math.BigDecimal.class, this.kdtEntrys, "inQty.text");
		dataBinder.registerBinding("entrys.inMaterial", java.lang.Object.class, this.kdtEntrys, "inMaterial.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.pig.PigFarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("checkPerson", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtcheckPerson, "data");
		dataBinder.registerBinding("warehouseOperator", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtwarehouseOperator, "data");
		dataBinder.registerBinding("warehouse", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.prmtwarehouse, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.pig.breedingboar.app.SpermCheckBillEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.pig.breedingboar.SpermCheckBillInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.boar", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.earGap", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.earTag", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.boarName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.collectTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.labelNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.batchNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sampleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dilutionMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dilutionTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dilutionQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.inQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.inMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("checkPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("warehouseOperator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("warehouse", ValidateHelper.ON_SAVE);    		
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
            if ("boar".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"earGap").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"boar").getValue(),"earGap")));

}

    if ("boar".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"earTag").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"boar").getValue(),"earTag")));

}

    if ("boar".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"boarName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"boar").getValue(),"name")));

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
			sic.add(new SelectorItemInfo("entrys.boar.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.boar.id"));
			sic.add(new SelectorItemInfo("entrys.boar.number"));
			sic.add(new SelectorItemInfo("entrys.boar.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.earGap"));
    	sic.add(new SelectorItemInfo("entrys.earTag"));
    	sic.add(new SelectorItemInfo("entrys.boarName"));
    	sic.add(new SelectorItemInfo("entrys.collectTime"));
    	sic.add(new SelectorItemInfo("entrys.labelNumber"));
    	sic.add(new SelectorItemInfo("entrys.batchNumber"));
    	sic.add(new SelectorItemInfo("entrys.qty"));
    	sic.add(new SelectorItemInfo("entrys.sampleQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.dilutionMaterial.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.dilutionMaterial.id"));
			sic.add(new SelectorItemInfo("entrys.dilutionMaterial.name"));
        	sic.add(new SelectorItemInfo("entrys.dilutionMaterial.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.dilutionTime"));
    	sic.add(new SelectorItemInfo("entrys.dilutionQty"));
    	sic.add(new SelectorItemInfo("entrys.inQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.inMaterial.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.inMaterial.id"));
			sic.add(new SelectorItemInfo("entrys.inMaterial.name"));
        	sic.add(new SelectorItemInfo("entrys.inMaterial.number"));
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farm.id"));
        	sic.add(new SelectorItemInfo("farm.number"));
        	sic.add(new SelectorItemInfo("farm.name"));
		}
        sic.add(new SelectorItemInfo("baseStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("checkPerson.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("checkPerson.id"));
        	sic.add(new SelectorItemInfo("checkPerson.number"));
        	sic.add(new SelectorItemInfo("checkPerson.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("warehouseOperator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("warehouseOperator.id"));
        	sic.add(new SelectorItemInfo("warehouseOperator.number"));
        	sic.add(new SelectorItemInfo("warehouseOperator.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("warehouse.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("warehouse.id"));
        	sic.add(new SelectorItemInfo("warehouse.number"));
        	sic.add(new SelectorItemInfo("warehouse.name"));
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
        return new MetaDataPK("com.kingdee.eas.farm.pig.breedingboar.client", "SpermCheckBillEditUI");
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
        return com.kingdee.eas.farm.pig.breedingboar.client.SpermCheckBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.pig.breedingboar.SpermCheckBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.pig.breedingboar.SpermCheckBillInfo objectValue = new com.kingdee.eas.farm.pig.breedingboar.SpermCheckBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/pig/breedingboar/SpermCheckBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.pig.breedingboar.app.SpermCheckBillQuery");
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