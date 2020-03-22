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
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
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
import com.kingdee.eas.custom.tocloud.bean.CloudCommonStaffF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudMaterialReqBean;
import com.kingdee.eas.custom.tocloud.bean.CloudMaterialReqEntryBean;
import com.kingdee.eas.custom.tocloud.service.ISynData;
import com.kingdee.eas.custom.tocloud.utils.BaseDataUtil;
import com.kingdee.eas.custom.tocloud.utils.K3CloudUtil;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyImmuneEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyImmuneEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo;


/**
 * 养殖日报免疫信息分录同步cloud领料出库单
 * @author
 *
 */
public class SynDataImmuneToMaterialReq implements ISynData{

//	@Override
	public String synData(Context ctx, 
			String billId, 
			String entryId,
			String 
			targetSystemId, 
			String bizTypeId, 
			List<String> errorMessage,
			SynDateLogEntryInfo synDateLogEntryInfo) throws Exception {



		StockingBreedDailyInfo stockingInfo = StockingBreedDailyFactory.getLocalInstance(ctx).getStockingBreedDailyInfo(new ObjectUuidPK(billId));
		StockingBreedDailyImmuneEntryInfo entryInfo = StockingBreedDailyImmuneEntryFactory.getLocalInstance(ctx).getStockingBreedDailyImmuneEntryInfo(new ObjectUuidPK(entryId));

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
		commomStr = "养殖日报免疫信息数据同步";
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







		//获取物料
		MaterialInfo materialInfo1 = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(entryInfo.getVaccineMaterial().getId()));


