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
import com.kingdee.eas.custom.tocloud.bean.CloudCommonStaffF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudManufactureReturnBill;
import com.kingdee.eas.custom.tocloud.bean.CloudManufactureReturnBillEntry;
import com.kingdee.eas.custom.tocloud.service.ISynData;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionEntryFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionEntryInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo;
//import com.kingdee.eas.farm.carnivorous.feedbiz.OtherFeedRecBillEntryFactory;
//import com.kingdee.eas.farm.carnivorous.feedbiz.OtherFeedRecBillEntryInfo;
//import com.kingdee.eas.farm.carnivorous.feedbiz.OtherFeedRecBillFactory;
//import com.kingdee.eas.farm.carnivorous.feedbiz.OtherFeedRecBillInfo;

/**
 * 物料领用单同步cloud生产退料单
 * @author wlhl
 *
 */
public class SynDataOtherMatToReturnMaterialReq implements ISynData{

	@Override
	public String synData(Context ctx, String billId, String entryId,
			String targetSystemId, String bizTypeId, List<String> errorMessage,
			SynDateLogEntryInfo synDateLogEntryInfo) throws Exception {
		// TODO Auto-generated method stub
		//实例化
//		OtherFeedRecBillInfo fodderReceptionInfo = OtherFeedRecBillFactory.getLocalInstance(ctx).getOtherFeedRecBillInfo(new ObjectUuidPK(billId));
//		OtherFeedRecBillEntryInfo entryInfo = OtherFeedRecBillEntryFactory.getLocalInstance(ctx).getOtherFeedRecBillEntryInfo(new ObjectUuidPK(entryId));
		//设定日期显示格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		CloudManufactureReturnBill manReturnInfo = new CloudManufactureReturnBill();
		
		CloudCommonF7Bean f7Bean = new CloudCommonF7Bean();
		
		String FID = "0";
		manReturnInfo.setFID(FID);
		
		//单据编号
		String FBillNo = "";
		manReturnInfo.setFBillNo(FBillNo);
		
		//单据类型
		String FBillType = "JDSCTL01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FBillType);
		manReturnInfo.setFBillType(f7Bean);
		
//		//日期
//		String FDate = fodderReceptionInfo.getBizDate().toString();
//		manReturnInfo.setFDate(FDate);
//		
//		//备注
//		String FDescription = "物料领用单同步生产退料单";
//		manReturnInfo.setFDescription(FDescription);
//		
//		//收料组织
//		CompanyOrgUnitInfo storageInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(fodderReceptionInfo.getCompany().getId()));
//		String targetOrgNum = storageInfo.getNumber();
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(targetOrgNum);
//		manReturnInfo.setFStockOrgId(f7Bean);
		
		//库存组
		String FStockerGroupId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockerGroupId);
		manReturnInfo.setFStockerGroupId(f7Bean);
		
		//仓管员
		String FStockerId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockerId);
		manReturnInfo.setFStockerId(f7Bean);
		
		//退料人
		String FReturnerId = "";
		CloudCommonStaffF7Bean stfBean = new CloudCommonStaffF7Bean();
		stfBean.setFStaffNumber(FReturnerId);
		manReturnInfo.setFReturnerId(stfBean);
		
		//本位币
		String FCurrId = "PRE001";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FCurrId);
		manReturnInfo.setFCurrId(f7Bean);
		
		//货主类型
		String FOwnerTypeId0 = "BD_OwnerOrg";
		manReturnInfo.setFOwnerTypeId0(FOwnerTypeId0);
		
