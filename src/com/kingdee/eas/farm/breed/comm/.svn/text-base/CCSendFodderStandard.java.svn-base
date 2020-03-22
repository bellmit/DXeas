package com.kingdee.eas.farm.breed.comm;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;

/**
 * 商品鸡饲料送料计划
 * 按日龄存储 明细标准
 * 标准包括 所需饲料品种、饲料数量、折合车次
 * 
 * @author USER
 *
 */
public class CCSendFodderStandard implements Serializable{

	/**
	 * 构造方法
	 */
	public CCSendFodderStandard(){
		standardDetails = new HashMap<Integer, CCSendFodderStandardDetail>();
	}
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8888411035334677964L;
	
	/**
	 * 养殖公司
	 */
	private CompanyOrgUnitInfo  companyInfo;
	/**
	 * 按照养殖入栏计划 送料截止日期，
	 * 超过这个日龄后  不根据计划生成要料计划，而是在养殖日报 自动生成要料计划
	 */
	private int sendByBreedPlanDays;
	/**
	 * 开始送料日龄
	 */
	private int sendBeginDays;
	/**
	 * 开始送料日龄
	 */
	private int sendEndDays;
	/**
	 * 自动生成送料计划截止日期
	 */
	private int  autoSendEndDays;
	/**
	 * 送料标准 库
	 */
	private Map<Integer,CCSendFodderStandardDetail> standardDetails;
	

	public CompanyOrgUnitInfo getCompanyInfo() {
		return companyInfo;
	}
	public void setCompanyInfo(CompanyOrgUnitInfo companyInfo) {
		this.companyInfo = companyInfo;
	}
	public int getSendByBreedPlanDays() {
		return sendByBreedPlanDays;
	}
	public void setSendByBreedPlanDays(int sendByBreedPlanDays) {
		this.sendByBreedPlanDays = sendByBreedPlanDays;
	}
	public Map<Integer, CCSendFodderStandardDetail> getStandardDetails() {
		return standardDetails;
	}
	public int getSendBeginDays() {
		return sendBeginDays;
	}
	public void setSendBeginDays(int sendBeginDays) {
		this.sendBeginDays = sendBeginDays;
	}
	public int getAutoSendEndDays() {
		return autoSendEndDays;
	}
	public void setAutoSendEndDays(int autoSendEndDays) {
		this.autoSendEndDays = autoSendEndDays;
	}
	public void setStandardDetails(
			Map<Integer, CCSendFodderStandardDetail> standardDetails) {
		this.standardDetails = standardDetails;
	}
	public int getSendEndDays() {
		return sendEndDays;
	}
	public void setSendEndDays(int sendEndDays) {
		this.sendEndDays = sendEndDays;
	}
}