		JSONObject obj = new JSONObject();
		obj.put("formId", "STK_Inventory");
		JSONObject dataObject = new JSONObject();
		dataObject.put("FormId", "STK_Inventory");
		dataObject.put("FieldKeys", "FBaseQty,FProduceDate,FExpiryDate");
		dataObject.put("FilterString", "FMaterialId.FNumber='"+materialInfo1.getNumber()+"'");
		dataObject.put("OrderString", "FProduceDate");
		dataObject.put("TopRowCount", "0");
		dataObject.put("StartRow", "0");
		dataObject.put("Limit", "0");
		obj.put("data", dataObject);
		String res = K3CloudUtil.ExecuteBillQuery(JSONObject.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty));

		JSONArray jsonArray = JSONArray.parseArray(res);
		System.out.println(jsonArray);
		JSONArray jsonA1 = null;
		//疫苗使用量
		BigDecimal useQty = entryInfo.getVaccineUsedQty();
		//设置(使用量-即时库存量A) <= 0时的辨别标准
		boolean checkA = false;
		//设置(使用量-即时库存量A) > 0 时的辨别标准
		boolean checkB = false;
		for(int i=0,size = jsonArray.size();i < size;i++){
			jsonA1 = (JSONArray) jsonArray.get(i);
			//即时库存量
			BigDecimal qty = (BigDecimal) jsonA1.get(0);
			//有效期从：
			String beginDate = jsonA1.getString(1);
			//有效期至：
			String endDate = jsonA1.getString(2);
			//剩余量 = 物料使用量  - 即时库存物料剩余量  ,既是剩余量又是使用量
			useQty = useQty.subtract(qty);

			//即时库存可能查询出多条记录，如果第一条记录的数量为0就直接返回
			if(qty.compareTo(BigDecimal.ZERO) == 0){
				continue;
			}

			//情况1 只执行一次
			if(checkA){
				continue;
			}




			// 情况1：  剩余使用量 = (使用量 - 即时库存量A)  <= 0
			if(useQty.compareTo(BigDecimal.ZERO) <= 0){
				checkA = true;


				//设置分录
				CloudMaterialReqEntryBean cloudMaterialReqEntryBeanInfo = new CloudMaterialReqEntryBean();

				//设置FEntryID
				commomStr = "0";
				cloudMaterialReqEntryBeanInfo.setFEntryID(commomStr);



				//如果checkB = true ,就说明 是从 “情况2”里面走出来的---- 数量应该设置“剩余使用量”
				if(checkB){
					//物料编码
					//如果疫苗不为空 抛出异常
					MaterialInfo materialInfo = null;
					if(entryInfo.getVaccineMaterial() != null){
						objectUuidpk = new ObjectUuidPK(entryInfo.getVaccineMaterial().getId().toString());
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
							commomStr = String.valueOf(qty.add(useQty));
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
							commomStr = String.valueOf(qty.add(useQty));
							cloudMaterialReqEntryBeanInfo.setFStockActualQty(commomStr);

						} 
					} 

				}else{
					//物料编码
					//如果疫苗不为空 抛出异常
					MaterialInfo materialInfo = null;
					if(entryInfo.getVaccineMaterial() != null){
						objectUuidpk = new ObjectUuidPK(entryInfo.getVaccineMaterial().getId().toString());
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
							commomStr = String.valueOf(entryInfo.getVaccineUsedQty());
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
							commomStr = String.valueOf(entryInfo.getVaccineUsedQty());
							cloudMaterialReqEntryBeanInfo.setFStockActualQty(commomStr);

						} 
					}
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
				commomStr = "ZQ04";
				f7Bean = new CloudCommonF7Bean();
				f7Bean.setFNumber(commomStr);
				cloudMaterialReqEntryBeanInfo.setFStockId(f7Bean);	

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


				//生产对象
//				commomStr = BaseDataUtil.getTargetBaseDataNumberByMap(ctx, targetSystemId, "nuiYNRcVTnqpYLz0uikkyrsXwY4=", String.valueOf(stockingInfo.getNowBreedStage().getValue()));
				commomStr = "06.03.01.003";
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
					throw new Exception("请维护药品处方单批次");
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

				//生产日期
				commomStr = beginDate;
				cloudMaterialReqEntryBeanInfo.setFProduceDate(commomStr);

				//有效期至
				commomStr = endDate;
				cloudMaterialReqEntryBeanInfo.setFExpiryDate(commomStr);

				entryArray.add(cloudMaterialReqEntryBeanInfo);
			}




			//情况2： 剩余使用量 = (使用量 - 即时库存量A) > 0
			if(useQty.compareTo(BigDecimal.ZERO) > 0){
				checkB = true;

				//设置分录
				CloudMaterialReqEntryBean cloudMaterialReqEntryBeanInfo = new CloudMaterialReqEntryBean();

				//设置FEntryID
				commomStr = "0";
				cloudMaterialReqEntryBeanInfo.setFEntryID(commomStr);

				//物料编码
				//如果疫苗不为空 抛出异常
				MaterialInfo materialInfo = null;
				if(entryInfo.getVaccineMaterial() != null){
					objectUuidpk = new ObjectUuidPK(entryInfo.getVaccineMaterial().getId().toString());
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
						commomStr = String.valueOf(qty);
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

						//库存单位实发数量 = 即时库存量
						commomStr = String.valueOf(qty);
						cloudMaterialReqEntryBeanInfo.setFStockActualQty(commomStr);
					} 
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


				//生产对象
//				commomStr = BaseDataUtil.getTargetBaseDataNumberByMap(ctx, targetSystemId, "nuiYNRcVTnqpYLz0uikkyrsXwY4=", String.valueOf(stockingInfo.getNowBreedStage().getValue()));
				commomStr = "06.03.01.003";
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
					throw new Exception("请维护药品处方单批次");
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

				//生产日期
				commomStr = beginDate;
				cloudMaterialReqEntryBeanInfo.setFProduceDate(commomStr);

				//有效期至
				commomStr = endDate;
				cloudMaterialReqEntryBeanInfo.setFExpiryDate(commomStr);

				entryArray.add(cloudMaterialReqEntryBeanInfo);

			}
		}
		//如果遍历完成之后，使用量还是大于零，就说明疫苗不够了，抛出异常
		if(useQty.compareTo(BigDecimal.ZERO) > 0){
			throw new Exception( "该免疫物料:"+materialInfo1.getName()+" 的库存不足，缺少量为："+useQty);
		}



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
