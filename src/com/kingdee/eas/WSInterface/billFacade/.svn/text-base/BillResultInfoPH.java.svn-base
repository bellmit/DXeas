package com.kingdee.eas.WSInterface.billFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BillResultInfoPH implements Serializable {
	private static final long serialVersionUID = -7954147217204613140L;
	private String id;
	private String number;
	private int status;
	private String errorMsgs;

	
	public static BillResultInfoPH getPHResult(BillResultInfo result){
		BillResultInfoPH newResult = new BillResultInfoPH();
		newResult.setId(result.getId());
		newResult.setNumber(result.getNumber());
		newResult.setStatus(result.getStatus());
		StringBuilder phMsg = new StringBuilder("");
		for(int i = 0; result.getErrorMsgs() != null && result.getErrorMsgs().size() > 0 && i < result.getErrorMsgs().size(); i++){
			String msg = (String) result.getErrorMsgs().get(i);
			phMsg.append(msg).append(";");
			
		}
		newResult.setErrorMsgs(phMsg.toString());
		
		return newResult;
	}
	public BillResultInfoPH() {
		status = 0;
		setErrorMsgs("");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setErrorMsgs(String errorMsgs) {
		this.errorMsgs = errorMsgs;
	}

	public String getErrorMsgs() {
		return errorMsgs;
	}


}