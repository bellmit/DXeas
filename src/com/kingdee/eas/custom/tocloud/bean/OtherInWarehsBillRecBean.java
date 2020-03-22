package com.kingdee.eas.custom.tocloud.bean;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

/**
 * 其他入库单表头实体
 * @author Administrator
 *
 */
@JSONType(orders = {"FID","FBillNo","FBillTypeID","FStockOrgId","FStockDirect",
		"FDate","FSUPPLIERID","FDEPTID","FACCEPTANCE","FSTOCKERID","FSTOCKERGROUPID",
		"FOwnerTypeIdHead","FOwnerIdHead","FNOTE","FBaseCurrId","FScanBox","FEntity"})
public class OtherInWarehsBillRecBean {

	//表头ID
	@JSONField(ordinal=1,name = "FID")
	private String FID;
	
	//编号
	@JSONField(ordinal=2,name = "FBillNo")
	private String FBillNo;
	
	//单据类型
	@JSONField(ordinal=3,name = "FBillTypeID")
	private CloudCommonF7Bean FBillTypeID;
	
	//库存组织
	@JSONField(ordinal=4,name = "FStockOrgId")
	private CloudCommonF7Bean FStockOrgId;
	
	//库存方向
	@JSONField(ordinal=5,name = "FStockDirect")
	private String FStockDirect;
	
	//日期
	@JSONField(ordinal=6,name = "FDate")
	private String FDate;
	
	//供应商
	@JSONField(ordinal=7,name = "FSUPPLIERID")
	private CloudCommonF7Bean FSUPPLIERID;
	
	//部门
	@JSONField(ordinal=8,name = "FDEPTID")
	private CloudCommonF7Bean FDEPTID;
	
	//验收员
	@JSONField(ordinal=9,name = "FACCEPTANCE")
	private CloudCommonStaffF7Bean FACCEPTANCE;
	
	//仓管员
	@JSONField(ordinal=10,name = "FSTOCKERID")
	private CloudCommonF7Bean FSTOCKERID;
	
	//库存组
	@JSONField(ordinal=11,name = "FSTOCKERGROUPID")
	private CloudCommonF7Bean FSTOCKERGROUPID;
	
	//货主类型
	@JSONField(ordinal=12,name = "FOwnerTypeIdHead")
	private String FOwnerTypeIdHead;
	
	//货主
	@JSONField(ordinal=13,name = "FOwnerIdHead")
	private CloudCommonF7Bean FOwnerIdHead;
	
	//备注
	@JSONField(ordinal=14,name = "FNOTE")
	private String FNOTE;
	
	//本位币
	@JSONField(ordinal=15,name = "FBaseCurrId")
	private CloudCommonF7Bean FBaseCurrId;
	
	//序列号上传
	@JSONField(ordinal=16,name = "FScanBox")
	private String FScanBox;

	//分录
	@JSONField(ordinal=17,name = "FEntity")
	private JSONArray FEntity;
	
	
	@JSONField(name = "FEntity")
	public JSONArray getFEntity() {
		return FEntity;
	}
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
	@JSONField(name = "FStockDirect")
	public String getFStockDirect() {
		return FStockDirect;
	}
	@JSONField(name = "FDate")
	public String getFDate() {
		return FDate;
	}
	@JSONField(name = "FSUPPLIERID")
	public CloudCommonF7Bean getFSUPPLIERID() {
		return FSUPPLIERID;
	}
	@JSONField(name = "FDEPTID")
	public CloudCommonF7Bean getFDEPTID() {
		return FDEPTID;
	}
	@JSONField(name = "FACCEPTANCE")
	public CloudCommonStaffF7Bean getFACCEPTANCE() {
		return FACCEPTANCE;
	}
	@JSONField(name = "FSTOCKERID")
	public CloudCommonF7Bean getFSTOCKERID() {
		return FSTOCKERID;
	}
	@JSONField(name = "FSTOCKERGROUPID")
	public CloudCommonF7Bean getFSTOCKERGROUPID() {
		return FSTOCKERGROUPID;
	}
	@JSONField(name = "FOwnerTypeIdHead")
	public String getFOwnerTypeIdHead() {
		return FOwnerTypeIdHead;
	}
	@JSONField(name = "FOwnerIdHead")
	public CloudCommonF7Bean getFOwnerIdHead() {
		return FOwnerIdHead;
	}
	@JSONField(name = "FNOTE")
	public String getFNOTE() {
		return FNOTE;
	}
	@JSONField(name = "FBaseCurrId")
	public CloudCommonF7Bean getFBaseCurrId() {
		return FBaseCurrId;
	}
	@JSONField(name = "FScanBox")
	public String getFScanBox() {
		return FScanBox;
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
	public void setFStockDirect(String stockDirect) {
		FStockDirect = stockDirect;
	}
	public void setFDate(String date) {
		FDate = date;
	}
	public void setFSUPPLIERID(CloudCommonF7Bean fsupplierid) {
		FSUPPLIERID = fsupplierid;
	}
	public void setFDEPTID(CloudCommonF7Bean fdeptid) {
		FDEPTID = fdeptid;
	}
	public void setFACCEPTANCE(CloudCommonStaffF7Bean facceptance) {
		FACCEPTANCE = facceptance;
	}
	public void setFSTOCKERID(CloudCommonF7Bean fstockerid) {
		FSTOCKERID = fstockerid;
	}
	public void setFSTOCKERGROUPID(CloudCommonF7Bean fstockergroupid) {
		FSTOCKERGROUPID = fstockergroupid;
	}
	public void setFOwnerTypeIdHead(String ownerTypeIdHead) {
		FOwnerTypeIdHead = ownerTypeIdHead;
	}
	public void setFOwnerIdHead(CloudCommonF7Bean ownerIdHead) {
		FOwnerIdHead = ownerIdHead;
	}
	public void setFNOTE(String fnote) {
		FNOTE = fnote;
	}
	public void setFBaseCurrId(CloudCommonF7Bean baseCurrId) {
		FBaseCurrId = baseCurrId;
	}
	public void setFScanBox(String scanBox) {
		FScanBox = scanBox;
	}
	
	public void setFEntity(JSONArray entity) {
		FEntity = entity;
	}
	
	
	
	
	
}
