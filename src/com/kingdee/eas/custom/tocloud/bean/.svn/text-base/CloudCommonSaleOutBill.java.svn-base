package com.kingdee.eas.custom.tocloud.bean;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

/*
 * 结算单同步cloud销售出库单，表头
 *   
 */
@JSONType(orders = {"FID","FBillTypeID","FBillNo","FDate","FSaleOrgId",
		"FSaleDeptID","FCustomerID","FHeadLocationId","FCorrespondOrgId","FCarrierID","FCarriageNO",
		"FSalesGroupID","FSalesManID","FStockOrgId","FDeliveryDeptID","FStockerGroupID","FStockerID",
		"FNote","FReceiverID","FReceiveAddress","FSettleID","FReceiverContactID","FPayerID","FOwnerTypeIdHead",
		"FOwnerIdHead","FScanBox","FCDateOffsetUnit","FCDateOffsetValue","FPlanRecAddress","F_abc_Text","FIsTotalServiceOrCost",
		"F_abc_Text1","F_abc_Text2","SubHeadEntity","FEntity"})
public class CloudCommonSaleOutBill {

	@JSONField(ordinal=1,name = "FID")
	private String FID;
	
	//单据类型
	@JSONField(ordinal=2,name = "FBillTypeID")
	private CloudCommonF7Bean FBillTypeID;
	
	//单据编号
	@JSONField(ordinal=3,name = "FBillNo")
	private String FBillNo;
	
	//日期
	@JSONField(ordinal=4,name = "FDate")
	private String FDate;
	
	//销售组织
	@JSONField(ordinal=5,name = "FSaleOrgId")
	private CloudCommonF7Bean FSaleOrgId;
	
	//销售部门
	@JSONField(ordinal=6,name = "FSaleDeptID")
	private CloudCommonF7Bean FSaleDeptID;

    //客户
	@JSONField(ordinal=7,name = "FCustomerID")
	private CloudCommonF7Bean FCustomerID;
	
	//交货地点
	@JSONField(ordinal=8,name = "FHeadLocationId")
	private CloudCommonF7Bean FHeadLocationId;
	
	//对应组织
	@JSONField(ordinal=9,name = "FCorrespondOrgId")
	private CloudCommonF7Bean FCorrespondOrgId;

	//承运商
	@JSONField(ordinal=10,name = "FCarrierID")
	private CloudCommonF7Bean FCarrierID;
	
	//运输单号
	@JSONField(ordinal=11,name = "FCarriageNO")
	private String FCarriageNO;
	
	//销售组
	@JSONField(ordinal=12,name = "FSalesGroupID")
	private CloudCommonF7Bean FSalesGroupID;
	
	//销售员
	@JSONField(ordinal=13,name = "FSalesManID")
	private CloudCommonF7Bean FSalesManID;
	
	//发货组织
	@JSONField(ordinal=14,name = "FStockOrgId")
	private CloudCommonF7Bean FStockOrgId;

	//发货部门
	@JSONField(ordinal=15,name = "FDeliveryDeptID")
	private CloudCommonF7Bean FDeliveryDeptID;
	
	//库存组
	@JSONField(ordinal=16,name = "FStockerGroupID")
	private CloudCommonF7Bean FStockerGroupID;

    //仓管员
	@JSONField(ordinal=17,name = "FStockerID")
	private CloudCommonF7Bean FStockerID;
	
	//备注
	@JSONField(ordinal=18,name = "FNote")
	private String FNote;
	
	//收货方
	@JSONField(ordinal=19,name = "FReceiverID")
	private CloudCommonF7Bean FReceiverID;
	
	//收货方地址
	@JSONField(ordinal=20,name = "FReceiveAddress")
	private String FReceiveAddress;
	
	//结算方
	@JSONField(ordinal=21,name = "FSettleID")
	private CloudCommonF7Bean FSettleID;
	
	//收货方联系人
	@JSONField(ordinal=22,name = "FReceiverContactID")
	private CloudCommonF7NameBean FReceiverContactID;
	
	//付款方
	@JSONField(ordinal=23,name = "FPayerID")
	private CloudCommonF7Bean FPayerID;
	
	//货主类型
	@JSONField(ordinal=24,name = "FOwnerTypeIdHead")
	private String FOwnerTypeIdHead;
	
	//货主
	@JSONField(ordinal=25,name = "FOwnerIdHead")
	private CloudCommonF7Bean FOwnerIdHead;
	
	//序列号上传
	@JSONField(ordinal=26,name = "FScanBox")
	private String FScanBox;
	
	//创建日期偏移单位
	@JSONField(ordinal=27,name = "FCDateOffsetUnit")
	private String FCDateOffsetUnit;
	
	//创建日期偏移量
	@JSONField(ordinal=28,name = "FCDateOffsetValue")
	private String FCDateOffsetValue;
	
