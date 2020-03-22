package com.kingdee.eas.custom.tocloud.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.tocloud.SynDateLogEntryInfo;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonDataBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonFAUXPROF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonFSTOCKF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudManufactureRecBean;
import com.kingdee.eas.custom.tocloud.bean.CloudManufactureRecEntryBean;
import com.kingdee.eas.custom.tocloud.service.ISynData;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
//import com.kingdee.eas.farm.carnivorous.recyclebiz.AccountPolicyFactory;
//import com.kingdee.eas.farm.carnivorous.recyclebiz.AccountPolicyInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo;

/**
 * 结算单同步cloud的生产入库单
 * @author wlhl
 *
 */
public class SynDataSettlementToManufacture implements ISynData {

	@Override
	public String synData(Context ctx, String billId, String entryId,
			String targetSystemId, String bizTypeId, List<String> errorMessage,
			SynDateLogEntryInfo synDateLogEntryInfo) throws Exception {

		//实例化
	//	AccountPolicyInfo stockingInfo = AccountPolicyFactory.getLocalInstance(ctx).getAccountPolicyInfo(new ObjectUuidPK(billId));

		//设定日期显示格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		//设置生产入库单表头信息
		//实例化生产入库单表头对象
		CloudManufactureRecBean manufactureBillInfo = new CloudManufactureRecBean();

		//设置id
		CloudCommonF7Bean f7Bean = null;
		manufactureBillInfo.setFID("0");

		//编号
		String billNum = "";
		manufactureBillInfo.setFBillNo(billNum);


		//仓管员
		manufactureBillInfo.setFStockerId(new CloudCommonF7Bean());

		//跨组织业务类型
		String FTransferBizTypeId = "OverOrgPrdIn";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FTransferBizTypeId);
		manufactureBillInfo.setFTransferBizTypeId(f7Bean);

		//序列号上传
		manufactureBillInfo.setFScanBox(null);

		manufactureBillInfo.setFStockerGroupId(new CloudCommonF7Bean());


		//入库组织
		//CompanyOrgUnitInfo companyInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo( new ObjectUuidPK(stockingInfo.getCompany().getId().toString()));

//		String targetOrgNum = companyInfo.getNumber();
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(targetOrgNum);
//		manufactureBillInfo.setFStockOrgId(f7Bean);

//		//生产组织
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(targetOrgNum);
//		manufactureBillInfo.setFPrdOrgId(f7Bean);

		//单据类型
		String targetProType = "JDSCRK01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetProType);
		manufactureBillInfo.setFBillType(f7Bean);
//
//		//日期
//		String fdate = sdf.format(stockingInfo.getBizDate());
//		manufactureBillInfo.setFDate(fdate);
		//班组
		String targetBan = "01";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetBan);
		manufactureBillInfo.setF_BANZ2(f7Bean);

		//备注
		manufactureBillInfo.setFDescription("结算单同步cloud生产入库单");

		//本位币
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber("PRE001");
		manufactureBillInfo.setFCurrId(f7Bean);

//		//货主
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(targetOrgNum);
//		manufactureBillInfo.setFOwnerId0(f7Bean);

		//货主类型
		String OwnerTypeId = "BD_OwnerOrg";
		manufactureBillInfo.setFOwnerTypeId0(OwnerTypeId);

		//设置生产入库单分录信息
		//实例化生产入库单分录
		CloudManufactureRecEntryBean entryInfo = new CloudManufactureRecEntryBean();

		String fentryid = "0";
		entryInfo.setFEntryID(fentryid);

		//物料
		String targetMatNum = "06.03.01.005";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetMatNum);
		entryInfo.setFMaterialId(f7Bean);

		//仓库FStockId
		String FStockId = "ZL08";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockId);
		entryInfo.setFStockId(f7Bean);


		//仓位
		entryInfo.setFStockLocId(new CloudCommonFSTOCKF7Bean());

		//班组
		entryInfo.setFShiftGroupId(new CloudCommonF7Bean());

		//入库类型
		String  inStoreNum = "1";
		entryInfo.setFInStockType(inStoreNum);

		//单位
		String targetUnit ="kg";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetUnit);
		entryInfo.setFUnitID(f7Bean);

		String FIsAffectCost = "true";
		entryInfo.setFIsAffectCost(FIsAffectCost);

		//基本单位
		String BaseUnitId = "kg";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(BaseUnitId);
		entryInfo.setFBaseUnitId(f7Bean);

		entryInfo.setFExtAuxUnitId(new CloudCommonF7Bean());

		entryInfo.setFBomId(new CloudCommonF7Bean());

		//库存状态
		String targetStatus = "KCZT01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetStatus);
		entryInfo.setFStockStatusId(f7Bean);

//		//保管者
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(targetOrgNum);
//		entryInfo.setFKeeperId(f7Bean);

		//保管者类型
		String KeeperTypeId= "BD_KeeperOrg";
		entryInfo.setFKeeperTypeId(KeeperTypeId);

		//生产日期FProduceDate
		entryInfo.setFProduceDate(null);

		//有效期至
		entryInfo.setFExpiryDate(null);

		entryInfo.setFSecUnitId(new CloudCommonF7Bean());


