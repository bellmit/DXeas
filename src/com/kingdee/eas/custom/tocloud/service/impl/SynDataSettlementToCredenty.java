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
import com.kingdee.eas.basedata.org.CompanyOrgUnit;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.custom.tocloud.SynDateLogEntryInfo;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonDataBean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonF7Bean;
import com.kingdee.eas.custom.tocloud.bean.CloudCommonUserID;
import com.kingdee.eas.custom.tocloud.bean.CloudSettlementToCredenty;
import com.kingdee.eas.custom.tocloud.bean.CloudSettlementToCredentyEntry;
import com.kingdee.eas.custom.tocloud.bean.CloudSettlementToCredentyEntryDetail;
import com.kingdee.eas.custom.tocloud.service.ISynData;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
//import com.kingdee.eas.farm.carnivorous.recyclebiz.AccountPolicyFactory;
//import com.kingdee.eas.farm.carnivorous.recyclebiz.AccountPolicyInfo;
import com.kingdee.eas.fi.newrpt.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 结算单同步cloud的凭证
 * @author wlhl
 *
 */
public class SynDataSettlementToCredenty implements ISynData{

	@Override
	public String synData(Context ctx, String billId, String entryId,
			String targetSystemId, String bizTypeId, List<String> errorMessage,
			SynDateLogEntryInfo synDateLogEntryInfo) throws Exception {
		// TODO Auto-generated method stub

		//AccountPolicyInfo accountPolicyInfo = AccountPolicyFactory.getLocalInstance(ctx).getAccountPolicyInfo(new ObjectUuidPK(billId));

		//设定日期显示格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		//设置凭证的表头
		CloudSettlementToCredenty  billInfo = new CloudSettlementToCredenty();

		String FVOUCHERID = "";
		billInfo.setFVOUCHERID(FVOUCHERID);


		//账簿
		CloudCommonF7Bean f7Bean = null;
		String FAccountBookID = "ZLYB";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FAccountBookID);
		billInfo.setFAccountBookID(f7Bean);

		//日期
//		String FDate = sdf.format(accountPolicyInfo.getBizDate());
//		billInfo.setFDate(FDate);

		//凭证字
		String FVOUCHERGROUPID = "PRE001";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FVOUCHERGROUPID);
		billInfo.setFVOUCHERGROUPID(f7Bean);

		//凭证号
		String FVOUCHERGROUPNO = "";
		billInfo.setFVOUCHERGROUPNO(FVOUCHERGROUPNO);

		//外币
		String FISFOREIGNCUR = "false";
		billInfo.setFISFOREIGNCUR(FISFOREIGNCUR);

		//本位币(辅助)
		String FBASECURRENCYID = "PRE001";
		f7Bean = new CloudCommonF7Bean();
		f7Bean.setFNumber(FBASECURRENCYID);
		billInfo.setFBASECURRENCYID(f7Bean);

		//取消复核操(作辅助)
		String FCancleRecheck = "false";
		billInfo.setFCancleRecheck(FCancleRecheck);

		//核算组织

