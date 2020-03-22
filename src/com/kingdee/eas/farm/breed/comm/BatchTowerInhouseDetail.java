package com.kingdee.eas.farm.breed.comm;

import java.io.Serializable;
import java.util.Date;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.wlhlcomm.DateCommon;

/**
 * 批次入栏  ，料塔对应栏位 与入栏日期 情况
 * @author USER
 *
 */
public class BatchTowerInhouseDetail implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3851113620114553616L;
	// 料塔对应入栏日期 （按照料塔对应的 日龄较小的一个塔入栏日期计算）
	private Date minInhouseDate;
	// 料塔 
	private WarehouseInfo tower;
	// 进鸡舍数 
	private int inhouseCount;
	// 获取料塔最早入栏日期 到当前日期的 日龄
	public int getCurrentDays(Date currentDate) throws BOSException{
		return DateCommon.dateDiff(minInhouseDate, currentDate);
	}
	
	
	public Date getMinInhouseDate() {
		return minInhouseDate;
	}
	public void setMinInhouseDate(Date minInhouseDate) {
		this.minInhouseDate = minInhouseDate;
	}
	public WarehouseInfo getTower() {
		return tower;
	}
	public void setTower(WarehouseInfo tower) {
		this.tower = tower;
	}
	public int getInhouseCount() {
		return inhouseCount;
	}
	public void setInhouseCount(int inhouseCount) {
		this.inhouseCount = inhouseCount;
	}
	
	
	
	
}
