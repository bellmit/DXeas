package com.kingdee.eas.farm.stocking.common;

import java.math.BigDecimal;

/**
 * 
 * �����۸��ȡBEAN
 * @author dai_andong
 *
 */
public class BasePriceBean {
	private String materialID;
	private String unitID;
	private BigDecimal basePrice;
	public String getMaterialID() {
		return materialID;
	}
	public void setMaterialID(String materialID) {
		this.materialID = materialID;
	}
	public String getUnitID() {
		return unitID;
	}
	public void setUnitID(String unitID) {
		this.unitID = unitID;
	}
	public BigDecimal getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}
	
}
