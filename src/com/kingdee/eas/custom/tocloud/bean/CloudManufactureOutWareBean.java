package com.kingdee.eas.custom.tocloud.bean;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
@JSONType(orders = {"FID","FBillNo","FBillType","FDate","FStockOrgId",
		"FBizType","FPrdOrgId","FStockerGroupId","FStockerId","FCurrId",
		"FOwnerTypeId0","FOwnerId0","FDescription","FTransferBizTypeId",
		"FScanBox","FEntity"})
public class CloudManufactureOutWareBean {

	
	@JSONField(ordinal=1,name = "FID")
	private String FID;
	//���ݱ���
	@JSONField(ordinal=2,name = "FBillNo")
	private String FBillNo;
	//��������
	@JSONField(ordinal=3,name = "FBillType")
	private CloudCommonF7Bean FBillType;
	
	//����
	@JSONField(ordinal=4,name = "FDate")
	private String FDate;
	
	//�˿���֯
	@JSONField(ordinal=5,name = "FStockOrgId")
	private CloudCommonF7Bean FStockOrgId;
	
	//ҵ������
	@JSONField(ordinal=6,name = "FBizType")
	private String FBizType;
	
	//������֯
	@JSONField(ordinal=7,name = "FPrdOrgId")
	private CloudCommonF7Bean FPrdOrgId;
	
	//�����
	@JSONField(ordinal=8,name = "FStockerGroupId")
	private CloudCommonF7Bean FStockerGroupId;
	
	//�ֹ�Ա
	@JSONField(ordinal=9,name = "FStockerId")
	private CloudCommonF7Bean FStockerId;

    //��λ��
	@JSONField(ordinal=10,name = "FCurrId")
	private CloudCommonF7Bean FCurrId;
	
	//��������
	@JSONField(ordinal=11,name = "FOwnerTypeId0")
	private String FOwnerTypeId0;
	
	//����
	@JSONField(ordinal=12,name = "FOwnerId0")
	private CloudCommonF7Bean FOwnerId0;

	//��ע
	@JSONField(ordinal=13,name = "FDescription")
	private String FDescription;
	
	//����֯ҵ������
	@JSONField(ordinal=14,name = "FTransferBizTypeId")
	private CloudCommonF7Bean FTransferBizTypeId;
	
	//���к��ϴ�
	@JSONField(ordinal=15,name = "FScanBox")
	private String FScanBox;
	
	//��¼
	@JSONField(ordinal=16,name = "FEntity")
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
	@JSONField(name = "FStockOrgId")
	public CloudCommonF7Bean getFStockOrgId() {
		return FStockOrgId;
	}
	@JSONField(name = "FBizType")
	public String getFBizType() {
		return FBizType;
	}
	@JSONField(name = "FPrdOrgId")
	public CloudCommonF7Bean getFPrdOrgId() {
		return FPrdOrgId;
	}
	@JSONField(name = "FStockerGroupId")
	public CloudCommonF7Bean getFStockerGroupId() {
		return FStockerGroupId;
	}
	@JSONField(name = "FStockerId")
	public CloudCommonF7Bean getFStockerId() {
		return FStockerId;
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
	@JSONField(name = "FDescription")
	public String getFDescription() {
		return FDescription;
	}
	@JSONField(name = "FTransferBizTypeId")
	public CloudCommonF7Bean getFTransferBizTypeId() {
		return FTransferBizTypeId;
	}
	@JSONField(name = "FScanBox")
	public String getFScanBox() {
		return FScanBox;
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
	public void setFStockOrgId(CloudCommonF7Bean stockOrgId) {
		FStockOrgId = stockOrgId;
	}
	public void setFBizType(String bizType) {
		FBizType = bizType;
	}
	public void setFPrdOrgId(CloudCommonF7Bean prdOrgId) {
		FPrdOrgId = prdOrgId;
	}
	public void setFStockerGroupId(CloudCommonF7Bean stockerGroupId) {
		FStockerGroupId = stockerGroupId;
	}
	public void setFStockerId(CloudCommonF7Bean stockerId) {
		FStockerId = stockerId;
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
	public void setFDescription(String description) {
		FDescription = description;
	}
	public void setFTransferBizTypeId(CloudCommonF7Bean transferBizTypeId) {
		FTransferBizTypeId = transferBizTypeId;
	}
	public void setFScanBox(String scanBox) {
		FScanBox = scanBox;
	}
	public void setFEntity(JSONArray entity) {
		FEntity = entity;
	}
	



	
	
	
	
}
