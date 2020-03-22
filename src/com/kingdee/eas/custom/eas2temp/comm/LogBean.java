package com.kingdee.eas.custom.eas2temp.comm;

public class LogBean {
	public final static String Direction_Export = "export";
	public final static String Direction_Import = "import";
	String orgUnitID;
	String bosType;
	String easBillID;
	String tempBillID;
	String direction;
	boolean isSuccess;
	String msg;
	
	public String getOrgUnitID() {
		return orgUnitID;
	}
	public void setOrgUnitID(String orgUnitID) {
		this.orgUnitID = orgUnitID;
	}
	public String getBosType() {
		return bosType;
	}
	public void setBosType(String bosType) {
		this.bosType = bosType;
	}
	public String getEasBillID() {
		return easBillID;
	}
	public void setEasBillID(String easBillID) {
		this.easBillID = easBillID;
	}
	public String getTempBillID() {
		return tempBillID;
	}
	public void setTempBillID(String tempBillID) {
		this.tempBillID = tempBillID;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
