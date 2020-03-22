package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.kingdee.eas.basedata.master.cssp.CustomerInfo;

/**
 * ���ö��� ��Ϣ
 * @author Administrator
 *
 */
public class DiscountCashInfo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1137570168066060897L;
	
	
	private CustomerInfo customerInfo;  // �ͻ�
	private DiscountTypeEnum discountTypeEnum; // ��������
	private int billCount;	  // ��������
	private BigDecimal allAmount;   // �ܽ��
	private List<DiscountCashDetail> details;   // ��ϸ�б�
	
	
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	public DiscountTypeEnum getDiscountTypeEnum() {
		return discountTypeEnum;
	}
	public void setDiscountTypeEnum(DiscountTypeEnum discountTypeEnum) {
		this.discountTypeEnum = discountTypeEnum;
	}
	public int getBillCount() {
		return billCount;
	}
	public void setBillCount(int billCount) {
		this.billCount = billCount;
	}
	public BigDecimal getAllAmount() {
		return allAmount;
	}
	public void setAllAmount(BigDecimal allAmount) {
		this.allAmount = allAmount;
	}
	public List<DiscountCashDetail> getDetails() {
		return details;
	}
	public void setDetails(List<DiscountCashDetail> details) {
		this.details = details;
	}
	
	
}
