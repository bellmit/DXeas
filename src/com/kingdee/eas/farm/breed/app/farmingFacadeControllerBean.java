package com.kingdee.eas.farm.breed.app;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.business.CCBreedPlanEntryFactory;
import com.kingdee.eas.farm.breed.business.CCBreedPlanEntryInfo;
import com.kingdee.eas.farm.breed.business.ICCBreedPlanEntry;
import com.kingdee.eas.farm.breed.layegg.LayEggPlanEntryFactory;
import com.kingdee.eas.farm.breed.layegg.LayEggPlanEntryInfo;
import com.kingdee.eas.farm.food.SlaughterPlanEntryFactory;
import com.kingdee.eas.farm.food.SlaughterPlanEntryInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;




public class farmingFacadeControllerBean extends AbstractfarmingFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.breed.app.farmingFacadeControllerBean");


	/**
	 * 从入栏计划获取屠宰计划的相关信息
	 */
	@Override
	protected java.util.ArrayList<CCBreedPlanEntryInfo> _getSlaughterPlan(Context ctx, IObjectValue storageUnit,
			IObjectValue period) throws BOSException {
		// TODO Auto-generated method stub
		java.util.ArrayList<CCBreedPlanEntryInfo> list=new java.util.ArrayList<CCBreedPlanEntryInfo>();
		PeriodInfo periodInfo = (PeriodInfo)period;
		Date beginDate = periodInfo.getBeginDate();
		Date endDate = periodInfo.getEndDate();
		StringBuffer sb=new StringBuffer();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		sb.append("select t2.fid,t2.fslaughterDate from CT_FM_CCBreedPlan t1");
		sb.append(" inner join  CT_FM_CCBreedPlanEntry t2 on t2.fparentid=t1.fid");
		sb.append(" where t1.cfBaseStatus=4 and t2.fslaughterDate between {ts '");
		sb.append(beginDate).append("'} and {ts '").append(sdf.format(endDate)).append("'}");
		sb.append(" order by t2.fslaughterDate");
		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb.toString()).executeSQL();
		try {
			String id="";
			ICCBreedPlanEntry ccBreedPlanEntryFacadeInstance = CCBreedPlanEntryFactory.getLocalInstance(ctx);
			while(rs.next())
			{
				id=rs.getString("fid");
				CCBreedPlanEntryInfo info = ccBreedPlanEntryFacadeInstance.getCCBreedPlanEntryInfo(new ObjectUuidPK(id));
				list.add(info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 *获得养殖计划
	 *主方法
	 */
	@Override
	protected java.util.ArrayList _getBreedPlan(Context ctx, Date date,
			IObjectValue period, IObjectValue stoOrgUnit, String planType)
	throws BOSException {
		// TODO Auto-generated method stub

		//展板首页显示近几日计划
		if(date!=null&&!planType.equals(""))
			try {
				return getBreedPlanByDate(ctx,date,planType);
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//查询某个期间的计划
			else if(period!=null&&stoOrgUnit!=null&&!planType.equals(""))
				return getBreedPlanByDateByPeriod(ctx,period,stoOrgUnit,planType);//获得某个会计期间的养殖计划


		return null;
	}




	/*
	 * 获得某个期间的养殖计划
	 * @param    period:期间
	 * @param    stoOrgUnit:库存组织
	 * @param    planType:计划类型
	 */
	private java.util.ArrayList getBreedPlanByDateByPeriod(Context ctx,IObjectValue period,
			IObjectValue stoOrgUnit, String planType) {


		StringBuffer sb=getStringBufferByPeriodAndStoOrgUnit(period,stoOrgUnit,planType);
		if(sb!=null){
			try {
				IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
				if(rs.size()==0)
					return null;
				else
					return getBreedPlan(ctx,planType,rs);
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		return null;
		// TODO Auto-generated method stub


	}



	/**
	 * 某的某个期间某个场的计划2.1：获得StringBuffer查询语句
	 * @param period                              会计期间
	 * @param stoOrgUnit                          库存组织
	 * @param planType                            计划类型
	 * @return                               StringBuffer
	 */
	private StringBuffer getStringBufferByPeriodAndStoOrgUnit(
			IObjectValue period, IObjectValue stoOrgUnit, String planType) {
		// TODO Auto-generated method stub
		//获得期间
		PeriodInfo periodInfo=null;
		if(period!=null)
			periodInfo=(PeriodInfo)period;

		//		//获得期间的开始日期和结束日期
		//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//		String beginDate = sdf.format(periodInfo.getBeginDate());
		//		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		//		String endDate = df.format(periodInfo.getEndDate());

		//获得库存组织
		StorageOrgUnitInfo stoOrgUnitInfo=null;
		if(stoOrgUnit!=null)
			stoOrgUnitInfo=(StorageOrgUnitInfo)stoOrgUnit;


		return getStringBuffer(null, null, planType,stoOrgUnitInfo,periodInfo);
	}




	/*
	 * 获得近几日的养殖计划
	 * @param    date:日期
	 * @param    planType:计划类型
	 * 方法                1.1
	 */
	private java.util.ArrayList getBreedPlanByDate(Context ctx,Date date, String planType) throws BOSException, EASBizException, SQLException {
		// TODO Auto-generated method stub


		if(date==null||planType.equals(""))
			return null;


		//获得时间段
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		int days=5;
		if(planType.equals("layEggPlan"))
			days=3;

		//获得查询语句
		Date endDate = new Date(date.getTime()+days*24*3600*1000);
		StringBuffer sb=new StringBuffer();
		sb=getStringBuffer(sdf.format(date),sdf.format(endDate),planType,null,null);
		if(sb==null)
			return null;

		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		if(rs.size()==0)
			return null;

		return getBreedPlan(ctx,planType,rs);

	}

	/**
	 * 根据查询到的结果获得未来几天的计划
	 * @param ctx       当前环境变量
	 * @param planType  计划类型  
	 * @param rs        查询到的结果集
	 * @return          ArrayList存储结果
	 * @throws EASBizException
	 * @throws BOSException
	 * @throws SQLException
	 */
	private java.util.ArrayList getBreedPlan(Context ctx, String planType,
			IRowSet rs) throws EASBizException, BOSException, SQLException {
		// TODO Auto-generated method stub

		//产蛋
		if(planType.equals("layEggPlan")){
			java.util.ArrayList<LayEggPlanEntryInfo> infos=new java.util.ArrayList<LayEggPlanEntryInfo>();
			while(rs.next()){
				LayEggPlanEntryInfo entryInfo=LayEggPlanEntryFactory.getLocalInstance(ctx).getLayEggPlanEntryInfo(new ObjectUuidPK(rs.getString("fid")));
				infos.add(entryInfo);
			}
			return infos;
		}

//		//孵化
//		if(planType.equals("hatchPlan")){
//			java.util.ArrayList<BatchPlanEntryInfo> infos=new java.util.ArrayList<BatchPlanEntryInfo>();
//			while(rs.next()){
//				BatchPlanEntryInfo entryInfo = BatchPlanEntryFactory.getLocalInstance(ctx).getBatchPlanEntryInfo(new ObjectUuidPK(rs.getString("fid")));
//				infos.add(entryInfo);
//			}
//			return infos;
//		}

		//入栏
		if(planType.equals("ccBreedPlan")){
			java.util.ArrayList<CCBreedPlanEntryInfo> infos = new java.util.ArrayList<CCBreedPlanEntryInfo>();
			while(rs.next()){
				CCBreedPlanEntryInfo info = CCBreedPlanEntryFactory.getLocalInstance(ctx).getCCBreedPlanEntryInfo(new ObjectUuidPK(rs.getString("fid")));
				infos.add(info);
			}		
			return infos;
		}

		//宰杀
		if(planType.equals("slaughterPlan")){
			java.util.ArrayList<SlaughterPlanEntryInfo> infos = new java.util.ArrayList<SlaughterPlanEntryInfo>();
			while(rs.next()){
				SlaughterPlanEntryInfo entryInfo = SlaughterPlanEntryFactory.getLocalInstance(ctx).getSlaughterPlanEntryInfo(new ObjectUuidPK(rs.getString("fid")));
				infos.add(entryInfo);
			}
			return infos;
		}
		return null;
	}
	/**
	 * 查询两个日期间的信息
	 * @param beginDate   起始日期
	 * @param endDate     结束日期
	 * @param type        计划类别：0产蛋,1孵化,2入栏,3屠宰
	 */
	protected StringBuffer getStringBuffer(String beginDate,String endDate,String type,StorageOrgUnitInfo stoOrgUnit,PeriodInfo periodInfo){

		StringBuffer sb=new StringBuffer();


		//产蛋
		if(type.equals("layEggPlan")){
			sb.append("select t1.fid,t1.CFPlanDate from CT_FM_LayEggPlanEntry t1 ");
			sb.append(" inner join CT_FM_LayEggPlan t2 on t2.fid=t1.fparentid and t2.CFBaseStatus=4");

			if(periodInfo==null){
				sb.append(" where t1.CFPlanDate between {ts '").append(beginDate).append("'}");
				sb.append(" and {ts '").append(endDate).append("'}");
			}
			else if(stoOrgUnit!=null){
				sb.append(" where t2.CFFarmID='").append(stoOrgUnit.getId().toString()).append("'");
				sb.append(" and t2.CFPeriodID='").append(periodInfo.getId().toString()).append("'");
			}


			sb.append(" order by t1.CFPlanDate");
		}
		//孵化
		else if(type.equals("hatchPlan")){
			sb.append("select t1.fid,t1.cfplandate from CT_FM_BatchPlanEntry t1 ");
			sb.append(" inner join CT_FM_BatchPlan t2 on t2.fid=t1.fparentid and t2.CFBaseStatus=4");

			if(periodInfo==null){
				sb.append(" where t1.CFPlanDate between {ts '").append(beginDate).append("'}");
				sb.append(" and {ts '").append(endDate).append("'}");
			}

			else if(stoOrgUnit!=null){
				sb.append(" where t2.CFHatchFactoryID='").append(stoOrgUnit.getId().toString()).append("'");
				sb.append(" and t2.CFPeriodID='").append(periodInfo.getId().toString()).append("'");
			}

			sb.append(" order by t1.cfplandate");
		}
		//入栏
		else if(type.equals("ccBreedPlan")){
			sb.append("select * from CT_FM_CCBreedPlanEntry t1");
			sb.append(" inner join CT_FM_CCBreedPlan t2 on t1.fparentid=t2.fid and t2.CFBaseStatus=4");

			if(periodInfo==null){
				sb.append(" where t1.CFIncoopDate between {ts '").append(beginDate).append("'}");
				sb.append(" and {ts '").append(endDate).append("'}");
			}

			else if(stoOrgUnit!=null){
				sb.append(" where t2.CFStoOrgID='").append(stoOrgUnit.getId().toString()).append("'");
				sb.append(" and t2.FPeriodID='").append(periodInfo.getId().toString()).append("'");
			}
		}
		//屠宰
		else if(type.equals("slaughterPlan")){
			sb.append("select t1.fid from T_FM_SlaughterPlanEntry t1 ");
			sb.append(" inner join T_FM_SlaughterPlan t2 on t2.fid=t1.fparentid and t2.FBillStatus=4");
			if(periodInfo==null){
				sb.append(" where t1.FPkDate between {ts '").append(beginDate).append("'}");
				sb.append(" and {ts '").append(endDate).append("'}");
			}

			else if(stoOrgUnit!=null){
				sb.append(" where t2.FStoOrgID='").append(stoOrgUnit.getId().toString()).append("'");
				sb.append(" and t2.FPeriodID='").append(periodInfo.getId().toString()).append("'");
			}
		}
		return sb;		
	}
}