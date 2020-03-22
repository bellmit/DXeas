/**
 * output package name
 */
package com.kingdee.eas.custom.salegrossprofitsrpt.client;

import java.awt.event.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.swing.KDSpinner;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.base.commonquery.client.CustomerParams;
import com.kingdee.eas.base.report.client.SpinnerFilterElement;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.assistant.PeriodUtils;
import com.kingdee.eas.basedata.assistant.SystemStatusCtrolUtils;
import com.kingdee.eas.basedata.framework.util.EntityControlTypeUtil;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupStandardCollection;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupStandardFactory;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupStandardInfo;
import com.kingdee.eas.basedata.master.cssp.ICSSPGroupStandard;
import com.kingdee.eas.basedata.master.cssp.MainDataParser;
import com.kingdee.eas.basedata.master.cssp.StandardTypeEnum;
import com.kingdee.eas.basedata.master.material.IMaterialGroupStandard;
import com.kingdee.eas.basedata.master.material.MaterialGroupStandardCollection;
import com.kingdee.eas.basedata.master.material.MaterialGroupStandardFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupStandardInfo;
import com.kingdee.eas.basedata.master.material.MaterialGroupStandardTypeEnum;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.FullOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.SCMRptMultiOrgsF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.salegrossprofitsrpt.materialClassifiedStandard;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.scm.cal.WrittenOffFacadeFactory;
import com.kingdee.eas.scm.cal.info.WriteOffPeriodInfo;
import com.kingdee.eas.scm.common.client.SCMClientHelper;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.scm.common.filter.CheckRadioFilterElement;
import com.kingdee.eas.scm.common.filter.CompositeFilterElement;
import com.kingdee.eas.scm.common.filter.MultiOrgsFilterElement;
import com.kingdee.eas.scm.common.filter.SingleFilterElement;
import com.kingdee.eas.scm.common.util.SCMQueryFormat;
import com.kingdee.eas.scm.common.util.SCMUtils;
import com.kingdee.eas.scm.im.rpt.IMRptUtils;
import com.kingdee.eas.scm.sd.sale.SaleReportBillStatusEnum;
import com.kingdee.eas.scm.sd.sale.SaleReportBizTypeEnum;
import com.kingdee.eas.scm.sd.sale.SaleReportClassificationEnum;
import com.kingdee.eas.scm.sd.sale.report.ISaleGrossProfits;
import com.kingdee.eas.scm.sd.sale.report.SaleGrossProfitsFactory;
import com.kingdee.eas.scm.sd.sale.report.SaleGrossProfitsRptCuTypeEnum;
import com.kingdee.eas.scm.sd.sale.report.SaleImcomEnum;
//import com.kingdee.eas.scm.sd.sale.report.client.SaleGrossProfitsConditionUI;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;


public class SaleGrossProfitsConditionUI extends AbstractSaleGrossProfitsConditionUI
{
	private static final Logger logger = CoreUIObject.getLogger(SaleGrossProfitsConditionUI.class);
	private static final long serialVersionUID = 7270032977740720216L;
	
	
	
	
	
	
	   private int materialGroupMaxLevel = 0;
	
	   private int customerGroupMaxLevel = 0;
	   private ItemListener groupStandardListener = null;
	   private Object selectedItem = null;
	   protected String customerGroupStandardID = null;
	   protected boolean isBaseStardarGroupStandard = true;
	
	
	
