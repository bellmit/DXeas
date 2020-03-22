package com.kingdee.eas.custom.tocloud.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

/**
 * 生产退库单分录
 * @author wlhl
 *
 */
@JSONType(orders = {"FEntryID","FMaterialId","FUnitID","FAPPQty","FQty",
		"FReturnType","FReturnReason","FStockId","FLot","FProductId","FProductNo",
		"FIsAffectCost","FPRODUCTGROUPID","FMtoNo","FStockUnitId",
		"FStockQty","FPrice","FAmount","FBaseUnitId","FBaseAppQty",
		"FBaseQty","FOwnerTypeId","FExtAuxUnitId","FOwnerId","FExtAuxUnitQty","FParentOwnerTypeId",
		"FParentOwnerId","FBomId","FKeeperTypeId","FKeeperId","FEntrtyMemo",
		"FStockStatusId","FProduceDate","FExpiryDate","FSecUnitId","FSecStockQty","F_abc_Amount"})
public class CloudManufactureReturnBillEntry {

	@JSONField(ordinal=1,name = "FEntryID")
	private String FEntryID;

	//物料编码
	@JSONField(ordinal=2,name = "FMaterialId")
	private CloudCommonF7Bean FMaterialId;

	//单位
	@JSONField(ordinal=3,name = "FUnitID")
	private CloudCommonF7Bean FUnitID;
	
	//申请数量
	@JSONField(ordinal=4,name = "FAPPQty")
	private String FAPPQty;
	
	//实退数量
	@JSONField(ordinal=5,name = "FQty")
	private String FQty;
	
	//退料类型
	@JSONField(ordinal=6,name = "FReturnType")
	private String FReturnType;
	
	//退料原因
	@JSONField(ordinal=7,name = "FReturnReason")
	private CloudCommonF7Bean FReturnReason;
	
	//仓库
	@JSONField(ordinal=8,name = "FStockId")
	private CloudCommonF7Bean FStockId;
	
	//批号
	@JSONField(ordinal=9,name = "FLot")
	private CloudCommonF7Bean FLot;
	
	//生产对象
	@JSONField(ordinal=10,name = "FProductId")
	private CloudCommonF7Bean FProductId;
	
	//生产编号
	@JSONField(ordinal=11,name = "FProductNo")
	private String FProductNo;
	
	//生产编号影响成本
	@JSONField(ordinal=12,name = "FIsAffectCost")
	private String FIsAffectCost;
	
	//产品组
	@JSONField(ordinal=13,name = "FPRODUCTGROUPID")
	private CloudCommonF7Bean FPRODUCTGROUPID;
	
	//计划跟踪号
	@JSONField(ordinal=14,name = "FMtoNo")
	private String FMtoNo;
	
	//主库存单位
	@JSONField(ordinal=15,name = "FStockUnitId")
	private CloudCommonF7Bean FStockUnitId;
	
	//主库存实退数量
	@JSONField(ordinal=16,name = "FStockQty")
	private String FStockQty;
	
	//成本价
	@JSONField(ordinal=17,name = "FPrice")
	private String FPrice;
	
	//总成本
	@JSONField(ordinal=18,name = "FAmount")
	private String FAmount;
	
	//基本单位
	@JSONField(ordinal=19,name = "FBaseUnitId")
	private CloudCommonF7Bean FBaseUnitId;
	
	//基本单位申请数量
	@JSONField(ordinal=20,name = "FBaseAppQty")
	private String FBaseAppQty;
	
	//基本单位实退数量
	@JSONField(ordinal=21,name = "FBaseQty")
	private String FBaseQty;
	
	//货主类型
	@JSONField(ordinal=22,name = "FOwnerTypeId")
	private String FOwnerTypeId;
	
	//辅单位
	@JSONField(ordinal=23,name = "FExtAuxUnitId")
	private CloudCommonF7Bean FExtAuxUnitId;
	
	//货主
	@JSONField(ordinal=24,name = "FOwnerId")
	private CloudCommonF7Bean FOwnerId;
	
	//实退数量（辅单位）
	@JSONField(ordinal=25,name = "FExtAuxUnitQty")
	private String FExtAuxUnitQty;
	
	//产品货主类型
	@JSONField(ordinal=26,name = "FParentOwnerTypeId")
	private String FParentOwnerTypeId;
	
	//产品货主
	@JSONField(ordinal=27,name = "FParentOwnerId")
	private CloudCommonF7Bean FParentOwnerId;
	
	//BOM版本
	@JSONField(ordinal=28,name = "FBomId")
	private CloudCommonF7Bean FBomId;

	//保管者类型
	@JSONField(ordinal=29,name = "FKeeperTypeId")
	private String FKeeperTypeId;
	
	//保管者
	@JSONField(ordinal=30,name = "FKeeperId")
	private CloudCommonF7Bean FKeeperId;
	
