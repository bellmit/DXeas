package com.kingdee.eas.custom.echickeninterface.common;

public class EFeedCommicalCDAE {

	private int CFBreedingStock;//������
	private int CFCullAndDeath;//������
	private int CFTransQty;//ת������
	private int CFMarketQty;//��������
	private String CFHenhouseID;//����id
	private int CFIsMarketed;//�Ƿ���ȫ����
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
