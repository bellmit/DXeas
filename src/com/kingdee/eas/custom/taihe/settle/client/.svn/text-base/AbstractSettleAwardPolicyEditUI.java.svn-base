/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.settle.client;

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
public abstract class AbstractSettleAwardPolicyEditUI extends com.kingdee.eas.custom.wlhllicensemanager.client.WlhlBaseEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSettleAwardPolicyEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteffectDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunEffectDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenSzCoff;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDAOImpl;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtAwardEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtAwardEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contflooredContractType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtflooredContractType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthedgingContractType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcomapnyProp;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsupplierProp;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmthedgingContractType;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcomapnyProp;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsupplierProp;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkeffectDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkunEffectDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcontractType;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenSzCoff;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDAOImpl;
    protected com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractSettleAwardPolicyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSettleAwardPolicyEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.conteffectDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunEffectDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontractType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenSzCoff = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDAOImpl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtAwardEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contflooredContractType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtflooredContractType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.conthedgingContractType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcomapnyProp = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsupplierProp = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmthedgingContractType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtcomapnyProp = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsupplierProp = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkeffectDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkunEffectDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcontractType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtchickenSzCoff = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtDAOImpl = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.contcompany.setName("contcompany");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.conteffectDate.setName("conteffectDate");
        this.contunEffectDate.setName("contunEffectDate");
        this.contcontractType.setName("contcontractType");
        this.contchickenSzCoff.setName("contchickenSzCoff");
        this.contDAOImpl.setName("contDAOImpl");
        this.prmtcompany.setName("prmtcompany");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kdtEntry.setName("kdtEntry");
        this.kdtAwardEntry.setName("kdtAwardEntry");
        this.contflooredContractType.setName("contflooredContractType");
        this.prmtflooredContractType.setName("prmtflooredContractType");
        this.conthedgingContractType.setName("conthedgingContractType");
        this.contcomapnyProp.setName("contcomapnyProp");
        this.contsupplierProp.setName("contsupplierProp");
        this.prmthedgingContractType.setName("prmthedgingContractType");
        this.txtcomapnyProp.setName("txtcomapnyProp");
        this.txtsupplierProp.setName("txtsupplierProp");
        this.pkeffectDate.setName("pkeffectDate");
        this.pkunEffectDate.setName("pkunEffectDate");
        this.prmtcontractType.setName("prmtcontractType");
        this.txtchickenSzCoff.setName("txtchickenSzCoff");
        this.txtDAOImpl.setName("txtDAOImpl");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setVisible(false);		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(false);		
        this.contapprover.setBoundLabelText(resHelper.getString("contapprover.boundLabelText"));		
        this.contapprover.setBoundLabelLength(100);		
        this.contapprover.setBoundLabelUnderline(true);		
        this.contapprover.setVisible(true);		
        this.contapproveTime.setBoundLabelText(resHelper.getString("contapproveTime.boundLabelText"));		
        this.contapproveTime.setBoundLabelLength(100);		
        this.contapproveTime.setBoundLabelUnderline(true);		
        this.contapproveTime.setVisible(true);		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);		
        this.contcreator.setBoundLabelText(resHelper.getString("contcreator.boundLabelText"));		
        this.contcreator.setBoundLabelLength(100);		
        this.contcreator.setBoundLabelUnderline(true);		
        this.contcreator.setVisible(true);		
        this.contcreateTime.setBoundLabelText(resHelper.getString("contcreateTime.boundLabelText"));		
        this.contcreateTime.setBoundLabelLength(100);		
        this.contcreateTime.setBoundLabelUnderline(true);		
        this.contcreateTime.setVisible(true);		
        this.txtNumber.setMaxLength(80);		
        this.txtName.setRequired(true);		
        this.txtSimpleName.setMaxLength(80);		
        this.txtSimpleName.setVisible(false);		
        this.txtDescription.setVisible(false);		
        this.prmtapprover.setEditable(true);		
        this.prmtapprover.setDisplayFormat("$number$");		
        this.prmtapprover.setEditFormat("$number$");		
        this.prmtapprover.setCommitFormat("$number$");		
        this.prmtapprover.setRequired(false);		
        this.prmtapprover.setEnabled(false);		
        this.pkapproveTime.setRequired(false);		
        this.pkapproveTime.setEnabled(false);		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.prmtcreator.setEditable(true);		
        this.prmtcreator.setDisplayFormat("$name$");		
        this.prmtcreator.setEditFormat("$number$");		
        this.prmtcreator.setCommitFormat("$number$");		
        this.prmtcreator.setRequired(false);		
        this.prmtcreator.setEnabled(false);		
        this.pkcreateTime.setRequired(false);		
        this.pkcreateTime.setEnabled(false);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // kDTabbedPane1
        // conteffectDate		
        this.conteffectDate.setBoundLabelText(resHelper.getString("conteffectDate.boundLabelText"));		
        this.conteffectDate.setBoundLabelLength(100);		
        this.conteffectDate.setBoundLabelUnderline(true);		
        this.conteffectDate.setVisible(true);
        // contunEffectDate		
        this.contunEffectDate.setBoundLabelText(resHelper.getString("contunEffectDate.boundLabelText"));		
        this.contunEffectDate.setBoundLabelLength(100);		
        this.contunEffectDate.setBoundLabelUnderline(true);		
        this.contunEffectDate.setVisible(true);
        // contcontractType		
        this.contcontractType.setBoundLabelText(resHelper.getString("contcontractType.boundLabelText"));		
        this.contcontractType.setBoundLabelLength(100);		
        this.contcontractType.setBoundLabelUnderline(true);		
        this.contcontractType.setVisible(true);
        // contchickenSzCoff		
        this.contchickenSzCoff.setBoundLabelText(resHelper.getString("contchickenSzCoff.boundLabelText"));		
        this.contchickenSzCoff.setBoundLabelLength(100);		
        this.contchickenSzCoff.setBoundLabelUnderline(true);		
        this.contchickenSzCoff.setVisible(true);
        // contDAOImpl		
        this.contDAOImpl.setBoundLabelText(resHelper.getString("contDAOImpl.boundLabelText"));		
        this.contDAOImpl.setBoundLabelLength(100);		
        this.contDAOImpl.setBoundLabelUnderline(true);		
        this.contDAOImpl.setVisible(true);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // kDPanel1
        // kDPanel2
        // kDPanel3
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"floor\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"up\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"amt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{floor}</t:Cell><t:Cell>$Resource{up}</t:Cell><t:Cell>$Resource{amt}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntry.setFormatXml(resHelper.translateString("kdtEntry",kdtEntryStrXML));

                this.kdtEntry.putBindContents("editData",new String[] {"seq","floor","up","amt"});


        this.kdtEntry.checkParsed();
        KDFormattedTextField kdtEntry_floor_TextField = new KDFormattedTextField();
        kdtEntry_floor_TextField.setName("kdtEntry_floor_TextField");
        kdtEntry_floor_TextField.setVisible(true);
        kdtEntry_floor_TextField.setEditable(true);
        kdtEntry_floor_TextField.setHorizontalAlignment(2);
        kdtEntry_floor_TextField.setDataType(1);
        	kdtEntry_floor_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_floor_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_floor_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_floor_CellEditor = new KDTDefaultCellEditor(kdtEntry_floor_TextField);
        this.kdtEntry.getColumn("floor").setEditor(kdtEntry_floor_CellEditor);
        KDFormattedTextField kdtEntry_up_TextField = new KDFormattedTextField();
        kdtEntry_up_TextField.setName("kdtEntry_up_TextField");
        kdtEntry_up_TextField.setVisible(true);
        kdtEntry_up_TextField.setEditable(true);
        kdtEntry_up_TextField.setHorizontalAlignment(2);
        kdtEntry_up_TextField.setDataType(1);
        	kdtEntry_up_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_up_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_up_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_up_CellEditor = new KDTDefaultCellEditor(kdtEntry_up_TextField);
        this.kdtEntry.getColumn("up").setEditor(kdtEntry_up_CellEditor);
        KDFormattedTextField kdtEntry_amt_TextField = new KDFormattedTextField();
        kdtEntry_amt_TextField.setName("kdtEntry_amt_TextField");
        kdtEntry_amt_TextField.setVisible(true);
        kdtEntry_amt_TextField.setEditable(true);
        kdtEntry_amt_TextField.setHorizontalAlignment(2);
        kdtEntry_amt_TextField.setDataType(1);
        	kdtEntry_amt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_amt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_amt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_amt_CellEditor = new KDTDefaultCellEditor(kdtEntry_amt_TextField);
        this.kdtEntry.getColumn("amt").setEditor(kdtEntry_amt_CellEditor);
        // kdtAwardEntry
		String kdtAwardEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"avgWgtLower\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" t:styleID=\"sCol1\" /><t:Column t:key=\"avgWgtUpper\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" t:styleID=\"sCol2\" /><t:Column t:key=\"awardAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{avgWgtLower}</t:Cell><t:Cell>$Resource{avgWgtUpper}</t:Cell><t:Cell>$Resource{awardAmt}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtAwardEntry.setFormatXml(resHelper.translateString("kdtAwardEntry",kdtAwardEntryStrXML));

                this.kdtAwardEntry.putBindContents("editData",new String[] {"seq","avgWgtLower","avgWgtUpper","awardAmt"});


        this.kdtAwardEntry.checkParsed();
        KDFormattedTextField kdtAwardEntry_avgWgtLower_TextField = new KDFormattedTextField();
        kdtAwardEntry_avgWgtLower_TextField.setName("kdtAwardEntry_avgWgtLower_TextField");
        kdtAwardEntry_avgWgtLower_TextField.setVisible(true);
        kdtAwardEntry_avgWgtLower_TextField.setEditable(true);
        kdtAwardEntry_avgWgtLower_TextField.setHorizontalAlignment(2);
        kdtAwardEntry_avgWgtLower_TextField.setDataType(1);
        	kdtAwardEntry_avgWgtLower_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAwardEntry_avgWgtLower_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAwardEntry_avgWgtLower_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAwardEntry_avgWgtLower_CellEditor = new KDTDefaultCellEditor(kdtAwardEntry_avgWgtLower_TextField);
        this.kdtAwardEntry.getColumn("avgWgtLower").setEditor(kdtAwardEntry_avgWgtLower_CellEditor);
        KDFormattedTextField kdtAwardEntry_avgWgtUpper_TextField = new KDFormattedTextField();
        kdtAwardEntry_avgWgtUpper_TextField.setName("kdtAwardEntry_avgWgtUpper_TextField");
        kdtAwardEntry_avgWgtUpper_TextField.setVisible(true);
        kdtAwardEntry_avgWgtUpper_TextField.setEditable(true);
        kdtAwardEntry_avgWgtUpper_TextField.setHorizontalAlignment(2);
        kdtAwardEntry_avgWgtUpper_TextField.setDataType(1);
        	kdtAwardEntry_avgWgtUpper_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAwardEntry_avgWgtUpper_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAwardEntry_avgWgtUpper_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAwardEntry_avgWgtUpper_CellEditor = new KDTDefaultCellEditor(kdtAwardEntry_avgWgtUpper_TextField);
        this.kdtAwardEntry.getColumn("avgWgtUpper").setEditor(kdtAwardEntry_avgWgtUpper_CellEditor);
        KDFormattedTextField kdtAwardEntry_awardAmt_TextField = new KDFormattedTextField();
        kdtAwardEntry_awardAmt_TextField.setName("kdtAwardEntry_awardAmt_TextField");
        kdtAwardEntry_awardAmt_TextField.setVisible(true);
        kdtAwardEntry_awardAmt_TextField.setEditable(true);
        kdtAwardEntry_awardAmt_TextField.setHorizontalAlignment(2);
        kdtAwardEntry_awardAmt_TextField.setDataType(1);
        	kdtAwardEntry_awardAmt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAwardEntry_awardAmt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAwardEntry_awardAmt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAwardEntry_awardAmt_CellEditor = new KDTDefaultCellEditor(kdtAwardEntry_awardAmt_TextField);
        this.kdtAwardEntry.getColumn("awardAmt").setEditor(kdtAwardEntry_awardAmt_CellEditor);
        // contflooredContractType		
        this.contflooredContractType.setBoundLabelText(resHelper.getString("contflooredContractType.boundLabelText"));		
        this.contflooredContractType.setBoundLabelLength(100);		
        this.contflooredContractType.setBoundLabelUnderline(true);		
        this.contflooredContractType.setVisible(true);
        // prmtflooredContractType		
        this.prmtflooredContractType.setQueryInfo("com.kingdee.eas.custom.signwasthetable.app.ContractTypeQuery");		
        this.prmtflooredContractType.setVisible(true);		
        this.prmtflooredContractType.setEditable(true);		
        this.prmtflooredContractType.setDisplayFormat("$name$");		
        this.prmtflooredContractType.setEditFormat("$number$");		
        this.prmtflooredContractType.setCommitFormat("$number$");		
        this.prmtflooredContractType.setRequired(true);
        // conthedgingContractType		
        this.conthedgingContractType.setBoundLabelText(resHelper.getString("conthedgingContractType.boundLabelText"));		
        this.conthedgingContractType.setBoundLabelLength(100);		
        this.conthedgingContractType.setBoundLabelUnderline(true);		
        this.conthedgingContractType.setVisible(true);
        // contcomapnyProp		
        this.contcomapnyProp.setBoundLabelText(resHelper.getString("contcomapnyProp.boundLabelText"));		
        this.contcomapnyProp.setBoundLabelLength(120);		
        this.contcomapnyProp.setBoundLabelUnderline(true);		
        this.contcomapnyProp.setVisible(true);
        // contsupplierProp		
        this.contsupplierProp.setBoundLabelText(resHelper.getString("contsupplierProp.boundLabelText"));		
        this.contsupplierProp.setBoundLabelLength(130);		
        this.contsupplierProp.setBoundLabelUnderline(true);		
        this.contsupplierProp.setVisible(true);
        // prmthedgingContractType		
        this.prmthedgingContractType.setQueryInfo("com.kingdee.eas.custom.signwasthetable.app.ContractTypeQuery");		
        this.prmthedgingContractType.setEditable(true);		
        this.prmthedgingContractType.setDisplayFormat("$name$");		
        this.prmthedgingContractType.setEditFormat("$number$");		
        this.prmthedgingContractType.setCommitFormat("$number$");		
        this.prmthedgingContractType.setRequired(true);
        // txtcomapnyProp		
        this.txtcomapnyProp.setVisible(true);		
        this.txtcomapnyProp.setHorizontalAlignment(2);		
        this.txtcomapnyProp.setDataType(1);		
        this.txtcomapnyProp.setSupportedEmpty(true);		
        this.txtcomapnyProp.setMinimumValue( new java.math.BigDecimal("-999.999"));		
        this.txtcomapnyProp.setMaximumValue( new java.math.BigDecimal("999.999"));		
        this.txtcomapnyProp.setPrecision(3);		
        this.txtcomapnyProp.setRequired(false);
        // txtsupplierProp		
        this.txtsupplierProp.setVisible(true);		
        this.txtsupplierProp.setHorizontalAlignment(2);		
        this.txtsupplierProp.setDataType(1);		
        this.txtsupplierProp.setSupportedEmpty(true);		
        this.txtsupplierProp.setMinimumValue( new java.math.BigDecimal("-999.999"));		
        this.txtsupplierProp.setMaximumValue( new java.math.BigDecimal("999.999"));		
        this.txtsupplierProp.setPrecision(3);		
        this.txtsupplierProp.setRequired(false);
        // pkeffectDate		
        this.pkeffectDate.setRequired(true);
        // pkunEffectDate		
        this.pkunEffectDate.setRequired(true);
        // prmtcontractType		
        this.prmtcontractType.setQueryInfo("com.kingdee.eas.custom.signwasthetable.app.ContractTypeQuery");		
        this.prmtcontractType.setEditable(true);		
        this.prmtcontractType.setDisplayFormat("$name$");		
        this.prmtcontractType.setEditFormat("$number$");		
        this.prmtcontractType.setCommitFormat("$number$");		
        this.prmtcontractType.setRequired(true);
        // txtchickenSzCoff		
        this.txtchickenSzCoff.setVisible(true);		
        this.txtchickenSzCoff.setHorizontalAlignment(2);		
        this.txtchickenSzCoff.setDataType(1);		
        this.txtchickenSzCoff.setSupportedEmpty(true);		
        this.txtchickenSzCoff.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenSzCoff.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenSzCoff.setPrecision(4);		
        this.txtchickenSzCoff.setRequired(false);
        // txtDAOImpl		
        this.txtDAOImpl.setVisible(true);		
        this.txtDAOImpl.setHorizontalAlignment(2);		
        this.txtDAOImpl.setMaxLength(200);		
        this.txtDAOImpl.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtapprover,pkapproveTime,baseStatus,txtName,txtNumber,txtDescription,txtSimpleName,prmtcreator,pkcreateTime,prmtcompany,pkeffectDate,pkunEffectDate,prmtcontractType,prmthedgingContractType,kdtAwardEntry,kdtEntry,txtcomapnyProp,txtsupplierProp,prmtflooredContractType,txtchickenSzCoff,txtDAOImpl}));
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
        this.setBounds(new Rectangle(0, 0, 633, 467));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(18, 16, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(338, 16, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(796, 52, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(797, 90, 270, 19));
        this.add(kDLabelContainer4, null);
        contapprover.setBounds(new Rectangle(338, 397, 270, 19));
        this.add(contapprover, null);
        contapproveTime.setBounds(new Rectangle(338, 431, 270, 19));
        this.add(contapproveTime, null);
        contbaseStatus.setBounds(new Rectangle(338, 43, 270, 19));
        this.add(contbaseStatus, null);
        contcreator.setBounds(new Rectangle(20, 431, 270, 19));
        this.add(contcreator, null);
        contcreateTime.setBounds(new Rectangle(20, 397, 270, 19));
        this.add(contcreateTime, null);
        contcompany.setBounds(new Rectangle(18, 43, 270, 19));
        this.add(contcompany, null);
        kDTabbedPane1.setBounds(new Rectangle(13, 152, 603, 233));
        this.add(kDTabbedPane1, null);
        conteffectDate.setBounds(new Rectangle(18, 70, 270, 19));
        this.add(conteffectDate, null);
        contunEffectDate.setBounds(new Rectangle(338, 70, 270, 19));
        this.add(contunEffectDate, null);
        contcontractType.setBounds(new Rectangle(18, 97, 270, 19));
        this.add(contcontractType, null);
        contchickenSzCoff.setBounds(new Rectangle(338, 97, 270, 19));
        this.add(contchickenSzCoff, null);
        contDAOImpl.setBounds(new Rectangle(18, 125, 589, 19));
        this.add(contDAOImpl, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contapprover
        contapprover.setBoundEditor(prmtapprover);
        //contapproveTime
        contapproveTime.setBoundEditor(pkapproveTime);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contcreator
        contcreator.setBoundEditor(prmtcreator);
        //contcreateTime
        contcreateTime.setBoundEditor(pkcreateTime);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        //kDPanel1
        kDPanel1.setLayout(null);        kdtEntry.setBounds(new Rectangle(1, 2, 598, 216));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyEntryInfo(),null,false);
        kDPanel1.add(kdtEntry_detailPanel, null);
        //kDPanel2
        kDPanel2.setLayout(null);        kdtAwardEntry.setBounds(new Rectangle(2, 40, 595, 177));
        kdtAwardEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtAwardEntry,new com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyAwardEntryInfo(),null,false);
        kDPanel2.add(kdtAwardEntry_detailPanel, null);
        contflooredContractType.setBounds(new Rectangle(9, 9, 270, 19));
        kDPanel2.add(contflooredContractType, null);
        //contflooredContractType
        contflooredContractType.setBoundEditor(prmtflooredContractType);
        //kDPanel3
        kDPanel3.setLayout(null);        conthedgingContractType.setBounds(new Rectangle(12, 9, 270, 19));
        kDPanel3.add(conthedgingContractType, null);
        contcomapnyProp.setBounds(new Rectangle(12, 46, 270, 19));
        kDPanel3.add(contcomapnyProp, null);
        contsupplierProp.setBounds(new Rectangle(320, 46, 270, 19));
        kDPanel3.add(contsupplierProp, null);
        //conthedgingContractType
        conthedgingContractType.setBoundEditor(prmthedgingContractType);
        //contcomapnyProp
        contcomapnyProp.setBoundEditor(txtcomapnyProp);
        //contsupplierProp
        contsupplierProp.setBoundEditor(txtsupplierProp);
        //conteffectDate
        conteffectDate.setBoundEditor(pkeffectDate);
        //contunEffectDate
        contunEffectDate.setBoundEditor(pkunEffectDate);
        //contcontractType
        contcontractType.setBoundEditor(prmtcontractType);
        //contchickenSzCoff
        contchickenSzCoff.setBoundEditor(txtchickenSzCoff);
        //contDAOImpl
        contDAOImpl.setBoundEditor(txtDAOImpl);

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
        menuBiz.add(mBtnApprove);
        menuBiz.add(mBtnUnApprove);
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
        this.toolBar.add(tBtnApprove);
        this.toolBar.add(tBtnUnApprove);
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
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("approver", com.kingdee.eas.base.permission.UserInfo.class, this.prmtapprover, "data");
		dataBinder.registerBinding("approveTime", java.util.Date.class, this.pkapproveTime, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtcreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.pkcreateTime, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.floor", java.math.BigDecimal.class, this.kdtEntry, "floor.text");
		dataBinder.registerBinding("Entry.up", java.math.BigDecimal.class, this.kdtEntry, "up.text");
		dataBinder.registerBinding("Entry.amt", java.math.BigDecimal.class, this.kdtEntry, "amt.text");
		dataBinder.registerBinding("AwardEntry.seq", int.class, this.kdtAwardEntry, "seq.text");
		dataBinder.registerBinding("AwardEntry", com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyAwardEntryInfo.class, this.kdtAwardEntry, "userObject");
		dataBinder.registerBinding("AwardEntry.avgWgtUpper", java.math.BigDecimal.class, this.kdtAwardEntry, "avgWgtUpper.text");
		dataBinder.registerBinding("AwardEntry.avgWgtLower", java.math.BigDecimal.class, this.kdtAwardEntry, "avgWgtLower.text");
		dataBinder.registerBinding("AwardEntry.awardAmt", java.math.BigDecimal.class, this.kdtAwardEntry, "awardAmt.text");
		dataBinder.registerBinding("flooredContractType", com.kingdee.eas.custom.signwasthetable.ContractTypeInfo.class, this.prmtflooredContractType, "data");
		dataBinder.registerBinding("hedgingContractType", com.kingdee.eas.custom.signwasthetable.ContractTypeInfo.class, this.prmthedgingContractType, "data");
		dataBinder.registerBinding("comapnyProp", java.math.BigDecimal.class, this.txtcomapnyProp, "value");
		dataBinder.registerBinding("supplierProp", java.math.BigDecimal.class, this.txtsupplierProp, "value");
		dataBinder.registerBinding("effectDate", java.util.Date.class, this.pkeffectDate, "value");
		dataBinder.registerBinding("unEffectDate", java.util.Date.class, this.pkunEffectDate, "value");
		dataBinder.registerBinding("contractType", com.kingdee.eas.custom.signwasthetable.ContractTypeInfo.class, this.prmtcontractType, "data");
		dataBinder.registerBinding("chickenSzCoff", java.math.BigDecimal.class, this.txtchickenSzCoff, "value");
		dataBinder.registerBinding("DAOImpl", String.class, this.txtDAOImpl, "text");		
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
	    return "com.kingdee.eas.custom.taihe.settle.app.SettleAwardPolicyEditUIHandler";
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
        this.prmtapprover.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyInfo)ov;
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
		getValidateHelper().registerBindProperty("approver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("approveTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.floor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.up", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.amt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AwardEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AwardEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AwardEntry.avgWgtUpper", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AwardEntry.avgWgtLower", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AwardEntry.awardAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("flooredContractType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hedgingContractType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("comapnyProp", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("supplierProp", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("effectDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unEffectDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenSzCoff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DAOImpl", ValidateHelper.ON_SAVE);    		
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("approver.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("approver.id"));
        	sic.add(new SelectorItemInfo("approver.number"));
        	sic.add(new SelectorItemInfo("approver.name"));
		}
        sic.add(new SelectorItemInfo("approveTime"));
        sic.add(new SelectorItemInfo("baseStatus"));
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
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
    	sic.add(new SelectorItemInfo("Entry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("Entry.floor"));
    	sic.add(new SelectorItemInfo("Entry.up"));
    	sic.add(new SelectorItemInfo("Entry.amt"));
    	sic.add(new SelectorItemInfo("AwardEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AwardEntry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("AwardEntry.avgWgtUpper"));
    	sic.add(new SelectorItemInfo("AwardEntry.avgWgtLower"));
    	sic.add(new SelectorItemInfo("AwardEntry.awardAmt"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("flooredContractType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("flooredContractType.id"));
        	sic.add(new SelectorItemInfo("flooredContractType.number"));
        	sic.add(new SelectorItemInfo("flooredContractType.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("hedgingContractType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("hedgingContractType.id"));
        	sic.add(new SelectorItemInfo("hedgingContractType.number"));
        	sic.add(new SelectorItemInfo("hedgingContractType.name"));
		}
        sic.add(new SelectorItemInfo("comapnyProp"));
        sic.add(new SelectorItemInfo("supplierProp"));
        sic.add(new SelectorItemInfo("effectDate"));
        sic.add(new SelectorItemInfo("unEffectDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("contractType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("contractType.id"));
        	sic.add(new SelectorItemInfo("contractType.number"));
        	sic.add(new SelectorItemInfo("contractType.name"));
		}
        sic.add(new SelectorItemInfo("chickenSzCoff"));
        sic.add(new SelectorItemInfo("DAOImpl"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.taihe.settle.client", "SettleAwardPolicyEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.taihe.settle.client.SettleAwardPolicyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyInfo objectValue = new com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtflooredContractType.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"保底合同类别"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmthedgingContractType.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"保值合同类别"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkeffectDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"生效日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkunEffectDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"失效日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcontractType.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"合同类别"});
		}
			super.beforeStoreFields(arg0);
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