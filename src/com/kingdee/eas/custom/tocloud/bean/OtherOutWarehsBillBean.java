package com.kingdee.eas.custom.tocloud.bean;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

/**
 * 其他出库单表头字段
 * @author Administrator
 *
 */
@JSONType(orders = {"FID","FBillNo","FBillTypeID","FStockOrgId","FPickOrgId",
		"FStockDirect","FDate","FCustId","FDeptId","FPickerId","FStockerId",
		"FStockerGroupId","FBizType","FOwnerTypeIdHead","FOwnerIdHead",
		"FNote","FBaseCurrId","FScanBox","F_abc_Base","FEntity"})
public class OtherOutWarehsBillBean {
	
	//id
	@JSONField(ordinal=1,name = "FID")
	private String FID;
	
	//单据编码
	@JSONField(ordinal=2,name = "FBillNo")
	private String FBillNo;
	
    //单据类型
	@JSONField(ordinal=3,name = "FBillTypeID")
	private CloudCommonF7Bean FBillTypeID;
	
	//库存组织
	@JSONField(ordinal=4,name = "FStockOrgId")
	private CloudCommonF7Bean FStockOrgId;
	
	//领用组织
	@JSONField(ordinal=5,name = "FPickOrgId")
	private CloudCommonF7Bean FPickOrgId;
	
	//库存方向
	@JSONField(ordinal=6,name = "FStockDirect")
	private String FStockDirect;
	
	//日期
	@JSONField(ordinal=7,name = "FDate")
	private String FDate;
	
	//客户
	@JSONField(ordinal=8,name = "FCustId")
	private CloudCommonF7Bean FCustId;
	
	//领料部门
	@JSONField(ordinal=9,name = "FDeptId")
	private CloudCommonF7Bean FDeptId;
	
	//领料人
	@JSONField(ordinal=10,name = "FPickerId")
	private CloudCommonStaffF7Bean FPickerId;
	
	//仓管员
	@JSONField(ordinal=11,name = "FStockerId")
	private CloudCommonF7Bean FStockerId;
	
	//库存组
	@JSONField(ordinal=12,name = "FStockerGroupId")
	private CloudCommonF7Bean FStockerGroupId;

	//业务类型
	@JSONField(ordinal=13,name = "FBizType")
	private String FBizType;
	
	//货主类型
	@JSONField(ordinal=14,name = "FOwnerTypeIdHead")
	private String FOwnerTypeIdHead;
	
	//货主
	@JSONField(ordinal=15,name = "FOwnerIdHead")
	private CloudCommonF7Bean FOwnerIdHead;
	
	//备注
	@JSONField(ordinal=16,name = "FNote")
	private String FNote;
	
	//本位币
	@JSONField(ordinal=17,name = "FBaseCurrId")
	private CloudCommonF7Bean FBaseCurrId;
	
	//序列号上传
	@JSONField(ordinal=18,name = "FScanBox")
	private String FScanBox;
	
	//出库类型
	@JSONField(ordinal=19,name = "F_abc_Base")
	private CloudCommonF7Bean F_abc_Base;
	
	//分录id
	@JSONField(ordinal=20,name = "FEntity")
	private JSONArray FEntity;

	
	
	
	
	
	@JSONField(name = "FID")
	public String getFID() {
		return FID;
	}
	@JSONField(name = "FBillNo")
	public String getFBillNo() {
		return FBillNo;
	}
	@JSONField(name = "FBillTypeID")
	public CloudCommonF7Bean getFBillTypeID() {
		return FBillTypeID;
	}
	@JSONField(name = "FStockOrgId")
	public CloudCommonF7Bean getFStockOrgId() {
		return FStockOrgId;
	}
	@JSONField(name = "FPickOrgId")
	public CloudCommonF7Bean getFPickOrgId() {
		return FPickOrgId;
	}
	@JSONField(name = "FStockDirect")
	public String getFStockDirect() {
		return FStockDirect;
	}
	@JSONField(name = "FDate")
	public String getFDate() {
		return FDate;
	}
	@JSONField(name = "FCustId")
	public CloudCommonF7Bean getFCustId() {
		return FCustId;
	}
	@JSONField(name = "FDeptId")
	public CloudCommonF7Bean getFDeptId() {
		return FDeptId;
	}
	@JSONField(name = "FPickerId")
	public CloudCommonStaffF7Bean getFPickerId() {
		return FPickerId;
	}
	@JSONField(name = "FStockerId")
	public CloudCommonF7Bean getFStockerId() {
		return FStockerId;
	}
	@JSONField(name = "FStockerGroupId")
	public CloudCommonF7Bean getFStockerGroupId() {
		return FStockerGroupId;
	}
	@JSONField(name = "FBizType")
	public String getFBizType() {
		return FBizType;
	}
	@JSONField(name = "FOwnerTypeIdHead")
	public String getFOwnerTypeIdHead() {
		return FOwnerTypeIdHead;
	}
	@JSONField(name = "FOwnerIdHead")
	public CloudCommonF7Bean getFOwnerIdHead() {
		return FOwnerIdHead;
	}
	@JSONField(name = "FNote")
	public String getFNote() {
		return FNote;
	}
	@JSONField(name = "FBaseCurrId")
	public CloudCommonF7Bean getFBaseCurrId() {
		return FBaseCurrId;
	}
	@JSONField(name = "FScanBox")
	public String getFScanBox() {
		return FScanBox;
	}
	@JSONField(name = "F_abc_Base")
	public CloudCommonF7Bean getF_abc_Base() {
		return F_abc_Base;
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
	public void setFBillTypeID(CloudCommonF7Bean billTypeID) {
		FBillTypeID = billTypeID;
	}
	public void setFStockOrgId(CloudCommonF7Bean stockOrgId) {
		FStockOrgId = stockOrgId;
	}
	public void setFPickOrgId(CloudCommonF7Bean pickOrgId) {
		FPickOrgId = pickOrgId;
	}
	public void setFStockDirect(String stockDirect) {
		FStockDirect = stockDirect;
	}
	public void setFDate(String date) {
		FDate = date;
	}
	public void setFCustId(CloudCommonF7Bean custId) {
		FCustId = custId;
	}
	public void setFDeptId(CloudCommonF7Bean deptId) {
		FDeptId = deptId;
	}
	public void setFPickerId(CloudCommonStaffF7Bean pickerId) {
		FPickerId = pickerId;
	}
	public void setFStockerId(CloudCommonF7Bean stockerId) {
		FStockerId = stockerId;
	}
	public void setFStockerGroupId(CloudCommonF7Bean stockerGroupId) {
		FStockerGroupId = stockerGroupId;
	}
	public void setFBizType(String bizType) {
		FBizType = bizType;
	}
	public void setFOwnerTypeIdHead(String ownerTypeIdHead) {
		FOwnerTypeIdHead = ownerTypeIdHead;
	}
	public void setFOwnerIdHead(CloudCommonF7Bean ownerIdHead) {
		FOwnerIdHead = ownerIdHead;
	}
	public void setFNote(String note) {
		FNote = note;
	}
	public void setFBaseCurrId(CloudCommonF7Bean baseCurrId) {
		FBaseCurrId = baseCurrId;
	}
	public void setFScanBox(String scanBox) {
		FScanBox = scanBox;
	}
	public void setF_abc_Base(CloudCommonF7Bean base) {
		F_abc_Base = base;
	}
	public void setFEntity(JSONArray entity) {
		FEntity = entity;
	}
	
	
	
	
	
	
	
	
	
	
	
}