//		//设置成本价
//		String FPrice = null;
//		if(UIRuleUtil.isNotNull(stockingInfo.getJinShareCost())){
//			FPrice = String.valueOf(stockingInfo.getJinShareCost().multiply(new BigDecimal("2")));
//		}
//		entryInfo.setFPrice(FPrice);
//
//		//设置成本金额
//		String FAmount = null;
//		if(UIRuleUtil.isNotNull(stockingInfo.getCompanyCost())){
//			FAmount = String.valueOf(stockingInfo.getCompanyCost());
//		}
//		entryInfo.setFAmount(FAmount);
//		
//		
//		//设置棚前净重
//		String F_abc_Qty3 = null;
//		if(UIRuleUtil.isNotNull(stockingInfo.getHouseWeight())){
//			F_abc_Qty3 = String.valueOf(stockingInfo.getHouseWeight());
//		}
//		entryInfo.setF_abc_Qty3(F_abc_Qty3);
//		
//		
//		//设置胴体增重--如果结算单的胴体折算后毛鸡重量不为空，并且大于零，胴体增重 = 胴体折算后毛鸡重量-棚前净重
//		String F_abc_Qty2 = null;
//		BigDecimal qty2 = BigDecimal.ZERO;
//		if(stockingInfo.getAfterReduceWeight() != null 
//				&& stockingInfo.getAfterReduceWeight().compareTo(BigDecimal.ZERO) > 0){
//			F_abc_Qty2 = String.valueOf(stockingInfo.getAfterReduceWeight().subtract(stockingInfo.getHouseWeight()));
//			qty2 = stockingInfo.getAfterReduceWeight().subtract(stockingInfo.getHouseWeight());
//		}
//		entryInfo.setF_abc_Qty2(F_abc_Qty2);
//		

//		//数量--取结算单棚前过磅重量
//		String targetustQty = stockingInfo.getHouseWeight().toString();
//		
//		entryInfo.setFMustQty(String.valueOf(stockingInfo.getHouseWeight().add(qty2)));
//		entryInfo.setFSecRealQty(null);
//		entryInfo.setFBaseMustQty(String.valueOf(stockingInfo.getHouseWeight().add(qty2)));
//
//		//实收数量
//		entryInfo.setFExtAuxUnitQty(String.valueOf(stockingInfo.getHouseWeight().add(qty2)));
//
//		//毛鸡只数
//		String F_abc_Qty = String.valueOf(stockingInfo.getCarcassQty());
//		entryInfo.setF_abc_Qty(F_abc_Qty);
//		
//		//单只毛鸡重量
//		String F_abc_Qty1 = String.valueOf(stockingInfo.getOneWeight());
//		entryInfo.setF_abc_Qty1(F_abc_Qty1);
//		
//		//实收数量
//		entryInfo.setFRealQty(String.valueOf(stockingInfo.getHouseWeight().add(qty2)));
//
//		//库存单位实收数量
//		entryInfo.setFStockRealQty(String.valueOf(stockingInfo.getHouseWeight().add(qty2)));
//
//		//基本单位实收数量
//		entryInfo.setFBaseRealQty(String.valueOf(stockingInfo.getHouseWeight().add(qty2)));
//
//
//		//批次
//		BatchInfo batchInfo = null;
//		try {
//			batchInfo = BatchFactory.getLocalInstance(ctx).getBatchInfo(new ObjectUuidPK(stockingInfo.getBatch().getId()));
//		} catch (EASBizException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (BOSException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//批号
//		String FLot = batchInfo.getNumber();
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(FLot);
//		entryInfo.setFLot(f7Bean);
//
//		//生产编号
//		entryInfo.setFProductNo(FLot);
//
//		//生产车间
//		FarmerInfo farmInfo = FarmerFactory.getLocalInstance(ctx).getFarmerInfo(new ObjectUuidPK(stockingInfo.getFarmer().getId()));
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(farmInfo.getNumber());
//		entryInfo.setFWorkShopId1(f7Bean);
//
//		//货主类型
//		String OwnerEntryTypeId = "BD_OwnerOrg";
//		entryInfo.setFOwnerTypeId(OwnerEntryTypeId);
//
//		//货主
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(targetOrgNum);
//		entryInfo.setFOwnerId(f7Bean);

		//库存单位
		String StockUnitId = "kg";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(StockUnitId);
		entryInfo.setFStockUnitId(f7Bean);

		//辅助属性
		entryInfo.setFAuxpropId(new CloudCommonFAUXPROF7Bean());

		//源单据编号
		entryInfo.setF_abc_SourceBillNo(null);

		//计划跟踪号
		entryInfo.setFMtoNo(null);


		//定义一个jsonArray
		JSONArray entryArray = new JSONArray();
		String entryStr = JSONObject.toJSONString(entryInfo, SerializerFeature.WriteNullStringAsEmpty);
		JSONObject entryJson = JSONObject.parseObject(entryStr, Feature.OrderedField);
		entryArray.add(entryJson);

		//将分录放到单据中
		manufactureBillInfo.setFEntity(entryArray);

		//将实体转化为jsonObject
		String manuString = JSONObject.toJSONString(manufactureBillInfo, SerializerFeature.WriteNullStringAsEmpty);
		JSONObject allJson = JSONObject.parseObject(manuString, Feature.OrderedField);

		//data（必填）
		CloudCommonDataBean cloudCommonDataBean = new CloudCommonDataBean();
		cloudCommonDataBean.setCreator("");
		cloudCommonDataBean.setNeedUpDateFields(null);
		cloudCommonDataBean.setModel(allJson);

		//新建CloudCommonBean对象
		CloudCommonBean commonBean = new CloudCommonBean();
		commonBean.setFormid("SP_InStock");
		commonBean.setData(cloudCommonDataBean);

		//将实体转化为字符串
		return JSONObject.toJSONString(commonBean, SerializerFeature.WriteNullStringAsEmpty);
	}

}
