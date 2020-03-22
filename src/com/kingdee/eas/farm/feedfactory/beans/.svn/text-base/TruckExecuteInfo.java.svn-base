package com.kingdee.eas.farm.feedfactory.beans;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.kingdee.eas.farm.feedfactory.FeedTruckInfo;

/**
 * 饲料车运输调度情况记录
 * 该info记录饲料车 计划的实时运行情况
 * @author USER
 *
 */
public class TruckExecuteInfo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6341818869051977771L;
	
	// 饲料车基本信息
	private String truckID;
	private String truckNumber;
	private String truckName;
	// 饲料车
	private FeedTruckInfo truckInfo;
	
	// 当前位置
	// 当前位置包括  饲料厂、养殖场  均为刚刚到达的时间 即下一项送料计划还未开始的地点和时间；初始状态为 该车即将
	// 打料时间（早晨多车同时打料时要根据排序计算打料开始时间）
	private String currPosition;
	private String currPositionID;
	// 出车时间
	private Time beginTime;
	private Time currTime;
	// 是否已经吃完午饭
	private boolean hasLunched;
	// 午饭地点
	private String lunchPlace;
	// 尚未完成的 送料计划；每次送完一车料要更新该列表，将已完成的 内容删除或更新
	private List<FodderPlanDetail> toBeSolveTask ;
	// 详细派车计划
	private List<TruckPlanDetail> truckPlans;
	
	
	
	
	
	/**
	 * 构造是 map自动创建
	 */
	public TruckExecuteInfo() {
		toBeSolveTask = new CopyOnWriteArrayList<FodderPlanDetail>();
		truckPlans = new ArrayList<TruckPlanDetail>();
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
	public String getCurrPosition() {
		return currPosition;
	}
	public void setCurrPosition(String currPosition) {
		this.currPosition = currPosition;
	}
	public String getCurrPositionID() {
		return currPositionID;
	}
	public void setCurrPositionID(String currPositionID) {
		this.currPositionID = currPositionID;
	}
	public Time getCurrTime() {
		return currTime;
	}
	public void setCurrTime(Time currTime) {
		this.currTime = currTime;
	}
	public List<FodderPlanDetail> getToBeSolveTask() {
		return toBeSolveTask;
	}
	public void setToBeSolveTask(List<FodderPlanDetail> toBeSolveTask) {
		this.toBeSolveTask = toBeSolveTask;
	}
	public List<TruckPlanDetail> getTruckPlans() {
		return truckPlans;
	}
	public void setTruckPlans(List<TruckPlanDetail> truckPlans) {
		this.truckPlans = truckPlans;
	}
	public void setTruckInfo(FeedTruckInfo truckInfo) {
		this.truckInfo = truckInfo;
	}
	public FeedTruckInfo getTruckInfo() {
		return truckInfo;
	}
	public boolean isHasLunched() {
		return hasLunched;
	}
	public void setHasLunched(boolean hasLunched) {
		this.hasLunched = hasLunched;
	}
	public String getLunchPlace() {
		return lunchPlace;
	}
	public void setLunchPlace(String lunchPlace) {
		this.lunchPlace = lunchPlace;
	}
	public Time getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Time beginTime) {
		this.beginTime = beginTime;
	}
	
	

}
