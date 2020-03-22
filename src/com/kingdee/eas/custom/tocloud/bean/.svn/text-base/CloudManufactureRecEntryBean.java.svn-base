package com.kingdee.eas.custom.tocloud.bean;

import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

/**
 *简单生产出入库单分录
 * @author Administrator
 *
 */
@JSONType(orders = {"FEntryID","FMaterialId","FInStockType","FUnitID","FMustQty",
		"FRealQty","FStockId","FStockLocId","FLot","FWorkShopId1","FShiftGroupId",
		"FProductNo","FIsAffectCost","FOwnerTypeId","FOwnerId","FStockUnitId",
		"FStockRealQty","FBaseUnitId","FExtAuxUnitId","FBaseRealQty","FExtAuxUnitQty",
		"F_abc_Qty","F_abc_Qty1",
		"F_abc_SourceBillNo","FMtoNo","FStockStatusId","FBomId","FProduceDate","FExpiryDate",
		"FMemo","FBaseMustQty","FKeeperTypeId","FKeeperId","FAuxpropId","FSecUnitId","FSecRealQty",
		"F_abc_Qty2","F_abc_Qty3","FPrice","FAmount"})
public class CloudManufactureRecEntryBean {

	//设置分录id
	@JSONField(ordinal=1,name = "FEntryID")
	private String FEntryID;
	//物料
	@JSONField(ordinal=2,name = "FMaterialId")
	private CloudCommonF7Bean FMaterialId;
    //入库类型
	@JSONField(ordinal=3,name = "FInStockType")
	private String FInStockType;
	//单位
	@JSONField(ordinal=4,name = "FUnitID")
	private CloudCommonF7Bean FUnitID;
	//应收数量
	@JSONField(ordinal=5,name = "FMustQty")
	private String FMustQty;
	//实收数量
	@JSONField(ordinal=6,name = "FRealQty")
	private String FRealQty;
	//仓库
	@JSONField(ordinal=7,name = "FStockId")
	private CloudCommonF7Bean FStockId;
	//仓位
	@JSONField(ordinal=8,name = "FStockLocId")
	private CloudCommonFSTOCKF7Bean FStockLocId;
	//批号
	@JSONField(ordinal=9,name = "FLot")
	private CloudCommonF7Bean FLot;
	//生产车间
	@JSONField(ordinal=10,name = "FWorkShopId1")
	private CloudCommonF7Bean FWorkShopId1;
	//班组
	@JSONField(ordinal=11,name = "FShiftGroupId")
	private CloudCommonF7Bean FShiftGroupId;
	//生产编号
	@JSONField(ordinal=12,name = "FProductNo")
	private String FProductNo;
	//生产编号影响成本
	@JSONField(ordinal=13,name = "FIsAffectCost")
	private String FIsAffectCost;
	//货主类型
	@JSONField(ordinal=14,name = "FOwnerTypeId")
	private String FOwnerTypeId;
	//货主
	@JSONField(ordinal=15,name = "FOwnerId")
	private CloudCommonF7Bean FOwnerId;
	//库存单位
	@JSONField(ordinal=16,name = "FStockUnitId")
	private CloudCommonF7Bean FStockUnitId;
	//库存单位实收数量
	@JSONField(ordinal=17,name = "FStockRealQty")
	private String FStockRealQty;
	//基本单位
	@JSONField(ordinal=18,name = "FBaseUnitId")
	private CloudCommonF7Bean FBaseUnitId;
	//辅单位
	@JSONField(ordinal=19,name = "FExtAuxUnitId")
	private CloudCommonF7Bean FExtAuxUnitId;
	//基本单位实收数量
	@JSONField(ordinal=20,name = "FBaseRealQty")
	private String FBaseRealQty;
	//实收数量（辅单位）
	@JSONField(ordinal=21,name = "FExtAuxUnitQty")
	private String FExtAuxUnitQty;
	
