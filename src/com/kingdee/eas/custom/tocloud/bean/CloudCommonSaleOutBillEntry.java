package com.kingdee.eas.custom.tocloud.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

/**
 * 结算单同步cloud销售出库单大分录
 * @author wlhl
 *
 */

@JSONType(orders = {"FENTRYID","FCustMatID","FMaterialID","FUnitID","FInventoryQty","FRealQty","FPrice",
		"FTaxPrice","FIsFree","FBomID","FProduceDate","FOwnerTypeID","FOwnerID","FLot","FExpiryDate","FTaxCombination",
		"FEntryTaxRate","FAuxUnitQty","FExtAuxUnitId","FExtAuxUnitQty","FStockID","FStockStatusID","FQualifyType","FMtoNo","FEntrynote",
		"FDiscountRate","FActQty","FSalUnitID","FSALUNITQTY","FSALBASEQTY","FPRICEBASEQTY","FProjectNo",
		"FOUTCONTROL","FRepairQty","FIsCreateProDoc","FEOwnerSupplierId","FIsOverLegalOrg","FESettleCustomerId",
		"FPriceListEntry","FARNOTJOINQTY","FQmEntryID","F_abc_Qty","FSOEntryId","FConvertEntryID","F_abc_Qty1"})
public class CloudCommonSaleOutBillEntry {


	@JSONField(ordinal=1,name = "FENTRYID")
	private String FENTRYID;
	
	//客户物料编码
	@JSONField(ordinal=2,name = "FCustMatID")
	private CloudCommonF7Bean FCustMatID;
	
	//物料编码
	@JSONField(ordinal=3,name = "FMaterialID")
	private CloudCommonF7Bean FMaterialID;
	
	//库存单位
	@JSONField(ordinal=4,name = "FUnitID")
	private CloudCommonF7Bean FUnitID;
	
	//当前库存
	@JSONField(ordinal=5,name = "FInventoryQty")
	private String FInventoryQty;
	
	//实发数量
	@JSONField(ordinal=6,name = "FRealQty")
	private String FRealQty;
	
	//单价
	@JSONField(ordinal=7,name = "FPrice")
	private String FPrice;
	
	//含税单价
	@JSONField(ordinal=8,name = "FTaxPrice")
	private String FTaxPrice;
	
	//是否赠品
	@JSONField(ordinal=9,name = "FIsFree")
	private String FIsFree;
	
	//BOM版本
	@JSONField(ordinal=10,name = "FBomID")
	private CloudCommonF7Bean FBomID;
	
	//生产日期
	@JSONField(ordinal=11,name = "FProduceDate")
	private String FProduceDate;
	
	//货主类型
	@JSONField(ordinal=12,name = "FOwnerTypeID")
	private String FOwnerTypeID;
	
	//货主
	@JSONField(ordinal=13,name = "FOwnerID")
	private CloudCommonF7Bean FOwnerID;
	
	//批号
	@JSONField(ordinal=14,name = "FLot")
	private CloudCommonF7Bean FLot;
	
	//有效期至
	@JSONField(ordinal=15,name = "FExpiryDate")
	private String FExpiryDate;
	
	//税组合
	@JSONField(ordinal=16,name = "FTaxCombination")
	private CloudCommonF7Bean FTaxCombination;
	
	//税率%
	@JSONField(ordinal=17,name = "FEntryTaxRate")
	private String FEntryTaxRate;
	
	//库存辅单位数量
	@JSONField(ordinal=18,name = "FAuxUnitQty")
	private String FAuxUnitQty;
	
	//辅单位
	@JSONField(ordinal=19,name = "FExtAuxUnitId")
	private CloudCommonF7Bean FExtAuxUnitId;
	
	//实发数量(辅单位)
	@JSONField(ordinal=20,name = "FExtAuxUnitQty")
	private String FExtAuxUnitQty;
	
	//仓库
	@JSONField(ordinal=21,name = "FStockID")
	private CloudCommonF7Bean FStockID;
	
	//库存状态
	@JSONField(ordinal=22,name = "FStockStatusID")
	private CloudCommonF7Bean FStockStatusID;
	
	//质量类型
	@JSONField(ordinal=23,name = "FQualifyType")
	private String FQualifyType;
	
	//计划跟踪号
	@JSONField(ordinal=24,name = "FMtoNo")
	private String FMtoNo;
	
	//备注
	@JSONField(ordinal=25,name = "FEntrynote")
	private String FEntrynote;
	
