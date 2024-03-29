package com.kingdee.eas.farm.rpt.app;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.ejb.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
import com.kingdee.bos.framework.ejb.EJBFactory;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.TableManagerFacadeFactory;
import com.kingdee.eas.farm.breed.BreedModelEntryCollection;
import com.kingdee.eas.farm.breed.BreedModelEntryFactory;
import com.kingdee.eas.farm.breed.BreedModelEntryInfo;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.farm.breed.business.BusinessBreedFacadeFactory;
import com.kingdee.eas.farm.breed.comm.BREED_CONSTANTS;
import com.kingdee.eas.farm.rpt.CCProductPlanRptCommonFacadeFactory;
import com.kingdee.eas.farm.rpt.ICCProductPlanRptCommonFacade;
import com.kingdee.eas.util.app.DbUtil;

import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.db.SQLUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CCProductAgeDetailRptFacadeControllerBean extends AbstractCCProductAgeDetailRptFacadeControllerBean
{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3868213285504099697L;

	private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.rpt.app.CCProductAgeDetailRptFacadeControllerBean");
    

    // 符合条件的 结果集
//  private List<CCProductPlanRptBean> beans;
    // 养殖规范
    private BreedModelInfo currentBreedModel;
    // 养殖规范明细
    private Map<Integer,BreedModelEntryInfo> currentBreedModelDetails;
    // 当前养殖规范包含的饲料信息
    private Map<Integer,MaterialInfo> currentBreedMaterials;
    
    // 过滤开始日期
    private Date filterBeginDate;
    // 过滤结束日期
    private Date filterEndDate;
    // 养殖周期
    private int breedDays;
	@Override
	protected IRowSet _getRptData(Context ctx, HashMap param)
			throws BOSException {
		// TODO Auto-generated method stub
//		return super._getRptData(ctx, param);
		// 获取过滤日期，如果没有传入 则默认当前系统时间
		filterBeginDate = (Date)param.get("filterBeginDate");
		if(filterBeginDate == null){
			filterBeginDate = new Date();
		}
		
		// 获取过滤结束日期，如果没有传入 则默认当前系统时间
		filterEndDate = (Date)param.get("filterEndDate");
		if(filterEndDate == null){
			filterEndDate = new Date();
		}
		// 获取养殖周期
		String breedDaysStr = (String)param.get("breedDays");
		if(StringUtils.isNotBlank(breedDaysStr)){
			breedDays = Integer.parseInt(breedDaysStr);
		}
		
		String showDetail = (String) param.get("showDetail");
		
		String temptableName = (String) param.get("temptableName");
		
		String containPlan = (String) param.get("containPlan");
		
		List<CCProductPlanRptBean> resultBeans = new ArrayList<CCProductPlanRptBean>();
		try{
			// 参数临时表名为空时才 进行相关操作
			if(StringUtils.isBlank(temptableName)){
				// 通用接口
				ICCProductPlanRptCommonFacade rptCommonFacade = CCProductPlanRptCommonFacadeFactory.getLocalInstance(ctx);
				
				// 获取 养殖规范
				
	//			getCurrentCCBreedModelInfo(ctx);
				System.out.println("查询养殖规范 取数开始 ：");
				System.out.println(new Date());
				currentBreedModel = rptCommonFacade.getCurrentBreedModelInfo(HenhouseType.CC);
				if(currentBreedModel != null){
					BreedModelEntryCollection entryCol = currentBreedModel.getEntrys();
					
					if(entryCol != null && entryCol.size() > 0){
						if(currentBreedModelDetails == null){
							currentBreedModelDetails = new HashMap<Integer, BreedModelEntryInfo>();
						}
						for(int i =0; i < entryCol.size(); i++){
							BreedModelEntryInfo entryInfo = entryCol.get(i);
							entryInfo = BreedModelEntryFactory.getLocalInstance(ctx).getBreedModelEntryInfo(new ObjectUuidPK(entryInfo.getId()));
							// 日龄明细存到内存中
							//currentBreedModelDetails.put(Integer.valueOf(entryInfo.getWeekDay()), entryInfo);
							MaterialInfo currMaterial = entryInfo.getMaterial();
							// 整理 饲喂 物料列表
							addToCurrBreedMaterials(ctx,currMaterial);
							
						}
					}
				}else{
					// 抛出异常
					throw new BOSException("不存在符合条件的养殖规范，请联系信息部添加");
				}
				System.out.println("查询养殖规范 取数结束 ：");
				System.out.println(new Date());
				List<CCProductPlanRptBean> storageBeans = rptCommonFacade.getRptBeanStorageInfos(param);
				// 逐个养殖场  计算获得对应的批次和计划信息
				for(CCProductPlanRptBean ccRptBean : storageBeans){
					
					List<CCProductPlanRptBean> batchRptBeans = rptCommonFacade.getStoorgBatchInfo(ccRptBean,  filterBeginDate,filterEndDate,this.getBreedDays());
					System.out.println("查询养殖批次数据开始 ：");
					System.out.println(new Date());
					// 批次ID
					List planIDs = new ArrayList<String>();
					if(batchRptBeans != null && batchRptBeans.size() > 0){
						for(int i = 0; i < batchRptBeans.size();i++){
							CCProductPlanRptBean batchRptBean = batchRptBeans.get(i);
							// 如果有关联计划则  设置计划id到列表中
							if(batchRptBean.getPlanID() != null && StringUtils.isNotBlank(batchRptBean.getPlanID())){
								planIDs.add(batchRptBean.getPlanID());
							}
							// 计算结果
							List<CCProductPlanRptBean> storageBatchResultBeans =  this.setBatchDetailInfos(ctx,batchRptBean,batchRptBean.getBatchID(),param);
//							// 统计转栏数据
//							storageBatchResultBeans = BusinessBreedFacadeFactory.getLocalInstance(ctx).getBatchHouseAllAdjustInfos(batchRptBean.getBatchID(), storageBatchResultBeans);
//							
							if(storageBatchResultBeans != null && storageBatchResultBeans.size() > 0){
								// 添加到 结果集
								resultBeans.addAll(storageBatchResultBeans);
							}
						}
					}
					
					
					System.out.println("查询养殖批次数据结束 ：");
					System.out.println(new Date());
					
					if("true".equals(containPlan)){
						System.out.println("查询养殖计划数据开始 ：");
						System.out.println(new Date());
						// 计划
						List<CCProductPlanRptBean> planRptBeans = rptCommonFacade.getStoorgPlanInfo(ccRptBean,planIDs, filterBeginDate,filterEndDate,this.getBreedDays());
						if(planRptBeans!= null && planRptBeans.size() > 0){
							for(int i = 0; i < planRptBeans.size(); i++){
								CCProductPlanRptBean planRptBean =  planRptBeans.get(i);
								// 计算
								List<CCProductPlanRptBean> storagePlanResultBeans =  this.setPlanDetailInfos(ctx,planRptBean,planRptBean.getPlanID(),param);
								if(storagePlanResultBeans != null && storagePlanResultBeans.size() > 0){
									// 添加到 结果集
									resultBeans.addAll(storagePlanResultBeans);
								}
							}
						}
					}
				}
				
				System.out.println("查询养殖计划数据结束 ：");
				System.out.println(new Date());
				// 结果插入临时表中
				temptableName = executeInsert(ctx,resultBeans);
			}
			
			
//			System.out.println("更新调拨数量开始：");
//			System.out.println(new Date());
//			// 获得 实际调拨数量到临时表中
////			updateActualQty(ctx,temptable);
//			System.out.println("更新调拨数量结束：");
//			System.out.println(new Date());
			
			System.out.println("查询结果开始：");
			System.out.println(new Date());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			String sumType = (String) param.get("sumType");	
			// 1 按日期汇总
			if("1".equals(sumType)){
				StringBuilder sumsql = new StringBuilder();
				sumsql.append(" /*dialect*/	");
//				sumsql.append(" select 	");
//				sumsql.append("                t.farmID farmID,	");
//				sumsql.append("                t.stoOrgName,	");
//				sumsql.append("                t.batchFirstIncoopDate batchFirstIncoopDate,	");
//				sumsql.append("                t.inhouseDate inhouseDate,	");
//				sumsql.append("                m.inhouseQty inhouseQty,	");// add by dai 20150724
//				sumsql.append("                t.currentDate currentDate,	");
//				sumsql.append("                t.currDateNum currDateNum,	");
//				sumsql.append("                t.currDateBreekingStock currDateBreekingStock	");
//				sumsql.append(" from ( ");
//				
				sumsql.append(" select 	");
				sumsql.append("                max(stoOrgID) farmID,	");
				sumsql.append("                stoOrgName,	");
				
				sumsql.append("                max(isPlan) isPlan,	");
				sumsql.append("                max(batchID) batchID,	");
				sumsql.append("                max(batchFirstIncoopDate) batchFirstIncoopDate,	");
				sumsql.append("                max(inhouseDate) inhouseDate,	");
				sumsql.append("                sum(inhouseQty) inhouseQty,	");// add by dai 20150724
				sumsql.append("                sum(henhouseArea) houseAreas,	");
				sumsql.append("                to_char(currentDate,'yyyy-mm-dd') currentDate,	");
				sumsql.append("                max(currDateNum) currDateNum,	");
				sumsql.append("                sum(currDateBreekingStock) currDateBreekingStock	");
//				sumsql.append("                max(TwoMaterialID) TwoMaterialID,	");
//				sumsql.append("                max(ThreeMaterialID) ThreeMaterialID,	");
//				sumsql.append("                sum(OneMaterialPredictQty) / 1000 OneMaterialPredictQty,	");
//				sumsql.append("                sum(OneMaterialActualQty) / 1000 OneMaterialActualQty,	");
//				sumsql.append("                sum(TwoMaterialPredictQty) / 1000 TwoMaterialPredictQty,	");
//				sumsql.append("                sum(TwoMaterialActualQty) / 1000 TwoMaterialActualQty,	");
//				sumsql.append("                sum(ThreeMaterialPredictQty) / 1000 ThreeMaterialPredictQty,	");
//				sumsql.append("                sum(ThreeMaterialActualQty) / 1000 ThreeMaterialActualQty	");
				sumsql.append(" from ");
				sumsql.append(temptableName);
				sumsql.append("          where 1 = 1	");
				if(filterBeginDate != null){
					sumsql.append(" and currentDate >= {ts'");
					sumsql.append(sdf.format(filterBeginDate));
					sumsql.append("'} ");
				}
				
				if(filterEndDate != null){
					sumsql.append(" and currentDate <= {ts'");
					sumsql.append(sdf.format(filterEndDate));
					sumsql.append("'} ");
				}
				sumsql.append(" group by stoOrgName,inhouseDate,currentDate ");
				sumsql.append(" order by batchFirstIncoopDate,stoOrgName,inhouseDate,currentDate,currDateNum  ");
//				// 查询入栏数量
//				sumsql.append(" left join ( select distinct	");
//				sumsql.append("                stoOrgName,	");
//			
//				sumsql.append("                max(inhouseDate) inhouseDate,	");
//				sumsql.append("                sum(inhouseQty) inhouseQty	");// add by dai 20150724
//				
//				sumsql.append(" from ");
//				sumsql.append(temptableName);
//				sumsql.append("          where 1 = 1	");
//				if(filterBeginDate != null){
//					sumsql.append(" and currentDate >= {ts'");
//					sumsql.append(sdf.format(filterBeginDate));
//					sumsql.append("'} ");
//				}
//				
//				if(filterEndDate != null){
//					sumsql.append(" and currentDate <= {ts'");
//					sumsql.append(sdf.format(filterEndDate));
//					sumsql.append("'} ");
//				}
//				sumsql.append(" group by stoOrgName,inhouseDate,currDateNum) m  on t.stoOrgName = m.stoOrgName and t.inhouseDate = m.inhouseDate ");
//				
				IRowSet rs = DbUtil.executeQuery(ctx, sumsql.toString());
				System.out.println("查询结果结束：");
				System.out.println(new Date());
				return rs;
			}else if("2".equals(sumType)){
				
			}if("3".equals(sumType)){
				
			}
			// 有数据则插入临时表返回结果
//			if(sb.length() > 10){
				IRowSet rs = DbUtil.executeQuery(ctx, "select * from "+ temptableName +" order by stoOrgNumber,batchNumber,inhouseDate ");
				System.out.println("查询结果结束：");
				System.out.println(new Date());
				return rs;
//			}
				
				
			
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		} catch (EASBizException e) {
			e.printStackTrace();
			throw new BOSException(e);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new BOSException(e);
		}
//		return null;
	}
	

	/**
	 * 批量执行 插入语句
	 * @param ctx
	 * @param beans
	 * @throws BOSException 
	 */
	private String executeInsert(Context ctx,List<CCProductPlanRptBean> beans) throws BOSException{
		System.out.println("保存数据开始：");
		System.out.println(new Date());
		// 添加到数据库中
		// 创建临时表
		String temptable = TableManagerFacadeFactory.getLocalInstance(ctx).getTableName("CCProductPlanDetailRpt");
		System.out.println("临时表名：" + temptable);
		TableManagerFacadeFactory.getLocalInstance(ctx).createTempTable(getTempTableCreateSql(temptable));
		
		
		StringBuilder sb = new StringBuilder();
		
		Connection conn = null;
		Statement statement = null;
		String sql = "";
		try{
		  conn = EJBFactory.getConnection(ctx);
		}catch (SQLException exc)
		{
		  SQLUtils.cleanup(conn);
		   throw new BOSException("CONFIG_EXCEPTION", exc);
		 }
		try{
		statement = conn.createStatement();
		
		for(int i = 0; i < beans.size(); i++){
			CCProductPlanRptBean bean = beans.get(i);
			// 插入语句添加
			sql = this.getInsertSql(temptable, bean);
			statement.execute(sql);
//			sb.append(";");
//			// 每10条执行一次
//			if(i != 0 && i / 30 == 0) {
////				DbUtil.execute(ctx, sb.substring(0,sb.length() -1).toString());
//				DbUtil.executeBatch(ctx, sb.substring(0,sb.length() -1).toString(), new ArrayList());
//				
//				sb = new StringBuilder();
//			}
//			
//			// 最后一条判断一下是否需要执行
//			if(i == (beans.size() -1)){
//				if(sb.length() > 100){
//					DbUtil.executeBatch(ctx, sb.substring(0,sb.length() -1).toString(), new ArrayList());
//					sb = new StringBuilder();
//				}
//			}
		}
		
		}
		catch (SQLException exc)
		{
		  throw new BOSException("Sql1 execute exception : " + sql, exc);
		}
		finally
		{
		  SQLUtils.cleanup(statement, conn);
		}
		
		System.out.println("保存数据结束：");
		System.out.println(new Date());
		
		
		return temptable;
	}
	


	/**
	 * 设置批次明细信息
	 * 
	 * @param ctx
	 * @param ccRptBean
	 * @param param
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	private List<CCProductPlanRptBean> setBatchDetailInfos(Context ctx,CCProductPlanRptBean stoBatchBean,String batchID,HashMap param) throws EASBizException, BOSException, SQLException, ParseException{
		List<CCProductPlanRptBean> batchDetailInfos = new ArrayList<CCProductPlanRptBean>();
		// 获取批次明细信息 
		if(StringUtils.isNotBlank(batchID)){
			// 获取 批次明细信息
			// 判断批次 入栏日期  和当前时间比较  批次是否在 当前时间内
			StringBuilder sb = new StringBuilder();
			sb.append("select t.fid billID,te.fid entryID,");
			sb.append(" te.cfhenhouseid,te.cfhenhouseName,th.fnumber henhouseNumber, th.cfarea,");
			sb.append(" tw.fid towerID,tw.fnumber towerNumber, tw.fname_l2 towerName,");
			sb.append(" te.cfinitqty,te.cfincoopdate,t.fbizdate billBizdate ");
			sb.append(" from CT_FM_BreedBatch t inner join CT_FM_BreedBatchEntry te on t.fid = te.fparentid ");
			sb.append(" inner join CT_FM_Henhouse th on te.cfhenhouseid = th.fid ");
			sb.append(" inner join T_DB_WAREHOUSE tw on th.CFTowerID = tw.fid ");
			sb.append(" where t.fid ='");
			sb.append(batchID);
			sb.append("'  order by te.cfincoopdate ");
			
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			
//				Date currEntryInDate = new Date();
			Date currEntryOutDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String currEntryDateStr = "";
//			List<String> entryHenhouseIDs = new ArrayList<String>();
			int currIncoopQty =0;
//			int  currEntryDays;
			Date batchFirstIncoopDate = null;
			// 计数器
			int i = 0;
			while(rs.next()){
				
				String billID = rs.getString("billID");
//				String entryID = rs.getString("entryID");
				String cfhenhouseid = rs.getString("cfhenhouseid");
				String henhouseNumber = rs.getString("henhouseNumber");
				String cfhenhouseName = rs.getString("cfhenhouseName");
				// 保存鸡舍信息
				stoBatchBean.setHenhouseID(cfhenhouseid);
				stoBatchBean.setHenhouseNumber(henhouseNumber);
				stoBatchBean.setHenhouseName(cfhenhouseName);
				stoBatchBean.setHenhouseArea(rs.getBigDecimal("cfarea"));
				
				// 保存料塔信息
				String towerID = rs.getString("towerID");
				String towerNumber = rs.getString("towerNumber");
				String towerName = rs.getString("towerName");
				
				stoBatchBean.setTowerID(towerID);
				stoBatchBean.setTowerNumber(towerNumber);
				stoBatchBean.setTowerName(towerName);
				
				
				int cfinitqty = rs.getInt("cfinitqty");
				// 入栏日期
				Date cfincoopdate = rs.getDate("cfincoopdate");
				// 设置 批次 首次入栏日期
				if(batchFirstIncoopDate == null){
					batchFirstIncoopDate = cfincoopdate;
				}
				if(cfincoopdate == null ){
					cfincoopdate = rs.getDate("billBizdate");
				}
				
				currEntryDateStr = sdf.format(cfincoopdate);
//				entryHenhouseIDs = new ArrayList<String>();
//				entryHenhouseIDs.add(cfhenhouseid);
				// 当前总入栏量等于当前行
				currIncoopQty = cfinitqty;
				// 获得 出栏日期
				currEntryOutDate = getBatchEntryOutcoopDate(ctx, billID, cfhenhouseid, cfincoopdate);
				Calendar cal = Calendar.getInstance();
				
				// 如果取得的出栏日期为null，则计算理论出栏时间     入栏日期加上  38天
				if(currEntryOutDate == null){
					cal.setTime(cfincoopdate);
					cal.add(Calendar.DATE, this.getBreedDays());
					
					currEntryOutDate = cal.getTime();
				}
				
				// 保存批次 入栏首日
				stoBatchBean.setBatchFirstIncoopDate(batchFirstIncoopDate);
				// 获取批次日龄明细信息
				List<CCProductPlanRptBean> batchEntryDetailBean = getBatchFodders(ctx, stoBatchBean, batchID, sdf.parse(currEntryDateStr), currEntryOutDate,currIncoopQty, cfhenhouseid);
				batchDetailInfos.addAll(batchEntryDetailBean);

				
			}

		}
		
		return batchDetailInfos;
	}

	
	/**
	 * 设置 计划进栏计算出的  计划用料信息
	 * 
	 * @param ctx
	 * @param ccRptBean
	 * @param param
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	private List<CCProductPlanRptBean> setPlanDetailInfos(Context ctx,CCProductPlanRptBean stoBatchBean,String planID,HashMap param) throws EASBizException, BOSException, SQLException, ParseException{
		List<CCProductPlanRptBean> batchDetailInfos = new ArrayList<CCProductPlanRptBean>();
		// 获取计划明细信息 
		if(StringUtils.isNotBlank(planID)){
			// 获取 计划明细信息
//			CCBreedPlanInfo planInfo = CCBreedPlanFactory.getLocalInstance(ctx).getCCBreedPlanInfo(new ObjectUuidPK(planID));
			
				// 判断 计划入栏日期  和当前时间比较  计划是否在 当前时间内
				StringBuilder sb = new StringBuilder();
				sb.append("select t.fid billID,te.fid entryID, ");
				sb.append(" te.cfhenhouseid,te.cfhenhouseName,th.fnumber henhouseNumber,th.cfarea, ");
				sb.append(" tw.fid towerID,tw.fnumber towerNumber, tw.fname_l2 towerName,");
				sb.append(" te.cfinitqty,te.cfincoopdate,t.fbizdate billBizdate ");
				sb.append(" from CT_FM_CCBreedPlan t inner join CT_FM_CCBreedPlanEntry te on t.fid = te.fparentid ");
				sb.append(" inner join CT_FM_Henhouse th on te.cfhenhouseid = th.fid ");
				sb.append(" inner join T_DB_WAREHOUSE tw on th.CFTowerID = tw.fid ");
				sb.append(" where t.fid ='");
				sb.append(planID);
				sb.append("'  order by te.cfincoopdate ");
				
				IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
				
//				Date currEntryInDate = new Date();
				Date currEntryOutDate = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				String currEntryDateStr = "";
				List<String> entryHenhouseIDs = new ArrayList<String>();
//				int currIncoopQty =0;
//				int  currEntryDays;
				// 计数器
				int i = 0;
				while(rs.next()){
					
					String billID = rs.getString("billID");
					String entryID = rs.getString("entryID");
					String cfhenhouseid = rs.getString("cfhenhouseid");
					String henhouseNumber = rs.getString("henhouseNumber");
					String cfhenhouseName = rs.getString("cfhenhouseName");
					int currIncoopQty = rs.getInt("cfinitqty");
					// 入栏日期
					Date cfincoopdate = rs.getDate("cfincoopdate");
					
					// 保存鸡舍信息
					stoBatchBean.setHenhouseID(cfhenhouseid);
					stoBatchBean.setHenhouseNumber(henhouseNumber);
					stoBatchBean.setHenhouseName(cfhenhouseName);
					stoBatchBean.setHenhouseArea(rs.getBigDecimal("cfarea"));
					
					// 保存料塔信息
					String towerID = rs.getString("towerID");
					String towerNumber = rs.getString("towerNumber");
					String towerName = rs.getString("towerName");
					
					stoBatchBean.setTowerID(towerID);
					stoBatchBean.setTowerNumber(towerNumber);
					stoBatchBean.setTowerName(towerName);
					
					if(cfincoopdate == null ){
						cfincoopdate = rs.getDate("billBizdate");
					}

					// 日龄变化处理，保存 之前数据，清空临时记录字段
				
					// 计算出理论出栏日期
					Calendar cal = Calendar.getInstance();
					
					// 如果取得的出栏日期为null，则计算理论出栏时间     入栏日期加上养殖周期
					cal.setTime(cfincoopdate);
					cal.add(Calendar.DATE, this.getBreedDays());
					currEntryOutDate = cal.getTime();
					// 获取批次日龄明细信息
					List<CCProductPlanRptBean> batchEntryDetailBeans = getPlanDetailFodders(ctx,
							stoBatchBean,
							planID, 
							cfincoopdate,
							currEntryOutDate,
							currIncoopQty
							);
//							batchEntryDetailBean.setPlan(true);
					batchDetailInfos.addAll(batchEntryDetailBeans);
				
					
					// 当前入栏日期指向 当前数据
//						currEntryInDate = cfincoopdate;
					
//					currEntryDateStr = sdf.format(cfincoopdate);
					entryHenhouseIDs = new ArrayList<String>();
					entryHenhouseIDs.add(cfhenhouseid);
					// 当前总入栏量等于当前行
//					currIncoopQty = cfinitqty;
					// 获得 出栏日期
//						currEntryOutDate = getBatchEntryOutcoopDate(ctx, billID, cfhenhouseid, cfincoopdate);
					
				
				
			}
		}
		
		return batchDetailInfos;
	}
	
	
	/**
	 * 获得饲喂标准量，根据物料 类别 分别 计算出 按饲喂标准 计算出的 数量 
	 * @param ctx
	 * @param stoBatchInfo
	 * @param batchID
	 * @param incoopDate
	 * @param outcoopDate
	 * @param incoopQty
	 * @param henhouseIDs
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 * @throws SQLException 
	 */
	private List<CCProductPlanRptBean> getPlanDetailFodders(Context ctx,
			CCProductPlanRptBean stoBatchInfo,
			String planID,
			Date incoopDate,
			Date outcoopDate,
			int incoopQty) throws EASBizException, BOSException, SQLException{
		// 计算开始日期和结束日期的时间差
		long timeLong = outcoopDate.getTime()-incoopDate.getTime();
		long days = timeLong / (1000 * 60 * 60 * 24);
		int outDays = (new Long(days)).intValue();
		
		List<CCProductPlanRptBean> result = new ArrayList<CCProductPlanRptBean>();
		
		
//		newRptBean.set
		// 根据料号 从小到大 逐个循环  计算用料量，同时 鸡只数量逐渐 减少
		// 数量
		int qty = incoopQty;
		
		// 理论饲喂天数
		int prediDays = 0;
		Date batchFirstIncoopDate = null;
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(incoopDate);
		for(int i = 1; i <= days; i++){
			// 获取 对应日龄所在日期
			cal.add(Calendar.DATE, 1);
			Date currDate = cal.getTime();
			
			CCProductPlanRptBean newRptBean = stoBatchInfo.clone();
			// 设置日期
			newRptBean.setCurrentDate(currDate);
			
			newRptBean.setPlan(true);
			newRptBean.setBatchID(planID);
			
			newRptBean.setInhouseDate(incoopDate);
			newRptBean.setInhouseQty(qty);
			newRptBean.setCurrDateNum(i);
//			newRptBean.setcu
			
			newRptBean.setInhouseDate(incoopDate);
			newRptBean.setInhouseQty(incoopQty);
			
//			newRptBean.setCurrDateNum(outDays);
			newRptBean.setDesc("");
			
			// 逐天匹配  匹配到的 根据当天分录明细设置 计算领料量 同时更新 存栏量
			BreedModelEntryInfo modelEntryInfo =  currentBreedModelDetails.get(Integer.valueOf(i));
			if(modelEntryInfo != null){
				// 物料匹配 
	//					if(currMaterial.getId().toString().equals(modelEntryMaterial.getId().toString())){
				// 批次 日死淘率
				BigDecimal dcRate = modelEntryInfo.getDailyDCRate();
			
				// 日死淘数量
				BigDecimal dayDCQty = ((new BigDecimal(qty)).multiply(dcRate)).divide(new BigDecimal(100),0,RoundingMode.HALF_UP);
				
				int dayDCQtyInt = dayDCQty.intValue();
				
				// 剩余数量
				qty = qty - dayDCQtyInt;
				// 死淘后的数量是存栏量
				newRptBean.setCurrDateBreekingStock(qty);
				prediDays ++;
				// 设置 批次 首次入栏日期
				if(batchFirstIncoopDate == null){
					batchFirstIncoopDate = incoopDate;
				}
				// 保存批次 入栏首日
				newRptBean.setBatchFirstIncoopDate(batchFirstIncoopDate);
				newRptBean.setPredictOuthouseDate(outcoopDate);
//				newRptBean.setPredictOuthouseQty(qty);
			
				// 添加到结果集中
				result.add(newRptBean);
			}
			
		}
		return result;
	}
	/**
	 * 获得饲喂标准量，根据物料 类别 分别 累计 按饲喂标准 饲喂出的 数量
	 * @param ctx
	 * @param stoBatchInfo
	 * @param batchID
	 * @param incoopDate
	 * @param outcoopDate
	 * @param incoopQty
	 * @param henhouseIDs
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 * @throws SQLException 
	 */
	private List<CCProductPlanRptBean> getBatchFodders(Context ctx,
			CCProductPlanRptBean stoBatchInfo, 
			String batchID,
			Date incoopDate,
			Date outcoopDate,
			int incoopQty,
			String henhouseID) throws EASBizException, BOSException, SQLException{
		long timeLong = outcoopDate.getTime()-incoopDate.getTime();
		long days = timeLong / (1000 * 60 * 60 * 24);
		int outDays = (new Long(days)).intValue();
		
		List<CCProductPlanRptBean> resutlRptBeans = new ArrayList<CCProductPlanRptBean>();
		
//		newRptBean.set
		// 根据料号 从小到大 逐个循环  计算用料量，同时 鸡只数量逐渐 减少
		// 数量
		int qty = incoopQty;
		
		
		// 理论饲喂天数
		int prediDays = 0;
		// 记录当前计算日期的 时间戳
		Calendar currCal = Calendar.getInstance();
		
		for(int i = 1; i <= outDays; i++){
			
			currCal.setTime(incoopDate);
			currCal.add(Calendar.DATE, i);
			
			// 获取当前循环到的日期
			Date currDate = currCal.getTime();
			
			
			
			// 获取当天的实际存栏量，从头一天日报的 存栏量获得，如果未取到则以头一天算出的 存栏量 与理论死淘比例计算获得存栏量
			qty = CCProductPlanRptCommonFacadeFactory.getLocalInstance(ctx).getCCPredateHenqty(stoBatchInfo.getStoOrgID(),batchID,currDate,"",henhouseID,qty);
			if(qty <= 0 && i <=2 ) continue;
			if(qty <= 0) break;
			// 逐天匹配  匹配到的 根据当天分录明细设置 计算领料量 同时更新 存栏量
			BreedModelEntryInfo modelEntryInfo =  currentBreedModelDetails.get(Integer.valueOf(i));
			if(modelEntryInfo != null && modelEntryInfo.getMaterial() != null){
				// 复制一个 bean
				CCProductPlanRptBean newRptBean = stoBatchInfo.clone();
				
				newRptBean.setBatchID(batchID);
			
				newRptBean.setInhouseDate(incoopDate);
				newRptBean.setInhouseQty(incoopQty);
				newRptBean.setCurrDateBreekingStock(qty);
				newRptBean.setCurrDateNum(i);
				
				newRptBean.setDesc("");
				
				// 设置计算日期
				newRptBean.setCurrentDate(currDate);
				
				// 批次 日死淘率
				BigDecimal dcRate = modelEntryInfo.getDailyDCRate();
			
				// 日死淘数量
				BigDecimal dayDCQty = ((new BigDecimal(qty)).multiply(dcRate)).divide(new BigDecimal(100),0,RoundingMode.HALF_UP);
				
				int dayDCQtyInt = dayDCQty.intValue();
				
				// 剩余数量
				qty = qty - dayDCQtyInt;
				
				prediDays ++;
				// 物料的实际饲喂量 和饲喂天数
				BigDecimal actualQty = new BigDecimal("0.00");
				int actualDays  = 0;
				
				
				// 如果日期 过滤日期范围内则添加到结果集中
				if(currDate.before(filterBeginDate) || currDate.after(filterEndDate)) continue;
				// 计算结果 存放到结果集中
				resutlRptBeans.add(newRptBean);
				
			}
		}

		return resutlRptBeans;
	}
	
	

	/**
	 * 获得指定 列表的鸡舍id的过滤条件  （'','',''）
	 * @param henhouseIDs
	 * @return
	 */
	private String getHenhouseStr(List<String> henhouseIDs){
		StringBuilder sb = new StringBuilder("(");
		for(int i = 0; i < henhouseIDs.size(); i++){
			if(i != 0) {
				sb.append(",");
			}
			sb.append("'");
			sb.append(henhouseIDs.get(i));
			sb.append("'");
		}
		
		sb.append(")");
		
		return sb.toString();
	}
	
	
	
	/**
	 * 判断指定物料是否已经包含在当前饲喂 物料中，如果不包含则添加上
	 * 顺序 按照 养殖规范 分录顺序添加
	 * @param currMaterial
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void addToCurrBreedMaterials(Context ctx,MaterialInfo currMaterial) throws EASBizException, BOSException {
		if(this.currentBreedMaterials == null) currentBreedMaterials = new HashMap<Integer, MaterialInfo>();
		int i = currentBreedMaterials.size() + 1;
		
		Set<Integer> keySet = currentBreedMaterials.keySet();
		if(keySet != null && keySet.size() > 0){
			Iterator<Integer> keyIte = keySet.iterator();
			while(keyIte.hasNext()){
				MaterialInfo matInfo = currentBreedMaterials.get(keyIte.next());
				// 如果物料已经存在 则 返回
				if(matInfo.getId().toString().equals(currMaterial.getId().toString())){
					return;
				}
			}
		}
		currMaterial = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(currMaterial.getId()));
		// 列表不存在就新增
		currentBreedMaterials.put(Integer.valueOf(i), currMaterial);
		
		
		
		
	}

	/**
	 * 获得 指定批次分录的 实际出栏日期
	 * @param ctx
	 * @param batchID
	 * @param henhouseid    鸡舍id
	 * @return
	 * @throws BOSException 
	 * @throws SQLException 
	 */
	private Date getBatchEntryOutcoopDate(Context ctx,String batchID,String henhouseid,Date incoopDate) throws BOSException, SQLException{
		StringBuilder sql = new StringBuilder("select top 1 t.fid billid,te.fid entryid, te.cfdays  ");
		sql.append(" from CT_FM_CommecialChilkenDaily t inner join CT_FM_CommecialCDAE te on t.fid = te.fparentid ");
//		sql.append("")
		sql.append(" where t.fid=? and te.cfhenhouseid=? and (te.CFBreedingStock is null or te.CFBreedingStock = 0) ");
		sql.append(" order by te.cfdays asc ");
		Object[] args = {batchID,henhouseid};
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString(),args);
		if(rs.next()){
			String billid = rs.getString("billid");
			String entryid = rs.getString("entryid");
			int days = rs.getInt("cfdays");
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(incoopDate);
			cal.add(Calendar.DATE, days);
			
			return cal.getTime();
		}
		
		return null;
	}
	
	
	/**
	 * 获得插入语句
	 * @param tempTableName
	 * @param columnCase
	 * @return
	 */
	private String getInsertSql(String tempTableName,CCProductPlanRptBean ccBean){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 StringBuffer sql = new StringBuffer();
		 
		 sql.append("insert into ");
		 sql.append(tempTableName);
		 sql.append(" values('");
		 sql.append(ccBean.getStoOrgID());
		 sql.append("','");
		 sql.append(ccBean.getStoOrgNumber());
		 sql.append("','");
		 sql.append(ccBean.getStoOrgName());
		 
		 // 是否计划数据
		 if(ccBean.isPlan()){
			 sql.append("','1','");
		 }else{
			 sql.append("','0','");
		 }
		 
		 sql.append(ccBean.getBatchID());
		 sql.append("','");
		 sql.append(ccBean.getBatchNumber());
		 sql.append("','");
		 sql.append(ccBean.getBatchName());
		 sql.append("','");
		 sql.append(ccBean.getHenhouseID());
		 sql.append("','");
		 sql.append(ccBean.getHenhouseNumber());
		 sql.append("','");
		 sql.append(ccBean.getHenhouseName());
		 sql.append("','");
		 sql.append(ccBean.getHenhouseArea().toPlainString());
		 sql.append("','");
		 sql.append(ccBean.getTowerID());
		 sql.append("','");
		 sql.append(ccBean.getTowerNumber());
		 sql.append("','");
		 sql.append(ccBean.getTowerName());
		
		 sql.append("',{ts'");
		 sql.append(sdf.format(ccBean.getInhouseDate()));
		 sql.append("'},");
		 sql.append("{ts'");
		 sql.append(sdf.format(ccBean.getBatchFirstIncoopDate()));
		 sql.append("'},");
		 sql.append(ccBean.getCurrDateNum());
		 sql.append(",");
		 sql.append(ccBean.getInhouseQty());
		 sql.append(",");
		 sql.append(ccBean.getCurrDateBreekingStock());
		 
		 
		 if(ccBean.getPredictOuthouseDate() != null){
			 sql.append(",{ts'");
			 sql.append(sdf.format(ccBean.getPredictOuthouseDate()));
			 sql.append("'},");
		 } else{
			 sql.append(",null,");
		 }
		 
		 sql.append(ccBean.getPredictOuthouseQty());
		 if(ccBean.getActualOuthouseDate() != null){
			 sql.append(",{ts'");
			 sql.append(sdf.format(ccBean.getActualOuthouseDate()));
			 sql.append("'},");
		 }else{
			 sql.append(",null,");
		 }
		 sql.append(ccBean.getActualOuthouseQty());
		 
		 // 预计日期
		 if(ccBean.getCurrentDate() != null){
			 sql.append(",{ts'");
			 sql.append(sdf.format(ccBean.getCurrentDate()));
			 sql.append("'},");
		 }else{
			 sql.append(",null,");
		 }
		 sql.append("'");
		 sql.append(ccBean.getOneMaterialID());
		 sql.append("','");
		 sql.append(ccBean.getOneMaterialNumber());
		 sql.append("','");
		 sql.append(ccBean.getOneMaterialName());
		 sql.append("',");
		 sql.append(ccBean.getOneMaterialPredictDays());
		 sql.append(",");
		 sql.append(ccBean.getOneMaterialActualDays());
		 sql.append(",");
		 sql.append(ccBean.getOneMaterialPredictQty().toPlainString());
		 sql.append(",");
		 sql.append(ccBean.getOneMaterialActualQty().toPlainString());
		 sql.append(",'");
		 
		 sql.append(ccBean.getTwoMaterialID());
		 sql.append("','");
		 sql.append(ccBean.getTwoMaterialNumber());
		 sql.append("','");
		 sql.append(ccBean.getTwoMaterialName());
		 sql.append("',");
		 sql.append(ccBean.getTwoMaterialPredictDays());
		 sql.append(",");
		 sql.append(ccBean.getTwoMaterialActualDays());
		 sql.append(",");
		 sql.append(ccBean.getTwoMaterialPredictQty());
		 sql.append(",");
		 sql.append(ccBean.getTwoMaterialActualQty());
		 sql.append(",'");
		 
		 sql.append(ccBean.getThreeMaterialID());
		 sql.append("','");
		 sql.append(ccBean.getThreeMaterialNumber());
		 sql.append("','");
		 sql.append(ccBean.getThreeMaterialName());
		 sql.append("',");
		 sql.append(ccBean.getThreeMaterialPredictDays());
		 sql.append(",");
		 sql.append(ccBean.getThreeMaterialActualDays());
		 sql.append(",");
		 sql.append(ccBean.getThreeMaterialPredictQty());
		 sql.append(",");
		 sql.append(ccBean.getThreeMaterialActualQty());
		 sql.append(",'");
		 
		 
		 sql.append(ccBean.getDesc());
		 sql.append("')");
		  
		 return sql.toString();
	}
	
	/**
	 * 临时表建表语句
	 * @return
	 */
	private String getTempTableCreateSql(String temptableName)
	{
	  StringBuffer sql = new StringBuffer();
	  sql.append("create table ");
	  sql.append(temptableName);
	  sql.append("( stoorgID varchar(44), \r\n");
	  sql.append(" stoOrgNumber varchar(44), \r\n");
	  sql.append(" stoOrgName VARCHAR(80), \r\n");
	  
	  sql.append(" isPlan varchar(2), \r\n");
	  
	  sql.append(" batchID varchar(44), \r\n");
	  sql.append(" batchNumber varchar(44), \r\n");
	  sql.append(" batchName VARCHAR(80), \r\n");
	  
	  sql.append(" henhouseID VARCHAR(44), \r\n");
	  sql.append(" henhouseNumber VARCHAR(44), \r\n");
	  sql.append(" henhouseName VARCHAR(80), \r\n");
	  sql.append(" henhouseArea DECIMAL(28,6), \r\n");
	  
	  sql.append(" towerID VARCHAR(44), \r\n");
	  sql.append(" towerNumber VARCHAR(44), \r\n");
	  sql.append(" towerName VARCHAR(80), \r\n");
	 
	  
	  sql.append(" inhouseDate DATETIME, \r\n");
	  sql.append(" batchFirstIncoopDate DATETIME, \r\n");
	  sql.append(" currDateNum int, \r\n");
	  sql.append(" inhouseQty int, \r\n");
	  sql.append(" currDateBreekingStock int, \r\n");
	  
	  sql.append(" predictOuthouseDate DATETIME, \r\n");
	  sql.append(" predictOuthouseQty int, \r\n");
	  sql.append(" actualOuthouseDate DATETIME, \r\n");
	  sql.append(" actualOuthouseQty int, \r\n");
	  
	  sql.append(" currentDate DATETIME, \r\n");
	  
	  sql.append(" OneMaterialID VARCHAR(44), \r\n");
	  sql.append(" OneMaterialNumber VARCHAR(44), \r\n");
	  sql.append(" OneMaterialName VARCHAR(80), \r\n");
	  sql.append(" OneMaterialPredictDays int, \r\n");
	  sql.append(" OneMaterialActualDays int, \r\n");
	  sql.append(" OneMaterialPredictQty DECIMAL(28,10), \r\n");
	  sql.append(" OneMaterialActualQty DECIMAL(28,10), \r\n");
	  
	  sql.append(" TwoMaterialID VARCHAR(44), \r\n");
	  sql.append(" TwoMaterialNumber VARCHAR(44), \r\n");
	  sql.append(" TwoMaterialName VARCHAR(44), \r\n");
	  sql.append(" TwoMaterialPredictDays int, \r\n");
	  sql.append(" TwoMaterialActualDays int, \r\n");
	  sql.append(" TwoMaterialPredictQty DECIMAL(28,10), \r\n");
	  sql.append(" TwoMaterialActualQty DECIMAL(28,10), \r\n");
	  
	  sql.append(" ThreeMaterialID VARCHAR(44), \r\n");
	  sql.append(" ThreeMaterialNumber VARCHAR(44), \r\n");
	  sql.append(" ThreeMaterialName VARCHAR(44), \r\n");
	  sql.append(" ThreeMaterialPredictDays int, \r\n");
	  sql.append(" ThreeMaterialActualDays int, \r\n");
	  sql.append(" ThreeMaterialPredictQty DECIMAL(28,10), \r\n");
	  sql.append(" ThreeMaterialActualQty DECIMAL(28,10), \r\n");
	  
	  sql.append(" FDESC VARCHAR(80) ");
	  sql.append(" )");
	  return sql.toString();
	}



	public Date getFilterBeginDate() {
		return filterBeginDate;
	}



	public void setFilterBeginDate(Date filterBeginDate) {
		this.filterBeginDate = filterBeginDate;
	}



	public Date getFilterEndDate() {
		return filterEndDate;
	}



	public void setFilterEndDate(Date filterEndDate) {
		this.filterEndDate = filterEndDate;
	}



	public void setBreedDays(int breedDays) {
		this.breedDays = breedDays;
	}



	public int getBreedDays() {
		return breedDays;
	}
	
}