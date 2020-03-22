/**
 * output package name
 */
package com.kingdee.eas.custom.stockprice.client;

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
public abstract class AbstractRealTimeInventoryEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractRealTimeInventoryEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstoOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstoOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditDate;
    protected com.kingdee.eas.custom.stockprice.RealTimeInventoryInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractRealTimeInventoryEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractRealTimeInventoryEditUI.class.getName());
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
        this.contstoOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtstoOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.kdtEntrys.setName("kdtEntrys");
        this.contstoOrgUnit.setName("contstoOrgUnit");
        this.contauditDate.setName("contauditDate");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtstoOrgUnit.setName("prmtstoOrgUnit");
        this.pkauditDate.setName("pkauditDate");
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
        this.contCreateTime.setForeground(new java.awt.Color(0,0,0));
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
        this.contLastUpdateTime.setForeground(new java.awt.Color(0,0,0));
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
        this.contDescription.setVisible(false);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"materialNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"flot\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"productionDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"exp\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"availableQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"baseUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"baseQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"availableBaseQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"assistUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"assistQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"availableAssistQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"assistProperty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"wareHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"location\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"storeType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"storeState\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"project\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"trackNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"customer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"supplier\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"storageOrgUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"reservedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"reservedBaseQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"reservedAvaliableQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{materialNum}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{flot}</t:Cell><t:Cell>$Resource{productionDate}</t:Cell><t:Cell>$Resource{exp}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{availableQty}</t:Cell><t:Cell>$Resource{baseUnit}</t:Cell><t:Cell>$Resource{baseQty}</t:Cell><t:Cell>$Resource{availableBaseQty}</t:Cell><t:Cell>$Resource{assistUnit}</t:Cell><t:Cell>$Resource{assistQty}</t:Cell><t:Cell>$Resource{availableAssistQty}</t:Cell><t:Cell>$Resource{assistProperty}</t:Cell><t:Cell>$Resource{wareHouse}</t:Cell><t:Cell>$Resource{location}</t:Cell><t:Cell>$Resource{storeType}</t:Cell><t:Cell>$Resource{storeState}</t:Cell><t:Cell>$Resource{project}</t:Cell><t:Cell>$Resource{trackNumber}</t:Cell><t:Cell>$Resource{customer}</t:Cell><t:Cell>$Resource{supplier}</t:Cell><t:Cell>$Resource{storageOrgUnit}</t:Cell><t:Cell>$Resource{reservedQty}</t:Cell><t:Cell>$Resource{reservedBaseQty}</t:Cell><t:Cell>$Resource{reservedAvaliableQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","materialNum","material","model","flot","productionDate","exp","unit","amount","availableQty","baseUnit","baseQty","availableBaseQty","assistUnit","assistQty","availableAssistQty","assistProperty","wareHouse","location","storeType","storeState","project","trackNumber","customer","supplier","storageOrgUnit","reservedQty","reservedBaseQty","reservedAvaliableQty"});


        this.kdtEntrys.checkParsed();
        KDTextField kdtEntrys_materialNum_TextField = new KDTextField();
        kdtEntrys_materialNum_TextField.setName("kdtEntrys_materialNum_TextField");
        kdtEntrys_materialNum_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_materialNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_materialNum_TextField);
        this.kdtEntrys.getColumn("materialNum").setEditor(kdtEntrys_materialNum_CellEditor);
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
        KDTextField kdtEntrys_model_TextField = new KDTextField();
        kdtEntrys_model_TextField.setName("kdtEntrys_model_TextField");
        kdtEntrys_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_model_CellEditor = new KDTDefaultCellEditor(kdtEntrys_model_TextField);
        this.kdtEntrys.getColumn("model").setEditor(kdtEntrys_model_CellEditor);
        KDTextField kdtEntrys_flot_TextField = new KDTextField();
        kdtEntrys_flot_TextField.setName("kdtEntrys_flot_TextField");
        kdtEntrys_flot_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_flot_CellEditor = new KDTDefaultCellEditor(kdtEntrys_flot_TextField);
        this.kdtEntrys.getColumn("flot").setEditor(kdtEntrys_flot_CellEditor);
        KDDatePicker kdtEntrys_productionDate_DatePicker = new KDDatePicker();
        kdtEntrys_productionDate_DatePicker.setName("kdtEntrys_productionDate_DatePicker");
        kdtEntrys_productionDate_DatePicker.setVisible(true);
        kdtEntrys_productionDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_productionDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_productionDate_DatePicker);
        this.kdtEntrys.getColumn("productionDate").setEditor(kdtEntrys_productionDate_CellEditor);
        KDDatePicker kdtEntrys_exp_DatePicker = new KDDatePicker();
        kdtEntrys_exp_DatePicker.setName("kdtEntrys_exp_DatePicker");
        kdtEntrys_exp_DatePicker.setVisible(true);
        kdtEntrys_exp_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_exp_CellEditor = new KDTDefaultCellEditor(kdtEntrys_exp_DatePicker);
        this.kdtEntrys.getColumn("exp").setEditor(kdtEntrys_exp_CellEditor);
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
        KDFormattedTextField kdtEntrys_availableQty_TextField = new KDFormattedTextField();
        kdtEntrys_availableQty_TextField.setName("kdtEntrys_availableQty_TextField");
        kdtEntrys_availableQty_TextField.setVisible(true);
        kdtEntrys_availableQty_TextField.setEditable(true);
        kdtEntrys_availableQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_availableQty_TextField.setDataType(1);
        	kdtEntrys_availableQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_availableQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_availableQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_availableQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_availableQty_TextField);
        this.kdtEntrys.getColumn("availableQty").setEditor(kdtEntrys_availableQty_CellEditor);
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
        	kdtEntrys_baseQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_baseQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_baseQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_baseQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_baseQty_TextField);
        this.kdtEntrys.getColumn("baseQty").setEditor(kdtEntrys_baseQty_CellEditor);
        KDFormattedTextField kdtEntrys_availableBaseQty_TextField = new KDFormattedTextField();
        kdtEntrys_availableBaseQty_TextField.setName("kdtEntrys_availableBaseQty_TextField");
        kdtEntrys_availableBaseQty_TextField.setVisible(true);
        kdtEntrys_availableBaseQty_TextField.setEditable(true);
        kdtEntrys_availableBaseQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_availableBaseQty_TextField.setDataType(1);
        	kdtEntrys_availableBaseQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_availableBaseQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_availableBaseQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_availableBaseQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_availableBaseQty_TextField);
        this.kdtEntrys.getColumn("availableBaseQty").setEditor(kdtEntrys_availableBaseQty_CellEditor);
        final KDBizPromptBox kdtEntrys_assistUnit_PromptBox = new KDBizPromptBox();
        kdtEntrys_assistUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtEntrys_assistUnit_PromptBox.setVisible(true);
        kdtEntrys_assistUnit_PromptBox.setEditable(true);
        kdtEntrys_assistUnit_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_assistUnit_PromptBox.setEditFormat("$number$");
        kdtEntrys_assistUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_assistUnit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_assistUnit_PromptBox);
        this.kdtEntrys.getColumn("assistUnit").setEditor(kdtEntrys_assistUnit_CellEditor);
        ObjectValueRender kdtEntrys_assistUnit_OVR = new ObjectValueRender();
        kdtEntrys_assistUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("assistUnit").setRenderer(kdtEntrys_assistUnit_OVR);
        KDFormattedTextField kdtEntrys_assistQty_TextField = new KDFormattedTextField();
        kdtEntrys_assistQty_TextField.setName("kdtEntrys_assistQty_TextField");
        kdtEntrys_assistQty_TextField.setVisible(true);
        kdtEntrys_assistQty_TextField.setEditable(true);
        kdtEntrys_assistQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_assistQty_TextField.setDataType(1);
        	kdtEntrys_assistQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_assistQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_assistQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_assistQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_assistQty_TextField);
        this.kdtEntrys.getColumn("assistQty").setEditor(kdtEntrys_assistQty_CellEditor);
        KDFormattedTextField kdtEntrys_availableAssistQty_TextField = new KDFormattedTextField();
        kdtEntrys_availableAssistQty_TextField.setName("kdtEntrys_availableAssistQty_TextField");
        kdtEntrys_availableAssistQty_TextField.setVisible(true);
        kdtEntrys_availableAssistQty_TextField.setEditable(true);
        kdtEntrys_availableAssistQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_availableAssistQty_TextField.setDataType(1);
        	kdtEntrys_availableAssistQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_availableAssistQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_availableAssistQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_availableAssistQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_availableAssistQty_TextField);
        this.kdtEntrys.getColumn("availableAssistQty").setEditor(kdtEntrys_availableAssistQty_CellEditor);
        final KDBizPromptBox kdtEntrys_assistProperty_PromptBox = new KDBizPromptBox();
        kdtEntrys_assistProperty_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7AsstAttrValueQuery");
        kdtEntrys_assistProperty_PromptBox.setVisible(true);
        kdtEntrys_assistProperty_PromptBox.setEditable(true);
        kdtEntrys_assistProperty_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_assistProperty_PromptBox.setEditFormat("$number$");
        kdtEntrys_assistProperty_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_assistProperty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_assistProperty_PromptBox);
        this.kdtEntrys.getColumn("assistProperty").setEditor(kdtEntrys_assistProperty_CellEditor);
        ObjectValueRender kdtEntrys_assistProperty_OVR = new ObjectValueRender();
        kdtEntrys_assistProperty_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("assistProperty").setRenderer(kdtEntrys_assistProperty_OVR);
        final KDBizPromptBox kdtEntrys_wareHouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_wareHouse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtEntrys_wareHouse_PromptBox.setVisible(true);
        kdtEntrys_wareHouse_PromptBox.setEditable(true);
        kdtEntrys_wareHouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_wareHouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_wareHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_wareHouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_wareHouse_PromptBox);
        this.kdtEntrys.getColumn("wareHouse").setEditor(kdtEntrys_wareHouse_CellEditor);
        ObjectValueRender kdtEntrys_wareHouse_OVR = new ObjectValueRender();
        kdtEntrys_wareHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("wareHouse").setRenderer(kdtEntrys_wareHouse_OVR);
        final KDBizPromptBox kdtEntrys_location_PromptBox = new KDBizPromptBox();
        kdtEntrys_location_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7LocationQuery");
        kdtEntrys_location_PromptBox.setVisible(true);
        kdtEntrys_location_PromptBox.setEditable(true);
        kdtEntrys_location_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_location_PromptBox.setEditFormat("$number$");
        kdtEntrys_location_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_location_CellEditor = new KDTDefaultCellEditor(kdtEntrys_location_PromptBox);
        this.kdtEntrys.getColumn("location").setEditor(kdtEntrys_location_CellEditor);
        ObjectValueRender kdtEntrys_location_OVR = new ObjectValueRender();
        kdtEntrys_location_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("location").setRenderer(kdtEntrys_location_OVR);
        final KDBizPromptBox kdtEntrys_storeType_PromptBox = new KDBizPromptBox();
        kdtEntrys_storeType_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7StoreTypeQuery");
        kdtEntrys_storeType_PromptBox.setVisible(true);
        kdtEntrys_storeType_PromptBox.setEditable(true);
        kdtEntrys_storeType_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_storeType_PromptBox.setEditFormat("$number$");
        kdtEntrys_storeType_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_storeType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_storeType_PromptBox);
        this.kdtEntrys.getColumn("storeType").setEditor(kdtEntrys_storeType_CellEditor);
        ObjectValueRender kdtEntrys_storeType_OVR = new ObjectValueRender();
        kdtEntrys_storeType_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("storeType").setRenderer(kdtEntrys_storeType_OVR);
        final KDBizPromptBox kdtEntrys_storeState_PromptBox = new KDBizPromptBox();
        kdtEntrys_storeState_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7StoreStateQuery");
        kdtEntrys_storeState_PromptBox.setVisible(true);
        kdtEntrys_storeState_PromptBox.setEditable(true);
        kdtEntrys_storeState_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_storeState_PromptBox.setEditFormat("$number$");
        kdtEntrys_storeState_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_storeState_CellEditor = new KDTDefaultCellEditor(kdtEntrys_storeState_PromptBox);
        this.kdtEntrys.getColumn("storeState").setEditor(kdtEntrys_storeState_CellEditor);
        ObjectValueRender kdtEntrys_storeState_OVR = new ObjectValueRender();
        kdtEntrys_storeState_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("storeState").setRenderer(kdtEntrys_storeState_OVR);
        final KDBizPromptBox kdtEntrys_project_PromptBox = new KDBizPromptBox();
        kdtEntrys_project_PromptBox.setQueryInfo("com.kingdee.eas.mm.project.app.F7ProjectQuery");
        kdtEntrys_project_PromptBox.setVisible(true);
        kdtEntrys_project_PromptBox.setEditable(true);
        kdtEntrys_project_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_project_PromptBox.setEditFormat("$number$");
        kdtEntrys_project_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_project_CellEditor = new KDTDefaultCellEditor(kdtEntrys_project_PromptBox);
        this.kdtEntrys.getColumn("project").setEditor(kdtEntrys_project_CellEditor);
        ObjectValueRender kdtEntrys_project_OVR = new ObjectValueRender();
        kdtEntrys_project_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("project").setRenderer(kdtEntrys_project_OVR);
        			EntityViewInfo evikdtEntrys_project_PromptBox = new EntityViewInfo ();
		evikdtEntrys_project_PromptBox.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("ControlUnit"),"CU.id"));
		kdtEntrys_project_PromptBox.setEntityViewInfo(evikdtEntrys_project_PromptBox);
					
        final KDBizPromptBox kdtEntrys_trackNumber_PromptBox = new KDBizPromptBox();
        kdtEntrys_trackNumber_PromptBox.setQueryInfo("com.kingdee.eas.mm.basedata.app.TrackNumberQuery");
        kdtEntrys_trackNumber_PromptBox.setVisible(true);
        kdtEntrys_trackNumber_PromptBox.setEditable(true);
        kdtEntrys_trackNumber_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_trackNumber_PromptBox.setEditFormat("$number$");
        kdtEntrys_trackNumber_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_trackNumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_trackNumber_PromptBox);
        this.kdtEntrys.getColumn("trackNumber").setEditor(kdtEntrys_trackNumber_CellEditor);
        ObjectValueRender kdtEntrys_trackNumber_OVR = new ObjectValueRender();
        kdtEntrys_trackNumber_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("trackNumber").setRenderer(kdtEntrys_trackNumber_OVR);
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
        final KDBizPromptBox kdtEntrys_storageOrgUnit_PromptBox = new KDBizPromptBox();
        kdtEntrys_storageOrgUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");
        kdtEntrys_storageOrgUnit_PromptBox.setVisible(true);
        kdtEntrys_storageOrgUnit_PromptBox.setEditable(true);
        kdtEntrys_storageOrgUnit_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_storageOrgUnit_PromptBox.setEditFormat("$number$");
        kdtEntrys_storageOrgUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_storageOrgUnit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_storageOrgUnit_PromptBox);
        this.kdtEntrys.getColumn("storageOrgUnit").setEditor(kdtEntrys_storageOrgUnit_CellEditor);
        ObjectValueRender kdtEntrys_storageOrgUnit_OVR = new ObjectValueRender();
        kdtEntrys_storageOrgUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("storageOrgUnit").setRenderer(kdtEntrys_storageOrgUnit_OVR);
        KDFormattedTextField kdtEntrys_reservedQty_TextField = new KDFormattedTextField();
        kdtEntrys_reservedQty_TextField.setName("kdtEntrys_reservedQty_TextField");
        kdtEntrys_reservedQty_TextField.setVisible(true);
        kdtEntrys_reservedQty_TextField.setEditable(true);
        kdtEntrys_reservedQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_reservedQty_TextField.setDataType(1);
        	kdtEntrys_reservedQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_reservedQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_reservedQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_reservedQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_reservedQty_TextField);
        this.kdtEntrys.getColumn("reservedQty").setEditor(kdtEntrys_reservedQty_CellEditor);
        KDFormattedTextField kdtEntrys_reservedBaseQty_TextField = new KDFormattedTextField();
        kdtEntrys_reservedBaseQty_TextField.setName("kdtEntrys_reservedBaseQty_TextField");
        kdtEntrys_reservedBaseQty_TextField.setVisible(true);
        kdtEntrys_reservedBaseQty_TextField.setEditable(true);
        kdtEntrys_reservedBaseQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_reservedBaseQty_TextField.setDataType(1);
        	kdtEntrys_reservedBaseQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_reservedBaseQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_reservedBaseQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_reservedBaseQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_reservedBaseQty_TextField);
        this.kdtEntrys.getColumn("reservedBaseQty").setEditor(kdtEntrys_reservedBaseQty_CellEditor);
        KDFormattedTextField kdtEntrys_reservedAvaliableQty_TextField = new KDFormattedTextField();
        kdtEntrys_reservedAvaliableQty_TextField.setName("kdtEntrys_reservedAvaliableQty_TextField");
        kdtEntrys_reservedAvaliableQty_TextField.setVisible(true);
        kdtEntrys_reservedAvaliableQty_TextField.setEditable(true);
        kdtEntrys_reservedAvaliableQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_reservedAvaliableQty_TextField.setDataType(1);
        	kdtEntrys_reservedAvaliableQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_reservedAvaliableQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_reservedAvaliableQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_reservedAvaliableQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_reservedAvaliableQty_TextField);
        this.kdtEntrys.getColumn("reservedAvaliableQty").setEditor(kdtEntrys_reservedAvaliableQty_CellEditor);
        // contstoOrgUnit		
        this.contstoOrgUnit.setBoundLabelText(resHelper.getString("contstoOrgUnit.boundLabelText"));		
        this.contstoOrgUnit.setBoundLabelLength(100);		
        this.contstoOrgUnit.setBoundLabelUnderline(true);		
        this.contstoOrgUnit.setVisible(true);
        // contauditDate		
        this.contauditDate.setBoundLabelText(resHelper.getString("contauditDate.boundLabelText"));		
        this.contauditDate.setBoundLabelLength(100);		
        this.contauditDate.setBoundLabelUnderline(true);		
        this.contauditDate.setVisible(true);
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
        this.txtDescription.setVisible(false);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // prmtstoOrgUnit		
        this.prmtstoOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstoOrgUnit.setEditable(true);		
        this.prmtstoOrgUnit.setDisplayFormat("$name$");		
        this.prmtstoOrgUnit.setEditFormat("$number$");		
        this.prmtstoOrgUnit.setCommitFormat("$number$");		
        this.prmtstoOrgUnit.setRequired(false);
        // pkauditDate		
        this.pkauditDate.setVisible(true);		
        this.pkauditDate.setRequired(false);		
        this.pkauditDate.setEnabled(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,prmtstoOrgUnit,kdtEntrys,pkauditDate}));
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
        contCreator.setBounds(new Rectangle(372, 524, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(372, 524, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(733, 524, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(733, 524, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(372, 555, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(372, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(733, 555, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(733, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(12, 18, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(12, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(733, 17, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(733, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contDescription.setBounds(new Rectangle(866, 65, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(866, 65, 270, 19, 0));
        contAuditor.setBounds(new Rectangle(12, 528, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(12, 528, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(12, 62, 991, 450));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.custom.stockprice.RealTimeInventoryEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(12, 62, 991, 450, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contstoOrgUnit.setBounds(new Rectangle(372, 17, 270, 19));
        this.add(contstoOrgUnit, new KDLayout.Constraints(372, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditDate.setBounds(new Rectangle(12, 555, 270, 19));
        this.add(contauditDate, new KDLayout.Constraints(12, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contstoOrgUnit
        contstoOrgUnit.setBoundEditor(prmtstoOrgUnit);
        //contauditDate
        contauditDate.setBoundEditor(pkauditDate);

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
        this.toolBar.add(btnPCVoucher);
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
		dataBinder.registerBinding("entrys", com.kingdee.eas.custom.stockprice.RealTimeInventoryEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.material", java.lang.Object.class, this.kdtEntrys, "material.text");
		dataBinder.registerBinding("entrys.materialNum", String.class, this.kdtEntrys, "materialNum.text");
		dataBinder.registerBinding("entrys.model", String.class, this.kdtEntrys, "model.text");
		dataBinder.registerBinding("entrys.flot", String.class, this.kdtEntrys, "flot.text");
		dataBinder.registerBinding("entrys.storageOrgUnit", java.lang.Object.class, this.kdtEntrys, "storageOrgUnit.text");
		dataBinder.registerBinding("entrys.location", java.lang.Object.class, this.kdtEntrys, "location.text");
		dataBinder.registerBinding("entrys.wareHouse", java.lang.Object.class, this.kdtEntrys, "wareHouse.text");
		dataBinder.registerBinding("entrys.baseUnit", java.lang.Object.class, this.kdtEntrys, "baseUnit.text");
		dataBinder.registerBinding("entrys.amount", java.math.BigDecimal.class, this.kdtEntrys, "amount.text");
		dataBinder.registerBinding("entrys.supplier", java.lang.Object.class, this.kdtEntrys, "supplier.text");
		dataBinder.registerBinding("entrys.customer", java.lang.Object.class, this.kdtEntrys, "customer.text");
		dataBinder.registerBinding("entrys.storeType", java.lang.Object.class, this.kdtEntrys, "storeType.text");
		dataBinder.registerBinding("entrys.storeState", java.lang.Object.class, this.kdtEntrys, "storeState.text");
		dataBinder.registerBinding("entrys.productionDate", java.util.Date.class, this.kdtEntrys, "productionDate.text");
		dataBinder.registerBinding("entrys.unit", java.lang.Object.class, this.kdtEntrys, "unit.text");
		dataBinder.registerBinding("entrys.baseQty", java.math.BigDecimal.class, this.kdtEntrys, "baseQty.text");
		dataBinder.registerBinding("entrys.exp", java.util.Date.class, this.kdtEntrys, "exp.text");
		dataBinder.registerBinding("entrys.availableQty", java.math.BigDecimal.class, this.kdtEntrys, "availableQty.text");
		dataBinder.registerBinding("entrys.availableBaseQty", java.math.BigDecimal.class, this.kdtEntrys, "availableBaseQty.text");
		dataBinder.registerBinding("entrys.assistUnit", java.lang.Object.class, this.kdtEntrys, "assistUnit.text");
		dataBinder.registerBinding("entrys.assistQty", java.math.BigDecimal.class, this.kdtEntrys, "assistQty.text");
		dataBinder.registerBinding("entrys.availableAssistQty", java.math.BigDecimal.class, this.kdtEntrys, "availableAssistQty.text");
		dataBinder.registerBinding("entrys.trackNumber", java.lang.Object.class, this.kdtEntrys, "trackNumber.text");
		dataBinder.registerBinding("entrys.reservedQty", java.math.BigDecimal.class, this.kdtEntrys, "reservedQty.text");
		dataBinder.registerBinding("entrys.reservedBaseQty", java.math.BigDecimal.class, this.kdtEntrys, "reservedBaseQty.text");
		dataBinder.registerBinding("entrys.reservedAvaliableQty", java.math.BigDecimal.class, this.kdtEntrys, "reservedAvaliableQty.text");
		dataBinder.registerBinding("entrys.project", java.lang.Object.class, this.kdtEntrys, "project.text");
		dataBinder.registerBinding("entrys.assistProperty", java.lang.Object.class, this.kdtEntrys, "assistProperty.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("stoOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstoOrgUnit, "data");
		dataBinder.registerBinding("auditDate", java.util.Date.class, this.pkauditDate, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.stockprice.app.RealTimeInventoryEditUIHandler";
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
        this.editData = (com.kingdee.eas.custom.stockprice.RealTimeInventoryInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materialNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.flot", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.storageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.location", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.wareHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.baseUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.customer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.storeType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.storeState", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.productionDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.baseQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.exp", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.availableQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.availableBaseQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.assistUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.assistQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.availableAssistQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.trackNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.reservedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.reservedBaseQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.reservedAvaliableQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.project", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.assistProperty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stoOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditDate", ValidateHelper.ON_SAVE);    		
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
kdtEntrys.getCell(rowIndex,"materialNum").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"number")));

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
			sic.add(new SelectorItemInfo("entrys.material.name"));
        	sic.add(new SelectorItemInfo("entrys.material.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.materialNum"));
    	sic.add(new SelectorItemInfo("entrys.model"));
    	sic.add(new SelectorItemInfo("entrys.flot"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.storageOrgUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.storageOrgUnit.id"));
			sic.add(new SelectorItemInfo("entrys.storageOrgUnit.name"));
        	sic.add(new SelectorItemInfo("entrys.storageOrgUnit.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.location.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.location.id"));
			sic.add(new SelectorItemInfo("entrys.location.name"));
        	sic.add(new SelectorItemInfo("entrys.location.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.wareHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.wareHouse.id"));
			sic.add(new SelectorItemInfo("entrys.wareHouse.name"));
        	sic.add(new SelectorItemInfo("entrys.wareHouse.number"));
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
    	sic.add(new SelectorItemInfo("entrys.amount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.supplier.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.supplier.id"));
			sic.add(new SelectorItemInfo("entrys.supplier.name"));
        	sic.add(new SelectorItemInfo("entrys.supplier.number"));
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
			sic.add(new SelectorItemInfo("entrys.storeType.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.storeType.id"));
			sic.add(new SelectorItemInfo("entrys.storeType.name"));
        	sic.add(new SelectorItemInfo("entrys.storeType.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.storeState.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.storeState.id"));
			sic.add(new SelectorItemInfo("entrys.storeState.name"));
        	sic.add(new SelectorItemInfo("entrys.storeState.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.productionDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.unit.id"));
			sic.add(new SelectorItemInfo("entrys.unit.name"));
        	sic.add(new SelectorItemInfo("entrys.unit.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.baseQty"));
    	sic.add(new SelectorItemInfo("entrys.exp"));
    	sic.add(new SelectorItemInfo("entrys.availableQty"));
    	sic.add(new SelectorItemInfo("entrys.availableBaseQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.assistUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.assistUnit.id"));
			sic.add(new SelectorItemInfo("entrys.assistUnit.name"));
        	sic.add(new SelectorItemInfo("entrys.assistUnit.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.assistQty"));
    	sic.add(new SelectorItemInfo("entrys.availableAssistQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.trackNumber.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.trackNumber.id"));
			sic.add(new SelectorItemInfo("entrys.trackNumber.name"));
        	sic.add(new SelectorItemInfo("entrys.trackNumber.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.reservedQty"));
    	sic.add(new SelectorItemInfo("entrys.reservedBaseQty"));
    	sic.add(new SelectorItemInfo("entrys.reservedAvaliableQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.project.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.project.id"));
			sic.add(new SelectorItemInfo("entrys.project.name"));
        	sic.add(new SelectorItemInfo("entrys.project.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.assistProperty.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.assistProperty.id"));
			sic.add(new SelectorItemInfo("entrys.assistProperty.name"));
        	sic.add(new SelectorItemInfo("entrys.assistProperty.number"));
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
			sic.add(new SelectorItemInfo("stoOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("stoOrgUnit.id"));
        	sic.add(new SelectorItemInfo("stoOrgUnit.number"));
        	sic.add(new SelectorItemInfo("stoOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("auditDate"));
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
        return new MetaDataPK("com.kingdee.eas.custom.stockprice.client", "RealTimeInventoryEditUI");
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
        return com.kingdee.eas.custom.stockprice.client.RealTimeInventoryEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.stockprice.RealTimeInventoryFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.stockprice.RealTimeInventoryInfo objectValue = new com.kingdee.eas.custom.stockprice.RealTimeInventoryInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/stockprice/RealTimeInventory";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.stockprice.app.RealTimeInventoryQuery");
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
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}