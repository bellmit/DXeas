package com.kingdee.eas.custom.salepayment.bean;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kingdee.eas.custom.salepayment.CompanyTargetInfo;
import com.kingdee.eas.custom.salepayment.GrossProfitInfoInfo;
import com.kingdee.eas.custom.salepayment.SalePaymentSetInfo;
import com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultFeeEntryInfo;
import com.kingdee.eas.custom.salepayment.SalerStimulateSetInfo;
import com.kingdee.eas.wlhlcomm.bean.ResultInfo;

/**
 * 损益计算结果
 * @author USER
 *
 */
public class SaleProfitResultInfo extends ResultInfo {
	
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5509265992469104189L;
	
	// 公司损益基本设置
	private SalePaymentSetInfo companySetInfo;
	// 公司指标
	private CompanyTargetInfo companyTargetInfo;
	// 销售员损益指标设置
	private SalerStimulateSetInfo salerSetInfo;
	// 计算日期
	private Date calculateDate;
	// 损益合计
	private BigDecimal allProfit;
	// 销售总毛利
	private BigDecimal allGrossProfit;
	// 销售总不含税金额
	private BigDecimal allNoTaxAmount;
	// 销售总标准成本
	private BigDecimal allStandardCost;
	
	// 总销售回款
	private BigDecimal allRecAmount;
	
	// 公司总销售额
	private BigDecimal companyAllNoTaxAmount;
	
	// 长期应收款考核金额
	private BigDecimal longTimeArAmount;
	
	
	// 包含月份的销售毛利计算结果
	private List<GrossProfitInfoInfo> grossProfits;
	// 费用分录明细
	private List<SaleProfitCalculateResultFeeEntryInfo> feeEntryInfos;

	
	/**
	 * SaleProfitResultInfo
	 */
	public SaleProfitResultInfo(SalerStimulateSetInfo salerSetInfo){
		this.salerSetInfo = salerSetInfo;
		grossProfits = new ArrayList<GrossProfitInfoInfo>();
		feeEntryInfos = new ArrayList<SaleProfitCalculateResultFeeEntryInfo>();
		allProfit = new BigDecimal(0);
		calculateDate = new Date();
		
		allProfit = new BigDecimal(0);
		allNoTaxAmount = new BigDecimal(0);
		allGrossProfit = new BigDecimal(0);
		allNoTaxAmount = new BigDecimal(0);
		allStandardCost = new BigDecimal(0);
	}
	
	/**
	 * 添加月明细毛利润到 列表中，并且 累计损益合计，毛利润合计
	 * 
	 * @param grossProfit 月明细毛利润
	 */
	public void addGrossProfitInfo(GrossProfitInfoInfo grossProfit){
		if(grossProfits == null){
			grossProfits = new ArrayList<GrossProfitInfoInfo>();
			feeEntryInfos = new ArrayList<SaleProfitCalculateResultFeeEntryInfo>();
			allProfit = new BigDecimal(0);
			allNoTaxAmount = new BigDecimal(0);
			allGrossProfit = new BigDecimal(0);
			allNoTaxAmount = new BigDecimal(0);
			allStandardCost = new BigDecimal(0);
		}
		
		// 添加列表值，并累计毛利
		grossProfits.add(grossProfit);
		// 累计金额字段
		allNoTaxAmount  = allNoTaxAmount.add(grossProfit.getAllNoTaxAmount() == null?new BigDecimal(0):grossProfit.getAllNoTaxAmount());
		allStandardCost = allStandardCost.add(grossProfit.getAllStandardCost() == null?new BigDecimal(0):grossProfit.getAllStandardCost());
		allGrossProfit = allGrossProfit.add(grossProfit.getAllGrossProfit() == null?new BigDecimal(0):grossProfit.getAllGrossProfit());
		allProfit = allProfit.add(allGrossProfit);
		
		
	}
	public CompanyTargetInfo getCompanyTargetInfo() {
		return companyTargetInfo;
	}
	public void setCompanyTargetInfo(CompanyTargetInfo companyTargetInfo) {
		this.companyTargetInfo = companyTargetInfo;
	}
	public SalerStimulateSetInfo getSalerSetInfo() {
		return salerSetInfo;
	}
	public void setSalerSetInfo(SalerStimulateSetInfo salerSetInfo) {
		this.salerSetInfo = salerSetInfo;
	}
	public Date getCalculateDate() {
		return calculateDate;
	}
	public void setCalculateDate(Date calculateDate) {
		this.calculateDate = calculateDate;
	}
	public BigDecimal getAllProfit() {
		return allProfit;
	}
	public void setAllProfit(BigDecimal allProfit) {
		this.allProfit = allProfit;
	}
	public List<GrossProfitInfoInfo> getGrossProfits() {
		if(grossProfits == null){
			grossProfits = new ArrayList<GrossProfitInfoInfo>();
		}
		return grossProfits;
	}
	
	
	public void setGrossProfits(List<GrossProfitInfoInfo> grossProfits) {
		this.grossProfits = grossProfits;
	}

	public BigDecimal getAllGrossProfit() {
		return allGrossProfit;
	}

	public BigDecimal getAllNoTaxAmount() {
		return allNoTaxAmount;
	}

	public BigDecimal getAllStandardCost() {
		return allStandardCost;
	}

	public SalePaymentSetInfo getCompanySetInfo() {
		return companySetInfo;
	}

	public void setCompanySetInfo(SalePaymentSetInfo companySetInfo) {
		this.companySetInfo = companySetInfo;
	}

	public BigDecimal getAllRecAmount() {
		return allRecAmount;
	}

	public void setAllRecAmount(BigDecimal allRecAmount) {
		this.allRecAmount = allRecAmount;
	}

	public void setCompanyAllNoTaxAmount(BigDecimal companyAllNoTaxAmount) {
		this.companyAllNoTaxAmount = companyAllNoTaxAmount;
	}

	public BigDecimal getCompanyAllNoTaxAmount() {
		return companyAllNoTaxAmount;
	}

	public void setFeeEntryInfos(List<SaleProfitCalculateResultFeeEntryInfo> feeEntryInfos) {
		this.feeEntryInfos = feeEntryInfos;
	}

	public List<SaleProfitCalculateResultFeeEntryInfo> getFeeEntryInfos() {
		
		if(feeEntryInfos == null){
			feeEntryInfos = new ArrayList<SaleProfitCalculateResultFeeEntryInfo>();
		}
		return feeEntryInfos;
		
	}

	public BigDecimal getLongTimeArAmount() {
		return longTimeArAmount;
	}

	public void setLongTimeArAmount(BigDecimal longTimeArAmount) {
		this.longTimeArAmount = longTimeArAmount;
	}
	
	
}