//		CompanyOrgUnitInfo compnyInfo = null;
//		compnyInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(((CompanyOrgUnitInfo)accountPolicyInfo.getCompany()).getId()));
//
//		String FACCBOOKORGID = compnyInfo.getNumber();
//		f7Bean = new CloudCommonF7Bean();
//		f7Bean.setFNumber(FACCBOOKORGID);
//		billInfo.setFACCBOOKORGID(f7Bean);

		//是否拆分
		String FIsSplit = "0";
		billInfo.setFIsSplit(FIsSplit);

		//出纳复核操作(辅助)
		String FCashierRecheck = "false";
		billInfo.setFCashierRecheck(FCashierRecheck);

		//审核时间
		String FAuditDate = "";
		billInfo.setFAuditDate(FAuditDate);

		//审核状态
		String FDocumentStatus = "";
		billInfo.setFDocumentStatus(FDocumentStatus);

		//创建时间
		String FCreateDate = "";
		billInfo.setFCreateDate(FCreateDate);

		//数量金额核算
		String FIsQty = "false";
		billInfo.setFIsQty(FIsQty);

		//修改人
		String FModifierId = "";
		CloudCommonUserID userid = new CloudCommonUserID();
		userid.setFUserID(FModifierId);
		billInfo.setFModifierId(userid);





		//---------------这里需要添加一个循环-循环之后表头上的entryArray添加这个分录-----------------------------------

		JSONArray jsonArray = new JSONArray();
		//创建凭证的分录


		if(1 == 1){
			CloudSettlementToCredentyEntry entryInfo = new CloudSettlementToCredentyEntry();

			//设置毛鸡的科目编码
			String FEntryID = "";
			entryInfo.setFEntryID(FEntryID);
			//描述
			String FEXPLANATION = "结算单同步凭证";
			entryInfo.setFEXPLANATION(FEXPLANATION);

			//科目编码
			String FACCOUNTID = "1405.02.03";
			f7Bean = new CloudCommonF7Bean();
			f7Bean.setFNumber(FACCOUNTID);
			entryInfo.setFACCOUNTID(f7Bean);

//			//核算维度---对应养殖批次和养殖户
//			FarmerInfo farmerInfo = accountPolicyInfo.getFarmer();
//			farmerInfo = FarmerFactory.getLocalInstance(ctx).getFarmerInfo(new ObjectUuidPK(farmerInfo.getId()));
//			String FDETAILID__FFLEX5 = farmerInfo.getNumber();//养殖户
//			
//			BatchInfo  batchInfo = accountPolicyInfo.getBatch();
//			batchInfo = BatchFactory.getLocalInstance(ctx).getBatchInfo(new ObjectUuidPK(batchInfo.getId()));
//			String FDETAILID__FF100007 = batchInfo.getNumber();
			
//			CloudSettlementToCredentyEntryDetail detailInfo = new CloudSettlementToCredentyEntryDetail();
//			f7Bean = new CloudCommonF7Bean();
//			f7Bean.setFNumber(FDETAILID__FFLEX5);
//			
//			detailInfo.setFDETAILID__FFLEX5(f7Bean);
//			f7Bean = new CloudCommonF7Bean();
//			f7Bean.setFNumber(FDETAILID__FF100007);
//			
//			detailInfo.setFDETAILID__FF100007(f7Bean);
//			entryInfo.setFDetailID(detailInfo);

			//币别
			String FCURRENCYID = "PRE001";
			f7Bean = new CloudCommonF7Bean();
			f7Bean.setFNumber(FCURRENCYID);
			entryInfo.setFCURRENCYID(f7Bean);

			//汇率类型
			String FEXCHANGERATETYPE = "HLTX01_SYS";
			f7Bean = new CloudCommonF7Bean();
			f7Bean.setFNumber(FEXCHANGERATETYPE);
			entryInfo.setFEXCHANGERATETYPE(f7Bean);

			//汇率
			String FEXCHANGERATE = "1";
			entryInfo.setFEXCHANGERATE(FEXCHANGERATE);

			//单位
			String FUnitId = "";
			f7Bean = new CloudCommonF7Bean();
			f7Bean.setFNumber(FUnitId);
			entryInfo.setFUnitId(f7Bean);

			//单价
			String FPrice = "";
			entryInfo.setFPrice(FPrice);

			//数量
			String FQty = "";
			entryInfo.setFQty(FQty);

//			//原币金额
//			String FAMOUNTFOR = String.valueOf(accountPolicyInfo.getCompanyCost());
//			entryInfo.setFAMOUNTFOR(FAMOUNTFOR);
//
//			//借方金额
//			String FDEBIT = String.valueOf(accountPolicyInfo.getCompanyCost());
//			entryInfo.setFDEBIT(FDEBIT);

			//贷方金额
			String FCREDIT = "";
			entryInfo.setFCREDIT(FCREDIT);

			//是否参与多栏账汇总
			String FISMULTICOLLECT = "true";
			entryInfo.setFISMULTICOLLECT(FISMULTICOLLECT);

			//上移下移之前的分录内码
			String FOldEntryId = "";
			entryInfo.setFOldEntryId(FOldEntryId);

			jsonArray.add(entryInfo);
		}

		//--------------------设置除了毛鸡之外的科目编码-----------------------------------------------------

		StringBuffer sql = new StringBuffer();
		sql.append(" /*dialect*/ select t2.CFSrcNumber    CFSrcNumber, t2.CFTargetNumber  CFTargetNumber");
		sql.append(" from CT_CLD_BaseDataRel  t1 inner join CT_CLD_BaseDataRelEntry t2 on t2.fparentid=t1.fid");
		sql.append(" inner join CT_CLD_BaseDataType t3 on t3.fid=t1.CFBaseDataTypeID");
		sql.append("  where t3.fnumber='009'");
		IRowSet rs = null;
		rs = DbUtil.executeQuery(ctx, sql.toString());
		String CFSrcNumber = null;
		String CFTargetNumber = null;
		while(rs.next()){
			CFSrcNumber = rs.getString("CFSrcNumber");
			CFTargetNumber = rs.getString("CFTargetNumber");
			CloudSettlementToCredentyEntry entryInfo1 = new CloudSettlementToCredentyEntry();

//			//如果某个成本字段的值为空或者为0，不计算在内
//			if(accountPolicyInfo.getBigDecimal(CFSrcNumber) == null
//					|| accountPolicyInfo.getBigDecimal(CFSrcNumber).compareTo(BigDecimal.ZERO) == 0){
//				continue;
//			}





			String FEntryID = "";
			entryInfo1.setFEntryID(FEntryID);
			//描述
			String FEXPLANATION = "";
			entryInfo1.setFEXPLANATION(FEXPLANATION);

			//科目编码
			String FACCOUNTID = CFTargetNumber;
			f7Bean = new CloudCommonF7Bean();
			f7Bean.setFNumber(FACCOUNTID);
			entryInfo1.setFACCOUNTID(f7Bean);

			//细节
//			BatchInfo  batchInfo = accountPolicyInfo.getBatch();
//			batchInfo = BatchFactory.getLocalInstance(ctx).getBatchInfo(new ObjectUuidPK(batchInfo.getId()));
//			String FDETAILID__FFLEX5 = batchInfo.getNumber();
//			CloudSettlementToCredentyEntryDetail detailInfo = new CloudSettlementToCredentyEntryDetail();
//			f7Bean = new CloudCommonF7Bean();
//			f7Bean.setFNumber(FDETAILID__FFLEX5);
//			detailInfo.setFDETAILID__FFLEX5(f7Bean);
//			entryInfo1.setFDetailID(detailInfo);
			
			
//			FarmerInfo farmerInfo = accountPolicyInfo.getFarmer();
//			farmerInfo = FarmerFactory.getLocalInstance(ctx).getFarmerInfo(new ObjectUuidPK(farmerInfo.getId()));
//			String FDETAILID__FFLEX5 = farmerInfo.getNumber();//养殖户
//			
//			BatchInfo  batchInfo = accountPolicyInfo.getBatch();
//			batchInfo = BatchFactory.getLocalInstance(ctx).getBatchInfo(new ObjectUuidPK(batchInfo.getId()));
//			String FDETAILID__FF100007 = batchInfo.getNumber();
//			
//			CloudSettlementToCredentyEntryDetail detailInfo = new CloudSettlementToCredentyEntryDetail();
//			f7Bean = new CloudCommonF7Bean();
//			f7Bean.setFNumber(FDETAILID__FFLEX5);
//			
//			detailInfo.setFDETAILID__FFLEX5(f7Bean);
//			f7Bean = new CloudCommonF7Bean();
//			f7Bean.setFNumber(FDETAILID__FF100007);
//			
//			detailInfo.setFDETAILID__FF100007(f7Bean);
//			entryInfo1.setFDetailID(detailInfo);

			//币别
			String FCURRENCYID = "PRE001";
			f7Bean = new CloudCommonF7Bean();
			f7Bean.setFNumber(FCURRENCYID);
			entryInfo1.setFCURRENCYID(f7Bean);

			//汇率类型
			String FEXCHANGERATETYPE = "HLTX01_SYS";
			f7Bean = new CloudCommonF7Bean();
			f7Bean.setFNumber(FEXCHANGERATETYPE);
			entryInfo1.setFEXCHANGERATETYPE(f7Bean);

			//汇率
			String FEXCHANGERATE = "1";
			entryInfo1.setFEXCHANGERATE(FEXCHANGERATE);

			//单位
			String FUnitId = "";
			f7Bean = new CloudCommonF7Bean();
			f7Bean.setFNumber(FUnitId);
			entryInfo1.setFUnitId(f7Bean);

			//单价
			String FPrice = "";
			entryInfo1.setFPrice(FPrice);

			//数量
			String FQty = "";
			entryInfo1.setFQty(FQty);

//			//原币金额
//			String FAMOUNTFOR = String.valueOf(accountPolicyInfo.getBigDecimal(CFSrcNumber));
//			entryInfo1.setFAMOUNTFOR(FAMOUNTFOR);
//
//			//借方金额
//			String FDEBIT = "";
//			entryInfo1.setFDEBIT(FDEBIT);
//
//			//贷方金额
//			String FCREDIT = String.valueOf(accountPolicyInfo.getBigDecimal(CFSrcNumber));
//			entryInfo1.setFCREDIT(FCREDIT);

			//是否参与多栏账汇总
			String FISMULTICOLLECT = "true";
			entryInfo1.setFISMULTICOLLECT(FISMULTICOLLECT);

			//上移下移之前的分录内码
			String FOldEntryId = "";
			entryInfo1.setFOldEntryId(FOldEntryId);

			jsonArray.add(entryInfo1);

		}

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
		commonBean.setFormid("GL_VOUCHER");
		commonBean.setData(cloudCommonDataBean);

		//将实体转化为字符串
		return JSONObject.toJSONString(commonBean, SerializerFeature.WriteNullStringAsEmpty);

	}

}
