package com.kingdee.eas.outinterface.farm.duck.stocking;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.basedata.assistant.PeriodCollection;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.basedata.FeedWithHisNumberCollection;
import com.kingdee.eas.farm.stocking.basedata.FeedWithHisNumberFactory;
import com.kingdee.eas.farm.stocking.basedata.FeedWithHisNumberInfo;
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.FodderApplyBillEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.FodderApplyBillFactory;
import com.kingdee.eas.farm.stocking.processbizill.FodderApplyBillInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.base.utils.JUtils;
import com.kingdee.eas.outinterface.base.utils.ResultUtils;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 要料计划
 * @author alex_dai
 *
 */
public class FodderApplyBill extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "37E98DBA";
	}
	
	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return new String[]{"*"
				,"technician.number","technician.name"
				,"entrys.*"
				,"entrys.farmer.id","entrys.farmer.name"
				,"entrys.farm.id","entrys.farm.name"
				,"entrys.house.id","entrys.house.number","entrys.house.name"
				,"entrys.stockingBatch.id","entrys.stockingBatch.number","entrys.stockingBatch.name"
				,"entrys.batchContract.id","entrys.batchContract.number","entrys.batchContract.name"
				,"entrys.feedNum.id","entrys.feedNum.number","entrys.feedNum.name","entrys.feedNum.model"
				,"entrys.material.id","entrys.feedNum.number","entrys.feedNum.name","entrys.feedNum.model"
				,"entrys.unit.id","entrys.unit.number","entrys.unit.name"
				,"entrys.sendPerson.id","entrys.sendPerson.number","entrys.sendPerson.name"
				,"entrys.sendCompany.id","entrys.sendCompany.number","entrys.sendCompany.name"
		};
	}

	@Override
	protected String getQueryInfo() {
		// TODO Auto-generated method stub
		return "com.kingdee.eas.outinterface.farm.duck.stocking.InterfaceFodderApplyBillQuery";
	}

	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","billStatus","bizDate","technician.name","beginDate","endDate"
		};
	}
	
	
	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		return "order by number desc";
	}
	/**
	 * 获取单据后处理
	 */
	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		FodderApplyBillInfo info=(FodderApplyBillInfo) model;
		//移除签名数据
