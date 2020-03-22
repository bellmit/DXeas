package com.kingdee.eas.farm.dayratecost.bean;

import java.math.BigDecimal;

/**
 * 日成本期初bean
 * @author dai_andong
 *
 */
public class DayrateInitBean {
	private String batchID;
	private String houseID;
	private String costItemID;
	private BigDecimal beginCost;
	private BigDecimal beginQty;
	private String periodNum;
	private String periodID;
	public String getBatchID() {
		return batchID;
	}
	public void setBatchID(String batchID) {
		this.batchID = batchID;
	}
	public String getHouseID() {
		return houseID;
	}
	public void setHouseID(String houseID) {
		this.houseID = houseID;
	}
	public String getCostItemID() {
		return costItemID;
	}
	public void setCostItemID(String costItemID) {
		this.costItemID = costItemID;
	}
	public String getPeriodNum() {
		return periodNum;
	}
	public void setPeriodNum(String periodNum) {
		this.periodNum = periodNum;
	}
	public String getPeriodID() {
		return periodID;
	}
	public void setPeriodID(String periodID) {
		this.periodID = periodID;
	}
	public BigDecimal getBeginCost() {
		return beginCost;
	}
	public void setBeginCost(BigDecimal beginCost) {
		this.beginCost = beginCost;
	}
	public BigDecimal getBeginQty() {
		return beginQty;
	}
	public void setBeginQty(BigDecimal beginQty) {
		this.beginQty = beginQty;
	}
	
}
