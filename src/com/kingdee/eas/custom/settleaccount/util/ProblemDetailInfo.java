package com.kingdee.eas.custom.settleaccount.util;

import java.io.Serializable;

/**
 * ������ϸ��Ϣ
 * @author USER
 *
 */
public class ProblemDetailInfo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2266310839594560116L;
	
	// У����Ŀ
	private String checkItem;
	// ��������
	private String billType;
	// ���ݱ���
	private String billNumber;
	// ��������
	private String billProblem;
	// ��������
	private String otherInfos;
	
	
	public String getCheckItem() {
		return checkItem;
	}
	public void setCheckItem(String checkItem) {
		this.checkItem = checkItem;
	}
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public String getBillProblem() {
		return billProblem;
	}
	public void setBillProblem(String billProblem) {
		this.billProblem = billProblem;
	}
	public String getOtherInfos() {
		return otherInfos;
	}
	public void setOtherInfos(String otherInfos) {
		this.otherInfos = otherInfos;
	}
	
	
}
