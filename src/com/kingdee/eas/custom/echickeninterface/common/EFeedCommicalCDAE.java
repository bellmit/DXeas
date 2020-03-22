package com.kingdee.eas.custom.echickeninterface.common;

public class EFeedCommicalCDAE {

	private int CFBreedingStock;//存栏量
	private int CFCullAndDeath;//死淘数
	private int CFTransQty;//转栏数量
	private int CFMarketQty;//出栏数量
	private String CFHenhouseID;//鸡舍id
	private int CFIsMarketed;//是否完全出栏
	public int getCFBreedingStock() {
		return CFBreedingStock;
	}
	public void setCFBreedingStock(int breedingStock) {
		CFBreedingStock = breedingStock;
	}
	public int getCFCullAndDeath() {
		return CFCullAndDeath;
	}
	public void setCFCullAndDeath(int cullAndDeath) {
		CFCullAndDeath = cullAndDeath;
	}
	public String getCFHenhouseID() {
		return CFHenhouseID;
	}
	public void setCFHenhouseID(String henhouseID) {
		CFHenhouseID = henhouseID;
	}
	public int getCFTransQty() {
		return CFTransQty;
	}
	public void setCFTransQty(int transQty) {
		CFTransQty = transQty;
	}
	public int getCFMarketQty() {
		return CFMarketQty;
	}
	public void setCFMarketQty(int marketQty) {
		CFMarketQty = marketQty;
	}
	public int getCFIsMarketed() {
		return CFIsMarketed;
	}
	public void setCFIsMarketed(int isMarketed) {
		CFIsMarketed = isMarketed;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
