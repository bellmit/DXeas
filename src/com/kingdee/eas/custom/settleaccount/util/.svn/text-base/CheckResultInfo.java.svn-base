package com.kingdee.eas.custom.settleaccount.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 校验结果类
 * <p>Title: ResultInfo</p>
 * <p>Description: </p>
 * <p>Company: kindee</p> 
 * @author    kevin_gj_wang
 * @date       2011-9-27
 */
public class CheckResultInfo implements Serializable {
	
	
	/**
	 * 序列化标志号
	 */
	private static final long serialVersionUID = 3808457154543384208L;
	private boolean isSuccess;  // 执行是否成功
	private String checkItem;  // 校验项目
	private String checkResult; // 校验结果 文字描述
	// 问题列表
	private List<ProblemDetailInfo> returnsObjs;
	
	
	
	public CheckResultInfo() {
		super();
	}
	public CheckResultInfo(String checkItem){
		this.checkItem = checkItem;
		this.checkResult="未开始校验";
		this.setSuccess(false);
		this.returnsObjs = new ArrayList<ProblemDetailInfo>();
		
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	

	public String getCheckItem() {
		return checkItem;
	}
	public void setCheckItem(String checkItem) {
		this.checkItem = checkItem;
	}
	public String getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}
	public List<ProblemDetailInfo> getReturnsObjs() {
		return returnsObjs;
	}
	public void setReturnsObjs(List<ProblemDetailInfo> returnsObjs) {
		this.returnsObjs = returnsObjs;
	}
	
	
	
}
