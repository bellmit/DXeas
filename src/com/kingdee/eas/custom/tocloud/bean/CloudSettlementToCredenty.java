package com.kingdee.eas.custom.tocloud.bean;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;


@JSONType(orders = {"FVOUCHERID","FAccountBookID","FDate","FVOUCHERGROUPID","FVOUCHERGROUPNO",
		"FISFOREIGNCUR","FBASECURRENCYID","FCancleRecheck","FACCBOOKORGID","FIsSplit","FCashierRecheck",
		"FAuditDate","FDocumentStatus","FCreateDate","FIsQty","FModifierId","FModifyDate","FEntity"})
public class CloudSettlementToCredenty {


	@JSONField(ordinal=1,name = "FVOUCHERID")
	private String FVOUCHERID;
	
	//账簿
	@JSONField(ordinal=2,name = "FAccountBookID")
	private CloudCommonF7Bean FAccountBookID;
	
	//日期
	@JSONField(ordinal=3,name = "FDate")
	private String FDate;
	
	//凭证字
	@JSONField(ordinal=4,name = "FVOUCHERGROUPID")
	private CloudCommonF7Bean FVOUCHERGROUPID;
	
	//凭证号
	@JSONField(ordinal=5,name = "FVOUCHERGROUPNO")
	private String FVOUCHERGROUPNO;

	//外币
	@JSONField(ordinal=6,name = "FISFOREIGNCUR")
	private String FISFOREIGNCUR;
	
	//本位币(辅助)
	@JSONField(ordinal=7,name = "FBASECURRENCYID")
	private CloudCommonF7Bean FBASECURRENCYID;
	
	//取消复核操(作辅助)
	@JSONField(ordinal=8,name = "FCancleRecheck")
	private String FCancleRecheck;
	
	//核算组织
	@JSONField(ordinal=9,name = "FACCBOOKORGID")
	private CloudCommonF7Bean FACCBOOKORGID;
	
	//是否拆分
	@JSONField(ordinal=10,name = "FIsSplit")
	private String FIsSplit;
	
	//出纳复核操作(辅助)
	@JSONField(ordinal=11,name = "FCashierRecheck")
	private String FCashierRecheck;
	
	//审核日期
	@JSONField(ordinal=12,name = "FAuditDate")
	private String FAuditDate;
	
	//审核状态
	@JSONField(ordinal=13,name = "FDocumentStatus")
	private String FDocumentStatus;
	
	//创建日期
	@JSONField(ordinal=14,name = "FCreateDate")
	private String FCreateDate;

   //数量金额核算
	@JSONField(ordinal=15,name = "FIsQty")
	private String FIsQty;
	
	//修改人
	@JSONField(ordinal=16,name = "FModifierId")
	private CloudCommonUserID FModifierId;
	
	//修改日期
	@JSONField(ordinal=17,name = "FModifyDate")
	private String FModifyDate;

	//设置因崔
	@JSONField(ordinal=18,name = "FEntity")
	private JSONArray FEntity;

	
	
	@JSONField(name = "FVOUCHERID")
	public String getFVOUCHERID() {
		return FVOUCHERID;
	}
	@JSONField(name = "FAccountBookID")
	public CloudCommonF7Bean getFAccountBookID() {
		return FAccountBookID;
	}
	@JSONField(name = "FDate")
	public String getFDate() {
		return FDate;
	}
	@JSONField(name = "FVOUCHERGROUPID")
	public CloudCommonF7Bean getFVOUCHERGROUPID() {
		return FVOUCHERGROUPID;
	}
	@JSONField(name = "FVOUCHERGROUPNO")
	public String getFVOUCHERGROUPNO() {
		return FVOUCHERGROUPNO;
	}
	@JSONField(name = "FISFOREIGNCUR")
	public String getFISFOREIGNCUR() {
		return FISFOREIGNCUR;
	}
	@JSONField(name = "FBASECURRENCYID")
	public CloudCommonF7Bean getFBASECURRENCYID() {
		return FBASECURRENCYID;
	}
	@JSONField(name = "FCancleRecheck")
	public String getFCancleRecheck() {
		return FCancleRecheck;
	}
	@JSONField(name = "FACCBOOKORGID")
	public CloudCommonF7Bean getFACCBOOKORGID() {
		return FACCBOOKORGID;
	}
	@JSONField(name = "FIsSplit")
	public String getFIsSplit() {
		return FIsSplit;
	}
	@JSONField(name = "FCashierRecheck")
	public String getFCashierRecheck() {
		return FCashierRecheck;
	}
	@JSONField(name = "FAuditDate")
	public String getFAuditDate() {
		return FAuditDate;
	}
	@JSONField(name = "FDocumentStatus")
	public String getFDocumentStatus() {
		return FDocumentStatus;
	}
	@JSONField(name = "FCreateDate")
	public String getFCreateDate() {
		return FCreateDate;
	}
	@JSONField(name = "FIsQty")
	public String getFIsQty() {
		return FIsQty;
	}
	@JSONField(name = "FModifierId")
	public CloudCommonUserID getFModifierId() {
		return FModifierId;
	}
	@JSONField(name = "FModifyDate")
	public String getFModifyDate() {
		return FModifyDate;
	}
	@JSONField(name = "FEntity")
	public JSONArray getFEntity() {
		return FEntity;
	}
	public void setFVOUCHERID(String fvoucherid) {
		FVOUCHERID = fvoucherid;
	}
	public void setFAccountBookID(CloudCommonF7Bean accountBookID) {
		FAccountBookID = accountBookID;
	}
	public void setFDate(String date) {
		FDate = date;
	}
	public void setFVOUCHERGROUPID(CloudCommonF7Bean fvouchergroupid) {
		FVOUCHERGROUPID = fvouchergroupid;
	}
	public void setFVOUCHERGROUPNO(String fvouchergroupno) {
		FVOUCHERGROUPNO = fvouchergroupno;
	}
	public void setFISFOREIGNCUR(String fisforeigncur) {
		FISFOREIGNCUR = fisforeigncur;
	}
	public void setFBASECURRENCYID(CloudCommonF7Bean fbasecurrencyid) {
		FBASECURRENCYID = fbasecurrencyid;
	}
	public void setFCancleRecheck(String cancleRecheck) {
		FCancleRecheck = cancleRecheck;
	}
	public void setFACCBOOKORGID(CloudCommonF7Bean faccbookorgid) {
		FACCBOOKORGID = faccbookorgid;
	}
	public void setFIsSplit(String isSplit) {
		FIsSplit = isSplit;
	}
	public void setFCashierRecheck(String cashierRecheck) {
		FCashierRecheck = cashierRecheck;
	}
	public void setFAuditDate(String auditDate) {
		FAuditDate = auditDate;
	}
	public void setFDocumentStatus(String documentStatus) {
		FDocumentStatus = documentStatus;
	}
	public void setFCreateDate(String createDate) {
		FCreateDate = createDate;
	}
	public void setFIsQty(String isQty) {
		FIsQty = isQty;
	}
	public void setFModifierId(CloudCommonUserID modifierId) {
		FModifierId = modifierId;
	}
	public void setFModifyDate(String modifyDate) {
		FModifyDate = modifyDate;
	}
	public void setFEntity(JSONArray entity) {
		FEntity = entity;
	}

	
}