	   protected String materialGroupStandardID = null;
	   private Map periodMap = new HashMap();
	   ItemListener materialClassfiedListerer=null;
	private ItemListener classificationListener;
	private ItemListener combBillStatusListener;
	private ItemListener rbSaleOrgListener;
	private ItemListener combBillFromListener;
	private ItemListener combBillTypeListener;
	private ItemListener customerClassfiledListener;
	private SCMRptMultiOrgsF7 saleOrgsMultiF7;
	private SCMRptMultiOrgsF7 companyOrgsMultiF7;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	public SaleGrossProfitsConditionUI()
	     throws Exception
	   {
	     setSize(450, 600);
	     getGroupMaxLevel();
	     initInterface();
	     this.isReport = true;
	 
	     addCkBxSimpleNameListener();
	 
	     setSpinRange(this.spnPrecision, new Integer(10), new Integer(0));
	     setSpinRange(this.qtyPrecision, new Integer(10), new Integer(0));
	     setSpinRange(this.amountPrecision1, new Integer(10), new Integer(0));
	     setSpinRange(this.amountPrecision2, new Integer(10), new Integer(0));
	     this.lblPrecision.setEnabled(false);
	     this.spnPrecision.setEnabled(false);
	     this.spnPrecision.setValue(new Integer(4));
	     this.KdlablePercision1.setEnabled(false);
	     this.amountPrecision1.setEnabled(false);
	     this.amountPrecision1.setValue(new Integer(4));
	     this.qtyPrecision.setValue(new Integer(4));
	     this.amountPrecision2.setValue(new Integer(4));
	 
	     setBizMaterialF7(this.prmtMaterialFrom, false, null);
	     setBizMaterialF7(this.prmtMaterialTo, false, null);
	 
	     setBizCustomerF7(this.prmtCustomerFrom, null);
	     setBizCustomerF7(this.prmtCustomerTo, null);
	
	 
	     CompositeFilterElement elements = new CompositeFilterElement(0);
	
	 
	     Timestamp[] dates = SCMUtils.getDefaultDateRange(SCMClientUtils.getServerDate2());
	
	 
	     SingleFilterElement element = new SingleFilterElement("dateStart", this.datePickerStart);
	 
	     element.setDefaultValue(dates[0]);
	     element.setCompareType(CompareType.GREATER_EQUALS);
	     elements.add(element);
	 
	     element = new SingleFilterElement("dateEnd", this.datePickerEnd);
	     element.setDefaultValue(dates[1]);
	     element.setCompareType(CompareType.LESS_EQUALS);
	     elements.add(element);
	 
	     element = new SingleFilterElement("materialGroupFrom", this.prmtMaterialGroupFrom);
	     element.setCompareType(CompareType.GREATER_EQUALS);
	     elements.add(element);
	     element = new SingleFilterElement("materialGroupTo", this.prmtMaterialGroupTo);
	     element.setCompareType(CompareType.LESS_EQUALS);
	     elements.add(element);
	 
	     element = new SingleFilterElement("materialFrom", this.prmtMaterialFrom);
	     element.setCompareType(CompareType.GREATER_EQUALS);
	     elements.add(element);
	     element = new SingleFilterElement("materialTo", this.prmtMaterialTo);
	     element.setCompareType(CompareType.LESS_EQUALS);
	     elements.add(element);
	 
	     element = new SingleFilterElement("customerGroupFrom", this.prmtCustomerGroupFrom);
	     element.setCompareType(CompareType.GREATER_EQUALS);
	     elements.add(element);
	     element = new SingleFilterElement("customerGroupFrom", this.prmtCustomerGroupTo);
	     element.setCompareType(CompareType.LESS_EQUALS);
	     elements.add(element);
	 
	     element = new SingleFilterElement("customerFrom", this.prmtCustomerFrom);
	     element.setCompareType(CompareType.GREATER_EQUALS);
	     elements.add(element);
	     element = new SingleFilterElement("customerTo", this.prmtCustomerTo);
	     element.setCompareType(CompareType.LESS_EQUALS);
	     elements.add(element);
	
	 
	     element = new SingleFilterElement("shortNameFrom", this.txtMShortNameFrom);
	     element.setCompareType(CompareType.GREATER_EQUALS);
	     elements.add(element);
	     element = new SingleFilterElement("shortNameTo", this.txtMShortNameTo);
	     element.setCompareType(CompareType.LESS_EQUALS);
	     elements.add(element);
	 
	     SpinnerFilterElement spe = new SpinnerFilterElement("spnPrecision", this.spnPrecision);
	 
	     spe.setDefaultValue(new Integer(4));
	     elements.add(spe);
	     SpinnerFilterElement spe1 = new SpinnerFilterElement("qtyPrecision", this.qtyPrecision);
	 
	     spe.setDefaultValue(new Integer(4));
	     elements.add(spe1);
	     SpinnerFilterElement spe2 = new SpinnerFilterElement("amountPrecision1", this.amountPrecision1);
	 
	     spe.setDefaultValue(new Integer(4));
	     elements.add(spe2);
	     SpinnerFilterElement spe3 = new SpinnerFilterElement("amountPrecision2", this.amountPrecision2);
	 
	     spe.setDefaultValue(new Integer(4));
	     elements.add(spe3);
	 
	     element = new SingleFilterElement("periodYear", this.spinPeriodYear);
	     element.setCompareType(CompareType.GREATER_EQUALS);
	     elements.add(element);
	     element = new SingleFilterElement("periodYearTo", this.spinPeriodYearTo);
	     element.setCompareType(CompareType.LESS_EQUALS);
	     elements.add(element);
	 
	     element = new SingleFilterElement("periodMonth", this.spinPeriodMonth);
	     element.setCompareType(CompareType.GREATER_EQUALS);
	     elements.add(element);
	     element = new SingleFilterElement("periodMonthTo", this.spinPeriodMonthTo);
	     element.setCompareType(CompareType.LESS_EQUALS);
	     elements.add(element);
	
	 
	     CheckRadioFilterElement el = new CheckRadioFilterElement("ckBxShowMShortName", this.ckBxShowMShortName);
	 
	     el.setDefaultValue(new Boolean(false));
	     elements.add(el);
	
	
	
	
	
	
	 
	     element = new SingleFilterElement("isContainCost", this.chkContainCost);
	     elements.add(element);
	
	
	
	 
	     element = new SingleFilterElement("saleGroupFrom", this.prmtSaleGroupFrom);
	     element.setCompareType(CompareType.GREATER_EQUALS);
	     elements.add(element);
	     element = new SingleFilterElement("saleGroupTo", this.prmtSaleGroupTo);
	     element.setCompareType(CompareType.LESS_EQUALS);
	     elements.add(element);
	
	
	
	
	
	
	
	 
	     SCMClientHelper scmClientHelper = new SCMClientHelper(this);
	     scmClientHelper.setSalePersonDisplay(this.prmtSalePersonFrom);
	     scmClientHelper.setSalePersonDisplay(this.prmtSalePersonTo);
	 
	     element = new SingleFilterElement("salePersonFrom", this.prmtSalePersonFrom);
	     element.setCompareType(CompareType.GREATER_EQUALS);
	     elements.add(element);
	     element = new SingleFilterElement("salePersonTo", this.prmtSalePersonTo);
	     element.setCompareType(CompareType.LESS_EQUALS);
	     elements.add(element);
	 
	     element = new SingleFilterElement("billType", this.combBillType);
	     element.setDefaultValue(SaleReportBizTypeEnum.all);
	     elements.add(element);
	 
	     element = new SingleFilterElement("billStatus", this.combBillStatus);
	     element.setDefaultValue(SaleReportBillStatusEnum.all);
	     elements.add(element);
	 
	     element = new SingleFilterElement("classification", this.combClassification);
	     element.setDefaultValue(SaleReportClassificationEnum.material);
	     elements.add(element);
	     
	
	 
	     element = new SingleFilterElement("imcomeFrom", this.cbImcome);
	     element.setDefaultValue(SaleImcomEnum.FROM_AR);
	     elements.add(element);
	     element = new SingleFilterElement("containInvoice", this.chkContainInvoice);
	     element.setDefaultValue(Boolean.FALSE);
	     elements.add(element);
	
	 
	     element = new SingleFilterElement("containBizBill", this.chkContainBizBill);
	     element.setDefaultValue(Boolean.FALSE);
	     elements.add(element);
	
	 
	     element = new SingleFilterElement("CustomerType", this.comCustomerType);
	     element.setDefaultValue(SaleGrossProfitsRptCuTypeEnum.ARCustomer);
	     elements.add(element);
	 
	     element = new SingleFilterElement("customerClassfiled", this.customerclassfield);
	     elements.add(element);
	 
	     element = new SingleFilterElement("materialClassfiled", this.MaterialClassfield);
	     elements.add(element);
	
	
	
	 
	     CheckRadioFilterElement e = new CheckRadioFilterElement("AuxiliaryProperties", this.AuxiliaryProperties);
	 
	     e.setDefaultValue(new Boolean(false));
	     elements.add(e);
	     getFilterManager().setElement(elements);
	 
	     setNeedMainOrgF7s(new KDBizPromptBox[] { this.prmtSaleGroupFrom, this.prmtSaleGroupTo, this.prmtCustomerFrom, this.prmtCustomerTo, this.prmtMaterialFrom, this.prmtMaterialTo });
	
	
	
	 
	     addListener();
	   }
	
	   public void onLoad() throws Exception {
	     super.onLoad();
	     CompanyOrgUnitInfo company = (CompanyOrgUnitInfo)SysContext.getSysContext().getCurrentOrgUnit(OrgType.Company);
	     if ((null != company) && (!(this.periodMap.containsKey(company.getId().toString())))) {
	       Map map = WrittenOffFacadeFactory.getRemoteInstance().loadFinanceData(company.getId().toString());
	       WriteOffPeriodInfo info = (WriteOffPeriodInfo)map.get(company.getId().toString());
	       this.periodMap.put(company.getId().toString(), info);
	     }
	 
	     this.spinPeriodYear.addChangeListener(new ChangeListener()
	     {
	       public void stateChanged(ChangeEvent arg0) {
	         CompanyOrgUnitInfo company = (CompanyOrgUnitInfo)SysContext.getSysContext().getCurrentOrgUnit(OrgType.Company);
	         if (((KDSpinner)arg0.getSource()).equals(SaleGrossProfitsConditionUI.this.spinPeriodYear))
	           SaleGrossProfitsConditionUI.this.setPeriod(SaleGrossProfitsConditionUI.this.spinPeriodYear, company);
	
	
	
	       }
	     });
	     this.spinPeriodYearTo.addChangeListener(new ChangeListener()
	     {
	       public void stateChanged(ChangeEvent arg0) {
	         CompanyOrgUnitInfo company = (CompanyOrgUnitInfo)SysContext.getSysContext().getCurrentOrgUnit(OrgType.Company);
	         if (((KDSpinner)arg0.getSource()).equals(SaleGrossProfitsConditionUI.this.spinPeriodYearTo))
	           SaleGrossProfitsConditionUI.this.setPeriod(SaleGrossProfitsConditionUI.this.spinPeriodYearTo, company);
	
	
	       }
	     });
	     this.groupStandardListener = new ItemListener() {
	       public void itemStateChanged(ItemEvent e) {
	         SaleGrossProfitsConditionUI.this.itemChanaged(e);
	
	       }
	     };
	     loadGroupStandard();
	     this.selectedItem = this.customerClassfiled.getSelectedItem();
	     loadMaterialGroupStandard();
	     initComp(); }
	
