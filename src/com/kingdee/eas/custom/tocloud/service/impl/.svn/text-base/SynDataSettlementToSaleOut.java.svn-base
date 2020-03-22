package com.kingdee.eas.custom.tocloud.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.tocloud.SynDateLogEntryInfo;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonDataBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonF7NameBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonSaleOutBill;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonSaleOutBillEntry;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonSaleOutBillSubHeadEntity;
import com.kingdee.eas.custom.tocloud.service.ISynData;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
//import com.kingdee.eas.farm.carnivorous.recyclebiz.AccountPolicyFactory;
//import com.kingdee.eas.farm.carnivorous.recyclebiz.AccountPolicyInfo;
//import com.kingdee.eas.farm.carnivorous.recyclebiz.AccountPolicySaleEntryFactory;
//import com.kingdee.eas.farm.carnivorous.recyclebiz.AccountPolicySaleEntryInfo;

/**
 * 结算单同步生成销售出库单
 * @author wlhl
 *
 */
public class SynDataSettlementToSaleOut implements ISynData{

	@Override
	public String synData(Context ctx, String billId, String entryId,
			String targetSystemId, String bizTypeId, List<String> errorMessage,
			SynDateLogEntryInfo synDateLogEntryInfo) throws Exception {
		// TODO Auto-generated method stub
		//实例化
//		AccountPolicyInfo accountPolicyInfo = AccountPolicyFactory.getLocalInstance(ctx).getAccountPolicyInfo(new ObjectUuidPK(billId));
//		AccountPolicySaleEntryInfo saleEntryInfo = AccountPolicySaleEntryFactory.getLocalInstance(ctx).getAccountPolicySaleEntryInfo(new ObjectUuidPK(entryId));
		//设定日期显示格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");




		CloudCommonSaleOutBill billInfo = new CloudCommonSaleOutBill();

		CloudCommonF7Bean f7Bean = new CloudCommonF7Bean();
		String FID = "0";
		billInfo.setFID(FID);

		String  FBillTypeID = "XSCKD01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FBillTypeID);
		billInfo.setFBillTypeID(f7Bean);


		//单据编号
		String FBillNo = "";
		billInfo.setFBillNo(FBillNo);

//		//日期
//		String FDate =sdf.format(accountPolicyInfo.getBizDate());
//		billInfo.setFDate(FDate);
//
//		//销售组织
//		CompanyOrgUnitInfo storageInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(accountPolicyInfo.getCompany().getId()));
//		String targetOrgNum = storageInfo.getNumber();
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(targetOrgNum);
//		billInfo.setFSaleOrgId(f7Bean);
//
//		//销售部门
//		String FSaleDeptID = "";
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(FSaleDeptID);
//		billInfo.setFSaleDeptID(f7Bean);
//
//		//客户 
//		CustomerInfo customerInfo = CustomerFactory.getLocalInstance(ctx).getCustomerInfo(new ObjectUuidPK(((CustomerInfo)saleEntryInfo.getCustomerNo()).getId()));
//		String FCustomerID = customerInfo.getNumber();
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(FCustomerID);
//		billInfo.setFCustomerID(f7Bean);

		//交货地点
		String FHeadLocationId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FHeadLocationId);
		billInfo.setFHeadLocationId(f7Bean);

		//对应组织
		String FCorrespondOrgId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FCorrespondOrgId);
		billInfo.setFCorrespondOrgId(f7Bean);

		//承运商
		String FCarrierID = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FCarrierID);
		billInfo.setFCarrierID(f7Bean);

		//运输单号
		String FCarriageNO = "";
		billInfo.setFCarriageNO(FCarriageNO);

		//销售组
		String FSalesGroupID = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FSalesGroupID);
		billInfo.setFSalesGroupID(f7Bean);

		//销售员
		String FSalesManID = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FSalesManID);
		billInfo.setFSalesManID(f7Bean);
