package com.kingdee.eas.weighbridge.webServices;

import java.io.Serializable;

public class ReturnResultBean implements Serializable {
	private static final long serialVersionUID = 5466115552328379319L;
	private Boolean IsSucess;
	private String MsgCode;
	private String Message;
	public Boolean getIsSucess() {
		return IsSucess;
	}
	public void setIsSucess(Boolean isSucess) {
		IsSucess = isSucess;
	}
	public String getMsgCode() {
		return MsgCode;
	}
	public void setMsgCode(String msgCode) {
		MsgCode = msgCode;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}

}
