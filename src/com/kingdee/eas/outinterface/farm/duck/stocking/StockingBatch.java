package com.kingdee.eas.outinterface.farm.duck.stocking;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.BatchLastBean;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.base.utils.JUtils;
import com.kingdee.eas.outinterface.farm.duck.busniess.BatchInfoBean;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 放养批次
 * @author alex_dai
 *
 */
public class StockingBatch extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "00751DDD";
	}
	
	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","name","farm.name"
				,"farmer.name","baseStatus","inDate"
				,"batchContract.number","breedData.name"
		};
	}
	
	
	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		//如果日报，则根据日期过滤出尚未填写的批次
		if(jo.getBooleanValue("isStockingDaily")) {
			return "order by inDate";
		}
		return "order by number";
	}
	

	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","name","isAllOut","femaleQty","allOutDate"
				,"farmer.id","farmer.name","baseStatus"
				,"batchContract.id","batchContract.number"
				,"breedData.id","breedData.name","inDate","farm.id","farm.name","totalQty","matureDate","cohortQty"
				//名称  、品种信息  上苗日期   养殖场栋舍   养殖总数  定群日期  定群数量
				,"HouseEntry.house.id","HouseEntry.house.name","HouseEntry.inData","HouseEntry.qty","HouseEntry.femaleQty"
				 // 棚舍明细(分录)：棚舍  、入雏日期（一行展示不开可以去掉）、公禽数 、母禽数
		};
	}
   

	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		// TODO Auto-generated method stub
		return super.dealBeforeGetDataJSON(ctx, model);
	}

	@Override
	public JSONObject getData(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException {
		// TODO Auto-generated method stub
		JSONObject paramsJson=JSONObject.parseObject(jsonStr);
		//查询数据的业务日期
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
			if(batchInfo.getInDate()!=null) {
				int week=0;
				int weekDay=0;
				int dayAge=0;
				if(batchInfo.getInDate()!=null) {
					//周龄 *周*
					int[] result = StockingComm.getBreedWeekAndDay(bizDate, batchInfo.getInDate());
					week=result[0];
					weekDay=result[1];
					dayAge=StockingComm.getDayAgeByWeekAge(ctx, batchInfo, week, weekDay);
				}
				//周龄
				dataJson.put("week", week);
				dataJson.put("weekDay",weekDay);
				//日龄
				dataJson.put("dayAge", dayAge);
				
				try {
					BatchLastBean bean = StockingComm.getEntryHouseBatchBean(ctx,null,batchInfo.getCompany().getString("id"),bizDate, batchInfo.getString("id"), null);
					dataJson.put("inDate", bean.getInDate());
					dataJson.put("initQty", bean.getInitQty());
					dataJson.put("initFemaleQty", bean.getInitFemaleQty());
					dataJson.put("sumDeathAndCullQty", bean.getDeathCullQty());
					dataJson.put("sumFemaleDeathAndCullQty", bean.getFemaleDeathCullQty());
					dataJson.put("lastStock", bean.getLaskStock());
					dataJson.put("femaleLastStock", bean.getFemaleLaskStock());
				} catch (Exception e) {
					throw new BOSException(e);
				}
			}
		}
		
		return reusltJson;
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

	@Override
	protected String getListQueryStr(Context ctx, JSONObject jo) throws BOSException {
		String number=jo.getString("number");
		StringBuffer queryStr=new StringBuffer();
		queryStr.append("where baseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE);
		
		//养户过滤
		if(StringUtils.isNotEmpty(jo.getString("farmer.id"))) {
			queryStr.append(" and farmer.id='").append(jo.getString("farmer.id")).append("'");
		}
		
		//只过滤未出栏的
		if(!jo.getBooleanValue("isIncludeAllOut")){
			//只过滤未出栏的
			String bizDate=jo.getString("bizDate");
			if(StringUtils.isNotBlank(bizDate)) {
				queryStr.append(" and (allOutDate is null or allOutDate>'").append(bizDate).append("') ");
			}else {
				queryStr.append(" and (isAllOut is null or isAllOut=0) ");
			}
		}
		
		//如果日报，则根据日期过滤出尚未填写的批次
		if(jo.getBooleanValue("isStockingDaily")) {
			Date bizDate=jo.getDate("bizDate");
			if(bizDate==null) {
				bizDate=new Date();
			}
			if(bizDate!=null) {
				queryStr.append(" and id not in (")
				.append(" select distinct tmain.CFStockingBatchID from T_FM_StockingBreedDaily tmain")
				.append(" where to_char(tmain.FBizDate,'yyyy-MM-dd')='").append(JUtils.SDF_DAY.format(bizDate)).append("'")
//				.append(" and tentry.CFBatchID=\"BATCH\".FID")
				.append(" )")
				;
			}
		}
		
		//编码查询
		if(StringUtils.isNotBlank(number)) {
			queryStr.append("and (number like '%").append(number).append("%'")
			.append(" or name like '%").append(number).append("%')")
			;
		}
	
		//角色
		String rolesStr=StockingInterfaceUtils.getRoleFilterStr(jo, "farm");
		if(rolesStr.length()>0) {
			//顺祥没有养户代养种鸡，去掉养户过滤
			queryStr.append(" AND (").append(rolesStr).append(")");
		}

		return queryStr.toString();
	}

}