//
//		//发货组织
//		String FStockOrgId = "";
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(targetOrgNum);
//		billInfo.setFStockOrgId(f7Bean);

		//发货部门
		String FDeliveryDeptID = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FDeliveryDeptID);
		billInfo.setFDeliveryDeptID(f7Bean);

		//库存组
		String FStockerGroupID = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockerGroupID);
		billInfo.setFStockerGroupID(f7Bean);

		//仓管员
		String FStockerID = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockerID);
		billInfo.setFStockerID(f7Bean);

		//备注
		String FNote = "结算单同步cloud销售出库单";
		billInfo.setFNote(FNote);

		//收货方
		String FReceiverID = "";
		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(FCustomerID);
//		billInfo.setFReceiverID(f7Bean);

		//收货方地址
		String FReceiveAddress = "";
		billInfo.setFReceiveAddress(FReceiveAddress);

		//结算方
		String FSettleID = "";
		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(FCustomerID);
//		billInfo.setFSettleID(f7Bean);

		//收货方联系人
		String FReceiverContactID = "";
		CloudCommonF7NameBean f7NameBean = new CloudCommonF7NameBean();
		f7NameBean.setFName(FReceiverContactID);
		billInfo.setFReceiverContactID(f7NameBean);

		//付款方
		String FPayerID = "";
		f7Bean = new CloudCommonF7Bean();
		//f7Bean.setFNumber(FCustomerID);
		billInfo.setFPayerID(f7Bean);

		//货主类型
		String FOwnerTypeIdHead = "BD_OwnerOrg";
		billInfo.setFOwnerTypeIdHead(FOwnerTypeIdHead);

		//货主
		String FOwnerIdHead = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FOwnerIdHead);
		billInfo.setFOwnerIdHead(f7Bean);

		//序列号上传
		String FScanBox = "";
		billInfo.setFScanBox(FScanBox);

		//创建日期偏移单位
		String FCDateOffsetUnit = "";
		billInfo.setFCDateOffsetUnit(FCDateOffsetUnit);

		//创建日期偏移量
		String FCDateOffsetValue = "0";
		billInfo.setFCDateOffsetValue(FCDateOffsetValue);

		//交货明细执行地址(后台用)
		String FPlanRecAddress = "";
		billInfo.setFPlanRecAddress(FPlanRecAddress);

		//养殖户
		String F_abc_Text = "";
		billInfo.setF_abc_Text(F_abc_Text);

		//整单服务或费用
		String FIsTotalServiceOrCost = "false";
		billInfo.setFIsTotalServiceOrCost(FIsTotalServiceOrCost);

		//服务人员
		String F_abc_Text1 = "";
		billInfo.setF_abc_Text1(F_abc_Text1);

		//车号
		String F_abc_Text2 = "";
		billInfo.setF_abc_Text2(F_abc_Text2);




		//设置小分录
		CloudCommonSaleOutBillSubHeadEntity subHeadEntity = new CloudCommonSaleOutBillSubHeadEntity();

		//结算币别
		String FSettleCurrID = "PRE001";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FSettleCurrID);
		subHeadEntity.setFSettleCurrID(f7Bean);

		//结算组织
		String FSettleOrgID = "";
		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(targetOrgNum);
