package com.kingdee.eas.custom.tocloud.service.impl;

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
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
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
import com.kingdee.eas.farm.hatch.BHatchBabyBillEntryFactory;
import com.kingdee.eas.farm.hatch.BHatchBabyBillEntryInfo;
import com.kingdee.eas.farm.hatch.BHatchBabyBillFactory;
import com.kingdee.eas.farm.hatch.BHatchBabyBillInfo;
import com.kingdee.eas.farm.hatch.HatchBaseDataFactory;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;

public class SynDatabHatchBabToManufacture implements ISynData{

	/**
	 * 出雏单同步生成cloud生产入库单（008）
	 */
//	@Override
	public String synData(Context ctx, String billId, String entryId,
			String targetSystemId, String bizTypeId, List<String> errorMessage,
			SynDateLogEntryInfo synDateLogEntryInfo) throws Exception {
		// TODO Auto-generated method stub

		//实例化
		BHatchBabyBillInfo bHatchBabyBillInfo = BHatchBabyBillFactory.getLocalInstance(ctx).getBHatchBabyBillInfo(new ObjectUuidPK(billId));
		BHatchBabyBillEntryInfo entryInfo = BHatchBabyBillEntryFactory.getLocalInstance(ctx).getBHatchBabyBillEntryInfo(new ObjectUuidPK(entryId));



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
		manufactureBillInfo.setFTransferBizTypeId(new CloudCommonF7Bean());
		//序列号上传
		manufactureBillInfo.setFScanBox(null);
		manufactureBillInfo.setFStockerGroupId(new CloudCommonF7Bean());


		//入库组织
		StorageOrgUnitInfo storageInfo = StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(new ObjectUuidPK((bHatchBabyBillInfo.getCU().getId())));
		String targetOrgNum = storageInfo.getNumber();
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
		String fdate = bHatchBabyBillInfo.getBizDate().toString();
		manufactureBillInfo.setFDate(fdate);
		//班组
		String targetBan = "01";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetBan);
		manufactureBillInfo.setF_BANZ2(f7Bean);

		//备注
		manufactureBillInfo.setFDescription("出雏单健雏同步生产入库单");

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
		CloudManufactureRecEntryBean entryInfo1 = new CloudManufactureRecEntryBean();

		String fentryid = "0";
		entryInfo1.setFEntryID(fentryid);

		//物料
		String targetMatNum = "06.002";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetMatNum);
		entryInfo1.setFMaterialId(f7Bean);

		//仓库FStockId
		String entryWareNum = "ZQ07";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(entryWareNum);
		entryInfo1.setFStockId(f7Bean);

		//仓位
		entryInfo1.setFStockLocId(new CloudCommonFSTOCKF7Bean());

		//班组
		entryInfo1.setFShiftGroupId(new CloudCommonF7Bean());

		//入库类型
		String  inStoreNum = "1";
		entryInfo1.setFInStockType(inStoreNum);

		//单位
		String targetUnit ="yu";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetUnit);
		entryInfo1.setFUnitID(f7Bean);

		String FIsAffectCost = "true";
		entryInfo1.setFIsAffectCost(FIsAffectCost);

		//基本单位
		String BaseUnitId = "yu";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(BaseUnitId);
		entryInfo1.setFBaseUnitId(f7Bean);
		entryInfo1.setFExtAuxUnitId(new CloudCommonF7Bean());
		entryInfo1.setFBomId(new CloudCommonF7Bean());

		//库存状态
		String targetStatus = "KCZT01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetStatus);
		entryInfo1.setFStockStatusId(f7Bean);

		//保管者
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		entryInfo1.setFKeeperId(f7Bean);

		//保管者类型
		String KeeperTypeId= "BD_KeeperOrg";
		entryInfo1.setFKeeperTypeId(KeeperTypeId);
		//生产日期FProduceDate
		entryInfo1.setFProduceDate(null);
		//有效期至
		entryInfo1.setFExpiryDate(null);
		entryInfo1.setFSecUnitId(new CloudCommonF7Bean());

		//数量
		String targetustQty =String.valueOf(entryInfo.getHealthQty());
		entryInfo1.setFMustQty(targetustQty);
		entryInfo1.setFSecRealQty(null);
		entryInfo1.setFBaseMustQty(targetustQty);
		entryInfo1.setFExtAuxUnitQty(null);
		//实收数量
		entryInfo1.setFRealQty(targetustQty);
		//库存单位实收数量
		entryInfo1.setFStockRealQty(targetustQty);
		//基本单位实收数量
		entryInfo1.setFBaseRealQty(targetustQty);




		//养殖日报表头的当前成本对象
		StockingBatchInfo batchIfo = null;
		try {
			batchIfo = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(new ObjectUuidPK(entryInfo.getStrockbatch().getId().toString()));
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//批号
		String FLot = batchIfo.getNumber().substring(0, 8);
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FLot); 
		entryInfo1.setFLot(f7Bean);

		//生产编号
		entryInfo1.setFProductNo(FLot);

		//生产车间
		String WorkShopId = "ZQ08";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(WorkShopId);
		entryInfo1.setFWorkShopId1(f7Bean);

		//货主类型
		String OwnerEntryTypeId = "BD_OwnerOrg";
		entryInfo1.setFOwnerTypeId(OwnerEntryTypeId);

		//货主
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(targetOrgNum);
		entryInfo1.setFOwnerId(f7Bean);

		//库存单位
		String StockUnitId = "yu";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(StockUnitId);
		entryInfo1.setFStockUnitId(f7Bean);

		//辅助属性
		entryInfo1.setFAuxpropId(new CloudCommonFAUXPROF7Bean());

		//源单据编号
		entryInfo1.setF_abc_SourceBillNo(null);

		//计划跟踪号
		entryInfo1.setFMtoNo(null);





		//定义一个jsonArray
		JSONArray entryArray = new JSONArray();
		String entryStr = JSONObject.toJSONString(entryInfo1, SerializerFeature.WriteNullStringAsEmpty);
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
