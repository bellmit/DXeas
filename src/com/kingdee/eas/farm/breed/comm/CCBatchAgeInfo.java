package com.kingdee.eas.farm.breed.comm;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class CCBatchAgeInfo implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3916140712589741430L;
	
	private String stoOrgID;
	private String stoOrgNumber;
	private String stoOrgName;
	
	private String batchID;
	private String batchNumber;
	private String batchName;
	
	
	List<CCBatchAgeDetailInfo> details;
	
	public String getStoOrgID() {
		return stoOrgID;
	}
	
	public void setStoOrgID(String stoOrgID) {
		this.stoOrgID = stoOrgID;
	}

	public String getStoOrgNumber() {
		return stoOrgNumber;
	}

	public void setStoOrgNumber(String stoOrgNumber) {
		this.stoOrgNumber = stoOrgNumber;
	}

	public String getStoOrgName() {
		return stoOrgName;
	}

	public void setStoOrgName(String stoOrgName) {
		this.stoOrgName = stoOrgName;
	}

	public String getBatchID() {
		return batchID;
	}

	public void setBatchID(String batchID) {
		this.batchID = batchID;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public List<CCBatchAgeDetailInfo> getDetails() {
		return details;
	}

	public void setDetails(List<CCBatchAgeDetailInfo> details) {
		this.details = details;
	}
	
	
}
