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
	private String taxpayerCode;//�N؛���{�����R�e̖
	private String taxpayerAddress;//�N؛����ַ
	private String taxpayerTel;//�N؛���Ԓ
	private String taxpayerBankName;//�N؛���_���y��
	private String taxpayerBankAccount;//�N؛���y���~̖
	private String customerName;//ُ؛�����Q--�lƱ�E�^
	private String customerCode;//ُ؛���{�����R�e̖
	private String drawer;//�_Ʊ��
	private BigDecimal totalAmount;//�r����Ӌ���~
	private String remark;//�lƱ���]
	private String customerAddress;//ُ؛����ַ
	private String customerTel;//ُ؛���Ԓ
	private String customerBankName;//ُ؛���_���y��
	private String customerBankAccount;//ُ؛���y���~̖
	private String payee;//�տ���
	private String reviewer;//�}҇��
//	private ElcExportItemBean[] items;//����
	private ArrayList<ElcExportItemBean> items;//����

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