//		//货主
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(targetOrgNum);
//		manReturnInfo.setFOwnerId0(f7Bean);
//		
//		//生产组织
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(targetOrgNum);
//		manReturnInfo.setFPrdOrgId(f7Bean);
//		
//		//生产车间
//		FarmerInfo farmInfo = FarmerFactory.getLocalInstance(ctx).getFarmerInfo(new ObjectUuidPK(fodderReceptionInfo.getFarmer().getId()));		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(farmInfo.getNumber());
//		manReturnInfo.setFWorkShopId(f7Bean);
		
		//套数
		String FPloidyQty = "0";
		manReturnInfo.setFPloidyQty(FPloidyQty);
		
		//跨组织业务类型
		String FTransferBizTypeId = "OverOrgPick";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FTransferBizTypeId);
		manReturnInfo.setFTransferBizTypeId(f7Bean);
		
		//序列号上传
		String FScanBox = "";
		manReturnInfo.setFScanBox(FScanBox);
		
		//业务类型
		String FBizType = "NORMAL";
		manReturnInfo.setFBizType(FBizType);
		
		
		
		
		
		JSONArray jsonArray = new JSONArray();
		
		CloudManufactureReturnBillEntry manReturnEntryInfo = new CloudManufactureReturnBillEntry();
		
		String FEntryID = "0";
		manReturnEntryInfo.setFEntryID(FEntryID);
		
//		//物料编码
//		MaterialInfo matInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(entryInfo.getMaterial().getId()));
//		String FMaterialId = matInfo.getNumber();
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(FMaterialId);
//		manReturnEntryInfo.setFMaterialId(f7Bean);
//		
//		//单位
//		String FUnitID = "kg";
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(FUnitID);
//		manReturnEntryInfo.setFUnitID(f7Bean);
//		
//		//申请数量
//		String FAppQty = String.valueOf(entryInfo.getReceiveQty().multiply(new BigDecimal("-1")));
//		manReturnEntryInfo.setFAPPQty(FAppQty);
//		
//		//实退数量
//		manReturnEntryInfo.setFQty(FAppQty);
//		
//		//退料类型
//		String FReturnType = "1";
//		manReturnEntryInfo.setFReturnType(FReturnType);
//		
//		//退料原因
//		String FReturnReason = "";
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(FReturnReason);
//		manReturnEntryInfo.setFReturnReason(f7Bean);
//		
//		//仓库
//		WarehouseInfo wareInfo = WarehouseFactory.getLocalInstance(ctx).getWarehouseInfo(new ObjectUuidPK(entryInfo.getWarehouse().getId()));
//		String FStockId = wareInfo.getNumber();
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(FStockId);
//		manReturnEntryInfo.setFStockId(f7Bean);
		
//		//批号
//		BatchInfo batchInfo = fodderReceptionInfo.getBatch();
//		BatchInfo batchInfo1 = null;
//		if(batchInfo != null){
//			batchInfo1 = BatchFactory.getLocalInstance(ctx).getBatchInfo(new ObjectUuidPK(batchInfo.getId()));
//			String batchNum = batchInfo1.getNumber();
//			f7Bean = new CloudCommonF7Bean();
//			f7Bean.setFNumber("");
//			manReturnEntryInfo.setFLot(f7Bean);
//		} else {
//			throw new Exception("请维护饲料领用单批次");
//		}
		
