/**
 * output package name
 */
package com.kingdee.eas.custom.salegrossprofitsrpt.client;

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
public abstract class AbstractSaleGrossProfitsConditionUI extends com.kingdee.eas.scm.common.client.SCMBillFilterUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSaleGrossProfitsConditionUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contStartDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contEndDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contMaterialGroupFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contMaterialGroupTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contMaterialFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCustomerGroupTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCustomerGroupFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCustomerFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCustomerTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSaleOrgFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSalePersonFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSalePersonTo;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contMaterialTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contClassification;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBillType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contGrade;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contImcome;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkContainCost;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCompanyFrom;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkContainInvoice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox ckBxShowMShortName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labAccountPeriod;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labAccPeriodYear;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labAccPeriodMonth;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labAccountPeriodTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labAccPeriodYearTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labAccPeriodMonthTo;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox AuxiliaryProperties;
    protected com.kingdee.bos.ctrl.swing.KDSpinner spnPrecision;
    protected com.kingdee.bos.ctrl.swing.KDLabel lblPrecision;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer6;
    protected com.kingdee.bos.ctrl.swing.KDTextField customerclassfield;
    protected com.kingdee.bos.ctrl.swing.KDTextField MaterialClassfield;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer7;
    protected com.kingdee.bos.ctrl.swing.KDLabel lblPrecision2;
    protected com.kingdee.bos.ctrl.swing.KDSpinner qtyPrecision;
    protected com.kingdee.bos.ctrl.swing.KDLabel KdlablePercision1;
    protected com.kingdee.bos.ctrl.swing.KDSpinner amountPrecision1;
    protected com.kingdee.bos.ctrl.swing.KDSpinner amountPrecision2;
    protected com.kingdee.bos.ctrl.swing.KDLabel KdlablePercision2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkContainBizBill;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker datePickerStart;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker datePickerEnd;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtMaterialGroupFrom;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtMaterialGroupTo;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtMaterialFrom;
    protected com.kingdee.bos.ctrl.swing.KDComboBox combBillStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCustomerGroupTo;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCustomerGroupFrom;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCustomerFrom;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCustomerTo;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtSaleOrgFrom;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtSalePersonFrom;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtSalePersonTo;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtMaterialTo;
    protected com.kingdee.bos.ctrl.swing.KDComboBox combClassification;
    protected com.kingdee.bos.ctrl.swing.KDComboBox combBillType;
    protected com.kingdee.bos.ctrl.swing.KDSpinner spinnerGrade;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtSaleGroupFrom;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtSaleGroupTo;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cbImcome;
    protected com.kingdee.bos.ctrl.swing.KDButtonGroup bgOrgSelected;
    protected com.kingdee.bos.ctrl.swing.KDRadioButton rbSaleOrg;
    protected com.kingdee.bos.ctrl.swing.KDRadioButton rbCompanyOrg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCompanyOrgFrom;
    protected com.kingdee.bos.ctrl.swing.KDComboBox comCustomerType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtMShortNameTo;
    protected com.kingdee.bos.ctrl.swing.KDSpinner spinPeriodYear;
    protected com.kingdee.bos.ctrl.swing.KDSpinner spinPeriodMonth;
    protected com.kingdee.bos.ctrl.swing.KDSpinner spinPeriodYearTo;
    protected com.kingdee.bos.ctrl.swing.KDSpinner spinPeriodMonthTo;
    protected com.kingdee.bos.ctrl.swing.KDComboBox customerClassfiled;
    protected com.kingdee.bos.ctrl.swing.KDComboBox materialClass;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtMShortNameFrom;
    /**
     * output class constructor
     */
    public AbstractSaleGrossProfitsConditionUI() throws Exception
    {
        super();
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractSaleGrossProfitsConditionUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.contStartDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contEndDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contMaterialGroupFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contMaterialGroupTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contMaterialFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCustomerGroupTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCustomerGroupFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCustomerFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCustomerTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSaleOrgFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSalePersonFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSalePersonTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator2 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contMaterialTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contClassification = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBillType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contGrade = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contImcome = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkContainCost = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contCompanyFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkContainInvoice = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.ckBxShowMShortName = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kDLabelContainer5 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labAccountPeriod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labAccPeriodYear = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labAccPeriodMonth = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labAccountPeriodTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labAccPeriodYearTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labAccPeriodMonthTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.AuxiliaryProperties = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.spnPrecision = new com.kingdee.bos.ctrl.swing.KDSpinner();
        this.lblPrecision = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabelContainer6 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.customerclassfield = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.MaterialClassfield = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDLabelContainer7 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lblPrecision2 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.qtyPrecision = new com.kingdee.bos.ctrl.swing.KDSpinner();
        this.KdlablePercision1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.amountPrecision1 = new com.kingdee.bos.ctrl.swing.KDSpinner();
        this.amountPrecision2 = new com.kingdee.bos.ctrl.swing.KDSpinner();
        this.KdlablePercision2 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkContainBizBill = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.datePickerStart = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.datePickerEnd = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtMaterialGroupFrom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtMaterialGroupTo = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtMaterialFrom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.combBillStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtCustomerGroupTo = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtCustomerGroupFrom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtCustomerFrom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtCustomerTo = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtSaleOrgFrom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtSalePersonFrom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtSalePersonTo = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtMaterialTo = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.combClassification = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.combBillType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.spinnerGrade = new com.kingdee.bos.ctrl.swing.KDSpinner();
        this.prmtSaleGroupFrom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtSaleGroupTo = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.cbImcome = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.bgOrgSelected = new com.kingdee.bos.ctrl.swing.KDButtonGroup();
        this.rbSaleOrg = new com.kingdee.bos.ctrl.swing.KDRadioButton();
        this.rbCompanyOrg = new com.kingdee.bos.ctrl.swing.KDRadioButton();
        this.prmtCompanyOrgFrom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.comCustomerType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtMShortNameTo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.spinPeriodYear = new com.kingdee.bos.ctrl.swing.KDSpinner();
        this.spinPeriodMonth = new com.kingdee.bos.ctrl.swing.KDSpinner();
        this.spinPeriodYearTo = new com.kingdee.bos.ctrl.swing.KDSpinner();
        this.spinPeriodMonthTo = new com.kingdee.bos.ctrl.swing.KDSpinner();
        this.customerClassfiled = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.materialClass = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtMShortNameFrom = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.contStartDate.setName("contStartDate");
        this.contEndDate.setName("contEndDate");
        this.contMaterialGroupFrom.setName("contMaterialGroupFrom");
        this.contMaterialGroupTo.setName("contMaterialGroupTo");
        this.contMaterialFrom.setName("contMaterialFrom");
        this.contBillStatus.setName("contBillStatus");
        this.contCustomerGroupTo.setName("contCustomerGroupTo");
        this.contCustomerGroupFrom.setName("contCustomerGroupFrom");
        this.contCustomerFrom.setName("contCustomerFrom");
        this.contCustomerTo.setName("contCustomerTo");
        this.contSaleOrgFrom.setName("contSaleOrgFrom");
        this.contSalePersonFrom.setName("contSalePersonFrom");
        this.contSalePersonTo.setName("contSalePersonTo");
        this.kDSeparator2.setName("kDSeparator2");
        this.contMaterialTo.setName("contMaterialTo");
        this.contClassification.setName("contClassification");
        this.contBillType.setName("contBillType");
        this.contGrade.setName("contGrade");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.contImcome.setName("contImcome");
        this.chkContainCost.setName("chkContainCost");
        this.kDPanel1.setName("kDPanel1");
        this.contCompanyFrom.setName("contCompanyFrom");
        this.chkContainInvoice.setName("chkContainInvoice");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.ckBxShowMShortName.setName("ckBxShowMShortName");
        this.kDLabelContainer5.setName("kDLabelContainer5");
        this.labAccountPeriod.setName("labAccountPeriod");
        this.labAccPeriodYear.setName("labAccPeriodYear");
        this.labAccPeriodMonth.setName("labAccPeriodMonth");
        this.labAccountPeriodTo.setName("labAccountPeriodTo");
        this.labAccPeriodYearTo.setName("labAccPeriodYearTo");
        this.labAccPeriodMonthTo.setName("labAccPeriodMonthTo");
        this.AuxiliaryProperties.setName("AuxiliaryProperties");
        this.spnPrecision.setName("spnPrecision");
        this.lblPrecision.setName("lblPrecision");
        this.kDLabelContainer6.setName("kDLabelContainer6");
        this.customerclassfield.setName("customerclassfield");
        this.MaterialClassfield.setName("MaterialClassfield");
        this.kDLabelContainer7.setName("kDLabelContainer7");
        this.lblPrecision2.setName("lblPrecision2");
        this.qtyPrecision.setName("qtyPrecision");
        this.KdlablePercision1.setName("KdlablePercision1");
        this.amountPrecision1.setName("amountPrecision1");
        this.amountPrecision2.setName("amountPrecision2");
        this.KdlablePercision2.setName("KdlablePercision2");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.chkContainBizBill.setName("chkContainBizBill");
        this.datePickerStart.setName("datePickerStart");
        this.datePickerEnd.setName("datePickerEnd");
        this.prmtMaterialGroupFrom.setName("prmtMaterialGroupFrom");
        this.prmtMaterialGroupTo.setName("prmtMaterialGroupTo");
        this.prmtMaterialFrom.setName("prmtMaterialFrom");
        this.combBillStatus.setName("combBillStatus");
        this.prmtCustomerGroupTo.setName("prmtCustomerGroupTo");
        this.prmtCustomerGroupFrom.setName("prmtCustomerGroupFrom");
        this.prmtCustomerFrom.setName("prmtCustomerFrom");
        this.prmtCustomerTo.setName("prmtCustomerTo");
        this.prmtSaleOrgFrom.setName("prmtSaleOrgFrom");
        this.prmtSalePersonFrom.setName("prmtSalePersonFrom");
        this.prmtSalePersonTo.setName("prmtSalePersonTo");
        this.prmtMaterialTo.setName("prmtMaterialTo");
        this.combClassification.setName("combClassification");
        this.combBillType.setName("combBillType");
        this.spinnerGrade.setName("spinnerGrade");
        this.prmtSaleGroupFrom.setName("prmtSaleGroupFrom");
        this.prmtSaleGroupTo.setName("prmtSaleGroupTo");
        this.cbImcome.setName("cbImcome");
        this.rbSaleOrg.setName("rbSaleOrg");
        this.rbCompanyOrg.setName("rbCompanyOrg");
        this.prmtCompanyOrgFrom.setName("prmtCompanyOrgFrom");
        this.comCustomerType.setName("comCustomerType");
        this.txtMShortNameTo.setName("txtMShortNameTo");
        this.spinPeriodYear.setName("spinPeriodYear");
        this.spinPeriodMonth.setName("spinPeriodMonth");
        this.spinPeriodYearTo.setName("spinPeriodYearTo");
        this.spinPeriodMonthTo.setName("spinPeriodMonthTo");
        this.customerClassfiled.setName("customerClassfiled");
        this.materialClass.setName("materialClass");
        this.txtMShortNameFrom.setName("txtMShortNameFrom");
        // CustomerQueryPanel
        // contStartDate		
        this.contStartDate.setBoundLabelText(resHelper.getString("contStartDate.boundLabelText"));		
        this.contStartDate.setBoundLabelLength(80);		
        this.contStartDate.setBoundLabelUnderline(true);
        // contEndDate		
        this.contEndDate.setBoundLabelText(resHelper.getString("contEndDate.boundLabelText"));		
        this.contEndDate.setBoundLabelLength(59);		
        this.contEndDate.setBoundLabelUnderline(true);
        // contMaterialGroupFrom		
        this.contMaterialGroupFrom.setBoundLabelText(resHelper.getString("contMaterialGroupFrom.boundLabelText"));		
        this.contMaterialGroupFrom.setBoundLabelLength(80);		
        this.contMaterialGroupFrom.setBoundLabelUnderline(true);
        // contMaterialGroupTo		
        this.contMaterialGroupTo.setBoundLabelText(resHelper.getString("contMaterialGroupTo.boundLabelText"));		
        this.contMaterialGroupTo.setBoundLabelLength(59);		
        this.contMaterialGroupTo.setBoundLabelUnderline(true);
        // contMaterialFrom		
        this.contMaterialFrom.setBoundLabelText(resHelper.getString("contMaterialFrom.boundLabelText"));		
        this.contMaterialFrom.setBoundLabelLength(80);		
        this.contMaterialFrom.setBoundLabelUnderline(true);
        // contBillStatus		
        this.contBillStatus.setBoundLabelText(resHelper.getString("contBillStatus.boundLabelText"));		
        this.contBillStatus.setBoundLabelLength(80);		
        this.contBillStatus.setBoundLabelUnderline(true);
        // contCustomerGroupTo		
        this.contCustomerGroupTo.setBoundLabelText(resHelper.getString("contCustomerGroupTo.boundLabelText"));		
        this.contCustomerGroupTo.setBoundLabelLength(59);		
        this.contCustomerGroupTo.setBoundLabelUnderline(true);		
        this.contCustomerGroupTo.setVisible(false);
        // contCustomerGroupFrom		
        this.contCustomerGroupFrom.setBoundLabelText(resHelper.getString("contCustomerGroupFrom.boundLabelText"));		
        this.contCustomerGroupFrom.setBoundLabelLength(80);		
        this.contCustomerGroupFrom.setBoundLabelUnderline(true);		
        this.contCustomerGroupFrom.setVisible(false);
        // contCustomerFrom		
        this.contCustomerFrom.setBoundLabelText(resHelper.getString("contCustomerFrom.boundLabelText"));		
        this.contCustomerFrom.setBoundLabelLength(80);		
        this.contCustomerFrom.setBoundLabelUnderline(true);
        // contCustomerTo		
        this.contCustomerTo.setBoundLabelText(resHelper.getString("contCustomerTo.boundLabelText"));		
        this.contCustomerTo.setBoundLabelLength(59);		
        this.contCustomerTo.setBoundLabelUnderline(true);
        // contSaleOrgFrom		
        this.contSaleOrgFrom.setBoundLabelText(resHelper.getString("contSaleOrgFrom.boundLabelText"));		
        this.contSaleOrgFrom.setBoundLabelLength(80);		
        this.contSaleOrgFrom.setBoundLabelUnderline(true);
        // contSalePersonFrom		
        this.contSalePersonFrom.setBoundLabelText(resHelper.getString("contSalePersonFrom.boundLabelText"));		
        this.contSalePersonFrom.setBoundLabelLength(80);		
        this.contSalePersonFrom.setBoundLabelUnderline(true);
        // contSalePersonTo		
        this.contSalePersonTo.setBoundLabelText(resHelper.getString("contSalePersonTo.boundLabelText"));		
        this.contSalePersonTo.setBoundLabelLength(59);		
        this.contSalePersonTo.setBoundLabelUnderline(true);
        // kDSeparator2
        // contMaterialTo		
        this.contMaterialTo.setBoundLabelText(resHelper.getString("contMaterialTo.boundLabelText"));		
        this.contMaterialTo.setBoundLabelLength(59);		
        this.contMaterialTo.setBoundLabelUnderline(true);
        // contClassification		
        this.contClassification.setBoundLabelText(resHelper.getString("contClassification.boundLabelText"));		
        this.contClassification.setBoundLabelLength(80);		
        this.contClassification.setBoundLabelUnderline(true);
        // contBillType		
        this.contBillType.setBoundLabelText(resHelper.getString("contBillType.boundLabelText"));		
        this.contBillType.setBoundLabelLength(80);		
        this.contBillType.setBoundLabelUnderline(true);
        // contGrade		
        this.contGrade.setBoundLabelText(resHelper.getString("contGrade.boundLabelText"));		
        this.contGrade.setBoundLabelLength(80);		
        this.contGrade.setBoundLabelUnderline(true);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(80);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(59);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // contImcome		
        this.contImcome.setBoundLabelText(resHelper.getString("contImcome.boundLabelText"));		
        this.contImcome.setBoundLabelLength(80);		
        this.contImcome.setBoundLabelUnderline(true);
        // chkContainCost		
        this.chkContainCost.setText(resHelper.getString("chkContainCost.text"));
        // kDPanel1		
        this.kDPanel1.setMinimumSize(new Dimension(0,0));		
        this.kDPanel1.setPreferredSize(new Dimension(0,0));
        // contCompanyFrom		
        this.contCompanyFrom.setBoundLabelText(resHelper.getString("contCompanyFrom.boundLabelText"));		
        this.contCompanyFrom.setBoundLabelLength(80);		
        this.contCompanyFrom.setBoundLabelUnderline(true);		
        this.contCompanyFrom.setVisible(false);
        // chkContainInvoice		
        this.chkContainInvoice.setText(resHelper.getString("chkContainInvoice.text"));
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(80);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);
        // ckBxShowMShortName		
        this.ckBxShowMShortName.setText(resHelper.getString("ckBxShowMShortName.text"));
        // kDLabelContainer5		
        this.kDLabelContainer5.setBoundLabelText(resHelper.getString("kDLabelContainer5.boundLabelText"));		
        this.kDLabelContainer5.setBoundLabelLength(80);		
        this.kDLabelContainer5.setBoundLabelUnderline(true);
        // labAccountPeriod		
        this.labAccountPeriod.setBoundLabelText(resHelper.getString("labAccountPeriod.boundLabelText"));		
        this.labAccountPeriod.setBoundLabelUnderline(true);		
        this.labAccountPeriod.setBoundLabelLength(80);
        // labAccPeriodYear		
        this.labAccPeriodYear.setBoundLabelText(resHelper.getString("labAccPeriodYear.boundLabelText"));		
        this.labAccPeriodYear.setBoundLabelUnderline(true);		
        this.labAccPeriodYear.setBoundLabelLength(30);		
        this.labAccPeriodYear.setBoundLabelAlignment(3);
        // labAccPeriodMonth		
        this.labAccPeriodMonth.setBoundLabelText(resHelper.getString("labAccPeriodMonth.boundLabelText"));		
        this.labAccPeriodMonth.setBoundLabelUnderline(true);		
        this.labAccPeriodMonth.setBoundLabelLength(30);		
        this.labAccPeriodMonth.setBoundLabelAlignment(3);
        // labAccountPeriodTo		
        this.labAccountPeriodTo.setBoundLabelText(resHelper.getString("labAccountPeriodTo.boundLabelText"));		
        this.labAccountPeriodTo.setBoundLabelUnderline(true);		
        this.labAccountPeriodTo.setBoundLabelLength(80);
        // labAccPeriodYearTo		
        this.labAccPeriodYearTo.setBoundLabelText(resHelper.getString("labAccPeriodYearTo.boundLabelText"));		
        this.labAccPeriodYearTo.setBoundLabelUnderline(true);		
        this.labAccPeriodYearTo.setBoundLabelLength(30);		
        this.labAccPeriodYearTo.setBoundLabelAlignment(3);
        // labAccPeriodMonthTo		
        this.labAccPeriodMonthTo.setBoundLabelText(resHelper.getString("labAccPeriodMonthTo.boundLabelText"));		
        this.labAccPeriodMonthTo.setBoundLabelLength(30);		
        this.labAccPeriodMonthTo.setBoundLabelAlignment(3);		
        this.labAccPeriodMonthTo.setBoundLabelUnderline(true);
        // AuxiliaryProperties		
        this.AuxiliaryProperties.setText(resHelper.getString("AuxiliaryProperties.text"));
        // spnPrecision
        // lblPrecision		
        this.lblPrecision.setText(resHelper.getString("lblPrecision.text"));
        // kDLabelContainer6		
        this.kDLabelContainer6.setBoundLabelText(resHelper.getString("kDLabelContainer6.boundLabelText"));		
        this.kDLabelContainer6.setBoundLabelLength(80);
        // customerclassfield		
        this.customerclassfield.setVisible(false);
        // MaterialClassfield		
        this.MaterialClassfield.setVisible(false);
        // kDLabelContainer7		
        this.kDLabelContainer7.setBoundLabelText(resHelper.getString("kDLabelContainer7.boundLabelText"));		
        this.kDLabelContainer7.setBoundLabelLength(80);
        // lblPrecision2		
        this.lblPrecision2.setText(resHelper.getString("lblPrecision2.text"));
        // qtyPrecision
        // KdlablePercision1		
        this.KdlablePercision1.setText(resHelper.getString("KdlablePercision1.text"));
        // amountPrecision1
        // amountPrecision2
        // KdlablePercision2		
        this.KdlablePercision2.setText(resHelper.getString("KdlablePercision2.text"));
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(80);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);
        // chkContainBizBill		
        this.chkContainBizBill.setText(resHelper.getString("chkContainBizBill.text"));
        this.chkContainBizBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    chkContainBizBill_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // datePickerStart
        // datePickerEnd
        // prmtMaterialGroupFrom		
        this.prmtMaterialGroupFrom.setDisplayFormat("$number$");		
        this.prmtMaterialGroupFrom.setEditFormat("$number$");		
        this.prmtMaterialGroupFrom.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialGroupQuery");
        // prmtMaterialGroupTo		
        this.prmtMaterialGroupTo.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialGroupQuery");		
        this.prmtMaterialGroupTo.setDisplayFormat("$number$");		
        this.prmtMaterialGroupTo.setEditFormat("$number$");
        // prmtMaterialFrom		
        this.prmtMaterialFrom.setDisplayFormat("$number$");		
        this.prmtMaterialFrom.setEditFormat("$number$");
        // combBillStatus		
        this.combBillStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.sd.sale.SaleReportBillStatusEnum").toArray());		
        this.combBillStatus.setSelectedIndex(0);
        // prmtCustomerGroupTo		
        this.prmtCustomerGroupTo.setCommitFormat("$number$");		
        this.prmtCustomerGroupTo.setEditFormat("$number$");		
        this.prmtCustomerGroupTo.setDisplayFormat("$name$");
        // prmtCustomerGroupFrom		
        this.prmtCustomerGroupFrom.setDisplayFormat("$name$");		
        this.prmtCustomerGroupFrom.setEditFormat("$number$");		
        this.prmtCustomerGroupFrom.setCommitFormat("$number$");
        // prmtCustomerFrom		
        this.prmtCustomerFrom.setEditFormat("$number$");		
        this.prmtCustomerFrom.setDisplayFormat("$number$");
        // prmtCustomerTo		
        this.prmtCustomerTo.setDisplayFormat("$number$");		
        this.prmtCustomerTo.setEditFormat("$number$");
        // prmtSaleOrgFrom		
        this.prmtSaleOrgFrom.setDisplayFormat("$number$");		
        this.prmtSaleOrgFrom.setEditFormat("$number$");		
        this.prmtSaleOrgFrom.setQueryInfo("com.kingdee.eas.basedata.org.app.SaleOrgUnitQuery");		
        this.prmtSaleOrgFrom.setCommitFormat("$number$");		
        this.prmtSaleOrgFrom.setRequired(true);
        // prmtSalePersonFrom		
        this.prmtSalePersonFrom.setQueryInfo("com.kingdee.eas.basedata.scm.sd.sale.app.F7SalePerson2Query");		
        this.prmtSalePersonFrom.setDisplayFormat("$number$");		
        this.prmtSalePersonFrom.setEditFormat("$number$");		
        this.prmtSalePersonFrom.setEditable(true);
        // prmtSalePersonTo		
        this.prmtSalePersonTo.setQueryInfo("com.kingdee.eas.basedata.scm.sd.sale.app.F7SalePerson2Query");		
        this.prmtSalePersonTo.setDisplayFormat("$number$");		
        this.prmtSalePersonTo.setEditFormat("$number$");		
        this.prmtSalePersonTo.setEditable(true);
        // prmtMaterialTo		
        this.prmtMaterialTo.setDisplayFormat("$number$");		
        this.prmtMaterialTo.setEditFormat("$number$");
        // combClassification		
        this.combClassification.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.sd.sale.SaleReportClassificationEnum").toArray());
        // combBillType		
        this.combBillType.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.sd.sale.SaleReportBizTypeEnum").toArray());		
        this.combBillType.setSelectedIndex(0);
        // spinnerGrade
        // prmtSaleGroupFrom		
        this.prmtSaleGroupFrom.setEditFormat("$number$");		
        this.prmtSaleGroupFrom.setDisplayFormat("$number$");		
        this.prmtSaleGroupFrom.setQueryInfo("com.kingdee.eas.basedata.scm.sd.sale.app.F7SaleGroupQueryCondition");
        // prmtSaleGroupTo		
        this.prmtSaleGroupTo.setDisplayFormat("$number$");		
        this.prmtSaleGroupTo.setEditFormat("$number$");		
        this.prmtSaleGroupTo.setQueryInfo("com.kingdee.eas.basedata.scm.sd.sale.app.F7SaleGroupQueryCondition");
        // cbImcome		
        this.cbImcome.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.sd.sale.report.SaleImcomEnum").toArray());
        // bgOrgSelected		
        this.bgOrgSelected.setValue(1);
        this.bgOrgSelected.add(this.rbSaleOrg);
        this.bgOrgSelected.add(this.rbCompanyOrg);
        // rbSaleOrg		
        this.rbSaleOrg.setText(resHelper.getString("rbSaleOrg.text"));		
        this.rbSaleOrg.setSelected(true);		
        this.rbSaleOrg.setToolTipText(resHelper.getString("rbSaleOrg.toolTipText"));
        // rbCompanyOrg		
        this.rbCompanyOrg.setText(resHelper.getString("rbCompanyOrg.text"));		
        this.rbCompanyOrg.setToolTipText(resHelper.getString("rbCompanyOrg.toolTipText"));
        // prmtCompanyOrgFrom		
        this.prmtCompanyOrgFrom.setDisplayFormat("$number$");		
        this.prmtCompanyOrgFrom.setEditFormat("$number$");		
        this.prmtCompanyOrgFrom.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyUnitQuery");		
        this.prmtCompanyOrgFrom.setCommitFormat("$number$");		
        this.prmtCompanyOrgFrom.setRequired(true);
        // comCustomerType		
        this.comCustomerType.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.sd.sale.report.SaleGrossProfitsRptCuTypeEnum").toArray());
        // txtMShortNameTo
        // spinPeriodYear
        // spinPeriodMonth
        // spinPeriodYearTo
        // spinPeriodMonthTo
        // customerClassfiled
        // materialClass
        // txtMShortNameFrom
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
        this.setBounds(new Rectangle(10, 10, 450, 580));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 450, 580));
        contStartDate.setBounds(new Rectangle(10, 35, 200, 19));
        this.add(contStartDate, new KDLayout.Constraints(10, 35, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contEndDate.setBounds(new Rectangle(227, 35, 193, 19));
        this.add(contEndDate, new KDLayout.Constraints(227, 35, 193, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contMaterialGroupFrom.setBounds(new Rectangle(10, 85, 200, 19));
        this.add(contMaterialGroupFrom, new KDLayout.Constraints(10, 85, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contMaterialGroupTo.setBounds(new Rectangle(227, 85, 193, 19));
        this.add(contMaterialGroupTo, new KDLayout.Constraints(227, 85, 193, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contMaterialFrom.setBounds(new Rectangle(10, 110, 200, 19));
        this.add(contMaterialFrom, new KDLayout.Constraints(10, 110, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBillStatus.setBounds(new Rectangle(224, 262, 200, 17));
        this.add(contBillStatus, new KDLayout.Constraints(224, 262, 200, 17, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contCustomerGroupTo.setBounds(new Rectangle(322, 475, 31, 17));
        this.add(contCustomerGroupTo, new KDLayout.Constraints(322, 475, 31, 17, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCustomerGroupFrom.setBounds(new Rectangle(375, 475, 39, 17));
        this.add(contCustomerGroupFrom, new KDLayout.Constraints(375, 475, 39, 17, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contCustomerFrom.setBounds(new Rectangle(10, 160, 200, 19));
        this.add(contCustomerFrom, new KDLayout.Constraints(10, 160, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCustomerTo.setBounds(new Rectangle(227, 160, 193, 19));
        this.add(contCustomerTo, new KDLayout.Constraints(227, 160, 193, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contSaleOrgFrom.setBounds(new Rectangle(10, 185, 410, 19));
        this.add(contSaleOrgFrom, new KDLayout.Constraints(10, 185, 410, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contSalePersonFrom.setBounds(new Rectangle(10, 235, 200, 19));
        this.add(contSalePersonFrom, new KDLayout.Constraints(10, 235, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contSalePersonTo.setBounds(new Rectangle(227, 235, 193, 19));
        this.add(contSalePersonTo, new KDLayout.Constraints(227, 235, 193, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator2.setBounds(new Rectangle(2, 258, 436, 5));
        this.add(kDSeparator2, new KDLayout.Constraints(2, 258, 436, 5, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contMaterialTo.setBounds(new Rectangle(227, 110, 193, 19));
        this.add(contMaterialTo, new KDLayout.Constraints(227, 110, 193, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contClassification.setBounds(new Rectangle(10, 287, 200, 17));
        this.add(contClassification, new KDLayout.Constraints(10, 287, 200, 17, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBillType.setBounds(new Rectangle(10, 262, 199, 17));
        this.add(contBillType, new KDLayout.Constraints(10, 262, 199, 17, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contGrade.setBounds(new Rectangle(224, 287, 200, 17));
        this.add(contGrade, new KDLayout.Constraints(224, 287, 200, 17, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer1.setBounds(new Rectangle(10, 210, 200, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(10, 210, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(227, 210, 193, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(227, 210, 193, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contImcome.setBounds(new Rectangle(10, 327, 200, 19));
        this.add(contImcome, new KDLayout.Constraints(10, 327, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkContainCost.setBounds(new Rectangle(322, 450, 107, 19));
        this.add(chkContainCost, new KDLayout.Constraints(322, 450, 107, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDPanel1.setBounds(new Rectangle(17, 5, 369, 26));
        this.add(kDPanel1, new KDLayout.Constraints(17, 5, 369, 26, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCompanyFrom.setBounds(new Rectangle(10, 185, 410, 19));
        this.add(contCompanyFrom, new KDLayout.Constraints(10, 185, 410, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        chkContainInvoice.setBounds(new Rectangle(224, 327, 100, 19));
        this.add(chkContainInvoice, new KDLayout.Constraints(224, 327, 100, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(10, 135, 198, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(10, 135, 198, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        ckBxShowMShortName.setBounds(new Rectangle(10, 352, 103, 19));
        this.add(ckBxShowMShortName, new KDLayout.Constraints(10, 352, 103, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer5.setBounds(new Rectangle(225, 375, 200, 19));
        this.add(kDLabelContainer5, new KDLayout.Constraints(225, 375, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        labAccountPeriod.setBounds(new Rectangle(11, 450, 85, 19));
        this.add(labAccountPeriod, new KDLayout.Constraints(11, 450, 85, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        labAccPeriodYear.setBounds(new Rectangle(92, 450, 100, 19));
        this.add(labAccPeriodYear, new KDLayout.Constraints(92, 450, 100, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        labAccPeriodMonth.setBounds(new Rectangle(203, 450, 89, 19));
        this.add(labAccPeriodMonth, new KDLayout.Constraints(203, 450, 89, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        labAccountPeriodTo.setBounds(new Rectangle(10, 475, 85, 19));
        this.add(labAccountPeriodTo, new KDLayout.Constraints(10, 475, 85, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        labAccPeriodYearTo.setBounds(new Rectangle(92, 475, 100, 19));
        this.add(labAccPeriodYearTo, new KDLayout.Constraints(92, 475, 100, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        labAccPeriodMonthTo.setBounds(new Rectangle(203, 475, 89, 19));
        this.add(labAccPeriodMonthTo, new KDLayout.Constraints(203, 475, 89, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        AuxiliaryProperties.setBounds(new Rectangle(10, 307, 115, 18));
        this.add(AuxiliaryProperties, new KDLayout.Constraints(10, 307, 115, 18, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        spnPrecision.setBounds(new Rectangle(222, 400, 50, 19));
        this.add(spnPrecision, new KDLayout.Constraints(222, 400, 50, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        lblPrecision.setBounds(new Rectangle(10, 400, 188, 19));
        this.add(lblPrecision, new KDLayout.Constraints(10, 400, 188, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer6.setBounds(new Rectangle(222, 135, 200, 19));
        this.add(kDLabelContainer6, new KDLayout.Constraints(222, 135, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        customerclassfield.setBounds(new Rectangle(10, 500, 170, 19));
        this.add(customerclassfield, new KDLayout.Constraints(10, 500, 170, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        MaterialClassfield.setBounds(new Rectangle(200, 500, 170, 19));
        this.add(MaterialClassfield, new KDLayout.Constraints(200, 500, 170, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer7.setBounds(new Rectangle(10, 60, 410, 19));
        this.add(kDLabelContainer7, new KDLayout.Constraints(10, 60, 410, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        lblPrecision2.setBounds(new Rectangle(10, 425, 182, 19));
        this.add(lblPrecision2, new KDLayout.Constraints(10, 425, 182, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        qtyPrecision.setBounds(new Rectangle(222, 425, 50, 19));
        this.add(qtyPrecision, new KDLayout.Constraints(222, 425, 50, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        KdlablePercision1.setBounds(new Rectangle(293, 400, 78, 19));
        this.add(KdlablePercision1, new KDLayout.Constraints(293, 400, 78, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        amountPrecision1.setBounds(new Rectangle(376, 400, 50, 19));
        this.add(amountPrecision1, new KDLayout.Constraints(376, 400, 50, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        amountPrecision2.setBounds(new Rectangle(376, 425, 50, 19));
        this.add(amountPrecision2, new KDLayout.Constraints(376, 425, 50, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        KdlablePercision2.setBounds(new Rectangle(293, 425, 78, 19));
        this.add(KdlablePercision2, new KDLayout.Constraints(293, 425, 78, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer4.setBounds(new Rectangle(10, 375, 199, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(10, 375, 199, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkContainBizBill.setBounds(new Rectangle(324, 327, 100, 19));
        this.add(chkContainBizBill, new KDLayout.Constraints(324, 327, 100, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contStartDate
        contStartDate.setBoundEditor(datePickerStart);
        //contEndDate
        contEndDate.setBoundEditor(datePickerEnd);
        //contMaterialGroupFrom
        contMaterialGroupFrom.setBoundEditor(prmtMaterialGroupFrom);
        //contMaterialGroupTo
        contMaterialGroupTo.setBoundEditor(prmtMaterialGroupTo);
        //contMaterialFrom
        contMaterialFrom.setBoundEditor(prmtMaterialFrom);
        //contBillStatus
        contBillStatus.setBoundEditor(combBillStatus);
        //contCustomerGroupTo
        contCustomerGroupTo.setBoundEditor(prmtCustomerGroupTo);
        //contCustomerGroupFrom
        contCustomerGroupFrom.setBoundEditor(prmtCustomerGroupFrom);
        //contCustomerFrom
        contCustomerFrom.setBoundEditor(prmtCustomerFrom);
        //contCustomerTo
        contCustomerTo.setBoundEditor(prmtCustomerTo);
        //contSaleOrgFrom
        contSaleOrgFrom.setBoundEditor(prmtSaleOrgFrom);
        //contSalePersonFrom
        contSalePersonFrom.setBoundEditor(prmtSalePersonFrom);
        //contSalePersonTo
        contSalePersonTo.setBoundEditor(prmtSalePersonTo);
        //contMaterialTo
        contMaterialTo.setBoundEditor(prmtMaterialTo);
        //contClassification
        contClassification.setBoundEditor(combClassification);
        //contBillType
        contBillType.setBoundEditor(combBillType);
        //contGrade
        contGrade.setBoundEditor(spinnerGrade);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(prmtSaleGroupFrom);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(prmtSaleGroupTo);
        //contImcome
        contImcome.setBoundEditor(cbImcome);
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(17, 5, 369, 26));        rbSaleOrg.setBounds(new Rectangle(6, 3, 140, 19));
        kDPanel1.add(rbSaleOrg, new KDLayout.Constraints(6, 3, 140, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        rbCompanyOrg.setBounds(new Rectangle(217, 3, 140, 19));
        kDPanel1.add(rbCompanyOrg, new KDLayout.Constraints(217, 3, 140, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contCompanyFrom
        contCompanyFrom.setBoundEditor(prmtCompanyOrgFrom);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(comCustomerType);
        //kDLabelContainer5
        kDLabelContainer5.setBoundEditor(txtMShortNameTo);
        //labAccPeriodYear
        labAccPeriodYear.setBoundEditor(spinPeriodYear);
        //labAccPeriodMonth
        labAccPeriodMonth.setBoundEditor(spinPeriodMonth);
        //labAccPeriodYearTo
        labAccPeriodYearTo.setBoundEditor(spinPeriodYearTo);
        //labAccPeriodMonthTo
        labAccPeriodMonthTo.setBoundEditor(spinPeriodMonthTo);
        //kDLabelContainer6
        kDLabelContainer6.setBoundEditor(customerClassfiled);
        //kDLabelContainer7
        kDLabelContainer7.setBoundEditor(materialClass);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtMShortNameFrom);

    }


    /**
     * output initUIMenuBarLayout method
     */
    public void initUIMenuBarLayout()
    {

    }

    /**
     * output initUIToolBarLayout method
     */
    public void initUIToolBarLayout()
    {


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.salegrossprofitsrpt.app.SaleGrossProfitsConditionUIHandler";
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
    }

    /**
     * output chkContainBizBill_actionPerformed method
     */
    protected void chkContainBizBill_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }


    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.salegrossprofitsrpt.client", "SaleGrossProfitsConditionUI");
    }




}