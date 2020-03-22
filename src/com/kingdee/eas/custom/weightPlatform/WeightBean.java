package com.kingdee.eas.custom.weightPlatform;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ¹ý°õbean
 * @author dai_andong
 *
 */
public class WeightBean implements Serializable{
	private static final long serialVersionUID = 2384910770359371811L;
	
	private String billID;
	private String billNum;
	private String bizDate;
	private BigDecimal qty;
	private String weightNum;
	private String carNum;
	private Date firstTime;
	private Date secondTime;
	private BigDecimal firstQty;
	private BigDecimal secondQty;
	private BigDecimal suttleQty;
	public String getBizDate() {
		return bizDate;
	}
	public void setBizDate(String bizDate) {
		this.bizDate = bizDate;
	}
	public String getBillID() {
		return billID;
	}
	public void setBillID(String billID) {
		this.billID = billID;
	}
	public String getBillNum() {
		return billNum;
	}
	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public BigDecimal getFirstQty() {
		return firstQty;
	}
	public void setFirstQty(BigDecimal firstQty) {
		this.firstQty = firstQty;
	}
	public BigDecimal getSecondQty() {
		return secondQty;
	}
	public void setSecondQty(BigDecimal secondQty) {
		this.secondQty = secondQty;
	}
	public BigDecimal getSuttleQty() {
		return suttleQty;
	}
	public void setSuttleQty(BigDecimal suttleQty) {
		this.suttleQty = suttleQty;
	}
	public BigDecimal getQty() {
		return qty;
	}
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
	public String getWeightNum() {
		return weightNum;
	}
	public void setWeightNum(String weightNum) {
		this.weightNum = weightNum;
	}
	public Date getFirstTime() {
		return firstTime;
	}
	public void setFirstTime(Date firstTime) {
		this.firstTime = firstTime;
	}
	public Date getSecondTime() {
		return secondTime;
	}
	public void setSecondTime(Date secondTime) {
		this.secondTime = secondTime;
	}
	
}