//		for(int index=0;index<info.getEntrys().size();index++){
//			info.getEntrys().get(index).setSignData(null);
//		}
		return info;
	}

	
	
	@Override
	public JSONObject getData(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException {
		JSONObject paramsJson=JSONObject.parseObject(jsonStr);
		JSONObject resutlJson = super.getData(ctx, jsonStr);
		
//		//由于存在多张养户在一张领用单上得情况，所以前端传入查询List(已过滤)获取到得entryId，单据展示是只展示有权限得分录
//		if(resutlJson.getString("result").equals("0")&&paramsJson.containsKey("entryId")) {
//			List entryIdsList = JSONArray.toJavaObject(paramsJson.getJSONArray("entryId"), List.class);
//			if(entryIdsList.size()>0) {
//				if(resutlJson.getJSONObject("data")!=null){
//					JSONArray entrys = resutlJson.getJSONObject("data").getJSONArray("entrys");
//					for(int index=0;index<entrys.size();) {
//						JSONObject tmpjo = entrys.getJSONObject(index);
//						if(!entryIdsList.contains(tmpjo.getString("id"))) {
//							entrys.remove(tmpjo);
//						}else{
//							index++;
//						}
//					}
//				}
//			}
//		}
//		//根据角色剔除分录
//		if(resutlJson.getString("result").equals("0")&&paramsJson.containsKey("roles")) {
//			List<String> farmerIdsList = StockingInterfaceUtils.getFarmerIdsByRole(ctx, paramsJson);
//			if(farmerIdsList.size()>0) {
//				if(resutlJson.getJSONObject("data")!=null){
//					JSONArray entrys = resutlJson.getJSONObject("data").getJSONArray("entrys");
//					for(int index=0;index<entrys.size();) {
//						JSONObject tmpjo = entrys.getJSONObject(index);
//						if(tmpjo.getJSONObject("farmer")==null) {
//							continue;
//						}
//						if(!farmerIdsList.contains(tmpjo.getJSONObject("farmer").getString("id"))) {
//							entrys.remove(tmpjo);
//						}else{
//							index++;
//						}
//					}
//				}
//			}else {
//				JSONArray entrys = resutlJson.getJSONObject("data").getJSONArray("entrys");
//				entrys.clear(); //先不过滤分录，展示全部
//			}
//				
//		}
		return resutlJson;
	}

	@Override
	protected String getListQueryStr(Context ctx, JSONObject jo) throws BOSException {
		String beginDate=JUtils.getDateStr(jo, "beginDate", JUtils.SDF_DAY);
		String endDate=JUtils.getDateStr(jo, "endDate", JUtils.SDF_DAY);
		StringBuffer queryStr= new StringBuffer();
		queryStr.append(" bizDate>={d '").append(beginDate).append("'}")
		.append(" and bizDate<{d '").append(endDate).append("'}");
		//养户过滤
		if(StringUtils.isNotEmpty(jo.getString("farmer.id"))) {
			queryStr.append(" and entrys.farmer.id='").append(jo.getString("farmer.id")).append("'");
		}
		
		//角色
		String rolesStr=StockingInterfaceUtils.getRoleFilterStr(jo, "entrys.farmer");
		if(rolesStr.length()>0) {
//			queryStr.append(" AND (").append(rolesStr).append(")");
		}
		
		return queryStr.toString();
	}
	
	/**
	 * 确认单据--分录
	 */
	public static String confirm(Context ctx,String jsonStr) {
	/*	JSONObject jo=JSONObject.parseObject(jsonStr);
		String id=jo.getString("id");
		JSONArray entryId=jo.getJSONArray("entryIds");
		String signData=jo.getString("signData");
		jo=ResultUtils.getResultSuccess();
		try {
			IFodderApplyBillEntry is = FodderApplyBillEntryFactory.getLocalInstance(ctx);
			SelectorItemCollection slor=new SelectorItemCollection();
			
			for(int index=0;index<entryId.size();index++) {
				FodderApplyBillEntryInfo info = is.getFodderApplyBillEntryInfo(new ObjectUuidPK(entryId.getString(index)));
				info.setConfirmTime(new Date());
				slor.add("confirmTime");
				
				if(StringUtils.isNotBlank(signData)){
					info.setSignData(Base64Decoder.decode(signData));
					slor.add("signData");
				}
				is.updatePartial(info,slor);
			}
		} catch (Exception e) {
			jo=ResultUtils.getResultError(e);
		}
		return jo.toJSONString();*/
		return null;
	}

	@Override
	public CoreBaseInfo dealBeforeSave(Context ctx, CoreBaseInfo model) throws BOSException, EASBizException {
		FodderApplyBillInfo info = (FodderApplyBillInfo) model;
		if(info.getBizDate()==null){
			info.setBizDate(new Date());
		}
		info.setBeginDate(info.getBizDate());
		info.setEndDate(info.getBizDate());
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		String companyId="";
		String bizDateStr=new SimpleDateFormat("yyyy-MM-dd").format(info.getBizDate());
		
		PeriodCollection periodCols = PeriodFactory.getLocalInstance(ctx).getPeriodCollection("where number="+bizDateStr.substring(0, 4)+bizDateStr.substring(5, 7));
		if(!periodCols.isEmpty()) {
			info.setPeriod(periodCols.get(0));
		}
		
		IStockingBatch ibs = StockingBatchFactory.getLocalInstance(ctx);
		IMaterial ims = MaterialFactory.getLocalInstance(ctx);
		
		FeedWithHisNumberInfo feedNumInfo=null;
		FeedWithHisNumberCollection feedCols = FeedWithHisNumberFactory.getLocalInstance(ctx).getFeedWithHisNumberCollection("where name='饲料领用'");
		if(!feedCols.isEmpty()) {
			feedNumInfo=feedCols.get(0);
		}
		
		for(int index=0;index<info.getEntrys().size();index++) {
			FodderApplyBillEntryInfo entryInfo = info.getEntrys().get(index);
			StockingBatchInfo batchInfo =null;
			if(entryInfo.getStockingBatch()!=null) {
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				slor.add("farm.*");
				slor.add("batchContract.*");
				slor.add("batchContract.settlementPolicy.*");
				batchInfo = ibs.getStockingBatchInfo(new ObjectUuidPK(entryInfo.getStockingBatch().getId()),slor);
				
				entryInfo.setFarm(batchInfo.getFarm());
				entryInfo.setFarmer(batchInfo.getFarmer());
				entryInfo.setBatchContract(batchInfo.getBatchContract());
				
				entryInfo.setHatchDate(batchInfo.getInDate());
				
				if(batchInfo.getInDate()!=null) {
					//周龄 *周*
					int[] result = StockingComm.getBreedWeekAndDay(info.getBizDate(), batchInfo.getInDate());
					int week=result[0];
					int weekDay=result[1];
					entryInfo.setWeekAge(week+"周"+weekDay);
				}
				
				if(info.getCompany()==null) {
					info.setCompany(batchInfo.getCompany());
					companyId=info.getCompany().getString("id");
				}
				if(info.getStorageOrgUnit()==null) {
//					info.setStorageOrgUnit(batchInfo.getStorageOrgUnit());
				}
				
//				entryInfo.setCurrentQty(0);//存栏
			}
			
			entryInfo.setFeedNum(feedNumInfo);
		}
		return info;
	}
	
	/**
	 * 获取公司对应的单只控料标准
	 * @param companyID
	 * @return
	 * @throws BOSException 
	 * @throws Exception 
	 */
	public static List<BigDecimal> getFeedStandard(Context ctx,String companyID) throws BOSException {
		// TODO Auto-generated method stub
		List<BigDecimal> feedStandard=new  ArrayList<BigDecimal>();
		String sql="select * from T_FM_SingelFeedStandard where FCompanyid='"+companyID+"' and fbasestatus='3'";
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				feedStandard.add(rs.getBigDecimal("FSingelFeedQty"));
			}
		} catch (Exception e) {
			throw new BOSException(e); 
		} 
		return feedStandard;
	}
	
	//通过饲喂标准获取物料名称
	public JSONObject getFieldMaterielName(Context ctx,String jsonStr) throws  BOSException {
		JSONObject resultJson = ResultUtils.getResultSuccess();
		JSONArray ja=new JSONArray();
		String dateStr=JUtils.SDF_DAY.format(new Date());
		StringBuffer sql=new StringBuffer();
		sql.append("/*dialect*/select tm1.fname_l2 FName1,   ")
		.append(" tm2.fname_l2 FName2,tm3.fname_l2 FName3,tm4.fname_l2 FName4")
		.append(" from T_FM_FeedWithHisNumber tmain")
		.append(" left join t_bd_material tm1 on tm1.fid=tmain.FNum1ID")
		.append(" left join t_bd_material tm2 on tm2.fid=tmain.FNum2ID")
		.append(" left join t_bd_material tm3 on tm3.fid=tmain.FNum3ID")
		.append(" left join t_bd_material tm4 on tm4.fid=tmain.FNum4ID")
		.append(" where tmain.FIsCancelCancel=1")
		.append(" and to_char(tmain.FBeginDate,'yyyy-MM-dd')<='").append(dateStr).append("'")
		.append(" and to_char(tmain.FEndDate,'yyyy-MM-dd')>='").append(dateStr).append("'")
		.append(" ");		
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try {
			if(rs.next()) {
				JSONObject tmpJo=new JSONObject();
				tmpJo.put("filedName","num1Feed");	
				tmpJo.put("materialName", rs.getString("FName1"));
				ja.add(tmpJo);
				
				tmpJo=new JSONObject();
				tmpJo.put("filedName","num2Feed");	
				tmpJo.put("materialName", rs.getString("FName2"));
				ja.add(tmpJo);
				
				tmpJo=new JSONObject();
				tmpJo.put("filedName","num3Feed");	
				tmpJo.put("materialName", rs.getString("FName3"));
				ja.add(tmpJo);
				
				tmpJo=new JSONObject();
				tmpJo.put("filedName","num4Feed");	
				tmpJo.put("materialName", rs.getString("FName4"));
				ja.add(tmpJo);
			}
		} catch (SQLException e) {
			return ResultUtils.getResultError(e);
		}
		resultJson.put("data", ja);
		return resultJson;
	}

	@Override
	public void dealAfterSave(Context ctx, CoreBaseInfo model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		super.dealAfterSave(ctx, model);
		FodderApplyBillInfo info = (FodderApplyBillInfo) model;
		FodderApplyBillFactory.getLocalInstance(ctx).submit(info);
		/*if(info.getId()!=null) {
			//单据状态改为提交
			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("billStatus");
			FodderApplyBillFactory.getLocalInstance(ctx).updatePartial(info, slor);
		}*/
	}

}
