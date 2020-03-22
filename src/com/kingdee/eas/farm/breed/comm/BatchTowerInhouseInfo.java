package com.kingdee.eas.farm.breed.comm;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 批次入栏  ，料塔对应栏位 与入栏日期 情况
 * @author USER
 *
 */
public class BatchTowerInhouseInfo implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4943361493698106213L;
	// 是否由入栏计划生成
	private boolean isPlan;
	// 当前日期
	private Date currentDate;
	// 料塔进鸡情况列表 
	List<BatchTowerInhouseDetail> towerDetails;
	
	/**
	 * 构造时设置
	 */
	public  BatchTowerInhouseInfo(){
		towerDetails = new LinkedList<BatchTowerInhouseDetail>();
	}

	public boolean isPlan() {
		return isPlan;
	}

	public void setPlan(boolean isPlan) {
		this.isPlan = isPlan;
	}

	public List<BatchTowerInhouseDetail> getTowerDetails() {
		return towerDetails;
	}

	public void setTowerDetails(List<BatchTowerInhouseDetail> towerDetails) {
		this.towerDetails = towerDetails;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
}