//		subHeadEntity.setFSettleOrgID(f7Bean);

		//结算方式
		String FSettleTypeID = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FSettleTypeID);
		subHeadEntity.setFSettleTypeID(f7Bean);

		//收款条件
		String FReceiptConditionID = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FReceiptConditionID);
		subHeadEntity.setFReceiptConditionID(f7Bean);

		//价目表
		String FPriceListId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FPriceListId);
		subHeadEntity.setFPriceListId(f7Bean);

		//折扣表
		String FDiscountListId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FDiscountListId);
		subHeadEntity.setFDiscountListId(f7Bean);


		//是否含税
		String FIsIncludedTax = "true";
		subHeadEntity.setFIsIncludedTax(FIsIncludedTax);

		//本位币
		String FLocalCurrID = "PRE001";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FLocalCurrID);
		subHeadEntity.setFLocalCurrID(f7Bean);

		//汇率类型
		String FExchangeTypeID = "HLTX01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FExchangeTypeID);
		subHeadEntity.setFExchangeTypeID(f7Bean);

		//汇率
		String FExchangeRate = "1";
		subHeadEntity.setFExchangeRate(FExchangeRate);


		//设置billInfo的小分录
		billInfo.setSubHeadEntity(subHeadEntity);




		JSONArray jsonArray = new JSONArray();
		//设置大分录
		CloudCommonSaleOutBillEntry entryInfo = new CloudCommonSaleOutBillEntry();

		String FENTRYID ="";
		entryInfo.setFENTRYID(FENTRYID);

		//客户物料编码
		String FCustMatID = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FCustMatID);
		entryInfo.setFCustMatID(f7Bean);

		//物料编码
		String FMaterialID = "06.03.01.005";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FMaterialID);
		entryInfo.setFMaterialID(f7Bean);

		//库存单位
		String FUnitID = "yu";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FUnitID);
		entryInfo.setFUnitID(f7Bean);

		//当前库存
		String FInventoryQty = "";
		entryInfo.setFInventoryQty(FInventoryQty);

//		//实发数量
//		String FRealQty = String.valueOf(saleEntryInfo.getSaleKg());
//		entryInfo.setFRealQty(FRealQty);
//
//		//单价
//		String FPrice = String.valueOf(saleEntryInfo.getSalePrice());
//		entryInfo.setFPrice(FPrice);
//
//		//含税单价
//		String FTaxPrice = String.valueOf(saleEntryInfo.getSalePrice());
//		entryInfo.setFTaxPrice(FTaxPrice);

		//是否赠品
		String FIsFree = "false";
		entryInfo.setFIsFree(FIsFree);

		//BOM版本
		String FBomID = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FBomID);
		entryInfo.setFBomID(f7Bean);

		//生产日期
		String FProduceDate = "";
		entryInfo.setFProduceDate(FProduceDate);

		//货主类型
		String FOwnerTypeID = "BD_OwnerOrg";
		entryInfo.setFOwnerTypeID(FOwnerTypeID);

		//货主
		String FOwnerID = "";
		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(targetOrgNum);
//		entryInfo.setFOwnerID(f7Bean);

		//批号
		//批次
//		BatchInfo batchInfo = null;
//		try {
//			batchInfo = BatchFactory.getLocalInstance(ctx).getBatchInfo(new ObjectUuidPK(accountPolicyInfo.getBatch().getId()));
//		} catch (EASBizException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (BOSException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String FLot = batchInfo.getNumber();
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(FLot);
//		entryInfo.setFLot(f7Bean);

		//有效期至
		String FExpiryDate = "";
		entryInfo.setFExpiryDate(FExpiryDate);

		//税组合
		String FTaxCombination = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FTaxCombination);
		entryInfo.setFTaxCombination(f7Bean);

		//税率%
		String FEntryTaxRate = "0";
		entryInfo.setFEntryTaxRate(FEntryTaxRate);

		//库存辅单位数量
		String FAuxUnitQty = "";
		entryInfo.setFAuxUnitQty(FAuxUnitQty);

		//辅单位
		String FExtAuxUnitId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FExtAuxUnitId);
		entryInfo.setFExtAuxUnitId(f7Bean);

		//实发数量(辅单位)
		String FExtAuxUnitQty = "";
		entryInfo.setFExtAuxUnitQty(FExtAuxUnitQty);

		//仓库
		String FStockID = "ZL08";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockID);
		entryInfo.setFStockID(f7Bean);

		//库存状态:FStockStatusID 
		String FStockStatusID = "KCZT01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockStatusID);
		entryInfo.setFStockStatusID(f7Bean);

		//质量类型
		String FQualifyType = "";
		entryInfo.setFQualifyType(FQualifyType);

		//计划跟踪号
		String FMtoNo = "";
		entryInfo.setFMtoNo(FMtoNo);

		//备注
		String FEntrynote = "";
		entryInfo.setFMtoNo(FEntrynote);

		//折扣率%
		String FDiscountRate = "0";
		entryInfo.setFDiscountRate(FDiscountRate);

		//实收数量
		String FActQty = "";
		entryInfo.setFActQty(FActQty);

		//销售单位
		String FSalUnitID = "kg";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FSalUnitID);
		entryInfo.setFSalUnitID(f7Bean);

