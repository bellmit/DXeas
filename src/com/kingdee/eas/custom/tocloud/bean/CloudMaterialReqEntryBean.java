package com.kingdee.eas.custom.tocloud.bean;

import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

/**
 * 领料出库单分录
 * @author MC
 *
 */
@JSONType(orders = {"FEntryID","FMaterialId","FAuxPropId","FBomId","FUnitID",
		"FAppQty","FActualQty","FStockId","FStockLocId","FLot","FProductId",
		"FProductNo","FIsAffectCost","FPRODUCTGROUPID","FStockUnitId",
		"FStockActualQty","FOwnerTypeId","FEntryWorkShopId","FOwnerId","FExtAuxUnitId",
		"FExtAuxUnitQty","FPrice","FAmount","FParentOwnerTypeId","FParentOwnerId","FBaseUnitId","FServiceContext",
		"FBaseActualQty","FStockStatusId","FProduceDate","FSecUnitId","FSecActualQty","FEntrtyMemo",
		"FMtoNo","FBaseAppQty","FKeeperTypeId","FKeeperId","FExpiryDate","F_abc_Text","F_abc_Amount"})
public class CloudMaterialReqEntryBean {
	
	@JSONField(ordinal=1,name = "FEntryID")
	private String FEntryID;
	//物料编码(必填项)
	@JSONField(ordinal=2,name = "FMaterialId")
	private CloudCommonF7Bean FMaterialId;
	//辅助属性
	@JSONField(ordinal=3,name = "FAuxPropId")
	private CloudCommonFAUXPROF7Bean FAuxPropId;
	//BOM版本
	@JSONField(ordinal=4,name = "FBomId")
	private CloudCommonF7Bean FBomId;
	//单位 (必填项)
	@JSONField(ordinal=5,name = "FUnitID")
	private CloudCommonF7Bean FUnitID;
	//申请数量
	@JSONField(ordinal=6,name = "FAppQty")
	private String FAppQty;
	//实发数量
	@JSONField(ordinal=7,name = "FActualQty")
	private String FActualQty;
	//仓库
	@JSONField(ordinal=8,name = "FStockId")
	private CloudCommonF7Bean FStockId;
	//仓位
	@JSONField(ordinal=9,name = "FStockLocId")
	private CloudCommonFSTOCKF7Bean FStockLocId;
	//批次
	@JSONField(ordinal=10,name = "FLot")
	private CloudCommonF7Bean FLot;
	//生产对象
	@JSONField(ordinal=11,name = "FProductId")
	private CloudCommonF7Bean FProductId;
	//生产编号
	@JSONField(ordinal=12,name = "FProductNo")
	private String FProductNo;
	//生产编号影响成本
	@JSONField(ordinal=13,name = "FIsAffectCost")
	private String FIsAffectCost;
	//产品组
	@JSONField(ordinal=14,name = "FPRODUCTGROUPID")
	private CloudCommonF7Bean FPRODUCTGROUPID;
	//库存单位
	@JSONField(ordinal=15,name = "FStockUnitId")
	private CloudCommonF7Bean FStockUnitId;
	//库存单位实发数量
	@JSONField(ordinal=16,name = "FStockActualQty")
	private String FStockActualQty;
	//货主类型
	@JSONField(ordinal=17,name = "FOwnerTypeId")
	private String FOwnerTypeId;
	//车间
	@JSONField(ordinal=18,name = "FEntryWorkShopId")
	private CloudCommonF7Bean FEntryWorkShopId;
	//货主
	@JSONField(ordinal=19,name = "FOwnerId")
	private CloudCommonF7Bean FOwnerId;
	//辅单位
	@JSONField(ordinal=20,name = "FExtAuxUnitId")
	private CloudCommonF7Bean FExtAuxUnitId;
	//实发数量（辅单位）
	@JSONField(ordinal=21,name = "FExtAuxUnitQty")
	private String FExtAuxUnitQty;
	//成本价
	@JSONField(ordinal=22,name = "FPrice")
	private String FPrice;
	//总成本
	@JSONField(ordinal=23,name = "FAmount")
	private String FAmount;
	//产品货主类型
	@JSONField(ordinal=24,name = "FParentOwnerTypeId")
	private String FParentOwnerTypeId;
	//产品货主
	@JSONField(ordinal=25,name = "FParentOwnerId")
	private CloudCommonF7Bean FParentOwnerId;
	//基本单位  (必填项)
	@JSONField(ordinal=26,name = "FBaseUnitId")
	private CloudCommonF7Bean FBaseUnitId;
	//服务上下文
	@JSONField(ordinal=27,name = "FServiceContext")
	private String FServiceContext;
	//基本单位数量
	@JSONField(ordinal=28,name = "FBaseActualQty")
	private String FBaseActualQty;
	//库存状态  (必填项)
	@JSONField(ordinal=29,name = "FStockStatusId")
	private CloudCommonF7Bean FStockStatusId;
	//生产日期
	@JSONField(ordinal=30,name = "FProduceDate")
	private String FProduceDate;
	//库存辅单位
	@JSONField(ordinal=31,name = "FSecUnitId")
	private CloudCommonF7Bean FSecUnitId;
	//实发数量(库存辅单位)
	@JSONField(ordinal=32,name = "FSecActualQty")
	private String FSecActualQty;
	//备注
	@JSONField(ordinal=33,name = "FEntrtyMemo")
	private String FEntrtyMemo;
	//计划跟踪号
	@JSONField(ordinal=34,name = "FMtoNo")
	private String FMtoNo;
	//基本单位申请数量
	@JSONField(ordinal=35,name = "FBaseAppQty")
	private String FBaseAppQty;
	//保管者类型  (必填项)
	@JSONField(ordinal=36,name = "FKeeperTypeId")
	private String FKeeperTypeId;
	//保管者  (必填项)
	@JSONField(ordinal=37,name = "FKeeperId")
	private CloudCommonF7Bean FKeeperId;
	//有效期至
	@JSONField(ordinal=38,name = "FExpiryDate")
	private String FExpiryDate;
	//调整
	@JSONField(ordinal=39,name = "F_abc_Text")
	private String F_abc_Text;
	
