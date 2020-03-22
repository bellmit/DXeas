package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

/**
 * 结果类
 * <p>Title: ResultInfo</p>
 * <p>Description: </p>
 * <p>Company: kindee</p> 
 * @author    kevin_gj_wang
 * @date       2012-04-24
 */
public class ResultInfo<t> implements Serializable {
	
	
	/**
	 * 序列化标志号
	 */
	private static final long serialVersionUID = 3752996904460805753L;
	
	
	private boolean isSuccess;  // 执行是否成功
	private String message;	   // 消息 
	private t returnObj;   // 返回值
	private ArrayList discountLogInfos;
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
	public t getReturnObj() {
		return returnObj;
	}
	public void setReturnObj(t returnObj) {
		this.returnObj = returnObj;
	}
	public ArrayList getDiscountLogInfos() {
		return discountLogInfos;
	}
	public void setDiscountLogInfos(ArrayList discountLogInfos) {
		this.discountLogInfos = discountLogInfos;
	}
	
	
}