//		//销售数量 FSALUNITQTY
//		String FSALUNITQTY = "";
//		entryInfo.setFSALUNITQTY(FRealQty);
//
//		//销售基本数量
//		String FSALBASEQTY = "";
//		entryInfo.setFSALBASEQTY(FRealQty);
//
//		//计价基本数量
//		String FPRICEBASEQTY = "";
//		entryInfo.setFPRICEBASEQTY(FRealQty);

		//项目编号
		String FProjectNo = "";
		entryInfo.setFProjectNo(FProjectNo);

		//控制出库数量:FOUTCONTROL 
		String FOUTCONTROL = "false";
		entryInfo.setFOUTCONTROL(FOUTCONTROL);

		//补货数量
		String FRepairQty = "0";
		entryInfo.setFRepairQty(FRepairQty);

		//是否生成产品档案
		String FIsCreateProDoc = "";
		entryInfo.setFIsCreateProDoc(FIsCreateProDoc);

		//明细货主供应商
		String FEOwnerSupplierId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FEOwnerSupplierId);
		entryInfo.setFEOwnerSupplierId(f7Bean);

		//是否跨法人交易
		String FIsOverLegalOrg = "false";
		entryInfo.setFIsOverLegalOrg(FIsOverLegalOrg);

		//明细结算组织客户
		String FESettleCustomerId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FESettleCustomerId);
		entryInfo.setFESettleCustomerId(f7Bean);

		//行价目表
		String FPriceListEntry = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FPriceListEntry);
		entryInfo.setFPriceListEntry(f7Bean);

		//未关联应收数量（计价单位）
		String FARNOTJOINQTY = "";
		//entryInfo.setFARNOTJOINQTY(FRealQty);

		//库存请检单EntryID
		String FQmEntryID = "";
		entryInfo.setFQmEntryID(FQmEntryID);

		//销售订单EntryId
		String FSOEntryId = "";
		entryInfo.setFSOEntryId(FSOEntryId);

		//库存状态转换单ENTRYID
		String FConvertEntryID = "";
		entryInfo.setFConvertEntryID(FConvertEntryID);

//		//毛鸡只数
//		String F_abc_Qty = "0";
//		if(saleEntryInfo.getSaleQty() != null){
//			F_abc_Qty = String.valueOf(saleEntryInfo.getSaleQty());
//		}
//		entryInfo.setF_abc_Qty(F_abc_Qty);
//
//		//单只毛鸡重量
//		String F_abc_Qty1 = "0";
//		if(saleEntryInfo.getSaleQty() != null){
//			F_abc_Qty1 = String.valueOf(accountPolicyInfo.getOneWeight());
//		}
		//entryInfo.setF_abc_Qty1(F_abc_Qty1);




		jsonArray.add(entryInfo);
		//设置billInfo的大分录
		billInfo.setFEntity(jsonArray);


		//将实体转化为jsonObject
		String manuString = JSONObject.toJSONString(billInfo, SerializerFeature.WriteNullStringAsEmpty);
		JSONObject allJson = JSONObject.parseObject(manuString, Feature.OrderedField);

		//data（必填）
		CloudCommonDataBean cloudCommonDataBean = new CloudCommonDataBean();
		cloudCommonDataBean.setCreator("");
		cloudCommonDataBean.setNeedUpDateFields(null);
		cloudCommonDataBean.setModel(allJson);

		//新建CloudCommonBean对象
		CloudCommonBean commonBean = new CloudCommonBean();
		commonBean.setFormid("SAL_OUTSTOCK");
		commonBean.setData(cloudCommonDataBean);

		//将实体转化为字符串
		return JSONObject.toJSONString(commonBean, SerializerFeature.WriteNullStringAsEmpty);
	}

}
