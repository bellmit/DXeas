package com.kingdee.eas.farm.feedfactory.beans;

import java.io.Serializable;
import java.sql.Time;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 饲料车 单次送料计划明细信息
 * 记录每次送货的 开始时间结束时间 起始结束位置
 * @author USER
 *
 */
public class TruckPlanDetail implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4958407043011416517L;
	
	// 对应要料计划信息
	private FodderPlanDetail fodderPlanDetail;
	// 是否拼车
	private boolean isMerger;
	// 是否是拼车的终点站
	private boolean isMergerEndpoint;
	// 开始装料时间
	private Time beginLoadingTime;
	// 饲料厂出厂时间
	private Time leaveFFTime;
	// 开始转场时间 /*****只有一车两场的情况 该字段不为空*****/
	private Time transBeginTime;
	// 送到时间 
	private Time arriveTime;
	// 预计离开养殖场时间
	private Time leaveFarmTime;
	// 送料完成回到饲料厂时间
	private Time batckToFFTime;
	
	// 要料备注
	private String farmDesc;
	// 装料料口
	private String fodderPort;
	// 物料ID
	private String materialID;
	private String materialName;
	// 派车 信息
	private String truckID;
	private String truckNumber;
	private String truckName;
	// 司机信息
	private String driverName;
	private String driverTel;
	
	// 是否吃午饭
	private boolean haveLunch;
	private String lunchPlace;
	
	// 次序
	private int planSeq;
	// 车次
	private int truckSeq;

	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("fodderPlanDetail",
				fodderPlanDetail).append("isMerger", isMerger).append(
				"isMergerEndpoint", isMergerEndpoint).append(
				"beginLoadingTime", beginLoadingTime).append("leaveFFTime",
				leaveFFTime).append("transBeginTime", transBeginTime).append(
				"arriveTime", arriveTime)
				.append("leaveFarmTime", leaveFarmTime).append("truckID",
						truckID).append("truckNumber", truckNumber).append(
						"truckName", truckName)
				.append("driverName", driverName)
				.append("driverTel", driverTel).toString();
	}
	public FodderPlanDetail getFodderPlanDetail() {
		return fodderPlanDetail;
	}
	public void setFodderPlanDetail(FodderPlanDetail fodderPlanDetail) {
		this.fodderPlanDetail = fodderPlanDetail;
	}
	public boolean isMerger() {
		return isMerger;
	}
	public void setMerger(boolean isMerger) {
		this.isMerger = isMerger;
	}
	public boolean isMergerEndpoint() {
		return isMergerEndpoint;
	}
	public void setMergerEndpoint(boolean isMergerEndpoint) {
		this.isMergerEndpoint = isMergerEndpoint;
	}
	public Time getBeginLoadingTime() {
		return beginLoadingTime;
	}
	public void setBeginLoadingTime(Time beginLoadingTime) {
		this.beginLoadingTime = beginLoadingTime;
	}
	public Time getLeaveFFTime() {
		return leaveFFTime;
	}
	public void setLeaveFFTime(Time leaveFFTime) {
		this.leaveFFTime = leaveFFTime;
	}
	public Time getTransBeginTime() {
		return transBeginTime;
	}
	public void setTransBeginTime(Time transBeginTime) {
		this.transBeginTime = transBeginTime;
	}
	public Time getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(Time arriveTime) {
		this.arriveTime = arriveTime;
	}
	public String getTruckID() {
		return truckID;
	}
	public void setTruckID(String truckID) {
		this.truckID = truckID;
	}
	public String getTruckNumber() {
		return truckNumber;
	}
	public void setTruckNumber(String truckNumber) {
		this.truckNumber = truckNumber;
	}
	public String getTruckName() {
		return truckName;
	}
	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverTel() {
		return driverTel;
	}
	public void setDriverTel(String driverTel) {
		this.driverTel = driverTel;
	}
	public void setLeaveFarmTime(Time leaveFarmTime) {
		this.leaveFarmTime = leaveFarmTime;
	}
	public Time getLeaveFarmTime() {
		return leaveFarmTime;
	}
	public Time getBatckToFFTime() {
		return batckToFFTime;
	}
	public void setBatckToFFTime(Time batckToFFTime) {
		this.batckToFFTime = batckToFFTime;
	}
	public boolean isHaveLunch() {
		return haveLunch;
	}
	public void setHaveLunch(boolean haveLunch) {
		this.haveLunch = haveLunch;
	}
	public String getLunchPlace() {
		return lunchPlace;
	}
	public void setLunchPlace(String lunchPlace) {
		this.lunchPlace = lunchPlace;
	}
	public int getPlanSeq() {
		return planSeq;
	}
	public void setPlanSeq(int planSeq) {
		this.planSeq = planSeq;
	}
	public int getTruckSeq() {
		return truckSeq;
	}
	public void setTruckSeq(int truckSeq) {
		this.truckSeq = truckSeq;
	}
	public void setFarmDesc(String farmDesc) {
		this.farmDesc = farmDesc;
	}
	public String getFarmDesc() {
		return farmDesc;
	}
	public String getFodderPort() {
		return fodderPort;
	}
	public void setFodderPort(String fodderPort) {
		this.fodderPort = fodderPort;
	}
	public String getMaterialID() {
		return materialID;
	}
	public void setMaterialID(String materialID) {
		this.materialID = materialID;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	
	
	
	

}
