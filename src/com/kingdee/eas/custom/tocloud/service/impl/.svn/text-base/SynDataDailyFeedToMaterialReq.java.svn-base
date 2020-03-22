package com.kingdee.eas.custom.tocloud.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseFactory;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.custom.tocloud.SynDateLogEntryInfo;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonDataBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonFAUXPROF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonFSTOCKF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonStaffF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudMaterialReqBean;
import com.kingdee.eas.custom.tocloud.bean.CloudMaterialReqEntryBean;
import com.kingdee.eas.custom.tocloud.service.ISynData;
import com.kingdee.eas.custom.tocloud.utils.BaseDataUtil;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo;

public class SynDataDailyFeedToMaterialReq implements ISynData {

	/**
	 * 业务类型是饲喂信息分录--生成cloud领料出库单（001）
	 */
	@Override
	public String synData(Context ctx, 
			String billId, 
			String entryId, 
			String targetSystemId, 
			String bizTypeId,
			List<String> errorMessage,
			SynDateLogEntryInfo synDateLogEntryInfo)
			throws Exception {
		
		StockingBreedDailyInfo stockingInfo = StockingBreedDailyFactory.getLocalInstance(ctx).getStockingBreedDailyInfo(new ObjectUuidPK(billId));
		StockingBreedDailyEntryInfo entryInfo = StockingBreedDailyEntryFactory.getLocalInstance(ctx).getStockingBreedDailyEntryInfo(new ObjectUuidPK(entryId));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		//创建领料出库单表头
		CloudMaterialReqBean cloudMaterialReqBean = new CloudMaterialReqBean();

		CloudCommonF7Bean f7Bean = null;

		ObjectUuidPK objectUuidpk = null;
		
		//设置id
		String commomStr = "0";
		cloudMaterialReqBean.setFID(commomStr);

		//单据编号
		commomStr = "";
		cloudMaterialReqBean.setFBillNo(commomStr);

		//单据类型
		commomStr = "JDSCLL01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(commomStr);
		cloudMaterialReqBean.setFBillType(f7Bean);

		//日期
		commomStr = sdf.format(stockingInfo.getBizDate());
		cloudMaterialReqBean.setFDate(commomStr);

		//备注
		commomStr = "养殖日报饲喂信息数据同步";
		cloudMaterialReqBean.setFDescription(commomStr);

		//发料组织
		CompanyOrgUnitInfo orgInfo = stockingInfo.getCompany();
		if(orgInfo != null){
			objectUuidpk = new ObjectUuidPK(orgInfo.getId().toString());
			orgInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(objectUuidpk);
			commomStr = orgInfo.getNumber();
			f7Bean = new CloudCommonF7Bean();
			f7Bean.setFNumber(commomStr);
			cloudMaterialReqBean.setFStockOrgId(f7Bean);
		}else {
			throw new Exception("组织不能为空");
		}
		

		//库存组
		commomStr = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(commomStr);
		cloudMaterialReqBean.setFStockerGroupId(f7Bean);

		//仓管员
		commomStr = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(commomStr);
		cloudMaterialReqBean.setFStockerId(f7Bean);

		//领料人
		commomStr = "";
		CloudCommonStaffF7Bean f8Bean = new CloudCommonStaffF7Bean();
		f8Bean.setFStaffNumber(commomStr);
		cloudMaterialReqBean.setFPickerId(f8Bean);

		//本位币
		commomStr = "PRE001";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(commomStr);
		cloudMaterialReqBean.setFCurrId(f7Bean);

		//货主类型
		commomStr = "BD_OwnerOrg";
		cloudMaterialReqBean.setFOwnerTypeId0(commomStr);

		//货主
		commomStr = orgInfo.getNumber();
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(commomStr);
		cloudMaterialReqBean.setFOwnerId0(f7Bean);

		//生产组织
		commomStr = orgInfo.getNumber();
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(commomStr);
		cloudMaterialReqBean.setFPrdOrgId(f7Bean);

		//生产车间
		FarmHouseEntryInfo houseInfo = entryInfo.getHouse();
		if(houseInfo != null){
			objectUuidpk = new ObjectUuidPK(houseInfo.getId().toString());
			houseInfo = FarmHouseEntryFactory.getLocalInstance(ctx).getFarmHouseEntryInfo(objectUuidpk);
			commomStr = houseInfo.getNumber();
			f7Bean = new CloudCommonF7Bean();
			f7Bean.setFNumber(commomStr);
			cloudMaterialReqBean.setFWorkShopId(f7Bean);
		} else {
			throw new Exception("棚舍不能为空");
		}
		

		//跨组织业务类型
		commomStr = "OverOrgPick";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(commomStr);
		cloudMaterialReqBean.setFTransferBizTypeId(f7Bean);

		//序列号上传
		commomStr = "";
		cloudMaterialReqBean.setFScanBox(commomStr);

		//班次
		//TODO 新账套单据上没有班次
		commomStr = "01";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(commomStr);
		cloudMaterialReqBean.setF_F_BANZ1(f7Bean);


		JSONArray entryArray = new JSONArray();

		//设置分录
		CloudMaterialReqEntryBean cloudMaterialReqEntryBeanInfo = new CloudMaterialReqEntryBean();

		//设置FEntryID
		commomStr = "0";
		cloudMaterialReqEntryBeanInfo.setFEntryID(commomStr);

		//物料编码
		//如果公禽料 不为空  则取公禽料  为空则取母禽料 都为空 抛出异常
		MaterialInfo materialInfo = null;
		if(entryInfo.getMaterial() != null && entryInfo.getDailyQtyAll() != null &&entryInfo.getDailyQtyAll().compareTo(BigDecimal.ZERO) > 0){
			objectUuidpk = new ObjectUuidPK(entryInfo.getMaterial().getId().toString());
			materialInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(objectUuidpk);
			commomStr = materialInfo.getNumber();
			f7Bean = new CloudCommonF7Bean();
			f7Bean.setFNumber(commomStr);
			cloudMaterialReqEntryBeanInfo.setFMaterialId(f7Bean);
			
			//单位
			MeasureUnitInfo unitInfo = materialInfo.getBaseUnit();
			if(unitInfo != null){
				objectUuidpk = new ObjectUuidPK(unitInfo.getId().toString());
				unitInfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(objectUuidpk);
				commomStr = unitInfo.getNumber().toLowerCase();
				f7Bean = new CloudCommonF7Bean();
				f7Bean.setFNumber(commomStr);
				cloudMaterialReqEntryBeanInfo.setFUnitID(f7Bean);
				
				//基本单位
				f7Bean = new CloudCommonF7Bean();
				f7Bean.setFNumber(commomStr);
				cloudMaterialReqEntryBeanInfo.setFBaseUnitId(f7Bean);
				
				//申请数量
				commomStr = String.valueOf(entryInfo.getDailyQtyAll());
				cloudMaterialReqEntryBeanInfo.setFAppQty(commomStr);
				//基本单位数量
				cloudMaterialReqEntryBeanInfo.setFBaseActualQty(commomStr);
				//实发数量
				cloudMaterialReqEntryBeanInfo.setFActualQty(commomStr);
				//基本单位申请数量
				cloudMaterialReqEntryBeanInfo.setFBaseAppQty(commomStr);
				
			} else {
				throw new Exception("请维护物料的基本计量单位");
			}
			
			//库存单位  用辅助计量单位对照
			unitInfo =  materialInfo.getAssistUnit();
			if(unitInfo != null){
				objectUuidpk = new ObjectUuidPK(unitInfo.getId().toString());
				unitInfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(objectUuidpk);
				//库存单位
				commomStr = unitInfo.getNumber();
				f7Bean = new CloudCommonF7Bean();
				f7Bean.setFNumber(commomStr);
				cloudMaterialReqEntryBeanInfo.setFStockUnitId(f7Bean);
				
				//库存单位实发数量
				commomStr = String.valueOf(entryInfo.getPackageQty());
				cloudMaterialReqEntryBeanInfo.setFStockActualQty(commomStr);
				
			} else {
				throw new Exception("请维护物料的辅助计量单位");
			}
		} else if (entryInfo.getFeMaterail() != null && entryInfo.getFemaleDailyQty() != null && entryInfo.getFemaleDailyQty().compareTo(BigDecimal.ZERO) > 0) {
			objectUuidpk = new ObjectUuidPK(entryInfo.getFeMaterail().getId().toString());
			materialInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(objectUuidpk);
			commomStr = materialInfo.getNumber();
			f7Bean = new CloudCommonF7Bean();
			f7Bean.setFNumber(commomStr);
			cloudMaterialReqEntryBeanInfo.setFMaterialId(f7Bean);
			
			//单位
			MeasureUnitInfo unitInfo = materialInfo.getBaseUnit();
			if(unitInfo != null){
				objectUuidpk = new ObjectUuidPK(unitInfo.getId().toString());
				unitInfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(objectUuidpk);
				commomStr = unitInfo.getNumber().toLowerCase();
				f7Bean = new CloudCommonF7Bean();
				f7Bean.setFNumber(commomStr);
				cloudMaterialReqEntryBeanInfo.setFUnitID(f7Bean);
				
				//基本单位
				f7Bean = new CloudCommonF7Bean();
				f7Bean.setFNumber(commomStr);
				cloudMaterialReqEntryBeanInfo.setFBaseUnitId(f7Bean);
				
				//申请数量
				commomStr = String.valueOf(entryInfo.getFemaleDailyQty());
				cloudMaterialReqEntryBeanInfo.setFAppQty(commomStr);
				//基本单位数量
				cloudMaterialReqEntryBeanInfo.setFBaseActualQty(commomStr);
				//实发数量
				cloudMaterialReqEntryBeanInfo.setFActualQty(commomStr);
				//基本单位申请数量
				cloudMaterialReqEntryBeanInfo.setFBaseAppQty(commomStr);
				
			} else {
				throw new Exception("请维护物料的基本计量单位");
			}
			
			//库存单位  用辅助计量单位对照
			unitInfo =  materialInfo.getAssistUnit();
			if(unitInfo != null){
				objectUuidpk = new ObjectUuidPK(unitInfo.getId().toString());
				unitInfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(objectUuidpk);
				//库存单位
				commomStr = unitInfo.getNumber();
				f7Bean = new CloudCommonF7Bean();
				f7Bean.setFNumber(commomStr);
				cloudMaterialReqEntryBeanInfo.setFStockUnitId(f7Bean);
				
				//库存单位实发数量
				commomStr = String.valueOf(entryInfo.getPackageQty());
				cloudMaterialReqEntryBeanInfo.setFStockActualQty(commomStr);
				
			} else {
				throw new Exception("请维护物料的辅助计量单位");
			}
			
		} else {
			throw new Exception("物料不能为空");
		}
		

		//辅助属性
		commomStr = "";
		CloudCommonFAUXPROF7Bean  FAuxPropIdfaux = new CloudCommonFAUXPROF7Bean();
		FAuxPropIdfaux.setFAUXPROPID__FOPCODE(commomStr);
		cloudMaterialReqEntryBeanInfo.setFAuxPropId(FAuxPropIdfaux);

		//BOM版本
		commomStr = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(commomStr);
		cloudMaterialReqEntryBeanInfo.setFBomId(f7Bean);
		
		//辅单位 
		commomStr = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(commomStr);
		cloudMaterialReqEntryBeanInfo.setFExtAuxUnitId(f7Bean);
		
		//库存辅单位
		commomStr = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(commomStr);
		cloudMaterialReqEntryBeanInfo.setFSecUnitId(f7Bean);
		
		//实发数量（辅单位）
		commomStr = "0";
		cloudMaterialReqEntryBeanInfo.setFExtAuxUnitQty(commomStr);
		
		
		//实发数量(库存辅单位)
		commomStr = "0";
		cloudMaterialReqEntryBeanInfo.setFSecActualQty(commomStr);
		
		//仓库
		WarehouseInfo wareHouseInfo  = houseInfo.getSlwarehouse();
		if(wareHouseInfo != null){
			objectUuidpk = new ObjectUuidPK(wareHouseInfo.getId().toString());
			wareHouseInfo = WarehouseFactory.getLocalInstance(ctx).getWarehouseInfo(objectUuidpk);
			commomStr = wareHouseInfo.getNumber();
			f7Bean = new CloudCommonF7Bean();
			f7Bean.setFNumber(commomStr);
			cloudMaterialReqEntryBeanInfo.setFStockId(f7Bean);	
		} else {
			throw new Exception("请维护棚舍对应的饲料仓库");
		}

		//仓位
		commomStr = "";
		CloudCommonFSTOCKF7Bean FStockLocIdStock = new CloudCommonFSTOCKF7Bean();
		FStockLocIdStock.setFSTOCKLOCID__FOPCODE(commomStr);
		cloudMaterialReqEntryBeanInfo.setFStockLocId(FStockLocIdStock);

		//批号  如果物料启用批次关联 需要赋值
		commomStr = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(commomStr);
		cloudMaterialReqEntryBeanInfo.setFLot(f7Bean);
//		StockingBatchInfo batchInfo = stockingInfo.getStockingBatch();
//		if(batchInfo != null){
//			objectUuidpk = new ObjectUuidPK(batchInfo.getId().toString());
//			batchInfo = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(objectUuidpk);
//			commomStr = batchInfo.getNumber().substring(0,8);
//			f7Bean = new CloudCommonF7Bean();
//			f7Bean.setFNumber(commomStr);
//			cloudMaterialReqEntryBeanInfo.setFLot(f7Bean);
//		} else {
//			throw new Exception("请维护养殖日报的养殖批次");
//		}
		

		//生产对象 需要做一个对应关系  当前阶段和成本对象对应关系  类似于非合格蛋的处理方式 封装一个方法
//		stockingInfo.getNowBreedStage();
//		commomStr = "06.01.01.003";
		commomStr = BaseDataUtil.getTargetBaseDataNumberByMap(ctx, targetSystemId, "nuiYNRcVTnqpYLz0uikkyrsXwY4=", String.valueOf(stockingInfo.getNowBreedStage().getValue()));
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(commomStr);
		cloudMaterialReqEntryBeanInfo.setFProductId(f7Bean);
		

		//生产编号   暂时先录入批次号
		StockingBatchInfo batchInfo = stockingInfo.getStockingBatch();
		if(batchInfo != null){
			objectUuidpk = new ObjectUuidPK(batchInfo.getId().toString());
			batchInfo = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(objectUuidpk);
			commomStr = batchInfo.getNumber().substring(0,8);
			cloudMaterialReqEntryBeanInfo.setFProductNo(commomStr);
		} else {
			throw new Exception("请维护养殖日报的养殖批次");
		}

		//生产编号影响成本
		commomStr = "true";
		cloudMaterialReqEntryBeanInfo.setFIsAffectCost(commomStr);

		//产品组
		commomStr = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(commomStr);
		cloudMaterialReqEntryBeanInfo.setFPRODUCTGROUPID(f7Bean);
		
		//货主类型
		commomStr = "BD_OwnerOrg";
		cloudMaterialReqEntryBeanInfo.setFOwnerTypeId(commomStr);

		//车间
		commomStr = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(commomStr);
		cloudMaterialReqEntryBeanInfo.setFEntryWorkShopId(f7Bean);

		//货主
		commomStr = orgInfo.getNumber();
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(commomStr);
		cloudMaterialReqEntryBeanInfo.setFOwnerId(f7Bean);

		//成本价
		cloudMaterialReqEntryBeanInfo.setFPrice(commomStr);

		//总成本
		cloudMaterialReqEntryBeanInfo.setFAmount(commomStr);

		//产品货主类型
		commomStr = "BD_OwnerOrg";
		cloudMaterialReqEntryBeanInfo.setFParentOwnerTypeId(commomStr);

		//产品货主
		commomStr = orgInfo.getNumber();
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(commomStr);
		cloudMaterialReqEntryBeanInfo.setFParentOwnerId(f7Bean);

		//服务上下文
		commomStr = "";
		cloudMaterialReqEntryBeanInfo.setFServiceContext(commomStr);
		
		//库存状态
		commomStr = "KCZT01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(commomStr);
		cloudMaterialReqEntryBeanInfo.setFStockStatusId(f7Bean);

		//生产日期
		commomStr = "";
		cloudMaterialReqEntryBeanInfo.setFProduceDate(commomStr);

		//有效期至
		commomStr = "";
		cloudMaterialReqEntryBeanInfo.setFExpiryDate(commomStr);
		
		//备注
		commomStr = "";
		cloudMaterialReqEntryBeanInfo.setFEntrtyMemo(commomStr);

		//计划跟踪号
		commomStr = "";
		cloudMaterialReqEntryBeanInfo.setFMtoNo(commomStr);

		//保管者类型
		commomStr = "BD_KeeperOrg";
		cloudMaterialReqEntryBeanInfo.setFKeeperTypeId(commomStr);

		//保管者
		commomStr = orgInfo.getNumber();
		f7Bean  = new CloudCommonF7Bean();
		f7Bean.setFNumber(commomStr);
		cloudMaterialReqEntryBeanInfo.setFKeeperId(f7Bean);

		//调整
		commomStr = "";
		cloudMaterialReqEntryBeanInfo.setF_abc_Text(commomStr);

		entryArray.add(cloudMaterialReqEntryBeanInfo);

		//设置表头的FEntity
		cloudMaterialReqBean.setFEntity(entryArray);

		//将实体转化为jsonObject
		String manuString = JSONObject.toJSONString(cloudMaterialReqBean, SerializerFeature.WriteNullStringAsEmpty);
		JSONObject allJson = JSONObject.parseObject(manuString, Feature.OrderedField);

		//data（必填）
		CloudCommonDataBean cloudCommonDataBean = new CloudCommonDataBean();
		cloudCommonDataBean.setCreator("");
		cloudCommonDataBean.setNeedUpDateFields(null);
		cloudCommonDataBean.setModel(allJson);

		//新建CloudCommonBean对象
		CloudCommonBean commonBean = new CloudCommonBean();
		commonBean.setFormid("SP_PickMtrl");
		commonBean.setData(cloudCommonDataBean);

		//将实体转化为字符串
		return JSONObject.toJSONString(commonBean, SerializerFeature.WriteNullStringAsEmpty);
		
	}

}
