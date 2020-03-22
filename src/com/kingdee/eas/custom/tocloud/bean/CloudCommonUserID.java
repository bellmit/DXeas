package com.kingdee.eas.custom.tocloud.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class CloudCommonUserID {
	private String FUserID;

	@JSONField(name = "FUserID")
	public String getFUserID() {
		return FUserID;
	}

	public void setFUserID(String userID) {
		FUserID = userID;
	}
	
	

}
