package com.kingdee.eas.custom.tocloud.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
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
import com.kingdee.eas.custom.tocloud.bean.CloudCommonStaffF7Bean;
import com.kingdee.eas.custom.tocloud.bean.OtherInWarehsBillRecBean;
import com.kingdee.eas.custom.tocloud.bean.OtherInWarehsBillRecEntryBean;
import com.kingdee.eas.custom.tocloud.service.ISynData;
import com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryFactory;
import com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryInfo;
import com.kingdee.eas.farm.hatch.BEggHatchBillFactory;
import com.kingdee.eas.farm.hatch.BEggHatchBillInfo;
import com.kingdee.eas.farm.hatch.HatchBaseDataFactory;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class SynDataBEggHatchToOtherInWare implements ISynData{

	/**
	 * 种蛋上孵单退蛋数量同步其他入库单--数量为正数
	 */
	@Override
	public String synData(Context ctx, String billId, String entryId,
			String targetSystemId, String bizTypeId, List<String> errorMessage,
			SynDateLogEntryInfo synDateLogEntryInfo) throws Exception {

		//实例化
		BEggHatchBillInfo stockingInfo = BEggHatchBillFactory.getLocalInstance(ctx).getBEggHatchBillInfo(new ObjectUuidPK(billId));
		BEggHatchBillEggEntryInfo eggEggInfo = BEggHatchBillEggEntryFactory.getLocalInstance(ctx).getBEggHatchBillEggEntryInfo(new ObjectUuidPK(entryId));
		
		//设定日期显示格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


		//设置其他入库单表头信息
		OtherInWarehsBillRecBean  otherInWarehsBillRecBean = new OtherInWarehsBillRecBean();
		CloudCommonF7Bean f7Bean = null;

		//fid		
		String fid = "0";
		otherInWarehsBillRecBean.setFID(fid);
		//单据编号
		String FBillNo = "";
		otherInWarehsBillRecBean.setFBillNo(FBillNo);

		//单据类型
		String FBillTypeID = "QTRKD01_SYS";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FBillTypeID);
		otherInWarehsBillRecBean.setFBillTypeID(f7Bean);


		//入库组织
//		CompanyOrgUnitInfo companyInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo( new ObjectUuidPK(stockingInfo.getCompany().getId().toString()));

		String FStockOrgId = "TYZQ";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockOrgId);
		otherInWarehsBillRecBean.setFStockOrgId(f7Bean);

		//库存方向
		String FStockDirect = "GENERAL";
		otherInWarehsBillRecBean.setFStockDirect(FStockDirect);

		//日期
		String FDate = sdf.format(stockingInfo.getBizDate());
		otherInWarehsBillRecBean.setFDate(FDate);

		//供应商
		otherInWarehsBillRecBean.setFSUPPLIERID(new CloudCommonF7Bean());

		//部门（棚舍）
//		FarmHouseEntryInfo houseInfo = eggEggInfo.getHouse();
//		if(houseInfo != null){
//			FarmHouseEntryInfo houseInfo1 = FarmHouseEntryFactory.getLocalInstance(ctx).getFarmHouseEntryInfo(new ObjectUuidPK(houseInfo.getId()));
//			f7Bean = new CloudCommonF7Bean();
//			f7Bean.setFNumber(houseInfo1.getNumber());
//			otherInWarehsBillRecBean.setFDEPTID(f7Bean);
//		} else {
//			throw new Exception("棚舍不能为空");
//		}
		
//		HatchBaseDataInfo hatchInfo = HatchBaseDataFactory.getLocalInstance(ctx).getHatchBaseDataInfo(new ObjectUuidPK(stockingInfo.getHatchFactory().getId()));
		StorageOrgUnitInfo hatchInfo = StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(new ObjectUuidPK(stockingInfo.getStorageOrgUnit().getId()));
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(hatchInfo.getNumber());
		otherInWarehsBillRecBean.setFDEPTID(f7Bean);
		
		
		
		

		//验收员
		otherInWarehsBillRecBean.setFACCEPTANCE(new CloudCommonStaffF7Bean());
		//仓管员
		otherInWarehsBillRecBean.setFSTOCKERID(new CloudCommonF7Bean());
		//库存组
		otherInWarehsBillRecBean.setFSTOCKERGROUPID(new CloudCommonF7Bean());

		//货主类型
		String FOwnerTypeIdHead = "BD_OwnerOrg";
		otherInWarehsBillRecBean.setFOwnerTypeIdHead(FOwnerTypeIdHead);

		//货主
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FStockOrgId);
		otherInWarehsBillRecBean.setFOwnerIdHead(f7Bean);

		//备注
		String FNOTE = "种蛋上孵单数据同步";
		otherInWarehsBillRecBean.setFNOTE(FNOTE);

		//本位币
		String FBaseCurrId = "PRE001";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FBaseCurrId);
		otherInWarehsBillRecBean.setFBaseCurrId(f7Bean);

		//序列号上传
		String FScanBox = "";
		otherInWarehsBillRecBean.setFScanBox(FScanBox);





		JSONArray entryArray = new JSONArray();
