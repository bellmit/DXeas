package com.kingdee.eas.outinterface.farm.duck.busniess;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.base.utils.JUtils;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 商品禽批次
 * @author alex_dai
 *
 */
public class Batch extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "83B77AD8";
	}


	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","name","farm.name"
				,"farmer.name","baseStatus","inDate"
				,"batchContract.number","breedData.name","isRecSettled"				
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
				,"farmer.id","farmer.name","baseStatus","inDate"
				,"farm.id","farm.name","farm.*"
				,"batchContract.id","batchContract.number"
				,"person.id","person.name"
				,"breedData.id","breedData.name" 
				,"marketPolicy.id","marketPolicy.number","marketPolicy.name"
		};
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
			BatchInfo batchInfo = BatchFactory.getLocalInstance(ctx).getBatchInfo(new ObjectUuidPK(batchId));
			if(batchInfo.getInDate()!=null) {
				//日龄
				dataJson.put("dayAge", DuckBusinessUtils.getDayDiff(batchInfo.getInDate(), bizDate));

				BatchInfoBean bean=getBatchInfoBean(ctx, batchId, bizDate,false);
				dataJson.put("initQty", bean.getInitQty());
				dataJson.put("sumDeathAndCullQty", bean.getSumDeathAndCullQty());
				dataJson.put("sumOutQty", bean.getSumOutQty());
				dataJson.put("sumFodderQty", bean.getSumFodderWgt());
				dataJson.put("beginCurQty", bean.getCurQty());
				
				BigDecimal feedStand = getFeedStand(ctx,batchId,null);
				dataJson.put("feedStand",feedStand);
				
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
		//		sql
		//		.append(" select FBatchId,sum(FInitQty) FInitQty,")
		//		.append(" sum(FDeathAndCullQty) FDeathAndCullQty,sum(FOutQty) FOutQty,sum(FFodderWgt) FFodderWgt")
		//		.append(" from (")
		//		.append(" select tbatch.fid FBatchId,isnull(tbatch.FFemaleQty,0) FInitQty,")
		//		.append(" 0 FDeathAndCullQty,0 FOutQty,0 FFodderWgt")
		//		.append(" from T_FM_Batch tbatch")
		//		.append(" where tbatch.fid='").append(batchId).append("'")
		//		.append(" union all")
		//		.append(" select tbatch.fid FBatchId,0 FInitQty,")
		//		.append(" isnull(sum(tentry.CFDeathAndCullQty),0) FDeathAndCullQty,")
		//		.append(" isnull(sum(FOutQty),0) FOutQty,")
		//		.append(" sum(isnull(tentry.CFFeedMateriel1,0)+isnull(tentry.CFFeedMateriel2,0)+isnull(tentry.CFFeedMateriel3,0)+isnull(tentry.CFFeedMateriel4,0)) FFodderWgt")
		//		.append(" from CT_FM_StockDailyNew tmain")
		//		.append(" inner join CT_FM_StockDailyNewEntry tentry on tentry.fparentid=tmain.fid")
		//		.append(" inner join T_FM_Batch tbatch on tbatch.fid=tentry.CFBatchID")
		//		.append(" where tmain.CFBillStatus=4")
		//		.append(" and tbatch.fid='").append(batchId).append("'");
		//包含业务日期
		//		if(includeBizDate) {
		//			sql.append(" and tmain.FBizDate<({d '").append(sdf.format(bizDate)).append("'}+1)");
		//		}else {
		//			sql.append(" and tmain.FBizDate<{d '").append(sdf.format(bizDate)).append("'}");
		//		}
		//		sql.append(" group by tbatch.fid")
		//		.append(" ) tt group by FBatchId");
		//饲喂重量的获取
		sql
		.append(" select FBatchId,sum(FInitQty) FInitQty,")
		.append(" sum(FDeathAndCullQty) FDeathAndCullQty,sum(FOutQty) FOutQty")
		.append(" from (")
		.append(" select tbatch.fid FBatchId,isnull(tbatch.FFemaleQty,0) FInitQty,")
		.append(" 0 FDeathAndCullQty,0 FOutQty")
		.append(" from T_FM_Batch tbatch")
		.append(" where tbatch.fid='").append(batchId).append("'")
		.append(" ) tt group by FBatchId");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try {
			if(rs.next()) {
				bean.setInitQty(rs.getInt("FInitQty"));
				bean.setSumDeathAndCullQty(rs.getInt("FDeathAndCullQty"));
				bean.setSumOutQty(rs.getInt("FOutQty"));
				//				bean.setSumFodderWgt(rs.getBigDecimal("FFodderWgt"));
				bean.setSumFodderWgt(BigDecimal.ZERO);
				bean.setCurQty(bean.getInitQty()-bean.getSumDeathAndCullQty()-bean.getSumOutQty());
			}
		} catch (SQLException e) {
			throw new BOSException(e);
		}
		return bean;
	}

	@Override
	protected String getListQueryStr(Context ctx, JSONObject jo) throws BOSException {
		String number=jo.getString("name");
		StringBuffer queryStr=new StringBuffer();
		queryStr.append("where baseStatus=").append(FarmBaseStatusEnum.APPROVE_VALUE);

		//养户过滤
		if(StringUtils.isNotEmpty(jo.getString("farmer.id"))) {
			queryStr.append(" and farmer.id='").append(jo.getString("farmer.id")).append("'");
		}
		//养殖场过滤
		if(StringUtils.isNotEmpty(jo.getString("farm.id"))) {
			queryStr.append(" and farm.id='").append(jo.getString("farm.id")).append("'");
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
				.append(" select distinct tentry.CFBatchID from CT_FM_StockDailyNew tmain")
				.append(" inner join CT_FM_StockDailyNewEntry tentry on tentry.fparentid=tmain.fid")
				.append(" where to_char(tmain.FBizDate,'yyyy-MM-dd')='").append(JUtils.SDF_DAY.format(bizDate)).append("'")
				.append(" and tentry.CFBatchID=\"BATCH\".FID")
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
			//司机--根据养户范围过滤
			if(StringUtils.equalsIgnoreCase(role,"driver")){
				rolesStr.append(" farmer.id in (")
				.append(" select distinct tentry.FFarmerID")
				.append(" from T_FM_DriverFarmerRealtion tmain")
				.append(" inner join T_FM_DriverFarmerRealtionEntry tentry on tentry.fparentid=tmain.fid")
				.append(" inner join CT_FM_Driver tp on tp.fid=tmain.FDriverID")
				.append(" where tp.CFDrivercardid='").append(jo.getString("idNo")).append("'")
				.append(" and tmain.FBaseStatus=3")
				.append(")");
			}
		}
		if(rolesStr.length()>0) {
			queryStr.append(" AND (").append(rolesStr).append(")");
		}

		return queryStr.toString();
	}


	@Override
	public JSONObject getList(Context ctx, String jsonStr) throws BOSException,
	EASBizException, RemoteException {
		// TODO Auto-generated method stub
		JSONObject reusltJson = super.getList(ctx, jsonStr);

		JSONArray dataJson=null;
		JSONObject batchJson = null;
		if(reusltJson.getString("result").equals("0")) {
			dataJson=reusltJson.getJSONArray("data");
			for(int i = 0,size = dataJson.size();i<size;i++){

				//批次自动带出累计送料量
				StringBuffer sql=new StringBuffer();
				batchJson = (JSONObject) dataJson.get(i);
				String batciid = batchJson.getString("id");
				sql.append("/*dialect*/ select sum(nvl(t2.FReceiveQty,0)) recQty from T_FM_FodderReception t1");
				sql.append(" inner join T_FM_FodderReceptionEntry t2 on t2.fparentid = t1.fid");
				sql.append(" where t1.fbillstatus = 4 and t1.CFBatchID = '");
				sql.append(batciid);
				sql.append("'");
				IRowSet r1 = DbUtil.executeQuery(ctx,sql.toString());
				BigDecimal recQty = BigDecimal.ZERO;
				try {
					if(r1.next()){
						recQty = UIRuleUtil.getBigDecimal(r1.getBigDecimal("recQty"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				batchJson.put("allFeedQty",recQty);
				BigDecimal feedStand = getFeedStand(ctx,batciid,batchJson);
				batchJson.put("feedStand",feedStand);
			}
		}

		return reusltJson;
	}

	private BigDecimal getFeedStand(Context ctx, String batciid, JSONObject batchJson) {
		// TODO Auto-generated method stub
		BatchInfo batchInfo;
		BigDecimal feedStand = BigDecimal.ZERO;
		try {
			//批次自动带出饲喂标准
			batchInfo = BatchFactory.getLocalInstance(ctx).getBatchInfo(new ObjectUuidPK(batciid));
			int[] result = StockingComm.getBreedWeekAndDay(new Date(), batchInfo.getInDate());
			int week=result[0];
			int weekDay=result[1];
			String s1 = "/*dialect*/ select t2.CFQtyPerday qty from CT_FM_BreedModel t1" +
			" inner join CT_FM_BreedModelEntrys t2 on t2.fparentid = t1.fid" +
			" where t1.CFBreedDataID = '"+batchInfo.getBreedData().getId()+"' and t2.CFWeek<='"+week+"' and t2.CFWeekTo>='"+week+"' and t2.CFWeekDay<='"+weekDay+"' and t2.CFDayTo>='"+weekDay+"'";
			IRowSet r1 = DbUtil.executeQuery(ctx,s1);
			if(r1.next()){
				feedStand = UIRuleUtil.getBigDecimal(r1.getBigDecimal("qty"));
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return feedStand;
	}


	/**
	 * 获取日龄
	 * @param bizDate
	 * @param batchDate
	 * @return
	 */
	private int getBreedWeekAndDay(Date bizDate,Date batchDate) {
		// TODO Auto-generated method stub
		return 0;
	}

}
