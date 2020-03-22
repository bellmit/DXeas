package com.kingdee.eas.farm.breed.comm;

import java.io.Serializable;
import java.util.Date;

public class CCBatchAgeDetailInfo implements Serializable{
	

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3806980501529639053L;
	
	
	private String henhouseID;
	private String henhouseNumber;
	private String henhouseName;
	
	private int incoopQty;
	private Date incoopDate;
	
	private int nowQty;
	private Date nowDate;
	
	private int outQty;
	private Date outDate;
	
	
	public String getHenhouseID() {
		return henhouseID;
	}
	public void setHenhouseID(String henhouseID) {
		this.henhouseID = henhouseID;
	}
	public String getHenhouseNumber() {
		return henhouseNumber;
	}
	public void setHenhouseNumber(String henhouseNumber) {
		this.henhouseNumber = henhouseNumber;
	}
	public String getHenhouseName() {
		return henhouseName;
	}
	public void setHenhouseName(String henhouseName) {
		this.henhouseName = henhouseName;
	}
	public int getIncoopQty() {
		return incoopQty;
	}
	public void setIncoopQty(int incoopQty) {
		this.incoopQty = incoopQty;
	}
	public Date getIncoopDate() {
		return incoopDate;
	}
	public void setIncoopDate(Date incoopDate) {
		this.incoopDate = incoopDate;
	}
	public int getNowQty() {
		return nowQty;
	}
	public void setNowQty(int nowQty) {
		this.nowQty = nowQty;
	}
	public Date getNowDate() {
		return nowDate;
	}
	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}
	public int getOutQty() {
		return outQty;
	}
	public void setOutQty(int outQty) {
		this.outQty = outQty;
	}
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	
}
