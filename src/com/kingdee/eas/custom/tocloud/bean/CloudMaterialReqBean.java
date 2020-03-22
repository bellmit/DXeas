package com.kingdee.eas.custom.tocloud.bean;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

/**
 * 领料出库单
 * @author MC
 *
 */
@JSONType(orders = {"FID","FBillNo","FBillType","FDate","FDescription",
		"FStockOrgId","FStockerGroupId","FStockerId","FPickerId","FCurrId",
		"FOwnerTypeId0","FOwnerId0","FPrdOrgId","FWorkShopId",
		"FTransferBizTypeId","FScanBox","F_F_BANZ1","FEntity"})
public class CloudMaterialReqBean {
	
	@JSONField(ordinal=1,name = "FID")
	private String FID;
	//单据编号
	@JSONField(ordinal=2,name = "FBillNo")
	private String FBillNo;
	//单据类型(必填项)
	@JSONField(ordinal=3,name = "FBillType")
	private CloudCommonF7Bean FBillType;
	//日期
	@JSONField(ordinal=4,name = "FDate")
	private String FDate;
	//备注
	@JSONField(ordinal=5,name = "FDescription")
	private String FDescription;
	//发料组织
	@JSONField(ordinal=6,name = "FStockOrgId")
	private CloudCommonF7Bean FStockOrgId;
	
	//库存组
	@JSONField(ordinal=7,name = "FStockerGroupId")
    private CloudCommonF7Bean FStockerGroupId;
	
	//仓管员
	@JSONField(ordinal=8,name = "FStockerId")
	private CloudCommonF7Bean FStockerId;
	//领料人
	@JSONField(ordinal=9,name = "FPickerId")
	private CloudCommonStaffF7Bean FPickerId;
	//本位币
	@JSONField(ordinal=10,name = "FCurrId")
	private CloudCommonF7Bean FCurrId;
	//货主类型(必填项)
	@JSONField(ordinal=11,name = "FOwnerTypeId0")
	private String FOwnerTypeId0;
	//货主(必填项)
	@JSONField(ordinal=12,name = "FOwnerId0")
	private CloudCommonF7Bean FOwnerId0;
	//生产组织 (必填项)
	@JSONField(ordinal=13,name = "FPrdOrgId")
	private CloudCommonF7Bean FPrdOrgId;
	//生产车间(必填项)
	@JSONField(ordinal=14,name = "FWorkShopId")
	private CloudCommonF7Bean FWorkShopId;
	//跨组织业务类型
	@JSONField(ordinal=15,name = "FTransferBizTypeId")
	private CloudCommonF7Bean FTransferBizTypeId;
	//序列号上传
	@JSONField(ordinal=16,name = "FScanBox")
	private String FScanBox;
	//班 次
	@JSONField(ordinal=17,name = "F_F_BANZ1")
	private CloudCommonF7Bean F_F_BANZ1;
	//物料分录
	@JSONField(ordinal=18,name = "FEntity")
	private JSONArray FEntity;
	
	
	
	
	
	
	@JSONField(name = "FID")
	public String getFID() {
		return FID;
	}
	@JSONField(name = "FBillNo")
	public String getFBillNo() {
		return FBillNo;
	}
	@JSONField(name = "FBillType")
	public CloudCommonF7Bean getFBillType() {
		return FBillType;
	}
	@JSONField(name = "FDate")
	public String getFDate() {
		return FDate;
	}
	@JSONField(name = "FDescription")
	public String getFDescription() {
		return FDescription;
	}
	@JSONField(name = "FStockOrgId")
	public CloudCommonF7Bean getFStockOrgId() {
		return FStockOrgId;
	}
	@JSONField(name = "FStockerGroupId")
	public CloudCommonF7Bean getFStockerGroupId() {
		return FStockerGroupId;
	}
	@JSONField(name = "FStockerId")
	public CloudCommonF7Bean getFStockerId() {
		return FStockerId;
	}
	@JSONField(name = "FPickerId")
	public CloudCommonStaffF7Bean getFPickerId() {
		return FPickerId;
	}
	@JSONField(name = "FCurrId")
	public CloudCommonF7Bean getFCurrId() {
		return FCurrId;
	}
	@JSONField(name = "FOwnerTypeId0")
	public String getFOwnerTypeId0() {
		return FOwnerTypeId0;
	}
	@JSONField(name = "FOwnerId0")
	public CloudCommonF7Bean getFOwnerId0() {
		return FOwnerId0;
	}
	@JSONField(name = "FPrdOrgId")
	public CloudCommonF7Bean getFPrdOrgId() {
		return FPrdOrgId;
	}
	@JSONField(name = "FWorkShopId")
	public CloudCommonF7Bean getFWorkShopId() {
		return FWorkShopId;
	}
	@JSONField(name = "FTransferBizTypeId")
	public CloudCommonF7Bean getFTransferBizTypeId() {
		return FTransferBizTypeId;
	}
	@JSONField(name = "FScanBox")
	public String getFScanBox() {
		return FScanBox;
	}
	@JSONField(name = "F_F_BANZ1")
	public CloudCommonF7Bean getF_F_BANZ1() {
		return F_F_BANZ1;
	}
	@JSONField(name = "FEntity")
	public JSONArray getFEntity() {
		return FEntity;
	}
	public void setFID(String fid) {
		FID = fid;
	}
	public void setFBillNo(String billNo) {
		FBillNo = billNo;
	}
	public void setFBillType(CloudCommonF7Bean billType) {
		FBillType = billType;
	}
	public void setFDate(String date) {
		FDate = date;
	}
	public void setFDescription(String description) {
		FDescription = description;
	}
	public void setFStockOrgId(CloudCommonF7Bean stockOrgId) {
		FStockOrgId = stockOrgId;
	}
	public void setFStockerGroupId(CloudCommonF7Bean stockerGroupId) {
		FStockerGroupId = stockerGroupId;
	}
	public void setFStockerId(CloudCommonF7Bean stockerId) {
		FStockerId = stockerId;
	}
	public void setFPickerId(CloudCommonStaffF7Bean pickerId) {
		FPickerId = pickerId;
	}
	public void setFCurrId(CloudCommonF7Bean currId) {
		FCurrId = currId;
	}
	public void setFOwnerTypeId0(String ownerTypeId0) {
		FOwnerTypeId0 = ownerTypeId0;
	}
	public void setFOwnerId0(CloudCommonF7Bean ownerId0) {
		FOwnerId0 = ownerId0;
	}
	public void setFPrdOrgId(CloudCommonF7Bean prdOrgId) {
		FPrdOrgId = prdOrgId;
	}
	public void setFWorkShopId(CloudCommonF7Bean workShopId) {
		FWorkShopId = workShopId;
	}
	public void setFTransferBizTypeId(CloudCommonF7Bean transferBizTypeId) {
		FTransferBizTypeId = transferBizTypeId;
	}
	public void setFScanBox(String scanBox) {
		FScanBox = scanBox;
	}
	public void setF_F_BANZ1(CloudCommonF7Bean f_f_banz1) {
		F_F_BANZ1 = f_f_banz1;
	}
	public void setFEntity(JSONArray entity) {
		FEntity = entity;
	}
	
	
}
