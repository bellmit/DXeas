package com.kingdee.eas.custom.tocloud.service.impl;

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
import com.kingdee.eas.custom.tocloud.SynDateLogEntryInfo;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonDataBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonFAUXPROF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonFSTOCKF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonStaffF7Bean;
import com.kingdee.eas.custom.tocloud.bean.OtherOutWarehsBillBean;
import com.kingdee.eas.custom.tocloud.bean.OtherOutWarehsBillEntry;
import com.kingdee.eas.custom.tocloud.service.ISynData;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyMatUserEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyMatUserEntryInfo;

public class SynDataMaTUseToOtherOutWare implements ISynData {

	/**
	 * 业务类型是物料领用--生成cloud其他出库单(005)
	 */
	@Override
	public String synData(Context ctx, String billId, String entryId,
			String targetSystemId, String bizTypeId, List<String> errorMessage,
			SynDateLogEntryInfo synDateLogEntryInfo) throws Exception {
		// TODO Auto-generated method stub

		//实例化
		StockingBreedDailyInfo stockingInfo = StockingBreedDailyFactory.getLocalInstance(ctx).getStockingBreedDailyInfo(new ObjectUuidPK(billId));
		StockingBreedDailyMatUserEntryInfo matUseInfo = StockingBreedDailyMatUserEntryFactory.getLocalInstance(ctx).getStockingBreedDailyMatUserEntryInfo(new ObjectUuidPK(entryId));

		//设定日期显示格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");



		//定义一个其他出库单分录
		OtherOutWarehsBillBean billInfo = new OtherOutWarehsBillBean();
		CloudCommonF7Bean f7Bean = null;
		//fid
		billInfo.setFID("0");

		//单据编号
		billInfo.setFBillNo(null);

		//单据类型
		String FBillTypeID = "QTCKD01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FBillTypeID);
		billInfo.setFBillTypeID(f7Bean);

		//库存组织
		String FStockOrgId = stockingInfo.getCompany().getNumber();
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockOrgId);
		billInfo.setFStockOrgId(f7Bean);