	   public void initComp() {
	     this.customerClassfiled.setEnabled(false);
	     this.customerclassfield.setText("");
	   }
	
	
	
	
	
	
	
	
	   private void itemChanaged(ItemEvent e)
	   {
	     Object item = e.getItem();
	     if ((item != null) && (item.equals(this.selectedItem))) {
	       return;
	     }
	     this.selectedItem = item;
	 
	     CSSPGroupStandardInfo standardInfo = (CSSPGroupStandardInfo)this.customerClassfiled.getSelectedItem();
	 
	     this.customerGroupStandardID = standardInfo.getId().toString();
	     this.isBaseStardarGroupStandard = (standardInfo.getIsBasic() == StandardTypeEnum.basicStandard);
	   }
	
	
	
	
	
	
	
	
	
	
	
	
	   private void loadGroupStandard()
	     throws Exception
	   {
	     ICSSPGroupStandard iSupplierGroupStandard = CSSPGroupStandardFactory.getRemoteInstance();
	 
	     this.customerClassfiled.removeItemListener(this.groupStandardListener);
	     CSSPGroupStandardCollection stds = iSupplierGroupStandard.getCSSPGroupStandard("1", false);
	 
	     this.customerClassfiled.removeAllItems();
	 
	     if (stds != null) {
	       this.customerClassfiled.addItems(stds.toArray());
	     }
	 
	     this.customerClassfiled.addItemListener(this.groupStandardListener);
	     if (this.customerClassfiled.getSelectedItem() != null)
	       this.customerGroupStandardID = ((CSSPGroupStandardInfo)this.customerClassfiled.getSelectedItem()).getId().toString();
	   }
	
	
	
	
	   private void loadMaterialGroupStandard()
	     throws Exception
	   {
	     IMaterialGroupStandard iMaterialGroupStandard = MaterialGroupStandardFactory.getRemoteInstance();
	 
	     this.materialClass.removeItemListener(this.materialClassfiedListerer);
	     FilterInfo filterInfoCU = EntityControlTypeUtil.getFilterInfoForControlTypeS4(SysContext.getSysContext().getCurrentCtrlUnit().getId().toString(), SysContext.getSysContext().getCurrentCtrlUnit().getLongNumber());
	
	 
	     EntityViewInfo viewInfo = new EntityViewInfo();
	     viewInfo.setFilter(filterInfoCU);
	     MaterialGroupStandardCollection groupStandardColl = iMaterialGroupStandard.getMaterialGroupStandardCollection(viewInfo);
	
	 
	     this.materialClass.removeAllItems();
	     if (groupStandardColl != null) {
	       this.materialClass.addItems(groupStandardColl.toArray());
	
	     }
	 
	     int size = (groupStandardColl != null) ? groupStandardColl.size() : 0;
	     MaterialGroupStandardInfo baseGroupStandardInfo = null;
	     for (int index = 0; index < size; ++index) {
	       if (groupStandardColl.get(index).getStandardType() == MaterialGroupStandardTypeEnum.BasicStandard) {
	         baseGroupStandardInfo = groupStandardColl.get(index);
	       }
	     }
	 
	     if (baseGroupStandardInfo != null) {
	       this.materialClass.setSelectedItem(baseGroupStandardInfo);
	 
	       this.isBaseStardarGroupStandard = true;
	     }
	 
	     this.materialClass.addItemListener(this.materialClassfiedListerer);
	   }
	
	
	   public void stateChanged(ChangeEvent e)
	   {
	     CompanyOrgUnitInfo aCompanyOrgUnitInfo = (CompanyOrgUnitInfo)SysContext.getSysContext().getCurrentOrgUnit(OrgType.Company);
	     KDSpinner aSpinner = (KDSpinner)e.getSource();
	     PeriodInfo periodInfo = null;
	     try {
	       periodInfo = SystemStatusCtrolUtils.getStartPeriod(null, SystemEnum.INVENTORYMANAGEMENT, aCompanyOrgUnitInfo);
	 
	       if (periodInfo != null) {
	         int startYear = periodInfo.getPeriodYear();
	         int startMonth = periodInfo.getPeriodNumber();
	
	
	
	 
	         int minPeriod = PeriodUtils.getMinPeriodNumber(null, Integer.parseInt(aSpinner.getValue().toString()), aCompanyOrgUnitInfo.getId().toString());
	         int maxPeriod = PeriodUtils.getMaxPeriodNumber(null, Integer.parseInt(aSpinner.getValue().toString()), aCompanyOrgUnitInfo.getId().toString());
	         if (aSpinner.getName().toString().equals("spinPeriodYear")) {
	           if (Integer.parseInt(aSpinner.getValue().toString()) == startYear) {
	             minPeriod = startMonth;
	           }
	           SetSpinnerMaxMin(this.spinPeriodMonth, minPeriod, maxPeriod);
	           int curPeriod = Integer.parseInt(this.spinPeriodMonth.getValue().toString());
	           if ((curPeriod < minPeriod) || (curPeriod > maxPeriod))
	             this.spinPeriodMonth.setValue(new Integer(maxPeriod));
	         }
	         else {
	           if (Integer.parseInt(aSpinner.getValue().toString()) == startYear) {
	             minPeriod = startMonth;
	           }
	           SetSpinnerMaxMin(this.spinPeriodMonthTo, minPeriod, maxPeriod);
	           int curPeriod = Integer.parseInt(this.spinPeriodMonth.getValue().toString());
	           if ((curPeriod < minPeriod) || (curPeriod > maxPeriod))
	             this.spinPeriodMonthTo.setValue(new Integer(maxPeriod));
	         }
	       }
	       else
	       {
	         MsgBox.showError(EASResource.getString("com.kingdee.eas.scm.cal.CalCommonResource", "PERIOD_IS_NULL"));
	       }
	     }
	     catch (Exception e1) {
	       handUIException(e1);
	     }
	   }
	
