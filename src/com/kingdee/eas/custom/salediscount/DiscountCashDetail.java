package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;

import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.fi.cas.ReceivingBillInfo;

public class DiscountCashDetail implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4156585487565902960L;
	
	
	private int count;  // ���
	private CustomerInfo customerInfo; // �ͻ� 
	private DiscountRecordBillInfo recordBillInfo;  // ���㵥
	private ReceivingBillInfo receivingBillInfo;   // �տ
	private String reveivingCreator;
	

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	public DiscountRecordBillInfo getRecordBillInfo() {
		return recordBillInfo;
	}
	public void setRecordBillInfo(DiscountRecordBillInfo recordBillInfo) {
		this.recordBillInfo = recordBillInfo;
	}
	public ReceivingBillInfo getReceivingBillInfo() {
		return receivingBillInfo;
	}
	public void setReceivingBillInfo(ReceivingBillInfo receivingBillInfo) {
		this.receivingBillInfo = receivingBillInfo;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getReveivingCreator() {
		return reveivingCreator;
	}
	public void setReveivingCreator(String reveivingCreator) {
		this.reveivingCreator = reveivingCreator;
	}
}
