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
public abstract class AbstractFarmEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFarmEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contarea;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsuccahQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfloorArea;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostCenter;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHouseManager;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwarehouse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmType;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisAllot;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFaemsType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contparentHenWare;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtaddress;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtarea;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsuccahQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtHouseEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtHouseEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfloorArea;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcostCenter;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtwarehouse;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDComboBox farmType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtgm;
    protected com.kingdee.bos.ctrl.swing.KDComboBox FaemsType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtparentHenWare;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.eas.farm.stocking.basedata.FarmInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractFarmEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFarmEditUI.class.getName());
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
        this.contaddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contarea = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsuccahQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contfloorArea = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostCenter = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisHouseManager = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contwarehouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisAllot = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contgm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFaemsType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contparentHenWare = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtaddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtarea = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtsuccahQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtHouseEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.txtfloorArea = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcostCenter = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtwarehouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtstorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.farmType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtgm = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.FaemsType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtparentHenWare = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contaddress.setName("contaddress");
        this.contarea.setName("contarea");
        this.contbaseStatus.setName("contbaseStatus");
        this.contsuccahQty.setName("contsuccahQty");
        this.contcompany.setName("contcompany");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contfloorArea.setName("contfloorArea");
        this.contcostCenter.setName("contcostCenter");
        this.chkisHouseManager.setName("chkisHouseManager");
        this.contwarehouse.setName("contwarehouse");
        this.contstorageOrgUnit.setName("contstorageOrgUnit");
        this.contfarmType.setName("contfarmType");
        this.chkisAllot.setName("chkisAllot");
        this.contgm.setName("contgm");
        this.contFaemsType.setName("contFaemsType");
        this.contparentHenWare.setName("contparentHenWare");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtaddress.setName("txtaddress");
        this.txtarea.setName("txtarea");
        this.baseStatus.setName("baseStatus");
        this.txtsuccahQty.setName("txtsuccahQty");
        this.prmtcompany.setName("prmtcompany");
        this.kDPanel1.setName("kDPanel1");
        this.kdtHouseEntry.setName("kdtHouseEntry");
        this.txtfloorArea.setName("txtfloorArea");
        this.prmtcostCenter.setName("prmtcostCenter");
        this.prmtwarehouse.setName("prmtwarehouse");
        this.prmtstorageOrgUnit.setName("prmtstorageOrgUnit");
        this.farmType.setName("farmType");
        this.txtgm.setName("txtgm");
        this.FaemsType.setName("FaemsType");
        this.prmtparentHenWare.setName("prmtparentHenWare");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
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
        this.kDLabelContainer3.setVisible(false);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(false);
        // contaddress		
        this.contaddress.setBoundLabelText(resHelper.getString("contaddress.boundLabelText"));		
        this.contaddress.setBoundLabelLength(100);		
        this.contaddress.setBoundLabelUnderline(true);		
        this.contaddress.setVisible(true);
        // contarea		
        this.contarea.setBoundLabelText(resHelper.getString("contarea.boundLabelText"));		
        this.contarea.setBoundLabelLength(80);		
        this.contarea.setBoundLabelUnderline(true);		
        this.contarea.setVisible(true);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // contsuccahQty		
        this.contsuccahQty.setBoundLabelText(resHelper.getString("contsuccahQty.boundLabelText"));		
        this.contsuccahQty.setBoundLabelLength(100);		
        this.contsuccahQty.setBoundLabelUnderline(true);		
        this.contsuccahQty.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // kDTabbedPane1
        // contfloorArea		
        this.contfloorArea.setBoundLabelText(resHelper.getString("contfloorArea.boundLabelText"));		
        this.contfloorArea.setBoundLabelLength(80);		
        this.contfloorArea.setBoundLabelUnderline(true);		
        this.contfloorArea.setVisible(true);
        // contcostCenter		
        this.contcostCenter.setBoundLabelText(resHelper.getString("contcostCenter.boundLabelText"));		
        this.contcostCenter.setBoundLabelLength(100);		
        this.contcostCenter.setBoundLabelUnderline(true);		
        this.contcostCenter.setVisible(true);
        // chkisHouseManager		
        this.chkisHouseManager.setText(resHelper.getString("chkisHouseManager.text"));		
        this.chkisHouseManager.setHorizontalAlignment(2);
        // contwarehouse		
        this.contwarehouse.setBoundLabelText(resHelper.getString("contwarehouse.boundLabelText"));		
        this.contwarehouse.setBoundLabelLength(100);		
        this.contwarehouse.setBoundLabelUnderline(true);		
        this.contwarehouse.setVisible(true);
        // contstorageOrgUnit		
        this.contstorageOrgUnit.setBoundLabelText(resHelper.getString("contstorageOrgUnit.boundLabelText"));		
        this.contstorageOrgUnit.setBoundLabelLength(100);		
        this.contstorageOrgUnit.setBoundLabelUnderline(true);		
        this.contstorageOrgUnit.setVisible(true);
        // contfarmType		
        this.contfarmType.setBoundLabelText(resHelper.getString("contfarmType.boundLabelText"));		
        this.contfarmType.setBoundLabelLength(100);		
        this.contfarmType.setBoundLabelUnderline(true);		
        this.contfarmType.setVisible(true);
        // chkisAllot		
        this.chkisAllot.setText(resHelper.getString("chkisAllot.text"));		
        this.chkisAllot.setHorizontalAlignment(2);
        // contgm		
        this.contgm.setBoundLabelText(resHelper.getString("contgm.boundLabelText"));		
        this.contgm.setBoundLabelLength(100);		
        this.contgm.setBoundLabelUnderline(true);		
        this.contgm.setVisible(true);
        // contFaemsType		
        this.contFaemsType.setBoundLabelText(resHelper.getString("contFaemsType.boundLabelText"));		
        this.contFaemsType.setBoundLabelLength(100);		
        this.contFaemsType.setBoundLabelUnderline(true);		
        this.contFaemsType.setVisible(true);
        // contparentHenWare		
        this.contparentHenWare.setBoundLabelText(resHelper.getString("contparentHenWare.boundLabelText"));		
        this.contparentHenWare.setBoundLabelLength(100);		
        this.contparentHenWare.setBoundLabelUnderline(true);		
        this.contparentHenWare.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setEnabled(false);
        // txtName		
        this.txtName.setRequired(true);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // txtaddress		
        this.txtaddress.setHorizontalAlignment(2);		
        this.txtaddress.setMaxLength(200);		
        this.txtaddress.setRequired(false);
        // txtarea		
        this.txtarea.setHorizontalAlignment(2);		
        this.txtarea.setDataType(1);		
        this.txtarea.setSupportedEmpty(true);		
        this.txtarea.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtarea.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtarea.setPrecision(4);		
        this.txtarea.setRequired(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // txtsuccahQty		
        this.txtsuccahQty.setHorizontalAlignment(2);		
        this.txtsuccahQty.setDataType(0);		
        this.txtsuccahQty.setSupportedEmpty(true);		
        this.txtsuccahQty.setRequired(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // kDPanel1
        // kdtHouseEntry
		String kdtHouseEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"area\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"floorArea\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"scale\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"costCentor\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"warehouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"slwarehouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"ypwarehousse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"breedPerson\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"spdwareHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{area}</t:Cell><t:Cell>$Resource{floorArea}</t:Cell><t:Cell>$Resource{scale}</t:Cell><t:Cell>$Resource{costCentor}</t:Cell><t:Cell>$Resource{warehouse}</t:Cell><t:Cell>$Resource{slwarehouse}</t:Cell><t:Cell>$Resource{ypwarehousse}</t:Cell><t:Cell>$Resource{breedPerson}</t:Cell><t:Cell>$Resource{spdwareHouse}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtHouseEntry.setFormatXml(resHelper.translateString("kdtHouseEntry",kdtHouseEntryStrXML));

                this.kdtHouseEntry.putBindContents("editData",new String[] {"seq","number","name","area","floorArea","scale","costCentor","warehouse","slwarehouse","ypwarehousse","breedPerson","spdwareHouse"});


        this.kdtHouseEntry.checkParsed();
        KDTextField kdtHouseEntry_number_TextField = new KDTextField();
        kdtHouseEntry_number_TextField.setName("kdtHouseEntry_number_TextField");
        kdtHouseEntry_number_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtHouseEntry_number_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_number_TextField);
        this.kdtHouseEntry.getColumn("number").setEditor(kdtHouseEntry_number_CellEditor);
        KDTextField kdtHouseEntry_name_TextField = new KDTextField();
        kdtHouseEntry_name_TextField.setName("kdtHouseEntry_name_TextField");
        kdtHouseEntry_name_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtHouseEntry_name_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_name_TextField);
        this.kdtHouseEntry.getColumn("name").setEditor(kdtHouseEntry_name_CellEditor);
        KDFormattedTextField kdtHouseEntry_area_TextField = new KDFormattedTextField();
        kdtHouseEntry_area_TextField.setName("kdtHouseEntry_area_TextField");
        kdtHouseEntry_area_TextField.setVisible(true);
        kdtHouseEntry_area_TextField.setEditable(true);
        kdtHouseEntry_area_TextField.setHorizontalAlignment(2);
        kdtHouseEntry_area_TextField.setDataType(1);
        	kdtHouseEntry_area_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtHouseEntry_area_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtHouseEntry_area_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtHouseEntry_area_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_area_TextField);
        this.kdtHouseEntry.getColumn("area").setEditor(kdtHouseEntry_area_CellEditor);
        KDFormattedTextField kdtHouseEntry_floorArea_TextField = new KDFormattedTextField();
        kdtHouseEntry_floorArea_TextField.setName("kdtHouseEntry_floorArea_TextField");
        kdtHouseEntry_floorArea_TextField.setVisible(true);
        kdtHouseEntry_floorArea_TextField.setEditable(true);
        kdtHouseEntry_floorArea_TextField.setHorizontalAlignment(2);
        kdtHouseEntry_floorArea_TextField.setDataType(1);
        	kdtHouseEntry_floorArea_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtHouseEntry_floorArea_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtHouseEntry_floorArea_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtHouseEntry_floorArea_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_floorArea_TextField);
        this.kdtHouseEntry.getColumn("floorArea").setEditor(kdtHouseEntry_floorArea_CellEditor);
        KDFormattedTextField kdtHouseEntry_scale_TextField = new KDFormattedTextField();
        kdtHouseEntry_scale_TextField.setName("kdtHouseEntry_scale_TextField");
        kdtHouseEntry_scale_TextField.setVisible(true);
        kdtHouseEntry_scale_TextField.setEditable(true);
        kdtHouseEntry_scale_TextField.setHorizontalAlignment(2);
        kdtHouseEntry_scale_TextField.setDataType(0);
        KDTDefaultCellEditor kdtHouseEntry_scale_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_scale_TextField);
        this.kdtHouseEntry.getColumn("scale").setEditor(kdtHouseEntry_scale_CellEditor);
        final KDBizPromptBox kdtHouseEntry_costCentor_PromptBox = new KDBizPromptBox();
        kdtHouseEntry_costCentor_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");
        kdtHouseEntry_costCentor_PromptBox.setVisible(true);
        kdtHouseEntry_costCentor_PromptBox.setEditable(true);
        kdtHouseEntry_costCentor_PromptBox.setDisplayFormat("$number$");
        kdtHouseEntry_costCentor_PromptBox.setEditFormat("$number$");
        kdtHouseEntry_costCentor_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtHouseEntry_costCentor_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_costCentor_PromptBox);
        this.kdtHouseEntry.getColumn("costCentor").setEditor(kdtHouseEntry_costCentor_CellEditor);
        ObjectValueRender kdtHouseEntry_costCentor_OVR = new ObjectValueRender();
        kdtHouseEntry_costCentor_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtHouseEntry.getColumn("costCentor").setRenderer(kdtHouseEntry_costCentor_OVR);
        final KDBizPromptBox kdtHouseEntry_warehouse_PromptBox = new KDBizPromptBox();
        kdtHouseEntry_warehouse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtHouseEntry_warehouse_PromptBox.setVisible(true);
        kdtHouseEntry_warehouse_PromptBox.setEditable(true);
        kdtHouseEntry_warehouse_PromptBox.setDisplayFormat("$number$");
        kdtHouseEntry_warehouse_PromptBox.setEditFormat("$number$");
        kdtHouseEntry_warehouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtHouseEntry_warehouse_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_warehouse_PromptBox);
        this.kdtHouseEntry.getColumn("warehouse").setEditor(kdtHouseEntry_warehouse_CellEditor);
        ObjectValueRender kdtHouseEntry_warehouse_OVR = new ObjectValueRender();
        kdtHouseEntry_warehouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtHouseEntry.getColumn("warehouse").setRenderer(kdtHouseEntry_warehouse_OVR);
        final KDBizPromptBox kdtHouseEntry_slwarehouse_PromptBox = new KDBizPromptBox();
        kdtHouseEntry_slwarehouse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtHouseEntry_slwarehouse_PromptBox.setVisible(true);
        kdtHouseEntry_slwarehouse_PromptBox.setEditable(true);
        kdtHouseEntry_slwarehouse_PromptBox.setDisplayFormat("$number$");
        kdtHouseEntry_slwarehouse_PromptBox.setEditFormat("$number$");
        kdtHouseEntry_slwarehouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtHouseEntry_slwarehouse_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_slwarehouse_PromptBox);
        this.kdtHouseEntry.getColumn("slwarehouse").setEditor(kdtHouseEntry_slwarehouse_CellEditor);
        ObjectValueRender kdtHouseEntry_slwarehouse_OVR = new ObjectValueRender();
        kdtHouseEntry_slwarehouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtHouseEntry.getColumn("slwarehouse").setRenderer(kdtHouseEntry_slwarehouse_OVR);
        final KDBizPromptBox kdtHouseEntry_ypwarehousse_PromptBox = new KDBizPromptBox();
        kdtHouseEntry_ypwarehousse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtHouseEntry_ypwarehousse_PromptBox.setVisible(true);
        kdtHouseEntry_ypwarehousse_PromptBox.setEditable(true);
        kdtHouseEntry_ypwarehousse_PromptBox.setDisplayFormat("$number$");
        kdtHouseEntry_ypwarehousse_PromptBox.setEditFormat("$number$");
        kdtHouseEntry_ypwarehousse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtHouseEntry_ypwarehousse_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_ypwarehousse_PromptBox);
        this.kdtHouseEntry.getColumn("ypwarehousse").setEditor(kdtHouseEntry_ypwarehousse_CellEditor);
        ObjectValueRender kdtHouseEntry_ypwarehousse_OVR = new ObjectValueRender();
        kdtHouseEntry_ypwarehousse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtHouseEntry.getColumn("ypwarehousse").setRenderer(kdtHouseEntry_ypwarehousse_OVR);
        final KDBizPromptBox kdtHouseEntry_breedPerson_PromptBox = new KDBizPromptBox();
        kdtHouseEntry_breedPerson_PromptBox.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");
        kdtHouseEntry_breedPerson_PromptBox.setVisible(true);
        kdtHouseEntry_breedPerson_PromptBox.setEditable(true);
        kdtHouseEntry_breedPerson_PromptBox.setDisplayFormat("$number$");
        kdtHouseEntry_breedPerson_PromptBox.setEditFormat("$number$");
        kdtHouseEntry_breedPerson_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtHouseEntry_breedPerson_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_breedPerson_PromptBox);
        this.kdtHouseEntry.getColumn("breedPerson").setEditor(kdtHouseEntry_breedPerson_CellEditor);
        ObjectValueRender kdtHouseEntry_breedPerson_OVR = new ObjectValueRender();
        kdtHouseEntry_breedPerson_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtHouseEntry.getColumn("breedPerson").setRenderer(kdtHouseEntry_breedPerson_OVR);
        final KDBizPromptBox kdtHouseEntry_spdwareHouse_PromptBox = new KDBizPromptBox();
        kdtHouseEntry_spdwareHouse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtHouseEntry_spdwareHouse_PromptBox.setVisible(true);
        kdtHouseEntry_spdwareHouse_PromptBox.setEditable(true);
        kdtHouseEntry_spdwareHouse_PromptBox.setDisplayFormat("$number$");
        kdtHouseEntry_spdwareHouse_PromptBox.setEditFormat("$number$");
        kdtHouseEntry_spdwareHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtHouseEntry_spdwareHouse_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_spdwareHouse_PromptBox);
        this.kdtHouseEntry.getColumn("spdwareHouse").setEditor(kdtHouseEntry_spdwareHouse_CellEditor);
        ObjectValueRender kdtHouseEntry_spdwareHouse_OVR = new ObjectValueRender();
        kdtHouseEntry_spdwareHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtHouseEntry.getColumn("spdwareHouse").setRenderer(kdtHouseEntry_spdwareHouse_OVR);
        // txtfloorArea		
        this.txtfloorArea.setHorizontalAlignment(2);		
        this.txtfloorArea.setDataType(1);		
        this.txtfloorArea.setSupportedEmpty(true);		
        this.txtfloorArea.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfloorArea.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfloorArea.setPrecision(4);		
        this.txtfloorArea.setRequired(false);
        // prmtcostCenter		
        this.prmtcostCenter.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");		
        this.prmtcostCenter.setEditable(true);		
        this.prmtcostCenter.setDisplayFormat("$name$");		
        this.prmtcostCenter.setEditFormat("$number$");		
        this.prmtcostCenter.setCommitFormat("$number$");		
        this.prmtcostCenter.setRequired(false);
        // prmtwarehouse		
        this.prmtwarehouse.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");		
        this.prmtwarehouse.setEditable(true);		
        this.prmtwarehouse.setDisplayFormat("$name$");		
        this.prmtwarehouse.setEditFormat("$number$");		
        this.prmtwarehouse.setCommitFormat("$number$");		
        this.prmtwarehouse.setRequired(false);
        // prmtstorageOrgUnit		
        this.prmtstorageOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstorageOrgUnit.setEditable(true);		
        this.prmtstorageOrgUnit.setDisplayFormat("$name$");		
        this.prmtstorageOrgUnit.setEditFormat("$number$");		
        this.prmtstorageOrgUnit.setCommitFormat("$number$");		
        this.prmtstorageOrgUnit.setRequired(true);
        // farmType		
        this.farmType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum").toArray());		
        this.farmType.setRequired(true);
        // txtgm		
        this.txtgm.setHorizontalAlignment(2);		
        this.txtgm.setMaxLength(100);		
        this.txtgm.setRequired(false);
        // FaemsType		
        this.FaemsType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmsType").toArray());		
        this.FaemsType.setRequired(false);
        // prmtparentHenWare		
        this.prmtparentHenWare.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.WarehouseQuery");		
        this.prmtparentHenWare.setVisible(true);		
        this.prmtparentHenWare.setEditable(true);		
        this.prmtparentHenWare.setDisplayFormat("$name$");		
        this.prmtparentHenWare.setEditFormat("$number$");		
        this.prmtparentHenWare.setCommitFormat("$number$");		
        this.prmtparentHenWare.setRequired(false);
        // tBtnAudit
        this.tBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnAudit.setText(resHelper.getString("tBtnAudit.text"));
        // tBtnUnAudit
        this.tBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnUnAudit.setText(resHelper.getString("tBtnUnAudit.text"));
        // mBtnAudit
        this.mBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnAudit.setText(resHelper.getString("mBtnAudit.text"));
        // mBtnUnAudit
        this.mBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnUnAudit.setText(resHelper.getString("mBtnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,txtDescription,txtSimpleName,txtaddress,txtarea,baseStatus,txtsuccahQty,prmtcompany,txtfloorArea,prmtcostCenter,chkisHouseManager,prmtwarehouse,prmtstorageOrgUnit,farmType,chkisAllot,kdtHouseEntry,txtgm,FaemsType,prmtparentHenWare}));
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
        this.setBounds(new Rectangle(0, 0, 678, 491));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(29, 17, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(370, 17, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(768, 177, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(766, 210, 270, 19));
        this.add(kDLabelContainer4, null);
        contaddress.setBounds(new Rectangle(29, 98, 415, 19));
        this.add(contaddress, null);
        contarea.setBounds(new Rectangle(29, 71, 135, 19));
        this.add(contarea, null);
        contbaseStatus.setBounds(new Rectangle(370, 44, 270, 19));
        this.add(contbaseStatus, null);
        contsuccahQty.setBounds(new Rectangle(29, 44, 270, 19));
        this.add(contsuccahQty, null);
        contcompany.setBounds(new Rectangle(29, 125, 270, 19));
        this.add(contcompany, null);
        kDTabbedPane1.setBounds(new Rectangle(24, 251, 622, 225));
        this.add(kDTabbedPane1, null);
        contfloorArea.setBounds(new Rectangle(171, 71, 128, 19));
        this.add(contfloorArea, null);
        contcostCenter.setBounds(new Rectangle(370, 125, 270, 19));
        this.add(contcostCenter, null);
        chkisHouseManager.setBounds(new Rectangle(555, 98, 85, 19));
        this.add(chkisHouseManager, null);
        contwarehouse.setBounds(new Rectangle(370, 155, 270, 19));
        this.add(contwarehouse, null);
        contstorageOrgUnit.setBounds(new Rectangle(29, 155, 270, 19));
        this.add(contstorageOrgUnit, null);
        contfarmType.setBounds(new Rectangle(370, 71, 270, 19));
        this.add(contfarmType, null);
        chkisAllot.setBounds(new Rectangle(466, 98, 80, 19));
        this.add(chkisAllot, null);
        contgm.setBounds(new Rectangle(30, 188, 270, 19));
        this.add(contgm, null);
        contFaemsType.setBounds(new Rectangle(370, 188, 270, 19));
        this.add(contFaemsType, null);
        contparentHenWare.setBounds(new Rectangle(30, 223, 270, 19));
        this.add(contparentHenWare, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contaddress
        contaddress.setBoundEditor(txtaddress);
        //contarea
        contarea.setBoundEditor(txtarea);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contsuccahQty
        contsuccahQty.setBoundEditor(txtsuccahQty);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        //kDPanel1
        kDPanel1.setLayout(null);        kdtHouseEntry.setBounds(new Rectangle(2, 1, 612, 190));
        kdtHouseEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtHouseEntry,new com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo(),null,false);
        kDPanel1.add(kdtHouseEntry_detailPanel, null);
        //contfloorArea
        contfloorArea.setBoundEditor(txtfloorArea);
        //contcostCenter
        contcostCenter.setBoundEditor(prmtcostCenter);
        //contwarehouse
        contwarehouse.setBoundEditor(prmtwarehouse);
        //contstorageOrgUnit
        contstorageOrgUnit.setBoundEditor(prmtstorageOrgUnit);
        //contfarmType
        contfarmType.setBoundEditor(farmType);
        //contgm
        contgm.setBoundEditor(txtgm);
        //contFaemsType
        contFaemsType.setBoundEditor(FaemsType);
        //contparentHenWare
        contparentHenWare.setBoundEditor(prmtparentHenWare);

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
        menuBiz.add(mBtnAudit);
        menuBiz.add(mBtnUnAudit);
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
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
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
		dataBinder.registerBinding("isHouseManager", boolean.class, this.chkisHouseManager, "selected");
		dataBinder.registerBinding("isAllot", boolean.class, this.chkisAllot, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("address", String.class, this.txtaddress, "text");
		dataBinder.registerBinding("area", java.math.BigDecimal.class, this.txtarea, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("succahQty", int.class, this.txtsuccahQty, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("HouseEntry.seq", int.class, this.kdtHouseEntry, "seq.text");
		dataBinder.registerBinding("HouseEntry", com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo.class, this.kdtHouseEntry, "userObject");
		dataBinder.registerBinding("HouseEntry.number", String.class, this.kdtHouseEntry, "number.text");
		dataBinder.registerBinding("HouseEntry.name", String.class, this.kdtHouseEntry, "name.text");
		dataBinder.registerBinding("HouseEntry.area", java.math.BigDecimal.class, this.kdtHouseEntry, "area.text");
		dataBinder.registerBinding("HouseEntry.floorArea", java.math.BigDecimal.class, this.kdtHouseEntry, "floorArea.text");
		dataBinder.registerBinding("HouseEntry.costCentor", java.lang.Object.class, this.kdtHouseEntry, "costCentor.text");
		dataBinder.registerBinding("HouseEntry.warehouse", java.lang.Object.class, this.kdtHouseEntry, "warehouse.text");
		dataBinder.registerBinding("HouseEntry.slwarehouse", java.lang.Object.class, this.kdtHouseEntry, "slwarehouse.text");
		dataBinder.registerBinding("HouseEntry.ypwarehousse", java.lang.Object.class, this.kdtHouseEntry, "ypwarehousse.text");
		dataBinder.registerBinding("HouseEntry.breedPerson", java.lang.Object.class, this.kdtHouseEntry, "breedPerson.text");
		dataBinder.registerBinding("HouseEntry.scale", int.class, this.kdtHouseEntry, "scale.text");
		dataBinder.registerBinding("HouseEntry.spdwareHouse", java.lang.Object.class, this.kdtHouseEntry, "spdwareHouse.text");
		dataBinder.registerBinding("floorArea", java.math.BigDecimal.class, this.txtfloorArea, "value");
		dataBinder.registerBinding("costCenter", com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo.class, this.prmtcostCenter, "data");
		dataBinder.registerBinding("warehouse", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.prmtwarehouse, "data");
		dataBinder.registerBinding("storageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstorageOrgUnit, "data");
		dataBinder.registerBinding("farmType", com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum.class, this.farmType, "selectedItem");
		dataBinder.registerBinding("gm", String.class, this.txtgm, "text");
		dataBinder.registerBinding("FaemsType", com.kingdee.eas.farm.stocking.basedata.FarmsType.class, this.FaemsType, "selectedItem");
		dataBinder.registerBinding("parentHenWare", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.prmtparentHenWare, "data");		
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
	    return "com.kingdee.eas.farm.stocking.basedata.app.FarmEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.stocking.basedata.FarmInfo)ov;
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
		getValidateHelper().registerBindProperty("isHouseManager", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isAllot", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("address", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("area", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("succahQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.area", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.floorArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.costCentor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.warehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.slwarehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.ypwarehousse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.breedPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.scale", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.spdwareHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("floorArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costCenter", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("warehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("storageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FaemsType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("parentHenWare", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("isHouseManager"));
        sic.add(new SelectorItemInfo("isAllot"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("address"));
        sic.add(new SelectorItemInfo("area"));
        sic.add(new SelectorItemInfo("baseStatus"));
        sic.add(new SelectorItemInfo("succahQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
    	sic.add(new SelectorItemInfo("HouseEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("HouseEntry.*"));
		}
		else{
			sic.add(new SelectorItemInfo("HouseEntry.name"));
        	sic.add(new SelectorItemInfo("HouseEntry.number"));
		}
    	sic.add(new SelectorItemInfo("HouseEntry.area"));
    	sic.add(new SelectorItemInfo("HouseEntry.floorArea"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("HouseEntry.costCentor.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("HouseEntry.costCentor.id"));
			sic.add(new SelectorItemInfo("HouseEntry.costCentor.name"));
        	sic.add(new SelectorItemInfo("HouseEntry.costCentor.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("HouseEntry.warehouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("HouseEntry.warehouse.id"));
			sic.add(new SelectorItemInfo("HouseEntry.warehouse.name"));
        	sic.add(new SelectorItemInfo("HouseEntry.warehouse.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("HouseEntry.slwarehouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("HouseEntry.slwarehouse.id"));
			sic.add(new SelectorItemInfo("HouseEntry.slwarehouse.name"));
        	sic.add(new SelectorItemInfo("HouseEntry.slwarehouse.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("HouseEntry.ypwarehousse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("HouseEntry.ypwarehousse.id"));
			sic.add(new SelectorItemInfo("HouseEntry.ypwarehousse.name"));
        	sic.add(new SelectorItemInfo("HouseEntry.ypwarehousse.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("HouseEntry.breedPerson.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("HouseEntry.breedPerson.id"));
			sic.add(new SelectorItemInfo("HouseEntry.breedPerson.name"));
        	sic.add(new SelectorItemInfo("HouseEntry.breedPerson.number"));
		}
    	sic.add(new SelectorItemInfo("HouseEntry.scale"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("HouseEntry.spdwareHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("HouseEntry.spdwareHouse.id"));
			sic.add(new SelectorItemInfo("HouseEntry.spdwareHouse.name"));
        	sic.add(new SelectorItemInfo("HouseEntry.spdwareHouse.number"));
		}
        sic.add(new SelectorItemInfo("floorArea"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("costCenter.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("costCenter.id"));
        	sic.add(new SelectorItemInfo("costCenter.number"));
        	sic.add(new SelectorItemInfo("costCenter.name"));
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("storageOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("storageOrgUnit.id"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.number"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("farmType"));
        sic.add(new SelectorItemInfo("gm"));
        sic.add(new SelectorItemInfo("FaemsType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("parentHenWare.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("parentHenWare.id"));
        	sic.add(new SelectorItemInfo("parentHenWare.number"));
        	sic.add(new SelectorItemInfo("parentHenWare.name"));
		}
        return sic;
    }        
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.basedata.FarmFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.basedata.FarmFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractFarmEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractFarmEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.basedata.client", "FarmEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.stocking.basedata.client.FarmEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.FarmInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.FarmInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtName.getItemDataByLang(new LanguageInfo(com.kingdee.eas.common.client.SysContext.getSysContext().getLocale())))) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"名称"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		for (int i=0,n=kdtHouseEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtHouseEntry.getCell(i,"number").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"编码"});
			}
		}
		for (int i=0,n=kdtHouseEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtHouseEntry.getCell(i,"name").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"名称"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtstorageOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"库存组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(farmType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场类别"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtHouseEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(1));
vo.put("farmType",new Integer(3));
vo.put("FaemsType","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}