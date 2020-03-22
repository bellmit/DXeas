package com.kingdee.eas.WSInterface.common;

import java.io.Serializable;
/**
 * webservices ���ؽ��
 * @author dai
 *
 */
public class WSResultInfo implements Serializable {
	private static final long serialVersionUID = 875332058911992938L;
	public final static int RESULT_SUCCESS=0;//�ɹ�
	public final static int RESULT_FAILURE=1;//ʧ��
	private int resultCode;
	private String resuleMsg;
	public WSResultInfo () {
		
	}
	public WSResultInfo (int code,String msg) {
		this.resultCode=code;
		this.resuleMsg=msg;
	}
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	public String getResuleMsg() {
		return resuleMsg;
	}
	public void setResuleMsg(String resuleMsg) {
		this.resuleMsg = resuleMsg;
	}
	
}
