package com.kingdee.eas.custom.tocloud.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;



@JSONType(orders = {"ErrorCode","IsSuccess","Errors"})
public class CloudCommonResultResponseStatus {
	
	@JSONField(ordinal=1,name = "ErrorCode")
	private String ErrorCode;
	@JSONField(ordinal=2,name = "IsSuccess")
	private String IsSuccess;
	@JSONField(ordinal=3,name = "Errors")
	private CloudCommonResultResponseStatusError[] Errors;
	@JSONField(name = "ErrorCode")
	public String getErrorCode() {
		return ErrorCode;
	}
	@JSONField(name = "IsSuccess")
	public String getIsSuccess() {
		return IsSuccess;
	}
	@JSONField(name = "Errors")
	public CloudCommonResultResponseStatusError[] getErrors() {
		return Errors;
	}
	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}
	public void setIsSuccess(String isSuccess) {
		IsSuccess = isSuccess;
	}
	public void setErrors(CloudCommonResultResponseStatusError[] errors) {
		Errors = errors;
	}
	

	
}
