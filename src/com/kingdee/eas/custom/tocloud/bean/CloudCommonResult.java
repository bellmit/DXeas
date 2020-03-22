package com.kingdee.eas.custom.tocloud.bean;

public class CloudCommonResult {
	
	private String Id;
	private String Number;
	private CloudCommonResultResponseStatus ResponseStatus;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}
	public CloudCommonResultResponseStatus getResponseStatus() {
		return ResponseStatus;
	}
	public void setResponseStatus(CloudCommonResultResponseStatus ResponseStatus) {
		this.ResponseStatus = ResponseStatus;
	}
	
}