	//毛鸡只数
	@JSONField(ordinal=22,name = "F_abc_Qty")
	private String F_abc_Qty;
	
	//单只毛鸡重量
	@JSONField(ordinal=23,name = "F_abc_Qty1")
	private String F_abc_Qty1;
	
	
	
	
	//源单编号
	@JSONField(ordinal=24,name = "F_abc_SourceBillNo")
	private String F_abc_SourceBillNo;
	//计划跟踪号
	@JSONField(ordinal=25,name = "FMtoNo")
	private String FMtoNo;
	//库存状态
	@JSONField(ordinal=26,name = "FStockStatusId")
	private CloudCommonF7Bean FStockStatusId;
	//BOM版本
	@JSONField(ordinal=27,name = "FBomId")
	private CloudCommonF7Bean FBomId;
	//生产日期
	@JSONField(ordinal=28,name = "FProduceDate")
	private String FProduceDate;
	//有效期至
	@JSONField(ordinal=29,name = "FExpiryDate")
	private String FExpiryDate;
	//备注
	@JSONField(ordinal=30,name = "FMemo")
	private String FMemo;
	//基本单位应收数量
	@JSONField(ordinal=31,name = "FBaseMustQty")
	private String FBaseMustQty;
	//保管者类型
	@JSONField(ordinal=32,name = "FKeeperTypeId")
	private String FKeeperTypeId;
	//保管者
	@JSONField(ordinal=33,name = "FKeeperId")
	private CloudCommonF7Bean FKeeperId;
	
	//辅助属性
	@JSONField(ordinal=34,name = "FAuxpropId")
	private CloudCommonFAUXPROF7Bean FAuxpropId;
	
	@JSONField(ordinal=35,name = "FSecUnitId")
	private CloudCommonF7Bean FSecUnitId;
	
	@JSONField(ordinal=36,name = "FSecRealQty")
	private String FSecRealQty;
	
	@JSONField(ordinal=37,name = "F_abc_Qty2")
	private String F_abc_Qty2;
	
	@JSONField(ordinal=38,name = "F_abc_Qty3")
	private String F_abc_Qty3;
	
	@JSONField(ordinal=39,name = "FPrice")
	private String FPrice;
	
	@JSONField(ordinal=40,name = "FAmount")
	private String FAmount;
	
	
	
	
	
	
	
	@JSONField(name = "FPrice")
	public String getFPrice() {
		return FPrice;
	}
	@JSONField(name = "FAmount")
	public String getFAmount() {
		return FAmount;
	}
	public void setFPrice(String price) {
		FPrice = price;
	}
	public void setFAmount(String amount) {
		FAmount = amount;
	}
	
	
	
	@JSONField(name = "F_abc_Qty2")
	public String getF_abc_Qty2() {
		return F_abc_Qty2;
	}
	@JSONField(name = "F_abc_Qty3")
	public String getF_abc_Qty3() {
		return F_abc_Qty3;
	}
	public void setF_abc_Qty2(String qty2) {
		F_abc_Qty2 = qty2;
	}
	public void setF_abc_Qty3(String qty3) {
		F_abc_Qty3 = qty3;
	}
	
	
	
	@JSONField(name = "F_abc_Qty")
	public String getF_abc_Qty() {
		return F_abc_Qty;
	}
	@JSONField(name = "F_abc_Qty1")
	public String getF_abc_Qty1() {
		return F_abc_Qty1;
	}
	
	
	