	   private void setPeriod(KDSpinner periodYear, CompanyOrgUnitInfo companyInfo)
	   {
	     try {
	       if (periodYear.getValue() != null) {
	         KDSpinner kdspinner = this.spinPeriodMonth;
	         if (periodYear.equals(this.spinPeriodYearTo)) {
	           kdspinner = this.spinPeriodMonthTo;
	         }
	         int year = ((Integer)periodYear.getValue()).intValue();
	
	 
	         PeriodInfo curPeriodInfo = null;
	         PeriodInfo startPeriodInfo = null;
	 
	         int minMonth = 1;
	         int maxMonth = 12;
	
	 
	         if (companyInfo != null) {
	           if (this.periodMap.containsKey(companyInfo.getId().toString())) {
	             WriteOffPeriodInfo info = (WriteOffPeriodInfo)this.periodMap.get(companyInfo.getId().toString());
	             curPeriodInfo = info.getCurPeriodInfo();
	             startPeriodInfo = info.getStartPeriodInfo();
	             minMonth = info.getMinMonth();
	             maxMonth = info.getMaxMonth();
	           } else {
	             curPeriodInfo = SystemStatusCtrolUtils.getCurrentPeriod(null, SystemEnum.INVENTORYMANAGEMENT, companyInfo);
	 
	             startPeriodInfo = SystemStatusCtrolUtils.getStartPeriod(null, SystemEnum.INVENTORYMANAGEMENT, companyInfo);
	 
	             minMonth = PeriodUtils.getMinPeriodNumber(null, year, companyInfo.getId().toString());
	             maxMonth = PeriodUtils.getMaxPeriodNumber(null, year, companyInfo.getId().toString());
	           }
	 
	           if (minMonth == 0) minMonth = 1;
	           if (maxMonth == 0) maxMonth = 12;
	         }
	         if ((startPeriodInfo != null) && 
	           (year == startPeriodInfo.getPeriodYear())) {
	           minMonth = startPeriodInfo.getPeriodNumber();
	
	         }
	 
	         SetSpinnerMaxMin(kdspinner, minMonth, maxMonth);
	 
	         if (curPeriodInfo != null) {
	           kdspinner.setValue(new Integer(curPeriodInfo.getPeriodNumber()));
	         }
	 
	         if (kdspinner.getIntegerVlaue().intValue() < minMonth) {
	           kdspinner.setValue(new Integer(minMonth));
	         }
	         if (kdspinner.getIntegerVlaue().intValue() > maxMonth)
	           kdspinner.setValue(new Integer(maxMonth));
	       }
	     }
	     catch (Exception ex)
	     {
	       handUIException(ex);
	     }
	   }
	
	   private void SetSpinnerMaxMin(JSpinner spinner, int min, int max) {
	     SpinnerModel model = spinner.getModel();
	     if (model instanceof SpinnerNumberModel) {
	       if (max > min) {
	         ((SpinnerNumberModel)model).setMaximum(new Integer(max));
	       }
	       ((SpinnerNumberModel)model).setMinimum(new Integer(min));
	     }
	   }
	
	
	
	
	
	
	   public CustomerParams getCustomerParams()
	   {
	     CustomerParams pp = super.getCustomerParams();
	 
	     if (this.contGrade.isVisible())
	       pp.addCustomerParam("grade", getSpinValue(this.spinnerGrade).toString());
	     else {
	       pp.addCustomerParam("grade", "0");
	     }
	 
	     if (this.spnPrecision.isEnabled())
	       pp.addCustomerParam("precision", getSpinValue(this.spnPrecision).toString());
	     else {
	       pp.addCustomerParam("precision", "0");
	     }
	     pp.addCustomerParam("byOrgType", String.valueOf(this.rbSaleOrg.isSelected()));
	 
	     return pp;
	   }
	
	   public RptParams getCustomCondition() {
	     RptParams pp = super.getCustomCondition();
	     if (this.contGrade.isVisible())
	       pp.setInt("grade", getSpinValue(this.spinnerGrade).intValue());
	     else {
	       pp.setInt("grade", 0);
	     }
	 
	     if (this.spnPrecision.isEnabled())
	       pp.setInt("precision", getSpinValue(this.spnPrecision).intValue());
	     else {
	       pp.setInt("precision", 0);
	     }
	     pp.setString("byOrgType", String.valueOf(this.rbSaleOrg.isSelected()));
	     if ((this.materialClass != null) && (this.materialClass.getSelectedItem() != null)) {
	       pp.setString("materialClassfiled", this.materialClass.getSelectedItem().toString());
	     }
	 
	     return pp;
	   }
	
	
	
	
	
	   public void setCustomCondition(RptParams params)
	   {
	     super.setCustomCondition(params);
	   }
	
	
	
	
	
	
	
	   public void setCustomerParams(CustomerParams cp)
	   {
	     boolean isBySaleOrg = cp.getBoolean("byOrgType");
	 
	     initMultOrg(isBySaleOrg);
	 
	     super.setCustomerParams(cp);
	     setSpinValue(this.spinnerGrade, new Integer(cp.getInt("grade")));
	 
	     if (isBySaleOrg)
	       this.rbSaleOrg.setSelected(true);
	     else
	       this.rbCompanyOrg.setSelected(true);
	   }
	
	   public void onShow()
	     throws Exception
	   {
	     initMultOrg(true);
	     setDefualtMain();
	   }
	
	   private void setDefualtMain()
	   {
	     OrgUnitInfo org = getDefaultMainBizOrg();
	 
	     if ((org == null) || (this.prmtSaleOrgFrom.getValue() != null))
	       return;
	     this.prmtSaleOrgFrom.setValue(new OrgUnitInfo[] { org.castToFullOrgUnitInfo() });
	   }
	
	
	
	
	
	   protected void initMultOrg(boolean isBySaleOrg)
	   {
	     if (isBySaleOrg)
	     {
	       if (this.saleOrgsMultiF7 != null) {
	         return;
	       }
	 
	       this.saleOrgsMultiF7 = new SCMRptMultiOrgsF7(this.prmtSaleOrgFrom, OrgType.Sale, EASResource.getString("com.kingdee.eas.scm.sd.sale.report.SDReportResource", "saleOrgUnitMutilF7"));
	 
	       this.saleOrgsMultiF7.setPermItemName(getViewPermission());
	       this.saleOrgsMultiF7.setUseCache(true);
	       this.saleOrgsMultiF7.setNeedWait4UIOpen(false);
	
	 
	       MultiOrgsFilterElement mainOrgElement = new MultiOrgsFilterElement("fullSaleOrgUnit", this.saleOrgsMultiF7, this.prmtSaleOrgFrom);
	
	
	
	 
	       CompositeFilterElement elements = (CompositeFilterElement)getFilterManager().getElement();
	       elements.add(mainOrgElement);
	
	     }
	     else
	     {
	       if (this.companyOrgsMultiF7 != null) {
	         return;
	       }
	       this.companyOrgsMultiF7 = new SCMRptMultiOrgsF7(this.prmtCompanyOrgFrom, OrgType.Company, EASResource.getString("com.kingdee.eas.scm.sd.sale.report.SDReportResource", "companyOrgUnitMutilF7"));
	 
	       this.companyOrgsMultiF7.setUseCache(true);
	       this.companyOrgsMultiF7.setNeedWait4UIOpen(false);
	
	 
	       MultiOrgsFilterElement companyOrgElement = new MultiOrgsFilterElement("fullCompanyOrgUnit", this.companyOrgsMultiF7, this.prmtCompanyOrgFrom);
	 
	       FullOrgUnitInfo fullOrg = new FullOrgUnitInfo();
	       CompanyOrgUnitInfo companyInfo = SysContext.getSysContext().getCurrentFIUnit();
	       fullOrg.setId(companyInfo.getId());
	       fullOrg.setName(companyInfo.getName());
	       fullOrg.setNumber(companyInfo.getNumber());
	       fullOrg.setIsLeaf(companyInfo.isIsLeaf());
	 
	       this.prmtCompanyOrgFrom.setValue(new Object[] { fullOrg });
	 
	       CompositeFilterElement elements = (CompositeFilterElement)getFilterManager().getElement();
	       elements.add(companyOrgElement);
	     }
	   }
	
	
	
	
	
	
	
