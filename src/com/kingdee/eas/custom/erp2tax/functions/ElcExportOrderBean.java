package com.kingdee.eas.custom.erp2tax.functions;

import java.io.Serializable;

public class ElcExportOrderBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1261741531948867559L;
//	private String account;//消費者的用戶名
//	private String address;//貨物配送地址
//	private String email;//消費者電子郵件地址
//	private String tel;//消費者
	private String orderNo;//訂單編碼
	/*public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}*/
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
}
