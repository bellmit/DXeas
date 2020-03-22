package com.kingdee.eas.custom.tocloud.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;


/**
 * 其他出口单分录字段
 * @author Administrator
 *
 */
@JSONType(orders = {"FEntryID","FMaterialId","FAuxPropId","FUnitID","FQty","FBaseUnitId",
		"FStockId","FStockLocId","FLot","FPRODUCTGROUPID","FEntryNote","FBomId","FProjectNo","FProduceDate",
		"FServiceContext","FStockStatusId","FMtoNo","FCostItem","FKeeperTypeId","FDistribution",
		"FKeeperId","FExtAuxUnitId","F_abc_Price","FExtAuxUnitQty","F_abc_Amount"})
public class OtherOutWarehsBillEntry {

	//分录ID
	@JSONField(ordinal=1,name = "FEntryID")
	private String FEntryID;
	
	//物料编码
	@JSONField(ordinal=2,name = "FMaterialId")
	private CloudCommonF7Bean FMaterialId;
	
	//辅助属性
	@JSONField(ordinal=3,name = "FAuxPropId")
	private CloudCommonFAUXPROF7Bean FAuxPropId;
	
	//单位
	@JSONField(ordinal=4,name = "FUnitID")
	private CloudCommonF7Bean FUnitID;
	
	//实发数量
	@JSONField(ordinal=5,name = "FQty")
	private String FQty;
	
	//基本单位
	@JSONField(ordinal=6,name = "FBaseUnitId")
	private CloudCommonF7Bean FBaseUnitId;
	
	//发货仓库
	@JSONField(ordinal=7,name = "FStockId")
	private CloudCommonF7Bean FStockId;
	
	//仓位
	@JSONField(ordinal=8,name = "FStockLocId")
	private CloudCommonFSTOCKF7Bean FStockLocId;
	
	//批号
	@JSONField(ordinal=9,name = "FLot")
	private CloudCommonF7Bean FLot;
	
	//产品组
	@JSONField(ordinal=10,name = "FPRODUCTGROUPID")
	private CloudCommonF7Bean FPRODUCTGROUPID;
	
	//备注
	@JSONField(ordinal=11,name = "FEntryNote")
	private String FEntryNote;
	
	//BOM版本
	@JSONField(ordinal=12,name = "FBomId")
	private CloudCommonF7Bean FBomId;
	
	//项目编号
	@JSONField(ordinal=13,name = "FProjectNo")
	private String FProjectNo;
	
	//生产日期
	@JSONField(ordinal=14,name = "FProduceDate")
	private String FProduceDate;
	
	//服务上下文
	@JSONField(ordinal=15,name = "FServiceContext")
	private String FServiceContext;
	
	//库存状态
	@JSONField(ordinal=16,name = "FStockStatusId")
	private CloudCommonF7Bean FStockStatusId;
	
	//计划跟踪号
	@JSONField(ordinal=17,name = "FMtoNo")
	private String FMtoNo;
	
	//成本项目
	@JSONField(ordinal=18,name = "FCostItem")
	private CloudCommonF7Bean FCostItem;
	
	//保管者类型
	@JSONField(ordinal=19,name = "FKeeperTypeId")
	private String FKeeperTypeId;
	
	//参加费用分配
	@JSONField(ordinal=20,name = "FDistribution")
	private String FDistribution;
	
	//保管者
	@JSONField(ordinal=21,name = "FKeeperId")
	private CloudCommonF7Bean FKeeperId;
	
	//辅单位
	@JSONField(ordinal=22,name = "FExtAuxUnitId")
	private CloudCommonF7Bean FExtAuxUnitId;
	
	//单价
	@JSONField(ordinal=23,name = "F_abc_Price")
	private String F_abc_Price;
	
	//实发数量（辅单位）
	@JSONField(ordinal=24,name = "FExtAuxUnitQty")
	private String FExtAuxUnitQty;
	
	//金额
	@JSONField(ordinal=25,name = "F_abc_Amount")
	private String F_abc_Amount;

	
	
	
	
