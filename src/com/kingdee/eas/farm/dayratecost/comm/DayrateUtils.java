package com.kingdee.eas.farm.dayratecost.comm;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.basedata.assistant.IPeriod;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.farm.dayratecost.DayRateBaseSettingFactory;
import com.kingdee.eas.farm.dayratecost.DayRateBaseSettingInfo;
import com.kingdee.eas.farm.dayratecost.IDayRateBaseSetting;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.PropertyContainer;

/**
 * 日成本计算工具类
 * @author dai_andong
 *
 */
public class DayrateUtils {
	public static final int LastStockCountType_All=0;
	public static final int LastStockCountType_Male=2;
	public static final int LastStockCountType_Female=1;
	/**
	 * 获取系统基础设置
	 * @param ctx
	 * @param companyID
	 * @return
	 */
	public static  DayRateBaseSettingInfo getBaseSetting(Context ctx,String companyID) {
		try {
			IRowSet rs;
			IDayRateBaseSetting ids;
			if(ctx==null) {
				rs=SQLExecutorFactory.getRemoteInstance("select fid from T_FM_DayRateBaseSetting where fcompanyid='"+companyID+"'").executeSQL();
				ids=DayRateBaseSettingFactory.getRemoteInstance();
			}else{
				rs=DbUtil.executeQuery(ctx,"select fid from T_FM_DayRateBaseSetting where fcompanyid='"+companyID+"'");
				ids = DayRateBaseSettingFactory.getLocalInstance(ctx);
			}
			if(rs.next()) {
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				slor.add("currentPeriod.*");
				return ids.getDayRateBaseSettingInfo(new ObjectUuidPK(rs.getString("fid")),slor);
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	/**
	 * 计算在养天只
	 * @param ctx
	 * @param companyID
	 * @param beginDateStr
	 * @param endDateStr
	 * @param batchID
	 * @param houseID
	 * @return
	 * @throws Exception 
	 */
	public static int getOnBreedDayStock(Context ctx,String companyID,Date beginDate,Date endDate,String batchID,String houseID,int countType) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		cal.setTime(beginDate);
		int allQty=0;
		int qty;
		while(true) {
			if(cal.getTime().compareTo(endDate)>0) {
				break;
			}
			qty=getStockingLastStock(ctx, companyID, sdf.format(cal.getTime()), batchID, houseID,countType);
//			System.out.println(batchID+"    "+sdf.format(cal.getTime())+"   "+qty);
			allQty+=qty;
			cal.add(Calendar.DAY_OF_MONTH,1);
		}
		return allQty;
	}

	/**
	 * 计算最后只存栏量
	 * @param ctx
	 * @param companyID
	 * @param bizDate
	 * @param batchID
	 * @param houseID
	 * @return
	 * @throws Exception
	 */
	public static int getStockingLastStock(Context ctx,String companyID,Date bizDate,String batchID,String houseID,int countType) throws Exception  {
		return getStockingLastStock(ctx, companyID, new SimpleDateFormat("yyyy-MM-dd").format(bizDate), batchID, houseID,countType);
	}
	/**
	 * 计算每日存栏量
	 * @param ctx
	 * @param companyID
	 * @param beginDateStr
	 * @param endDateStr
	 * @param batchID
	 * @param houseID
	 */
	public static int getStockingLastStock(Context ctx,String companyID,String bizDateStr,String batchID,String houseID,int countType) throws Exception  {
		String sql=getLastStockSql(ctx, companyID, bizDateStr, batchID, houseID);
		IRowSet rs=null;
		if(ctx!=null)  {
			rs=DbUtil.executeQuery(ctx, sql);
		}else{
			rs=SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
		}
		if(rs.next()) {
			if(countType==LastStockCountType_All) {
				return rs.getInt("FQty")+rs.getInt("FFemaleQty")-rs.getInt("FOccurQty")-rs.getInt("FFemaleOccurQty");
			}else if(countType==LastStockCountType_Male) {
				return rs.getInt("FQty")-rs.getInt("FOccurQty");
			}else if(countType==LastStockCountType_Female) {
				return rs.getInt("FFemaleQty")-rs.getInt("FFemaleOccurQty");
			}
		}
		return 0;
	}
	/**
	 * 获取存栏数
	 * @param ctx
	 * @param companyID
	 * @param bizDateStr
	 * @param batchID
	 * @param houseID
	 * @param countType
	 * @return
	 * @throws Exception
	 */
	public static int[] getStockingLastStockBoth(Context ctx,String companyID,String bizDateStr,String batchID,String houseID,int countType) throws Exception  {
		String sql=getLastStockSql(ctx, companyID, bizDateStr, batchID, houseID);
		int[] result=new int[]{0,0};
		IRowSet rs=null;
		if(ctx!=null)  {
			rs=DbUtil.executeQuery(ctx, sql);
		}else{
			rs=SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
		}
		if(rs.next()) {
			result[0]=rs.getInt("FQty")-rs.getInt("FOccurQty");
			result[1]=rs.getInt("FFemaleQty")-rs.getInt("FFemaleOccurQty");
		}
		return result;
	}

	/**
	 * 返回获取最后存栏数sql
	 * @param ctx
	 * @param companyID
	 * @param bizDateStr
	 * @param batchID
	 * @param houseID
	 * @return
	 */
	private static String getLastStockSql(Context ctx,String companyID,String bizDateStr,String batchID,String houseID)  {
		String selectFiledStr="to_char(tmain.FInDate,'yyyy-MM-dd') FDate,isnull(tmain.FBatchQty,0) FQty,isnull(tmain.FFemaleQty,0) FFemaleQty\n";
		if(StringUtils.isNotEmpty(houseID)) {
			selectFiledStr="to_char(tentry.FInData,'yyyy-MM-dd') FDate,isnull(tentry.FQty,0) FQty,isnull(tentry.FFemaleQty,0) FFemaleQty\n";
		}
		StringBuffer sql=new StringBuffer();
		sql.append(" select ").append(selectFiledStr).append(",").append("\n")
		.append(" isnull(tDaily.FQty,0) FOccurQty,isnull(tDaily.FFemaleQty,0) FFemaleOccurQty").append("\n")
		.append(" from T_FM_StockingBatch tmain ").append("\n");
		if(StringUtils.isNotEmpty(houseID)) {
			sql.append(" inner join T_FM_StockingBatchHouseEntry tentry on tentry.fparentid=tmain.fid").append("\n");
		}
//		sql.append(" inner join  T_FM_StockingBreedDaily t2 on tmain.fid=t2.CFStockingBatchID and t2.FBizDate<={d '").append(bizDateStr).append("'}").append("\n");

		sql.append(" left join (").append("\n")
		.append(" select fbatchid,fhouseID,isnull(sum(FQty),0) FQty,isnull(sum(FFemaleQty),0) FFemaleQty").append("\n")
		.append(" from (").append("\n")
		.append(" select tmain.cfstockingbatchID fbatchid,te.fhouseID,isnull(te.CFDeathQty,0)+isnull(te.CFCullQty,0)-isnull(FAdjustQty,0)+isnull(FMarkedQty,0) FQty,isnull(te.FFemaleDeathQty,0)+isnull(te.FFemaleCullQty,0)-isnull(FAdjustFemaleQty,0)+isnull(FFemaleMarketed,0) FFemaleQty").append("\n")
		.append(" from T_FM_StockingBreeddaily tmain ").append("\n")
		.append(" inner join T_FM_StockingBDAE te on te.fparentid=tmain.fid").append("\n")
		.append(" where tmain.fcompanyid='").append(companyID).append("'").append("\n")
		.append(" and CFStockingBatchID='").append(batchID).append("'").append("\n")
		.append(" and tmain.FBizDate<={d'").append(bizDateStr).append("'}").append("\n")
		.append(" and CFBaseStatus=4").append("\n");
		if(StringUtils.isNotEmpty(houseID)) {
			sql.append(" and te.fhouseID='").append(houseID).append("'").append("\n");
		}
		//转栏信息
		sql.append(" union all ").append("\n")
		.append(" select tmain.cfstockingbatchID fbatchid,te.fhouseID,(-1)*isnull(FTransQty,0) FQty,(-1)*isnull(FTransFemaleQty,0) FFemaleQty").append("\n")
		.append(" from T_FM_StockingBreeddaily tmain ").append("\n")
		.append(" inner join T_FM_StockingBDTE te on te.fparentid=tmain.fid").append("\n")
		.append(" where tmain.fcompanyid='").append(companyID).append("'").append("\n")
		.append(" and CFStockingBatchID='").append(batchID).append("'").append("\n")
		.append(" and tmain.FBizDate<={d'").append(bizDateStr).append("'}").append("\n")
		.append(" and CFBaseStatus=4").append("\n")
		.append(" and te.fhouseID='").append(houseID).append("'").append("\n")
		.append(" union all ").append("\n")
		.append(" select te.FFromStockingBatch fbatchid,te.ffromhouseID fhouseid,isnull(FTransQty,0) FQty,isnull(FTransFemaleQty,0) FFemaleQty").append("\n")
		.append(" from T_FM_StockingBreeddaily tmain ").append("\n")
		.append(" inner join T_FM_StockingBDTE te on te.fparentid=tmain.fid").append("\n")
		.append(" where tmain.fcompanyid='").append(companyID).append("'").append("\n")
		.append(" and tmain.FBizDate<={d'").append(bizDateStr).append("'}").append("\n")
		.append(" and CFBaseStatus=4").append("\n")
		.append(" and te.FFromStockingBatch='").append(batchID).append("'").append("\n")
		.append(" and te.ffromhouseID='").append(houseID).append("'").append("\n")
		.append(" ) temp group by fbatchid,fhouseid").append("\n")
		.append(" ) tDaily on (tdaily.fbatchid=tmain.fid and 1=1").append("\n");
		if(StringUtils.isNotEmpty(houseID)) {
			sql.append(" and tdaily.fhouseid=tentry.fhouseid").append("\n");
		}
		sql.append(" )").append("\n")
		.append(" where tmain.fid='").append(batchID).append("'").append("\n");
		if(StringUtils.isNotEmpty(houseID)) {
			sql.append(" and tentry.fhouseid='").append(houseID).append("'").append("\n");
		}
		return sql.toString();
	}


	/**
	 * 获取日产蛋量
	 * @param ctx
	 * @param company
	 * @param bizDateStr
	 * @param stockingBatchID
	 * @param houseID
	 * @return
	 */
	public int getStockingDayEggsQty(Context ctx,String companyID,String bizDateStr,String stockingBatchID,String houseID) throws Exception{
		StringBuffer sql=new StringBuffer();
		sql.append(" select tmain.cfstockingbatchid,tentry.fhouseID,sum(tentry.fAllQty) FQty")
		.append(" from T_FM_StockingBreedDaily tmain ")
		.append(" inner join T_FM_StockingBDEE tentry on tentry.fparentid=tmain.fid")
		.append(" where tmain.fcompanyid='").append(companyID).append("'")
		.append(" and tbill.fbizDate>={d '").append(bizDateStr).append("'}")
		.append(" and tbill.fbizDate<={d '").append(bizDateStr).append("'}")
		.append(" and tmain.cfstockingbatchid='").append(stockingBatchID).append("'");
		if(StringUtils.isNotBlank(houseID)) {
			sql.append(" and tentry.fhouseid='").append(houseID).append("'");
		}
		IRowSet rs=null;
		if(rs.next()) {
			return rs.getInt("FQty");
		}
		return 0;
	}

	public static PeriodInfo getCurrentPeriod(Context ctx,String companyID) {
		try {
			/** 设置当前期间
			 */
			StringBuffer sql=new StringBuffer();
			sql.append(" select FCurrentPeriodID")
			.append(" from T_FM_DayRateBaseSetting ")
			.append(" where fcompanyID='").append(companyID).append("'")
			.append(" ");
			IRowSet rs = null;
			IPeriod is=null;
			if(rs==null) {
				rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
				is = PeriodFactory.getRemoteInstance();
			}else {
				rs=DbUtil.executeQuery(ctx, sql.toString());
			}
			if(rs.next()) {
				if(rs.getString("FCurrentPeriodID")!=null) {
					return is.getPeriodInfo(new ObjectUuidPK(rs.getString("FCurrentPeriodID")));
				}
			}
		}catch(Exception err)  {
			err.printStackTrace();
		}
		return null;
	}
}
