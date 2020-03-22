package com.kingdee.eas.custom.erp2tax.functions;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ElcExportInvoiceBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4535672571200381128L;
	private String taxpayerCode;//銷貨方納稅人識別號
	private String taxpayerAddress;//銷貨方地址
	private String taxpayerTel;//銷貨方電話
	private String taxpayerBankName;//銷貨方開戶銀行
	private String taxpayerBankAccount;//銷貨方銀行賬號
	private String customerName;//購貨方名稱--發票擡頭
	private String customerCode;//購貨方納稅人識別號
	private String drawer;//開票人
	private BigDecimal totalAmount;//價稅合計金額
	private String remark;//發票備註
	private String customerAddress;//購貨方地址
	private String customerTel;//購貨方電話
	private String customerBankName;//購貨方開戶銀行
	private String customerBankAccount;//購貨方銀行賬號
	private String payee;//收款人
	private String reviewer;//複覈人
//	private ElcExportItemBean[] items;//明細
	private ArrayList<ElcExportItemBean> items;//明細

	private List<String> srcBillIDsList;
	
	public List<String> getSrcBillIDsList() {
		return srcBillIDsList;
	}
	public void setSrcBillIDsList(List<String> srcBillIDsList) {
		this.srcBillIDsList = srcBillIDsList;
	}
	
	public ArrayList<ElcExportItemBean> getItems() {
		return items;
	}
	public void setItems(ArrayList<ElcExportItemBean> items) {
		this.items = items;
	}
	public String getTaxpayerCode() {
		return taxpayerCode;
	}
	public void setTaxpayerCode(String taxpayerCode) {
		this.taxpayerCode = taxpayerCode;
	}
	public String getTaxpayerAddress() {
		return taxpayerAddress;
	}
	public void setTaxpayerAddress(String taxpayerAddress) {
		this.taxpayerAddress = taxpayerAddress;
	}
	public String getTaxpayerTel() {
		return taxpayerTel;
	}
	public void setTaxpayerTel(String taxpayerTel) {
		this.taxpayerTel = taxpayerTel;
	}
	public String getTaxpayerBankName() {
		return taxpayerBankName;
	}
	public void setTaxpayerBankName(String taxpayerBankName) {
		this.taxpayerBankName = taxpayerBankName;
	}
	public String getTaxpayerBankAccount() {
		return taxpayerBankAccount;
	}
	public void setTaxpayerBankAccount(String taxpayerBankAccount) {
		this.taxpayerBankAccount = taxpayerBankAccount;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getDrawer() {
		return drawer;
	}
	public void setDrawer(String drawer) {
		this.drawer = drawer;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
	public String getCustomerBankName() {
		return customerBankName;
	}
	public void setCustomerBankName(String customerBankName) {
		this.customerBankName = customerBankName;
	}
	public String getCustomerBankAccount() {
		return customerBankAccount;
	}
	public void setCustomerBankAccount(String customerBankAccount) {
		this.customerBankAccount = customerBankAccount;
	}
	public String getPayee() {
		return payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}
	public String getReviewer() {
		return reviewer;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	
}
