/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

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
public abstract class AbstractBasePriceAdjustPolicyEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBasePriceAdjustPolicyEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreed;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettleItem;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstandHenWeightLow;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstandHenWeightHign;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contremark;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBIMUDF0010;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBIMUDF0011;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBIMUDF0012;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel4;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator5;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contname;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreed;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkendDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsettleItem;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstandHenWeightLow;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstandHenWeightHign;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtremark;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtBIMUDF0010;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtBIMUDF0011;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtBIMUDF0012;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtname;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractBasePriceAdjustPolicyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBasePriceAdjustPolicyEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
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
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreed = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettleItem = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstandHenWeightLow = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstandHenWeightHign = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contremark = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.contBIMUDF0010 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabel2 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.contBIMUDF0011 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabel3 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.contBIMUDF0012 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabel4 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDSeparator5 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contname = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtbreed = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkbeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkendDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtsettleItem = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtstandHenWeightLow = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtstandHenWeightHign = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtremark = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtBIMUDF0010 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtBIMUDF0011 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtBIMUDF0012 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtname = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.contcompany.setName("contcompany");
        this.contbaseStatus.setName("contbaseStatus");
        this.contbreed.setName("contbreed");
        this.contbeginDate.setName("contbeginDate");
        this.contendDate.setName("contendDate");
        this.contsettleItem.setName("contsettleItem");
        this.contstandHenWeightLow.setName("contstandHenWeightLow");
        this.contstandHenWeightHign.setName("contstandHenWeightHign");
        this.contremark.setName("contremark");
        this.kDLabel1.setName("kDLabel1");
        this.contBIMUDF0010.setName("contBIMUDF0010");
        this.kDLabel2.setName("kDLabel2");
        this.contBIMUDF0011.setName("contBIMUDF0011");
        this.kDLabel3.setName("kDLabel3");
        this.contBIMUDF0012.setName("contBIMUDF0012");
        this.kDLabel4.setName("kDLabel4");
        this.kDSeparator5.setName("kDSeparator5");
        this.kdtEntry.setName("kdtEntry");
        this.contname.setName("contname");
        this.txtNumber.setName("txtNumber");
        this.prmtcompany.setName("prmtcompany");
        this.baseStatus.setName("baseStatus");
        this.prmtbreed.setName("prmtbreed");
        this.pkbeginDate.setName("pkbeginDate");
        this.pkendDate.setName("pkendDate");
        this.prmtsettleItem.setName("prmtsettleItem");
        this.txtstandHenWeightLow.setName("txtstandHenWeightLow");
        this.txtstandHenWeightHign.setName("txtstandHenWeightHign");
        this.txtremark.setName("txtremark");
        this.txtBIMUDF0010.setName("txtBIMUDF0010");
        this.txtBIMUDF0011.setName("txtBIMUDF0011");
        this.txtBIMUDF0012.setName("txtBIMUDF0012");
        this.txtname.setName("txtname");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // contbreed		
        this.contbreed.setBoundLabelText(resHelper.getString("contbreed.boundLabelText"));		
        this.contbreed.setBoundLabelLength(100);		
        this.contbreed.setBoundLabelUnderline(true);		
        this.contbreed.setVisible(true);
        // contbeginDate		
        this.contbeginDate.setBoundLabelText(resHelper.getString("contbeginDate.boundLabelText"));		
        this.contbeginDate.setBoundLabelLength(100);		
        this.contbeginDate.setBoundLabelUnderline(true);		
        this.contbeginDate.setVisible(true);
        // contendDate		
        this.contendDate.setBoundLabelText(resHelper.getString("contendDate.boundLabelText"));		
        this.contendDate.setBoundLabelLength(100);		
        this.contendDate.setBoundLabelUnderline(true);		
        this.contendDate.setVisible(true);
        // contsettleItem		
        this.contsettleItem.setBoundLabelText(resHelper.getString("contsettleItem.boundLabelText"));		
        this.contsettleItem.setBoundLabelLength(100);		
        this.contsettleItem.setBoundLabelUnderline(true);		
        this.contsettleItem.setVisible(true);
        // contstandHenWeightLow		
        this.contstandHenWeightLow.setBoundLabelText(resHelper.getString("contstandHenWeightLow.boundLabelText"));		
        this.contstandHenWeightLow.setBoundLabelLength(140);		
        this.contstandHenWeightLow.setBoundLabelUnderline(true);		
        this.contstandHenWeightLow.setVisible(true);
        // contstandHenWeightHign		
        this.contstandHenWeightHign.setBoundLabelText(resHelper.getString("contstandHenWeightHign.boundLabelText"));		
        this.contstandHenWeightHign.setBoundLabelLength(140);		
        this.contstandHenWeightHign.setBoundLabelUnderline(true);		
        this.contstandHenWeightHign.setVisible(true);
        // contremark		
        this.contremark.setBoundLabelText(resHelper.getString("contremark.boundLabelText"));		
        this.contremark.setBoundLabelLength(100);		
        this.contremark.setBoundLabelUnderline(true);		
        this.contremark.setVisible(true);
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));		
        this.kDLabel1.setVisible(false);
        // contBIMUDF0010		
        this.contBIMUDF0010.setBoundLabelText(resHelper.getString("contBIMUDF0010.boundLabelText"));		
        this.contBIMUDF0010.setBoundLabelLength(0);		
        this.contBIMUDF0010.setBoundLabelUnderline(true);		
        this.contBIMUDF0010.setVisible(false);
        // kDLabel2		
        this.kDLabel2.setText(resHelper.getString("kDLabel2.text"));		
        this.kDLabel2.setVisible(false);
        // contBIMUDF0011		
        this.contBIMUDF0011.setBoundLabelText(resHelper.getString("contBIMUDF0011.boundLabelText"));		
        this.contBIMUDF0011.setBoundLabelLength(0);		
        this.contBIMUDF0011.setBoundLabelUnderline(true);		
        this.contBIMUDF0011.setVisible(false);
        // kDLabel3		
        this.kDLabel3.setText(resHelper.getString("kDLabel3.text"));		
        this.kDLabel3.setVisible(false);
        // contBIMUDF0012		
        this.contBIMUDF0012.setBoundLabelText(resHelper.getString("contBIMUDF0012.boundLabelText"));		
        this.contBIMUDF0012.setBoundLabelLength(0);		
        this.contBIMUDF0012.setBoundLabelUnderline(true);		
        this.contBIMUDF0012.setVisible(false);
        // kDLabel4		
        this.kDLabel4.setText(resHelper.getString("kDLabel4.text"));		
        this.kDLabel4.setVisible(false);
        // kDSeparator5
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"highCompare\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"chicHighValue\" t:width=\"180\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"lessCompareValue\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"chicLessValue\" t:width=\"180\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"weightCompareValue\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"beginDown\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"weightDiffCoe\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"basePriceReduceRadio\" t:width=\"180\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"isMarketPrice\" t:width=\"180\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{highCompare}</t:Cell><t:Cell>$Resource{chicHighValue}</t:Cell><t:Cell>$Resource{lessCompareValue}</t:Cell><t:Cell>$Resource{chicLessValue}</t:Cell><t:Cell>$Resource{weightCompareValue}</t:Cell><t:Cell>$Resource{beginDown}</t:Cell><t:Cell>$Resource{weightDiffCoe}</t:Cell><t:Cell>$Resource{basePriceReduceRadio}</t:Cell><t:Cell>$Resource{isMarketPrice}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntry.setFormatXml(resHelper.translateString("kdtEntry",kdtEntryStrXML));

                this.kdtEntry.putBindContents("editData",new String[] {"seq","highCompare","chicHighValue","lessCompareValue","chicLessValue","weightCompareValue","beginDown","weightDiffCoe","basePriceReduceRadio","isMarketPrice"});


        this.kdtEntry.checkParsed();
        KDFormattedTextField kdtEntry_seq_TextField = new KDFormattedTextField();
        kdtEntry_seq_TextField.setName("kdtEntry_seq_TextField");
        kdtEntry_seq_TextField.setVisible(true);
        kdtEntry_seq_TextField.setEditable(true);
        kdtEntry_seq_TextField.setHorizontalAlignment(2);
        kdtEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtEntry_seq_TextField);
        this.kdtEntry.getColumn("seq").setEditor(kdtEntry_seq_CellEditor);
        KDComboBox kdtEntry_highCompare_ComboBox = new KDComboBox();
        kdtEntry_highCompare_ComboBox.setName("kdtEntry_highCompare_ComboBox");
        kdtEntry_highCompare_ComboBox.setVisible(true);
        kdtEntry_highCompare_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.highSymbol").toArray());
        KDTDefaultCellEditor kdtEntry_highCompare_CellEditor = new KDTDefaultCellEditor(kdtEntry_highCompare_ComboBox);
        this.kdtEntry.getColumn("highCompare").setEditor(kdtEntry_highCompare_CellEditor);
        KDFormattedTextField kdtEntry_chicHighValue_TextField = new KDFormattedTextField();
        kdtEntry_chicHighValue_TextField.setName("kdtEntry_chicHighValue_TextField");
        kdtEntry_chicHighValue_TextField.setVisible(true);
        kdtEntry_chicHighValue_TextField.setEditable(true);
        kdtEntry_chicHighValue_TextField.setHorizontalAlignment(2);
        kdtEntry_chicHighValue_TextField.setDataType(1);
        	kdtEntry_chicHighValue_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E25"));
        	kdtEntry_chicHighValue_TextField.setMaximumValue(new java.math.BigDecimal("1.0E25"));
        kdtEntry_chicHighValue_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtEntry_chicHighValue_CellEditor = new KDTDefaultCellEditor(kdtEntry_chicHighValue_TextField);
        this.kdtEntry.getColumn("chicHighValue").setEditor(kdtEntry_chicHighValue_CellEditor);
        KDComboBox kdtEntry_lessCompareValue_ComboBox = new KDComboBox();
        kdtEntry_lessCompareValue_ComboBox.setName("kdtEntry_lessCompareValue_ComboBox");
        kdtEntry_lessCompareValue_ComboBox.setVisible(true);
        kdtEntry_lessCompareValue_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.LessSymbol").toArray());
        KDTDefaultCellEditor kdtEntry_lessCompareValue_CellEditor = new KDTDefaultCellEditor(kdtEntry_lessCompareValue_ComboBox);
        this.kdtEntry.getColumn("lessCompareValue").setEditor(kdtEntry_lessCompareValue_CellEditor);
        KDFormattedTextField kdtEntry_chicLessValue_TextField = new KDFormattedTextField();
        kdtEntry_chicLessValue_TextField.setName("kdtEntry_chicLessValue_TextField");
        kdtEntry_chicLessValue_TextField.setVisible(true);
        kdtEntry_chicLessValue_TextField.setEditable(true);
        kdtEntry_chicLessValue_TextField.setHorizontalAlignment(2);
        kdtEntry_chicLessValue_TextField.setDataType(1);
        	kdtEntry_chicLessValue_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E25"));
        	kdtEntry_chicLessValue_TextField.setMaximumValue(new java.math.BigDecimal("1.0E25"));
        kdtEntry_chicLessValue_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtEntry_chicLessValue_CellEditor = new KDTDefaultCellEditor(kdtEntry_chicLessValue_TextField);
        this.kdtEntry.getColumn("chicLessValue").setEditor(kdtEntry_chicLessValue_CellEditor);
        KDFormattedTextField kdtEntry_weightCompareValue_TextField = new KDFormattedTextField();
        kdtEntry_weightCompareValue_TextField.setName("kdtEntry_weightCompareValue_TextField");
        kdtEntry_weightCompareValue_TextField.setVisible(true);
        kdtEntry_weightCompareValue_TextField.setEditable(true);
        kdtEntry_weightCompareValue_TextField.setHorizontalAlignment(2);
        kdtEntry_weightCompareValue_TextField.setDataType(1);
        	kdtEntry_weightCompareValue_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E25"));
        	kdtEntry_weightCompareValue_TextField.setMaximumValue(new java.math.BigDecimal("1.0E25"));
        kdtEntry_weightCompareValue_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtEntry_weightCompareValue_CellEditor = new KDTDefaultCellEditor(kdtEntry_weightCompareValue_TextField);
        this.kdtEntry.getColumn("weightCompareValue").setEditor(kdtEntry_weightCompareValue_CellEditor);
        KDFormattedTextField kdtEntry_beginDown_TextField = new KDFormattedTextField();
        kdtEntry_beginDown_TextField.setName("kdtEntry_beginDown_TextField");
        kdtEntry_beginDown_TextField.setVisible(true);
        kdtEntry_beginDown_TextField.setEditable(true);
        kdtEntry_beginDown_TextField.setHorizontalAlignment(2);
        kdtEntry_beginDown_TextField.setDataType(1);
        	kdtEntry_beginDown_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_beginDown_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_beginDown_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_beginDown_CellEditor = new KDTDefaultCellEditor(kdtEntry_beginDown_TextField);
        this.kdtEntry.getColumn("beginDown").setEditor(kdtEntry_beginDown_CellEditor);
        KDFormattedTextField kdtEntry_weightDiffCoe_TextField = new KDFormattedTextField();
        kdtEntry_weightDiffCoe_TextField.setName("kdtEntry_weightDiffCoe_TextField");
        kdtEntry_weightDiffCoe_TextField.setVisible(true);
        kdtEntry_weightDiffCoe_TextField.setEditable(true);
        kdtEntry_weightDiffCoe_TextField.setHorizontalAlignment(2);
        kdtEntry_weightDiffCoe_TextField.setDataType(1);
        	kdtEntry_weightDiffCoe_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E25"));
        	kdtEntry_weightDiffCoe_TextField.setMaximumValue(new java.math.BigDecimal("1.0E25"));
        kdtEntry_weightDiffCoe_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtEntry_weightDiffCoe_CellEditor = new KDTDefaultCellEditor(kdtEntry_weightDiffCoe_TextField);
        this.kdtEntry.getColumn("weightDiffCoe").setEditor(kdtEntry_weightDiffCoe_CellEditor);
        KDFormattedTextField kdtEntry_basePriceReduceRadio_TextField = new KDFormattedTextField();
        kdtEntry_basePriceReduceRadio_TextField.setName("kdtEntry_basePriceReduceRadio_TextField");
        kdtEntry_basePriceReduceRadio_TextField.setVisible(true);
        kdtEntry_basePriceReduceRadio_TextField.setEditable(true);
        kdtEntry_basePriceReduceRadio_TextField.setHorizontalAlignment(2);
        kdtEntry_basePriceReduceRadio_TextField.setDataType(1);
        	kdtEntry_basePriceReduceRadio_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E25"));
        	kdtEntry_basePriceReduceRadio_TextField.setMaximumValue(new java.math.BigDecimal("1.0E25"));
        kdtEntry_basePriceReduceRadio_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtEntry_basePriceReduceRadio_CellEditor = new KDTDefaultCellEditor(kdtEntry_basePriceReduceRadio_TextField);
        this.kdtEntry.getColumn("basePriceReduceRadio").setEditor(kdtEntry_basePriceReduceRadio_CellEditor);
        KDCheckBox kdtEntry_isMarketPrice_CheckBox = new KDCheckBox();
        kdtEntry_isMarketPrice_CheckBox.setName("kdtEntry_isMarketPrice_CheckBox");
        KDTDefaultCellEditor kdtEntry_isMarketPrice_CellEditor = new KDTDefaultCellEditor(kdtEntry_isMarketPrice_CheckBox);
        this.kdtEntry.getColumn("isMarketPrice").setEditor(kdtEntry_isMarketPrice_CellEditor);
        // contname		
        this.contname.setBoundLabelText(resHelper.getString("contname.boundLabelText"));		
        this.contname.setBoundLabelLength(100);		
        this.contname.setBoundLabelUnderline(true);		
        this.contname.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);
        // prmtbreed		
        this.prmtbreed.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");		
        this.prmtbreed.setEditable(true);		
        this.prmtbreed.setDisplayFormat("$name$");		
        this.prmtbreed.setEditFormat("$number$");		
        this.prmtbreed.setCommitFormat("$number$");		
        this.prmtbreed.setRequired(false);
        		prmtbreed.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI prmtbreed_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtbreed_F7ListUI == null) {
					try {
						prmtbreed_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbreed_F7ListUI));
					prmtbreed_F7ListUI.setF7Use(true,ctx);
					prmtbreed.setSelector(prmtbreed_F7ListUI);
				}
			}
		});
					
        // pkbeginDate		
        this.pkbeginDate.setRequired(true);
        // pkendDate		
        this.pkendDate.setRequired(true);
        // prmtsettleItem		
        this.prmtsettleItem.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.SettlementItemQuery");		
        this.prmtsettleItem.setEditable(true);		
        this.prmtsettleItem.setDisplayFormat("$name$");		
        this.prmtsettleItem.setEditFormat("$number$");		
        this.prmtsettleItem.setCommitFormat("$number$");		
        this.prmtsettleItem.setRequired(false);
        		prmtsettleItem.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI prmtsettleItem_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtsettleItem_F7ListUI == null) {
					try {
						prmtsettleItem_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtsettleItem_F7ListUI));
					prmtsettleItem_F7ListUI.setF7Use(true,ctx);
					prmtsettleItem.setSelector(prmtsettleItem_F7ListUI);
				}
			}
		});
					
        // txtstandHenWeightLow		
        this.txtstandHenWeightLow.setHorizontalAlignment(2);		
        this.txtstandHenWeightLow.setDataType(1);		
        this.txtstandHenWeightLow.setSupportedEmpty(true);		
        this.txtstandHenWeightLow.setMinimumValue( new java.math.BigDecimal("-1.0E25"));		
        this.txtstandHenWeightLow.setMaximumValue( new java.math.BigDecimal("1.0E25"));		
        this.txtstandHenWeightLow.setPrecision(3);		
        this.txtstandHenWeightLow.setRequired(false);
        // txtstandHenWeightHign		
        this.txtstandHenWeightHign.setHorizontalAlignment(2);		
        this.txtstandHenWeightHign.setDataType(1);		
        this.txtstandHenWeightHign.setSupportedEmpty(true);		
        this.txtstandHenWeightHign.setMinimumValue( new java.math.BigDecimal("-1.0E25"));		
        this.txtstandHenWeightHign.setMaximumValue( new java.math.BigDecimal("1.0E25"));		
        this.txtstandHenWeightHign.setPrecision(3);		
        this.txtstandHenWeightHign.setRequired(false);
        // txtremark		
        this.txtremark.setHorizontalAlignment(2);		
        this.txtremark.setMaxLength(100);		
        this.txtremark.setRequired(false);
        // txtBIMUDF0010		
        this.txtBIMUDF0010.setHorizontalAlignment(2);		
        this.txtBIMUDF0010.setMaxLength(100);		
        this.txtBIMUDF0010.setRequired(false);		
        this.txtBIMUDF0010.setVisible(false);
        // txtBIMUDF0011		
        this.txtBIMUDF0011.setHorizontalAlignment(2);		
        this.txtBIMUDF0011.setMaxLength(100);		
        this.txtBIMUDF0011.setRequired(false);		
        this.txtBIMUDF0011.setVisible(false);
        // txtBIMUDF0012		
        this.txtBIMUDF0012.setHorizontalAlignment(2);		
        this.txtBIMUDF0012.setMaxLength(100);		
        this.txtBIMUDF0012.setRequired(false);		
        this.txtBIMUDF0012.setVisible(false);
        // txtname		
        this.txtname.setHorizontalAlignment(2);		
        this.txtname.setMaxLength(255);		
        this.txtname.setRequired(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtname,txtBIMUDF0010,txtBIMUDF0011,txtBIMUDF0012,txtNumber,prmtcompany,baseStatus,prmtbreed,pkbeginDate,pkendDate,prmtsettleItem,txtstandHenWeightLow,txtstandHenWeightHign,txtremark,kdtEntry}));
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
        this.setBounds(new Rectangle(0, 0, 1026, 579));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1026, 579));
        kDLabelContainer1.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(10, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(341, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbaseStatus.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(672, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbreed.setBounds(new Rectangle(11, 61, 270, 19));
        this.add(contbreed, new KDLayout.Constraints(11, 61, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbeginDate.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(contbeginDate, new KDLayout.Constraints(341, 34, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contendDate.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contendDate, new KDLayout.Constraints(672, 34, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsettleItem.setBounds(new Rectangle(11, 85, 270, 19));
        this.add(contsettleItem, new KDLayout.Constraints(11, 85, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstandHenWeightLow.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(contstandHenWeightLow, new KDLayout.Constraints(341, 58, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstandHenWeightHign.setBounds(new Rectangle(672, 58, 270, 19));
        this.add(contstandHenWeightHign, new KDLayout.Constraints(672, 58, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contremark.setBounds(new Rectangle(340, 87, 601, 19));
        this.add(contremark, new KDLayout.Constraints(340, 87, 601, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabel1.setBounds(new Rectangle(8, 142, 145, 19));
        this.add(kDLabel1, new KDLayout.Constraints(8, 142, 145, 19, 0));
        contBIMUDF0010.setBounds(new Rectangle(507, 141, 87, 19));
        this.add(contBIMUDF0010, new KDLayout.Constraints(507, 141, 87, 19, 0));
        kDLabel2.setBounds(new Rectangle(243, 141, 114, 19));
        this.add(kDLabel2, new KDLayout.Constraints(243, 141, 114, 19, 0));
        contBIMUDF0011.setBounds(new Rectangle(145, 140, 93, 19));
        this.add(contBIMUDF0011, new KDLayout.Constraints(145, 140, 93, 19, 0));
        kDLabel3.setBounds(new Rectangle(465, 142, 52, 19));
        this.add(kDLabel3, new KDLayout.Constraints(465, 142, 52, 19, 0));
        contBIMUDF0012.setBounds(new Rectangle(359, 140, 96, 19));
        this.add(contBIMUDF0012, new KDLayout.Constraints(359, 140, 96, 19, 0));
        kDLabel4.setBounds(new Rectangle(599, 142, 166, 19));
        this.add(kDLabel4, new KDLayout.Constraints(599, 142, 166, 19, 0));
        kDSeparator5.setBounds(new Rectangle(10, 112, 935, 10));
        this.add(kDSeparator5, new KDLayout.Constraints(10, 112, 935, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntry.setBounds(new Rectangle(9, 124, 948, 428));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyEntryInfo(),null,false);
        this.add(kdtEntry_detailPanel, new KDLayout.Constraints(9, 124, 948, 428, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
		kdtEntry_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("highCompare",">");
vo.put("lessCompareValue","<");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contname.setBounds(new Rectangle(12, 34, 270, 19));
        this.add(contname, new KDLayout.Constraints(12, 34, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contbreed
        contbreed.setBoundEditor(prmtbreed);
        //contbeginDate
        contbeginDate.setBoundEditor(pkbeginDate);
        //contendDate
        contendDate.setBoundEditor(pkendDate);
        //contsettleItem
        contsettleItem.setBoundEditor(prmtsettleItem);
        //contstandHenWeightLow
        contstandHenWeightLow.setBoundEditor(txtstandHenWeightLow);
        //contstandHenWeightHign
        contstandHenWeightHign.setBoundEditor(txtstandHenWeightHign);
        //contremark
        contremark.setBoundEditor(txtremark);
        //contBIMUDF0010
        contBIMUDF0010.setBoundEditor(txtBIMUDF0010);
        //contBIMUDF0011
        contBIMUDF0011.setBoundEditor(txtBIMUDF0011);
        //contBIMUDF0012
        contBIMUDF0012.setBoundEditor(txtBIMUDF0012);
        //contname
        contname.setBoundEditor(txtname);

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
        this.toolBar.add(btnEdit);
        this.toolBar.add(btnReset);
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnSave);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnCloud);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnRemove);
        this.toolBar.add(btnXunTong);
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


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.weightCompareValue", java.math.BigDecimal.class, this.kdtEntry, "weightCompareValue.text");
		dataBinder.registerBinding("Entry.weightDiffCoe", java.math.BigDecimal.class, this.kdtEntry, "weightDiffCoe.text");
		dataBinder.registerBinding("Entry.basePriceReduceRadio", java.math.BigDecimal.class, this.kdtEntry, "basePriceReduceRadio.text");
		dataBinder.registerBinding("Entry.isMarketPrice", boolean.class, this.kdtEntry, "isMarketPrice.text");
		dataBinder.registerBinding("Entry.highCompare", com.kingdee.util.enums.Enum.class, this.kdtEntry, "highCompare.text");
		dataBinder.registerBinding("Entry.chicHighValue", java.math.BigDecimal.class, this.kdtEntry, "chicHighValue.text");
		dataBinder.registerBinding("Entry.lessCompareValue", com.kingdee.util.enums.Enum.class, this.kdtEntry, "lessCompareValue.text");
		dataBinder.registerBinding("Entry.chicLessValue", java.math.BigDecimal.class, this.kdtEntry, "chicLessValue.text");
		dataBinder.registerBinding("Entry.beginDown", java.math.BigDecimal.class, this.kdtEntry, "beginDown.text");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("breed", com.kingdee.eas.farm.stocking.basedata.BreedDataInfo.class, this.prmtbreed, "data");
		dataBinder.registerBinding("beginDate", java.util.Date.class, this.pkbeginDate, "value");
		dataBinder.registerBinding("endDate", java.util.Date.class, this.pkendDate, "value");
		dataBinder.registerBinding("settleItem", com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo.class, this.prmtsettleItem, "data");
		dataBinder.registerBinding("standHenWeightLow", java.math.BigDecimal.class, this.txtstandHenWeightLow, "value");
		dataBinder.registerBinding("standHenWeightHign", java.math.BigDecimal.class, this.txtstandHenWeightHign, "value");
		dataBinder.registerBinding("remark", String.class, this.txtremark, "text");
		dataBinder.registerBinding("BIMUDF0010", String.class, this.txtBIMUDF0010, "text");
		dataBinder.registerBinding("BIMUDF0011", String.class, this.txtBIMUDF0011, "text");
		dataBinder.registerBinding("BIMUDF0012", String.class, this.txtBIMUDF0012, "text");
		dataBinder.registerBinding("name", String.class, this.txtname, "text");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtNumber, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtNumber, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.basedata.app.BasePriceAdjustPolicyEditUIHandler";
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
        this.txtname.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyInfo)ov;
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
		getValidateHelper().registerBindProperty("Entry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.weightCompareValue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.weightDiffCoe", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.basePriceReduceRadio", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.isMarketPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.highCompare", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.chicHighValue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.lessCompareValue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.chicLessValue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.beginDown", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breed", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settleItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("standHenWeightLow", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("standHenWeightHign", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BIMUDF0010", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BIMUDF0011", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BIMUDF0012", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
		            this.txtNumber.setEnabled(true);
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtNumber.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.txtNumber.setEnabled(false);
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
    	sic.add(new SelectorItemInfo("Entry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("Entry.weightCompareValue"));
    	sic.add(new SelectorItemInfo("Entry.weightDiffCoe"));
    	sic.add(new SelectorItemInfo("Entry.basePriceReduceRadio"));
    	sic.add(new SelectorItemInfo("Entry.isMarketPrice"));
    	sic.add(new SelectorItemInfo("Entry.highCompare"));
    	sic.add(new SelectorItemInfo("Entry.chicHighValue"));
    	sic.add(new SelectorItemInfo("Entry.lessCompareValue"));
    	sic.add(new SelectorItemInfo("Entry.chicLessValue"));
    	sic.add(new SelectorItemInfo("Entry.beginDown"));
        sic.add(new SelectorItemInfo("number"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("baseStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breed.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breed.id"));
        	sic.add(new SelectorItemInfo("breed.number"));
        	sic.add(new SelectorItemInfo("breed.name"));
		}
        sic.add(new SelectorItemInfo("beginDate"));
        sic.add(new SelectorItemInfo("endDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("settleItem.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("settleItem.id"));
        	sic.add(new SelectorItemInfo("settleItem.number"));
        	sic.add(new SelectorItemInfo("settleItem.name"));
		}
        sic.add(new SelectorItemInfo("standHenWeightLow"));
        sic.add(new SelectorItemInfo("standHenWeightHign"));
        sic.add(new SelectorItemInfo("remark"));
        sic.add(new SelectorItemInfo("BIMUDF0010"));
        sic.add(new SelectorItemInfo("BIMUDF0011"));
        sic.add(new SelectorItemInfo("BIMUDF0012"));
        sic.add(new SelectorItemInfo("name"));
        return sic;
    }        
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractBasePriceAdjustPolicyEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBasePriceAdjustPolicyEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.basedata.client", "BasePriceAdjustPolicyEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.client.BasePriceAdjustPolicyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkbeginDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"开始日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkendDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"结束日期"});
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
		vo.put("baseStatus",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}