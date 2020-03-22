package com.kingdee.eas.custom.tocloud.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONSerializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseFactory;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
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
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo;

public class SynDataQcEggToManufacture implements ISynData {

	/**
	 * 如果业务类型是产蛋信息分录合格单类型--生成cloud生产入库单（002）
	 */
	@Override
	public String synData(Context ctx, 
			String billId, 
			String entryId,
			String targetSystemId, 
			String bizTypeId,
			List<String> errorMessage,
			SynDateLogEntryInfo synDateLogEntryInfo) throws Exception {

		//实例化
		StockingBreedDailyInfo stockingInfo = StockingBreedDailyFactory.getLocalInstance(ctx).getStockingBreedDailyInfo(new ObjectUuidPK(billId));
		StockingBreedDailyEggEntryInfo qcEntryInfo = StockingBreedDailyEggEntryFactory.getLocalInstance(ctx).getStockingBreedDailyEggEntryInfo(new ObjectUuidPK(entryId));

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
		CompanyOrgUnitInfo companyInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo( new ObjectUuidPK(stockingInfo.getCompany().getId().toString()));


		String targetOrgNum = companyInfo.getNumber();
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		manufactureBillInfo.setFStockOrgId(f7Bean);

		//生产组织
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		manufactureBillInfo.setFPrdOrgId(f7Bean);

		//单据类型
		String targetProType = "JDSCRK01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetProType);
		manufactureBillInfo.setFBillType(f7Bean);

		//日期
		String fdate = sdf.format(stockingInfo.getBizDate());
		manufactureBillInfo.setFDate(fdate);
		//班组
		String targetBan = "01";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetBan);
		manufactureBillInfo.setF_BANZ2(f7Bean);

		//备注
		manufactureBillInfo.setFDescription("养殖日报合格蛋类型数据同步");

		//本位币
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber("PRE001");
		manufactureBillInfo.setFCurrId(f7Bean);

		//货主
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		manufactureBillInfo.setFOwnerId0(f7Bean);

		//货主类型
		String OwnerTypeId = "BD_OwnerOrg";
		manufactureBillInfo.setFOwnerTypeId0(OwnerTypeId);

		//设置生产入库单分录信息
		//实例化生产入库单分录
		CloudManufactureRecEntryBean entryInfo = new CloudManufactureRecEntryBean();

		String fentryid = "0";
		entryInfo.setFEntryID(fentryid);

		//物料
		String targetMatNum = "06.03.01.001";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetMatNum);
		entryInfo.setFMaterialId(f7Bean);

		//仓库FStockId
		String FStockId = "ZQ06";
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
		String targetUnit ="mei";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetUnit);
		entryInfo.setFUnitID(f7Bean);

		String FIsAffectCost = "true";
		entryInfo.setFIsAffectCost(FIsAffectCost);

		//基本单位
		String BaseUnitId = "mei";
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

		//保管者
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		entryInfo.setFKeeperId(f7Bean);

		//保管者类型
		String KeeperTypeId= "BD_KeeperOrg";
		entryInfo.setFKeeperTypeId(KeeperTypeId);

		//生产日期FProduceDate
		entryInfo.setFProduceDate(null);

		//有效期至
		entryInfo.setFExpiryDate(null);

		entryInfo.setFSecUnitId(new CloudCommonF7Bean());





		//数量
		String targetustQty = null;
		if(qcEntryInfo.getQcEggQty() != null && !"0".equalsIgnoreCase(qcEntryInfo.getQcEggQty().toString()) )
		{
			targetustQty = qcEntryInfo.getQcEggQty().toString();
		}else{
			errorMessage.add("合格蛋的数量不能为空，不能为0!");
		}
		entryInfo.setFMustQty(targetustQty);
		entryInfo.setFSecRealQty(null);
		entryInfo.setFBaseMustQty(targetustQty);

		//实收数量
		entryInfo.setFExtAuxUnitQty(null);

		//实收数量
		entryInfo.setFRealQty(targetustQty);

		//库存单位实收数量
		entryInfo.setFStockRealQty(targetustQty);

		//基本单位实收数量
		entryInfo.setFBaseRealQty(targetustQty);





		//养殖日报表头的当前成本对象
		StockingBatchInfo batchInfo = null;
		try {
			batchInfo = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(new ObjectUuidPK(stockingInfo.getStockingBatch().getId()));
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//批号
		String FLot = batchInfo.getNumber().substring(0, 8);
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FLot);
		entryInfo.setFLot(f7Bean);

		//生产编号
		entryInfo.setFProductNo(FLot);

		//生产车间
		FarmHouseEntryInfo houseInfo = qcEntryInfo.getHouse();
		if(houseInfo != null){
			FarmHouseEntryInfo houseInfo1 = FarmHouseEntryFactory.getLocalInstance(ctx).getFarmHouseEntryInfo(new ObjectUuidPK(qcEntryInfo.getHouse().getId()));
			f7Bean = new CloudCommonF7Bean();
			f7Bean.setFNumber(houseInfo1.getNumber());
			entryInfo.setFWorkShopId1(f7Bean);
		}else{
			errorMessage.add("产蛋信息分录的棚舍不能为空！");
		}

		//货主类型
		String OwnerEntryTypeId = "BD_OwnerOrg";
		entryInfo.setFOwnerTypeId(OwnerEntryTypeId);

		//货主
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		entryInfo.setFOwnerId(f7Bean);

		//库存单位
		String StockUnitId = "mei";
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
