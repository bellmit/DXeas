package com.kingdee.eas.farm.breed.comm;

import java.io.Serializable;

import com.kingdee.eas.farm.breed.HenhouseInfo;

/**
 * 批次明细详细信息
 * @author USER
 *
 */
public class BreedBatchEntryDetailInfo implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7303517468202786070L;
	private HenhouseInfo henhouse;
	// 商品鸡 和育成鸡 的入栏量、淘汰量、死亡量、已出栏量、当前存栏量
	private int initQty;
	private int culledQty;
	private int deadQty;
	private int nowQty;
	private int marketQty;
	private int transQty; // 转栏量
	// 产蛋鸡分公鸡母鸡分别保存
	private int henInitQty;
	private int henCulledQty;
	private int henDeadQty;
	private int henNowQty;
	
	private int cockInitQty;
	private int cockCulledQty;
	private int cockDeadQty;
	private int cockNowQty;
	
	
	
	public HenhouseInfo getHenhouse() {
		return henhouse;
	}
	public void setHenhouse(HenhouseInfo henhouse) {
		this.henhouse = henhouse;
	}
	public int getInitQty() {
		return initQty;
	}
	public void setInitQty(int initQty) {
		this.initQty = initQty;
	}
	public int getCulledQty() {
		return culledQty;
	}
	public void setCulledQty(int culledQty) {
		this.culledQty = culledQty;
	}
	public int getDeadQty() {
		return deadQty;
	}
	public void setDeadQty(int deadQty) {
		this.deadQty = deadQty;
	}
	public int getNowQty() {
		return nowQty;
	}
	public void setNowQty(int nowQty) {
		this.nowQty = nowQty;
	}
	public int getHenInitQty() {
		return henInitQty;
	}
	public void setHenInitQty(int henInitQty) {
		this.henInitQty = henInitQty;
	}
	public int getHenCulledQty() {
		return henCulledQty;
	}
	public void setHenCulledQty(int henCulledQty) {
		this.henCulledQty = henCulledQty;
	}
	public int getHenDeadQty() {
		return henDeadQty;
	}
	public void setHenDeadQty(int henDeadQty) {
		this.henDeadQty = henDeadQty;
	}
	public int getHenNowQty() {
		return henNowQty;
	}
	public void setHenNowQty(int henNowQty) {
		this.henNowQty = henNowQty;
	}
	public int getCockInitQty() {
		return cockInitQty;
	}
	public void setCockInitQty(int cockInitQty) {
		this.cockInitQty = cockInitQty;
	}
	public int getCockCulledQty() {
		return cockCulledQty;
	}
	public void setCockCulledQty(int cockCulledQty) {
		this.cockCulledQty = cockCulledQty;
	}
	public int getCockDeadQty() {
		return cockDeadQty;
	}
	public void setCockDeadQty(int cockDeadQty) {
		this.cockDeadQty = cockDeadQty;
	}
	public int getCockNowQty() {
		return cockNowQty;
	}
	public void setCockNowQty(int cockNowQty) {
		this.cockNowQty = cockNowQty;
	}
	public int getMarketQty() {
		return marketQty;
	}
	public void setMarketQty(int marketQty) {
		this.marketQty = marketQty;
	}
	public void setTransQty(int transQty) {
		this.transQty = transQty;
	}
	public int getTransQty() {
		return transQty;
	}
	
}
