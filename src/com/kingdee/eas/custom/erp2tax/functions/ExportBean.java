package com.kingdee.eas.custom.erp2tax.functions;

import java.io.Serializable;
import java.util.ArrayList;

public class ExportBean implements Serializable {
	private String filePathAndName;//文件路径、名
	private String number;
	private String companyNum;
	private String customerNum;
	private String customerName;
	private String customerTaxNo;
	private String customerBankNo;
	private String customerAddTel;
	private String remark;
	private String checker;
	private String payee;
	private String srcID;
	private String timeStr;
	private boolean isTaxRate;
	
	private ArrayList<ExportEntryBean> ExportEntryCols=new ArrayList<ExportEntryBean>();
	
	public String getTimeStr() {
		return timeStr;
	}
	public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}
	public boolean isTaxRate() {
		return isTaxRate;
	}
	public void setTaxRate(boolean isTaxRate) {
		this.isTaxRate = isTaxRate;
	}
	public String getCompanyNum() {
		return companyNum;
	}
	public void setCompanyNum(String companyNum) {
		this.companyNum = companyNum;
	}
	public String getSrcID() {
		return srcID;
	}
	public void setSrcID(String srcID) {
		this.srcID = srcID;
	}
	public String getCustomerNum() {
		return customerNum;
	}
	public void setCustomerNum(String customerNum) {
		this.customerNum = customerNum;
	}
	public String getFilePathAndName() {
		return filePathAndName;
	}
	public void setFilePathAndName(String filePathAndName) {
		this.filePathAndName = filePathAndName;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerTaxNo() {
		return customerTaxNo;
	}
	public void setCustomerTaxNo(String customerTaxNo) {
		this.customerTaxNo = customerTaxNo;
	}
	public String getCustomerBankNo() {
		return customerBankNo;
	}
	public void setCustomerBankNo(String customerBankNo) {
		this.customerBankNo = customerBankNo;
	}
	public String getCustomerAddTel() {
		return customerAddTel;
	}
	public void setCustomerAddTel(String customerAddTel) {
		this.customerAddTel = customerAddTel;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getChecker() {
		return checker;
	}
	public void setChecker(String checker) {
		this.checker = checker;
	}
	public String getPayee() {
		return payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}
	public ArrayList<ExportEntryBean> getExportEntryCols() {
		return ExportEntryCols;
	}
	public void setExportEntryCols(ArrayList<ExportEntryBean> exportEntryCols) {
		ExportEntryCols = exportEntryCols;
	}
	
}
