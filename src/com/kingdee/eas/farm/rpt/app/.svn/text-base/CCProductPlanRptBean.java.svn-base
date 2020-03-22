package com.kingdee.eas.farm.rpt.app;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 养殖场 生产计划 报表 pojo 
 * @author USER
 *
 */
public class CCProductPlanRptBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4952814073850831968L;
	// 是否是计划数据
	private boolean isPlan;
	// 计划ID
	private String planID;
	// 养殖场
	private String stoOrgID;
	private String stoOrgNumber;
	private String stoOrgName;
	
	// 鸡舍
	private String henhouseID;
	private String henhouseNumber;
	private String henhouseName;
	private BigDecimal henhouseArea;
	
	// 料塔
	private String towerID;
	private String towerNumber;
	private String towerName;
	
	// 当前养殖批次
	private String batchID;
	private String batchNumber;
	private String batchName;   // 批次名称（成本对象名称）
	// 批次 入栏开始日期
	private Date batchFirstIncoopDate;
	
	
	// 成本对象ID
	private String costObjectID;
	// 进鸡时间
	private Date inhouseDate;
	// 当前日龄
	private int currDateNum;
	// 当天存栏量
	private int currDateBreekingStock;
	// 入栏数量
	private int inhouseQty;
	
	// 转栏总量
	private int allAdjustQty;
	// 实际入栏量
	private int actualAllInhouseQty;
	
	
	// 预计出栏时间
	private Date predictOuthouseDate;
	// 预计出栏数量
	private int predictOuthouseQty;
	
	// 实际出栏时间
	private Date actualOuthouseDate;
	// 实际出栏数量
	private int actualOuthouseQty;
	
	// 当前记录所在日期 计算预计耗料量时 的计划日期
	private Date currentDate;
	
	// 0号料
	private String ZeroMaterialID;
	private String ZeroMaterialNumber;
	private String ZeroMaterialName;
	private int ZeroMaterialPredictDays;
	private int ZeroMaterialActualDays;
	// 理论耗料量
	private BigDecimal ZeroMaterialPredictQty;
	private BigDecimal ZeroMaterialActualQty;
	// 一号料
	private String OneMaterialID;
	private String OneMaterialNumber;
	private String OneMaterialName;
	private int OneMaterialPredictDays;
	private int OneMaterialActualDays;
	// 理论耗料量
	private BigDecimal OneMaterialPredictQty;
	private BigDecimal OneMaterialActualQty;
	
	// 二号料
	private String TwoMaterialID;
	private String TwoMaterialNumber;
	private String TwoMaterialName;
	private int TwoMaterialPredictDays;
	private int TwoMaterialActualDays;
	private BigDecimal TwoMaterialPredictQty;
	private BigDecimal TwoMaterialActualQty;
	
	// 三号料
	private String ThreeMaterialID;
	private String ThreeMaterialNumber;
	private String ThreeMaterialName;
	private int ThreeMaterialPredictDays;
	private int ThreeMaterialActualDays;
	private BigDecimal ThreeMaterialPredictQty;
	private BigDecimal ThreeMaterialActualQty;
	
	// 包含的批次分录ID
	private List<String> batchEntryIDs; 
	
	// 说明
	private String desc;
	
	/**
	 * 复制当前对象
	 * @return
	 */
	public CCProductPlanRptBean clone(){
		
		CCProductPlanRptBean newRptBean = new CCProductPlanRptBean();
		newRptBean.setPlan(this.isPlan());
		newRptBean.setPlanID(this.getPlanID());
		
		newRptBean.setStoOrgID(this.getStoOrgID());
		newRptBean.setStoOrgName(this.getStoOrgName());
		newRptBean.setStoOrgNumber(this.getStoOrgNumber());
		
		newRptBean.setBatchID(batchID);
		newRptBean.setBatchEntryIDs(this.getBatchEntryIDs());
		newRptBean.setBatchName(this.getBatchName());
		newRptBean.setBatchNumber(this.getBatchNumber());
		newRptBean.setCostObjectID(this.getCostObjectID());
		newRptBean.setBatchFirstIncoopDate(this.getBatchFirstIncoopDate());
		
		newRptBean.setHenhouseID(this.getHenhouseID());
		newRptBean.setHenhouseNumber(this.getHenhouseNumber());
		newRptBean.setHenhouseName(this.getHenhouseName());
		newRptBean.setHenhouseArea(this.getHenhouseArea());
		
		
		newRptBean.setInhouseDate(this.getInhouseDate());
		newRptBean.setInhouseQty(this.getInhouseQty());
		newRptBean.setAllAdjustQty(this.getAllAdjustQty());
		newRptBean.setActualAllInhouseQty(this.getActualAllInhouseQty());
		
		newRptBean.setCurrDateBreekingStock(this.getCurrDateBreekingStock());
		newRptBean.setCurrDateNum(this.getCurrDateNum());
		
		newRptBean.setPredictOuthouseDate(this.getPredictOuthouseDate());
		newRptBean.setPredictOuthouseQty(this.getPredictOuthouseQty());
		
		newRptBean.setActualOuthouseDate(this.getActualOuthouseDate());
		newRptBean.setActualOuthouseQty(this.getActualOuthouseQty());
		
		newRptBean.setCurrentDate(this.getCurrentDate());
		
		
								
		newRptBean.setTowerID(this.getTowerID());
		newRptBean.setTowerNumber(this.getTowerNumber());
		newRptBean.setTowerName(this.getTowerName());
		
		newRptBean.setZeroMaterialActualDays(this.getZeroMaterialActualDays());
		newRptBean.setZeroMaterialActualQty(this.getZeroMaterialActualQty());
		newRptBean.setZeroMaterialID(this.getZeroMaterialID());
		newRptBean.setZeroMaterialName(this.getZeroMaterialName());
		newRptBean.setZeroMaterialNumber(this.getZeroMaterialNumber());
		newRptBean.setZeroMaterialPredictDays(this.getZeroMaterialPredictDays());
		newRptBean.setZeroMaterialPredictQty(this.getZeroMaterialPredictQty());
		
		newRptBean.setOneMaterialActualDays(this.getOneMaterialActualDays());
		newRptBean.setOneMaterialActualQty(this.getOneMaterialActualQty());
		newRptBean.setOneMaterialID(this.getOneMaterialID());
		newRptBean.setOneMaterialName(this.getOneMaterialName());
		newRptBean.setOneMaterialNumber(this.getOneMaterialNumber());
		newRptBean.setOneMaterialPredictDays(this.getOneMaterialPredictDays());
		newRptBean.setOneMaterialPredictQty(this.getOneMaterialPredictQty());
		
		newRptBean.setTwoMaterialActualDays(this.getTwoMaterialActualDays());
		newRptBean.setTwoMaterialActualQty(this.getTwoMaterialActualQty());
		newRptBean.setTwoMaterialID(this.getTwoMaterialID());
		newRptBean.setTwoMaterialName(this.getTwoMaterialName());
		newRptBean.setTwoMaterialNumber(this.getTwoMaterialNumber());
		newRptBean.setTwoMaterialPredictDays(this.getTwoMaterialPredictDays());
		newRptBean.setTwoMaterialPredictQty(this.getTwoMaterialPredictQty());
		
		newRptBean.setThreeMaterialActualDays(this.getThreeMaterialActualDays());
		newRptBean.setThreeMaterialActualQty(this.getThreeMaterialActualQty());
		newRptBean.setThreeMaterialID(this.getThreeMaterialID());
		newRptBean.setThreeMaterialName(this.getThreeMaterialName());
		newRptBean.setThreeMaterialNumber(this.getThreeMaterialNumber());
		newRptBean.setThreeMaterialPredictDays(this.getThreeMaterialPredictDays());
		newRptBean.setThreeMaterialPredictQty(this.getThreeMaterialPredictQty());
		
		newRptBean.setBatchEntryIDs(this.getBatchEntryIDs());
		
		newRptBean.setDesc(this.getDesc());
		
		return newRptBean;
	}
	
	public String getStoOrgID() {
		return stoOrgID == null ?"":stoOrgID;
	}
	public void setStoOrgID(String stoOrgID) {
		this.stoOrgID = stoOrgID;
	}
	public String getStoOrgNumber() {
		return stoOrgNumber == null ?"":stoOrgNumber;
	}
	public void setStoOrgNumber(String stoOrgNumber) {
		this.stoOrgNumber = stoOrgNumber;
	}
	public String getStoOrgName() {
		return stoOrgName == null ?"":stoOrgName;
	}
	public void setStoOrgName(String stoOrgName) {
		this.stoOrgName = stoOrgName;
	}
	public String getBatchID() {
		return batchID == null ?"":batchID;
	}
	public void setBatchID(String batchID) {
		this.batchID = batchID;
	}
	public String getBatchNumber() {
		return batchNumber == null ?"":batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	public String getBatchName() {
		return batchName == null ?"":batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public Date getInhouseDate() {
		return inhouseDate;
	}
	public void setInhouseDate(Date inhouseDate) {
		this.inhouseDate = inhouseDate;
	}
	
	public int getInhouseQty() {
		return inhouseQty;
	}
	public void setInhouseQty(int inhouseQty) {
		this.inhouseQty = inhouseQty;
	}
	public Date getPredictOuthouseDate() {
		return predictOuthouseDate;
	}
	public void setPredictOuthouseDate(Date predictOuthouseDate) {
		this.predictOuthouseDate = predictOuthouseDate;
	}
	public int getPredictOuthouseQty() {
		return predictOuthouseQty;
	}
	public void setPredictOuthouseQty(int predictOuthouseQty) {
		this.predictOuthouseQty = predictOuthouseQty;
	}
	public String getOneMaterialID() {
		return OneMaterialID == null ?"":OneMaterialID;
	}
	public void setOneMaterialID(String oneMaterialID) {
		OneMaterialID = oneMaterialID;
	}
	public String getOneMaterialNumber() {
		return OneMaterialNumber == null ?"":OneMaterialNumber;
	}
	public void setOneMaterialNumber(String oneMaterialNumber) {
		OneMaterialNumber = oneMaterialNumber;
	}
	public String getOneMaterialName() {
		return OneMaterialName == null ?"":OneMaterialName;
	}
	public void setOneMaterialName(String oneMaterialName) {
		OneMaterialName = oneMaterialName;
	}
	public BigDecimal getOneMaterialPredictQty() {
		return OneMaterialPredictQty==null?new BigDecimal("0.0"):OneMaterialPredictQty;
	}
	public void setOneMaterialPredictQty(BigDecimal oneMaterialPredictQty) {
		OneMaterialPredictQty = oneMaterialPredictQty;
	}
	public BigDecimal getOneMaterialActualQty() {
		return OneMaterialActualQty==null?new BigDecimal("0.0"):OneMaterialActualQty;
	}
	public void setOneMaterialActualQty(BigDecimal oneMaterialActualQty) {
		OneMaterialActualQty = oneMaterialActualQty;
	}
	public String getTwoMaterialID() {
		return TwoMaterialID == null ?"":TwoMaterialID;
	}
	public void setTwoMaterialID(String twoMaterialID) {
		TwoMaterialID = twoMaterialID;
	}
	public String getTwoMaterialNumber() {
		return TwoMaterialNumber == null ?"":TwoMaterialNumber;
	}
	public void setTwoMaterialNumber(String twoMaterialNumber) {
		TwoMaterialNumber = twoMaterialNumber;
	}
	public String getTwoMaterialName() {
		return TwoMaterialName == null ?"":TwoMaterialName;
	}
	public void setTwoMaterialName(String twoMaterialName) {
		TwoMaterialName = twoMaterialName;
	}
	public BigDecimal getTwoMaterialPredictQty() {
		return TwoMaterialPredictQty==null?new BigDecimal("0.0"):TwoMaterialPredictQty;
	}
	public void setTwoMaterialPredictQty(BigDecimal twoMaterialPredictQty) {
		TwoMaterialPredictQty = twoMaterialPredictQty;
	}
	public BigDecimal getTwoMaterialActualQty() {
		return TwoMaterialActualQty==null?new BigDecimal("0.0"):TwoMaterialActualQty;
	}
	public void setTwoMaterialActualQty(BigDecimal twoMaterialActualQty) {
		TwoMaterialActualQty = twoMaterialActualQty;
	}
	public String getThreeMaterialID() {
		return ThreeMaterialID == null ?"":ThreeMaterialID;
	}
	public void setThreeMaterialID(String threeMaterialID) {
		ThreeMaterialID = threeMaterialID;
	}
	public String getThreeMaterialNumber() {
		return ThreeMaterialNumber == null ?"":ThreeMaterialNumber;
	}
	public void setThreeMaterialNumber(String threeMaterialNumber) {
		ThreeMaterialNumber = threeMaterialNumber;
	}
	public String getThreeMaterialName() {
		return ThreeMaterialName == null ?"":ThreeMaterialName;
	}
	public void setThreeMaterialName(String threeMaterialName) {
		ThreeMaterialName = threeMaterialName;
	}
	public BigDecimal getThreeMaterialPredictQty() {
		return ThreeMaterialPredictQty==null?new BigDecimal("0.0"):ThreeMaterialPredictQty;
	}
	public void setThreeMaterialPredictQty(BigDecimal threeMaterialPredictQty) {
		ThreeMaterialPredictQty = threeMaterialPredictQty;
	}
	public BigDecimal getThreeMaterialActualQty() {
		return ThreeMaterialActualQty==null?new BigDecimal("0.0"):ThreeMaterialActualQty;
	}
	public void setThreeMaterialActualQty(BigDecimal threeMaterialActualQty) {
		ThreeMaterialActualQty = threeMaterialActualQty;
	}
	public void setCurrDateNum(int currDateNum) {
		this.currDateNum = currDateNum;
	}
	public int getCurrDateNum() {
//		if(inhouseDate != null){
//			Date currDate = new Date();
//			long timeLong = currDate.getTime()-inhouseDate.getTime();
//			long days = timeLong / (1000 * 60 * 60 * 24);
//			int outDays = (new Long(days)).intValue();
//			if(outDays < currDateNum){
//				return outDays;
//			}
//		}
		return currDateNum;
	}
	public String getDesc() {
		return desc==null?"":desc.toString();
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCostObjectID() {
		return costObjectID == null ?"":costObjectID;
	}
	public void setCostObjectID(String costObjectID) {
		this.costObjectID = costObjectID;
	}
	public void setBatchEntryIDs(List<String> batchEntryIDs) {
		this.batchEntryIDs = batchEntryIDs;
	}
	public List<String> getBatchEntryIDs() {
		return batchEntryIDs;
	}
	public int getOneMaterialPredictDays() {
		return OneMaterialPredictDays;
	}
	public void setOneMaterialPredictDays(int oneMaterialPredictDays) {
		OneMaterialPredictDays = oneMaterialPredictDays;
	}
	public int getOneMaterialActualDays() {
		return OneMaterialActualDays;
	}
	public void setOneMaterialActualDays(int oneMaterialActualDays) {
		OneMaterialActualDays = oneMaterialActualDays;
	}
	public int getTwoMaterialPredictDays() {
		return TwoMaterialPredictDays;
	}
	public void setTwoMaterialPredictDays(int twoMaterialPredictDays) {
		TwoMaterialPredictDays = twoMaterialPredictDays;
	}
	public int getTwoMaterialActualDays() {
		return TwoMaterialActualDays;
	}
	public void setTwoMaterialActualDays(int twoMaterialActualDays) {
		TwoMaterialActualDays = twoMaterialActualDays;
	}
	public int getThreeMaterialPredictDays() {
		return ThreeMaterialPredictDays;
	}
	public void setThreeMaterialPredictDays(int threeMaterialPredictDays) {
		ThreeMaterialPredictDays = threeMaterialPredictDays;
	}
	public int getThreeMaterialActualDays() {
		return ThreeMaterialActualDays;
	}
	public void setThreeMaterialActualDays(int threeMaterialActualDays) {
		ThreeMaterialActualDays = threeMaterialActualDays;
	}
	public Date getActualOuthouseDate() {
		return actualOuthouseDate;
	}
	public void setActualOuthouseDate(Date actualOuthouseDate) {
		this.actualOuthouseDate = actualOuthouseDate;
	}
	public int getActualOuthouseQty() {
		return actualOuthouseQty;
	}
	public void setActualOuthouseQty(int actualOuthouseQty) {
		this.actualOuthouseQty = actualOuthouseQty;
	}
	public boolean isPlan() {
		return isPlan;
	}
	public void setPlan(boolean isPlan) {
		this.isPlan = isPlan;
	}
	public Date getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	public String getPlanID() {
		return planID;
	}
	public void setPlanID(String planID) {
		this.planID = planID;
	}
	public String getHenhouseID() {
		return henhouseID;
	}
	public void setHenhouseID(String henhouseID) {
		this.henhouseID = henhouseID;
	}
	public String getHenhouseNumber() {
		return henhouseNumber;
	}
	public void setHenhouseNumber(String henhouseNumber) {
		this.henhouseNumber = henhouseNumber;
	}
	public String getHenhouseName() {
		return henhouseName;
	}
	public void setHenhouseName(String henhouseName) {
		this.henhouseName = henhouseName;
	}
	public String getTowerID() {
		return towerID;
	}
	public void setTowerID(String towerID) {
		this.towerID = towerID;
	}
	public String getTowerNumber() {
		return towerNumber;
	}
	public void setTowerNumber(String towerNumber) {
		this.towerNumber = towerNumber;
	}
	public String getTowerName() {
		return towerName;
	}
	public void setTowerName(String towerName) {
		this.towerName = towerName;
	}
	public int getCurrDateBreekingStock() {
		return currDateBreekingStock;
	}
	public void setCurrDateBreekingStock(int currDateBreekingStock) {
		this.currDateBreekingStock = currDateBreekingStock;
	}
	public Date getBatchFirstIncoopDate() {
		return batchFirstIncoopDate;
	}
	public void setBatchFirstIncoopDate(Date batchFirstIncoopDate) {
		this.batchFirstIncoopDate = batchFirstIncoopDate;
	}

	public BigDecimal getHenhouseArea() {
		return (henhouseArea == null? new BigDecimal("0"): henhouseArea);
	}

	public void setHenhouseArea(BigDecimal henhouseArea) {
		this.henhouseArea = henhouseArea;
	}

	public int getAllAdjustQty() {
		return allAdjustQty;
	}

	public void setAllAdjustQty(int allAdjustQty) {
		this.allAdjustQty = allAdjustQty;
	}

	public int getActualAllInhouseQty() {
		// 如果总数为0  则根据入栏和转栏总量计算
		if(actualAllInhouseQty == 0){
			actualAllInhouseQty = this.getInhouseQty()+this.getAllAdjustQty();
		}
		
		return actualAllInhouseQty;
	}

	public void setActualAllInhouseQty(int actualAllInhouseQty) {
		this.actualAllInhouseQty = actualAllInhouseQty;
	}

	public String getZeroMaterialID() {
//		return ZeroMaterialID;
		return ZeroMaterialID == null ?"":ZeroMaterialID;
	}

	public void setZeroMaterialID(String zeroMaterialID) {
		ZeroMaterialID = zeroMaterialID;
	}

	public String getZeroMaterialNumber() {
//		return ZeroMaterialNumber;
		return ZeroMaterialNumber == null ?"":ZeroMaterialNumber;
	}

	public void setZeroMaterialNumber(String zeroMaterialNumber) {
		ZeroMaterialNumber = zeroMaterialNumber;
	}

	public String getZeroMaterialName() {
//		return ZeroMaterialName;
		return ZeroMaterialName == null ?"":ZeroMaterialName;
	}

	public void setZeroMaterialName(String zeroMaterialName) {
		ZeroMaterialName = zeroMaterialName;
	}

	public int getZeroMaterialPredictDays() {
		return ZeroMaterialPredictDays;
	}

	public void setZeroMaterialPredictDays(int zeroMaterialPredictDays) {
		ZeroMaterialPredictDays = zeroMaterialPredictDays;
	}

	public int getZeroMaterialActualDays() {
		return ZeroMaterialActualDays;
	}

	public void setZeroMaterialActualDays(int zeroMaterialActualDays) {
		ZeroMaterialActualDays = zeroMaterialActualDays;
	}

	public BigDecimal getZeroMaterialPredictQty() {
//		return ZeroMaterialPredictQty;
		return ZeroMaterialPredictQty==null?new BigDecimal("0.0"):ZeroMaterialPredictQty;
	}

	public void setZeroMaterialPredictQty(BigDecimal zeroMaterialPredictQty) {
		ZeroMaterialPredictQty = zeroMaterialPredictQty;
	}

	public BigDecimal getZeroMaterialActualQty() {
//		return ZeroMaterialActualQty;
		return ZeroMaterialActualQty==null?new BigDecimal("0.0"):ZeroMaterialActualQty;
	}

	public void setZeroMaterialActualQty(BigDecimal zeroMaterialActualQty) {
		ZeroMaterialActualQty = zeroMaterialActualQty;
	}

}