		//领用组织
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockOrgId);
		billInfo.setFPickOrgId(f7Bean);

		//库存方向
		String FStockDirect = "GENERAL";
		billInfo.setFStockDirect(FStockDirect);

		//日期
		String FDate = stockingInfo.getBizDate().toString();
		billInfo.setFDate(FDate);

		//客户
		billInfo.setFCustId(new CloudCommonF7Bean());

		//领料部门
		String farm = "ZQ06";
		FarmInfo farmInfo = FarmFactory.getLocalInstance(ctx).getFarmInfo(new ObjectUuidPK(stockingInfo.getFarm().getId()));
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(farm);
		billInfo.setFDeptId(f7Bean);


		//领料人
		billInfo.setFPickerId( new CloudCommonStaffF7Bean());

		//仓管员
		billInfo.setFStockerId(new CloudCommonF7Bean());

		//库存组
		billInfo.setFStockerGroupId(new CloudCommonF7Bean());

		//业务类型
		String FBizType = "0";
		billInfo.setFBizType(FBizType);

		//货主类型
		String FOwnerTypeIdHead = "BD_OwnerOrg";
		billInfo.setFOwnerTypeIdHead(FOwnerTypeIdHead);

		//货主
		String FOwnerIdHead = "TYZQ";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FOwnerIdHead);
		billInfo.setFOwnerIdHead(f7Bean);

		//备注
		String FNote = "养殖日报同步";
		billInfo.setFNote(FNote);

		//本位币
		String FBaseCurrId = "PRE001";		
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FBaseCurrId);
		billInfo.setFBaseCurrId(f7Bean);

		//序列号上传
		String FScanBox = "FScanBox";
		billInfo.setFScanBox(FScanBox);

		//出库类型
		String F_abc_Base = "001";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(F_abc_Base);
		billInfo.setF_abc_Base(f7Bean);





		//定义一个其他出库单分录
		OtherOutWarehsBillEntry entryInfo = new OtherOutWarehsBillEntry();
		//定义一个jsonArray
		JSONArray entryArray = new JSONArray();

		//分录ID
		String FEntryID = "0";
		entryInfo.setFEntryID(FEntryID);

		//物料编码
		MaterialInfo FMaterialId = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(matUseInfo.getMatNum().getId()));
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FMaterialId.getNumber());
		entryInfo.setFMaterialId(f7Bean);

		//辅助属性
		entryInfo.setFAuxPropId(new CloudCommonFAUXPROF7Bean());

		//单位
		String FUnitID = "01";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FUnitID);
		entryInfo.setFUnitID(f7Bean);

		//实发数量
		String FQty = matUseInfo.getMatQty().toString();
		entryInfo.setFQty(FQty);

		//基本单位
		String FBaseUnitId = "01";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FBaseUnitId);
		entryInfo.setFBaseUnitId(f7Bean);

		//发货仓库
		String FStockId = null;


		//北马养殖场 石粉物料
		if("01.02.001".equalsIgnoreCase(FMaterialId.getNumber()) && "ZQ06".equalsIgnoreCase(farmInfo.getNumber())){
			FStockId = "ZQ0200";
		}
		//海岱养殖场  石粉物料
		if("01.02.001".equalsIgnoreCase(FMaterialId.getNumber()) && "ZQ07".equalsIgnoreCase(farmInfo.getNumber())){
			FStockId = "ZQ0300";
		}
		if(!"01.02.001".equalsIgnoreCase(FMaterialId.getNumber())){
			FStockId = "ZQ08";
		}


		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockId);
		entryInfo.setFStockId(f7Bean);

		//仓位
		entryInfo.setFStockLocId(new CloudCommonFSTOCKF7Bean());

		//批号
		String FLot = "";
		entryInfo.setFLot(new CloudCommonF7Bean());

		//产品组
		entryInfo.setFPRODUCTGROUPID(new CloudCommonF7Bean());

		//备注
		entryInfo.setFEntryNote(null);

		//BOM版本
		entryInfo.setFBomId(new CloudCommonF7Bean());

		//项目编号
		entryInfo.setFProjectNo(null);

		//生产日期
		entryInfo.setFProduceDate(null);

		//服务上下文
		entryInfo.setFServiceContext(null);

		//库存状态
		String FStockStatusId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockStatusId);
		entryInfo.setFStockStatusId(f7Bean);

		//计划跟踪号
		entryInfo.setFMtoNo(null);

		//成本项目
		entryInfo.setFCostItem(new CloudCommonF7Bean());

		//保管者类型
		String FKeeperTypeId = "BD_KeeperOrg";
		entryInfo.setFKeeperTypeId(FKeeperTypeId);

		//参加费用分配
		String FDistribution = "false";
		entryInfo.setFDistribution(FDistribution);

		//保管者
		String FKeeperId = "";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FKeeperId);
		entryInfo.setFKeeperId(f7Bean);

		//辅单位
		entryInfo.setFExtAuxUnitId(new CloudCommonF7Bean());

		//单价
		String F_abc_Price = "0";
		entryInfo.setF_abc_Price(F_abc_Price);

		//实发数量(辅单位)
		String FExtAuxUnitQty = "0";
		entryInfo.setFExtAuxUnitQty(FExtAuxUnitQty);

		//金额
		String F_abc_Amount = "0";
		entryInfo.setF_abc_Amount(F_abc_Amount);


		//创建实体List
		String entryStr = JSONObject.toJSONString(entryInfo, SerializerFeature.WriteNullStringAsEmpty);
		JSONObject entryJson = JSONObject.parseObject(entryStr, Feature.OrderedField);


		entryArray.add(entryJson);


		//设置  表头的 FEntity值
		billInfo.setFEntity(entryArray);


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
		commonBean.setFormid("STK_MisDelivery");
		commonBean.setData(cloudCommonDataBean);

		//将实体转化为字符串
		return JSONObject.toJSONString(commonBean, SerializerFeature.WriteNullStringAsEmpty);
	}
}