	//交货明细执行地址(后台用)
	@JSONField(ordinal=29,name = "FPlanRecAddress")
	private String FPlanRecAddress;
	
	//养殖户
	@JSONField(ordinal=30,name = "F_abc_Text")
	private String F_abc_Text;
	
	//整单服务或费用
	@JSONField(ordinal=31,name = "FIsTotalServiceOrCost")
	private String FIsTotalServiceOrCost;
	
	//服务人员
	@JSONField(ordinal=32,name = "F_abc_Text1")
	private String F_abc_Text1;
	
	//车号
	@JSONField(ordinal=33,name = "F_abc_Text2")
	private String F_abc_Text2;
	
	//小分录
	@JSONField(ordinal=34,name = "SubHeadEntity")
	private CloudCommonSaleOutBillSubHeadEntity SubHeadEntity;
	
	//大分录
	@JSONField(ordinal=35,name = "FEntity")
	private JSONArray FEntity;

	
	
	@JSONField(name = "FID")
	public String getFID() {
		return FID;
	}
	@JSONField(name = "FBillTypeID")
	public CloudCommonF7Bean getFBillTypeID() {
		return FBillTypeID;
	}
	@JSONField(name = "FBillNo")
	public String getFBillNo() {
		return FBillNo;
	}
	@JSONField(name = "FDate")
	public String getFDate() {
		return FDate;
	}
	@JSONField(name = "FSaleOrgId")
	public CloudCommonF7Bean getFSaleOrgId() {
		return FSaleOrgId;
	}
	@JSONField(name = "FSaleDeptID")
	public CloudCommonF7Bean getFSaleDeptID() {
		return FSaleDeptID;
	}
	@JSONField(name = "FCustomerID")
	public CloudCommonF7Bean getFCustomerID() {
		return FCustomerID;
	}
	@JSONField(name = "FHeadLocationId")
	public CloudCommonF7Bean getFHeadLocationId() {
		return FHeadLocationId;
	}
	@JSONField(name = "FCorrespondOrgId")
	public CloudCommonF7Bean getFCorrespondOrgId() {
		return FCorrespondOrgId;
	}
	@JSONField(name = "FCarrierID")
	public CloudCommonF7Bean getFCarrierID() {
		return FCarrierID;
	}
	@JSONField(name = "FCarriageNO")
	public String getFCarriageNO() {
		return FCarriageNO;
	}
	@JSONField(name = "FSalesGroupID")
	public CloudCommonF7Bean getFSalesGroupID() {
		return FSalesGroupID;
	}
	@JSONField(name = "FSalesManID")
	public CloudCommonF7Bean getFSalesManID() {
		return FSalesManID;
	}
	@JSONField(name = "FStockOrgId")
	public CloudCommonF7Bean getFStockOrgId() {
		return FStockOrgId;
	}
	@JSONField(name = "FDeliveryDeptID")
	public CloudCommonF7Bean getFDeliveryDeptID() {
		return FDeliveryDeptID;
	}
	@JSONField(name = "FStockerGroupID")
	public CloudCommonF7Bean getFStockerGroupID() {
		return FStockerGroupID;
	}
	@JSONField(name = "FStockerID")
	public CloudCommonF7Bean getFStockerID() {
		return FStockerID;
	}
	@JSONField(name = "FNote")
	public String getFNote() {
		return FNote;
	}
	@JSONField(name = "FReceiverID")
	public CloudCommonF7Bean getFReceiverID() {
		return FReceiverID;
	}
	@JSONField(name = "FReceiveAddress")
	public String getFReceiveAddress() {
		return FReceiveAddress;
	}
	@JSONField(name = "FSettleID")
	public CloudCommonF7Bean getFSettleID() {
		return FSettleID;
	}
	@JSONField(name = "FReceiverContactID")
	public CloudCommonF7NameBean getFReceiverContactID() {
		return FReceiverContactID;
	}
	@JSONField(name = "FPayerID")
	public CloudCommonF7Bean getFPayerID() {
		return FPayerID;
	}
	@JSONField(name = "FOwnerTypeIdHead")
	public String getFOwnerTypeIdHead() {
		return FOwnerTypeIdHead;
	}
	@JSONField(name = "FOwnerIdHead")
	public CloudCommonF7Bean getFOwnerIdHead() {
		return FOwnerIdHead;
	}
	@JSONField(name = "FScanBox")
	public String getFScanBox() {
		return FScanBox;
	}
	@JSONField(name = "FCDateOffsetUnit")
	public String getFCDateOffsetUnit() {
		return FCDateOffsetUnit;
	}
	@JSONField(name = "FCDateOffsetValue")
	public String getFCDateOffsetValue() {
		return FCDateOffsetValue;
	}
	@JSONField(name = "FPlanRecAddress")
	public String getFPlanRecAddress() {
		return FPlanRecAddress;
	}
	@JSONField(name = "F_abc_Text")
	public String getF_abc_Text() {
		return F_abc_Text;
	}
	@JSONField(name = "FIsTotalServiceOrCost")
	public String getFIsTotalServiceOrCost() {
		return FIsTotalServiceOrCost;
	}
	@JSONField(name = "F_abc_Text1")
	public String getF_abc_Text1() {
		return F_abc_Text1;
	}
	@JSONField(name = "F_abc_Text2")
	public String getF_abc_Text2() {
		return F_abc_Text2;
	}
	@JSONField(name = "SubHeadEntity")
	public CloudCommonSaleOutBillSubHeadEntity getSubHeadEntity() {
		return SubHeadEntity;
	}
	@JSONField(name = "FEntity")
	public JSONArray getFEntity() {
		return FEntity;
	}
	public void setFID(String fid) {
		FID = fid;
	}
	public void setFBillTypeID(CloudCommonF7Bean billTypeID) {
		FBillTypeID = billTypeID;
	}
	public void setFBillNo(String billNo) {
		FBillNo = billNo;
	}
	public void setFDate(String date) {
		FDate = date;
	}
	public void setFSaleOrgId(CloudCommonF7Bean saleOrgId) {
		FSaleOrgId = saleOrgId;
	}
	public void setFSaleDeptID(CloudCommonF7Bean saleDeptID) {
		FSaleDeptID = saleDeptID;
	}
	public void setFCustomerID(CloudCommonF7Bean customerID) {
		FCustomerID = customerID;
	}
	public void setFHeadLocationId(CloudCommonF7Bean headLocationId) {
		FHeadLocationId = headLocationId;
	}
	public void setFCorrespondOrgId(CloudCommonF7Bean correspondOrgId) {
		FCorrespondOrgId = correspondOrgId;
	}
	public void setFCarrierID(CloudCommonF7Bean carrierID) {
		FCarrierID = carrierID;
	}
	public void setFCarriageNO(String carriageNO) {
		FCarriageNO = carriageNO;
	}
	public void setFSalesGroupID(CloudCommonF7Bean salesGroupID) {
		FSalesGroupID = salesGroupID;
	}
	public void setFSalesManID(CloudCommonF7Bean salesManID) {
		FSalesManID = salesManID;
	}
	public void setFStockOrgId(CloudCommonF7Bean stockOrgId) {
		FStockOrgId = stockOrgId;
	}
	public void setFDeliveryDeptID(CloudCommonF7Bean deliveryDeptID) {
		FDeliveryDeptID = deliveryDeptID;
	}
	public void setFStockerGroupID(CloudCommonF7Bean stockerGroupID) {
		FStockerGroupID = stockerGroupID;
	}
	public void setFStockerID(CloudCommonF7Bean stockerID) {
		FStockerID = stockerID;
	}
	public void setFNote(String note) {
		FNote = note;
	}
	public void setFReceiverID(CloudCommonF7Bean receiverID) {
		FReceiverID = receiverID;
	}
	public void setFReceiveAddress(String receiveAddress) {
		FReceiveAddress = receiveAddress;
	}
	public void setFSettleID(CloudCommonF7Bean settleID) {
		FSettleID = settleID;
	}
	public void setFReceiverContactID(CloudCommonF7NameBean receiverContactID) {
		FReceiverContactID = receiverContactID;
	}
	public void setFPayerID(CloudCommonF7Bean payerID) {
		FPayerID = payerID;
	}
	public void setFOwnerTypeIdHead(String ownerTypeIdHead) {
		FOwnerTypeIdHead = ownerTypeIdHead;
	}
	public void setFOwnerIdHead(CloudCommonF7Bean ownerIdHead) {
		FOwnerIdHead = ownerIdHead;
	}
	public void setFScanBox(String scanBox) {
		FScanBox = scanBox;
	}
	public void setFCDateOffsetUnit(String dateOffsetUnit) {
		FCDateOffsetUnit = dateOffsetUnit;
	}
	public void setFCDateOffsetValue(String dateOffsetValue) {
		FCDateOffsetValue = dateOffsetValue;
	}
	public void setFPlanRecAddress(String planRecAddress) {
		FPlanRecAddress = planRecAddress;
	}
	public void setF_abc_Text(String text) {
		F_abc_Text = text;
	}
	public void setFIsTotalServiceOrCost(String isTotalServiceOrCost) {
		FIsTotalServiceOrCost = isTotalServiceOrCost;
	}
	public void setF_abc_Text1(String text1) {
		F_abc_Text1 = text1;
	}
	public void setF_abc_Text2(String text2) {
		F_abc_Text2 = text2;
	}
	public void setSubHeadEntity(CloudCommonSaleOutBillSubHeadEntity subHeadEntity) {
		SubHeadEntity = subHeadEntity;
	}
	public void setFEntity(JSONArray entity) {
		FEntity = entity;
	}


	
}
