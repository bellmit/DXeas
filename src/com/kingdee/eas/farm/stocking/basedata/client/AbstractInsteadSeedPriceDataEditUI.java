/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

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
public abstract class AbstractInsteadSeedPriceDataEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractInsteadSeedPriceDataEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contremark;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmaterial;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteffectDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunEffectDate;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPaneremark;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtremark;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtmaterial;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtprice;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkeffectDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkunEffectDate;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtPriceEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtPriceEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtRange;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtRange_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton mBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem tBtnUnAudit;
    protected com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractInsteadSeedPriceDataEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractInsteadSeedPriceDataEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
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
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contremark = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmaterial = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteffectDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunEffectDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.scrollPaneremark = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtremark = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.prmtmaterial = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtprice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkeffectDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkunEffectDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtPriceEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtRange = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contremark.setName("contremark");
        this.contmaterial.setName("contmaterial");
        this.contbaseStatus.setName("contbaseStatus");
        this.contprice.setName("contprice");
        this.conteffectDate.setName("conteffectDate");
        this.contcompany.setName("contcompany");
        this.contunEffectDate.setName("contunEffectDate");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.scrollPaneremark.setName("scrollPaneremark");
        this.txtremark.setName("txtremark");
        this.prmtmaterial.setName("prmtmaterial");
        this.baseStatus.setName("baseStatus");
        this.txtprice.setName("txtprice");
        this.pkeffectDate.setName("pkeffectDate");
        this.prmtcompany.setName("prmtcompany");
        this.pkunEffectDate.setName("pkunEffectDate");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kdtPriceEntry.setName("kdtPriceEntry");
        this.kdtRange.setName("kdtRange");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer1.setVisible(false);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);		
        this.kDLabelContainer2.setVisible(false);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setVisible(false);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(false);
        // contremark		
        this.contremark.setBoundLabelText(resHelper.getString("contremark.boundLabelText"));		
        this.contremark.setBoundLabelLength(100);		
        this.contremark.setBoundLabelUnderline(true);		
        this.contremark.setVisible(true);
        // contmaterial		
        this.contmaterial.setBoundLabelText(resHelper.getString("contmaterial.boundLabelText"));		
        this.contmaterial.setBoundLabelLength(100);		
        this.contmaterial.setBoundLabelUnderline(true);		
        this.contmaterial.setVisible(false);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // contprice		
        this.contprice.setBoundLabelText(resHelper.getString("contprice.boundLabelText"));		
        this.contprice.setBoundLabelLength(100);		
        this.contprice.setBoundLabelUnderline(true);		
        this.contprice.setVisible(false);
        // conteffectDate		
        this.conteffectDate.setBoundLabelText(resHelper.getString("conteffectDate.boundLabelText"));		
        this.conteffectDate.setBoundLabelLength(100);		
        this.conteffectDate.setBoundLabelUnderline(true);		
        this.conteffectDate.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contunEffectDate		
        this.contunEffectDate.setBoundLabelText(resHelper.getString("contunEffectDate.boundLabelText"));		
        this.contunEffectDate.setBoundLabelLength(100);		
        this.contunEffectDate.setBoundLabelUnderline(true);		
        this.contunEffectDate.setVisible(true);
        // kDTabbedPane1
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName		
        this.txtName.setRequired(false);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // scrollPaneremark
        // txtremark		
        this.txtremark.setRequired(false);		
        this.txtremark.setMaxLength(200);
        // prmtmaterial		
        this.prmtmaterial.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmtmaterial.setEditable(true);		
        this.prmtmaterial.setDisplayFormat("$name$");		
        this.prmtmaterial.setEditFormat("$number$");		
        this.prmtmaterial.setCommitFormat("$number$");		
        this.prmtmaterial.setRequired(false);		
        this.prmtmaterial.setVisible(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // txtprice		
        this.txtprice.setHorizontalAlignment(2);		
        this.txtprice.setDataType(1);		
        this.txtprice.setSupportedEmpty(true);		
        this.txtprice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtprice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtprice.setPrecision(4);		
        this.txtprice.setRequired(false);		
        this.txtprice.setVisible(false);
        // pkeffectDate		
        this.pkeffectDate.setRequired(true);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // pkunEffectDate		
        this.pkunEffectDate.setRequired(true);
        // kDPanel1
        // kDPanel2
        // kdtPriceEntry
		String kdtPriceEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"materialNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"offerPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"limitPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol7\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialNum}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{offerPrice}</t:Cell><t:Cell>$Resource{limitPrice}</t:Cell><t:Cell>$Resource{price}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtPriceEntry.setFormatXml(resHelper.translateString("kdtPriceEntry",kdtPriceEntryStrXML));
        kdtPriceEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtPriceEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtPriceEntry.putBindContents("editData",new String[] {"seq","material","materialNum","model","unit","offerPrice","limitPrice","price"});


        this.kdtPriceEntry.checkParsed();
        final KDBizPromptBox kdtPriceEntry_material_PromptBox = new KDBizPromptBox();
        kdtPriceEntry_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtPriceEntry_material_PromptBox.setVisible(true);
        kdtPriceEntry_material_PromptBox.setEditable(true);
        kdtPriceEntry_material_PromptBox.setDisplayFormat("$number$");
        kdtPriceEntry_material_PromptBox.setEditFormat("$number$");
        kdtPriceEntry_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPriceEntry_material_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_material_PromptBox);
        this.kdtPriceEntry.getColumn("material").setEditor(kdtPriceEntry_material_CellEditor);
        ObjectValueRender kdtPriceEntry_material_OVR = new ObjectValueRender();
        kdtPriceEntry_material_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtPriceEntry.getColumn("material").setRenderer(kdtPriceEntry_material_OVR);
        KDTextField kdtPriceEntry_materialNum_TextField = new KDTextField();
        kdtPriceEntry_materialNum_TextField.setName("kdtPriceEntry_materialNum_TextField");
        kdtPriceEntry_materialNum_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtPriceEntry_materialNum_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_materialNum_TextField);
        this.kdtPriceEntry.getColumn("materialNum").setEditor(kdtPriceEntry_materialNum_CellEditor);
        KDTextField kdtPriceEntry_model_TextField = new KDTextField();
        kdtPriceEntry_model_TextField.setName("kdtPriceEntry_model_TextField");
        kdtPriceEntry_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtPriceEntry_model_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_model_TextField);
        this.kdtPriceEntry.getColumn("model").setEditor(kdtPriceEntry_model_CellEditor);
        final KDBizPromptBox kdtPriceEntry_unit_PromptBox = new KDBizPromptBox();
        kdtPriceEntry_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtPriceEntry_unit_PromptBox.setVisible(true);
        kdtPriceEntry_unit_PromptBox.setEditable(true);
        kdtPriceEntry_unit_PromptBox.setDisplayFormat("$number$");
        kdtPriceEntry_unit_PromptBox.setEditFormat("$number$");
        kdtPriceEntry_unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPriceEntry_unit_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_unit_PromptBox);
        this.kdtPriceEntry.getColumn("unit").setEditor(kdtPriceEntry_unit_CellEditor);
        ObjectValueRender kdtPriceEntry_unit_OVR = new ObjectValueRender();
        kdtPriceEntry_unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtPriceEntry.getColumn("unit").setRenderer(kdtPriceEntry_unit_OVR);
        KDFormattedTextField kdtPriceEntry_offerPrice_TextField = new KDFormattedTextField();
        kdtPriceEntry_offerPrice_TextField.setName("kdtPriceEntry_offerPrice_TextField");
        kdtPriceEntry_offerPrice_TextField.setVisible(true);
        kdtPriceEntry_offerPrice_TextField.setEditable(true);
        kdtPriceEntry_offerPrice_TextField.setHorizontalAlignment(2);
        kdtPriceEntry_offerPrice_TextField.setDataType(1);
        	kdtPriceEntry_offerPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPriceEntry_offerPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPriceEntry_offerPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPriceEntry_offerPrice_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_offerPrice_TextField);
        this.kdtPriceEntry.getColumn("offerPrice").setEditor(kdtPriceEntry_offerPrice_CellEditor);
        KDFormattedTextField kdtPriceEntry_limitPrice_TextField = new KDFormattedTextField();
        kdtPriceEntry_limitPrice_TextField.setName("kdtPriceEntry_limitPrice_TextField");
        kdtPriceEntry_limitPrice_TextField.setVisible(true);
        kdtPriceEntry_limitPrice_TextField.setEditable(true);
        kdtPriceEntry_limitPrice_TextField.setHorizontalAlignment(2);
        kdtPriceEntry_limitPrice_TextField.setDataType(1);
        	kdtPriceEntry_limitPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPriceEntry_limitPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPriceEntry_limitPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPriceEntry_limitPrice_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_limitPrice_TextField);
        this.kdtPriceEntry.getColumn("limitPrice").setEditor(kdtPriceEntry_limitPrice_CellEditor);
        KDFormattedTextField kdtPriceEntry_price_TextField = new KDFormattedTextField();
        kdtPriceEntry_price_TextField.setName("kdtPriceEntry_price_TextField");
        kdtPriceEntry_price_TextField.setVisible(true);
        kdtPriceEntry_price_TextField.setEditable(true);
        kdtPriceEntry_price_TextField.setHorizontalAlignment(2);
        kdtPriceEntry_price_TextField.setDataType(1);
        	kdtPriceEntry_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPriceEntry_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPriceEntry_price_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPriceEntry_price_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_price_TextField);
        this.kdtPriceEntry.getColumn("price").setEditor(kdtPriceEntry_price_CellEditor);
        // kdtRange
		String kdtRangeStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"company\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"supplier\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{company}</t:Cell><t:Cell>$Resource{supplier}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtRange.setFormatXml(resHelper.translateString("kdtRange",kdtRangeStrXML));

                this.kdtRange.putBindContents("editData",new String[] {"seq","company","supplier"});


        this.kdtRange.checkParsed();
        final KDBizPromptBox kdtRange_company_PromptBox = new KDBizPromptBox();
        kdtRange_company_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct");
        kdtRange_company_PromptBox.setVisible(true);
        kdtRange_company_PromptBox.setEditable(true);
        kdtRange_company_PromptBox.setDisplayFormat("$number$");
        kdtRange_company_PromptBox.setEditFormat("$number$");
        kdtRange_company_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtRange_company_CellEditor = new KDTDefaultCellEditor(kdtRange_company_PromptBox);
        this.kdtRange.getColumn("company").setEditor(kdtRange_company_CellEditor);
        ObjectValueRender kdtRange_company_OVR = new ObjectValueRender();
        kdtRange_company_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtRange.getColumn("company").setRenderer(kdtRange_company_OVR);
        final KDBizPromptBox kdtRange_supplier_PromptBox = new KDBizPromptBox();
        kdtRange_supplier_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7SupplierDefaultQuery");
        kdtRange_supplier_PromptBox.setVisible(true);
        kdtRange_supplier_PromptBox.setEditable(true);
        kdtRange_supplier_PromptBox.setDisplayFormat("$number$");
        kdtRange_supplier_PromptBox.setEditFormat("$number$");
        kdtRange_supplier_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtRange_supplier_CellEditor = new KDTDefaultCellEditor(kdtRange_supplier_PromptBox);
        this.kdtRange.getColumn("supplier").setEditor(kdtRange_supplier_CellEditor);
        ObjectValueRender kdtRange_supplier_OVR = new ObjectValueRender();
        kdtRange_supplier_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtRange.getColumn("supplier").setRenderer(kdtRange_supplier_OVR);
        // mBtnAudit
        this.mBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnAudit.setText(resHelper.getString("mBtnAudit.text"));
        // mBtnUnAudit
        this.mBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnUnAudit.setText(resHelper.getString("mBtnUnAudit.text"));
        // tBtnAudit
        this.tBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnAudit.setText(resHelper.getString("tBtnAudit.text"));
        // tBtnUnAudit
        this.tBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnUnAudit.setText(resHelper.getString("tBtnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,txtDescription,txtSimpleName,txtremark,prmtmaterial,baseStatus,txtprice,pkeffectDate,prmtcompany,pkunEffectDate,kdtPriceEntry,kdtRange}));
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
        this.setBounds(new Rectangle(0, 0, 823, 411));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 823, 411));
        kDLabelContainer1.setBounds(new Rectangle(851, 105, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(851, 105, 270, 19, 0));
        kDLabelContainer2.setBounds(new Rectangle(846, 133, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(846, 133, 270, 19, 0));
        kDLabelContainer3.setBounds(new Rectangle(862, 165, 270, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(862, 165, 270, 19, 0));
        kDLabelContainer4.setBounds(new Rectangle(846, 191, 270, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(846, 191, 270, 19, 0));
        contremark.setBounds(new Rectangle(30, 87, 762, 23));
        this.add(contremark, new KDLayout.Constraints(30, 87, 762, 23, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmaterial.setBounds(new Rectangle(843, 41, 270, 19));
        this.add(contmaterial, new KDLayout.Constraints(843, 41, 270, 19, 0));
        contbaseStatus.setBounds(new Rectangle(441, 19, 350, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(441, 19, 350, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contprice.setBounds(new Rectangle(843, 66, 270, 19));
        this.add(contprice, new KDLayout.Constraints(843, 66, 270, 19, 0));
        conteffectDate.setBounds(new Rectangle(30, 54, 350, 19));
        this.add(conteffectDate, new KDLayout.Constraints(30, 54, 350, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(30, 19, 350, 19));
        this.add(contcompany, new KDLayout.Constraints(30, 19, 350, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contunEffectDate.setBounds(new Rectangle(441, 54, 350, 19));
        this.add(contunEffectDate, new KDLayout.Constraints(441, 54, 350, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(15, 124, 783, 274));
        this.add(kDTabbedPane1, new KDLayout.Constraints(15, 124, 783, 274, 0));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contremark
        contremark.setBoundEditor(scrollPaneremark);
        //scrollPaneremark
        scrollPaneremark.getViewport().add(txtremark, null);
        //contmaterial
        contmaterial.setBoundEditor(prmtmaterial);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contprice
        contprice.setBoundEditor(txtprice);
        //conteffectDate
        conteffectDate.setBoundEditor(pkeffectDate);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contunEffectDate
        contunEffectDate.setBoundEditor(pkunEffectDate);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(null);        kdtPriceEntry.setBounds(new Rectangle(2, 2, 774, 236));
        kdtPriceEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtPriceEntry,new com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataPriceEntryInfo(),null,false);
        kDPanel1.add(kdtPriceEntry_detailPanel, null);
        //kDPanel2
        kDPanel2.setLayout(null);        kdtRange.setBounds(new Rectangle(3, 3, 774, 239));
        kdtRange_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtRange,new com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataRangeInfo(),null,false);
        kDPanel2.add(kdtRange_detailPanel, null);

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
        this.menuBar.add(menuTool);
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
        //menuBiz
        menuBiz.add(tBtnAudit);
        menuBiz.add(tBtnUnAudit);
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        //menuTool
        menuTool.add(menuItemMsgFormat);
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
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
        this.toolBar.add(btnReset);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnSave);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
        this.toolBar.add(mBtnAudit);
        this.toolBar.add(mBtnUnAudit);
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
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("remark", String.class, this.txtremark, "text");
		dataBinder.registerBinding("material", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmtmaterial, "data");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("price", java.math.BigDecimal.class, this.txtprice, "value");
		dataBinder.registerBinding("effectDate", java.util.Date.class, this.pkeffectDate, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("unEffectDate", java.util.Date.class, this.pkunEffectDate, "value");
		dataBinder.registerBinding("PriceEntry.seq", int.class, this.kdtPriceEntry, "seq.text");
		dataBinder.registerBinding("PriceEntry", com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataPriceEntryInfo.class, this.kdtPriceEntry, "userObject");
		dataBinder.registerBinding("PriceEntry.material", java.lang.Object.class, this.kdtPriceEntry, "material.text");
		dataBinder.registerBinding("PriceEntry.model", String.class, this.kdtPriceEntry, "model.text");
		dataBinder.registerBinding("PriceEntry.unit", java.lang.Object.class, this.kdtPriceEntry, "unit.text");
		dataBinder.registerBinding("PriceEntry.price", java.math.BigDecimal.class, this.kdtPriceEntry, "price.text");
		dataBinder.registerBinding("PriceEntry.materialNum", String.class, this.kdtPriceEntry, "materialNum.text");
		dataBinder.registerBinding("PriceEntry.offerPrice", java.math.BigDecimal.class, this.kdtPriceEntry, "offerPrice.text");
		dataBinder.registerBinding("PriceEntry.limitPrice", java.math.BigDecimal.class, this.kdtPriceEntry, "limitPrice.text");
		dataBinder.registerBinding("Range.seq", int.class, this.kdtRange, "seq.text");
		dataBinder.registerBinding("Range", com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataRangeInfo.class, this.kdtRange, "userObject");
		dataBinder.registerBinding("Range.company", java.lang.Object.class, this.kdtRange, "company.text");
		dataBinder.registerBinding("Range.supplier", java.lang.Object.class, this.kdtRange, "supplier.text");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtSimpleName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtSimpleName, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtName, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtDescription, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtNumber, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtSimpleName, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.stocking.basedata.app.InsteadSeedPriceDataEditUIHandler";
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
        this.txtName.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataInfo)ov;
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
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("price", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("effectDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unEffectDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.price", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.materialNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.offerPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.limitPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Range.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Range", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Range.company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Range.supplier", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(false);
		            this.txtDescription.setEnabled(false);
		            this.txtNumber.setEnabled(false);
		            this.txtSimpleName.setEnabled(false);
        }
    }


    /**
     * output kdtPriceEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtPriceEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("material".equalsIgnoreCase(kdtPriceEntry.getColumn(colIndex).getKey())) {
kdtPriceEntry.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtPriceEntry.getCell(rowIndex,"material").getValue(),"model")));

}

    if ("material".equalsIgnoreCase(kdtPriceEntry.getColumn(colIndex).getKey())) {
kdtPriceEntry.getCell(rowIndex,"materialNum").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtPriceEntry.getCell(rowIndex,"material").getValue(),"number")));

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
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("remark"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("material.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("material.id"));
        	sic.add(new SelectorItemInfo("material.number"));
        	sic.add(new SelectorItemInfo("material.name"));
		}
        sic.add(new SelectorItemInfo("baseStatus"));
        sic.add(new SelectorItemInfo("price"));
        sic.add(new SelectorItemInfo("effectDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("unEffectDate"));
    	sic.add(new SelectorItemInfo("PriceEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PriceEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PriceEntry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("PriceEntry.material.id"));
			sic.add(new SelectorItemInfo("PriceEntry.material.name"));
        	sic.add(new SelectorItemInfo("PriceEntry.material.number"));
		}
    	sic.add(new SelectorItemInfo("PriceEntry.model"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PriceEntry.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("PriceEntry.unit.id"));
			sic.add(new SelectorItemInfo("PriceEntry.unit.name"));
        	sic.add(new SelectorItemInfo("PriceEntry.unit.number"));
		}
    	sic.add(new SelectorItemInfo("PriceEntry.price"));
    	sic.add(new SelectorItemInfo("PriceEntry.materialNum"));
    	sic.add(new SelectorItemInfo("PriceEntry.offerPrice"));
    	sic.add(new SelectorItemInfo("PriceEntry.limitPrice"));
    	sic.add(new SelectorItemInfo("Range.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Range.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Range.company.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Range.company.id"));
			sic.add(new SelectorItemInfo("Range.company.name"));
        	sic.add(new SelectorItemInfo("Range.company.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Range.supplier.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Range.supplier.id"));
			sic.add(new SelectorItemInfo("Range.supplier.name"));
        	sic.add(new SelectorItemInfo("Range.supplier.number"));
		}
        return sic;
    }        
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractInsteadSeedPriceDataEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractInsteadSeedPriceDataEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.basedata.client", "InsteadSeedPriceDataEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.stocking.basedata.client.InsteadSeedPriceDataEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkeffectDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkunEffectDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"失效日期"});
		}
		for (int i=0,n=kdtPriceEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtPriceEntry.getCell(i,"material").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"物料名称"});
			}
		}
		for (int i=0,n=kdtPriceEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtPriceEntry.getCell(i,"price").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"执行价格"});
			}
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtPriceEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}