	   private void getGroupMaxLevel()
	   {
	     try
	     {
	       ISaleGrossProfits reportFacade = SaleGrossProfitsFactory.getRemoteInstance();
	       int[] levels = reportFacade.getMaxLevels();
	       this.customerGroupMaxLevel = levels[0];
	       this.materialGroupMaxLevel = levels[1];
	     }
	     catch (Exception exp)
	     {
	       handUIException(exp);
	     }
	   }
	
	
	
	
	
	
	
	
	
	
	
	
	   private void setSpinRange(KDSpinner sp, Integer maxVal, Integer minVal)
	     throws Exception
	   {
	     SpinnerModel sm = sp.getModel();
	 
	     SpinnerNumberModel nm = (SpinnerNumberModel)sm;
	     nm.setMaximum(maxVal);
	     nm.setMinimum(minVal);
	     int val = ((Integer)nm.getValue()).intValue();
	     if ((val < minVal.intValue()) || (val > maxVal.intValue()))
	       nm.setValue(new Integer(1));
	   }
	
	
	
	   private void setSpinValue(KDSpinner sp, Integer val)
	   {
	     SpinnerModel sm = sp.getModel();
	 
	     SpinnerNumberModel nm = (SpinnerNumberModel)sm;
	
	
	
	
	
	
	 
	     nm.setValue(val);
	   }
	
	   private Integer getSpinValue(KDSpinner sp)
	   {
	     SpinnerModel sm = sp.getModel();
	 
	     SpinnerNumberModel nm = (SpinnerNumberModel)sm;
	     return ((Integer)nm.getValue());
	   }
	
	
	
	
	   public void loadFields()
	   {
	     super.loadFields();
	   }
	
	
	
	
	   public void storeFields()
	   {
	     super.storeFields();
	   }
	
	
	
	
	
	
	
	
	
	   public static String convertStr(String ids)
	   {
	     StringBuffer idBuf = new StringBuffer();
	 
	     String[] idArray = ids.split(",");
	     for (int i = 0; i < idArray.length; ++i)
	     {
	       if (i == idArray.length - 1)
	       {
	         idBuf.append("'").append(idArray[i]).append("'");
	       }
	       else
	       {
	         idBuf.append("'").append(idArray[i]).append("',");
	       }
	     }
	 
	     return idBuf.toString();
	   }
	
	
	
	
	   protected void rbSaleOrg_itemStateChanged(ItemEvent e)
	     throws Exception
	   {
	     boolean isBySale = this.rbSaleOrg.isSelected();
	 
	     initMultOrg(isBySale);
	 
	     if (isBySale) {
	       setDefualtMain();
	     }
	     orgChanged(isBySale);
	   }
	
	   private void orgChanged(boolean isBySale) {
	     if (isBySale)
	     {
	       this.contSaleOrgFrom.setVisible(true);
	       this.contCompanyFrom.setVisible(false);
	       this.chkContainCost.setVisible(false);
	     }
	     else {
	       this.contSaleOrgFrom.setVisible(false);
	       this.contCompanyFrom.setVisible(true);
	       this.chkContainCost.setVisible(true);
	     }
	   }
	
	   private void addListener()
	   {
	     removeListener();
	 
	     if (this.classificationListener == null)
	     {
	       this.classificationListener = new ItemListener() {
	         public void itemStateChanged(ItemEvent e) {
	           try {
	             SaleGrossProfitsConditionUI.this.combClassification_itemStateChanged(e);
	           } catch (Exception exc) {
	             SaleGrossProfitsConditionUI.this.handUIException(exc);
	           } finally {
	           }
	         }
	       };
	     }
	     this.combClassification.addItemListener(this.classificationListener);
	
	 
	     if (this.combBillStatusListener == null)
	     {
	       this.combBillStatusListener = new ItemListener() {
	         public void itemStateChanged(ItemEvent e) {
	           try {
	             SaleGrossProfitsConditionUI.this.combBillStatus_itemStateChanged(e);
	           } catch (Exception exc) {
	             SaleGrossProfitsConditionUI.this.handUIException(exc);
	           } finally {
	           }
	         }
	       };
	     }
	     this.combBillStatus.addItemListener(this.combBillStatusListener);
	 
	     if (this.rbSaleOrgListener == null)
	     {
	       this.rbSaleOrgListener = new ItemListener() {
	         public void itemStateChanged(ItemEvent e) {
	           try {
	             SaleGrossProfitsConditionUI.this.rbSaleOrg_itemStateChanged(e);
	           } catch (Exception exc) {
	             SaleGrossProfitsConditionUI.this.handUIException(exc);
	           } finally {
	           }
	         }
	       };
	     }
	     this.rbSaleOrg.addItemListener(this.rbSaleOrgListener);
	
	 
	     if (this.combBillFromListener == null)
	     {
	       this.combBillFromListener = new ItemListener() {
	         public void itemStateChanged(ItemEvent e) {
	           try {
	             SaleGrossProfitsConditionUI.this.cbImcome_itemStateChanged(e);
	           } catch (Exception exc) {
	             SaleGrossProfitsConditionUI.this.handUIException(exc);
	           } finally {
	           }
	         }
	       };
	     }
	     this.cbImcome.addItemListener(this.combBillFromListener);
	
	
	
	
	
	 
	     if (this.combBillTypeListener == null)
	     {
	       this.combBillTypeListener = new ItemListener() {
	         public void itemStateChanged(ItemEvent e) {
	           try {
	             SaleGrossProfitsConditionUI.this.combBillType_itemStateChanged(e);
	           } catch (Exception exc) {
	             SaleGrossProfitsConditionUI.this.handUIException(exc);
	           } finally {
	           }
	         }
	       };
	     }
	     this.combBillType.addItemListener(this.combBillTypeListener);
	
	
	 
	     if (this.customerClassfiledListener == null)
	     {
	       this.customerClassfiledListener = new ItemListener() {
	         public void itemStateChanged(ItemEvent e) {
	           try {
	             SaleGrossProfitsConditionUI.this.customerclassfied_itemStateChanged(e);
	           } catch (Exception exc) {
	             SaleGrossProfitsConditionUI.this.handUIException(exc);
	           } finally {
	           }
	         }
	       };
	     }
	     this.customerClassfiled.addItemListener(this.customerClassfiledListener);
	
	 
	     if (this.materialClassfiedListerer == null)
	     {
	       this.materialClassfiedListerer = new ItemListener() {
	         public void itemStateChanged(ItemEvent e) {
	           try {
	             SaleGrossProfitsConditionUI.this.materialclassfied_itemStateChanged(e);
	           } catch (Exception exc) {
	             SaleGrossProfitsConditionUI.this.handUIException(exc);
	           } finally {
	           }
	         }
	       };
	     }
	     this.materialClass.addItemListener(this.materialClassfiedListerer);
	   }
	
	
	   private void removeListener()
	   {
	     if (this.classificationListener != null) {
	       this.combClassification.removeItemListener(this.classificationListener);
	
	
	
	
	     }
	 
	     if (this.combBillTypeListener != null) {
	       this.combBillType.removeItemListener(this.combBillTypeListener);
	     }
	     if (this.combBillStatusListener != null) {
	       this.combBillStatus.removeItemListener(this.combBillStatusListener);
	     }
	     if (this.rbSaleOrgListener != null) {
	       this.rbSaleOrg.removeItemListener(this.rbSaleOrgListener);
	     }
	     if (this.combBillFromListener != null)
	       this.cbImcome.removeItemListener(this.combBillFromListener);
	     if (this.customerClassfiledListener != null)
	       this.customerClassfiled.removeItemListener(this.customerClassfiledListener);
	   }
	
	
	
	
	
