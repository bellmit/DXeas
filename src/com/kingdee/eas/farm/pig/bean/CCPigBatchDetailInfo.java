package com.kingdee.eas.farm.pig.bean;

import java.io.Serializable;
import java.util.Date;

import com.kingdee.eas.farm.pig.PigHouseInfo;

/**
 * 商品猪批次  及时状态明细信息 
 * @author Administrator
 *
 */
public class CCPigBatchDetailInfo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2667059839348254949L;
	
	// 对应批次ID
	private String batchID;
	// 入栏日期
	private Date incoopDate;
	// 猪舍
	private PigHouseInfo pigHouse;
	// 初始入栏数量
	private int initQty;
	// 已出栏数量
	private int marketQty;
	// 已淘汰数量
	private int deathQty;
	
	private int cullQty;
	// 当前存栏量
	
	public int getNowQty(){
		return initQty - cullQty-deathQty-marketQty;
	}
	/**************************************************************************/
	public String getBatchID() {
		return batchID;
	}
	public void setBatchID(String batchID) {
		this.batchID = batchID;
	}
	public Date getIncoopDate() {
		return incoopDate;
	}
	public void setIncoopDate(Date incoopDate) {
		this.incoopDate = incoopDate;
	}
	
	public PigHouseInfo getPigHouse() {
		return pigHouse;
	}
	public void setPigHouse(PigHouseInfo pigHouse) {
		this.pigHouse = pigHouse;
	}
	public int getInitQty() {
		return initQty;
	}
	public void setInitQty(int initQty) {
		this.initQty = initQty;
	}
	
	public int getMarketQty() {
		return marketQty;
	}
	public void setMarketQty(int marketQty) {
		this.marketQty = marketQty;
	}
	public int getDeathQty() {
		return deathQty;
	}
	public void setDeathQty(int deathQty) {
		this.deathQty = deathQty;
	}
	public int getCullQty() {
		return cullQty;
	}
	public void setCullQty(int cullQty) {
		this.cullQty = cullQty;
	}
	
	
	
}