//		//生产对象
//		String FProductId = "06.03.01.005";
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(FProductId);
//		manReturnEntryInfo.setFProductId(f7Bean);
//		
//		//生产编号
//		String FProductNo = batchInfo1.getNumber();
//		manReturnEntryInfo.setFProductNo(FProductNo);
//		
//		//生产编号影响成本
//		String FIsAffectCost = "true";
//		manReturnEntryInfo.setFIsAffectCost(FIsAffectCost);
//		
//		//产品组
//		String FPRODUCTGROUPID = "";
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(FPRODUCTGROUPID);
//		manReturnEntryInfo.setFPRODUCTGROUPID(f7Bean);
//		
//		//计划跟踪号
//		String FMtoNo = "";
//		manReturnEntryInfo.setFMtoNo(FMtoNo);
//		
//		//主库存单位
//		String FStockUnitId = "UOM001";
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(FStockUnitId);
//		manReturnEntryInfo.setFStockUnitId(f7Bean);
//		
//		//主库存实退数量
//		String FStockQty = "3";
//		manReturnEntryInfo.setFStockQty(FAppQty);
//		
//		
//		String FPrice = "";
//		manReturnEntryInfo.setFPrice(FPrice);
//		
//		
//		
//		String FAmount = "";
//		manReturnEntryInfo.setFAmount(FAmount);
//		
//		//基本单位
//		String FBaseUnitId = "kg";
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(FBaseUnitId);
//		manReturnEntryInfo.setFBaseUnitId(f7Bean);
//		
//		//基本单位申请数量
//		manReturnEntryInfo.setFBaseAppQty(FAppQty);
//		
//		manReturnEntryInfo.setFBaseQty(FAppQty);
//		
//		//货主类型
//		String FOwnerTypeId = "BD_OwnerOrg";
//		manReturnEntryInfo.setFOwnerTypeId(FOwnerTypeId);
//		
//		//辅单位
//		String FExtAuxUnitId = "";
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(FExtAuxUnitId);
//		manReturnEntryInfo.setFExtAuxUnitId(f7Bean);
//		
//		//货主
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(targetOrgNum);
//		manReturnEntryInfo.setFOwnerId(f7Bean);
//		
//		//实退数量（辅单位）
//		String FExtAuxUnitQty = "";
//		manReturnEntryInfo.setFExtAuxUnitQty(FExtAuxUnitQty);
//		
//		//产品货主类型
//		String FParentOwnerTypeId = "BD_OwnerOrg";
//		manReturnEntryInfo.setFParentOwnerTypeId(FParentOwnerTypeId);
//		
//		//产品货主
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(targetOrgNum);
//		manReturnEntryInfo.setFParentOwnerId(f7Bean);
		
		//BOM版本
		String FBomId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FBomId);
		manReturnEntryInfo.setFBomId(f7Bean);
		
		//保管者类型
		String FKeeperTypeId = "BD_KeeperOrg";
		manReturnEntryInfo.setFKeeperTypeId(FKeeperTypeId);
		
		//保管者
		String FKeeperId = "ZL1";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FKeeperId);
		manReturnEntryInfo.setFKeeperId(f7Bean);
		
		//备注
		String FEntrtyMemo = "";
		manReturnEntryInfo.setFEntrtyMemo(FEntrtyMemo);
		
		//库存状态
		String FStockStatusId = "KCZT01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockStatusId);
		manReturnEntryInfo.setFStockStatusId(f7Bean);
		
		//生产日期
		String FProduceDate = "";
		manReturnEntryInfo.setFProduceDate(FProduceDate);
		
		//有效期至
		String FExpiryDate = "";
		manReturnEntryInfo.setFExpiryDate(FExpiryDate);
		
		//库存辅单位
		String FSecUnitId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FSecUnitId);
		manReturnEntryInfo.setFSecUnitId(f7Bean);
		
		//实退数量(库存辅单位)
		String FSecStockQty = "";
		manReturnEntryInfo.setFSecStockQty(FSecStockQty);
		
		
		jsonArray.add(manReturnEntryInfo);
		manReturnInfo.setFEntity(jsonArray);
		
		
		//将实体转化为jsonObject
		String manuString = JSONObject.toJSONString(manReturnInfo, SerializerFeature.WriteNullStringAsEmpty);
		JSONObject allJson = JSONObject.parseObject(manuString, Feature.OrderedField);

		//data（必填）
		CloudCommonDataBean cloudCommonDataBean = new CloudCommonDataBean();
		cloudCommonDataBean.setCreator("");
		cloudCommonDataBean.setNeedUpDateFields(null);
		cloudCommonDataBean.setModel(allJson);

		//新建CloudCommonBean对象
		CloudCommonBean commonBean = new CloudCommonBean();
		commonBean.setFormid("SP_ReturnMtrl");
		commonBean.setData(cloudCommonDataBean);

		//将实体转化为字符串
		return JSONObject.toJSONString(commonBean, SerializerFeature.WriteNullStringAsEmpty);
	}

}
