package com.kingdee.eas.custom.erp2tax.functions;

import java.io.Serializable;
import java.math.BigDecimal;

public class ExportEntryBean implements Serializable {
	 private final int SPLITE_TYPE = 1;//拆分记录
	 private final int SUM_TYPE = 2;//合并分
     /**
      * 导入entrybean
      */
	 private int seq;
	 private String rowID;
	 private String materialNum;
	 private String materialName;
	 private String model;
	 private String measureUnit;
	 private BigDecimal taxPrice;
	 private BigDecimal qty;
	 private BigDecimal allAmount;//加税合计
     private BigDecimal taxAmount;//税额
     private BigDecimal amount;//不含税金额
     private BigDecimal price;
     private BigDecimal taxRate;
     private String tableName;
     private String srcID;
     private String taxCode;
     
     
     public BigDecimal getAllAmount() {
		return allAmount;
	}
	public void setAllAmount(BigDecimal allAmount) {
		this.allAmount = allAmount;
	}
	public String getTaxCode() {
		return taxCode;
	}
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	private int entryType;
//     private List<ExportRecordBean> exportRecordCols=new List<ExportRecordBean>();//执行导入的记录
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getRowID() {
		return rowID;
	}
	public void setRowID(String rowID) {
		this.rowID = rowID;
	}
	public String getMaterialNum() {
		return materialNum;
	}
	public void setMaterialNum(String materialNum) {
		this.materialNum = materialNum;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMeasureUnit() {
		return measureUnit;
	}
	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}
	public BigDecimal getTaxPrice() {
		return taxPrice;
	}
	public void setTaxPrice(BigDecimal taxPrice) {
		this.taxPrice = taxPrice;
	}
	public BigDecimal getQty() {
		return qty;
	}
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
	/*public BigDecimal getAllAmount() {
		return allAmount;
	}
	public void setAllAmount(BigDecimal allAmount) {
		this.allAmount = allAmount;
	}*/
	public BigDecimal getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getSrcID() {
		return srcID;
	}
	public void setSrcID(String srcID) {
		this.srcID = srcID;
	}
	public int getEntryType() {
		return entryType;
	}
	public void setEntryType(int entryType) {
		this.entryType = entryType;
	}
	public int getSPLITE_TYPE() {
		return SPLITE_TYPE;
	}
	public int getSUM_TYPE() {
		return SUM_TYPE;
	}
     
}
