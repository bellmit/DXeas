package com.kingdee.eas.custom.erp2tax.functions;

import java.io.Serializable;

public class ElcExportBackItemBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7223675068894620267L;
	private String type;//��Ʊ���� �̶�Ϊ0
	private String code;//��Ʒ����
	private String name;//��Ʒ����
	private String spec;//���
	private double price;//����
	private double quantity;//����
	private String uom;//������λ
	private float taxRate;//˰��
	private double amount;//���
	private String catalogCode;//˰�շ������
	private String preferentialPolicyFlg;
	private String addedValueTaxFlg;
	private String zeroTaxRateFlg;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public float getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(float taxRate) {
		this.taxRate = taxRate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
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
	
}
