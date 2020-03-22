/**
 * output package name
 */
package com.kingdee.eas.weighbridge.client;

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
public abstract class AbstractOutStorageBillPlatformUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractOutStorageBillPlatformUI.class);
    protected com.kingdee.bos.ctrl.kdf.table.KDTable tbList;
    protected com.kingdee.bos.ctrl.swing.KDLabel labShowWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCar;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer6;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer7;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer8;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer10;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer11;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnQuery;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCustomer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contOrderStorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDButtonGroup BtnGroupWeightModel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer12;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contTare2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contImpurity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer14;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer15;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer17;
    protected com.kingdee.bos.ctrl.swing.KDLabel labelKG;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer13;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox cmbIsAuto2Inv;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contRemark;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnWeight;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAllSave;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkIsTemp;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCarNum;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnShowOrder;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer16;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer18;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDLabel lblSuttleDiff;
    protected com.kingdee.bos.ctrl.swing.KDLabel lblOrderQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCar;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtMaterial;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtTare;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtGross;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtSuttle;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpBizDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpInTime;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpOutTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpEndDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCustomer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtOrderStorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cmbBizType;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtTare2;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtImpurity;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cmbBillStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtQueryCar;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtQueryMaterial;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cmbQueryBillStatus;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtRemark;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtCarNum;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtOrderNum;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtActualSuttle;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtTempSuttle;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDRadioButton rdoTare2Gross;
    protected com.kingdee.bos.ctrl.swing.KDRadioButton rdoGross2Tare;
    protected com.kingdee.bos.ctrl.swing.KDRadioButton rdoTare2Gross2Tare;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtDetail;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnSaveWeigh;
    protected com.kingdee.eas.framework.CoreBillBaseInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractOutStorageBillPlatformUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractOutStorageBillPlatformUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.tbList = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.labShowWeight = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.contCar = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer5 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer6 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer7 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer8 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer9 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer10 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer11 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnQuery = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCustomer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contOrderStorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.BtnGroupWeightModel = new com.kingdee.bos.ctrl.swing.KDButtonGroup();
        this.kDLabelContainer12 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contTare2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contImpurity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer14 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer15 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer17 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labelKG = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabelContainer13 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.cmbIsAuto2Inv = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contRemark = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnWeight = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAllSave = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.chkIsTemp = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contCarNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabel2 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnShowOrder = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabelContainer16 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer18 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.lblSuttleDiff = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.lblOrderQty = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.prmtCar = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtMaterial = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtTare = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtGross = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtSuttle = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.dpBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.dpInTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.dpOutTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.dpBeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.dpEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtCustomer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtOrderStorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.cmbBizType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtTare2 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtImpurity = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.cmbBillStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtQueryCar = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtQueryMaterial = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.cmbQueryBillStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtRemark = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtCarNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtOrderNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtActualSuttle = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtTempSuttle = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.rdoTare2Gross = new com.kingdee.bos.ctrl.swing.KDRadioButton();
        this.rdoGross2Tare = new com.kingdee.bos.ctrl.swing.KDRadioButton();
        this.rdoTare2Gross2Tare = new com.kingdee.bos.ctrl.swing.KDRadioButton();
        this.kdtDetail = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.btnSaveWeigh = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tbList.setName("tbList");
        this.labShowWeight.setName("labShowWeight");
        this.contCar.setName("contCar");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.kDLabelContainer5.setName("kDLabelContainer5");
        this.kDLabelContainer6.setName("kDLabelContainer6");
        this.kDLabelContainer7.setName("kDLabelContainer7");
        this.kDLabelContainer8.setName("kDLabelContainer8");
        this.kDLabelContainer9.setName("kDLabelContainer9");
        this.kDLabelContainer10.setName("kDLabelContainer10");
        this.kDLabelContainer11.setName("kDLabelContainer11");
        this.btnQuery.setName("btnQuery");
        this.contCustomer.setName("contCustomer");
        this.contOrderStorageOrgUnit.setName("contOrderStorageOrgUnit");
        this.kDLabelContainer12.setName("kDLabelContainer12");
        this.contTare2.setName("contTare2");
        this.contImpurity.setName("contImpurity");
        this.kDLabelContainer14.setName("kDLabelContainer14");
        this.kDLabelContainer15.setName("kDLabelContainer15");
        this.kDLabelContainer17.setName("kDLabelContainer17");
        this.labelKG.setName("labelKG");
        this.kDLabelContainer13.setName("kDLabelContainer13");
        this.cmbIsAuto2Inv.setName("cmbIsAuto2Inv");
        this.contRemark.setName("contRemark");
        this.btnWeight.setName("btnWeight");
        this.btnAllSave.setName("btnAllSave");
        this.chkIsTemp.setName("chkIsTemp");
        this.contCarNum.setName("contCarNum");
        this.kDLabel2.setName("kDLabel2");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.btnShowOrder.setName("btnShowOrder");
        this.kDLabelContainer16.setName("kDLabelContainer16");
        this.kDLabelContainer18.setName("kDLabelContainer18");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.kDLabel1.setName("kDLabel1");
        this.lblSuttleDiff.setName("lblSuttleDiff");
        this.lblOrderQty.setName("lblOrderQty");
        this.prmtCar.setName("prmtCar");
        this.prmtMaterial.setName("prmtMaterial");
        this.txtTare.setName("txtTare");
        this.txtGross.setName("txtGross");
        this.txtSuttle.setName("txtSuttle");
        this.dpBizDate.setName("dpBizDate");
        this.dpInTime.setName("dpInTime");
        this.dpOutTime.setName("dpOutTime");
        this.txtNumber.setName("txtNumber");
        this.dpBeginDate.setName("dpBeginDate");
        this.dpEndDate.setName("dpEndDate");
        this.prmtCustomer.setName("prmtCustomer");
        this.prmtOrderStorageOrgUnit.setName("prmtOrderStorageOrgUnit");
        this.cmbBizType.setName("cmbBizType");
        this.txtTare2.setName("txtTare2");
        this.txtImpurity.setName("txtImpurity");
        this.cmbBillStatus.setName("cmbBillStatus");
        this.prmtQueryCar.setName("prmtQueryCar");
        this.prmtQueryMaterial.setName("prmtQueryMaterial");
        this.cmbQueryBillStatus.setName("cmbQueryBillStatus");
        this.txtRemark.setName("txtRemark");
        this.txtCarNum.setName("txtCarNum");
        this.txtOrderNum.setName("txtOrderNum");
        this.txtActualSuttle.setName("txtActualSuttle");
        this.txtTempSuttle.setName("txtTempSuttle");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.rdoTare2Gross.setName("rdoTare2Gross");
        this.rdoGross2Tare.setName("rdoGross2Tare");
        this.rdoTare2Gross2Tare.setName("rdoTare2Gross2Tare");
        this.kdtDetail.setName("kdtDetail");
        this.btnSaveWeigh.setName("btnSaveWeigh");
        // CoreUI		
        this.btnPageSetup.setVisible(false);		
        this.btnCloud.setVisible(false);		
        this.btnXunTong.setVisible(false);		
        this.kDSeparatorCloud.setVisible(false);		
        this.menuItemPageSetup.setVisible(false);		
        this.menuItemCloudFeed.setVisible(false);		
        this.menuItemCloudScreen.setEnabled(false);		
        this.menuItemCloudScreen.setVisible(false);		
        this.menuItemCloudShare.setVisible(false);		
        this.kdSeparatorFWFile1.setVisible(false);		
        this.kDSeparator2.setVisible(true);
        // tbList
		String tbListStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol15\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol16\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol20\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" /><t:Column t:key=\"car\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" /><t:Column t:key=\"storageOrgUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"customer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /><t:Column t:key=\"orderStorageOrgUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" /><t:Column t:key=\"inTime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" /><t:Column t:key=\"outTime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" /><t:Column t:key=\"billStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" /><t:Column t:key=\"materialID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" t:styleID=\"sCol10\" /><t:Column t:key=\"materialNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" /><t:Column t:key=\"tare\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" /><t:Column t:key=\"gross\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" /><t:Column t:key=\"tare2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"15\" t:styleID=\"sCol15\" /><t:Column t:key=\"impurity\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"16\" t:styleID=\"sCol16\" /><t:Column t:key=\"suttle\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"17\" /><t:Column t:key=\"actualSuttle\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"18\" /><t:Column t:key=\"suttleDiff\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"19\" /><t:Column t:key=\"entryID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"20\" t:styleID=\"sCol20\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{car}</t:Cell><t:Cell>$Resource{storageOrgUnit}</t:Cell><t:Cell>$Resource{customer}</t:Cell><t:Cell>$Resource{orderStorageOrgUnit}</t:Cell><t:Cell>$Resource{inTime}</t:Cell><t:Cell>$Resource{outTime}</t:Cell><t:Cell>$Resource{billStatus}</t:Cell><t:Cell>$Resource{materialID}</t:Cell><t:Cell>$Resource{materialNum}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{tare}</t:Cell><t:Cell>$Resource{gross}</t:Cell><t:Cell>$Resource{tare2}</t:Cell><t:Cell>$Resource{impurity}</t:Cell><t:Cell>$Resource{suttle}</t:Cell><t:Cell>$Resource{actualSuttle}</t:Cell><t:Cell>$Resource{suttleDiff}</t:Cell><t:Cell>$Resource{entryID}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.tbList.setFormatXml(resHelper.translateString("tbList",tbListStrXML));

        

        // labShowWeight		
        this.labShowWeight.setText(resHelper.getString("labShowWeight.text"));		
        this.labShowWeight.setFont(resHelper.getFont("labShowWeight.font"));		
        this.labShowWeight.setForeground(new java.awt.Color(86,210,45));		
        this.labShowWeight.setHorizontalAlignment(4);
        // contCar		
        this.contCar.setBoundLabelText(resHelper.getString("contCar.boundLabelText"));		
        this.contCar.setBoundLabelUnderline(true);		
        this.contCar.setBoundLabelLength(50);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelUnderline(true);		
        this.kDLabelContainer2.setBoundLabelLength(100);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setBoundLabelLength(100);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelLength(100);
        // kDLabelContainer5		
        this.kDLabelContainer5.setBoundLabelText(resHelper.getString("kDLabelContainer5.boundLabelText"));		
        this.kDLabelContainer5.setBoundLabelUnderline(true);		
        this.kDLabelContainer5.setBoundLabelLength(100);
        // kDLabelContainer6		
        this.kDLabelContainer6.setBoundLabelText(resHelper.getString("kDLabelContainer6.boundLabelText"));		
        this.kDLabelContainer6.setBoundLabelUnderline(true);		
        this.kDLabelContainer6.setBoundLabelLength(100);
        // kDLabelContainer7		
        this.kDLabelContainer7.setBoundLabelText(resHelper.getString("kDLabelContainer7.boundLabelText"));		
        this.kDLabelContainer7.setBoundLabelUnderline(true);		
        this.kDLabelContainer7.setBoundLabelLength(100);
        // kDLabelContainer8		
        this.kDLabelContainer8.setBoundLabelText(resHelper.getString("kDLabelContainer8.boundLabelText"));		
        this.kDLabelContainer8.setBoundLabelUnderline(true);		
        this.kDLabelContainer8.setBoundLabelLength(100);
        // kDLabelContainer9		
        this.kDLabelContainer9.setBoundLabelText(resHelper.getString("kDLabelContainer9.boundLabelText"));		
        this.kDLabelContainer9.setBoundLabelUnderline(true);		
        this.kDLabelContainer9.setBoundLabelLength(100);
        // kDLabelContainer10		
        this.kDLabelContainer10.setBoundLabelText(resHelper.getString("kDLabelContainer10.boundLabelText"));		
        this.kDLabelContainer10.setBoundLabelLength(100);		
        this.kDLabelContainer10.setBoundLabelUnderline(true);
        // kDLabelContainer11		
        this.kDLabelContainer11.setBoundLabelText(resHelper.getString("kDLabelContainer11.boundLabelText"));		
        this.kDLabelContainer11.setBoundLabelLength(100);		
        this.kDLabelContainer11.setBoundLabelUnderline(true);
        // btnQuery		
        this.btnQuery.setText(resHelper.getString("btnQuery.text"));
        this.btnQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnQuery_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // contCustomer		
        this.contCustomer.setBoundLabelText(resHelper.getString("contCustomer.boundLabelText"));		
        this.contCustomer.setBoundLabelUnderline(true);		
        this.contCustomer.setBoundLabelLength(100);
        // contOrderStorageOrgUnit		
        this.contOrderStorageOrgUnit.setBoundLabelText(resHelper.getString("contOrderStorageOrgUnit.boundLabelText"));		
        this.contOrderStorageOrgUnit.setBoundLabelUnderline(true);		
        this.contOrderStorageOrgUnit.setBoundLabelLength(100);
        // BtnGroupWeightModel
        this.BtnGroupWeightModel.add(this.rdoTare2Gross);
        this.BtnGroupWeightModel.add(this.rdoGross2Tare);
        this.BtnGroupWeightModel.add(this.rdoTare2Gross2Tare);
        // kDLabelContainer12		
        this.kDLabelContainer12.setBoundLabelText(resHelper.getString("kDLabelContainer12.boundLabelText"));		
        this.kDLabelContainer12.setBoundLabelLength(100);		
        this.kDLabelContainer12.setBoundLabelUnderline(true);
        // contTare2		
        this.contTare2.setBoundLabelText(resHelper.getString("contTare2.boundLabelText"));		
        this.contTare2.setBoundLabelUnderline(true);		
        this.contTare2.setBoundLabelLength(100);		
        this.contTare2.setVisible(false);
        // contImpurity		
        this.contImpurity.setBoundLabelText(resHelper.getString("contImpurity.boundLabelText"));		
        this.contImpurity.setBoundLabelUnderline(true);		
        this.contImpurity.setBoundLabelLength(100);		
        this.contImpurity.setVisible(false);
        // kDLabelContainer14		
        this.kDLabelContainer14.setBoundLabelText(resHelper.getString("kDLabelContainer14.boundLabelText"));		
        this.kDLabelContainer14.setBoundLabelUnderline(true);		
        this.kDLabelContainer14.setBoundLabelLength(100);
        // kDLabelContainer15		
        this.kDLabelContainer15.setBoundLabelText(resHelper.getString("kDLabelContainer15.boundLabelText"));		
        this.kDLabelContainer15.setBoundLabelUnderline(true);		
        this.kDLabelContainer15.setBoundLabelLength(100);
        // kDLabelContainer17		
        this.kDLabelContainer17.setBoundLabelText(resHelper.getString("kDLabelContainer17.boundLabelText"));		
        this.kDLabelContainer17.setBoundLabelUnderline(true);		
        this.kDLabelContainer17.setBoundLabelLength(100);
        // labelKG		
        this.labelKG.setText(resHelper.getString("labelKG.text"));		
        this.labelKG.setFont(resHelper.getFont("labelKG.font"));		
        this.labelKG.setForeground(new java.awt.Color(0,187,0));
        // kDLabelContainer13		
        this.kDLabelContainer13.setBoundLabelText(resHelper.getString("kDLabelContainer13.boundLabelText"));		
        this.kDLabelContainer13.setBoundLabelUnderline(true);		
        this.kDLabelContainer13.setBoundLabelLength(100);
        // cmbIsAuto2Inv		
        this.cmbIsAuto2Inv.setText(resHelper.getString("cmbIsAuto2Inv.text"));
        // contRemark		
        this.contRemark.setBoundLabelText(resHelper.getString("contRemark.boundLabelText"));		
        this.contRemark.setBoundLabelUnderline(true);		
        this.contRemark.setBoundLabelLength(100);
        // btnWeight		
        this.btnWeight.setText(resHelper.getString("btnWeight.text"));		
        this.btnWeight.setFont(resHelper.getFont("btnWeight.font"));
        this.btnWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnWeight_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnAllSave		
        this.btnAllSave.setText(resHelper.getString("btnAllSave.text"));		
        this.btnAllSave.setFont(resHelper.getFont("btnAllSave.font"));
        this.btnAllSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnAllSave_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // chkIsTemp		
        this.chkIsTemp.setText(resHelper.getString("chkIsTemp.text"));
        // contCarNum		
        this.contCarNum.setBoundLabelText(resHelper.getString("contCarNum.boundLabelText"));		
        this.contCarNum.setBoundLabelLength(100);		
        this.contCarNum.setBoundLabelUnderline(true);		
        this.contCarNum.setVisible(false);
        // kDLabel2		
        this.kDLabel2.setText(resHelper.getString("kDLabel2.text"));		
        this.kDLabel2.setFont(resHelper.getFont("kDLabel2.font"));		
        this.kDLabel2.setForeground(new java.awt.Color(10,148,182));		
        this.kDLabel2.setHorizontalAlignment(2);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer1.setBoundLabelLength(100);
        // btnShowOrder		
        this.btnShowOrder.setText(resHelper.getString("btnShowOrder.text"));
        this.btnShowOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnShowOrder_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDLabelContainer16		
        this.kDLabelContainer16.setBoundLabelText(resHelper.getString("kDLabelContainer16.boundLabelText"));		
        this.kDLabelContainer16.setBoundLabelUnderline(true);		
        this.kDLabelContainer16.setBoundLabelLength(100);		
        this.kDLabelContainer16.setEnabled(false);
        // kDLabelContainer18		
        this.kDLabelContainer18.setBoundLabelText(resHelper.getString("kDLabelContainer18.boundLabelText"));		
        this.kDLabelContainer18.setBoundLabelUnderline(true);		
        this.kDLabelContainer18.setBoundLabelLength(100);
        // kDTabbedPane1
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));		
        this.kDLabel1.setFont(resHelper.getFont("kDLabel1.font"));		
        this.kDLabel1.setForeground(new java.awt.Color(217,0,0));		
        this.kDLabel1.setHorizontalAlignment(4);
        // lblSuttleDiff		
        this.lblSuttleDiff.setText(resHelper.getString("lblSuttleDiff.text"));		
        this.lblSuttleDiff.setFont(resHelper.getFont("lblSuttleDiff.font"));		
        this.lblSuttleDiff.setForeground(new java.awt.Color(217,0,0));		
        this.lblSuttleDiff.setHorizontalAlignment(4);
        // lblOrderQty		
        this.lblOrderQty.setText(resHelper.getString("lblOrderQty.text"));		
        this.lblOrderQty.setFont(resHelper.getFont("lblOrderQty.font"));		
        this.lblOrderQty.setForeground(new java.awt.Color(36,153,159));		
        this.lblOrderQty.setHorizontalAlignment(2);
        // prmtCar
        // prmtMaterial
        // txtTare
        // txtGross
        // txtSuttle
        // dpBizDate
        // dpInTime		
        this.dpInTime.setRequired(true);
        // dpOutTime		
        this.dpOutTime.setRequired(true);
        // txtNumber
        this.txtNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    txtNumber_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // dpBeginDate
        // dpEndDate
        // prmtCustomer
        // prmtOrderStorageOrgUnit
        // cmbBizType		
        this.cmbBizType.setActionCommand("cmbWeighType");		
        this.cmbBizType.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.WeighBizType").toArray());
        // txtTare2		
        this.txtTare2.setEnabled(false);
        // txtImpurity
        this.txtImpurity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    txtImpurity_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // cmbBillStatus		
        this.cmbBillStatus.setActionCommand("");		
        this.cmbBillStatus.setEnabled(false);		
        this.cmbBillStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.WeighBaseStatus").toArray());
        // prmtQueryCar
        // prmtQueryMaterial
        // cmbQueryBillStatus		
        this.cmbQueryBillStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.WeighBaseStatus").toArray());
        // txtRemark
        // txtCarNum
        // txtOrderNum
        // txtActualSuttle
        // txtTempSuttle		
        this.txtTempSuttle.setEnabled(false);
        // kDPanel1
        // kDPanel2
        // rdoTare2Gross		
        this.rdoTare2Gross.setText(resHelper.getString("rdoTare2Gross.text"));		
        this.rdoTare2Gross.setSelected(true);
        // rdoGross2Tare		
        this.rdoGross2Tare.setText(resHelper.getString("rdoGross2Tare.text"));
        // rdoTare2Gross2Tare		
        this.rdoTare2Gross2Tare.setText(resHelper.getString("rdoTare2Gross2Tare.text"));		
        this.rdoTare2Gross2Tare.setVisible(false);
        // kdtDetail
		String kdtDetailStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles /><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"billNum\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"mateiralName\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bagQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"customerName\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{billNum}</t:Cell><t:Cell>$Resource{mateiralName}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{bagQty}</t:Cell><t:Cell>$Resource{customerName}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtDetail.setFormatXml(resHelper.translateString("kdtDetail",kdtDetailStrXML));

        

        // btnSaveWeigh		
        this.btnSaveWeigh.setText(resHelper.getString("btnSaveWeigh.text"));
        this.btnSaveWeigh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnSaveWeigh_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
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
        this.setBounds(new Rectangle(10, 10, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 1013, 629));
        kDSeparator2.setBounds(new Rectangle(-6, 333, 1034, 11));
        this.add(kDSeparator2, new KDLayout.Constraints(-6, 333, 1034, 11, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        tbList.setBounds(new Rectangle(13, 397, 991, 215));
        this.add(tbList, new KDLayout.Constraints(13, 397, 991, 215, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        labShowWeight.setBounds(new Rectangle(322, 8, 266, 82));
        this.add(labShowWeight, new KDLayout.Constraints(322, 8, 266, 82, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCar.setBounds(new Rectangle(121, 119, 190, 19));
        this.add(contCar, new KDLayout.Constraints(121, 119, 190, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(41, 148, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(41, 148, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(41, 177, 270, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(41, 177, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer4.setBounds(new Rectangle(41, 206, 270, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(41, 206, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer5.setBounds(new Rectangle(41, 264, 270, 19));
        this.add(kDLabelContainer5, new KDLayout.Constraints(41, 264, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer6.setBounds(new Rectangle(379, 90, 270, 19));
        this.add(kDLabelContainer6, new KDLayout.Constraints(379, 90, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer7.setBounds(new Rectangle(379, 117, 270, 19));
        this.add(kDLabelContainer7, new KDLayout.Constraints(379, 117, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer8.setBounds(new Rectangle(718, 117, 270, 19));
        this.add(kDLabelContainer8, new KDLayout.Constraints(718, 117, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer9.setBounds(new Rectangle(41, 90, 270, 19));
        this.add(kDLabelContainer9, new KDLayout.Constraints(41, 90, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer10.setBounds(new Rectangle(41, 345, 270, 19));
        this.add(kDLabelContainer10, new KDLayout.Constraints(41, 345, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer11.setBounds(new Rectangle(379, 345, 270, 19));
        this.add(kDLabelContainer11, new KDLayout.Constraints(379, 345, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnQuery.setBounds(new Rectangle(923, 370, 63, 19));
        this.add(btnQuery, new KDLayout.Constraints(923, 370, 63, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contCustomer.setBounds(new Rectangle(718, 90, 270, 19));
        this.add(contCustomer, new KDLayout.Constraints(718, 90, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contOrderStorageOrgUnit.setBounds(new Rectangle(718, 90, 270, 19));
        this.add(contOrderStorageOrgUnit, new KDLayout.Constraints(718, 90, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer12.setBounds(new Rectangle(379, 144, 270, 19));
        this.add(kDLabelContainer12, new KDLayout.Constraints(379, 144, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contTare2.setBounds(new Rectangle(-234, 267, 270, 19));
        this.add(contTare2, new KDLayout.Constraints(-234, 267, 270, 19, 0));
        contImpurity.setBounds(new Rectangle(989, 270, 270, 19));
        this.add(contImpurity, new KDLayout.Constraints(989, 270, 270, 19, 0));
        kDLabelContainer14.setBounds(new Rectangle(718, 144, 270, 19));
        this.add(kDLabelContainer14, new KDLayout.Constraints(718, 144, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer15.setBounds(new Rectangle(716, 340, 270, 19));
        this.add(kDLabelContainer15, new KDLayout.Constraints(716, 340, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer17.setBounds(new Rectangle(41, 369, 270, 19));
        this.add(kDLabelContainer17, new KDLayout.Constraints(41, 369, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        labelKG.setBounds(new Rectangle(594, 38, 57, 31));
        this.add(labelKG, new KDLayout.Constraints(594, 38, 57, 31, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer13.setBounds(new Rectangle(379, 369, 270, 19));
        this.add(kDLabelContainer13, new KDLayout.Constraints(379, 369, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        cmbIsAuto2Inv.setBounds(new Rectangle(718, 222, 270, 19));
        this.add(cmbIsAuto2Inv, new KDLayout.Constraints(718, 222, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contRemark.setBounds(new Rectangle(379, 171, 270, 19));
        this.add(contRemark, new KDLayout.Constraints(379, 171, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnWeight.setBounds(new Rectangle(718, 258, 100, 60));
        this.add(btnWeight, new KDLayout.Constraints(718, 258, 100, 60, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnAllSave.setBounds(new Rectangle(888, 258, 100, 60));
        this.add(btnAllSave, new KDLayout.Constraints(888, 258, 100, 60, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkIsTemp.setBounds(new Rectangle(41, 122, 71, 19));
        this.add(chkIsTemp, new KDLayout.Constraints(41, 122, 71, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCarNum.setBounds(new Rectangle(718, 197, 240, 19));
        this.add(contCarNum, new KDLayout.Constraints(718, 197, 240, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabel2.setBounds(new Rectangle(41, 7, 194, 44));
        this.add(kDLabel2, new KDLayout.Constraints(41, 7, 194, 44, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));
        kDLabelContainer1.setBounds(new Rectangle(718, 171, 240, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(718, 171, 240, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnShowOrder.setBounds(new Rectangle(959, 171, 29, 46));
        this.add(btnShowOrder, new KDLayout.Constraints(959, 171, 29, 46, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer16.setBounds(new Rectangle(41, 297, 270, 19));
        this.add(kDLabelContainer16, new KDLayout.Constraints(41, 297, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer18.setBounds(new Rectangle(41, 235, 270, 19));
        this.add(kDLabelContainer18, new KDLayout.Constraints(41, 235, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(378, 194, 269, 128));
        this.add(kDTabbedPane1, new KDLayout.Constraints(378, 194, 269, 128, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabel1.setBounds(new Rectangle(836, 7, 152, 44));
        this.add(kDLabel1, new KDLayout.Constraints(836, 7, 152, 44, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_RIGHT));
        lblSuttleDiff.setBounds(new Rectangle(804, 49, 184, 42));
        this.add(lblSuttleDiff, new KDLayout.Constraints(804, 49, 184, 42, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_RIGHT));
        lblOrderQty.setBounds(new Rectangle(41, 49, 450, 42));
        this.add(lblOrderQty, new KDLayout.Constraints(41, 49, 450, 42, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));
        //contCar
        contCar.setBoundEditor(prmtCar);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(prmtMaterial);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtTare);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtGross);
        //kDLabelContainer5
        kDLabelContainer5.setBoundEditor(txtSuttle);
        //kDLabelContainer6
        kDLabelContainer6.setBoundEditor(dpBizDate);
        //kDLabelContainer7
        kDLabelContainer7.setBoundEditor(dpInTime);
        //kDLabelContainer8
        kDLabelContainer8.setBoundEditor(dpOutTime);
        //kDLabelContainer9
        kDLabelContainer9.setBoundEditor(txtNumber);
        //kDLabelContainer10
        kDLabelContainer10.setBoundEditor(dpBeginDate);
        //kDLabelContainer11
        kDLabelContainer11.setBoundEditor(dpEndDate);
        //contCustomer
        contCustomer.setBoundEditor(prmtCustomer);
        //contOrderStorageOrgUnit
        contOrderStorageOrgUnit.setBoundEditor(prmtOrderStorageOrgUnit);
        //kDLabelContainer12
        kDLabelContainer12.setBoundEditor(cmbBizType);
        //contTare2
        contTare2.setBoundEditor(txtTare2);
        //contImpurity
        contImpurity.setBoundEditor(txtImpurity);
        //kDLabelContainer14
        kDLabelContainer14.setBoundEditor(cmbBillStatus);
        //kDLabelContainer15
        kDLabelContainer15.setBoundEditor(prmtQueryCar);
        //kDLabelContainer17
        kDLabelContainer17.setBoundEditor(prmtQueryMaterial);
        //kDLabelContainer13
        kDLabelContainer13.setBoundEditor(cmbQueryBillStatus);
        //contRemark
        contRemark.setBoundEditor(txtRemark);
        //contCarNum
        contCarNum.setBoundEditor(txtCarNum);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtOrderNum);
        //kDLabelContainer16
        kDLabelContainer16.setBoundEditor(txtActualSuttle);
        //kDLabelContainer18
        kDLabelContainer18.setBoundEditor(txtTempSuttle);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 268, 95));        rdoTare2Gross.setBounds(new Rectangle(6, 10, 140, 19));
        kDPanel1.add(rdoTare2Gross, new KDLayout.Constraints(6, 10, 140, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        rdoGross2Tare.setBounds(new Rectangle(6, 37, 140, 19));
        kDPanel1.add(rdoGross2Tare, new KDLayout.Constraints(6, 37, 140, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        rdoTare2Gross2Tare.setBounds(new Rectangle(6, 64, 140, 19));
        kDPanel1.add(rdoTare2Gross2Tare, new KDLayout.Constraints(6, 64, 140, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 268, 95));        kdtDetail.setBounds(new Rectangle(1, 3, 262, 92));
        kDPanel2.add(kdtDetail, new KDLayout.Constraints(1, 3, 262, 92, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));

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
        this.toolBar.add(btnSaveWeigh);
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
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.weighbridge.app.OutStorageBillPlatformUIHandler";
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
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.framework.CoreBillBaseInfo)ov;
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        dataBinder.loadFields();
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
     * output btnQuery_actionPerformed method
     */
    protected void btnQuery_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnWeight_actionPerformed method
     */
    protected void btnWeight_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnAllSave_actionPerformed method
     */
    protected void btnAllSave_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnShowOrder_actionPerformed method
     */
    protected void btnShowOrder_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output txtNumber_actionPerformed method
     */
    protected void txtNumber_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output txtImpurity_actionPerformed method
     */
    protected void txtImpurity_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnSaveWeigh_actionPerformed method
     */
    protected void btnSaveWeigh_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
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
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.weighbridge.client", "OutStorageBillPlatformUI");
    }




}