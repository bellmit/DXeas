package com.kingdee.eas.outinterface.farm.duck.stocking;

import java.awt.List;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
//import net.sf.json.JSONObject;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
//import net.sf.json.JSONObject;
import com.google.gson.JsonObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.basedata.assistant.IMeasureUnit;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.IFarmHouseEntry;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.BatchLastBean;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.farm.duck.busniess.BatchInfoBean;
import com.kingdee.eas.outinterface.farm.duck.busniess.DuckBusinessUtils;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;




public class BreedStandard extends AbstractOutInterfaceImpl{

	private boolean isHouseManager=false;//是否启动棚舍管理
	
	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "6C5ED8A0";
	}

	
	
	
	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{
				
		};
	}




	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return new String[]{
//				"*"
				"auditTime"
		};
	}



	@Override
	public JSONObject getData(Context ctx, String jsonStr) throws BOSException,
			EASBizException, RemoteException {
		// TODO Auto-generated method stub
		JSONObject paramsJson=JSONObject.parseObject(jsonStr);
		
		Date bizDate=paramsJson.getDate("bizDate");
		if(bizDate==null){
			bizDate=new Date();
		}
		
		JSONObject reusltJson = super.getData(ctx, jsonStr);
		
		//补充资料
		if(reusltJson.getString("result").equals("0")&&bizDate!=null) {
			JSONObject dataJson=reusltJson.getJSONObject("data");
			String batchId=dataJson.getString("id");
			StockingBatchInfo batchInfo = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(new ObjectUuidPK(batchId));
			JSONArray entrysStandardArr = null;
			JSONArray eggStandardArr=null;
			JSONArray immuneStandardArr=null;
			
			//周龄日龄
			int[] result = StockingComm.getBreedWeekAndDay(bizDate,batchInfo.getInDate());
			int week=result[0];
			int weekDay=result[1];
			
			
			//获取饲喂规范
			try {
				entrysStandardArr = getEntrysStandard(ctx,batchInfo.getCompany().getString("id"),batchInfo.getBreedData().getString("id")
					,week,weekDay,batchId);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			//获取产蛋规范
			try {
				eggStandardArr = getEggStandard(ctx,batchInfo.getCompany().getString("id"),batchInfo.getBreedData().getString("id")
					,week,weekDay,batchId);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			//获取免疫规范
			try {
				immuneStandardArr = getImmuneStandard(ctx,batchInfo.getCompany().getString("id"),batchInfo.getBreedData().getString("id")
			,week,weekDay,batchId);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			if(batchInfo.getInDate()!=null) {
				dataJson.put("enteryStandard", entrysStandardArr);//饲喂规范
				dataJson.put("eggStandard", eggStandardArr);  //产蛋规范
				dataJson.put("immuneStandard",immuneStandardArr); //免疫规范
				//日龄
//				try {
//					BatchLastBean bean = StockingComm.getEntryHouseBatchBean(ctx,null,batchInfo.getCompany().getString("id"),bizDate, batchInfo.getString("id"), null);
//					dataJson.put("breekingStock", bean.getLaskStock()); //公禽存栏数
//					dataJson.put("femaleQty", bean.getFemaleLaskStock()); //母禽存栏数					
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			
//				dataJson.put("initQty", bean.getInitQty());
//				dataJson.put("sumDeathAndCullQty", bean.getSumDeathAndCullQty());
//				dataJson.put("sumOutQty", bean.getSumOutQty());
//				dataJson.put("sumFodderQty", bean.getSumFodderWgt());
//				dataJson.put("beginCurQty", bean.getCurQty());
				
				
				
				
			}
		}	
		return reusltJson;
	}
	
	
	
	/**
	 * 获取免疫规范
	 * */
	private JSONArray getImmuneStandard(Context ctx ,String companyID,String breedDataID,int week,int weekDay,String batchId ){
		JSONArray immuneArr = new JSONArray();
		try {
			if(StringUtils.isEmpty(companyID)||StringUtils.isEmpty(breedDataID)) {
				return immuneArr;
			}
			int dayAge=(week-1)*7+weekDay-1;
			StringBuffer sql=new StringBuffer();
			sql.append(" select tentry.FMaterialID,tentry.FUnitID,tentry.FQty")
			.append(" from T_FM_BreedStandard tmain ")
			.append(" inner join T_FM_BreedStandardDrugEntry tentry on tentry.fparentid=tmain.fid")
			.append(" where tmain.FCompanyID='").append(companyID).append("'")
			.append(" and FBreedDataID='").append(breedDataID).append("'")
			.append(" and FBaseStatus=3")//启用状态
			.append(" and (")
			//起始周日均大于当前
			.append(" (FWeek<=").append(week).append(" and FDays<=").append(weekDay).append(" ")
			//结束同周，日大于当前日
			.append(" and ((FEndWeek=").append(week).append(" and FEndDays>=").append(weekDay).append(" )")
			//周大于当前周
			.append(" or FEndWeek>").append(week).append(" ))")
			//0周 进行日龄判断
			.append(" or (FWeek=0 and FDays<=").append(dayAge).append(" and FEndWeek=0 and FEndDays>=").append(dayAge).append(")")
			.append(" )")
			.append(" order by tentry.FSeq")
			.append(" ");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			IRow row;
			MaterialInfo mInfo;
			IMaterial ims = MaterialFactory.getRemoteInstance();
			IMeasureUnit ius = MeasureUnitFactory.getRemoteInstance();
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("baseUnit.*");
			FarmHouseEntryInfo fheInfo=new FarmHouseEntryInfo();

			while(rs.next()) {
				 JSONObject object = new JSONObject();
				 mInfo=ims.getMaterialInfo(new ObjectUuidPK(rs.getString("FMaterialID")),slor);
				 object.put("vaccineMaterialId", mInfo.getId().toString());
				 object.put("vaccineMaterialName", mInfo.getName());
				 object.put("vaccineMaterialNumber", mInfo.getNumber());
				 object.put("vaccineModel", mInfo.getModel());
				 object.put("vaccineUnit", ius.getMeasureUnitInfo(new ObjectUuidPK(rs.getString("FUnitID"))).toString());
				 object.put("vaccineGetQty", rs.getBigDecimal("FQty").toString());
				 immuneArr.add(object);
				}
			rs.close();
		}catch(Exception err) {
			err.printStackTrace();
		}
		return immuneArr;
		
	}
	
	/**
	 * 获取饲喂规范
	 * */
	private JSONArray getEntrysStandard(Context ctx ,String companyID,String breedDataID,int week,int weekDay,String batchId ) {
		//获取饲喂规范
		HashMap<MaterialInfo, BigDecimal> map = 
			StockingComm.getBreedFodderStandard(ctx, companyID, breedDataID, week,weekDay);

		MaterialInfo mi = new MaterialInfo();
		BigDecimal bd;
		JSONArray entrysStandardArr = new JSONArray();
		for (Map.Entry<MaterialInfo,BigDecimal> entry : map.entrySet()) { 
			JSONObject object = new JSONObject();
				mi = entry.getKey();
				bd = entry.getValue();
				object.put("materialName", mi.getName());
				object.put("materialNumber", mi.getNumber());
				object.put("materialModel", mi.getModel());
				object.put("materialQty", bd);
				entrysStandardArr.add(object);
		}
		return entrysStandardArr;
		
		
		
	}
	
	/**
	 * 获取产蛋规范
	 * */
	private JSONArray getEggStandard(Context ctx ,String companyID,String breedDataID,int week,int weekDay,String batchId ){

		JSONArray standardArr = new JSONArray();
		//日龄 
		int dayAge=(week-1)*7+weekDay-1;

		StringBuffer sql=new StringBuffer();
		sql.append(" select top 1 tentry.fid")
		.append(" from T_FM_BreedStandard tmain ")
		.append(" inner join T_FM_BreedStandardLayEggEntry tentry on tentry.fparentid=tmain.fid")
		.append(" where tmain.FCompanyID='").append(companyID).append("'")
		.append(" and FBreedDataID='").append(breedDataID).append("'")
		.append(" and FBaseStatus=3")//启用状态
		//		.append(" and CFWeek<=").append(week).append(" and CFDays<=").append(weekDay).append(" ")
		//		.append(" and ( (FEndWeek=").append(week).append(" and FEndDays>").append(weekDay).append(" )")
		//		.append(" or FEndWeek>").append(week)
		//		.append(" )")
		.append(" and (")
		//起始周日均大于当前
		.append(" (CFWeek<=").append(week).append(" and CFDays<=").append(weekDay).append(" ")
		//结束同周，日大于当前日
		.append(" and ((FEndWeek=").append(week).append(" and FEndDays>=").append(weekDay).append(" )")
		//周大于当前周
		.append(" or FEndWeek>").append(week).append(" ))")
		//0周 进行日龄判断
		.append(" or (CFWeek=0 and CFDays<=").append(dayAge).append(" and FEndWeek=0 and FEndDays>=").append(dayAge).append(")")
		.append(" )")
		.append(" order by tentry.FSeq");
		
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			//没有产蛋规范则退出
			if(rs.size()<=0) {
				return standardArr;
			}
		} catch (BOSException e) {
			e.printStackTrace();
		}
		
		ArrayList<String> list = StockingComm.getEggListByStockingBatchID(ctx, batchId,true);
		if(list!=null){
			try{
				IMaterial ims = MaterialFactory.getRemoteInstance();
				MaterialInfo mInfo;
				IRow row;
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add(new SelectorItemInfo("*"));
				slor.add(new SelectorItemInfo("baseUnit.*"));
				
				for(String materialID:list) {
					    JSONObject object = new JSONObject();
						mInfo=ims.getMaterialInfo(new ObjectUuidPK(materialID),slor);
						object.put("material", mInfo.getId().toString());
						object.put("materialName", mInfo.getName());
						object.put("model", mInfo.getModel());
						object.put("unitId", mInfo.getBaseUnit().getId().toString());
						object.put("unitName", mInfo.getBaseUnit().getName());
						object.put("number", mInfo.getNumber());
						standardArr.add(object);
					
				}
			}catch(Exception err) {
				err.printStackTrace();
			}
		}
		return standardArr;
		
	}
	
	
	/**
	 * 获取批次即时信息
	 * @param ctx
	 * @param batchId
	 * @throws BOSException 
	 */
	public static BatchInfoBean getBatchInfoBean(Context ctx,String batchId,Date bizDate,boolean includeBizDate) throws BOSException {
		BatchInfoBean bean=new BatchInfoBean();
		bean.setBatchId(batchId);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sql=new StringBuffer();
		sql
		.append(" select FBatchId,sum(FInitQty) FInitQty,")
		.append(" sum(FDeathAndCullQty) FDeathAndCullQty,sum(FOutQty) FOutQty,sum(FFodderWgt) FFodderWgt")
		.append(" from (")
		.append(" select tbatch.fid FBatchId,isnull(tbatch.FFemaleQty,0) FInitQty,")
		.append(" 0 FDeathAndCullQty,0 FOutQty,0 FFodderWgt")
		.append(" from T_FM_Batch tbatch")
		.append(" where tbatch.fid='").append(batchId).append("'")
		.append(" union all")
		.append(" select tbatch.fid FBatchId,0 FInitQty,")
		.append(" isnull(sum(tentry.CFDeathAndCullQty),0) FDeathAndCullQty,")
		.append(" isnull(sum(FOutQty),0) FOutQty,")
		.append(" sum(isnull(tentry.CFFeedMateriel1,0)+isnull(tentry.CFFeedMateriel2,0)+isnull(tentry.CFFeedMateriel3,0)+isnull(tentry.CFFeedMateriel4,0)) FFodderWgt")
		.append(" from CT_FM_StockDailyNew tmain")
		.append(" inner join CT_FM_StockDailyNewEntry tentry on tentry.fparentid=tmain.fid")
		.append(" inner join T_FM_Batch tbatch on tbatch.fid=tentry.CFBatchID")
		.append(" where tmain.CFBillStatus=4")
		.append(" and tbatch.fid='").append(batchId).append("'");
		//包含业务日期
		if(includeBizDate) {
			sql.append(" and tmain.FBizDate<({d '").append(sdf.format(bizDate)).append("'}+1)");
		}else {
			sql.append(" and tmain.FBizDate<{d '").append(sdf.format(bizDate)).append("'}");
		}
		sql.append(" group by tbatch.fid")
		.append(" ) tt group by FBatchId");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try {
			if(rs.next()) {
				bean.setInitQty(rs.getInt("FInitQty"));
				bean.setSumDeathAndCullQty(rs.getInt("FDeathAndCullQty"));
				bean.setSumOutQty(rs.getInt("FOutQty"));
				bean.setSumFodderWgt(rs.getBigDecimal("FFodderWgt"));
				bean.setCurQty(bean.getInitQty()-bean.getSumDeathAndCullQty()-bean.getSumOutQty());
			}
		} catch (SQLException e) {
			throw new BOSException(e);
		}
		return bean;
	}
	
	/**
	 * 根据批次获取
	 * @return
	 */
	private LinkedList<FarmHouseEntryInfo> getHouseIDListByBatch(Context ctx,String batchId) {
		LinkedList<FarmHouseEntryInfo> list=new LinkedList<FarmHouseEntryInfo>();

		//没有启动棚舍管理
		if(!isHouseManager) {//sysSetting.isIsHouseManager(
			return list;
		}
//		String batchID=null;
//		if(prmtstockingBatch.getValue()!=null) {
//			batchID=((IPropertyContainer) prmtstockingBatch.getValue()).getString("id");
			/*try{
				StringBuffer sql=new StringBuffer();
				sql.append(" select tentry.FhouseID")
				.append(" from T_FM_StockingBatch tmain")
				.append(" inner join  T_FM_StockingBatchHouseEntry tentry on tentry.fparentid=tmain.fid")
				.append(" inner join CT_FM_FarmHouseEntry the on the.fid=tentry.FhouseID")
				.append(" where tmain.fid='").append(((IPropertyContainer) prmtstockingBatch.getValue()).getString("id")).append("'")
				.append(" and tentry.FIsAllout=0")//没有完全出栏
				.append(" order by the.FSeq")
				;
				IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
				IFarmHouseEntry ifs = FarmHouseEntryFactory.getRemoteInstance();
				while(rs.next()) {
					list.add(ifs.getFarmHouseEntryInfo(new ObjectUuidPK(rs.getString("FhouseID"))));
				}
			}catch(Exception err) {
				err.printStackTrace();
			}*/
			try{
				IFarmHouseEntry ifs = FarmHouseEntryFactory.getRemoteInstance();
				LinkedHashSet<String> houseSetByBatchID = StockingComm.getHouseSetByBatchID(ctx,batchId);
				for(String id: houseSetByBatchID){
					list.add(ifs.getFarmHouseEntryInfo(new ObjectUuidPK(id)));
				}
			}catch(Exception err) {
				err.printStackTrace();
			}
//		}
		return list;
	}
	

}