	//折扣率%
	@JSONField(ordinal=26,name = "FDiscountRate")
	private String FDiscountRate;

	//实收数量
	@JSONField(ordinal=27,name = "FActQty")
	private String FActQty;
	
	//销售单位
	@JSONField(ordinal=28,name = "FSalUnitID")
	private CloudCommonF7Bean FSalUnitID;
	
	//销售数量
	@JSONField(ordinal=29,name = "FSALUNITQTY")
	private String FSALUNITQTY;

	//销售基本数量
	@JSONField(ordinal=30,name = "FSALBASEQTY")
	private String FSALBASEQTY;

	//计价基本数量
	@JSONField(ordinal=31,name = "FPRICEBASEQTY")
	private String FPRICEBASEQTY;

	//项目编号
	@JSONField(ordinal=32,name = "FProjectNo")
	private String FProjectNo;

	//控制出库数量
	@JSONField(ordinal=33,name = "FOUTCONTROL")
	private String FOUTCONTROL;
	
	//补货数量
	@JSONField(ordinal=34,name = "FRepairQty")
	private String FRepairQty;
	
	//是否生成产品档案
	@JSONField(ordinal=35,name = "FIsCreateProDoc")
	private String FIsCreateProDoc;
	
	//明细货主供应商
	@JSONField(ordinal=36,name = "FEOwnerSupplierId")
	private CloudCommonF7Bean FEOwnerSupplierId;
	
	//是否跨法人交易
	@JSONField(ordinal=37,name = "FIsOverLegalOrg")
	private String FIsOverLegalOrg;
	
	//明细结算组织客户
	@JSONField(ordinal=38,name = "FESettleCustomerId")
	private CloudCommonF7Bean FESettleCustomerId;
	
	//行价目表
	@JSONField(ordinal=39,name = "FPriceListEntry")
	private CloudCommonF7Bean FPriceListEntry;
	
	//未关联应收数量（计价单位）
	@JSONField(ordinal=40,name = "FARNOTJOINQTY")
	private String FARNOTJOINQTY;

	//库存请检单EntryID
	@JSONField(ordinal=41,name = "FQmEntryID")
	private String FQmEntryID;

	//毛鸡只数
	@JSONField(ordinal=42,name = "F_abc_Qty")
	private String F_abc_Qty;
	
	//销售订单EntryId
	@JSONField(ordinal=43,name = "FSOEntryId")
	private String FSOEntryId;

