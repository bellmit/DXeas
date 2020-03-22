/**
 * output package name
 */
package com.kingdee.eas.custom.wages.client;

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
public abstract class AbstractBasicPostEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBasicPostEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPostSalary;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttheGroup;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contProductRatio;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contExtractFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBasicWages;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpostname;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contposition;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contslaughter;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcoefficient;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contUnitMetering;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwagesType;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCoefficientRate;
    protected com.kingdee.bos.ctrl.swing.KDButton importExcel;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtPostSalary;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmttheGroup;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtProductRatio;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtExtractFrom;
    protected com.kingdee.bos.ctrl.swing.KDComboBox BaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtBasicWages;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpostname;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtposition;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtslaughter;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcoefficient;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDComboBox UnitMetering;
    protected com.kingdee.bos.ctrl.swing.KDComboBox wagesType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCoefficientRate;
    protected com.kingdee.eas.custom.wages.BasicPostInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractBasicPostEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBasicPostEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contPostSalary = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttheGroup = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contProductRatio = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contExtractFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBasicWages = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpostname = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contposition = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contslaughter = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcoefficient = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contUnitMetering = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contwagesType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contCoefficientRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.importExcel = new com.kingdee.bos.ctrl.swing.KDButton();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtPostSalary = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmttheGroup = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtProductRatio = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtExtractFrom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.BaseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtBasicWages = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpostname = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtposition = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtslaughter = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcoefficient = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.UnitMetering = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.wagesType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtCoefficientRate = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contPostSalary.setName("contPostSalary");
        this.conttheGroup.setName("conttheGroup");
        this.contProductRatio.setName("contProductRatio");
        this.contExtractFrom.setName("contExtractFrom");
        this.contBaseStatus.setName("contBaseStatus");
        this.contBasicWages.setName("contBasicWages");
        this.contpostname.setName("contpostname");
        this.contposition.setName("contposition");
        this.contslaughter.setName("contslaughter");
        this.contcoefficient.setName("contcoefficient");
        this.contcompany.setName("contcompany");
        this.contUnitMetering.setName("contUnitMetering");
        this.contwagesType.setName("contwagesType");
        this.kdtEntry.setName("kdtEntry");
        this.contCoefficientRate.setName("contCoefficientRate");
        this.importExcel.setName("importExcel");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtPostSalary.setName("txtPostSalary");
        this.prmttheGroup.setName("prmttheGroup");
        this.txtProductRatio.setName("txtProductRatio");
        this.prmtExtractFrom.setName("prmtExtractFrom");
        this.BaseStatus.setName("BaseStatus");
        this.txtBasicWages.setName("txtBasicWages");
        this.txtpostname.setName("txtpostname");
        this.prmtposition.setName("prmtposition");
        this.txtslaughter.setName("txtslaughter");
        this.txtcoefficient.setName("txtcoefficient");
        this.prmtcompany.setName("prmtcompany");
        this.UnitMetering.setName("UnitMetering");
        this.wagesType.setName("wagesType");
        this.prmtCoefficientRate.setName("prmtCoefficientRate");
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
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(false);
        // contPostSalary		
        this.contPostSalary.setBoundLabelText(resHelper.getString("contPostSalary.boundLabelText"));		
        this.contPostSalary.setBoundLabelLength(100);		
        this.contPostSalary.setBoundLabelUnderline(true);		
        this.contPostSalary.setVisible(false);
        // conttheGroup		
        this.conttheGroup.setBoundLabelText(resHelper.getString("conttheGroup.boundLabelText"));		
        this.conttheGroup.setBoundLabelLength(100);		
        this.conttheGroup.setBoundLabelUnderline(true);		
        this.conttheGroup.setVisible(true);
        // contProductRatio		
        this.contProductRatio.setBoundLabelText(resHelper.getString("contProductRatio.boundLabelText"));		
        this.contProductRatio.setBoundLabelLength(100);		
        this.contProductRatio.setBoundLabelUnderline(true);		
        this.contProductRatio.setVisible(true);
        // contExtractFrom		
        this.contExtractFrom.setBoundLabelText(resHelper.getString("contExtractFrom.boundLabelText"));		
        this.contExtractFrom.setBoundLabelLength(100);		
        this.contExtractFrom.setBoundLabelUnderline(true);		
        this.contExtractFrom.setVisible(true);
        // contBaseStatus		
        this.contBaseStatus.setBoundLabelText(resHelper.getString("contBaseStatus.boundLabelText"));		
        this.contBaseStatus.setBoundLabelLength(100);		
        this.contBaseStatus.setBoundLabelUnderline(true);		
        this.contBaseStatus.setVisible(true);
        // contBasicWages		
        this.contBasicWages.setBoundLabelText(resHelper.getString("contBasicWages.boundLabelText"));		
        this.contBasicWages.setBoundLabelLength(100);		
        this.contBasicWages.setBoundLabelUnderline(true);		
        this.contBasicWages.setVisible(true);
        // contpostname		
        this.contpostname.setBoundLabelText(resHelper.getString("contpostname.boundLabelText"));		
        this.contpostname.setBoundLabelLength(100);		
        this.contpostname.setBoundLabelUnderline(true);		
        this.contpostname.setVisible(true);
        // contposition		
        this.contposition.setBoundLabelText(resHelper.getString("contposition.boundLabelText"));		
        this.contposition.setBoundLabelLength(100);		
        this.contposition.setBoundLabelUnderline(true);		
        this.contposition.setVisible(true);
        // contslaughter		
        this.contslaughter.setBoundLabelText(resHelper.getString("contslaughter.boundLabelText"));		
        this.contslaughter.setBoundLabelLength(100);		
        this.contslaughter.setBoundLabelUnderline(true);		
        this.contslaughter.setVisible(true);
        // contcoefficient		
        this.contcoefficient.setBoundLabelText(resHelper.getString("contcoefficient.boundLabelText"));		
        this.contcoefficient.setBoundLabelLength(100);		
        this.contcoefficient.setBoundLabelUnderline(true);		
        this.contcoefficient.setVisible(false);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contUnitMetering		
        this.contUnitMetering.setBoundLabelText(resHelper.getString("contUnitMetering.boundLabelText"));		
        this.contUnitMetering.setBoundLabelLength(100);		
        this.contUnitMetering.setBoundLabelUnderline(true);		
        this.contUnitMetering.setVisible(true);
        // contwagesType		
        this.contwagesType.setBoundLabelText(resHelper.getString("contwagesType.boundLabelText"));		
        this.contwagesType.setBoundLabelLength(100);		
        this.contwagesType.setBoundLabelUnderline(true);		
        this.contwagesType.setVisible(true);
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"person\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"personnumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"bankcar\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"idcard\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"phonenumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"score\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"isQuit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{person}</t:Cell><t:Cell>$Resource{personnumber}</t:Cell><t:Cell>$Resource{bankcar}</t:Cell><t:Cell>$Resource{idcard}</t:Cell><t:Cell>$Resource{phonenumber}</t:Cell><t:Cell>$Resource{score}</t:Cell><t:Cell>$Resource{isQuit}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntry.putBindContents("editData",new String[] {"seq","person","personnumber","bankcar","idcard","phonenumber","score","isQuit"});


        this.kdtEntry.checkParsed();
        KDFormattedTextField kdtEntry_seq_TextField = new KDFormattedTextField();
        kdtEntry_seq_TextField.setName("kdtEntry_seq_TextField");
        kdtEntry_seq_TextField.setVisible(true);
        kdtEntry_seq_TextField.setEditable(true);
        kdtEntry_seq_TextField.setHorizontalAlignment(2);
        kdtEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtEntry_seq_TextField);
        this.kdtEntry.getColumn("seq").setEditor(kdtEntry_seq_CellEditor);
        final KDBizPromptBox kdtEntry_person_PromptBox = new KDBizPromptBox();
        kdtEntry_person_PromptBox.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");
        kdtEntry_person_PromptBox.setVisible(true);
        kdtEntry_person_PromptBox.setEditable(true);
        kdtEntry_person_PromptBox.setDisplayFormat("$number$");
        kdtEntry_person_PromptBox.setEditFormat("$number$");
        kdtEntry_person_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_person_CellEditor = new KDTDefaultCellEditor(kdtEntry_person_PromptBox);
        this.kdtEntry.getColumn("person").setEditor(kdtEntry_person_CellEditor);
        ObjectValueRender kdtEntry_person_OVR = new ObjectValueRender();
        kdtEntry_person_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("person").setRenderer(kdtEntry_person_OVR);
        KDTextField kdtEntry_personnumber_TextField = new KDTextField();
        kdtEntry_personnumber_TextField.setName("kdtEntry_personnumber_TextField");
        kdtEntry_personnumber_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_personnumber_CellEditor = new KDTDefaultCellEditor(kdtEntry_personnumber_TextField);
        this.kdtEntry.getColumn("personnumber").setEditor(kdtEntry_personnumber_CellEditor);
        KDTextField kdtEntry_bankcar_TextField = new KDTextField();
        kdtEntry_bankcar_TextField.setName("kdtEntry_bankcar_TextField");
        kdtEntry_bankcar_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntry_bankcar_CellEditor = new KDTDefaultCellEditor(kdtEntry_bankcar_TextField);
        this.kdtEntry.getColumn("bankcar").setEditor(kdtEntry_bankcar_CellEditor);
        KDTextField kdtEntry_idcard_TextField = new KDTextField();
        kdtEntry_idcard_TextField.setName("kdtEntry_idcard_TextField");
        kdtEntry_idcard_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntry_idcard_CellEditor = new KDTDefaultCellEditor(kdtEntry_idcard_TextField);
        this.kdtEntry.getColumn("idcard").setEditor(kdtEntry_idcard_CellEditor);
        KDTextField kdtEntry_phonenumber_TextField = new KDTextField();
        kdtEntry_phonenumber_TextField.setName("kdtEntry_phonenumber_TextField");
        kdtEntry_phonenumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntry_phonenumber_CellEditor = new KDTDefaultCellEditor(kdtEntry_phonenumber_TextField);
        this.kdtEntry.getColumn("phonenumber").setEditor(kdtEntry_phonenumber_CellEditor);
        KDFormattedTextField kdtEntry_score_TextField = new KDFormattedTextField();
        kdtEntry_score_TextField.setName("kdtEntry_score_TextField");
        kdtEntry_score_TextField.setVisible(true);
        kdtEntry_score_TextField.setEditable(true);
        kdtEntry_score_TextField.setHorizontalAlignment(2);
        kdtEntry_score_TextField.setDataType(1);
        	kdtEntry_score_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_score_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_score_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_score_CellEditor = new KDTDefaultCellEditor(kdtEntry_score_TextField);
        this.kdtEntry.getColumn("score").setEditor(kdtEntry_score_CellEditor);
        KDCheckBox kdtEntry_isQuit_CheckBox = new KDCheckBox();
        kdtEntry_isQuit_CheckBox.setName("kdtEntry_isQuit_CheckBox");
        KDTDefaultCellEditor kdtEntry_isQuit_CellEditor = new KDTDefaultCellEditor(kdtEntry_isQuit_CheckBox);
        this.kdtEntry.getColumn("isQuit").setEditor(kdtEntry_isQuit_CellEditor);
        // contCoefficientRate		
        this.contCoefficientRate.setBoundLabelText(resHelper.getString("contCoefficientRate.boundLabelText"));		
        this.contCoefficientRate.setBoundLabelLength(100);		
        this.contCoefficientRate.setBoundLabelUnderline(true);		
        this.contCoefficientRate.setVisible(true);
        // importExcel		
        this.importExcel.setText(resHelper.getString("importExcel.text"));
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // txtPostSalary		
        this.txtPostSalary.setHorizontalAlignment(2);		
        this.txtPostSalary.setDataType(1);		
        this.txtPostSalary.setSupportedEmpty(true);		
        this.txtPostSalary.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtPostSalary.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtPostSalary.setPrecision(2);		
        this.txtPostSalary.setRequired(false);		
        this.txtPostSalary.setVisible(false);
        // prmttheGroup		
        this.prmttheGroup.setQueryInfo("com.kingdee.eas.custom.wages.app.WageOrganizationQuery");		
        this.prmttheGroup.setEditable(true);		
        this.prmttheGroup.setDisplayFormat("$name$");		
        this.prmttheGroup.setEditFormat("$number$");		
        this.prmttheGroup.setCommitFormat("$number$");		
        this.prmttheGroup.setRequired(true);
        		prmttheGroup.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.custom.wages.client.WageOrganizationListUI prmttheGroup_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmttheGroup_F7ListUI == null) {
					try {
						prmttheGroup_F7ListUI = new com.kingdee.eas.custom.wages.client.WageOrganizationListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmttheGroup_F7ListUI));
					prmttheGroup_F7ListUI.setF7Use(true,ctx);
					prmttheGroup.setSelector(prmttheGroup_F7ListUI);
				}
			}
		});
					
        // txtProductRatio		
        this.txtProductRatio.setHorizontalAlignment(2);		
        this.txtProductRatio.setDataType(1);		
        this.txtProductRatio.setSupportedEmpty(true);		
        this.txtProductRatio.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtProductRatio.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtProductRatio.setPrecision(4);		
        this.txtProductRatio.setRequired(true);
        // prmtExtractFrom		
        this.prmtExtractFrom.setQueryInfo("com.kingdee.eas.custom.wages.app.ExtractFromQuery");		
        this.prmtExtractFrom.setEditable(true);		
        this.prmtExtractFrom.setDisplayFormat("$name$");		
        this.prmtExtractFrom.setEditFormat("$number$");		
        this.prmtExtractFrom.setCommitFormat("$number$");		
        this.prmtExtractFrom.setRequired(true);
        // BaseStatus		
        this.BaseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.wages.BasicStatus").toArray());		
        this.BaseStatus.setRequired(false);
        // txtBasicWages		
        this.txtBasicWages.setHorizontalAlignment(2);		
        this.txtBasicWages.setDataType(1);		
        this.txtBasicWages.setSupportedEmpty(true);		
        this.txtBasicWages.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtBasicWages.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtBasicWages.setPrecision(2);		
        this.txtBasicWages.setRequired(false);
        // txtpostname		
        this.txtpostname.setHorizontalAlignment(2);		
        this.txtpostname.setMaxLength(100);		
        this.txtpostname.setRequired(false);
        // prmtposition		
        this.prmtposition.setQueryInfo("com.kingdee.eas.basedata.org.app.PositionQuery");		
        this.prmtposition.setEditable(true);		
        this.prmtposition.setDisplayFormat("$name$");		
        this.prmtposition.setEditFormat("$number$");		
        this.prmtposition.setCommitFormat("$number$");		
        this.prmtposition.setRequired(false);
        // txtslaughter		
        this.txtslaughter.setHorizontalAlignment(2);		
        this.txtslaughter.setDataType(1);		
        this.txtslaughter.setSupportedEmpty(true);		
        this.txtslaughter.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtslaughter.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtslaughter.setPrecision(4);		
        this.txtslaughter.setRequired(false);
        // txtcoefficient		
        this.txtcoefficient.setHorizontalAlignment(2);		
        this.txtcoefficient.setDataType(1);		
        this.txtcoefficient.setSupportedEmpty(true);		
        this.txtcoefficient.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcoefficient.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcoefficient.setPrecision(4);		
        this.txtcoefficient.setRequired(false);		
        this.txtcoefficient.setVisible(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // UnitMetering		
        this.UnitMetering.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.wages.FractionUnit").toArray());		
        this.UnitMetering.setRequired(false);
        // wagesType		
        this.wagesType.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.wages.wagesType").toArray());		
        this.wagesType.setRequired(false);
        // prmtCoefficientRate		
        this.prmtCoefficientRate.setQueryInfo("com.kingdee.eas.custom.wages.app.CoefficientQuery");		
        this.prmtCoefficientRate.setEditable(true);		
        this.prmtCoefficientRate.setDisplayFormat("$CoefficientRate$");		
        this.prmtCoefficientRate.setEditFormat("$number$");		
        this.prmtCoefficientRate.setCommitFormat("$number$");		
        this.prmtCoefficientRate.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtProductRatio,txtPostSalary,prmttheGroup,txtSimpleName,txtDescription,txtNumber,txtName,prmtExtractFrom,BaseStatus,txtBasicWages,txtpostname,prmtposition,txtslaughter,txtcoefficient,prmtcompany,UnitMetering,wagesType,prmtCoefficientRate,kdtEntry}));
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
        this.setBounds(new Rectangle(0, 2, 1013, 637));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 2, 1013, 637));
        kDLabelContainer1.setBounds(new Rectangle(30, 25, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(30, 25, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(-342, 25, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(-342, 25, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(694, -23, 270, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(694, -23, 270, 19, 0));
        kDLabelContainer4.setBounds(new Rectangle(976, 139, 270, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(976, 139, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contPostSalary.setBounds(new Rectangle(976, 105, 270, 19));
        this.add(contPostSalary, new KDLayout.Constraints(976, 105, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conttheGroup.setBounds(new Rectangle(30, 61, 270, 19));
        this.add(conttheGroup, new KDLayout.Constraints(30, 61, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contProductRatio.setBounds(new Rectangle(363, 61, 270, 19));
        this.add(contProductRatio, new KDLayout.Constraints(363, 61, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contExtractFrom.setBounds(new Rectangle(30, 97, 270, 19));
        this.add(contExtractFrom, new KDLayout.Constraints(30, 97, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBaseStatus.setBounds(new Rectangle(696, 25, 270, 19));
        this.add(contBaseStatus, new KDLayout.Constraints(696, 25, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contBasicWages.setBounds(new Rectangle(696, 97, 270, 19));
        this.add(contBasicWages, new KDLayout.Constraints(696, 97, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpostname.setBounds(new Rectangle(30, 133, 270, 19));
        this.add(contpostname, new KDLayout.Constraints(30, 133, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contposition.setBounds(new Rectangle(363, 25, 270, 19));
        this.add(contposition, new KDLayout.Constraints(363, 25, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contslaughter.setBounds(new Rectangle(696, 133, 270, 19));
        this.add(contslaughter, new KDLayout.Constraints(696, 133, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcoefficient.setBounds(new Rectangle(363, 168, 270, 19));
        this.add(contcoefficient, new KDLayout.Constraints(363, 168, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(696, 61, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(696, 61, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contUnitMetering.setBounds(new Rectangle(363, 97, 270, 19));
        this.add(contUnitMetering, new KDLayout.Constraints(363, 97, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contwagesType.setBounds(new Rectangle(30, 170, 270, 19));
        this.add(contwagesType, new KDLayout.Constraints(30, 170, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntry.setBounds(new Rectangle(30, 215, 937, 359));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.custom.wages.BasicPostEntryInfo(),null,false);
        this.add(kdtEntry_detailPanel, new KDLayout.Constraints(30, 215, 937, 359, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contCoefficientRate.setBounds(new Rectangle(363, 134, 270, 19));
        this.add(contCoefficientRate, new KDLayout.Constraints(363, 134, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        importExcel.setBounds(new Rectangle(846, 177, 120, 25));
        this.add(importExcel, new KDLayout.Constraints(846, 177, 120, 25, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contPostSalary
        contPostSalary.setBoundEditor(txtPostSalary);
        //conttheGroup
        conttheGroup.setBoundEditor(prmttheGroup);
        //contProductRatio
        contProductRatio.setBoundEditor(txtProductRatio);
        //contExtractFrom
        contExtractFrom.setBoundEditor(prmtExtractFrom);
        //contBaseStatus
        contBaseStatus.setBoundEditor(BaseStatus);
        //contBasicWages
        contBasicWages.setBoundEditor(txtBasicWages);
        //contpostname
        contpostname.setBoundEditor(txtpostname);
        //contposition
        contposition.setBoundEditor(prmtposition);
        //contslaughter
        contslaughter.setBoundEditor(txtslaughter);
        //contcoefficient
        contcoefficient.setBoundEditor(txtcoefficient);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contUnitMetering
        contUnitMetering.setBoundEditor(UnitMetering);
        //contwagesType
        contwagesType.setBoundEditor(wagesType);
        //contCoefficientRate
        contCoefficientRate.setBoundEditor(prmtCoefficientRate);

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
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.custom.wages.BasicPostEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.person", java.lang.Object.class, this.kdtEntry, "person.text");
		dataBinder.registerBinding("Entry.personnumber", String.class, this.kdtEntry, "personnumber.text");
		dataBinder.registerBinding("Entry.score", java.math.BigDecimal.class, this.kdtEntry, "score.text");
		dataBinder.registerBinding("Entry.bankcar", String.class, this.kdtEntry, "bankcar.text");
		dataBinder.registerBinding("Entry.idcard", String.class, this.kdtEntry, "idcard.text");
		dataBinder.registerBinding("Entry.phonenumber", String.class, this.kdtEntry, "phonenumber.text");
		dataBinder.registerBinding("Entry.isQuit", boolean.class, this.kdtEntry, "isQuit.text");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("PostSalary", java.math.BigDecimal.class, this.txtPostSalary, "value");
		dataBinder.registerBinding("theGroup", com.kingdee.eas.custom.wages.WageOrganizationInfo.class, this.prmttheGroup, "data");
		dataBinder.registerBinding("ProductRatio", java.math.BigDecimal.class, this.txtProductRatio, "value");
		dataBinder.registerBinding("ExtractFrom", com.kingdee.eas.custom.wages.ExtractFromInfo.class, this.prmtExtractFrom, "data");
		dataBinder.registerBinding("BaseStatus", com.kingdee.eas.custom.wages.BasicStatus.class, this.BaseStatus, "selectedItem");
		dataBinder.registerBinding("BasicWages", java.math.BigDecimal.class, this.txtBasicWages, "value");
		dataBinder.registerBinding("postname", String.class, this.txtpostname, "text");
		dataBinder.registerBinding("position", com.kingdee.eas.basedata.org.PositionInfo.class, this.prmtposition, "data");
		dataBinder.registerBinding("slaughter", java.math.BigDecimal.class, this.txtslaughter, "value");
		dataBinder.registerBinding("coefficient", java.math.BigDecimal.class, this.txtcoefficient, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("UnitMetering", com.kingdee.eas.custom.wages.FractionUnit.class, this.UnitMetering, "selectedItem");
		dataBinder.registerBinding("wagesType", com.kingdee.eas.custom.wages.wagesType.class, this.wagesType, "selectedItem");
		dataBinder.registerBinding("CoefficientRate", com.kingdee.eas.custom.wages.CoefficientInfo.class, this.prmtCoefficientRate, "data");		
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
	    return "com.kingdee.eas.custom.wages.app.BasicPostEditUIHandler";
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
        this.txtProductRatio.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.wages.BasicPostInfo)ov;
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
		getValidateHelper().registerBindProperty("Entry.person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.personnumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.score", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.bankcar", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.idcard", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.phonenumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.isQuit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PostSalary", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("theGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ProductRatio", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ExtractFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BaseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BasicWages", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("postname", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("position", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("slaughter", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("coefficient", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("UnitMetering", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("wagesType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CoefficientRate", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("person".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"personnumber").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"person").getValue(),"number")));

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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.person.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.person.id"));
			sic.add(new SelectorItemInfo("Entry.person.name"));
        	sic.add(new SelectorItemInfo("Entry.person.number"));
		}
    	sic.add(new SelectorItemInfo("Entry.personnumber"));
    	sic.add(new SelectorItemInfo("Entry.score"));
    	sic.add(new SelectorItemInfo("Entry.bankcar"));
    	sic.add(new SelectorItemInfo("Entry.idcard"));
    	sic.add(new SelectorItemInfo("Entry.phonenumber"));
    	sic.add(new SelectorItemInfo("Entry.isQuit"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("PostSalary"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("theGroup.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("theGroup.id"));
        	sic.add(new SelectorItemInfo("theGroup.number"));
        	sic.add(new SelectorItemInfo("theGroup.name"));
		}
        sic.add(new SelectorItemInfo("ProductRatio"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ExtractFrom.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("ExtractFrom.id"));
        	sic.add(new SelectorItemInfo("ExtractFrom.number"));
        	sic.add(new SelectorItemInfo("ExtractFrom.name"));
		}
        sic.add(new SelectorItemInfo("BaseStatus"));
        sic.add(new SelectorItemInfo("BasicWages"));
        sic.add(new SelectorItemInfo("postname"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("position.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("position.id"));
        	sic.add(new SelectorItemInfo("position.number"));
        	sic.add(new SelectorItemInfo("position.name"));
		}
        sic.add(new SelectorItemInfo("slaughter"));
        sic.add(new SelectorItemInfo("coefficient"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("UnitMetering"));
        sic.add(new SelectorItemInfo("wagesType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CoefficientRate.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("CoefficientRate.id"));
        	sic.add(new SelectorItemInfo("CoefficientRate.number"));
        	sic.add(new SelectorItemInfo("CoefficientRate.name"));
        	sic.add(new SelectorItemInfo("CoefficientRate.CoefficientRate"));
		}
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.wages.client", "BasicPostEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.wages.client.BasicPostEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.wages.BasicPostFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.wages.BasicPostInfo objectValue = new com.kingdee.eas.custom.wages.BasicPostInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntry.getCell(i,"person").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"员工"});
			}
		}
		for (int i=0,n=kdtEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntry.getCell(i,"personnumber").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"员工编码"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmttheGroup.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"所属班组"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtProductRatio.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"产品系数"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtExtractFrom.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"提取来源"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"公司"});
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
				vo.put("PostSalary",new java.math.BigDecimal(0));
vo.put("BaseStatus","0");
vo.put("UnitMetering","0");
vo.put("wagesType","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}