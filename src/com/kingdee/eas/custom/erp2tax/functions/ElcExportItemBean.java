package com.kingdee.eas.custom.erp2tax.functions;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

public class ElcExportItemBean implements Serializable {
	private static final long serialVersionUID = 4706766674444529127L;
	private BigDecimal amount;//�r����Ӌ
	private String code;//��Ʒ���a
	private String name;//��Ʒ���Q
	private BigDecimal price;//��Ʒ�΃r
	private BigDecimal quantity;//����
	private BigDecimal taxRate;//����
	private String uom;//Ӌ����λ
	private String type;//�lƱ�����|
	private String spec;//Ҏ����̖
	private String catalogCode;//���շ���a
	private String preferentialPolicyFlg;//�������ߘ��I
	private String addedValueTaxFlg;//��ֵ���������
	private String zeroTaxRateFlg;//0���ʘ��I
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