	   protected void combClassification_itemStateChanged(ItemEvent e)
	     throws Exception
	   {
	     Object selectedItem = this.combClassification.getSelectedItem();
	     classificationChanged(selectedItem);
	   }
	
	   private void classificationChanged(Object selectedItem) throws Exception
	   {
	     if (selectedItem == null)
	       return;
	     if ((selectedItem.equals(SaleReportClassificationEnum.custGroupPlusMaterial)) || (selectedItem.equals(SaleReportClassificationEnum.materialPlusCustGroup)) || (selectedItem.equals(SaleReportClassificationEnum.customerGroup)))
	
	
	
	     {
	       this.customerClassfiled.setEnabled(true);
	       this.customerclassfield.setText(this.customerClassfiled.getSelectedItem().toString());
	     }
	     else if ((selectedItem.equals(SaleReportClassificationEnum.materGroupPlusCustomer)) || (selectedItem.equals(SaleReportClassificationEnum.customerPlusMaterGroup)) || (selectedItem.equals(SaleReportClassificationEnum.materialGroup)))
	
	
	     {
	       this.customerClassfiled.setEnabled(false);
	       this.customerclassfield.setText("");
	     }
	     else {
	       this.customerClassfiled.setEnabled(false);
	       this.customerclassfield.setText("");
	     }
	 
	     if ((selectedItem.equals(SaleReportClassificationEnum.material)) || (selectedItem.equals(SaleReportClassificationEnum.customerPlusmaterial)) || (selectedItem.equals(SaleReportClassificationEnum.custGroupPlusMaterial)) || (selectedItem.equals(SaleReportClassificationEnum.materialPlusCustomer)) || (selectedItem.equals(SaleReportClassificationEnum.departmentplusmaterial)) || (selectedItem.equals(SaleReportClassificationEnum.customerPlusMaterPerson)) || (selectedItem.equals(SaleReportClassificationEnum.materialPlusCustGroup)))
	
	
	
	
	
	
	
	
	     {
	       this.AuxiliaryProperties.setVisible(true);
	       this.AuxiliaryProperties.setEditable(true);
	     }
	     else
	     {
	       this.AuxiliaryProperties.setVisible(false);
	     }
	     if ((selectedItem.equals(SaleReportClassificationEnum.customer)) || (selectedItem.equals(SaleReportClassificationEnum.material)) || (selectedItem.equals(SaleReportClassificationEnum.materialPlusCustomer)) || (selectedItem.equals(SaleReportClassificationEnum.customerPlusmaterial)) || (selectedItem.equals(SaleReportClassificationEnum.salecontract)) || (selectedItem.equals(SaleReportClassificationEnum.saleorder)))
	
	
	
	
	     {
	       this.contGrade.setVisible(false);
	     }
	     else if ((selectedItem.equals(SaleReportClassificationEnum.customerGroup)) || (selectedItem.equals(SaleReportClassificationEnum.custGroupPlusMaterial)) || (selectedItem.equals(SaleReportClassificationEnum.materialPlusCustGroup)))
	
	
	     {
	       this.contGrade.setVisible(true);
	       setSpinRange(this.spinnerGrade, new Integer(this.customerGroupMaxLevel), new Integer(1));
	     }
	     else if ((selectedItem.equals(SaleReportClassificationEnum.materialGroup)) || (selectedItem.equals(SaleReportClassificationEnum.materGroupPlusCustomer)) || (selectedItem.equals(SaleReportClassificationEnum.customerPlusMaterGroup)))
	
	     {
	       this.contGrade.setVisible(true);
	       setSpinRange(this.spinnerGrade, new Integer(this.materialGroupMaxLevel), new Integer(1));
	     }
	 
	     if ((selectedItem.equals(SaleReportClassificationEnum.customer)) || (selectedItem.equals(SaleReportClassificationEnum.materialGroup)) || (selectedItem.equals(SaleReportClassificationEnum.customerGroup)) || (selectedItem.equals(SaleReportClassificationEnum.customerPlusMaterGroup)) || (selectedItem.equals(SaleReportClassificationEnum.materGroupPlusCustomer)) || (selectedItem.equals(SaleReportClassificationEnum.saleorder)) || (selectedItem.equals(SaleReportClassificationEnum.salecontract)))
	
	
	
	
	
	     {
	       this.lblPrecision.setEnabled(true);
	       this.spnPrecision.setEnabled(true);
	       this.spnPrecision.setValue(new Integer(4));
	       this.KdlablePercision1.setEnabled(true);
	       this.amountPrecision1.setEnabled(true);
	       this.amountPrecision1.setValue(new Integer(4));
	 
	       this.lblPrecision2.setEnabled(false);
	       this.qtyPrecision.setEnabled(false);
	       this.qtyPrecision.setValue(new Integer(4));
	       this.KdlablePercision2.setEnabled(false);
	       this.amountPrecision2.setEnabled(false);
	       this.amountPrecision2.setValue(new Integer(4)); } else {
	       if ((!(selectedItem.equals(SaleReportClassificationEnum.material))) && (!(selectedItem.equals(SaleReportClassificationEnum.customerPlusmaterial))) && (!(selectedItem.equals(SaleReportClassificationEnum.materialPlusCustomer))) && (!(selectedItem.equals(SaleReportClassificationEnum.departmentplusmaterial))) && (!(selectedItem.equals(SaleReportClassificationEnum.customerPlusMaterPerson))) && (!(selectedItem.equals(SaleReportClassificationEnum.materialPlusCustGroup))))
	
	
	       {
	         return;
	       }
	 
	       this.lblPrecision.setEnabled(false);
	       this.spnPrecision.setEnabled(false);
	       this.spnPrecision.setValue(new Integer(4));
	       this.KdlablePercision1.setEnabled(false);
	       this.amountPrecision1.setEnabled(false);
	       this.amountPrecision1.setValue(new Integer(4));
	 
	       this.lblPrecision2.setEnabled(true);
	       this.qtyPrecision.setEnabled(true);
	       this.qtyPrecision.setValue(new Integer(4));
	       this.KdlablePercision2.setEnabled(true);
	       this.amountPrecision2.setEnabled(true);
	       this.amountPrecision2.setValue(new Integer(4));
	     }
	   }
	
	
	
