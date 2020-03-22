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
public abstract class AbstractTempPolicyEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractTempPolicyEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFICompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdateRelate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmaterialType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcalUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contkbPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contavgWgtFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contavgWgtTo;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkforAll;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedData;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtFICompany;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbizDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox dateRelate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkendDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox materialType;
    protected com.kingdee.bos.ctrl.swing.KDComboBox calUnit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtkbPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtavgWgtFrom;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtavgWgtTo;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtPolicyEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtPolicyEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedData;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtMarketPriceEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtMarketPriceEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.carnivorous.basedata.TempPolicyInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractTempPolicyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractTempPolicyEditUI.class.getName());
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
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFICompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdateRelate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmaterialType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcalUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contkbPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contavgWgtFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contavgWgtTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkforAll = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contbreedData = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtFICompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkbizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.dateRelate = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkbeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkendDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.materialType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.calUnit = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtkbPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtavgWgtFrom = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtavgWgtTo = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtPolicyEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.prmtbreedData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kdtMarketPriceEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contFICompany.setName("contFICompany");
        this.contbaseStatus.setName("contbaseStatus");
        this.contbizDate.setName("contbizDate");
        this.contdateRelate.setName("contdateRelate");
        this.contbeginDate.setName("contbeginDate");
        this.contendDate.setName("contendDate");
        this.contmaterialType.setName("contmaterialType");
        this.contcalUnit.setName("contcalUnit");
        this.contkbPrice.setName("contkbPrice");
        this.contavgWgtFrom.setName("contavgWgtFrom");
        this.contavgWgtTo.setName("contavgWgtTo");
        this.chkforAll.setName("chkforAll");
        this.kDLabel1.setName("kDLabel1");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contbreedData.setName("contbreedData");
        this.kDPanel2.setName("kDPanel2");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtDescription.setName("txtDescription");
        this.prmtFICompany.setName("prmtFICompany");
        this.baseStatus.setName("baseStatus");
        this.pkbizDate.setName("pkbizDate");
        this.dateRelate.setName("dateRelate");
        this.pkbeginDate.setName("pkbeginDate");
        this.pkendDate.setName("pkendDate");
        this.materialType.setName("materialType");
        this.calUnit.setName("calUnit");
        this.txtkbPrice.setName("txtkbPrice");
        this.txtavgWgtFrom.setName("txtavgWgtFrom");
        this.txtavgWgtTo.setName("txtavgWgtTo");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel3.setName("kDPanel3");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtPolicyEntry.setName("kdtPolicyEntry");
        this.prmtbreedData.setName("prmtbreedData");
        this.kdtMarketPriceEntrys.setName("kdtMarketPriceEntrys");
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
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(true);
        // contFICompany		
        this.contFICompany.setBoundLabelText(resHelper.getString("contFICompany.boundLabelText"));		
        this.contFICompany.setBoundLabelLength(100);		
        this.contFICompany.setBoundLabelUnderline(true);		
        this.contFICompany.setVisible(true);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // contbizDate		
        this.contbizDate.setBoundLabelText(resHelper.getString("contbizDate.boundLabelText"));		
        this.contbizDate.setBoundLabelLength(100);		
        this.contbizDate.setBoundLabelUnderline(true);		
        this.contbizDate.setVisible(true);
        // contdateRelate		
        this.contdateRelate.setBoundLabelText(resHelper.getString("contdateRelate.boundLabelText"));		
        this.contdateRelate.setBoundLabelLength(100);		
        this.contdateRelate.setBoundLabelUnderline(true);		
        this.contdateRelate.setVisible(false);
        // contbeginDate		
        this.contbeginDate.setBoundLabelText(resHelper.getString("contbeginDate.boundLabelText"));		
        this.contbeginDate.setBoundLabelLength(100);		
        this.contbeginDate.setBoundLabelUnderline(true);		
        this.contbeginDate.setVisible(false);
        // contendDate		
        this.contendDate.setBoundLabelText(resHelper.getString("contendDate.boundLabelText"));		
        this.contendDate.setBoundLabelLength(100);		
        this.contendDate.setBoundLabelUnderline(true);		
        this.contendDate.setVisible(false);
        // contmaterialType		
        this.contmaterialType.setBoundLabelText(resHelper.getString("contmaterialType.boundLabelText"));		
        this.contmaterialType.setBoundLabelLength(100);		
        this.contmaterialType.setBoundLabelUnderline(true);		
        this.contmaterialType.setVisible(false);
        // contcalUnit		
        this.contcalUnit.setBoundLabelText(resHelper.getString("contcalUnit.boundLabelText"));		
        this.contcalUnit.setBoundLabelLength(100);		
        this.contcalUnit.setBoundLabelUnderline(true);		
        this.contcalUnit.setVisible(false);
        // contkbPrice		
        this.contkbPrice.setBoundLabelText(resHelper.getString("contkbPrice.boundLabelText"));		
        this.contkbPrice.setBoundLabelLength(100);		
        this.contkbPrice.setBoundLabelUnderline(true);		
        this.contkbPrice.setVisible(false);
        // contavgWgtFrom		
        this.contavgWgtFrom.setBoundLabelText(resHelper.getString("contavgWgtFrom.boundLabelText"));		
        this.contavgWgtFrom.setBoundLabelLength(100);		
        this.contavgWgtFrom.setBoundLabelUnderline(true);		
        this.contavgWgtFrom.setVisible(false);
        // contavgWgtTo		
        this.contavgWgtTo.setBoundLabelText(resHelper.getString("contavgWgtTo.boundLabelText"));		
        this.contavgWgtTo.setBoundLabelLength(100);		
        this.contavgWgtTo.setBoundLabelUnderline(true);		
        this.contavgWgtTo.setVisible(false);
        // chkforAll		
        this.chkforAll.setText(resHelper.getString("chkforAll.text"));		
        this.chkforAll.setHorizontalAlignment(2);
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));
        // kDTabbedPane1
        // contbreedData		
        this.contbreedData.setBoundLabelText(resHelper.getString("contbreedData.boundLabelText"));		
        this.contbreedData.setBoundLabelLength(100);		
        this.contbreedData.setBoundLabelUnderline(true);		
        this.contbreedData.setVisible(true);
        // kDPanel2
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setRequired(true);
        // txtName		
        this.txtName.setRequired(true);
        // txtDescription
        // prmtFICompany		
        this.prmtFICompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct");		
        this.prmtFICompany.setEditable(true);		
        this.prmtFICompany.setDisplayFormat("$name$");		
        this.prmtFICompany.setEditFormat("$number$");		
        this.prmtFICompany.setCommitFormat("$number$");		
        this.prmtFICompany.setRequired(true);
        		setOrgF7(prmtFICompany,com.kingdee.eas.basedata.org.OrgType.getEnum("Company"));
					
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // pkbizDate		
        this.pkbizDate.setRequired(false);
        // dateRelate		
        this.dateRelate.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.DateRelate").toArray());		
        this.dateRelate.setRequired(false);		
        this.dateRelate.setVisible(false);
        // pkbeginDate		
        this.pkbeginDate.setRequired(false);		
        this.pkbeginDate.setVisible(false);
        // pkendDate		
        this.pkendDate.setRequired(false);		
        this.pkendDate.setVisible(false);
        // materialType		
        this.materialType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.MaterialType").toArray());		
        this.materialType.setRequired(false);		
        this.materialType.setVisible(false);
        // calUnit		
        this.calUnit.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.CalUnit").toArray());		
        this.calUnit.setRequired(false);		
        this.calUnit.setVisible(false);
        // txtkbPrice		
        this.txtkbPrice.setHorizontalAlignment(2);		
        this.txtkbPrice.setDataType(1);		
        this.txtkbPrice.setSupportedEmpty(true);		
        this.txtkbPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtkbPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtkbPrice.setPrecision(4);		
        this.txtkbPrice.setRequired(false);		
        this.txtkbPrice.setEnabled(false);		
        this.txtkbPrice.setVisible(false);
        // txtavgWgtFrom		
        this.txtavgWgtFrom.setHorizontalAlignment(2);		
        this.txtavgWgtFrom.setDataType(1);		
        this.txtavgWgtFrom.setSupportedEmpty(true);		
        this.txtavgWgtFrom.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtavgWgtFrom.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtavgWgtFrom.setPrecision(4);		
        this.txtavgWgtFrom.setRequired(false);		
        this.txtavgWgtFrom.setEnabled(false);		
        this.txtavgWgtFrom.setVisible(false);
        // txtavgWgtTo		
        this.txtavgWgtTo.setHorizontalAlignment(2);		
        this.txtavgWgtTo.setDataType(1);		
        this.txtavgWgtTo.setSupportedEmpty(true);		
        this.txtavgWgtTo.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtavgWgtTo.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtavgWgtTo.setPrecision(4);		
        this.txtavgWgtTo.setRequired(false);		
        this.txtavgWgtTo.setEnabled(false);		
        this.txtavgWgtTo.setVisible(false);
        // kDPanel1
        // kDPanel3
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"farmer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"farm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{farmer}</t:Cell><t:Cell>$Resource{farm}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"seq","farmer","farm"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_farmer_PromptBox = new KDBizPromptBox();
        kdtEntrys_farmer_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");
        kdtEntrys_farmer_PromptBox.setVisible(true);
        kdtEntrys_farmer_PromptBox.setEditable(true);
        kdtEntrys_farmer_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_farmer_PromptBox.setEditFormat("$number$");
        kdtEntrys_farmer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_farmer_CellEditor = new KDTDefaultCellEditor(kdtEntrys_farmer_PromptBox);
        this.kdtEntrys.getColumn("farmer").setEditor(kdtEntrys_farmer_CellEditor);
        ObjectValueRender kdtEntrys_farmer_OVR = new ObjectValueRender();
        kdtEntrys_farmer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("farmer").setRenderer(kdtEntrys_farmer_OVR);
        			kdtEntrys_farmer_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI kdtEntrys_farmer_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_farmer_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_farmer_PromptBox_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_farmer_PromptBox_F7ListUI));
					kdtEntrys_farmer_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_farmer_PromptBox.setSelector(kdtEntrys_farmer_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntrys_farm_PromptBox = new KDBizPromptBox();
        kdtEntrys_farm_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmQuery");
        kdtEntrys_farm_PromptBox.setVisible(true);
        kdtEntrys_farm_PromptBox.setEditable(true);
        kdtEntrys_farm_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_farm_PromptBox.setEditFormat("$number$");
        kdtEntrys_farm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_farm_CellEditor = new KDTDefaultCellEditor(kdtEntrys_farm_PromptBox);
        this.kdtEntrys.getColumn("farm").setEditor(kdtEntrys_farm_CellEditor);
        ObjectValueRender kdtEntrys_farm_OVR = new ObjectValueRender();
        kdtEntrys_farm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("farm").setRenderer(kdtEntrys_farm_OVR);
        			kdtEntrys_farm_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI kdtEntrys_farm_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_farm_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_farm_PromptBox_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_farm_PromptBox_F7ListUI));
					kdtEntrys_farm_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_farm_PromptBox.setSelector(kdtEntrys_farm_PromptBox_F7ListUI);
				}
			}
		});
					
        // kdtPolicyEntry
		String kdtPolicyEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"policyDatR\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"matSelect\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"beginDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"endDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"wgtBegin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"wgtEnd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{policyDatR}</t:Cell><t:Cell>$Resource{matSelect}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{beginDate}</t:Cell><t:Cell>$Resource{endDate}</t:Cell><t:Cell>$Resource{wgtBegin}</t:Cell><t:Cell>$Resource{wgtEnd}</t:Cell><t:Cell>$Resource{price}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtPolicyEntry.setFormatXml(resHelper.translateString("kdtPolicyEntry",kdtPolicyEntryStrXML));

                this.kdtPolicyEntry.putBindContents("editData",new String[] {"seq","policyDatR","matSelect","unit","beginDate","endDate","wgtBegin","wgtEnd","price"});


        this.kdtPolicyEntry.checkParsed();
        KDComboBox kdtPolicyEntry_policyDatR_ComboBox = new KDComboBox();
        kdtPolicyEntry_policyDatR_ComboBox.setName("kdtPolicyEntry_policyDatR_ComboBox");
        kdtPolicyEntry_policyDatR_ComboBox.setVisible(true);
        kdtPolicyEntry_policyDatR_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.DateRelate").toArray());
        KDTDefaultCellEditor kdtPolicyEntry_policyDatR_CellEditor = new KDTDefaultCellEditor(kdtPolicyEntry_policyDatR_ComboBox);
        this.kdtPolicyEntry.getColumn("policyDatR").setEditor(kdtPolicyEntry_policyDatR_CellEditor);
        KDComboBox kdtPolicyEntry_matSelect_ComboBox = new KDComboBox();
        kdtPolicyEntry_matSelect_ComboBox.setName("kdtPolicyEntry_matSelect_ComboBox");
        kdtPolicyEntry_matSelect_ComboBox.setVisible(true);
        kdtPolicyEntry_matSelect_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.MaterialType").toArray());
        KDTDefaultCellEditor kdtPolicyEntry_matSelect_CellEditor = new KDTDefaultCellEditor(kdtPolicyEntry_matSelect_ComboBox);
        this.kdtPolicyEntry.getColumn("matSelect").setEditor(kdtPolicyEntry_matSelect_CellEditor);
        KDComboBox kdtPolicyEntry_unit_ComboBox = new KDComboBox();
        kdtPolicyEntry_unit_ComboBox.setName("kdtPolicyEntry_unit_ComboBox");
        kdtPolicyEntry_unit_ComboBox.setVisible(true);
        kdtPolicyEntry_unit_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.CalUnit").toArray());
        KDTDefaultCellEditor kdtPolicyEntry_unit_CellEditor = new KDTDefaultCellEditor(kdtPolicyEntry_unit_ComboBox);
        this.kdtPolicyEntry.getColumn("unit").setEditor(kdtPolicyEntry_unit_CellEditor);
        KDDatePicker kdtPolicyEntry_beginDate_DatePicker = new KDDatePicker();
        kdtPolicyEntry_beginDate_DatePicker.setName("kdtPolicyEntry_beginDate_DatePicker");
        kdtPolicyEntry_beginDate_DatePicker.setVisible(true);
        kdtPolicyEntry_beginDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtPolicyEntry_beginDate_CellEditor = new KDTDefaultCellEditor(kdtPolicyEntry_beginDate_DatePicker);
        this.kdtPolicyEntry.getColumn("beginDate").setEditor(kdtPolicyEntry_beginDate_CellEditor);
        KDDatePicker kdtPolicyEntry_endDate_DatePicker = new KDDatePicker();
        kdtPolicyEntry_endDate_DatePicker.setName("kdtPolicyEntry_endDate_DatePicker");
        kdtPolicyEntry_endDate_DatePicker.setVisible(true);
        kdtPolicyEntry_endDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtPolicyEntry_endDate_CellEditor = new KDTDefaultCellEditor(kdtPolicyEntry_endDate_DatePicker);
        this.kdtPolicyEntry.getColumn("endDate").setEditor(kdtPolicyEntry_endDate_CellEditor);
        KDFormattedTextField kdtPolicyEntry_wgtBegin_TextField = new KDFormattedTextField();
        kdtPolicyEntry_wgtBegin_TextField.setName("kdtPolicyEntry_wgtBegin_TextField");
        kdtPolicyEntry_wgtBegin_TextField.setVisible(true);
        kdtPolicyEntry_wgtBegin_TextField.setEditable(true);
        kdtPolicyEntry_wgtBegin_TextField.setHorizontalAlignment(2);
        kdtPolicyEntry_wgtBegin_TextField.setDataType(1);
        	kdtPolicyEntry_wgtBegin_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E25"));
        	kdtPolicyEntry_wgtBegin_TextField.setMaximumValue(new java.math.BigDecimal("1.0E25"));
        kdtPolicyEntry_wgtBegin_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtPolicyEntry_wgtBegin_CellEditor = new KDTDefaultCellEditor(kdtPolicyEntry_wgtBegin_TextField);
        this.kdtPolicyEntry.getColumn("wgtBegin").setEditor(kdtPolicyEntry_wgtBegin_CellEditor);
        KDFormattedTextField kdtPolicyEntry_wgtEnd_TextField = new KDFormattedTextField();
        kdtPolicyEntry_wgtEnd_TextField.setName("kdtPolicyEntry_wgtEnd_TextField");
        kdtPolicyEntry_wgtEnd_TextField.setVisible(true);
        kdtPolicyEntry_wgtEnd_TextField.setEditable(true);
        kdtPolicyEntry_wgtEnd_TextField.setHorizontalAlignment(2);
        kdtPolicyEntry_wgtEnd_TextField.setDataType(1);
        	kdtPolicyEntry_wgtEnd_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E25"));
        	kdtPolicyEntry_wgtEnd_TextField.setMaximumValue(new java.math.BigDecimal("1.0E25"));
        kdtPolicyEntry_wgtEnd_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtPolicyEntry_wgtEnd_CellEditor = new KDTDefaultCellEditor(kdtPolicyEntry_wgtEnd_TextField);
        this.kdtPolicyEntry.getColumn("wgtEnd").setEditor(kdtPolicyEntry_wgtEnd_CellEditor);
        KDFormattedTextField kdtPolicyEntry_price_TextField = new KDFormattedTextField();
        kdtPolicyEntry_price_TextField.setName("kdtPolicyEntry_price_TextField");
        kdtPolicyEntry_price_TextField.setVisible(true);
        kdtPolicyEntry_price_TextField.setEditable(true);
        kdtPolicyEntry_price_TextField.setHorizontalAlignment(2);
        kdtPolicyEntry_price_TextField.setDataType(1);
        	kdtPolicyEntry_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E25"));
        	kdtPolicyEntry_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E25"));
        kdtPolicyEntry_price_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtPolicyEntry_price_CellEditor = new KDTDefaultCellEditor(kdtPolicyEntry_price_TextField);
        this.kdtPolicyEntry.getColumn("price").setEditor(kdtPolicyEntry_price_CellEditor);
        // prmtbreedData		
        this.prmtbreedData.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");		
        this.prmtbreedData.setVisible(true);		
        this.prmtbreedData.setEditable(true);		
        this.prmtbreedData.setDisplayFormat("$name$");		
        this.prmtbreedData.setEditFormat("$number$");		
        this.prmtbreedData.setCommitFormat("$number$");		
        this.prmtbreedData.setRequired(true);
        		prmtbreedData.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI prmtbreedData_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtbreedData_F7ListUI == null) {
					try {
						prmtbreedData_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbreedData_F7ListUI));
					prmtbreedData_F7ListUI.setF7Use(true,ctx);
					prmtbreedData.setSelector(prmtbreedData_F7ListUI);
				}
			}
		});
					
        // kdtMarketPriceEntrys
		String kdtMarketPriceEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"highSymbol\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"minPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"lessSymbol\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"maxPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"subsidyPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol5\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{highSymbol}</t:Cell><t:Cell>$Resource{minPrice}</t:Cell><t:Cell>$Resource{lessSymbol}</t:Cell><t:Cell>$Resource{maxPrice}</t:Cell><t:Cell>$Resource{subsidyPrice}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtMarketPriceEntrys.setFormatXml(resHelper.translateString("kdtMarketPriceEntrys",kdtMarketPriceEntrysStrXML));

                this.kdtMarketPriceEntrys.putBindContents("editData",new String[] {"seq","highSymbol","minPrice","lessSymbol","maxPrice","subsidyPrice"});


        this.kdtMarketPriceEntrys.checkParsed();
        KDComboBox kdtMarketPriceEntrys_highSymbol_ComboBox = new KDComboBox();
        kdtMarketPriceEntrys_highSymbol_ComboBox.setName("kdtMarketPriceEntrys_highSymbol_ComboBox");
        kdtMarketPriceEntrys_highSymbol_ComboBox.setVisible(true);
        kdtMarketPriceEntrys_highSymbol_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.highSymbol").toArray());
        KDTDefaultCellEditor kdtMarketPriceEntrys_highSymbol_CellEditor = new KDTDefaultCellEditor(kdtMarketPriceEntrys_highSymbol_ComboBox);
        this.kdtMarketPriceEntrys.getColumn("highSymbol").setEditor(kdtMarketPriceEntrys_highSymbol_CellEditor);
        KDFormattedTextField kdtMarketPriceEntrys_minPrice_TextField = new KDFormattedTextField();
        kdtMarketPriceEntrys_minPrice_TextField.setName("kdtMarketPriceEntrys_minPrice_TextField");
        kdtMarketPriceEntrys_minPrice_TextField.setVisible(true);
        kdtMarketPriceEntrys_minPrice_TextField.setEditable(true);
        kdtMarketPriceEntrys_minPrice_TextField.setHorizontalAlignment(2);
        kdtMarketPriceEntrys_minPrice_TextField.setDataType(1);
        	kdtMarketPriceEntrys_minPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtMarketPriceEntrys_minPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtMarketPriceEntrys_minPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtMarketPriceEntrys_minPrice_CellEditor = new KDTDefaultCellEditor(kdtMarketPriceEntrys_minPrice_TextField);
        this.kdtMarketPriceEntrys.getColumn("minPrice").setEditor(kdtMarketPriceEntrys_minPrice_CellEditor);
        KDComboBox kdtMarketPriceEntrys_lessSymbol_ComboBox = new KDComboBox();
        kdtMarketPriceEntrys_lessSymbol_ComboBox.setName("kdtMarketPriceEntrys_lessSymbol_ComboBox");
        kdtMarketPriceEntrys_lessSymbol_ComboBox.setVisible(true);
        kdtMarketPriceEntrys_lessSymbol_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.LessSymbol").toArray());
        KDTDefaultCellEditor kdtMarketPriceEntrys_lessSymbol_CellEditor = new KDTDefaultCellEditor(kdtMarketPriceEntrys_lessSymbol_ComboBox);
        this.kdtMarketPriceEntrys.getColumn("lessSymbol").setEditor(kdtMarketPriceEntrys_lessSymbol_CellEditor);
        KDFormattedTextField kdtMarketPriceEntrys_maxPrice_TextField = new KDFormattedTextField();
        kdtMarketPriceEntrys_maxPrice_TextField.setName("kdtMarketPriceEntrys_maxPrice_TextField");
        kdtMarketPriceEntrys_maxPrice_TextField.setVisible(true);
        kdtMarketPriceEntrys_maxPrice_TextField.setEditable(true);
        kdtMarketPriceEntrys_maxPrice_TextField.setHorizontalAlignment(2);
        kdtMarketPriceEntrys_maxPrice_TextField.setDataType(1);
        	kdtMarketPriceEntrys_maxPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtMarketPriceEntrys_maxPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtMarketPriceEntrys_maxPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtMarketPriceEntrys_maxPrice_CellEditor = new KDTDefaultCellEditor(kdtMarketPriceEntrys_maxPrice_TextField);
        this.kdtMarketPriceEntrys.getColumn("maxPrice").setEditor(kdtMarketPriceEntrys_maxPrice_CellEditor);
        KDFormattedTextField kdtMarketPriceEntrys_subsidyPrice_TextField = new KDFormattedTextField();
        kdtMarketPriceEntrys_subsidyPrice_TextField.setName("kdtMarketPriceEntrys_subsidyPrice_TextField");
        kdtMarketPriceEntrys_subsidyPrice_TextField.setVisible(true);
        kdtMarketPriceEntrys_subsidyPrice_TextField.setEditable(true);
        kdtMarketPriceEntrys_subsidyPrice_TextField.setHorizontalAlignment(2);
        kdtMarketPriceEntrys_subsidyPrice_TextField.setDataType(1);
        	kdtMarketPriceEntrys_subsidyPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtMarketPriceEntrys_subsidyPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtMarketPriceEntrys_subsidyPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtMarketPriceEntrys_subsidyPrice_CellEditor = new KDTDefaultCellEditor(kdtMarketPriceEntrys_subsidyPrice_TextField);
        this.kdtMarketPriceEntrys.getColumn("subsidyPrice").setEditor(kdtMarketPriceEntrys_subsidyPrice_CellEditor);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtFICompany,txtName,txtNumber,txtDescription,baseStatus,pkbizDate,dateRelate,pkbeginDate,pkendDate,materialType,calUnit,txtkbPrice,txtavgWgtFrom,txtavgWgtTo,chkforAll,kdtEntrys,kdtMarketPriceEntrys,prmtbreedData}));
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
        this.setBounds(new Rectangle(0, 0, 906, 556));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 906, 556));
        kDLabelContainer1.setBounds(new Rectangle(25, 33, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(25, 33, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(319, 33, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(319, 33, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer4.setBounds(new Rectangle(26, 94, 573, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(26, 94, 573, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contFICompany.setBounds(new Rectangle(25, 63, 270, 19));
        this.add(contFICompany, new KDLayout.Constraints(25, 63, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbaseStatus.setBounds(new Rectangle(613, 33, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(613, 33, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbizDate.setBounds(new Rectangle(319, 63, 270, 19));
        this.add(contbizDate, new KDLayout.Constraints(319, 63, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdateRelate.setBounds(new Rectangle(24, 93, 270, 19));
        this.add(contdateRelate, new KDLayout.Constraints(24, 93, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbeginDate.setBounds(new Rectangle(319, 93, 270, 19));
        this.add(contbeginDate, new KDLayout.Constraints(319, 93, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contendDate.setBounds(new Rectangle(613, 93, 270, 19));
        this.add(contendDate, new KDLayout.Constraints(613, 93, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contmaterialType.setBounds(new Rectangle(24, 120, 270, 19));
        this.add(contmaterialType, new KDLayout.Constraints(24, 120, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcalUnit.setBounds(new Rectangle(319, 119, 270, 19));
        this.add(contcalUnit, new KDLayout.Constraints(319, 119, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contkbPrice.setBounds(new Rectangle(613, 119, 270, 19));
        this.add(contkbPrice, new KDLayout.Constraints(613, 119, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contavgWgtFrom.setBounds(new Rectangle(492, 185, 270, 19));
        this.add(contavgWgtFrom, new KDLayout.Constraints(492, 185, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contavgWgtTo.setBounds(new Rectangle(579, 166, 270, 19));
        this.add(contavgWgtTo, new KDLayout.Constraints(579, 166, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkforAll.setBounds(new Rectangle(614, 94, 270, 19));
        this.add(chkforAll, new KDLayout.Constraints(614, 94, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabel1.setBounds(new Rectangle(25, 130, 849, 19));
        this.add(kDLabel1, new KDLayout.Constraints(25, 130, 849, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(25, 174, 859, 367));
        this.add(kDTabbedPane1, new KDLayout.Constraints(25, 174, 859, 367, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbreedData.setBounds(new Rectangle(613, 63, 270, 19));
        this.add(contbreedData, new KDLayout.Constraints(613, 63, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDPanel2.setBounds(new Rectangle(134, 260, 855, 260));
        this.add(kDPanel2, new KDLayout.Constraints(134, 260, 855, 260, 0));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contFICompany
        contFICompany.setBoundEditor(prmtFICompany);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contbizDate
        contbizDate.setBoundEditor(pkbizDate);
        //contdateRelate
        contdateRelate.setBoundEditor(dateRelate);
        //contbeginDate
        contbeginDate.setBoundEditor(pkbeginDate);
        //contendDate
        contendDate.setBoundEditor(pkendDate);
        //contmaterialType
        contmaterialType.setBoundEditor(materialType);
        //contcalUnit
        contcalUnit.setBoundEditor(calUnit);
        //contkbPrice
        contkbPrice.setBoundEditor(txtkbPrice);
        //contavgWgtFrom
        contavgWgtFrom.setBoundEditor(txtavgWgtFrom);
        //contavgWgtTo
        contavgWgtTo.setBoundEditor(txtavgWgtTo);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 858, 334));        kdtEntrys.setBounds(new Rectangle(3, 3, 844, 330));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.carnivorous.basedata.TempPolicyEntryInfo(),null,false);
        kDPanel1.add(kdtEntrys_detailPanel, new KDLayout.Constraints(3, 3, 844, 330, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 858, 334));        kdtPolicyEntry.setBounds(new Rectangle(5, 4, 842, 327));
        kdtPolicyEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtPolicyEntry,new com.kingdee.eas.farm.carnivorous.basedata.TempPolicyPolicyEntryInfo(),null,false);
        kDPanel3.add(kdtPolicyEntry_detailPanel, new KDLayout.Constraints(5, 4, 842, 327, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtPolicyEntry_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("policyDatR","0");
vo.put("matSelect","0");
vo.put("unit","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //contbreedData
        contbreedData.setBoundEditor(prmtbreedData);
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(134, 260, 855, 260));        kdtMarketPriceEntrys.setBounds(new Rectangle(5, 4, 845, 235));
        kdtMarketPriceEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtMarketPriceEntrys,new com.kingdee.eas.farm.carnivorous.basedata.TempPolicyMarketPriceEntryInfo(),null,false);
        kDPanel2.add(kdtMarketPriceEntrys_detailPanel, new KDLayout.Constraints(5, 4, 845, 235, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtMarketPriceEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("highSymbol",">");
vo.put("lessSymbol","<");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});

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
        this.toolBar.add(btnCloud);
        this.toolBar.add(btnEdit);
        this.toolBar.add(btnXunTong);
        this.toolBar.add(btnReset);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnSave);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
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
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("forAll", boolean.class, this.chkforAll, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("FICompany", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtFICompany, "data");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkbizDate, "value");
		dataBinder.registerBinding("dateRelate", com.kingdee.eas.farm.carnivorous.basedata.DateRelate.class, this.dateRelate, "selectedItem");
		dataBinder.registerBinding("beginDate", java.util.Date.class, this.pkbeginDate, "value");
		dataBinder.registerBinding("endDate", java.util.Date.class, this.pkendDate, "value");
		dataBinder.registerBinding("materialType", com.kingdee.eas.farm.carnivorous.basedata.MaterialType.class, this.materialType, "selectedItem");
		dataBinder.registerBinding("calUnit", com.kingdee.eas.farm.carnivorous.basedata.CalUnit.class, this.calUnit, "selectedItem");
		dataBinder.registerBinding("kbPrice", java.math.BigDecimal.class, this.txtkbPrice, "value");
		dataBinder.registerBinding("avgWgtFrom", java.math.BigDecimal.class, this.txtavgWgtFrom, "value");
		dataBinder.registerBinding("avgWgtTo", java.math.BigDecimal.class, this.txtavgWgtTo, "value");
		dataBinder.registerBinding("Entrys.seq", int.class, this.kdtEntrys, "seq.text");
		dataBinder.registerBinding("Entrys", com.kingdee.eas.farm.carnivorous.basedata.TempPolicyEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("Entrys.farmer", java.lang.Object.class, this.kdtEntrys, "farmer.text");
		dataBinder.registerBinding("Entrys.farm", java.lang.Object.class, this.kdtEntrys, "farm.text");
		dataBinder.registerBinding("PolicyEntry.seq", int.class, this.kdtPolicyEntry, "seq.text");
		dataBinder.registerBinding("PolicyEntry", com.kingdee.eas.farm.carnivorous.basedata.TempPolicyPolicyEntryInfo.class, this.kdtPolicyEntry, "userObject");
		dataBinder.registerBinding("PolicyEntry.policyDatR", com.kingdee.util.enums.Enum.class, this.kdtPolicyEntry, "policyDatR.text");
		dataBinder.registerBinding("PolicyEntry.matSelect", com.kingdee.util.enums.Enum.class, this.kdtPolicyEntry, "matSelect.text");
		dataBinder.registerBinding("PolicyEntry.unit", com.kingdee.util.enums.Enum.class, this.kdtPolicyEntry, "unit.text");
		dataBinder.registerBinding("PolicyEntry.beginDate", java.util.Date.class, this.kdtPolicyEntry, "beginDate.text");
		dataBinder.registerBinding("PolicyEntry.endDate", java.util.Date.class, this.kdtPolicyEntry, "endDate.text");
		dataBinder.registerBinding("PolicyEntry.wgtBegin", java.math.BigDecimal.class, this.kdtPolicyEntry, "wgtBegin.text");
		dataBinder.registerBinding("PolicyEntry.wgtEnd", java.math.BigDecimal.class, this.kdtPolicyEntry, "wgtEnd.text");
		dataBinder.registerBinding("PolicyEntry.price", java.math.BigDecimal.class, this.kdtPolicyEntry, "price.text");
		dataBinder.registerBinding("breedData", com.kingdee.eas.farm.stocking.basedata.BreedDataInfo.class, this.prmtbreedData, "data");
		dataBinder.registerBinding("MarketPriceEntrys.seq", int.class, this.kdtMarketPriceEntrys, "seq.text");
		dataBinder.registerBinding("MarketPriceEntrys", com.kingdee.eas.farm.carnivorous.basedata.TempPolicyMarketPriceEntryInfo.class, this.kdtMarketPriceEntrys, "userObject");
		dataBinder.registerBinding("MarketPriceEntrys.minPrice", java.math.BigDecimal.class, this.kdtMarketPriceEntrys, "minPrice.text");
		dataBinder.registerBinding("MarketPriceEntrys.highSymbol", com.kingdee.util.enums.Enum.class, this.kdtMarketPriceEntrys, "highSymbol.text");
		dataBinder.registerBinding("MarketPriceEntrys.maxPrice", java.math.BigDecimal.class, this.kdtMarketPriceEntrys, "maxPrice.text");
		dataBinder.registerBinding("MarketPriceEntrys.lessSymbol", com.kingdee.util.enums.Enum.class, this.kdtMarketPriceEntrys, "lessSymbol.text");
		dataBinder.registerBinding("MarketPriceEntrys.subsidyPrice", java.math.BigDecimal.class, this.kdtMarketPriceEntrys, "subsidyPrice.text");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtNumber, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtName, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtDescription, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtNumber, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.basedata.app.TempPolicyEditUIHandler";
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
        this.prmtFICompany.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.carnivorous.basedata.TempPolicyInfo)ov;
    }
    protected void removeByPK(IObjectPK pk) throws Exception {
    	IObjectValue editData = this.editData;
    	super.removeByPK(pk);
    	recycleNumberByOrg(editData,"Company",editData.getString("number"));
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
			protected com.kingdee.eas.basedata.org.OrgType getMainBizOrgType() {
			return com.kingdee.eas.basedata.org.OrgType.getEnum("Company");
		}

	protected KDBizPromptBox getMainBizOrg() {
		return prmtFICompany;
}


    /**
     * output loadFields method
     */
    public void loadFields()
    {
        		setAutoNumberByOrg("Company");
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
		getValidateHelper().registerBindProperty("forAll", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FICompany", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dateRelate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("materialType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("calUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("kbPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("avgWgtFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("avgWgtTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.policyDatR", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.matSelect", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.beginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.wgtBegin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.wgtEnd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.price", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MarketPriceEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MarketPriceEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MarketPriceEntrys.minPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MarketPriceEntrys.highSymbol", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MarketPriceEntrys.maxPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MarketPriceEntrys.lessSymbol", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MarketPriceEntrys.subsidyPrice", ValidateHelper.ON_SAVE);    		
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
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(false);
		            this.txtDescription.setEnabled(false);
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
        sic.add(new SelectorItemInfo("forAll"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FICompany.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("FICompany.id"));
        	sic.add(new SelectorItemInfo("FICompany.number"));
        	sic.add(new SelectorItemInfo("FICompany.name"));
		}
        sic.add(new SelectorItemInfo("baseStatus"));
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("dateRelate"));
        sic.add(new SelectorItemInfo("beginDate"));
        sic.add(new SelectorItemInfo("endDate"));
        sic.add(new SelectorItemInfo("materialType"));
        sic.add(new SelectorItemInfo("calUnit"));
        sic.add(new SelectorItemInfo("kbPrice"));
        sic.add(new SelectorItemInfo("avgWgtFrom"));
        sic.add(new SelectorItemInfo("avgWgtTo"));
    	sic.add(new SelectorItemInfo("Entrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entrys.farmer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entrys.farmer.id"));
			sic.add(new SelectorItemInfo("Entrys.farmer.name"));
        	sic.add(new SelectorItemInfo("Entrys.farmer.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entrys.farm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entrys.farm.id"));
			sic.add(new SelectorItemInfo("Entrys.farm.name"));
        	sic.add(new SelectorItemInfo("Entrys.farm.number"));
		}
    	sic.add(new SelectorItemInfo("PolicyEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PolicyEntry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("PolicyEntry.policyDatR"));
    	sic.add(new SelectorItemInfo("PolicyEntry.matSelect"));
    	sic.add(new SelectorItemInfo("PolicyEntry.unit"));
    	sic.add(new SelectorItemInfo("PolicyEntry.beginDate"));
    	sic.add(new SelectorItemInfo("PolicyEntry.endDate"));
    	sic.add(new SelectorItemInfo("PolicyEntry.wgtBegin"));
    	sic.add(new SelectorItemInfo("PolicyEntry.wgtEnd"));
    	sic.add(new SelectorItemInfo("PolicyEntry.price"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedData.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedData.id"));
        	sic.add(new SelectorItemInfo("breedData.number"));
        	sic.add(new SelectorItemInfo("breedData.name"));
		}
    	sic.add(new SelectorItemInfo("MarketPriceEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("MarketPriceEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("MarketPriceEntrys.minPrice"));
    	sic.add(new SelectorItemInfo("MarketPriceEntrys.highSymbol"));
    	sic.add(new SelectorItemInfo("MarketPriceEntrys.maxPrice"));
    	sic.add(new SelectorItemInfo("MarketPriceEntrys.lessSymbol"));
    	sic.add(new SelectorItemInfo("MarketPriceEntrys.subsidyPrice"));
        return sic;
    }        
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basedata.TempPolicyFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basedata.TempPolicyFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractTempPolicyEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractTempPolicyEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.basedata.client", "TempPolicyEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.client.TempPolicyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basedata.TempPolicyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basedata.TempPolicyInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.TempPolicyInfo();
				if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));
 
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"编码"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtName.getItemDataByLang(new LanguageInfo(com.kingdee.eas.common.client.SysContext.getSysContext().getLocale())))) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"名称"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtFICompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"farmer").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖户"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"farm").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbreedData.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"品种"});
		}
		for (int i=0,n=kdtMarketPriceEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtMarketPriceEntrys.getCell(i,"subsidyPrice").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"补贴价格"});
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
		vo.put("baseStatus",new Integer(1));
vo.put("dateRelate","0");
vo.put("materialType","0");
vo.put("calUnit","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}