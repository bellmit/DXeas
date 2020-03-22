/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.workshopmanager.client;

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
public abstract class AbstractLoadingBillEditUI extends com.kingdee.eas.custom.wlhllicensemanager.client.WlhlCoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractLoadingBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsrcBillName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsrcBillNum;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcustomer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsaleOrder;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisCreateIssueBill;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsrcBillName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsrcBillNum;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcustomer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsaleOrder;
    protected com.kingdee.eas.custom.taihe.workshopmanager.LoadingBillInfo editData = null;
    protected ActionMobileQuery actionMobileQuery = null;
    protected ActionMobifyAddNew actionMobifyAddNew = null;
    /**
     * output class constructor
     */
    public AbstractLoadingBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractLoadingBillEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionMobileQuery
        this.actionMobileQuery = new ActionMobileQuery(this);
        getActionManager().registerAction("actionMobileQuery", actionMobileQuery);
        this.actionMobileQuery.setExtendProperty("canForewarn", "true");
        this.actionMobileQuery.setExtendProperty("userDefined", "false");
        this.actionMobileQuery.setExtendProperty("isObjectUpdateLock", "false");
         this.actionMobileQuery.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionMobileQuery.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionMobifyAddNew
        this.actionMobifyAddNew = new ActionMobifyAddNew(this);
        getActionManager().registerAction("actionMobifyAddNew", actionMobifyAddNew);
        this.actionMobifyAddNew.setExtendProperty("canForewarn", "true");
        this.actionMobifyAddNew.setExtendProperty("userDefined", "false");
        this.actionMobifyAddNew.setExtendProperty("isObjectUpdateLock", "false");
         this.actionMobifyAddNew.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionMobifyAddNew.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsrcBillName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsrcBillNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contcustomer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsaleOrder = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisCreateIssueBill = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtstorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtsrcBillName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtsrcBillNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtcustomer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtsaleOrder = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contcompany.setName("contcompany");
        this.contstorageOrgUnit.setName("contstorageOrgUnit");
        this.contsrcBillName.setName("contsrcBillName");
        this.contsrcBillNum.setName("contsrcBillNum");
        this.kdtEntry.setName("kdtEntry");
        this.contcustomer.setName("contcustomer");
        this.contsaleOrder.setName("contsaleOrder");
        this.chkisCreateIssueBill.setName("chkisCreateIssueBill");
        this.prmtcompany.setName("prmtcompany");
        this.prmtstorageOrgUnit.setName("prmtstorageOrgUnit");
        this.txtsrcBillName.setName("txtsrcBillName");
        this.txtsrcBillNum.setName("txtsrcBillNum");
        this.prmtcustomer.setName("prmtcustomer");
        this.prmtsaleOrder.setName("prmtsaleOrder");
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
        this.contCreator.setBoundLabelText(resHelper.getString("contCreator.boundLabelText"));		
        this.contCreator.setBoundLabelLength(100);		
        this.contCreator.setBoundLabelUnderline(true);		
        this.contCreator.setEnabled(false);		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);		
        this.contLastUpdateUser.setBoundLabelText(resHelper.getString("contLastUpdateUser.boundLabelText"));		
        this.contLastUpdateUser.setBoundLabelLength(100);		
        this.contLastUpdateUser.setBoundLabelUnderline(true);		
        this.contLastUpdateUser.setEnabled(false);		
        this.contLastUpdateUser.setVisible(true);		
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);		
        this.contLastUpdateTime.setVisible(true);		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);		
        this.prmtCreator.setEnabled(false);		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);		
        this.prmtLastUpdateUser.setEnabled(false);		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);		
        this.txtNumber.setMaxLength(80);		
        this.pkBizDate.setEnabled(true);		
        this.txtDescription.setMaxLength(80);		
        this.prmtAuditor.setEnabled(false);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contstorageOrgUnit		
        this.contstorageOrgUnit.setBoundLabelText(resHelper.getString("contstorageOrgUnit.boundLabelText"));		
        this.contstorageOrgUnit.setBoundLabelLength(100);		
        this.contstorageOrgUnit.setBoundLabelUnderline(true);		
        this.contstorageOrgUnit.setVisible(true);
        // contsrcBillName		
        this.contsrcBillName.setBoundLabelText(resHelper.getString("contsrcBillName.boundLabelText"));		
        this.contsrcBillName.setBoundLabelLength(100);		
        this.contsrcBillName.setBoundLabelUnderline(true);		
        this.contsrcBillName.setVisible(true);
        // contsrcBillNum		
        this.contsrcBillNum.setBoundLabelText(resHelper.getString("contsrcBillNum.boundLabelText"));		
        this.contsrcBillNum.setBoundLabelLength(100);		
        this.contsrcBillNum.setBoundLabelUnderline(true);		
        this.contsrcBillNum.setVisible(true);
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"srcEntryID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"baseUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"baseQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"assitUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"assitQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"taxRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"taxAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"taxPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"allAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"warehouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"policyPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"premiumPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{srcEntryID}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{baseUnit}</t:Cell><t:Cell>$Resource{baseQty}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{assitUnit}</t:Cell><t:Cell>$Resource{assitQty}</t:Cell><t:Cell>$Resource{price}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{taxRate}</t:Cell><t:Cell>$Resource{taxAmount}</t:Cell><t:Cell>$Resource{taxPrice}</t:Cell><t:Cell>$Resource{allAmount}</t:Cell><t:Cell>$Resource{warehouse}</t:Cell><t:Cell>$Resource{policyPrice}</t:Cell><t:Cell>$Resource{premiumPrice}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntry.putBindContents("editData",new String[] {"seq","srcEntryID","material","materialName","model","baseUnit","baseQty","unit","qty","assitUnit","assitQty","price","amount","taxRate","taxAmount","taxPrice","allAmount","warehouse","policyPrice","premiumPrice"});


        this.kdtEntry.checkParsed();
        KDFormattedTextField kdtEntry_seq_TextField = new KDFormattedTextField();
        kdtEntry_seq_TextField.setName("kdtEntry_seq_TextField");
        kdtEntry_seq_TextField.setVisible(true);
        kdtEntry_seq_TextField.setEditable(true);
        kdtEntry_seq_TextField.setHorizontalAlignment(2);
        kdtEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtEntry_seq_TextField);
        this.kdtEntry.getColumn("seq").setEditor(kdtEntry_seq_CellEditor);
        KDTextField kdtEntry_srcEntryID_TextField = new KDTextField();
        kdtEntry_srcEntryID_TextField.setName("kdtEntry_srcEntryID_TextField");
        kdtEntry_srcEntryID_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntry_srcEntryID_CellEditor = new KDTDefaultCellEditor(kdtEntry_srcEntryID_TextField);
        this.kdtEntry.getColumn("srcEntryID").setEditor(kdtEntry_srcEntryID_CellEditor);
        final KDBizPromptBox kdtEntry_material_PromptBox = new KDBizPromptBox();
        kdtEntry_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntry_material_PromptBox.setVisible(true);
        kdtEntry_material_PromptBox.setEditable(true);
        kdtEntry_material_PromptBox.setDisplayFormat("$number$");
        kdtEntry_material_PromptBox.setEditFormat("$number$");
        kdtEntry_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_material_CellEditor = new KDTDefaultCellEditor(kdtEntry_material_PromptBox);
        this.kdtEntry.getColumn("material").setEditor(kdtEntry_material_CellEditor);
        ObjectValueRender kdtEntry_material_OVR = new ObjectValueRender();
        kdtEntry_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntry.getColumn("material").setRenderer(kdtEntry_material_OVR);
        KDTextField kdtEntry_materialName_TextField = new KDTextField();
        kdtEntry_materialName_TextField.setName("kdtEntry_materialName_TextField");
        kdtEntry_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_materialName_CellEditor = new KDTDefaultCellEditor(kdtEntry_materialName_TextField);
        this.kdtEntry.getColumn("materialName").setEditor(kdtEntry_materialName_CellEditor);
        KDTextField kdtEntry_model_TextField = new KDTextField();
        kdtEntry_model_TextField.setName("kdtEntry_model_TextField");
        kdtEntry_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_model_CellEditor = new KDTDefaultCellEditor(kdtEntry_model_TextField);
        this.kdtEntry.getColumn("model").setEditor(kdtEntry_model_CellEditor);
        final KDBizPromptBox kdtEntry_baseUnit_PromptBox = new KDBizPromptBox();
        kdtEntry_baseUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtEntry_baseUnit_PromptBox.setVisible(true);
        kdtEntry_baseUnit_PromptBox.setEditable(true);
        kdtEntry_baseUnit_PromptBox.setDisplayFormat("$number$");
        kdtEntry_baseUnit_PromptBox.setEditFormat("$number$");
        kdtEntry_baseUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_baseUnit_CellEditor = new KDTDefaultCellEditor(kdtEntry_baseUnit_PromptBox);
        this.kdtEntry.getColumn("baseUnit").setEditor(kdtEntry_baseUnit_CellEditor);
        ObjectValueRender kdtEntry_baseUnit_OVR = new ObjectValueRender();
        kdtEntry_baseUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("baseUnit").setRenderer(kdtEntry_baseUnit_OVR);
        KDFormattedTextField kdtEntry_baseQty_TextField = new KDFormattedTextField();
        kdtEntry_baseQty_TextField.setName("kdtEntry_baseQty_TextField");
        kdtEntry_baseQty_TextField.setVisible(true);
        kdtEntry_baseQty_TextField.setEditable(true);
        kdtEntry_baseQty_TextField.setHorizontalAlignment(2);
        kdtEntry_baseQty_TextField.setDataType(1);
        	kdtEntry_baseQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_baseQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_baseQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_baseQty_CellEditor = new KDTDefaultCellEditor(kdtEntry_baseQty_TextField);
        this.kdtEntry.getColumn("baseQty").setEditor(kdtEntry_baseQty_CellEditor);
        final KDBizPromptBox kdtEntry_unit_PromptBox = new KDBizPromptBox();
        kdtEntry_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtEntry_unit_PromptBox.setVisible(true);
        kdtEntry_unit_PromptBox.setEditable(true);
        kdtEntry_unit_PromptBox.setDisplayFormat("$number$");
        kdtEntry_unit_PromptBox.setEditFormat("$number$");
        kdtEntry_unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_unit_CellEditor = new KDTDefaultCellEditor(kdtEntry_unit_PromptBox);
        this.kdtEntry.getColumn("unit").setEditor(kdtEntry_unit_CellEditor);
        ObjectValueRender kdtEntry_unit_OVR = new ObjectValueRender();
        kdtEntry_unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("unit").setRenderer(kdtEntry_unit_OVR);
        KDFormattedTextField kdtEntry_qty_TextField = new KDFormattedTextField();
        kdtEntry_qty_TextField.setName("kdtEntry_qty_TextField");
        kdtEntry_qty_TextField.setVisible(true);
        kdtEntry_qty_TextField.setEditable(true);
        kdtEntry_qty_TextField.setHorizontalAlignment(2);
        kdtEntry_qty_TextField.setDataType(1);
        	kdtEntry_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_qty_CellEditor = new KDTDefaultCellEditor(kdtEntry_qty_TextField);
        this.kdtEntry.getColumn("qty").setEditor(kdtEntry_qty_CellEditor);
        final KDBizPromptBox kdtEntry_assitUnit_PromptBox = new KDBizPromptBox();
        kdtEntry_assitUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtEntry_assitUnit_PromptBox.setVisible(true);
        kdtEntry_assitUnit_PromptBox.setEditable(true);
        kdtEntry_assitUnit_PromptBox.setDisplayFormat("$number$");
        kdtEntry_assitUnit_PromptBox.setEditFormat("$number$");
        kdtEntry_assitUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_assitUnit_CellEditor = new KDTDefaultCellEditor(kdtEntry_assitUnit_PromptBox);
        this.kdtEntry.getColumn("assitUnit").setEditor(kdtEntry_assitUnit_CellEditor);
        ObjectValueRender kdtEntry_assitUnit_OVR = new ObjectValueRender();
        kdtEntry_assitUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("assitUnit").setRenderer(kdtEntry_assitUnit_OVR);
        KDFormattedTextField kdtEntry_assitQty_TextField = new KDFormattedTextField();
        kdtEntry_assitQty_TextField.setName("kdtEntry_assitQty_TextField");
        kdtEntry_assitQty_TextField.setVisible(true);
        kdtEntry_assitQty_TextField.setEditable(true);
        kdtEntry_assitQty_TextField.setHorizontalAlignment(2);
        kdtEntry_assitQty_TextField.setDataType(1);
        	kdtEntry_assitQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_assitQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_assitQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_assitQty_CellEditor = new KDTDefaultCellEditor(kdtEntry_assitQty_TextField);
        this.kdtEntry.getColumn("assitQty").setEditor(kdtEntry_assitQty_CellEditor);
        KDFormattedTextField kdtEntry_price_TextField = new KDFormattedTextField();
        kdtEntry_price_TextField.setName("kdtEntry_price_TextField");
        kdtEntry_price_TextField.setVisible(true);
        kdtEntry_price_TextField.setEditable(true);
        kdtEntry_price_TextField.setHorizontalAlignment(2);
        kdtEntry_price_TextField.setDataType(1);
        	kdtEntry_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_price_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_price_CellEditor = new KDTDefaultCellEditor(kdtEntry_price_TextField);
        this.kdtEntry.getColumn("price").setEditor(kdtEntry_price_CellEditor);
        KDFormattedTextField kdtEntry_amount_TextField = new KDFormattedTextField();
        kdtEntry_amount_TextField.setName("kdtEntry_amount_TextField");
        kdtEntry_amount_TextField.setVisible(true);
        kdtEntry_amount_TextField.setEditable(true);
        kdtEntry_amount_TextField.setHorizontalAlignment(2);
        kdtEntry_amount_TextField.setDataType(1);
        	kdtEntry_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_amount_CellEditor = new KDTDefaultCellEditor(kdtEntry_amount_TextField);
        this.kdtEntry.getColumn("amount").setEditor(kdtEntry_amount_CellEditor);
        KDFormattedTextField kdtEntry_taxRate_TextField = new KDFormattedTextField();
        kdtEntry_taxRate_TextField.setName("kdtEntry_taxRate_TextField");
        kdtEntry_taxRate_TextField.setVisible(true);
        kdtEntry_taxRate_TextField.setEditable(true);
        kdtEntry_taxRate_TextField.setHorizontalAlignment(2);
        kdtEntry_taxRate_TextField.setDataType(1);
        	kdtEntry_taxRate_TextField.setMinimumValue(new java.math.BigDecimal("-999.999"));
        	kdtEntry_taxRate_TextField.setMaximumValue(new java.math.BigDecimal("999.999"));
        kdtEntry_taxRate_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtEntry_taxRate_CellEditor = new KDTDefaultCellEditor(kdtEntry_taxRate_TextField);
        this.kdtEntry.getColumn("taxRate").setEditor(kdtEntry_taxRate_CellEditor);
        KDFormattedTextField kdtEntry_taxAmount_TextField = new KDFormattedTextField();
        kdtEntry_taxAmount_TextField.setName("kdtEntry_taxAmount_TextField");
        kdtEntry_taxAmount_TextField.setVisible(true);
        kdtEntry_taxAmount_TextField.setEditable(true);
        kdtEntry_taxAmount_TextField.setHorizontalAlignment(2);
        kdtEntry_taxAmount_TextField.setDataType(1);
        	kdtEntry_taxAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_taxAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_taxAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_taxAmount_CellEditor = new KDTDefaultCellEditor(kdtEntry_taxAmount_TextField);
        this.kdtEntry.getColumn("taxAmount").setEditor(kdtEntry_taxAmount_CellEditor);
        KDFormattedTextField kdtEntry_taxPrice_TextField = new KDFormattedTextField();
        kdtEntry_taxPrice_TextField.setName("kdtEntry_taxPrice_TextField");
        kdtEntry_taxPrice_TextField.setVisible(true);
        kdtEntry_taxPrice_TextField.setEditable(true);
        kdtEntry_taxPrice_TextField.setHorizontalAlignment(2);
        kdtEntry_taxPrice_TextField.setDataType(1);
        	kdtEntry_taxPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_taxPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_taxPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_taxPrice_CellEditor = new KDTDefaultCellEditor(kdtEntry_taxPrice_TextField);
        this.kdtEntry.getColumn("taxPrice").setEditor(kdtEntry_taxPrice_CellEditor);
        KDFormattedTextField kdtEntry_allAmount_TextField = new KDFormattedTextField();
        kdtEntry_allAmount_TextField.setName("kdtEntry_allAmount_TextField");
        kdtEntry_allAmount_TextField.setVisible(true);
        kdtEntry_allAmount_TextField.setEditable(true);
        kdtEntry_allAmount_TextField.setHorizontalAlignment(2);
        kdtEntry_allAmount_TextField.setDataType(1);
        	kdtEntry_allAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_allAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_allAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_allAmount_CellEditor = new KDTDefaultCellEditor(kdtEntry_allAmount_TextField);
        this.kdtEntry.getColumn("allAmount").setEditor(kdtEntry_allAmount_CellEditor);
        final KDBizPromptBox kdtEntry_warehouse_PromptBox = new KDBizPromptBox();
        kdtEntry_warehouse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtEntry_warehouse_PromptBox.setVisible(true);
        kdtEntry_warehouse_PromptBox.setEditable(true);
        kdtEntry_warehouse_PromptBox.setDisplayFormat("$number$");
        kdtEntry_warehouse_PromptBox.setEditFormat("$number$");
        kdtEntry_warehouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_warehouse_CellEditor = new KDTDefaultCellEditor(kdtEntry_warehouse_PromptBox);
        this.kdtEntry.getColumn("warehouse").setEditor(kdtEntry_warehouse_CellEditor);
        ObjectValueRender kdtEntry_warehouse_OVR = new ObjectValueRender();
        kdtEntry_warehouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("warehouse").setRenderer(kdtEntry_warehouse_OVR);
        KDFormattedTextField kdtEntry_policyPrice_TextField = new KDFormattedTextField();
        kdtEntry_policyPrice_TextField.setName("kdtEntry_policyPrice_TextField");
        kdtEntry_policyPrice_TextField.setVisible(true);
        kdtEntry_policyPrice_TextField.setEditable(true);
        kdtEntry_policyPrice_TextField.setHorizontalAlignment(2);
        kdtEntry_policyPrice_TextField.setDataType(1);
        	kdtEntry_policyPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_policyPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_policyPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_policyPrice_CellEditor = new KDTDefaultCellEditor(kdtEntry_policyPrice_TextField);
        this.kdtEntry.getColumn("policyPrice").setEditor(kdtEntry_policyPrice_CellEditor);
        KDFormattedTextField kdtEntry_premiumPrice_TextField = new KDFormattedTextField();
        kdtEntry_premiumPrice_TextField.setName("kdtEntry_premiumPrice_TextField");
        kdtEntry_premiumPrice_TextField.setVisible(true);
        kdtEntry_premiumPrice_TextField.setEditable(true);
        kdtEntry_premiumPrice_TextField.setHorizontalAlignment(2);
        kdtEntry_premiumPrice_TextField.setDataType(1);
        	kdtEntry_premiumPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_premiumPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_premiumPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_premiumPrice_CellEditor = new KDTDefaultCellEditor(kdtEntry_premiumPrice_TextField);
        this.kdtEntry.getColumn("premiumPrice").setEditor(kdtEntry_premiumPrice_CellEditor);
        // contcustomer		
        this.contcustomer.setBoundLabelText(resHelper.getString("contcustomer.boundLabelText"));		
        this.contcustomer.setBoundLabelLength(100);		
        this.contcustomer.setBoundLabelUnderline(true);		
        this.contcustomer.setVisible(true);
        // contsaleOrder		
        this.contsaleOrder.setBoundLabelText(resHelper.getString("contsaleOrder.boundLabelText"));		
        this.contsaleOrder.setBoundLabelLength(100);		
        this.contsaleOrder.setBoundLabelUnderline(true);		
        this.contsaleOrder.setVisible(false);
        // chkisCreateIssueBill		
        this.chkisCreateIssueBill.setText(resHelper.getString("chkisCreateIssueBill.text"));		
        this.chkisCreateIssueBill.setHorizontalAlignment(2);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // prmtstorageOrgUnit		
        this.prmtstorageOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstorageOrgUnit.setEditable(true);		
        this.prmtstorageOrgUnit.setDisplayFormat("$name$");		
        this.prmtstorageOrgUnit.setEditFormat("$number$");		
        this.prmtstorageOrgUnit.setCommitFormat("$number$");		
        this.prmtstorageOrgUnit.setRequired(false);
        // txtsrcBillName		
        this.txtsrcBillName.setHorizontalAlignment(2);		
        this.txtsrcBillName.setMaxLength(100);		
        this.txtsrcBillName.setRequired(false);
        // txtsrcBillNum		
        this.txtsrcBillNum.setHorizontalAlignment(2);		
        this.txtsrcBillNum.setMaxLength(100);		
        this.txtsrcBillNum.setRequired(false);
        // prmtcustomer		
        this.prmtcustomer.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");		
        this.prmtcustomer.setEditable(true);		
        this.prmtcustomer.setDisplayFormat("$name$");		
        this.prmtcustomer.setEditFormat("$number$");		
        this.prmtcustomer.setCommitFormat("$number$");		
        this.prmtcustomer.setRequired(false);
        // prmtsaleOrder		
        this.prmtsaleOrder.setQueryInfo("com.kingdee.eas.scm.sd.sale.app.SaleOrderQuery");		
        this.prmtsaleOrder.setEditable(true);		
        this.prmtsaleOrder.setDisplayFormat("$number$");		
        this.prmtsaleOrder.setEditFormat("$number$");		
        this.prmtsaleOrder.setCommitFormat("$number$");		
        this.prmtsaleOrder.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,pkauditTime,billStatus,prmtcompany,prmtstorageOrgUnit,txtsrcBillName,txtsrcBillNum,prmtcustomer,prmtsaleOrder,chkisCreateIssueBill,kdtEntry}));
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
        contCreator.setBounds(new Rectangle(370, 548, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(370, 548, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(370, 581, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(370, 581, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(717, 548, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(717, 548, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(717, 581, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(717, 581, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(23, 19, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(23, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(370, 19, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(370, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(717, 58, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(717, 58, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(23, 548, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(23, 548, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(23, 581, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(23, 581, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(717, 19, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(717, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(23, 58, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(23, 58, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstorageOrgUnit.setBounds(new Rectangle(370, 58, 270, 19));
        this.add(contstorageOrgUnit, new KDLayout.Constraints(370, 58, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsrcBillName.setBounds(new Rectangle(370, 97, 270, 19));
        this.add(contsrcBillName, new KDLayout.Constraints(370, 97, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsrcBillNum.setBounds(new Rectangle(717, 97, 270, 19));
        this.add(contsrcBillNum, new KDLayout.Constraints(717, 97, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtEntry.setBounds(new Rectangle(16, 171, 974, 364));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.custom.taihe.workshopmanager.LoadingBillEntryInfo(),null,false);
        this.add(kdtEntry_detailPanel, new KDLayout.Constraints(16, 171, 974, 364, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcustomer.setBounds(new Rectangle(23, 97, 270, 19));
        this.add(contcustomer, new KDLayout.Constraints(23, 97, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsaleOrder.setBounds(new Rectangle(641, 605, 270, 19));
        this.add(contsaleOrder, new KDLayout.Constraints(641, 605, 270, 19, 0));
        chkisCreateIssueBill.setBounds(new Rectangle(23, 136, 270, 19));
        this.add(chkisCreateIssueBill, new KDLayout.Constraints(23, 136, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contstorageOrgUnit
        contstorageOrgUnit.setBoundEditor(prmtstorageOrgUnit);
        //contsrcBillName
        contsrcBillName.setBoundEditor(txtsrcBillName);
        //contsrcBillNum
        contsrcBillNum.setBoundEditor(txtsrcBillNum);
        //contcustomer
        contcustomer.setBoundEditor(prmtcustomer);
        //contsaleOrder
        contsaleOrder.setBoundEditor(prmtsaleOrder);

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
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(MenuItemPCVoucher);
        menuBiz.add(menuItemDelVoucher);
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
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
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
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.custom.taihe.workshopmanager.LoadingBillEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.srcEntryID", String.class, this.kdtEntry, "srcEntryID.text");
		dataBinder.registerBinding("Entry.material", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.kdtEntry, "material.text");
		dataBinder.registerBinding("Entry.materialName", String.class, this.kdtEntry, "materialName.text");
		dataBinder.registerBinding("Entry.model", String.class, this.kdtEntry, "model.text");
		dataBinder.registerBinding("Entry.unit", com.kingdee.eas.basedata.assistant.MeasureUnitInfo.class, this.kdtEntry, "unit.text");
		dataBinder.registerBinding("Entry.qty", java.math.BigDecimal.class, this.kdtEntry, "qty.text");
		dataBinder.registerBinding("Entry.price", java.math.BigDecimal.class, this.kdtEntry, "price.text");
		dataBinder.registerBinding("Entry.amount", java.math.BigDecimal.class, this.kdtEntry, "amount.text");
		dataBinder.registerBinding("Entry.taxRate", java.math.BigDecimal.class, this.kdtEntry, "taxRate.text");
		dataBinder.registerBinding("Entry.taxAmount", java.math.BigDecimal.class, this.kdtEntry, "taxAmount.text");
		dataBinder.registerBinding("Entry.taxPrice", java.math.BigDecimal.class, this.kdtEntry, "taxPrice.text");
		dataBinder.registerBinding("Entry.allAmount", java.math.BigDecimal.class, this.kdtEntry, "allAmount.text");
		dataBinder.registerBinding("Entry.baseUnit", java.lang.Object.class, this.kdtEntry, "baseUnit.text");
		dataBinder.registerBinding("Entry.baseQty", java.math.BigDecimal.class, this.kdtEntry, "baseQty.text");
		dataBinder.registerBinding("Entry.assitUnit", java.lang.Object.class, this.kdtEntry, "assitUnit.text");
		dataBinder.registerBinding("Entry.assitQty", java.math.BigDecimal.class, this.kdtEntry, "assitQty.text");
		dataBinder.registerBinding("Entry.warehouse", java.lang.Object.class, this.kdtEntry, "warehouse.text");
		dataBinder.registerBinding("Entry.policyPrice", java.math.BigDecimal.class, this.kdtEntry, "policyPrice.text");
		dataBinder.registerBinding("Entry.premiumPrice", java.math.BigDecimal.class, this.kdtEntry, "premiumPrice.text");
		dataBinder.registerBinding("isCreateIssueBill", boolean.class, this.chkisCreateIssueBill, "selected");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("storageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstorageOrgUnit, "data");
		dataBinder.registerBinding("srcBillName", String.class, this.txtsrcBillName, "text");
		dataBinder.registerBinding("srcBillNum", String.class, this.txtsrcBillNum, "text");
		dataBinder.registerBinding("customer", com.kingdee.eas.basedata.master.cssp.CustomerInfo.class, this.prmtcustomer, "data");
		dataBinder.registerBinding("saleOrder", com.kingdee.eas.scm.sd.sale.SaleOrderInfo.class, this.prmtsaleOrder, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.taihe.workshopmanager.app.LoadingBillEditUIHandler";
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
        this.editData = (com.kingdee.eas.custom.taihe.workshopmanager.LoadingBillInfo)ov;
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
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.srcEntryID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.price", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.taxRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.taxAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.taxPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.allAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.baseUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.baseQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.assitUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.assitQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.warehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.policyPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.premiumPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isCreateIssueBill", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("storageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("srcBillName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("srcBillNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("customer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("saleOrder", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("material".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"material").getValue(),"name")));

}

    if ("material".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"material").getValue(),"model")));

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
        sic.add(new SelectorItemInfo("billStatus"));
    	sic.add(new SelectorItemInfo("Entry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("Entry.srcEntryID"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.material.id"));
			sic.add(new SelectorItemInfo("Entry.material.number"));
			sic.add(new SelectorItemInfo("Entry.material.name"));
		}
    	sic.add(new SelectorItemInfo("Entry.materialName"));
    	sic.add(new SelectorItemInfo("Entry.model"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.unit.id"));
			sic.add(new SelectorItemInfo("Entry.unit.name"));
        	sic.add(new SelectorItemInfo("Entry.unit.number"));
		}
    	sic.add(new SelectorItemInfo("Entry.qty"));
    	sic.add(new SelectorItemInfo("Entry.price"));
    	sic.add(new SelectorItemInfo("Entry.amount"));
    	sic.add(new SelectorItemInfo("Entry.taxRate"));
    	sic.add(new SelectorItemInfo("Entry.taxAmount"));
    	sic.add(new SelectorItemInfo("Entry.taxPrice"));
    	sic.add(new SelectorItemInfo("Entry.allAmount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.baseUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.baseUnit.id"));
			sic.add(new SelectorItemInfo("Entry.baseUnit.name"));
        	sic.add(new SelectorItemInfo("Entry.baseUnit.number"));
		}
    	sic.add(new SelectorItemInfo("Entry.baseQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.assitUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.assitUnit.id"));
			sic.add(new SelectorItemInfo("Entry.assitUnit.name"));
        	sic.add(new SelectorItemInfo("Entry.assitUnit.number"));
		}
    	sic.add(new SelectorItemInfo("Entry.assitQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.warehouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.warehouse.id"));
			sic.add(new SelectorItemInfo("Entry.warehouse.name"));
        	sic.add(new SelectorItemInfo("Entry.warehouse.number"));
		}
    	sic.add(new SelectorItemInfo("Entry.policyPrice"));
    	sic.add(new SelectorItemInfo("Entry.premiumPrice"));
        sic.add(new SelectorItemInfo("isCreateIssueBill"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("storageOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("storageOrgUnit.id"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.number"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("srcBillName"));
        sic.add(new SelectorItemInfo("srcBillNum"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("customer.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("customer.id"));
        	sic.add(new SelectorItemInfo("customer.number"));
        	sic.add(new SelectorItemInfo("customer.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("saleOrder.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("saleOrder.id"));
        	sic.add(new SelectorItemInfo("saleOrder.number"));
		}
        return sic;
    }        
    	

    /**
     * output actionMobileQuery_actionPerformed method
     */
    public void actionMobileQuery_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.taihe.workshopmanager.LoadingBillFactory.getRemoteInstance().mobileQuery(editData);
    }
    	

    /**
     * output actionMobifyAddNew_actionPerformed method
     */
    public void actionMobifyAddNew_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.taihe.workshopmanager.LoadingBillFactory.getRemoteInstance().mobifyAddNew(editData);
    }
	public RequestContext prepareActionMobileQuery(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionMobileQuery() {
    	return false;
    }
	public RequestContext prepareActionMobifyAddNew(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionMobifyAddNew() {
    	return false;
    }

    /**
     * output ActionMobileQuery class
     */     
    protected class ActionMobileQuery extends ItemAction {     
    
        public ActionMobileQuery()
        {
            this(null);
        }

        public ActionMobileQuery(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionMobileQuery.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionMobileQuery.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionMobileQuery.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractLoadingBillEditUI.this, "ActionMobileQuery", "actionMobileQuery_actionPerformed", e);
        }
    }

    /**
     * output ActionMobifyAddNew class
     */     
    protected class ActionMobifyAddNew extends ItemAction {     
    
        public ActionMobifyAddNew()
        {
            this(null);
        }

        public ActionMobifyAddNew(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionMobifyAddNew.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionMobifyAddNew.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionMobifyAddNew.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractLoadingBillEditUI.this, "ActionMobifyAddNew", "actionMobifyAddNew_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.taihe.workshopmanager.client", "LoadingBillEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.taihe.workshopmanager.client.LoadingBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.taihe.workshopmanager.LoadingBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.workshopmanager.LoadingBillInfo objectValue = new com.kingdee.eas.custom.taihe.workshopmanager.LoadingBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/taihe/workshopmanager/LoadingBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.taihe.workshopmanager.app.LoadingBillQuery");
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
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}