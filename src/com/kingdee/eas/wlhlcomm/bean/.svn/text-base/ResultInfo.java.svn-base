package com.kingdee.eas.wlhlcomm.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 结果类
 * <p>Title: ResultInfo</p>
 * <p>Description: </p>
 * <p>Company: kindee</p> 
 * @author    kevin_gj_wang
 * @date       2011-9-27
 */
public class ResultInfo<T> implements Serializable {
	
	
	/**
	 * 序列化标志号
	 */
	private static final long serialVersionUID = -8288317533840085012L;
	private boolean isSuccess;  // 执行是否成功
	private String message;	   // 消息 
	private T returnObj;   // 返回值
	private Map returnsObjs;
	
	private ArrayList logInfos;
	
	public Map getReturnsObjs() {
		return returnsObjs;
	}
	public void setReturnsObjs(Map returnsObjs) {
		this.returnsObjs = returnsObjs;
	}
	public ResultInfo(){
		this.setSuccess(false);
		this.setMessage(StringUtils.EMPTY);
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getReturnObj() {
		return returnObj;
	}
	public void setReturnObj(T returnObj) {
		this.returnObj = returnObj;
	}
	public void setLogInfos(ArrayList logInfos) {
		this.logInfos = logInfos;
	}
	public ArrayList getLogInfos() {
		return logInfos;
	}
	
	
	
}
