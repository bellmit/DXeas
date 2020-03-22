package com.kingdee.eas.farm.food.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.BreedModelFactory;
import com.kingdee.eas.farm.food.SlaughterPlanFacadeFactory;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.farm.food.foodCommUtils.foodComm;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class SlaughterPlanFacadeControllerBean extends AbstractSlaughterPlanFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.food.app.SlaughterPlanFacadeControllerBean");
	protected LinkedHashMap _getSlaughterPlan(Context ctx, IObjectValue fiscalPeriod, int ageOfDaysFrom,int ageOfDaysTo)throws BOSException, EASBizException
	{
		PeriodInfo fiscalPeriodInfo = (PeriodInfo)fiscalPeriod;
		if(fiscalPeriodInfo==null||ageOfDaysFrom==0||ageOfDaysFrom<0||ageOfDaysTo==0||ageOfDaysTo<0||ageOfDaysTo<ageOfDaysFrom)
			return null;

		//获得养殖批次的入栏日期范围
		Date[] dateRange=getBreedDateRange(fiscalPeriodInfo,ageOfDaysFrom,ageOfDaysTo);
		Date dateBegin = dateRange[0];
		Date dateEnd=dateRange[1];

		// 获得屠宰计划的初始数据
		LinkedHashMap<String, String> map=new LinkedHashMap<String, String>();
		map=getBaseDataFromCCDailyAndBreedBatch(ctx,dateBegin,dateEnd);

		//整理初始数据获得最终数据
		//		list=getSlaughterDataFromInitialList(ctx,inititialList,ageOfDaysTo);


		return map;
	}


	/**
	 * 根据批次和商品鸡日报获得特定日期范围内的初始数据
	 * @param ctx
	 * @param dateBegin
	 * @param dateEnd
	 * @return
	 * @throws EASBizException 
	 */
	private java.util.LinkedHashMap<String,String> getBaseDataFromCCDailyAndBreedBatch(Context ctx,
			Date dateBegin, Date dateEnd) throws EASBizException {
		// TODO Auto-generated method stub
		LinkedHashMap<String,String> map = new LinkedHashMap<String, String>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");


		StringBuffer sb=new StringBuffer();
		sb=getStringBufferBasedOnDataRange(dateBegin,dateEnd);

		IRowSet rs;
		try {
			rs = DbUtil.executeQuery(ctx, sb.toString());
			String [] array=new String[5];
			while(rs.next()){
				array[0]=sdf.format(rs.getDate("incoopDate"));
				array[1]=rs.getString("stoOrgID");
				array[2]=rs.getString("wareHouseID");
				array[3]=rs.getString("breedBatch");
				array[4]="false";
				
				if(null==SlaughterPlanFacadeFactory.getLocalInstance(ctx).getSlaughterQtyInOneDay(array[1],array[2],array[3]))
					continue;
				
				map.put(foodComm.getKey(array),"00_00_00");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}



	/**
	 * 根据日期范围获得ksql语句
	 * @param dateBegin
	 * @param dateEnd
	 * @return
	 * @author shootingstarxx
	 */
	private StringBuffer getStringBufferBasedOnDataRange(Date dateBegin,
			Date dateEnd) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");


		sb.append(" select  t2.fid breedBatch,t2.CFStoOrgID stoOrgID,t1.CFHenHouseID wareHouseID,t3.CFName henHouseName,t1.CFIncoopDate incoopDate,CFInitQty initQty"); 
		sb.append(" from CT_FM_BreedBatchEntry t1");
		sb.append(" inner join CT_FM_BreedBatch t2 on t2.FID=t1.FParentID");
		sb.append(" inner join CT_FM_Henhouse t3 on t3.FID=t1.CFHenHouseID");
//		sb.append(" inner join CT_FM_CommecialChilkenDaily         t4 on t2.FID=t4.CFBreedBatchID");
//		sb.append(" inner join CT_FM_CommecialCDAE                 t5 on t4.FID=t5.FParentID");
//		sb.append(" and t5.CFHenhouseID=t3.FID");
//		sb.append(" inner join CT_FM_Henhouse t3 on t3.FID=t1.CFHenHouseID");
		
		sb.append(" where  t2.CFHouseType=3");



		//		sb.append(" where t2.CFBaseStatus=4 and t2.CFHouseType=3");
		sb.append(" and t1.CFIncoopDate>={ts '").append(sdf.format(dateBegin)).append("'} and t1.CFIncoopDate<={ts '").append(sdf.format(dateEnd)).append("'}");
		sb.append(" and t1.CFIsMarket=0");
		sb.append(" order by t1.CFIncoopDate,t2.CFStoOrgID,t3.CFName,t1.CFHenHouseID");
		return sb;
	}


	/**
	 * 获得养殖批次中  预计能落在当前会计期间内的   入栏日期 的时间段
	 * @param fiscalPeriodInfo                           会计期间
	 * @param ageOfDays                                  标准日龄
	 * @return
	 */
	private Date[] getBreedDateRange(PeriodInfo fiscalPeriodInfo, int ageOfDaysFrom,int ageOfDaysTo ) {
		// TODO Auto-generated method stub

		Date[] dateRange=new Date[2];
		Calendar calBenginDate=Calendar.getInstance();
		Calendar calEndDate=Calendar.getInstance();

		calBenginDate.setTime(fiscalPeriodInfo.getBeginDate());
		calEndDate.setTime(fiscalPeriodInfo.getEndDate());

		calBenginDate.add(Calendar.DATE, -ageOfDaysTo);
		calEndDate.add(Calendar.DATE, -ageOfDaysFrom);
		dateRange[0]=calBenginDate.getTime();
		dateRange[1]=calEndDate.getTime();


		return dateRange;
	}

	/**
	 * 获得死淘信息的map
	 */
	@Override
	protected Map _getCullAndDeathFromFeedModel(Context ctx)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		Map<Integer,BigDecimal> cullAndDeath=new HashMap<Integer, BigDecimal>();//死淘
		try {
			CoreBaseCollection coll = BreedModelFactory.getLocalInstance(ctx).getCollection(" where DeletedStatus=1 and HouseType=3");
			if(coll.size()>1)
				throw new EASBizException(new NumericExceptionSubItem("001","存在多个启用的商品鸡养殖规范"));
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer sb=new StringBuffer();
		sb.append("select t2.CFDays days,t2.CFDailyDCRate dailyDCRate from CT_FM_BreedModel t1");
		sb.append(" inner join CT_FM_BreedModelEntrys t2 on t2.FParentID=t1.Fid");
		sb.append(" where t1.CFDeletedStatus=1 and t1.CFHouseType=3");
		IRowSet rs;
		try {
			rs = DbUtil.executeQuery(ctx, sb.toString());
			while(rs.next())
				cullAndDeath.put(Integer.valueOf(rs.getString("days")),rs.getBigDecimal("dailyDCRate"));
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cullAndDeath;
	}




	/**
	 * 获得商品鸡日报的养殖  最后某日剩余只数
	 * @param breedBatchID
	 * @param stoOrgUnitID
	 * @param henHouseID
	 * @param maxAgeOfDays
	 * @return
	 */
	private StringBuffer getStringBufferToGetSlaughterQty(String breedBatchID, String stoOrgUnitID, String henHouseID, int maxAgeOfDays) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		//
		//		sb.append(" select max(t2.FBizDate) bizDate,t4.CFIncoopDate incoopDate,t1.CFHenhouseID wareHouseID,t2.CFBreedBatchID breedBatchID,t2.CFStoOrgID stoOrgID,t1.CFDays CFDays,t1.CFBreedingStock CFBreedingStock");
		//		sb.append("  from CT_FM_CommecialCDAE t1");
		//		sb.append("  inner join  CT_FM_CommecialChilkenDaily t2 on t2.Fid=t1.FParentID ");
		//
		//
		//
		//
		//		//		sb.append("  inner join  CT_FM_CommecialChilkenDaily t2 on t2.Fid=t1.FParentID and t2.CFBaseStatus=4");
		//		//		sb.append("  inner join  CT_FM_BreedBatch t3 on t3.Fid=t2.CFBreedBatchID and t2.CFStoOrgID=t3.CFStoOrgID and  t3.CFBaseStatus=4 and t3.CFHouseType=3");
		//		sb.append("  inner join  CT_FM_BreedBatch t3 on t3.Fid=t2.CFBreedBatchID and t2.CFStoOrgID=t3.CFStoOrgID  and t3.CFHouseType=3");
		//		sb.append("  and t3.FID='").append(breedBatchID).append("'");
		//		sb.append("  and t2.CFStoOrgID='").append(sroOrgUnitID).append("'");
		//		sb.append("  and t1.CFHenhouseID='").append(henHouseID).append("'");
		//		sb.append("  inner join  CT_FM_BreedBatchEntry t4 on t4.FParentID=t3.FID and t4.CFHenHouseID=t1.CFHenhouseID");
		//		sb.append(" and t1.CFBreedingStock<>0");
		//		sb.append(" and t1.CFDays=").append(maxAgeOfDays).append("");
		//		sb.append(" group by t4.CFIncoopDate,t1.CFHenhouseID,t2.CFBreedBatchID,t2.CFStoOrgID");


		sb.append(" /*dialect*/SELECT");
		sb.append(" t6.FName_l2           stoOrgUnit,");
		sb.append(" t7.FName_l2           breedBatch,");
		sb.append(" t4.CFname             henHouse,");
		sb.append(" t1.CFDays             CFDays,");
		sb.append(" t2.FBizDate           bizDate,");
		sb.append(" t5.CFInitQty-sum(t1.CFCullAndDeath) over (PARTITION BY t6.FName_l2,t7.FName_l2,t4.CFname ORDER BY t1.CFDays,t2.FBizDate)   CFBreedingStock");
		sb.append(" FROM");
		sb.append(" CT_FM_CommecialCDAE                                    t1");
		sb.append(" inner join CT_FM_CommecialChilkenDaily                 t2  on t2.FID=t1.FParentID");
		//		sb.append("                                                        and   t2.CFBaseStatus=4");
		sb.append(" inner join CT_FM_BreedBatch                            t3  on t3.FID=t2.CFBreedBatchID");
		sb.append(" inner join CT_FM_Henhouse                              t4  on t4.FID=t1.CFHenhouseID");

		sb.append(" inner join CT_FM_BreedBatchEntry                       t5  on t3.FID=t5.FParentID");
		sb.append("                                                        and t5.CFHenHouseID=t1.CFHenhouseID");
		sb.append(" inner join T_ORG_Storage                               t6  on t6.FID=t2.CFStoOrgID");
		sb.append(" inner join T_BD_CostObject                             t7  on t7.FID=t3.CFCostObjectID");
		sb.append(" where t2.CFStoOrgID='").append(stoOrgUnitID).append("'");
		sb.append(" and t2.CFBreedBatchID='").append(breedBatchID).append("'");
		sb.append(" and t4.FID='").append(henHouseID).append("'");
		//		sb.append(" and t1.CFDays=").append(maxAgeOfDays);
		sb.append(" and t1.CFIsMarketed=0 and CFBreedingStock>0");




		return sb;
	}

	/**
	 * 获得 特定的养殖批次、养殖场和鸡舍   在商品鸡日报的 最新饲喂数据
	 */
	@Override
	protected String[] _getSlaughterQtyInOneDay(Context ctx,
			String sroOrgUnitID, String henHouseID, String breedBatchID)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		String []str=new String[3];
		StringBuffer sql = getStringBufferToGetMaxAgeOfDays(breedBatchID, sroOrgUnitID, henHouseID);
		IRowSet irowset = DbUtil.executeQuery(ctx, sql.toString());

		int maxAgeOfDays=0;

		if(irowset.size()==0)
			return null;

		try {
			if(irowset.next())
				maxAgeOfDays=irowset.getInt("ageOfDays");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		sb=getStringBufferToGetSlaughterQty(breedBatchID, sroOrgUnitID, henHouseID,maxAgeOfDays);
		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		try {
			while(rs.next())
				if(rs.getInt("CFDays")==maxAgeOfDays){
					str[0]=rs.getString("bizDate");
					str[1]=rs.getString("CFBreedingStock");
					str[2]=rs.getString("CFDays");
					return str;
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取某个养殖场某个批次某个鸡舍的最大日龄
	 * @param breedBatchID
	 * @param sroOrgUnitID
	 * @param henHouseID
	 * @return
	 */
	private StringBuffer getStringBufferToGetMaxAgeOfDays(String breedBatchID,
			String stoOrgUnitID, String henHouseID) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		sb.append("/*dialect*/SELECT");
		sb.append(" max(t1.CFDays)             ageOfDays");
		sb.append(" FROM");
		sb.append(" CT_FM_CommecialCDAE                                    t1");
		sb.append(" inner join CT_FM_CommecialChilkenDaily                 t2  on t2.FID=t1.FParentID");
		//		sb.append(" and   t2.CFBaseStatus=4");
		sb.append(" inner join CT_FM_BreedBatch                            t3  on t3.FID=t2.CFBreedBatchID");
		sb.append(" inner join CT_FM_Henhouse                              t4  on t4.FID=t1.CFHenhouseID");
		sb.append(" inner join CT_FM_BreedBatchEntry                       t5  on t3.FID=t5.FParentID");
		sb.append(" and t5.CFHenHouseID=t1.CFHenhouseID");
		sb.append(" inner join T_ORG_Storage                               t6  on t6.FID=t2.CFStoOrgID");
		sb.append(" inner join T_BD_CostObject                             t7  on t7.FID=t3.CFCostObjectID");
		sb.append(" where t2.CFStoOrgID='").append(stoOrgUnitID).append("'");
		sb.append(" and t2.CFBreedBatchID='").append(breedBatchID).append("'");
		sb.append(" and t4.FID='").append(henHouseID).append("'");
		return sb;
	}

}