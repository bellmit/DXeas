package com.kingdee.eas.farm.pig.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.wlhlcomm.CommonMethod;

/**
 * 商品猪 批次  基本信息
 * @author Administrator
 *
 */
public class CCPigBatchNormalInfo implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4125711020081407125L;

	private String batchID;
	// 批次编码、名称
	private String batchNumber;
	private String batchName;
	// 养殖场
	private String farmID;
	private String farmNumber;
	private String farmName;
	// 对应库存组织ID
	private String stoOrgID;
	// 对应成本对象
	private String costObjectID;
	private String costObjectNumber;
	private String costObjectName;
	// 入栏日期
	private Date incoopDate;
	// 入栏日龄
	private int incoopDays;
	// 当前日期
	private Date nowDate;
	// 总入栏头数
	private int initAllQty;
	// 入栏均重
	private BigDecimal aveWeight;
	// 状态
	private BillBaseStatusEnum baseStatus;
	
	// 明细信息
	private List<CCPigBatchDetailInfo> batchDetails;
	
	/**
	 * 获取当前存栏量
	 * @return
	 */
	public int getCurrHealthQty(){
		// 各个猪舍的存栏量之和
		int count = 0;
		for(int i = 0; batchDetails != null && batchDetails.size()> 0 && i < batchDetails.size(); i++){
			count = count + batchDetails.get(i).getNowQty();
		}
		return count;
	}

	/**
	 * 获得当前日龄
	 * @return
	 * @throws BOSException 
	 */
	public int getCurrDays() throws BOSException{
		if(nowDate == null || incoopDate == null){
			return 0;
		}else{
			return CommonMethod.daysBetween(incoopDate, nowDate) + incoopDays;
		}
		
	}
	/**************************************************************************************/
	public String getBatchID() {
		return batchID;
	}

	public void setBatchID(String batchID) {
		this.batchID = batchID;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getCostObjectID() {
		return costObjectID;
	}

	public void setCostObjectID(String costObjectID) {
		this.costObjectID = costObjectID;
	}

	public String getCostObjectNumber() {
		return costObjectNumber;
	}

	public void setCostObjectNumber(String costObjectNumber) {
		this.costObjectNumber = costObjectNumber;
	}

	public String getCostObjectName() {
		return costObjectName;
	}

	public void setCostObjectName(String costObjectName) {
		this.costObjectName = costObjectName;
	}

	public Date getIncoopDate() {
		return incoopDate;
	}

	public void setIncoopDate(Date incoopDate) {
		this.incoopDate = incoopDate;
	}

	public int getInitAllQty() {
		return initAllQty;
	}

	public void setInitAllQty(int initAllQty) {
		this.initAllQty = initAllQty;
	}

	public BigDecimal getAveWeight() {
		return aveWeight;
	}

	public void setAveWeight(BigDecimal aveWeight) {
		this.aveWeight = aveWeight;
	}

	public BillBaseStatusEnum getBaseStatus() {
		return baseStatus;
	}

	public void setBaseStatus(BillBaseStatusEnum baseStatus) {
		this.baseStatus = baseStatus;
	}

	public List<CCPigBatchDetailInfo> getBatchDetails() {
		return batchDetails;
	}

	public void setBatchDetails(List<CCPigBatchDetailInfo> batchDetails) {
		this.batchDetails = batchDetails;
	}

	public String getFarmID() {
		return farmID;
	}

	public void setFarmID(String farmID) {
		this.farmID = farmID;
	}

	public String getFarmNumber() {
		return farmNumber;
	}

	public void setFarmNumber(String farmNumber) {
		this.farmNumber = farmNumber;
	}

	public String getFarmName() {
		return farmName;
	}

	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}

	public String getStoOrgID() {
		return stoOrgID;
	}

	public void setStoOrgID(String stoOrgID) {
		this.stoOrgID = stoOrgID;
	}

	public Date getNowDate() {
		return nowDate;
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}

	public void setIncoopDays(int incoopDays) {
		this.incoopDays = incoopDays;
	}

	public int getIncoopDays() {
		return incoopDays;
	}
	
	
	
}
