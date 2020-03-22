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
public abstract class AbstractSalesPriceEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSalesPriceEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditDate;
    protected com.kingdee.eas.custom.stockprice.SalesPriceInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractSalesPriceEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSalesPriceEditUI.class.getName());
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
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contAuditor.setName("contAuditor");
        this.kdtEntrys.setName("kdtEntrys");
        this.contcompany.setName("contcompany");
        this.contauditDate.setName("contauditDate");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtcompany.setName("prmtcompany");
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
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"orgUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"materialNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"assistProperty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"priceType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"channelType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"priority\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"currency\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"minPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"maxPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"creator\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"auditor\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"auditDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"createTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"blockedStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"checkedStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"effectiveDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"expireDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{orgUnit}</t:Cell><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{materialNum}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{assistProperty}</t:Cell><t:Cell>$Resource{priceType}</t:Cell><t:Cell>$Resource{channelType}</t:Cell><t:Cell>$Resource{priority}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{currency}</t:Cell><t:Cell>$Resource{price}</t:Cell><t:Cell>$Resource{minPrice}</t:Cell><t:Cell>$Resource{maxPrice}</t:Cell><t:Cell>$Resource{creator}</t:Cell><t:Cell>$Resource{auditor}</t:Cell><t:Cell>$Resource{auditDate}</t:Cell><t:Cell>$Resource{createTime}</t:Cell><t:Cell>$Resource{blockedStatus}</t:Cell><t:Cell>$Resource{checkedStatus}</t:Cell><t:Cell>$Resource{effectiveDate}</t:Cell><t:Cell>$Resource{expireDate}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","orgUnit","bizDate","materialNum","material","model","assistProperty","priceType","channelType","priority","unit","currency","price","minPrice","maxPrice","creator","auditor","auditDate","createTime","blockedStatus","checkedStatus","effectiveDate","expireDate"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_orgUnit_PromptBox = new KDBizPromptBox();
        kdtEntrys_orgUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
        kdtEntrys_orgUnit_PromptBox.setVisible(true);
        kdtEntrys_orgUnit_PromptBox.setEditable(true);
        kdtEntrys_orgUnit_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_orgUnit_PromptBox.setEditFormat("$number$");
        kdtEntrys_orgUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_orgUnit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_orgUnit_PromptBox);
        this.kdtEntrys.getColumn("orgUnit").setEditor(kdtEntrys_orgUnit_CellEditor);
        ObjectValueRender kdtEntrys_orgUnit_OVR = new ObjectValueRender();
        kdtEntrys_orgUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("orgUnit").setRenderer(kdtEntrys_orgUnit_OVR);
        KDDatePicker kdtEntrys_bizDate_DatePicker = new KDDatePicker();
        kdtEntrys_bizDate_DatePicker.setName("kdtEntrys_bizDate_DatePicker");
        kdtEntrys_bizDate_DatePicker.setVisible(true);
        kdtEntrys_bizDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_bizDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_bizDate_DatePicker);
        this.kdtEntrys.getColumn("bizDate").setEditor(kdtEntrys_bizDate_CellEditor);
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
        final KDBizPromptBox kdtEntrys_priceType_PromptBox = new KDBizPromptBox();
        kdtEntrys_priceType_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.sd.sale.app.F7PriceTypeQuery");
        kdtEntrys_priceType_PromptBox.setVisible(true);
        kdtEntrys_priceType_PromptBox.setEditable(true);
        kdtEntrys_priceType_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_priceType_PromptBox.setEditFormat("$number$");
        kdtEntrys_priceType_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_priceType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_priceType_PromptBox);
        this.kdtEntrys.getColumn("priceType").setEditor(kdtEntrys_priceType_CellEditor);
        ObjectValueRender kdtEntrys_priceType_OVR = new ObjectValueRender();
        kdtEntrys_priceType_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("priceType").setRenderer(kdtEntrys_priceType_OVR);
        final KDBizPromptBox kdtEntrys_channelType_PromptBox = new KDBizPromptBox();
        kdtEntrys_channelType_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7ChannelTypeDefaultQuery");
        kdtEntrys_channelType_PromptBox.setVisible(true);
        kdtEntrys_channelType_PromptBox.setEditable(true);
        kdtEntrys_channelType_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_channelType_PromptBox.setEditFormat("$number$");
        kdtEntrys_channelType_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_channelType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_channelType_PromptBox);
        this.kdtEntrys.getColumn("channelType").setEditor(kdtEntrys_channelType_CellEditor);
        ObjectValueRender kdtEntrys_channelType_OVR = new ObjectValueRender();
        kdtEntrys_channelType_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("channelType").setRenderer(kdtEntrys_channelType_OVR);
        KDFormattedTextField kdtEntrys_priority_TextField = new KDFormattedTextField();
        kdtEntrys_priority_TextField.setName("kdtEntrys_priority_TextField");
        kdtEntrys_priority_TextField.setVisible(true);
        kdtEntrys_priority_TextField.setEditable(true);
        kdtEntrys_priority_TextField.setHorizontalAlignment(2);
        kdtEntrys_priority_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_priority_CellEditor = new KDTDefaultCellEditor(kdtEntrys_priority_TextField);
        this.kdtEntrys.getColumn("priority").setEditor(kdtEntrys_priority_CellEditor);
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
        final KDBizPromptBox kdtEntrys_currency_PromptBox = new KDBizPromptBox();
        kdtEntrys_currency_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.CurrencyQuery");
        kdtEntrys_currency_PromptBox.setVisible(true);
        kdtEntrys_currency_PromptBox.setEditable(true);
        kdtEntrys_currency_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_currency_PromptBox.setEditFormat("$number$");
        kdtEntrys_currency_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_currency_CellEditor = new KDTDefaultCellEditor(kdtEntrys_currency_PromptBox);
        this.kdtEntrys.getColumn("currency").setEditor(kdtEntrys_currency_CellEditor);
        ObjectValueRender kdtEntrys_currency_OVR = new ObjectValueRender();
        kdtEntrys_currency_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("currency").setRenderer(kdtEntrys_currency_OVR);
        KDFormattedTextField kdtEntrys_price_TextField = new KDFormattedTextField();
        kdtEntrys_price_TextField.setName("kdtEntrys_price_TextField");
        kdtEntrys_price_TextField.setVisible(true);
        kdtEntrys_price_TextField.setEditable(true);
        kdtEntrys_price_TextField.setHorizontalAlignment(2);
        kdtEntrys_price_TextField.setDataType(1);
        	kdtEntrys_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_price_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_price_CellEditor = new KDTDefaultCellEditor(kdtEntrys_price_TextField);
        this.kdtEntrys.getColumn("price").setEditor(kdtEntrys_price_CellEditor);
        KDFormattedTextField kdtEntrys_minPrice_TextField = new KDFormattedTextField();
        kdtEntrys_minPrice_TextField.setName("kdtEntrys_minPrice_TextField");
        kdtEntrys_minPrice_TextField.setVisible(true);
        kdtEntrys_minPrice_TextField.setEditable(true);
        kdtEntrys_minPrice_TextField.setHorizontalAlignment(2);
        kdtEntrys_minPrice_TextField.setDataType(1);
        	kdtEntrys_minPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_minPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_minPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_minPrice_CellEditor = new KDTDefaultCellEditor(kdtEntrys_minPrice_TextField);
        this.kdtEntrys.getColumn("minPrice").setEditor(kdtEntrys_minPrice_CellEditor);
        KDFormattedTextField kdtEntrys_maxPrice_TextField = new KDFormattedTextField();
        kdtEntrys_maxPrice_TextField.setName("kdtEntrys_maxPrice_TextField");
        kdtEntrys_maxPrice_TextField.setVisible(true);
        kdtEntrys_maxPrice_TextField.setEditable(true);
        kdtEntrys_maxPrice_TextField.setHorizontalAlignment(2);
        kdtEntrys_maxPrice_TextField.setDataType(1);
        	kdtEntrys_maxPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_maxPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_maxPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_maxPrice_CellEditor = new KDTDefaultCellEditor(kdtEntrys_maxPrice_TextField);
        this.kdtEntrys.getColumn("maxPrice").setEditor(kdtEntrys_maxPrice_CellEditor);
        final KDBizPromptBox kdtEntrys_creator_PromptBox = new KDBizPromptBox();
        kdtEntrys_creator_PromptBox.setQueryInfo("com.kingdee.eas.base.permission.app.F7AllUserQuery");
        kdtEntrys_creator_PromptBox.setVisible(true);
        kdtEntrys_creator_PromptBox.setEditable(true);
        kdtEntrys_creator_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_creator_PromptBox.setEditFormat("$number$");
        kdtEntrys_creator_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_creator_CellEditor = new KDTDefaultCellEditor(kdtEntrys_creator_PromptBox);
        this.kdtEntrys.getColumn("creator").setEditor(kdtEntrys_creator_CellEditor);
        ObjectValueRender kdtEntrys_creator_OVR = new ObjectValueRender();
        kdtEntrys_creator_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("creator").setRenderer(kdtEntrys_creator_OVR);
        final KDBizPromptBox kdtEntrys_auditor_PromptBox = new KDBizPromptBox();
        kdtEntrys_auditor_PromptBox.setQueryInfo("com.kingdee.eas.base.permission.app.F7AllUserQuery");
        kdtEntrys_auditor_PromptBox.setVisible(true);
        kdtEntrys_auditor_PromptBox.setEditable(true);
        kdtEntrys_auditor_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_auditor_PromptBox.setEditFormat("$number$");
        kdtEntrys_auditor_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_auditor_CellEditor = new KDTDefaultCellEditor(kdtEntrys_auditor_PromptBox);
        this.kdtEntrys.getColumn("auditor").setEditor(kdtEntrys_auditor_CellEditor);
        ObjectValueRender kdtEntrys_auditor_OVR = new ObjectValueRender();
        kdtEntrys_auditor_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("auditor").setRenderer(kdtEntrys_auditor_OVR);
        KDDatePicker kdtEntrys_auditDate_DatePicker = new KDDatePicker();
        kdtEntrys_auditDate_DatePicker.setName("kdtEntrys_auditDate_DatePicker");
        kdtEntrys_auditDate_DatePicker.setVisible(true);
        kdtEntrys_auditDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_auditDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_auditDate_DatePicker);
        this.kdtEntrys.getColumn("auditDate").setEditor(kdtEntrys_auditDate_CellEditor);
        KDDatePicker kdtEntrys_createTime_DatePicker = new KDDatePicker();
        kdtEntrys_createTime_DatePicker.setName("kdtEntrys_createTime_DatePicker");
        kdtEntrys_createTime_DatePicker.setVisible(true);
        kdtEntrys_createTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_createTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_createTime_DatePicker);
        this.kdtEntrys.getColumn("createTime").setEditor(kdtEntrys_createTime_CellEditor);
        KDComboBox kdtEntrys_blockedStatus_ComboBox = new KDComboBox();
        kdtEntrys_blockedStatus_ComboBox.setName("kdtEntrys_blockedStatus_ComboBox");
        kdtEntrys_blockedStatus_ComboBox.setVisible(true);
        kdtEntrys_blockedStatus_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.scm.sd.sale.BlockedStatusEnum").toArray());
        KDTDefaultCellEditor kdtEntrys_blockedStatus_CellEditor = new KDTDefaultCellEditor(kdtEntrys_blockedStatus_ComboBox);
        this.kdtEntrys.getColumn("blockedStatus").setEditor(kdtEntrys_blockedStatus_CellEditor);
        KDComboBox kdtEntrys_checkedStatus_ComboBox = new KDComboBox();
        kdtEntrys_checkedStatus_ComboBox.setName("kdtEntrys_checkedStatus_ComboBox");
        kdtEntrys_checkedStatus_ComboBox.setVisible(true);
        kdtEntrys_checkedStatus_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.scm.sd.sale.CheckedStatusEnum").toArray());
        KDTDefaultCellEditor kdtEntrys_checkedStatus_CellEditor = new KDTDefaultCellEditor(kdtEntrys_checkedStatus_ComboBox);
        this.kdtEntrys.getColumn("checkedStatus").setEditor(kdtEntrys_checkedStatus_CellEditor);
        KDDatePicker kdtEntrys_effectiveDate_DatePicker = new KDDatePicker();
        kdtEntrys_effectiveDate_DatePicker.setName("kdtEntrys_effectiveDate_DatePicker");
        kdtEntrys_effectiveDate_DatePicker.setVisible(true);
        kdtEntrys_effectiveDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_effectiveDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_effectiveDate_DatePicker);
        this.kdtEntrys.getColumn("effectiveDate").setEditor(kdtEntrys_effectiveDate_CellEditor);
        KDDatePicker kdtEntrys_expireDate_DatePicker = new KDDatePicker();
        kdtEntrys_expireDate_DatePicker.setName("kdtEntrys_expireDate_DatePicker");
        kdtEntrys_expireDate_DatePicker.setVisible(true);
        kdtEntrys_expireDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_expireDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_expireDate_DatePicker);
        this.kdtEntrys.getColumn("expireDate").setEditor(kdtEntrys_expireDate_CellEditor);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
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
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CUQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // pkauditDate		
        this.pkauditDate.setRequired(false);		
        this.pkauditDate.setEnabled(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,pkBizDate,txtNumber,prmtcompany,pkauditDate,kdtEntrys}));
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
        contCreator.setBounds(new Rectangle(372, 555, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(372, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(372, 590, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(372, 590, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(733, 555, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(733, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(733, 590, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(733, 590, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(733, 25, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(733, 25, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contBizDate.setBounds(new Rectangle(372, 25, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(372, 25, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(12, 555, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(12, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(11, 68, 991, 450));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.custom.stockprice.SalesPriceEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(11, 68, 991, 450, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("blockedStatus",new Integer(-1));
vo.put("checkedStatus",new Integer(-1));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contcompany.setBounds(new Rectangle(12, 25, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(12, 25, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditDate.setBounds(new Rectangle(12, 590, 270, 19));
        this.add(contauditDate, new KDLayout.Constraints(12, 590, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
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
		dataBinder.registerBinding("entrys", com.kingdee.eas.custom.stockprice.SalesPriceEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.material", java.lang.Object.class, this.kdtEntrys, "material.text");
		dataBinder.registerBinding("entrys.materialNum", String.class, this.kdtEntrys, "materialNum.text");
		dataBinder.registerBinding("entrys.model", String.class, this.kdtEntrys, "model.text");
		dataBinder.registerBinding("entrys.creator", java.lang.Object.class, this.kdtEntrys, "creator.text");
		dataBinder.registerBinding("entrys.auditor", java.lang.Object.class, this.kdtEntrys, "auditor.text");
		dataBinder.registerBinding("entrys.auditDate", java.util.Date.class, this.kdtEntrys, "auditDate.text");
		dataBinder.registerBinding("entrys.createTime", java.util.Date.class, this.kdtEntrys, "createTime.text");
		dataBinder.registerBinding("entrys.maxPrice", java.math.BigDecimal.class, this.kdtEntrys, "maxPrice.text");
		dataBinder.registerBinding("entrys.minPrice", java.math.BigDecimal.class, this.kdtEntrys, "minPrice.text");
		dataBinder.registerBinding("entrys.price", java.math.BigDecimal.class, this.kdtEntrys, "price.text");
		dataBinder.registerBinding("entrys.assistProperty", java.lang.Object.class, this.kdtEntrys, "assistProperty.text");
		dataBinder.registerBinding("entrys.channelType", java.lang.Object.class, this.kdtEntrys, "channelType.text");
		dataBinder.registerBinding("entrys.priceType", java.lang.Object.class, this.kdtEntrys, "priceType.text");
		dataBinder.registerBinding("entrys.priority", int.class, this.kdtEntrys, "priority.text");
		dataBinder.registerBinding("entrys.currency", java.lang.Object.class, this.kdtEntrys, "currency.text");
		dataBinder.registerBinding("entrys.unit", java.lang.Object.class, this.kdtEntrys, "unit.text");
		dataBinder.registerBinding("entrys.blockedStatus", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "blockedStatus.text");
		dataBinder.registerBinding("entrys.checkedStatus", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "checkedStatus.text");
		dataBinder.registerBinding("entrys.effectiveDate", java.util.Date.class, this.kdtEntrys, "effectiveDate.text");
		dataBinder.registerBinding("entrys.expireDate", java.util.Date.class, this.kdtEntrys, "expireDate.text");
		dataBinder.registerBinding("entrys.orgUnit", java.lang.Object.class, this.kdtEntrys, "orgUnit.text");
		dataBinder.registerBinding("entrys.bizDate", java.util.Date.class, this.kdtEntrys, "bizDate.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("auditDate", java.util.Date.class, this.pkauditDate, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.stockprice.app.SalesPriceEditUIHandler";
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
        this.editData = (com.kingdee.eas.custom.stockprice.SalesPriceInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.materialNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.auditDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.maxPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.minPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.price", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.assistProperty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.channelType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.priceType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.priority", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.currency", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.blockedStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.checkedStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.effectiveDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.expireDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.orgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.creator.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.creator.id"));
			sic.add(new SelectorItemInfo("entrys.creator.number"));
			sic.add(new SelectorItemInfo("entrys.creator.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.auditor.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.auditor.id"));
			sic.add(new SelectorItemInfo("entrys.auditor.number"));
			sic.add(new SelectorItemInfo("entrys.auditor.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.auditDate"));
    	sic.add(new SelectorItemInfo("entrys.createTime"));
    	sic.add(new SelectorItemInfo("entrys.maxPrice"));
    	sic.add(new SelectorItemInfo("entrys.minPrice"));
    	sic.add(new SelectorItemInfo("entrys.price"));
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
			sic.add(new SelectorItemInfo("entrys.channelType.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.channelType.id"));
			sic.add(new SelectorItemInfo("entrys.channelType.name"));
        	sic.add(new SelectorItemInfo("entrys.channelType.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.priceType.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.priceType.id"));
			sic.add(new SelectorItemInfo("entrys.priceType.name"));
        	sic.add(new SelectorItemInfo("entrys.priceType.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.priority"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.currency.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.currency.id"));
			sic.add(new SelectorItemInfo("entrys.currency.name"));
        	sic.add(new SelectorItemInfo("entrys.currency.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.unit.id"));
			sic.add(new SelectorItemInfo("entrys.unit.name"));
        	sic.add(new SelectorItemInfo("entrys.unit.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.blockedStatus"));
    	sic.add(new SelectorItemInfo("entrys.checkedStatus"));
    	sic.add(new SelectorItemInfo("entrys.effectiveDate"));
    	sic.add(new SelectorItemInfo("entrys.expireDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.orgUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.orgUnit.id"));
			sic.add(new SelectorItemInfo("entrys.orgUnit.name"));
        	sic.add(new SelectorItemInfo("entrys.orgUnit.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.bizDate"));
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
        return new MetaDataPK("com.kingdee.eas.custom.stockprice.client", "SalesPriceEditUI");
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
        return com.kingdee.eas.custom.stockprice.client.SalesPriceEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.stockprice.SalesPriceFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.stockprice.SalesPriceInfo objectValue = new com.kingdee.eas.custom.stockprice.SalesPriceInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/stockprice/SalesPrice";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.stockprice.app.SalesPriceQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"orgUnit").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"组织单元"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"bizDate").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"material").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"物料"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"price").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"价格"});
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
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}