	@JSONField(name = "FEntryID")
	public String getFEntryID() {
		return FEntryID;
	}
	public void setFEntryID(String entryID) {
		FEntryID = entryID;
	}
	@JSONField(name = "FMaterialId")
	public CloudCommonF7Bean getFMaterialId() {
		return FMaterialId;
	}
	public void setFMaterialId(CloudCommonF7Bean materialId) {
		FMaterialId = materialId;
	}
	@JSONField(name = "FInStockType")
	public String getFInStockType() {
		return FInStockType;
	}
	public void setFInStockType(String inStockType) {
		FInStockType = inStockType;
	}
	@JSONField(name = "FUnitID")
	public CloudCommonF7Bean getFUnitID() {
		return FUnitID;
	}
	public void setFUnitID(CloudCommonF7Bean unitID) {
		FUnitID = unitID;
	}
	@JSONField(name = "FMustQty")
	public String getFMustQty() {
		return FMustQty;
	}
	public void setFMustQty(String targetustQty) {
		FMustQty = targetustQty;
	}
	@JSONField(name = "FRealQty")
	public String getFRealQty() {
		return FRealQty;
	}
	public void setFRealQty(String realQty) {
		FRealQty = realQty;
	}
	@JSONField(name = "FStockId")
	public CloudCommonF7Bean getFStockId() {
		return FStockId;
	}
	public void setFStockId(CloudCommonF7Bean stockId) {
		FStockId = stockId;
	}
	@JSONField(name = "FStockLocId")
	public CloudCommonFSTOCKF7Bean getFStockLocId() {
		return FStockLocId;
	}
	public void setFStockLocId(CloudCommonFSTOCKF7Bean stockLocId) {
		FStockLocId = stockLocId;
	}
	@JSONField(name = "FLot")
	public CloudCommonF7Bean getFLot() {
		return FLot;
	}
	public void setFLot(CloudCommonF7Bean lot) {
		FLot = lot;
	}
	@JSONField(name = "FWorkShopId1")
	public CloudCommonF7Bean getFWorkShopId1() {
		return FWorkShopId1;
	}
	public void setFWorkShopId1(CloudCommonF7Bean workShopId1) {
		FWorkShopId1 = workShopId1;
	}
	@JSONField(name = "FShiftGroupId")
	public CloudCommonF7Bean getFShiftGroupId() {
		return FShiftGroupId;
	}
	public void setFShiftGroupId(CloudCommonF7Bean shiftGroupId) {
		FShiftGroupId = shiftGroupId;
	}
	@JSONField(name = "FProductNo")
	public String getFProductNo() {
		return FProductNo;
	}
	public void setFProductNo(String productNo) {
		FProductNo = productNo;
	}
	@JSONField(name = "FIsAffectCost")
	public String getFIsAffectCost() {
		return FIsAffectCost;
	}
	public void setFIsAffectCost(String isAffectCost) {
		FIsAffectCost = isAffectCost;
	}
	@JSONField(name = "FOwnerTypeId")
	public String getFOwnerTypeId() {
		return FOwnerTypeId;
	}
	public void setFOwnerTypeId(String ownerTypeId) {
		FOwnerTypeId = ownerTypeId;
	}
	@JSONField(name = "FOwnerId")
	public CloudCommonF7Bean getFOwnerId() {
		return FOwnerId;
	}
	public void setFOwnerId(CloudCommonF7Bean ownerId) {
		FOwnerId = ownerId;
	}
	@JSONField(name = "FStockUnitId")
	public CloudCommonF7Bean getFStockUnitId() {
		return FStockUnitId;
	}
	public void setFStockUnitId(CloudCommonF7Bean stockUnitId) {
		FStockUnitId = stockUnitId;
	}
	@JSONField(name = "FStockRealQty")
	public String getFStockRealQty() {
		return FStockRealQty;
	}
	public void setFStockRealQty(String stockRealQty) {
		FStockRealQty = stockRealQty;
	}
	@JSONField(name = "FBaseUnitId")
	public CloudCommonF7Bean getFBaseUnitId() {
		return FBaseUnitId;
	}
	public void setFBaseUnitId(CloudCommonF7Bean baseUnitId) {
		FBaseUnitId = baseUnitId;
	}
	@JSONField(name = "FExtAuxUnitId")
	public CloudCommonF7Bean getFExtAuxUnitId() {
		return FExtAuxUnitId;
	}
	public void setFExtAuxUnitId(CloudCommonF7Bean extAuxUnitId) {
		FExtAuxUnitId = extAuxUnitId;
	}
	@JSONField(name = "FBaseRealQty")
	public String getFBaseRealQty() {
		return FBaseRealQty;
	}
	public void setFBaseRealQty(String baseRealQty) {
		FBaseRealQty = baseRealQty;
	}
	@JSONField(name = "FExtAuxUnitQty")
	public String getFExtAuxUnitQty() {
		return FExtAuxUnitQty;
	}
	public void setFExtAuxUnitQty(String extAuxUnitQty) {
		FExtAuxUnitQty = extAuxUnitQty;
	}
	@JSONField(name = "F_abc_SourceBillNo")
	public String getF_abc_SourceBillNo() {
		return F_abc_SourceBillNo;
	}
	public void setF_abc_SourceBillNo(String sourceBillNo) {
		F_abc_SourceBillNo = sourceBillNo;
	}
	@JSONField(name = "FMtoNo")
	public String getFMtoNo() {
		return FMtoNo;
	}
	public void setFMtoNo(String mtoNo) {
		FMtoNo = mtoNo;
	}
	@JSONField(name = "FStockStatusId")
	public CloudCommonF7Bean getFStockStatusId() {
		return FStockStatusId;
	}
	public void setFStockStatusId(CloudCommonF7Bean stockStatusId) {
		FStockStatusId = stockStatusId;
	}
	@JSONField(name = "FBomId")
	public CloudCommonF7Bean getFBomId() {
		return FBomId;
	}
	public void setFBomId(CloudCommonF7Bean bomId) {
		FBomId = bomId;
	}
	@JSONField(name = "FProduceDate")
	public String getFProduceDate() {
		return FProduceDate;
	}
	public void setFProduceDate(String produceDate) {
		FProduceDate = produceDate;
	}
	@JSONField(name = "FSecRealQty")
	public String getFSecRealQty() {
		return FSecRealQty;
	}
	public void setFSecRealQty(String secRealQty) {
		FSecRealQty = secRealQty;
	}
	@JSONField(name = "FExpiryDate")
	public String getFExpiryDate() {
		return FExpiryDate;
	}
	public void setFExpiryDate(String expiryDate) {
		FExpiryDate = expiryDate;
	}
	@JSONField(name = "FMemo")
	public String getFMemo() {
		return FMemo;
	}
	public void setFMemo(String memo) {
		FMemo = memo;
	}
	@JSONField(name = "FBaseMustQty")
	public String getFBaseMustQty() {
		return FBaseMustQty;
	}
	public void setFBaseMustQty(String baseMustQty) {
		FBaseMustQty = baseMustQty;
	}
	@JSONField(name = "FKeeperTypeId")
	public String getFKeeperTypeId() {
		return FKeeperTypeId;
	}
	public void setFKeeperTypeId(String keeperTypeId) {
		FKeeperTypeId = keeperTypeId;
	}
	@JSONField(name = "FKeeperId")
	public CloudCommonF7Bean getFKeeperId() {
		return FKeeperId;
	}
	public void setFKeeperId(CloudCommonF7Bean keeperId) {
		FKeeperId = keeperId;
	}
	@JSONField(name = "FAuxpropId")
	public CloudCommonFAUXPROF7Bean getFAuxpropId() {
		return FAuxpropId;
	}
	public void setFAuxpropId(CloudCommonFAUXPROF7Bean auxpropId) {
		FAuxpropId = auxpropId;
	}
	@JSONField(name = "FSecUnitId")
	public CloudCommonF7Bean getFSecUnitId() {
		return FSecUnitId;
	}
	public void setFSecUnitId(CloudCommonF7Bean secUnitId) {
		FSecUnitId = secUnitId;
	}
	public void setF_abc_Qty(String qty) {
		F_abc_Qty = qty;
	}
	public void setF_abc_Qty1(String qty1) {
		F_abc_Qty1 = qty1;
	}
	
}