	   protected void combBillStatus_itemStateChanged(ItemEvent e)
	     throws Exception
	   {
	     Object selectedItem = this.combBillStatus.getSelectedItem();
	     statusChanged(selectedItem);
	   }
	
	
	   private void statusChanged(Object selectedItem)
	   {
	     if (selectedItem == null) {
	       return;
	     }
	     if ((selectedItem.equals(SaleReportBillStatusEnum.all)) || (selectedItem.equals(SaleReportBillStatusEnum.audit)) || (selectedItem.equals(SaleReportBillStatusEnum.unAudit)))
	
	
	
	
	
	
	
	     {
	       Object selectedBillTypeItem = this.combBillType.getSelectedItem();
	       if (selectedItem != null) {
	         SaleReportBizTypeEnum billType = (SaleReportBizTypeEnum)selectedBillTypeItem;
	         if (billType.equals(SaleReportBizTypeEnum.sale))
	         {
	           this.cbImcome.setSelectedItem(SaleImcomEnum.FROM_AR);
	           this.cbImcome.setEnabled(false);
	         } else {
	           this.cbImcome.setEnabled(true);
	         }
	       } else {
	         this.cbImcome.setEnabled(true);
	       }
	 
	       this.spinPeriodYear.setEnabled(false);
	       this.spinPeriodYearTo.setEnabled(false);
	       this.spinPeriodMonth.setEnabled(false);
	       this.spinPeriodMonthTo.setEnabled(false);
	
	
	
	
	 
	       this.datePickerStart.setEnabled(true);
	       this.datePickerEnd.setEnabled(true);
	
	     }
	     else
	     {
	       this.cbImcome.setEnabled(false);
	       this.cbImcome.setSelectedItem(SaleImcomEnum.FROM_AR);
	       this.spinPeriodYear.setEnabled(true);
	       this.spinPeriodYearTo.setEnabled(true);
	       this.spinPeriodMonth.setEnabled(true);
	       this.spinPeriodMonthTo.setEnabled(true);
	
	
	 
	       this.datePickerStart.setValue(null);
	       this.datePickerStart.setEnabled(false);
	       this.datePickerEnd.setValue(null);
	       this.datePickerEnd.setEnabled(false);
	     }
	   }
	
	   protected void customerclassfied_itemStateChanged(ItemEvent e) throws Exception
	   {
	     Object selectedItem = this.customerClassfiled.getSelectedItem();
	     if (selectedItem == null)
	       return;
	     this.customerclassfield.setText(selectedItem.toString());
	   }
	
	   protected void materialclassfied_itemStateChanged(ItemEvent e) throws Exception
	   {
	     Object o = e.getItem();
	     MaterialGroupStandardInfo groupInfo = null;
	     if ((o != null) && (o instanceof MaterialGroupStandardInfo)) {
	       groupInfo = (MaterialGroupStandardInfo)o;
	     }
	     if (groupInfo != null)
	     {
	       IMRptUtils.setBizMaterialGroup(this.prmtMaterialGroupFrom, groupInfo.getId().toString());
	       IMRptUtils.setBizMaterialGroup(this.prmtMaterialGroupTo, groupInfo.getId().toString());
	       this.prmtMaterialGroupFrom.setCommitParser(new MainDataParser("$number$", this.prmtMaterialGroupFrom));
	       this.prmtMaterialGroupTo.setCommitParser(new MainDataParser("$number$", this.prmtMaterialGroupTo));
	
	     }
	 
	     this.prmtMaterialGroupFrom.setValue(null);
	     this.prmtMaterialGroupTo.setValue(null);
	   }
	
	   protected void cbImcome_itemStateChanged(ItemEvent e) throws Exception
	   {
	     Object selectedItem = this.cbImcome.getSelectedItem();
	     if (selectedItem == null) {
	       return;
	     }
	     SaleImcomEnum fromBill = (SaleImcomEnum)selectedItem;
	     if (fromBill.equals(SaleImcomEnum.FROM_AR))
	     {
	       this.chkContainInvoice.setVisible(true);
	       this.chkContainBizBill.setVisible(true);
	     }
	     else {
	       this.chkContainInvoice.setVisible(false);
	       this.chkContainBizBill.setVisible(false);
	     }
	   }
	
	
	
	
	
	
	
	   protected void combBillType_itemStateChanged(ItemEvent e)
	     throws Exception
	   {
	     Object selectedItem = this.combBillType.getSelectedItem();
	     if (selectedItem == null) {
	       return;
	     }
	     SaleReportBizTypeEnum billType = (SaleReportBizTypeEnum)selectedItem;
	     if (billType.equals(SaleReportBizTypeEnum.sale))
	     {
	       this.cbImcome.setSelectedItem(SaleImcomEnum.FROM_AR);
	       this.cbImcome.setEnabled(false);
	     } else {
	       this.cbImcome.setEnabled(true);
	
	
	
	
	
	     }
	 
	     Object billStatusItem = this.combBillStatus.getSelectedItem();
	     if (billStatusItem.equals(SaleReportBillStatusEnum.cal)) {
	       this.cbImcome.setSelectedItem(SaleImcomEnum.FROM_AR);
	       this.cbImcome.setEnabled(false);
	     }
	   }
	
	
	
	
	
	
	
	
	
	   public KDBizPromptBox getMainBizOrgF7()
	   {
	     return this.prmtSaleOrgFrom;
	   }
	
	
	
	
	
	
	   protected String getViewPermission()
	   {
	     String viewPermission = "SaleGrossProfits_view";
	     return viewPermission;
	   }
	
	
	
	
	
	
	   protected OrgType getMainBizOrgType()
	   {
	     return OrgType.Sale;
	   }
	
	
	
	
	
	   private void initInterface()
	   {
	     this.contGrade.setVisible(false);
	     this.prmtMaterialGroupFrom.setEditable(true);
	     this.prmtMaterialGroupTo.setEditable(true);
	     this.prmtMaterialFrom.setEditable(true);
	     this.prmtMaterialTo.setEditable(true);
	     this.prmtCustomerGroupFrom.setEditable(true);
	     this.prmtCustomerGroupTo.setEditable(true);
	     this.prmtCustomerFrom.setEditable(true);
	     this.prmtCustomerTo.setEditable(true);
	     this.prmtSaleOrgFrom.setEditable(true);
	
	
	 
	     this.prmtSaleGroupFrom.setEditable(true);
	     this.prmtSaleGroupTo.setEditable(true);
	 
	     this.prmtSalePersonFrom.setEditable(true);
	     this.prmtSalePersonTo.setEditable(true);
	   }
	
	
	
	
	
