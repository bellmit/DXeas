package com.kingdee.eas.custom.erp2tax.functions;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

public class ElcExportItemBean implements Serializable {
	private static final long serialVersionUID = 4706766674444529127L;
	private BigDecimal amount;//價稅合計
	private String code;//商品編碼
	private String name;//商品名稱
	private BigDecimal price;//商品單價
	private BigDecimal quantity;//數量
	private BigDecimal taxRate;//稅率
	private String uom;//計量單位
	private String type;//發票行性質
	private String spec;//規格型號
	private String catalogCode;//稅收分類代碼
	private String preferentialPolicyFlg;//優惠政策標誌
	private String addedValueTaxFlg;//增值稅特殊管理
	private String zeroTaxRateFlg;//0稅率標誌
	/*private ArrayList<String> srcEntryIDsList;
	
	public ArrayList<String> getSrcEntryIDsList() {
		return srcEntryIDsList;
	}
	public void setSrcEntryIDsList(ArrayList<String> srcEntryIDsList) {
		this.srcEntryIDsList = srcEntryIDsList;
	}*/
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getCatalogCode() {
		return catalogCode;
	}
	public void setCatalogCode(String catalogCode) {
		this.catalogCode = catalogCode;
	}
	public String getPreferentialPolicyFlg() {
		return preferentialPolicyFlg;
	}
	public void setPreferentialPolicyFlg(String preferentialPolicyFlg) {
		this.preferentialPolicyFlg = preferentialPolicyFlg;
	}
	public String getAddedValueTaxFlg() {
		return addedValueTaxFlg;
	}
	public void setAddedValueTaxFlg(String addedValueTaxFlg) {
		this.addedValueTaxFlg = addedValueTaxFlg;
	}
	public String getZeroTaxRateFlg() {
		return zeroTaxRateFlg;
	}
	public void setZeroTaxRateFlg(String zeroTaxRateFlg) {
		this.zeroTaxRateFlg = zeroTaxRateFlg;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
}
