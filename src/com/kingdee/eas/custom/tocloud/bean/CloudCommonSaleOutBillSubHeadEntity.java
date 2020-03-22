package com.kingdee.eas.custom.tocloud.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

/**
 * ���㵥ͬ�����۳��ⵥС��¼
 * @author wlhl
 *
 */
@JSONType(orders = {"FSettleCurrID","FSettleOrgID","FSettleTypeID","FReceiptConditionID","FPriceListId",
		"FDiscountListId","FIsIncludedTax","FLocalCurrID","FExchangeTypeID","FExchangeRate"})
public class CloudCommonSaleOutBillSubHeadEntity {


	@JSONField(ordinal=1,name = "FSettleCurrID")
	private CloudCommonF7Bean FSettleCurrID;
	
	//������֯
	@JSONField(ordinal=2,name = "FSettleOrgID")
	private CloudCommonF7Bean FSettleOrgID;
	
	//���㷽ʽ
	@JSONField(ordinal=3,name = "FSettleTypeID")
	private CloudCommonF7Bean FSettleTypeID;
	
	//�տ�����
	@JSONField(ordinal=4,name = "FReceiptConditionID")
	private CloudCommonF7Bean FReceiptConditionID;
	
	//��Ŀ��
	@JSONField(ordinal=5,name = "FPriceListId")
	private CloudCommonF7Bean FPriceListId;

	//�ۿ۱�
	@JSONField(ordinal=6,name = "FDiscountListId")
	private CloudCommonF7Bean FDiscountListId;
	
	//�Ƿ�˰
	@JSONField(ordinal=7,name = "FIsIncludedTax")
	private String FIsIncludedTax;
	
	//��λ��
	@JSONField(ordinal=8,name = "FLocalCurrID")
	private CloudCommonF7Bean FLocalCurrID;
	
	//��������
	@JSONField(ordinal=9,name = "FExchangeTypeID")
	private CloudCommonF7Bean FExchangeTypeID;
	
	//����
	@JSONField(ordinal=10,name = "FExchangeRate")
	private String FExchangeRate;

	
	
	@JSONField(name = "FSettleCurrID")
	public CloudCommonF7Bean getFSettleCurrID() {
		return FSettleCurrID;
	}
	@JSONField(name = "FSettleOrgID")
	public CloudCommonF7Bean getFSettleOrgID() {
		return FSettleOrgID;
	}
	@JSONField(name = "FSettleTypeID")
	public CloudCommonF7Bean getFSettleTypeID() {
		return FSettleTypeID;
	}
	@JSONField(name = "FReceiptConditionID")
	public CloudCommonF7Bean getFReceiptConditionID() {
		return FReceiptConditionID;
	}
	@JSONField(name = "FPriceListId")
	public CloudCommonF7Bean getFPriceListId() {
		return FPriceListId;
	}
	@JSONField(name = "FDiscountListId")
	public CloudCommonF7Bean getFDiscountListId() {
		return FDiscountListId;
	}
	@JSONField(name = "FIsIncludedTax")
	public String getFIsIncludedTax() {
		return FIsIncludedTax;
	}
	@JSONField(name = "FLocalCurrID")
	public CloudCommonF7Bean getFLocalCurrID() {
		return FLocalCurrID;
	}
	@JSONField(name = "FExchangeTypeID")
	public CloudCommonF7Bean getFExchangeTypeID() {
		return FExchangeTypeID;
	}
	@JSONField(name = "FExchangeRate")
	public String getFExchangeRate() {
		return FExchangeRate;
	}
	public void setFSettleCurrID(CloudCommonF7Bean settleCurrID) {
		FSettleCurrID = settleCurrID;
	}
	public void setFSettleOrgID(CloudCommonF7Bean settleOrgID) {
		FSettleOrgID = settleOrgID;
	}
	public void setFSettleTypeID(CloudCommonF7Bean settleTypeID) {
		FSettleTypeID = settleTypeID;
	}
	public void setFReceiptConditionID(CloudCommonF7Bean receiptConditionID) {
		FReceiptConditionID = receiptConditionID;
	}
	public void setFPriceListId(CloudCommonF7Bean priceListId) {
		FPriceListId = priceListId;
	}
	public void setFDiscountListId(CloudCommonF7Bean discountListId) {
		FDiscountListId = discountListId;
	}
	public void setFIsIncludedTax(String isIncludedTax) {
		FIsIncludedTax = isIncludedTax;
	}
	public void setFLocalCurrID(CloudCommonF7Bean localCurrID) {
		FLocalCurrID = localCurrID;
	}
	public void setFExchangeTypeID(CloudCommonF7Bean exchangeTypeID) {
		FExchangeTypeID = exchangeTypeID;
	}
	public void setFExchangeRate(String exchangeRate) {
		FExchangeRate = exchangeRate;
	}


	
}
