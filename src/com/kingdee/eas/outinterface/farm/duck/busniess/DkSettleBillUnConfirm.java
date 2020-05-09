package com.kingdee.eas.outinterface.farm.duck.busniess;


import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.castor.util.Base64Decoder;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBill;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.base.utils.JUtils;
import com.kingdee.eas.outinterface.base.utils.ResultUtils;

/**
 * 结算单
 * @author alex_dai
 *
 */
public class DkSettleBillUnConfirm extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "2A2E0777";
	}
	
	

	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return new String[]{
				"id","number","bizDate","billStatus","confirmTime","feedDays"//日龄
				,"batch.number","farmer.name","farm.name","costCenter.name","breedData.name" //养殖组织、合同类型
				,"operator.number","operator.name","person.name","farmer.mobileTel"
				,"settlePolicy.number","settlePolicy.name"//结算政策				
				,"inDate","batchQty","recDate"//上苗日期、上苗数量、过磅日期（回收日期）
				,"survivalRate","meatRate","oValue"//成活率、料肉比、PI值
				,"feedDays","recQty","chickenAveWgt"//饲养天数、回收只数、只重				
				,"batchAmt","feedAmt","drugAmt","recAmt"//雏鸡款、饲料款、药品款、毛鸡款
				,"punishAmt","chickenRetunAmt"//各项扣补、鸡雏让利
				,"batchQty","recQty","meatRate","singleDrugAmt","singleDyFee","chickenAveWgt"
				//进雏只数、回收只数、出栏率(no)、料肉比、只药、只鸡净利润、均重
				,"actualPayAmt","tranCost","coalCost","brokenCost"//支鸡款、运费、煤款、断档费
				,"marginProfit","borrowAmiunt","specialBorrowinst","reserveRiskCost"
				//保证金利息、笼养借款利息、特批借款利息、预留无药残风险押金
				,"marginGAmount","longBorrowReturn","specialPermitAmt"
				//保证金留取金额、笼养借款还款金额、特批借款还款金额
				,"equipmentReAmt","noPfoRetAmt","beforeBatchAmount","nowAccountBac"
				//设备升级借款还款金额、亏损还款、上批余额、现账面累计余额
				,"viewItemAmt","chickenRetunAmt","beforeBatchAmount"//客诉补雏、鸡雏让利、上批余额
				,"mRatePAmt","drugLackPAmt","immuneCost"//料肉比不足扣罚、用药不足扣罚、油苗费用
				,"farmeronlyPro","marginProfit" ,"borrowAmiunt","specialBorrowinst","dyFee"
				//养殖毛利、保证金使用费、笼养借款使用费、特批借款使用费、养殖代养费用
				,"farmerOnlyProOne","feedWgt","settleWgt"//只鸡净利润
				,"OtherEntrys.suType.name","OtherEntrys.amount" //其他扣补页签
		};
	}

	   
	/**
	 * 获取单据后处理
	 */
	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		CKSettleBillInfo info=(CKSettleBillInfo) model;
		//移除签名数据
		info.setSignData(null);
		info.getPreHouseEntrys().clear();
		info.getSaleEntrys().clear();
		info.getEntrys().clear();
		info.getDrugEntrys().clear();
		info.getSeedEntrys().clear();
		info.getQCEntrys().clear();
		info.getSlaughterEntrys().clear();
		info.getFodderEntrys().clear();
		return info;
	}



	@Override
	public JSONObject getData(Context ctx, String jsonStr) throws BOSException,
			EASBizException, RemoteException {
		// TODO Auto-generated method stub
//		JSONObject paramsJson=JSONObject.parseObject(jsonStr);
//		JSONObject reusltJson = super.getData(ctx, jsonStr);
//        BigDecimal price =BigDecimal.ZERO ,qty=BigDecimal.ZERO, amount=BigDecimal.ZERO;
//		if(reusltJson.getString("result").equals("0")) {
//			JSONObject dataJson=reusltJson.getJSONObject("data");
//			
//		}
		return super.getData(ctx, jsonStr);
	}



	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","bizDate","billStatus","farmer.name","farm.name","batch.number","batch.name",
				"chickenPay","endTotal","confirmTime","person.name","inDate"
				,"feedDays","survivalRate","meatRate","costCenter.name","oValue","chickenAveWgt","feedWgt"
		         //饲养天数、成活率、料肉比、养殖组织、PI值、只重
		        ,"batchQty","mlyAllAmt","recQty","settleWgt","recAmt","farmeronlyPro"
		        //上苗数量、苗料药总金额、回收只数、结算重量,回收金额、养户毛利
		};
	}
	
	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		String type=jo.getString("type");
		if(StringUtils.isEmpty(type)){
			type="ASC";
		}
		String bizDate=jo.getString("bizDate");
		String inDate=jo.getString("inDate");
		String farmerName=jo.getString("farmer.name");
		String costCenter=jo.getString("costCenter.name");
		String str=null;
		if(StringUtils.isNotEmpty(bizDate)){
			str=" bizDate desc";
		}else if(StringUtils.isNotEmpty(inDate)){
			str=" inDate desc ";
		}else if(StringUtils.isNotEmpty(farmerName)){
			str=" farmer.name " +type;
		}else if(StringUtils.isNotEmpty(costCenter)){
			str=" costCenter.name " +type;
		}else{
			str=" bizDate desc";
		}
		return "order by "+str;
	}
	@Override
	public JSONObject getList(Context ctx, String jsonStr) throws BOSException,
			EASBizException, RemoteException {
		// TODO Auto-generated method stub
		JSONObject reusltJson = super.getList(ctx, jsonStr);
		JSONArray dataJson=null;
        if(reusltJson.getString("result").equals("0")) {
        	dataJson=reusltJson.getJSONArray("data");
        	System.out.println(dataJson.size());
        	reusltJson.put("data", dataJson.size());
		}
        System.out.println(reusltJson);
		return reusltJson;
	}
	@Override
	protected String getListQueryStr(Context ctx, JSONObject jo) throws BOSException {
		StringBuffer queryStr= new StringBuffer();
//		queryStr.append(" bizDate>={d '").append(beginDate).append("'}")
//		.append(" and bizDate<{d '").append(endDate).append("'}");
		
		//只显示审核的
		queryStr.append("  billStatus=4  and confirmTime is null");
		
		//养户过滤
		if(StringUtils.isNotEmpty(jo.getString("farmer.id"))) {
			queryStr.append(" and farmer.id='").append(jo.getString("farmer.id")).append("'");
		}
		//养殖场过滤
		if(StringUtils.isNotEmpty(jo.getString("farm.id"))) {
			queryStr.append(" and farm.id='").append(jo.getString("farm.id")).append("'");
		}
		//批次合同
		if(StringUtils.isNotEmpty(jo.getString("batchContract.id"))) {
			queryStr.append(" and batchContract.id='").append(jo.getString("batchContract.id")).append("'");
		}
		//角色
		StringBuffer rolesStr=new StringBuffer();
		JSONArray rolesArray = jo.getJSONArray("roles");
		for(int index=0;index<rolesArray.size();index++) {
			String role=rolesArray.getString(index);
			if(rolesStr.length()>0) {
				rolesStr.append(" OR ");
			}
			if(StringUtils.equalsIgnoreCase(role,"farmer")){
				rolesStr.append(" farmer.identity='").append(jo.getString("idNo")).append("'");
			}
			if(StringUtils.equalsIgnoreCase(role,"manager")){
				rolesStr.append(" farmer.id in (")
				.append(" select distinct tentry.FFarmerID")
				.append(" from T_FM_PersonFarmerRange tmain")
				.append(" inner join T_FM_PersonFarmerRangeEntry tentry on tentry.fparentid=tmain.fid")
				.append(" inner join t_pm_user tuser on tuser.fpersonid=tmain.FPersonID")
				.append(" where tuser.fnumber='").append(jo.getString("userNum")).append("'")
				.append(" and tmain.FBaseStatus=2")
				.append(")");
			}
		}
		if(rolesStr.length()>0) {
			queryStr.append(" AND (").append(rolesStr).append(") and entrys.seq=1");
		}
		
		return queryStr.toString();
	}
	
	/**
	 * 确认单据
	 */
	public static String confirm(Context ctx,String jsonStr) {
		JSONObject jo=JSONObject.parseObject(jsonStr);
		String id=jo.getString("id");
		String signData=jo.getString("signData");
		jo=ResultUtils.getResultSuccess();
		try {
			ICKSettleBill is= CKSettleBillFactory.getLocalInstance(ctx);
			SelectorItemCollection slor=new SelectorItemCollection();
			
			CKSettleBillInfo info = is.getCKSettleBillInfo(new ObjectUuidPK(id));
			info.setConfirmTime(new Date());
			slor.add("confirmTime");
			
			if(StringUtils.isNotBlank(signData)){
				info.setSignData(Base64Decoder.decode(signData));
				slor.add("signData");
			}
			is.updatePartial(info,slor);
		} catch (Exception e) {
			jo=ResultUtils.getResultError(e);
		}
		return jo.toJSONString();
	}
	protected String getListQueryStr2(Context ctx, JSONObject jo) throws BOSException {
		String beginDate=JUtils.getDateStr(jo, "beginDate", JUtils.SDF_DAY);
		String endDate=JUtils.getDateStr(jo, "endDate", JUtils.SDF_DAY);
		StringBuffer queryStr= new StringBuffer();
		queryStr.append(" FBizDate>={d '").append(beginDate).append("'}")
		.append(" and FBizDate<{d '").append(endDate).append("'}");
		
		//只显示审核的并且未确认的
		queryStr.append(" and CFBillStatus=4 ");
		//养户过滤
		if(StringUtils.isNotEmpty(jo.getString("farmer.id"))) {
			queryStr.append(" and CFFarmerID='").append(jo.getString("farmer.id")).append("'");
		}
		 //养殖场过滤
		if(StringUtils.isNotEmpty(jo.getString("farm.id"))) {
			queryStr.append(" and CFFarmID='").append(jo.getString("farm.id")).append("'");
		}
		//批次合同
		if(StringUtils.isNotEmpty(jo.getString("batchContract.id"))) {
			queryStr.append(" and CFBatchContractID='").append(jo.getString("batchContract.id")).append("'");
		}
		//角色
		StringBuffer rolesStr=new StringBuffer();
		JSONArray rolesArray = jo.getJSONArray("roles");
		for(int index=0;index<rolesArray.size();index++) {
			String role=rolesArray.getString(index);
			if(rolesStr.length()>0) {
				rolesStr.append(" OR ");
			}
			if(StringUtils.equalsIgnoreCase(role,"farmer")){
				rolesStr.append(" farmer.FIdentity='").append(jo.getString("idNo")).append("'");
			}
			if(StringUtils.equalsIgnoreCase(role,"manager")){
				rolesStr.append(" farmer.fid in (")
				.append(" select distinct tentry.FFarmerID")
				.append(" from T_FM_PersonFarmerRange tmain")
				.append(" inner join T_FM_PersonFarmerRangeEntry tentry on tentry.fparentid=tmain.fid")
				.append(" inner join t_pm_user tuser on tuser.fpersonid=tmain.FPersonID")
				.append(" where tuser.fnumber='").append(jo.getString("userNum")).append("'")
				.append(" and tmain.FBaseStatus=2")
				.append(")");
			}
		}
		if(rolesStr.length()>0) {
			queryStr.append(" AND (").append(rolesStr).append(")");
		}
		
		return queryStr.toString();
	}

}