	//备注
	@JSONField(ordinal=31,name = "FEntrtyMemo")
	private String FEntrtyMemo;
	
	//库存状态
	@JSONField(ordinal=32,name = "FStockStatusId")
	private CloudCommonF7Bean FStockStatusId;
	
	//生产日期
	@JSONField(ordinal=33,name = "FProduceDate")
	private String FProduceDate;
	
	//有效期至
	@JSONField(ordinal=34,name = "FExpiryDate")
	private String FExpiryDate;
	
	//库存辅单位
	@JSONField(ordinal=35,name = "FSecUnitId")
	private CloudCommonF7Bean FSecUnitId;
	
	//实退数量(库存辅单位)
	@JSONField(ordinal=36,name = "FSecStockQty")
	private String FSecStockQty;

	//成本金额
	@JSONField(ordinal=37,name = "F_abc_Amount")
	private String F_abc_Amount;
	
	
	
	
	
	public void setF_abc_Amount(String amount) {
		F_abc_Amount = amount;
	}
	@JSONField(name = "F_abc_Amount")
	public String getF_abc_Amount() {
		return F_abc_Amount;
	}
	@JSONField(name = "FEntryID")
	public String getFEntryID() {
		return FEntryID;
	}
	@JSONField(name = "FMaterialId")
	public CloudCommonF7Bean getFMaterialId() {
		return FMaterialId;
	}
	@JSONField(name = "FUnitID")
	public CloudCommonF7Bean getFUnitID() {
		return FUnitID;
	}
	@JSONField(name = "FAPPQty")
	public String getFAPPQty() {
		return FAPPQty;
	}
	@JSONField(name = "FQty")
	public String getFQty() {
		return FQty;
	}
	@JSONField(name = "FReturnType")
	public String getFReturnType() {
		return FReturnType;
	}
	@JSONField(name = "FReturnReason")
	public CloudCommonF7Bean getFReturnReason() {
		return FReturnReason;
	}
	@JSONField(name = "FStockId")
	public CloudCommonF7Bean getFStockId() {
		return FStockId;
	}
	@JSONField(name = "FLot")
	public CloudCommonF7Bean getFLot() {
		return FLot;
	}
	@JSONField(name = "FProductId")
	public CloudCommonF7Bean getFProductId() {
		return FProductId;
	}
	@JSONField(name = "FProductNo")
	public String getFProductNo() {
		return FProductNo;
	}
	@JSONField(name = "FIsAffectCost")
	public String getFIsAffectCost() {
		return FIsAffectCost;
	}
	@JSONField(name = "FPRODUCTGROUPID")
	public CloudCommonF7Bean getFPRODUCTGROUPID() {
		return FPRODUCTGROUPID;
	}
	@JSONField(name = "FMtoNo")
	public String getFMtoNo() {
		return FMtoNo;
	}
	@JSONField(name = "FStockUnitId")
	public CloudCommonF7Bean getFStockUnitId() {
		return FStockUnitId;
	}
	@JSONField(name = "FStockQty")
	public String getFStockQty() {
		return FStockQty;
	}
	@JSONField(name = "FPrice")
	public String getFPrice() {
		return FPrice;
	}
	@JSONField(name = "FAmount")
	public String getFAmount() {
		return FAmount;
	}
	@JSONField(name = "FBaseUnitId")
	public CloudCommonF7Bean getFBaseUnitId() {
		return FBaseUnitId;
	}
	@JSONField(name = "FBaseAppQty")
	public String getFBaseAppQty() {
		return FBaseAppQty;
	}
	@JSONField(name = "FBaseQty")
	public String getFBaseQty() {
		return FBaseQty;
	}
	@JSONField(name = "FOwnerTypeId")
	public String getFOwnerTypeId() {
		return FOwnerTypeId;
	}
	@JSONField(name = "FExtAuxUnitId")
	public CloudCommonF7Bean getFExtAuxUnitId() {
		return FExtAuxUnitId;
	}
	@JSONField(name = "FOwnerId")
	public CloudCommonF7Bean getFOwnerId() {
		return FOwnerId;
	}
	@JSONField(name = "FExtAuxUnitQty")
	public String getFExtAuxUnitQty() {
		return FExtAuxUnitQty;
	}
	@JSONField(name = "FParentOwnerTypeId")
	public String getFParentOwnerTypeId() {
		return FParentOwnerTypeId;
	}
	@JSONField(name = "FParentOwnerId")
	public CloudCommonF7Bean getFParentOwnerId() {
		return FParentOwnerId;
	}
	@JSONField(name = "FBomId")
	public CloudCommonF7Bean getFBomId() {
		return FBomId;
	}
	@JSONField(name = "FKeeperTypeId")
	public String getFKeeperTypeId() {
		return FKeeperTypeId;
	}
	@JSONField(name = "FKeeperId")
	public CloudCommonF7Bean getFKeeperId() {
		return FKeeperId;
	}
	@JSONField(name = "FEntrtyMemo")
	public String getFEntrtyMemo() {
		return FEntrtyMemo;
	}
	@JSONField(name = "FStockStatusId")
	public CloudCommonF7Bean getFStockStatusId() {
		return FStockStatusId;
	}
	@JSONField(name = "FProduceDate")
	public String getFProduceDate() {
		return FProduceDate;
	}
	@JSONField(name = "FExpiryDate")
	public String getFExpiryDate() {
		return FExpiryDate;
	}
	@JSONField(name = "FSecUnitId")
	public CloudCommonF7Bean getFSecUnitId() {
		return FSecUnitId;
	}
	@JSONField(name = "FSecStockQty")
	public String getFSecStockQty() {
		return FSecStockQty;
	}
	public void setFEntryID(String entryID) {
		FEntryID = entryID;
	}
	public void setFMaterialId(CloudCommonF7Bean materialId) {
		FMaterialId = materialId;
	}
	public void setFUnitID(CloudCommonF7Bean unitID) {
		FUnitID = unitID;
	}
	public void setFAPPQty(String qty) {
		FAPPQty = qty;
	}
	public void setFQty(String qty) {
		FQty = qty;
	}
	public void setFReturnType(String returnType) {
		FReturnType = returnType;
	}
	public void setFReturnReason(CloudCommonF7Bean returnReason) {
		FReturnReason = returnReason;
	}
	public void setFStockId(CloudCommonF7Bean stockId) {
		FStockId = stockId;
	}
	public void setFLot(CloudCommonF7Bean lot) {
		FLot = lot;
	}
	public void setFProductId(CloudCommonF7Bean productId) {
		FProductId = productId;
	}
	public void setFProductNo(String productNo) {
		FProductNo = productNo;
	}
	public void setFIsAffectCost(String isAffectCost) {
		FIsAffectCost = isAffectCost;
	}
	public void setFPRODUCTGROUPID(CloudCommonF7Bean fproductgroupid) {
		FPRODUCTGROUPID = fproductgroupid;
	}
	public void setFMtoNo(String mtoNo) {
		FMtoNo = mtoNo;
	}
	public void setFStockUnitId(CloudCommonF7Bean stockUnitId) {
		FStockUnitId = stockUnitId;
	}
	public void setFStockQty(String stockQty) {
		FStockQty = stockQty;
	}
	public void setFPrice(String price) {
		FPrice = price;
	}
	public void setFAmount(String amount) {
		FAmount = amount;
	}
	public void setFBaseUnitId(CloudCommonF7Bean baseUnitId) {
		FBaseUnitId = baseUnitId;
	}
	public void setFBaseAppQty(String baseAppQty) {
		FBaseAppQty = baseAppQty;
	}
	public void setFBaseQty(String baseQty) {
		FBaseQty = baseQty;
	}
	public void setFOwnerTypeId(String ownerTypeId) {
		FOwnerTypeId = ownerTypeId;
	}
	public void setFExtAuxUnitId(CloudCommonF7Bean extAuxUnitId) {
		FExtAuxUnitId = extAuxUnitId;
	}
	public void setFOwnerId(CloudCommonF7Bean ownerId) {
		FOwnerId = ownerId;
	}
	public void setFExtAuxUnitQty(String extAuxUnitQty) {
		FExtAuxUnitQty = extAuxUnitQty;
	}
	public void setFParentOwnerTypeId(String parentOwnerTypeId) {
		FParentOwnerTypeId = parentOwnerTypeId;
	}
	public void setFParentOwnerId(CloudCommonF7Bean parentOwnerId) {
		FParentOwnerId = parentOwnerId;
	}
	public void setFBomId(CloudCommonF7Bean bomId) {
		FBomId = bomId;
	}
	public void setFKeeperTypeId(String keeperTypeId) {
		FKeeperTypeId = keeperTypeId;
	}
	public void setFKeeperId(CloudCommonF7Bean keeperId) {
		FKeeperId = keeperId;
	}
	public void setFEntrtyMemo(String entrtyMemo) {
		FEntrtyMemo = entrtyMemo;
	}
	public void setFStockStatusId(CloudCommonF7Bean stockStatusId) {
		FStockStatusId = stockStatusId;
	}
	public void setFProduceDate(String produceDate) {
		FProduceDate = produceDate;
	}
	public void setFExpiryDate(String expiryDate) {
		FExpiryDate = expiryDate;
	}
	public void setFSecUnitId(CloudCommonF7Bean secUnitId) {
		FSecUnitId = secUnitId;
	}
	public void setFSecStockQty(String secStockQty) {
		FSecStockQty = secStockQty;
	}




}
