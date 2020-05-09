package com.kingdee.eas.outinterface.farm.duck.busniess;

import java.math.BigDecimal;

/**
 * 
 * @author alex_dai
 * 批次信息bean
 */
public class BatchInfoBean{
	//批次Id
	private String batchId;
	//上苗数
	private int initQty=0;
	//死淘数
	private int sumDeathAndCullQty=0;
	//出栏数
	private int sumOutQty=0;
	//当前存栏数
	private int curQty=0;
	//饲料饲喂数
	private BigDecimal sumFodderWgt=BigDecimal.ZERO;
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public int getInitQty() {
		return initQty;
	}
	public void setInitQty(int initQty) {
		this.initQty = initQty;
	}
	public int getSumDeathAndCullQty() {
		return sumDeathAndCullQty;
	}
	public void setSumDeathAndCullQty(int sumDeathAndCullQty) {
		this.sumDeathAndCullQty = sumDeathAndCullQty;
	}
	public int getSumOutQty() {
		return sumOutQty;
	}
	public void setSumOutQty(int sumOutQty) {
		this.sumOutQty = sumOutQty;
	}
	public int getCurQty() {
		return curQty;
	}
	public void setCurQty(int curQty) {
		this.curQty = curQty;
	}
	public BigDecimal getSumFodderWgt() {
		return sumFodderWgt;
	}
	public void setSumFodderWgt(BigDecimal sumFodderWgt) {
		this.sumFodderWgt = sumFodderWgt;
	}
	
	
	
	
}