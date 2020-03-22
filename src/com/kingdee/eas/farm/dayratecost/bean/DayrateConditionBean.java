package com.kingdee.eas.farm.dayratecost.bean;

import java.io.Serializable;

/**
 * 成本计算条件Bean
 * @author dai_andong
 *
 */
public class DayrateConditionBean implements Serializable{
	private static final long serialVersionUID = 8299197910084227523L;
	
	private String companyID;
	private String periodID;
	private String stockingBatchID;
	private String hosueID;
	private String farmerID;
	private String farmID;
	private boolean isCalAll=false;
	
	public String getCompanyID() {
		return companyID;
	}
	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	public String getPeriodID() {
		return periodID;
	}
	public void setPeriodID(String periodID) {
		this.periodID = periodID;
	}
	public String getStockingBatchID() {
		return stockingBatchID;
	}
	public void setStockingBatchID(String stockingBatchID) {
		this.stockingBatchID = stockingBatchID;
	}
	public String getHosueID() {
		return hosueID;
	}
	public void setHosueID(String hosueID) {
		this.hosueID = hosueID;
	}
	public String getFarmerID() {
		return farmerID;
	}
	public void setFarmerID(String farmerID) {
		this.farmerID = farmerID;
	}
	public String getFarmID() {
		return farmID;
	}
	public void setFarmID(String farmID) {
		this.farmID = farmID;
	}
	public boolean isCalAll() {
		return isCalAll;
	}
	public void setCalAll(boolean isCalAll) {
		this.isCalAll = isCalAll;
	}
	
}