//		String sql = "select  t2.CFSrcNumber, t2.CFSrcName ,t2.CFTargetNumber,t2.CFTargetName  from CT_CLD_BaseDataRel t1 " +
//		" inner join CT_CLD_BaseDataRelEntry t2 on t2.FParentID=t1.fid inner join CT_CLD_BaseDataType t3 on t3.fid=t1.CFBaseDataTypeID where t3.FNumber='001' ";
//		String srcNum = null;
//		String srcName = null;
//		String targetNum = null;
//		String tarName = null;
//		IRowSet rs;
//		try {
//			rs = DbUtil.executeQuery(ctx, sql.toString());
//			while(rs.next()){
//				srcNum = rs.getString("CFSrcNumber");
//				srcName = rs.getString("CFSrcName");
//				targetNum = rs.getString("CFTargetNumber");
//				tarName = rs.getString("CFTargetName");
//				//如果该蛋型的数量为0，就返回，执行下一个蛋型
//				if(eggEggInfo.getString(srcNum) == null || eggEggInfo.getBigDecimal(srcNum).equals(new BigDecimal("0")) ){
//					continue;
//				}


				//设置分录的 字段
				OtherInWarehsBillRecEntryBean otherInWarehsBillRecEntryBean = new OtherInWarehsBillRecEntryBean();

				//分录的id
				String FEntryID = "0";
				otherInWarehsBillRecEntryBean.setFEntryID(FEntryID);

				//物料
				f7Bean = new CloudCommonF7Bean();
				f7Bean.setFNumber("04.004");
				otherInWarehsBillRecEntryBean.setFMATERIALID(f7Bean);

				//辅助属性
				otherInWarehsBillRecEntryBean.setFAuxPropId(new CloudCommonFAUXPROF7Bean());

				//单位
				String FUnitID = "mei";
				f7Bean = new CloudCommonF7Bean();
				f7Bean.setFNumber(FUnitID);
				otherInWarehsBillRecEntryBean.setFUnitID(f7Bean);

				//库存状态
				String FSTOCKSTATUSID = "KCZT01_SYS";
				f7Bean = new CloudCommonF7Bean();
				f7Bean.setFNumber(FSTOCKSTATUSID);
				otherInWarehsBillRecEntryBean.setFSTOCKSTATUSID(f7Bean);

				//实收数量
				String FQty = String.valueOf(eggEggInfo.getReFundEgg());
				otherInWarehsBillRecEntryBean.setFQty(FQty);

				//收货仓库
				String FSTOCKID = "ZQ06";
				f7Bean = new CloudCommonF7Bean();
				f7Bean.setFNumber(FSTOCKID);
				otherInWarehsBillRecEntryBean.setFSTOCKID(f7Bean);

				//仓位
				String FStockLocId = "";
				otherInWarehsBillRecEntryBean.setFStockLocId(new CloudCommonFSTOCKF7Bean());


				//批号
				
				StockingBatchInfo batchInfo = eggEggInfo.getOutBatch();
				try {
					batchInfo = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(new ObjectUuidPK(batchInfo.getId()));
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				//截取批次号的前8位
				String batchNum = batchInfo.getNumber().substring(0, 8);
				f7Bean = new CloudCommonF7Bean();
				f7Bean.setFNumber(batchNum);
				otherInWarehsBillRecEntryBean.setFLOT(f7Bean);

				//备注
				String FEntryNote = "";
				otherInWarehsBillRecEntryBean.setFEntryNote(FEntryNote);

				//BOM版本
				otherInWarehsBillRecEntryBean.setFBOMID(new CloudCommonF7Bean());

				//生产日期
				otherInWarehsBillRecEntryBean.setFPRODUCEDATE(null);

				//计划跟踪号
				String FMTONO = "";
				otherInWarehsBillRecEntryBean.setFMTONO(FMTONO);

				//辅单位
				otherInWarehsBillRecEntryBean.setFExtAuxUnitId(new CloudCommonF7Bean());

				//项目编号
				String FProjectNo = "";
				otherInWarehsBillRecEntryBean.setFProjectNo(FProjectNo);

				//实收数量(辅单位)
				String FExtAuxUnitQty = "0";
				otherInWarehsBillRecEntryBean.setFExtAuxUnitQty(FExtAuxUnitQty);

				//货主类型
				String FOWNERTYPEID = "BD_OwnerOrg";
				otherInWarehsBillRecEntryBean.setFOWNERTYPEID(FOWNERTYPEID);

				//货主
				f7Bean = new CloudCommonF7Bean();
				f7Bean.setFNumber(FStockOrgId);
				otherInWarehsBillRecEntryBean.setFOWNERID(f7Bean);

				//保管者类型
				String FKEEPERTYPEID = "BD_KeeperOrg";
				otherInWarehsBillRecEntryBean.setFKEEPERTYPEID(FKEEPERTYPEID);

				//保管者
				f7Bean = new CloudCommonF7Bean();
				f7Bean.setFNumber(FStockOrgId);
				otherInWarehsBillRecEntryBean.setFKEEPERID(f7Bean);

				//创建实体List
				String entryStr = JSONObject.toJSONString(otherInWarehsBillRecEntryBean, SerializerFeature.WriteNullStringAsEmpty);
				JSONObject entryJson = JSONObject.parseObject(entryStr, Feature.OrderedField);

				entryArray.add(entryJson);

//			}
//		} catch (BOSException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}


		//将分录放到单据中
		otherInWarehsBillRecBean.setFEntity(entryArray);

		//将实体转化为jsonObject
		String manuString = JSONObject.toJSONString(otherInWarehsBillRecBean, SerializerFeature.WriteNullStringAsEmpty);
		JSONObject allJson = JSONObject.parseObject(manuString, Feature.OrderedField);

		//data（必填）
		CloudCommonDataBean cloudCommonDataBean = new CloudCommonDataBean();
		cloudCommonDataBean.setCreator("");
		cloudCommonDataBean.setNeedUpDateFields(null);
		cloudCommonDataBean.setModel(allJson);

		//新建CloudCommonBean对象
		CloudCommonBean commonBean = new CloudCommonBean();
		commonBean.setFormid("STK_MISCELLANEOUS");
		commonBean.setData(cloudCommonDataBean);

		//将实体转化为字符串
		return JSONObject.toJSONString(commonBean, SerializerFeature.WriteNullStringAsEmpty);

	
	
	}

}