	@JSONField(name = "FEntryID")
	public String getFEntryID() {
		return FEntryID;
	}
	@JSONField(name = "FMaterialId")
	public CloudCommonF7Bean getFMaterialId() {
		return FMaterialId;
	}
	@JSONField(name = "FAuxPropId")
	public CloudCommonFAUXPROF7Bean getFAuxPropId() {
		return FAuxPropId;
	}
	@JSONField(name = "FUnitID")
	public CloudCommonF7Bean getFUnitID() {
		return FUnitID;
	}
	@JSONField(name = "FQty")
	public String getFQty() {
		return FQty;
	}
	@JSONField(name = "FBaseUnitId")
	public CloudCommonF7Bean getFBaseUnitId() {
		return FBaseUnitId;
	}
	@JSONField(name = "FStockId")
	public CloudCommonF7Bean getFStockId() {
		return FStockId;
	}
	@JSONField(name = "FStockLocId")
	public CloudCommonFSTOCKF7Bean getFStockLocId() {
		return FStockLocId;
	}
	@JSONField(name = "FLot")
	public CloudCommonF7Bean getFLot() {
		return FLot;
	}
	@JSONField(name = "FPRODUCTGROUPID")
	public CloudCommonF7Bean getFPRODUCTGROUPID() {
		return FPRODUCTGROUPID;
	}
	@JSONField(name = "FEntryNote")
	public String getFEntryNote() {
		return FEntryNote;
	}
	@JSONField(name = "FBomId")
	public CloudCommonF7Bean getFBomId() {
		return FBomId;
	}
	@JSONField(name = "FProjectNo")
	public String getFProjectNo() {
		return FProjectNo;
	}
	@JSONField(name = "FProduceDate")
	public String getFProduceDate() {
		return FProduceDate;
	}
	@JSONField(name = "FServiceContext")
	public String getFServiceContext() {
		return FServiceContext;
	}
	@JSONField(name = "FStockStatusId")
	public CloudCommonF7Bean getFStockStatusId() {
		return FStockStatusId;
	}
	@JSONField(name = "FMtoNo")
	public String getFMtoNo() {
		return FMtoNo;
	}
	@JSONField(name = "FCostItem")
	public CloudCommonF7Bean getFCostItem() {
		return FCostItem;
	}
	@JSONField(name = "FKeeperTypeId")
	public String getFKeeperTypeId() {
		return FKeeperTypeId;
	}
	@JSONField(name = "FDistribution")
	public String getFDistribution() {
		return FDistribution;
	}
	@JSONField(name = "FKeeperId")
	public CloudCommonF7Bean getFKeeperId() {
		return FKeeperId;
	}
	@JSONField(name = "FExtAuxUnitId")
	public CloudCommonF7Bean getFExtAuxUnitId() {
		return FExtAuxUnitId;
	}
	@JSONField(name = "F_abc_Price")
	public String getF_abc_Price() {
		return F_abc_Price;
	}
	@JSONField(name = "FExtAuxUnitQty")
	public String getFExtAuxUnitQty() {
		return FExtAuxUnitQty;
	}
	@JSONField(name = "F_abc_Amount")
	public String getF_abc_Amount() {
		return F_abc_Amount;
	}
	public void setFEntryID(String entryID) {
		FEntryID = entryID;
	}
	public void setFMaterialId(CloudCommonF7Bean materialId) {
		FMaterialId = materialId;
	}
	public void setFAuxPropId(CloudCommonFAUXPROF7Bean auxPropId) {
		FAuxPropId = auxPropId;
	}
	public void setFUnitID(CloudCommonF7Bean unitID) {
		FUnitID = unitID;
	}
	public void setFQty(String qty) {
		FQty = qty;
	}
	public void setFBaseUnitId(CloudCommonF7Bean baseUnitId) {
		FBaseUnitId = baseUnitId;
	}
	public void setFStockId(CloudCommonF7Bean stockId) {
		FStockId = stockId;
	}
	public void setFStockLocId(CloudCommonFSTOCKF7Bean stockLocId) {
		FStockLocId = stockLocId;
	}
	public void setFLot(CloudCommonF7Bean lot) {
		FLot = lot;
	}
	public void setFPRODUCTGROUPID(CloudCommonF7Bean fproductgroupid) {
		FPRODUCTGROUPID = fproductgroupid;
	}
	public void setFEntryNote(String entryNote) {
		FEntryNote = entryNote;
	}
	public void setFBomId(CloudCommonF7Bean bomId) {
		FBomId = bomId;
	}
	public void setFProjectNo(String projectNo) {
		FProjectNo = projectNo;
	}
	public void setFProduceDate(String produceDate) {
		FProduceDate = produceDate;
	}
	public void setFServiceContext(String serviceContext) {
		FServiceContext = serviceContext;
	}
	public void setFStockStatusId(CloudCommonF7Bean stockStatusId) {
		FStockStatusId = stockStatusId;
	}
	public void setFMtoNo(String mtoNo) {
		FMtoNo = mtoNo;
	}
	public void setFCostItem(CloudCommonF7Bean costItem) {
		FCostItem = costItem;
	}
	public void setFKeeperTypeId(String keeperTypeId) {
		FKeeperTypeId = keeperTypeId;
	}
	public void setFDistribution(String distribution) {
		FDistribution = distribution;
	}
	public void setFKeeperId(CloudCommonF7Bean keeperId) {
		FKeeperId = keeperId;
	}
	public void setFExtAuxUnitId(CloudCommonF7Bean extAuxUnitId) {
		FExtAuxUnitId = extAuxUnitId;
	}
	public void setF_abc_Price(String price) {
		F_abc_Price = price;
	}
	public void setFExtAuxUnitQty(String extAuxUnitQty) {
		FExtAuxUnitQty = extAuxUnitQty;
	}
	public void setF_abc_Amount(String amount) {
		F_abc_Amount = amount;
	}
	
	
	
}