	   public boolean verify()
	   {
	     if (this.rbSaleOrg.isSelected())
	
	
	     {
	       if ((this.prmtSaleOrgFrom.getValue() == null) || (((Object[])(Object[])this.prmtSaleOrgFrom.getValue()).length == 0))
	       {
	         MsgBox.showInfo(this, EASResource.getString("com.kingdee.eas.scm.sd.sale.report.SDReportResource", "SaleOrgUnitNotNull"));
	 
	         return false; }
	       if (((Object[])(Object[])this.prmtSaleOrgFrom.getValue()).length == 1) {
	         Object[] purchaseOrg = (Object[])(Object[])this.prmtSaleOrgFrom.getValue();
	         if ((purchaseOrg[0] == null) || (purchaseOrg[0].toString() == null))
	         {
	           MsgBox.showInfo(this, EASResource.getString("com.kingdee.eas.scm.sd.sale.report.SDReportResource", "SaleOrgUnitNotNull"));
	 
	           return false;
	         }
	       }
	     }
	     else {
	       if ((this.prmtCompanyOrgFrom.getValue() == null) || (((Object[])(Object[])this.prmtCompanyOrgFrom.getValue()).length == 0))
	       {
	         MsgBox.showInfo(this, EASResource.getString("com.kingdee.eas.scm.sd.sale.report.SDReportResource", "companyOrgUnitNotNull"));
	 
	         return false; }
	       if (((Object[])(Object[])this.prmtCompanyOrgFrom.getValue()).length == 1) {
	         Object[] purchaseOrg = (Object[])(Object[])this.prmtCompanyOrgFrom.getValue();
	         if ((purchaseOrg[0] == null) || (purchaseOrg[0].toString().length() == 0))
	         {
	           MsgBox.showInfo(this, EASResource.getString("com.kingdee.eas.scm.sd.sale.report.SDReportResource", "companyOrgUnitNotNull"));
	 
	           return false;
	         }
	       }
	     }
	 
	     if ((this.datePickerStart.getTimestamp() == null) || (this.datePickerEnd.getTimestamp() == null)) {
	       return true;
	     }
	     if (this.datePickerEnd.getTimestamp().before(this.datePickerStart.getTimestamp()))
	     {
	       MsgBox.showInfo(this, SCMClientUtils.getResource("CompareDate"));
	       return false;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	     }
	 
	     return true;
	   }
	
	
	
	
	
	   public void clear()
	   {
	     super.clear();
	     this.prmtMaterialFrom.setValue(null);
	     this.prmtMaterialTo.setValue(null);
	     this.prmtMaterialGroupFrom.setValue(null);
	     this.prmtMaterialGroupTo.setValue(null);
	     this.prmtCustomerFrom.setValue(null);
	     this.prmtCustomerTo.setValue(null);
	     this.prmtCustomerGroupFrom.setValue(null);
	     this.prmtCustomerGroupTo.setValue(null);
	
	
	
	 
	     this.prmtSaleGroupFrom.setValue(null);
	     this.prmtSaleGroupTo.setValue(null);
	 
	     this.prmtSalePersonFrom.setValue(null);
	     this.prmtSalePersonTo.setValue(null);
	     SCMQueryFormat.formatStartTime(this.datePickerStart);
	     SCMQueryFormat.formatEndTime(this.datePickerEnd);
	 
	     this.ckBxShowMShortName.setSelected(false);
	     this.chkContainCost.setSelected(false);
	     this.bgOrgSelected.setValue(0);
	     this.chkContainCost.setVisible(false);
	 
	     this.spinPeriodYear.setEnabled(false);
	     this.spinPeriodYearTo.setEnabled(false);
	     this.spinPeriodMonth.setEnabled(false);
	     this.spinPeriodMonthTo.setEnabled(false);
	     try
	     {
	       onInitFilter();
	     } catch (Exception e) {
	       handUIException(e);
	     }
	   }
	
	   private void onInitFilter() {
	     try {
	       CompanyOrgUnitInfo company = (CompanyOrgUnitInfo)SysContext.getSysContext().getCurrentOrgUnit(OrgType.Company);
	       if (company != null)
	         loadAccountPeriod(company);
	     }
	     catch (Exception e) {
	       handUIException(e);
	     }
	   }
	
	   private void loadAccountPeriod(CompanyOrgUnitInfo companyInfo) throws EASBizException, BOSException
	   {
	     PeriodInfo curPeriodInfo = null;
	     int minYear = 0;
	     int maxYear = 0;
	     if (companyInfo != null)
	     {
	       if (this.periodMap.containsKey(companyInfo.getId().toString())) {
	         WriteOffPeriodInfo info = (WriteOffPeriodInfo)this.periodMap.get(companyInfo.getId().toString());
	 
	         curPeriodInfo = info.getCurPeriodInfo();
	         minYear = info.getMinYear();
	         maxYear = info.getMaxYear();
	       }
	       else {
	         curPeriodInfo = SystemStatusCtrolUtils.getCurrentPeriod(null, SystemEnum.INVENTORYMANAGEMENT, companyInfo);
	 
	         minYear = PeriodUtils.getMaxOrMinPeriodYear(null, companyInfo.getId().toString(), false);
	         maxYear = PeriodUtils.getMaxOrMinPeriodYear(null, companyInfo.getId().toString(), true);
	
	
	
	
	
	
	
	
	       }
	 
	     }
	 
	     SetSpinnerMaxMin(this.spinPeriodYear, minYear, maxYear);
	     SetSpinnerMaxMin(this.spinPeriodYearTo, minYear, maxYear);
	 
	     if (curPeriodInfo != null) {
	       this.spinPeriodYear.setValue(new Integer(curPeriodInfo.getPeriodYear()));
	       this.spinPeriodYearTo.setValue(new Integer(curPeriodInfo.getPeriodYear()));
	       setPeriod(this.spinPeriodYear, companyInfo);
	       setPeriod(this.spinPeriodYearTo, companyInfo);
	     } else {
	       Calendar ca = Calendar.getInstance();
	       this.spinPeriodYear.setValue(new Integer(ca.get(1)));
	       this.spinPeriodYearTo.setValue(new Integer(ca.get(1)));
	       this.spinPeriodMonth.setValue(new Integer(ca.get(2) + 1));
	       this.spinPeriodMonthTo.setValue(new Integer(ca.get(2) + 1));
	     }
	   }
	
	
	   protected void addCkBxSimpleNameListener()
	   {
	     this.ckBxShowMShortName.setVisible(true);
	     this.txtMShortNameFrom.setVisible(true);
	     this.txtMShortNameTo.setVisible(true);
	 
	     this.ckBxShowMShortName.setSelected(false);
	     this.txtMShortNameFrom.setEnabled(false);
	     this.txtMShortNameTo.setEnabled(false);
	 
	     this.ckBxShowMShortName.addItemListener(new ItemListener()
	     {
	       public void itemStateChanged(ItemEvent e)
	       {
	         try
	         {
	           SaleGrossProfitsConditionUI.this.ckBxShowMShortName_itemStateChanged(e);
	         }
	         catch (Exception exc)
	         {
	           SaleGrossProfitsConditionUI.this.handUIException(exc);
	         }
	         finally
	         {
	         }
	       }
	     });
	   }
	
	   protected void ckBxShowMShortName_itemStateChanged(ItemEvent e)
	     throws Exception
	   {
	     boolean isSelected = this.ckBxShowMShortName.isSelected();
	 
	     this.txtMShortNameFrom.setText(null);
	     this.txtMShortNameTo.setText(null);
	     if (isSelected) {
	       this.txtMShortNameFrom.setEnabled(true);
	       this.txtMShortNameTo.setEnabled(true);
	     } else {
	       this.txtMShortNameFrom.setEnabled(false);
	       this.txtMShortNameTo.setEnabled(false);
	     }
	   }
	   

}