	//库存状态转换单ENTRYID
	@JSONField(ordinal=44,name = "FConvertEntryID")
	private String FConvertEntryID;

	
	//单只毛鸡重量
	@JSONField(ordinal=45,name = "F_abc_Qty1")
	private String F_abc_Qty1;
	
	
	@JSONField(name = "F_abc_Qty")
	public String getF_abc_Qty() {
		return F_abc_Qty;
	}
	public void setF_abc_Qty(String qty) {
		F_abc_Qty = qty;
	}
	public void setF_abc_Qty1(String qty1) {
		F_abc_Qty1 = qty1;
	}
	@JSONField(name = "F_abc_Qty1")
	public String getF_abc_Qty1() {
		return F_abc_Qty1;
	}
	@JSONField(name = "FENTRYID")
	public String getFENTRYID() {
		return FENTRYID;
	}
	@JSONField(name = "FCustMatID")
	public CloudCommonF7Bean getFCustMatID() {
		return FCustMatID;
	}
	@JSONField(name = "FMaterialID")
	public CloudCommonF7Bean getFMaterialID() {
		return FMaterialID;
	}
	@JSONField(name = "FUnitID")
	public CloudCommonF7Bean getFUnitID() {
		return FUnitID;
	}
	@JSONField(name = "FInventoryQty")
	public String getFInventoryQty() {
		return FInventoryQty;
	}
	@JSONField(name = "FRealQty")
	public String getFRealQty() {
		return FRealQty;
	}
	@JSONField(name = "FPrice")
	public String getFPrice() {
		return FPrice;
	}
	@JSONField(name = "FTaxPrice")
	public String getFTaxPrice() {
		return FTaxPrice;
	}
	@JSONField(name = "FIsFree")
	public String getFIsFree() {
		return FIsFree;
	}
	@JSONField(name = "FBomID")
	public CloudCommonF7Bean getFBomID() {
		return FBomID;
	}
	@JSONField(name = "FProduceDate")
	public String getFProduceDate() {
		return FProduceDate;
	}
	@JSONField(name = "FOwnerTypeID")
	public String getFOwnerTypeID() {
		return FOwnerTypeID;
	}
	@JSONField(name = "FOwnerID")
	public CloudCommonF7Bean getFOwnerID() {
		return FOwnerID;
	}
	@JSONField(name = "FLot")
	public CloudCommonF7Bean getFLot() {
		return FLot;
	}
	@JSONField(name = "FExpiryDate")
	public String getFExpiryDate() {
		return FExpiryDate;
	}
	@JSONField(name = "FTaxCombination")
	public CloudCommonF7Bean getFTaxCombination() {
		return FTaxCombination;
	}
	@JSONField(name = "FEntryTaxRate")
	public String getFEntryTaxRate() {
		return FEntryTaxRate;
	}
	@JSONField(name = "FAuxUnitQty")
	public String getFAuxUnitQty() {
		return FAuxUnitQty;
	}
	@JSONField(name = "FExtAuxUnitId")
	public CloudCommonF7Bean getFExtAuxUnitId() {
		return FExtAuxUnitId;
	}
	@JSONField(name = "FExtAuxUnitQty")
	public String getFExtAuxUnitQty() {
		return FExtAuxUnitQty;
	}
	@JSONField(name = "FStockID")
	public CloudCommonF7Bean getFStockID() {
		return FStockID;
	}
	@JSONField(name = "FStockStatusID")
	public CloudCommonF7Bean getFStockStatusID() {
		return FStockStatusID;
	}
	@JSONField(name = "FQualifyType")
	public String getFQualifyType() {
		return FQualifyType;
	}
	@JSONField(name = "FMtoNo")
	public String getFMtoNo() {
		return FMtoNo;
	}
	@JSONField(name = "FEntrynote")
	public String getFEntrynote() {
		return FEntrynote;
	}
	@JSONField(name = "FDiscountRate")
	public String getFDiscountRate() {
		return FDiscountRate;
	}
	@JSONField(name = "FActQty")
	public String getFActQty() {
		return FActQty;
	}
	@JSONField(name = "FSalUnitID")
	public CloudCommonF7Bean getFSalUnitID() {
		return FSalUnitID;
	}
	@JSONField(name = "FSALUNITQTY")
	public String getFSALUNITQTY() {
		return FSALUNITQTY;
	}
	@JSONField(name = "FSALBASEQTY")
	public String getFSALBASEQTY() {
		return FSALBASEQTY;
	}
	@JSONField(name = "FPRICEBASEQTY")
	public String getFPRICEBASEQTY() {
		return FPRICEBASEQTY;
	}
	@JSONField(name = "FProjectNo")
	public String getFProjectNo() {
		return FProjectNo;
	}
	@JSONField(name = "FOUTCONTROL")
	public String getFOUTCONTROL() {
		return FOUTCONTROL;
	}
	@JSONField(name = "FRepairQty")
	public String getFRepairQty() {
		return FRepairQty;
	}
	@JSONField(name = "FIsCreateProDoc")
	public String getFIsCreateProDoc() {
		return FIsCreateProDoc;
	}
	@JSONField(name = "FEOwnerSupplierId")
	public CloudCommonF7Bean getFEOwnerSupplierId() {
		return FEOwnerSupplierId;
	}
	@JSONField(name = "FIsOverLegalOrg")
	public String getFIsOverLegalOrg() {
		return FIsOverLegalOrg;
	}
	@JSONField(name = "FESettleCustomerId")
	public CloudCommonF7Bean getFESettleCustomerId() {
		return FESettleCustomerId;
	}
	@JSONField(name = "FPriceListEntry")
	public CloudCommonF7Bean getFPriceListEntry() {
		return FPriceListEntry;
	}
	@JSONField(name = "FARNOTJOINQTY")
	public String getFARNOTJOINQTY() {
		return FARNOTJOINQTY;
	}
	@JSONField(name = "FQmEntryID")
	public String getFQmEntryID() {
		return FQmEntryID;
	}
	@JSONField(name = "FSOEntryId")
	public String getFSOEntryId() {
		return FSOEntryId;
	}
	@JSONField(name = "FConvertEntryID")
	public String getFConvertEntryID() {
		return FConvertEntryID;
	}
	public void setFENTRYID(String fentryid) {
		FENTRYID = fentryid;
	}
	public void setFCustMatID(CloudCommonF7Bean custMatID) {
		FCustMatID = custMatID;
	}
	public void setFMaterialID(CloudCommonF7Bean materialID) {
		FMaterialID = materialID;
	}
	public void setFUnitID(CloudCommonF7Bean unitID) {
		FUnitID = unitID;
	}
	public void setFInventoryQty(String inventoryQty) {
		FInventoryQty = inventoryQty;
	}
	public void setFRealQty(String realQty) {
		FRealQty = realQty;
	}
	public void setFPrice(String price) {
		FPrice = price;
	}
	public void setFTaxPrice(String taxPrice) {
		FTaxPrice = taxPrice;
	}
	public void setFIsFree(String isFree) {
		FIsFree = isFree;
	}
	public void setFBomID(CloudCommonF7Bean bomID) {
		FBomID = bomID;
	}
	public void setFProduceDate(String produceDate) {
		FProduceDate = produceDate;
	}
	public void setFOwnerTypeID(String ownerTypeID) {
		FOwnerTypeID = ownerTypeID;
	}
	public void setFOwnerID(CloudCommonF7Bean ownerID) {
		FOwnerID = ownerID;
	}
	public void setFLot(CloudCommonF7Bean lot) {
		FLot = lot;
	}
	public void setFExpiryDate(String expiryDate) {
		FExpiryDate = expiryDate;
	}
	public void setFTaxCombination(CloudCommonF7Bean taxCombination) {
		FTaxCombination = taxCombination;
	}
	public void setFEntryTaxRate(String entryTaxRate) {
		FEntryTaxRate = entryTaxRate;
	}
	public void setFAuxUnitQty(String auxUnitQty) {
		FAuxUnitQty = auxUnitQty;
	}
	public void setFExtAuxUnitId(CloudCommonF7Bean extAuxUnitId) {
		FExtAuxUnitId = extAuxUnitId;
	}
	public void setFExtAuxUnitQty(String extAuxUnitQty) {
		FExtAuxUnitQty = extAuxUnitQty;
	}
	public void setFStockID(CloudCommonF7Bean stockID) {
		FStockID = stockID;
	}
	public void setFStockStatusID(CloudCommonF7Bean stockStatusID) {
		FStockStatusID = stockStatusID;
	}
	public void setFQualifyType(String qualifyType) {
		FQualifyType = qualifyType;
	}
	public void setFMtoNo(String mtoNo) {
		FMtoNo = mtoNo;
	}
	public void setFEntrynote(String entrynote) {
		FEntrynote = entrynote;
	}
	public void setFDiscountRate(String discountRate) {
		FDiscountRate = discountRate;
	}
	public void setFActQty(String actQty) {
		FActQty = actQty;
	}
	public void setFSalUnitID(CloudCommonF7Bean salUnitID) {
		FSalUnitID = salUnitID;
	}
	public void setFSALUNITQTY(String fsalunitqty) {
		FSALUNITQTY = fsalunitqty;
	}
	public void setFSALBASEQTY(String fsalbaseqty) {
		FSALBASEQTY = fsalbaseqty;
	}
	public void setFPRICEBASEQTY(String fpricebaseqty) {
		FPRICEBASEQTY = fpricebaseqty;
	}
	public void setFProjectNo(String projectNo) {
		FProjectNo = projectNo;
	}
	public void setFOUTCONTROL(String foutcontrol) {
		FOUTCONTROL = foutcontrol;
	}
	public void setFRepairQty(String repairQty) {
		FRepairQty = repairQty;
	}
	public void setFIsCreateProDoc(String isCreateProDoc) {
		FIsCreateProDoc = isCreateProDoc;
	}
	public void setFEOwnerSupplierId(CloudCommonF7Bean ownerSupplierId) {
		FEOwnerSupplierId = ownerSupplierId;
	}
	public void setFIsOverLegalOrg(String isOverLegalOrg) {
		FIsOverLegalOrg = isOverLegalOrg;
	}
	public void setFESettleCustomerId(CloudCommonF7Bean settleCustomerId) {
		FESettleCustomerId = settleCustomerId;
	}
	public void setFPriceListEntry(CloudCommonF7Bean priceListEntry) {
		FPriceListEntry = priceListEntry;
	}
	public void setFARNOTJOINQTY(String farnotjoinqty) {
		FARNOTJOINQTY = farnotjoinqty;
	}
	public void setFQmEntryID(String qmEntryID) {
		FQmEntryID = qmEntryID;
	}
	public void setFSOEntryId(String entryId) {
		FSOEntryId = entryId;
	}
	public void setFConvertEntryID(String convertEntryID) {
		FConvertEntryID = convertEntryID;
	}


}