	//成本金额
	@JSONField(ordinal=40,name = "F_abc_Amount")
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
	@JSONField(name = "FAuxPropId")
	public CloudCommonFAUXPROF7Bean getFAuxPropId() {
		return FAuxPropId;
	}
	@JSONField(name = "FBomId")
	public CloudCommonF7Bean getFBomId() {
		return FBomId;
	}
	@JSONField(name = "FUnitID")
	public CloudCommonF7Bean getFUnitID() {
		return FUnitID;
	}
	@JSONField(name = "FAppQty")
	public String getFAppQty() {
		return FAppQty;
	}
	@JSONField(name = "FActualQty")
	public String getFActualQty() {
		return FActualQty;
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
	@JSONField(name = "FStockUnitId")
	public CloudCommonF7Bean getFStockUnitId() {
		return FStockUnitId;
	}
	@JSONField(name = "FStockActualQty")
	public String getFStockActualQty() {
		return FStockActualQty;
	}
	@JSONField(name = "FOwnerTypeId")
	public String getFOwnerTypeId() {
		return FOwnerTypeId;
	}
	@JSONField(name = "FEntryWorkShopId")
	public CloudCommonF7Bean getFEntryWorkShopId() {
		return FEntryWorkShopId;
	}
	@JSONField(name = "FOwnerId")
	public CloudCommonF7Bean getFOwnerId() {
		return FOwnerId;
	}
	@JSONField(name = "FExtAuxUnitId")
	public CloudCommonF7Bean getFExtAuxUnitId() {
		return FExtAuxUnitId;
	}
	@JSONField(name = "FExtAuxUnitQty")
	public String getFExtAuxUnitQty() {
		return FExtAuxUnitQty;
	}
	@JSONField(name = "FPrice")
	public String getFPrice() {
		return FPrice;
	}
	@JSONField(name = "FAmount")
	public String getFAmount() {
		return FAmount;
	}
	@JSONField(name = "FParentOwnerTypeId")
	public String getFParentOwnerTypeId() {
		return FParentOwnerTypeId;
	}
	@JSONField(name = "FParentOwnerId")
	public CloudCommonF7Bean getFParentOwnerId() {
		return FParentOwnerId;
	}
	@JSONField(name = "FBaseUnitId")
	public CloudCommonF7Bean getFBaseUnitId() {
		return FBaseUnitId;
	}
	@JSONField(name = "FServiceContext")
	public String getFServiceContext() {
		return FServiceContext;
	}
	@JSONField(name = "FBaseActualQty")
	public String getFBaseActualQty() {
		return FBaseActualQty;
	}
	@JSONField(name = "FStockStatusId")
	public CloudCommonF7Bean getFStockStatusId() {
		return FStockStatusId;
	}
	@JSONField(name = "FProduceDate")
	public String getFProduceDate() {
		return FProduceDate;
	}
	@JSONField(name = "FSecUnitId")
	public CloudCommonF7Bean getFSecUnitId() {
		return FSecUnitId;
	}
	@JSONField(name = "FSecActualQty")
	public String getFSecActualQty() {
		return FSecActualQty;
	}
	@JSONField(name = "FEntrtyMemo")
	public String getFEntrtyMemo() {
		return FEntrtyMemo;
	}
	@JSONField(name = "FMtoNo")
	public String getFMtoNo() {
		return FMtoNo;
	}
	@JSONField(name = "FBaseAppQty")
	public String getFBaseAppQty() {
		return FBaseAppQty;
	}
	@JSONField(name = "FKeeperTypeId")
	public String getFKeeperTypeId() {
		return FKeeperTypeId;
	}
	@JSONField(name = "FKeeperId")
	public CloudCommonF7Bean getFKeeperId() {
		return FKeeperId;
	}
	@JSONField(name = "FExpiryDate")
	public String getFExpiryDate() {
		return FExpiryDate;
	}
	@JSONField(name = "F_abc_Text")
	public String getF_abc_Text() {
		return F_abc_Text;
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
	public void setFBomId(CloudCommonF7Bean bomId) {
		FBomId = bomId;
	}
	public void setFUnitID(CloudCommonF7Bean unitID) {
		FUnitID = unitID;
	}
	public void setFAppQty(String appQty) {
		FAppQty = appQty;
	}
	public void setFActualQty(String actualQty) {
		FActualQty = actualQty;
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
	public void setFStockUnitId(CloudCommonF7Bean stockUnitId) {
		FStockUnitId = stockUnitId;
	}
	public void setFStockActualQty(String stockActualQty) {
		FStockActualQty = stockActualQty;
	}
	public void setFOwnerTypeId(String ownerTypeId) {
		FOwnerTypeId = ownerTypeId;
	}
	public void setFEntryWorkShopId(CloudCommonF7Bean entryWorkShopId) {
		FEntryWorkShopId = entryWorkShopId;
	}
	public void setFOwnerId(CloudCommonF7Bean ownerId) {
		FOwnerId = ownerId;
	}
	public void setFExtAuxUnitId(CloudCommonF7Bean extAuxUnitId) {
		FExtAuxUnitId = extAuxUnitId;
	}
	public void setFExtAuxUnitQty(String extAuxUnitQty) {
		FExtAuxUnitQty = extAuxUnitQty;
	}
	public void setFPrice(String price) {
		FPrice = price;
	}
	public void setFAmount(String amount) {
		FAmount = amount;
	}
	public void setFParentOwnerTypeId(String parentOwnerTypeId) {
		FParentOwnerTypeId = parentOwnerTypeId;
	}
	public void setFParentOwnerId(CloudCommonF7Bean parentOwnerId) {
		FParentOwnerId = parentOwnerId;
	}
	public void setFBaseUnitId(CloudCommonF7Bean baseUnitId) {
		FBaseUnitId = baseUnitId;
	}
	public void setFServiceContext(String serviceContext) {
		FServiceContext = serviceContext;
	}
	public void setFBaseActualQty(String baseActualQty) {
		FBaseActualQty = baseActualQty;
	}
	public void setFStockStatusId(CloudCommonF7Bean stockStatusId) {
		FStockStatusId = stockStatusId;
	}
	public void setFProduceDate(String produceDate) {
		FProduceDate = produceDate;
	}
	public void setFSecUnitId(CloudCommonF7Bean secUnitId) {
		FSecUnitId = secUnitId;
	}
	public void setFSecActualQty(String secActualQty) {
		FSecActualQty = secActualQty;
	}
	public void setFEntrtyMemo(String entrtyMemo) {
		FEntrtyMemo = entrtyMemo;
	}
	public void setFMtoNo(String mtoNo) {
		FMtoNo = mtoNo;
	}
	public void setFBaseAppQty(String baseAppQty) {
		FBaseAppQty = baseAppQty;
	}
	public void setFKeeperTypeId(String keeperTypeId) {
		FKeeperTypeId = keeperTypeId;
	}
	public void setFKeeperId(CloudCommonF7Bean keeperId) {
		FKeeperId = keeperId;
	}
	public void setFExpiryDate(String expiryDate) {
		FExpiryDate = expiryDate;
	}
	public void setF_abc_Text(String text) {
		F_abc_Text = text;
	}
	
	
	
}
