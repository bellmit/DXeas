package com.kingdee.eas.scm.sd.sale.client;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * �ͻ�������� bean
 * @author Administrator
 *
 */
public class CustomerCreditBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6628321020198857796L;
	
	// �ͻ���Ϣ 
	private String customerID;
	private String customerNumber;
	private String customerName;
	// ��˾��Ϣ
	private String companyID;
	private String companyNumber;
	private String companyName;
	
	// ���á�Ӧ�ա�Ӧ�����ѿ�Ʊ���ϼ�
	private BigDecimal creditBalance;
	private BigDecimal arBalance;
	private BigDecimal orderNoArBalance;
	
	/**
	 * // ��Ӧ��  =Ӧ��+�ѿ�ƱδӦ�ս��
	 * @return
	 */
	public BigDecimal getAllArBalance(){
		BigDecimal allArBalance = BigDecimal.ZERO;
		
		if(getArBalance() != null){
    		allArBalance = allArBalance.add(getArBalance());
    	}
		
    	if(getOrderNoArBalance() != null){
    		allArBalance = allArBalance.add(getOrderNoArBalance());
    	}
    	
    	return allArBalance;
	}
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCompanyID() {
		return companyID;
	}
	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	public String getCompanyNumber() {
		return companyNumber;
	}
	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public BigDecimal getCreditBalance() {
		return creditBalance;
	}
	public void setCreditBalance(BigDecimal creditBalance) {
		this.creditBalance = creditBalance;
	}
	public BigDecimal getArBalance() {
		return arBalance;
	}
	public void setArBalance(BigDecimal arBalance) {
		this.arBalance = arBalance;
	}
	public BigDecimal getOrderNoArBalance() {
		return orderNoArBalance;
	}
	public void setOrderNoArBalance(BigDecimal orderNoArBalance) {
		this.orderNoArBalance = orderNoArBalance;
	}
	
	
}
