package com.kingdee.eas.custom.tocloud.bean;

import java.math.BigDecimal;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

/**
 * 简单生产入库单
 * @author MC
 *
 */
@JSONType(orders = {"FID","FBillNo","FStockerGroupId","FStockerId","FStockOrgId",
		"FOwnerId0","FOwnerTypeId0","FTransferBizTypeId","FScanBox","FBillType",
		"FPrdOrgId","FDate","F_BANZ2","FCurrId",
		"FDescription","FEntity"})
		public class CloudManufactureRecBean {

	@JSONField(ordinal=1,name = "FID")
	private String FID;
	//单据编码
	@JSONField(ordinal=2,name = "FBillNo")
	private String FBillNo;

	//库存组
	@JSONField(ordinal=3,name = "FStockerGroupId")
	private CloudCommonF7Bean FStockerGroupId;

	//仓管员
	@JSONField(ordinal=4,name = "FStockerId")
	private CloudCommonF7Bean FStockerId;

	//入库组织
	@JSONField(ordinal=5,name = "FStockOrgId")
	private CloudCommonF7Bean FStockOrgId;
	//货主
	@JSONField(ordinal=6,name = "FOwnerId0")
	private CloudCommonF7Bean FOwnerId0;
	//货主类型
	@JSONField(ordinal=7,name = "FOwnerTypeId0")
	private String FOwnerTypeId0;

	//跨组织业务类型
	@JSONField(ordinal=8,name = "FTransferBizTypeId")
	private CloudCommonF7Bean FTransferBizTypeId;

	//序列号上传
	@JSONField(ordinal=9,name = "FScanBox")
	private String FScanBox;

	//单据类型
	@JSONField(ordinal=10,name = "FBillType")
	private CloudCommonF7Bean FBillType;
	//生产组织
	@JSONField(ordinal=11,name = "FPrdOrgId")
	private CloudCommonF7Bean FPrdOrgId;
	//日期
	@JSONField(ordinal=12,name = "FDate")
	private String FDate;
	//班组
	@JSONField(ordinal=13,name = "F_BANZ2")
	private CloudCommonF7Bean F_BANZ2;
	//本位币
	@JSONField(ordinal=14,name = "FCurrId")
	private CloudCommonF7Bean FCurrId;

	//备注
	@JSONField(ordinal=15,name = "FDescription")
	private String FDescription;
	//分录

	@JSONField(ordinal=16,name = "FEntity")
	private JSONArray FEntity;

	@JSONField(name = "FCurrId")
	public CloudCommonF7Bean getFCurrId() {
		return FCurrId;
	}
	public void setFCurrId(CloudCommonF7Bean currId) {
		FCurrId = currId;
	}
	@JSONField(name = "FDescription")
	public String getFDescription() {
		return FDescription;
	}
	public void setFDescription(String description) {
		FDescription = description;
	}
	@JSONField(name = "FID")
	public String getFID() {
		return FID;
	}
	public void setFID(String fid) {
		FID = fid;
	}
	@JSONField(name = "FStockOrgId")
	public CloudCommonF7Bean getFStockOrgId() {
		return FStockOrgId;
	}
	public void setFStockOrgId(CloudCommonF7Bean stockOrgId) {
		FStockOrgId = stockOrgId;
	}
	@JSONField(name = "FOwnerId0")
	public CloudCommonF7Bean getFOwnerId0() {
		return FOwnerId0;
	}
	public void setFOwnerId0(CloudCommonF7Bean ownerId0) {
		FOwnerId0 = ownerId0;
	}
	@JSONField(name = "FBillType")
	public CloudCommonF7Bean getFBillType() {
		return FBillType;
	}
	public void setFBillType(CloudCommonF7Bean billType) {
		FBillType = billType;
	}
	@JSONField(name = "FPrdOrgId")
	public CloudCommonF7Bean getFPrdOrgId() {
		return FPrdOrgId;
	}
	public void setFPrdOrgId(CloudCommonF7Bean prdOrgId) {
		FPrdOrgId = prdOrgId;
	}
	@JSONField(name = "FDate")
	public String getFDate() {
		return FDate;
	}
	public void setFDate(String bizdate) {
		FDate = bizdate;
	}
	@JSONField(name = "F_BANZ2")
	public CloudCommonF7Bean getF_BANZ2() {
		return F_BANZ2;
	}
	public void setF_BANZ2(CloudCommonF7Bean f_BANZ2) {
		F_BANZ2 = f_BANZ2;
	}
	@JSONField(name = "FEntity")
	public JSONArray getFEntity() {
		return FEntity;
	}
	public void setFEntity(JSONArray entity) {
		FEntity = entity;
	}
	@JSONField(name = "FBillNo")
	public String getFBillNo() {
		return FBillNo;
	}
	public void setFBillNo(String billNo) {
		FBillNo = billNo;
	}
	@JSONField(name = "FStockerGroupId")
	public CloudCommonF7Bean getFStockerGroupId() {
		return FStockerGroupId;
	}
	public void setFStockerGroupId(CloudCommonF7Bean stockerGroupId) {
		FStockerGroupId = stockerGroupId;
	}
	@JSONField(name = "FStockerId")
	public CloudCommonF7Bean getFStockerId() {
		return FStockerId;
	}
	public void setFStockerId(CloudCommonF7Bean stockerId) {
		FStockerId = stockerId;
	}
	@JSONField(name = "FTransferBizTypeId")
	public CloudCommonF7Bean getFTransferBizTypeId() {
		return FTransferBizTypeId;
	}
	public void setFTransferBizTypeId(CloudCommonF7Bean transferBizTypeId) {
		FTransferBizTypeId = transferBizTypeId;
	}
	@JSONField(name = "FOwnerTypeId0")
	public String getFOwnerTypeId0() {
		return FOwnerTypeId0;
	}
	public void setFOwnerTypeId0(String ownerTypeId0) {
		FOwnerTypeId0 = ownerTypeId0;
	}
	@JSONField(name = "FScanBox")
	public String getFScanBox() {
		return FScanBox;
	}
	public void setFScanBox(String scanBox) {
		FScanBox = scanBox;
	}

}
