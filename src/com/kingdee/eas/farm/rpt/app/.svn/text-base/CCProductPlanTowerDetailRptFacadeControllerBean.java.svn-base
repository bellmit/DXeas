package com.kingdee.eas.farm.rpt.app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.framework.ejb.EJBFactory;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.TableManagerFacadeFactory;
import com.kingdee.eas.farm.breed.BreedBatchFactory;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.farm.breed.BreedModelEntryCollection;
import com.kingdee.eas.farm.breed.BreedModelEntryFactory;
import com.kingdee.eas.farm.breed.BreedModelEntryInfo;
import com.kingdee.eas.farm.breed.BreedModelFactory;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.farm.breed.business.CCBreedPlanFactory;
import com.kingdee.eas.farm.breed.business.CCBreedPlanInfo;
import com.kingdee.eas.farm.breed.comm.BREED_CONSTANTS;
import com.kingdee.eas.farm.rpt.CCProductPlanRptCommonFacadeFactory;
import com.kingdee.eas.farm.rpt.ICCProductPlanRptCommonFacade;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.db.SQLUtils;

/**
 * 商品鸡送料计划汇总、明细查询后台数据源
 * @author USER
 *
 */
public class CCProductPlanTowerDetailRptFacadeControllerBean extends AbstractCCProductPlanTowerDetailRptFacadeControllerBean
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5154648737070480324L;

	private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.rpt.app.CCProductPlanTowerDetailRptFacadeControllerBean");
    
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
							addToCurrBreedMaterials(currMaterial);
							
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
							// 如果有关联批次则  设置批次id到列表中
							if(batchRptBean.getPlanID() != null && StringUtils.isNotBlank(batchRptBean.getPlanID())){
								planIDs.add(batchRptBean.getPlanID());
							}
							// 如果是批次的话调用批次逻辑
							List<CCProductPlanRptBean> storageBatchResultBeans =  this.setBatchDetailInfos(ctx,batchRptBean,batchRptBean.getBatchID(),param);
							if(storageBatchResultBeans != null && storageBatchResultBeans.size() > 0){
								// 添加到 结果集
								resultBeans.addAll(storageBatchResultBeans);
							}
						}
					}
					System.out.println("查询养殖批次数据结束 ：");
					System.out.println(new Date());
					System.out.println("查询养殖计划数据开始 ：");
					System.out.println(new Date());
					// 计划
					List<CCProductPlanRptBean> planRptBeans = rptCommonFacade.getStoorgPlanInfo(ccRptBean,planIDs, filterBeginDate,filterEndDate,this.getBreedDays());
					if(planRptBeans!= null && planRptBeans.size() > 0){
						for(int i = 0; i < planRptBeans.size(); i++){
							CCProductPlanRptBean planRptBean =  planRptBeans.get(i);
							// 实际计划按照计划计算
							List<CCProductPlanRptBean> storagePlanResultBeans =  this.setPlanDetailInfos(ctx,planRptBean,planRptBean.getPlanID(),param);
							if(storagePlanResultBeans != null && storagePlanResultBeans.size() > 0){
								// 添加到 结果集
								resultBeans.addAll(storagePlanResultBeans);
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
			// 1 按日期 料号汇总
			if("1".equals(sumType)){
				StringBuilder sumsql = new StringBuilder();
				

				sumsql.append(" /*dialect*/	");
				sumsql.append(" select 	");
				sumsql.append(" max(farmID) farmID,	");
				sumsql.append("        stoOrgName,	");
//				sumsql.append("        max(batchName) batchName,	");
				sumsql.append("        '' batchName,	");
//				sumsql.append("        towerName,	");
				sumsql.append("        currentDate,	");
				sumsql.append("        max(towerid) towerID,	'");
				sumsql.append(temptableName);
				sumsql.append("' temptableName,");
				sumsql.append("        max(ZeroMaterialID) ZeroMaterialID,	");
				sumsql.append("        max(OneMaterialID) OneMaterialID,	");
				sumsql.append("        max(TwoMaterialID) TwoMaterialID,	");
				sumsql.append("        max(ThreeMaterialID) ThreeMaterialID,	");
				sumsql.append("        sum(ZeroMaterialPredictQty)  ZeroMaterialPredictQty,	");
				sumsql.append("        sum(ZeroMaterialActualQty)  ZeroMaterialActualQty,	");
				sumsql.append("        sum(OneMaterialPredictQty)  OneMaterialPredictQty,	");
				sumsql.append("        sum(OneMaterialActualQty)  OneMaterialActualQty,	");
				sumsql.append("        sum(TwoMaterialPredictQty) TwoMaterialPredictQty,	");
				sumsql.append("        sum(TwoMaterialActualQty)  TwoMaterialActualQty,	");
				sumsql.append("        sum(ThreeMaterialPredictQty) ThreeMaterialPredictQty,	");
				sumsql.append("        sum(ThreeMaterialActualQty) ThreeMaterialActualQty	");
				sumsql.append("        from 	");
				sumsql.append("  (	");
				sumsql.append(" select max(stoOrgID) farmID,	");
				sumsql.append("        stoOrgName,	");
				sumsql.append("        batchName,	");
				sumsql.append("        towerName,	");
				sumsql.append("        to_char(currentDate, 'yyyy-mm-dd') currentDate,	");
				sumsql.append("        max(towerid) towerID,	");
				sumsql.append("        max(ZeroMaterialID) ZeroMaterialID,	");
				sumsql.append("        max(OneMaterialID) OneMaterialID,	");
				sumsql.append("        max(TwoMaterialID) TwoMaterialID,	");
				sumsql.append("        max(ThreeMaterialID) ThreeMaterialID,	");
				sumsql.append("        sum(ZeroMaterialPredictQty) / 1000 ZeroMaterialPredictQty,	");
				sumsql.append("        sum(ZeroMaterialActualQty) / 1000 ZeroMaterialActualQty,	");
				sumsql.append("        sum(OneMaterialPredictQty) / 1000 OneMaterialPredictQty,	");
				sumsql.append("        sum(OneMaterialActualQty) / 1000 OneMaterialActualQty,	");
				sumsql.append("        sum(TwoMaterialPredictQty) / 1000 TwoMaterialPredictQty,	");
				sumsql.append("        sum(TwoMaterialActualQty) / 1000 TwoMaterialActualQty,	");
				sumsql.append("        sum(ThreeMaterialPredictQty) / 1000 ThreeMaterialPredictQty,	");
				sumsql.append("        sum(ThreeMaterialActualQty) / 1000 ThreeMaterialActualQty	");
				sumsql.append("   from ");
				sumsql.append(temptableName);
				sumsql.append("          where 1 = 1	");
				if(filterBeginDate != null){
					sumsql.append(" and currentDate >= to_date('");
					sumsql.append(sdf.format(filterBeginDate));
					sumsql.append("','yyyy-mm-dd') ");
				}
				
				if(filterEndDate != null){
					sumsql.append(" and to_date(to_char(currentDate,'yyyy-mm-dd'),'yyyy-mm-dd')<= to_date('");
					sumsql.append(sdf.format(filterEndDate));
					sumsql.append("','yyyy-mm-dd') ");
				}
//				
//				sumsql.append("  where 1 = 1	");
//				sumsql.append("    and currentDate >=	");
//				sumsql.append("        to_date('2015-09-01',	");
//				sumsql.append("                'yyyy-mm-dd')	");
//				sumsql.append("    and to_date(to_char(currentDate,	");
//				sumsql.append("                        'yyyy-mm-dd'),	");
//				sumsql.append("                'yyyy-mm-dd') <=	");
//				sumsql.append("        to_date('2015-09-30',	");
//				sumsql.append("                'yyyy-mm-dd')	");
				sumsql.append("  group by stoOrgName,	");
				sumsql.append("           batchName,	");
				sumsql.append("           towerName,	");
				sumsql.append("           currentDate	");
				sumsql.append(" 	");
				sumsql.append("                                                           	");
				sumsql.append(" union all 	");
				sumsql.append(" 	");
				sumsql.append(" select 	");
				sumsql.append("     t.freceiptstorageorgunitid   farmID,	");
				sumsql.append("    max(tos.fname_l2) stoOrgName,	");
				sumsql.append("    '' batchName,	");
				sumsql.append("    max(tw.fname_l2) towerName,	");
				sumsql.append("    to_char(t.fbizdate, 'yyyy-mm-dd') currentDate,	");
				sumsql.append("    tw.fid towerID,	");
				sumsql.append("    '' ZeroMaterialID,	");
				sumsql.append("    '' OneMaterialID,	");
				sumsql.append("    '' TwoMaterialID,	");
				sumsql.append("   '' ThreeMaterialID,	");
				sumsql.append("    0 ZeroMaterialPredictQty,	");
				sumsql.append("    sum (case when tm1.fname_l2  like   '%RJ-00%'	");
				sumsql.append("   then tsbe1.fbaseqty	");
				sumsql.append("     else 0 end) / 1000 ZeroMaterialActualQty,	");
				sumsql.append("    0 OneMaterialPredictQty,	");
				sumsql.append("    sum (case when tm1.fname_l2  like   '%RJ-01%'	");
				sumsql.append("   then tsbe1.fbaseqty	");
				sumsql.append("     else 0 end) / 1000 OneMaterialActualQty,	");
				sumsql.append("    0 TwoMaterialPredictQty,	");
				sumsql.append("    sum (case when  tm1.fname_l2  like   '%RJ-02%'	");
				sumsql.append("   then tsbe1.fbaseqty	");
				sumsql.append("     else 0 end) / 1000 TwoMaterialActualQty,	");
				sumsql.append("    0 ThreeMaterialPredictQty,	");
				sumsql.append("    sum (case when  tm1.fname_l2  like   '%RJ-03%'	");
				sumsql.append("   then tsbe1.fbaseqty	");
				sumsql.append("     else 0 end) / 1000 ThreeMaterialActualQty	");
				sumsql.append(" 	");
				sumsql.append(" from T_IM_StockTransferBill t 	");
				sumsql.append(" inner join T_IM_StockTransferBillEntry tsbe1 on t.fid = tsbe1.fparentid	");
				sumsql.append(" inner join t_bd_material tm1 on tsbe1.fmaterialid = tm1.fid	");
				sumsql.append(" inner join t_org_storage tos on t.freceiptstorageorgunitid = tos.fid 	");
				sumsql.append(" inner join t_db_warehouse tw on tsbe1.freceiptwarehouseid = tw.fid	");
//				sumsql.append(" inner join ( select distinct STOORGID,BATCHNAME from  ");
//				sumsql.append(temptableName);
//				sumsql.append(" ) tb on tb.STOORGID = tos.fid	");
				sumsql.append(" where  tw.fname_l2 like '%料塔%'	 ");
				sumsql.append(" and tos.fid in ( select distinct STOORGID from ");
				sumsql.append(temptableName);
				sumsql.append(" )  ");
				if(filterBeginDate != null){
					sumsql.append(" and t.fbizdate >= to_date('");
					sumsql.append(sdf.format(filterBeginDate));
					sumsql.append("','yyyy-mm-dd') ");
				}
				
				if(filterEndDate != null){
					sumsql.append(" and to_date(to_char(t.fbizdate,'yyyy-mm-dd'),'yyyy-mm-dd')<= to_date('");
					sumsql.append(sdf.format(filterEndDate));
					sumsql.append("','yyyy-mm-dd') ");
				}
				sumsql.append(" group by t.freceiptstorageorgunitid,tw.fid,t.fbizdate	");
				sumsql.append(" union all	");
				sumsql.append(" select 	");
				sumsql.append(" t.fissuestorageorgunitid farmID,	");
				sumsql.append("    max(tos.fname_l2) stoOrgName,	");
				sumsql.append("    '' batchName,	");
				sumsql.append("    max(tw.fname_l2) towerName,	");
				sumsql.append("    to_char(t.fbizdate, 'yyyy-mm-dd') currentDate,	");
				sumsql.append("    tw.fid towerID,	");
				sumsql.append("    '' ZeroMaterialID,	");
				sumsql.append("    '' OneMaterialID,	");
				sumsql.append("    '' TwoMaterialID,	");
				sumsql.append("   '' ThreeMaterialID,	");
				sumsql.append("    0 ZeroMaterialPredictQty,	");
				sumsql.append("    sum (case when tm1.fname_l2  like   '%RJ-00%'	");
				sumsql.append("   then -1*tsbe1.fbaseqty	");
				sumsql.append("     else 0 end) / 1000 ZeroMaterialActualQty,	");
				sumsql.append("    0 OneMaterialPredictQty,	");
				sumsql.append("    sum (case when tm1.fname_l2  like   '%RJ-01%'	");
				sumsql.append("   then -1*tsbe1.fbaseqty	");
				sumsql.append("     else 0 end) / 1000 OneMaterialActualQty,	");
				sumsql.append("    0 TwoMaterialPredictQty,	");
				sumsql.append("    sum (case when  tm1.fname_l2  like   '%RJ-02%'	");
				sumsql.append("   then -1*tsbe1.fbaseqty	");
				sumsql.append("     else 0 end) / 1000 TwoMaterialActualQty,	");
				sumsql.append("    0 ThreeMaterialPredictQty,	");
				sumsql.append("    sum (case when  tm1.fname_l2  like   '%RJ-03%'	");
				sumsql.append("   then -1*tsbe1.fbaseqty	");
				sumsql.append("     else 0 end) / 1000 ThreeMaterialActualQty	");
				sumsql.append(" 	");
				sumsql.append(" from T_IM_StockTransferBill t 	");
				sumsql.append(" inner join T_IM_StockTransferBillEntry tsbe1 on t.fid = tsbe1.fparentid	");
				sumsql.append(" inner join t_bd_material tm1 on tsbe1.fmaterialid = tm1.fid	");
				sumsql.append(" inner join t_org_storage tos on t.fissuestorageorgunitid = tos.fid 	");
				sumsql.append(" inner join t_db_warehouse tw on tsbe1.fissuewarehouseid = tw.fid	");
//				sumsql.append(" inner join ( select distinct STOORGID,BATCHNAME from  ");
//				sumsql.append(temptableName);
//				sumsql.append(" ) tb on tb.STOORGID = tos.fid	");
				sumsql.append(" where  tw.fname_l2 like '%料塔%'	");
				sumsql.append(" and tos.fid in ( select distinct STOORGID from ");
				sumsql.append(temptableName);
				sumsql.append(" )  ");
				if(filterBeginDate != null){
					sumsql.append(" and t.fbizdate >= to_date('");
					sumsql.append(sdf.format(filterBeginDate));
					sumsql.append("','yyyy-mm-dd') ");
				}
				
				if(filterEndDate != null){
					sumsql.append(" and to_date(to_char(t.fbizdate,'yyyy-mm-dd'),'yyyy-mm-dd')<= to_date('");
					sumsql.append(sdf.format(filterEndDate));
					sumsql.append("','yyyy-mm-dd') ");
				}
				sumsql.append(" group by t.fissuestorageorgunitid,tw.fid,t.fbizdate	");
				sumsql.append(" )  group by stoOrgName,	");
				sumsql.append("           	");
				sumsql.append("           currentDate	");
				sumsql.append("  order by stoOrgName,	");
				sumsql.append("           	");
				sumsql.append("           currentDate	");
//				sumsql.append(" /*dialect*/	");
//				sumsql.append(" select 	");
//				sumsql.append("   max(tmmmmmm.farmID) farmID,tmmmmmm.stoOrgName, ");
//				sumsql.append(" tmmmmmm.currentDate currentDate,	'");
//				sumsql.append(temptableName);
//				sumsql.append("' temptableName,");
//				sumsql.append("   max(tmmmmmm.OneMaterialPredictQty) OneMaterialPredictQty,	");
//				sumsql.append("   max(tmmmmmm.OneMaterialActualQty) OneMaterialActualQty,	");
//				sumsql.append("   max(tmmmmmm.TwoMaterialPredictQty) TwoMaterialPredictQty,	");
//				sumsql.append("   max(tmmmmmm.TwoMaterialActualQty) TwoMaterialActualQty,	");
//				sumsql.append("   max(tmmmmmm.ThreeMaterialPredictQty) ThreeMaterialPredictQty,	");
//				sumsql.append("   max(tmmmmmm.ThreeMaterialActualQty)-sum(decode(tsbem6.fid,null,0,tsbe6.fbaseqty))/1000  ThreeMaterialActualQty	");
//				
//				sumsql.append(" from (select 	");
//				sumsql.append("   max(tmmmmm.farmID) farmID,tmmmmm.stoOrgName, tmmmmm.batchName, tmmmmm.towerName,");
//				sumsql.append(" tmmmmm.currentDate currentDate, max(tmmmmm.towerid) towerID,	'");
//				sumsql.append(temptableName);
//				sumsql.append("' temptableName,");
//				sumsql.append("   max(tmmmmm.OneMaterialPredictQty) OneMaterialPredictQty,	");
//				sumsql.append("   max(tmmmmm.OneMaterialActualQty) OneMaterialActualQty,	");
//				sumsql.append("   max(tmmmmm.TwoMaterialPredictQty) TwoMaterialPredictQty,	");
//				sumsql.append("   max(tmmmmm.TwoMaterialActualQty)-sum(decode(tsbem5.fid,null,0,tsbe5.fbaseqty))/1000  TwoMaterialActualQty,	");
//				sumsql.append("   max(tmmmmm.ThreeMaterialPredictQty) ThreeMaterialPredictQty,	");
//				sumsql.append("   max(tmmmmm.ThreeMaterialActualQty) ThreeMaterialActualQty	");
//				
//				sumsql.append(" from ( select 	");
//				sumsql.append("   max(tmmmm.farmID) farmID,tmmmm.stoOrgName, tmmmm.batchName, tmmmm.towerName,");
//				sumsql.append(" tmmmm.currentDate currentDate, max(tmmmm.towerid) towerID,	'");
//				sumsql.append(temptableName);
//				sumsql.append("' temptableName,");
//				sumsql.append("   max(tmmmm.OneMaterialPredictQty) OneMaterialPredictQty,	");
//				sumsql.append("   max(tmmmm.OneMaterialActualQty)-sum(decode(tsbem4.fid,null,0,tsbe4.fbaseqty))/1000 OneMaterialActualQty,	");
//				sumsql.append("   max(tmmmm.TwoMaterialPredictQty) TwoMaterialPredictQty,	");
//				sumsql.append("   max(tmmmm.TwoMaterialActualQty) TwoMaterialActualQty,	");
//				sumsql.append("   max(tmmmm.ThreeMaterialPredictQty) ThreeMaterialPredictQty,	");
//				sumsql.append("   max(tmmmm.ThreeMaterialActualQty) ThreeMaterialActualQty	");
////				sumsql.append("   sum(tsbe3.fbaseqty)/1000 ThreeMaterialActualQty	");
//				sumsql.append(" 	");
//				
//				sumsql.append(" from( select 	");
//				sumsql.append("   max(tmmm.farmID) farmID,tmmm.stoOrgName, tmmm.batchName, tmmm.towerName,");
//				sumsql.append(" to_char(tmmm.currentDate,'yyyy-mm-dd') currentDate, max(tmmm.towerid) towerID,	'");
//				sumsql.append(temptableName);
//				sumsql.append("' temptableName,");
//				sumsql.append("   max(tmmm.OneMaterialPredictQty) OneMaterialPredictQty,	");
//				sumsql.append("   max(tmmm.OneMaterialActualQty) OneMaterialActualQty,	");
//				sumsql.append("   max(tmmm.TwoMaterialPredictQty) TwoMaterialPredictQty,	");
//				sumsql.append("   max(tmmm.TwoMaterialActualQty) TwoMaterialActualQty,	");
//				sumsql.append("   max(tmmm.ThreeMaterialPredictQty) ThreeMaterialPredictQty,	");
//				sumsql.append("   sum(decode(tsbem3.fid,null,0,tsbe3.fbaseqty))/1000 ThreeMaterialActualQty	");
////				sumsql.append("   sum(tsbe3.fbaseqty)/1000 ThreeMaterialActualQty	");
//				sumsql.append(" 	");
//				sumsql.append(" from (select 	");
//				sumsql.append("  max(tmm.farmID) farmID,tmm.stoOrgName, tmm.batchName, tmm.towerName, tmm.currentDate, max(tmm.towerid) towerID,	");
//				sumsql.append("   max(tmm.OneMaterialPredictQty) OneMaterialPredictQty,	");
//				sumsql.append("   max(tmm.OneMaterialActualQty) OneMaterialActualQty,	");
//				sumsql.append("   max(tmm.TwoMaterialPredictQty) TwoMaterialPredictQty,	");
//				sumsql.append("   sum(decode(tsbem2.fid,null,0,tsbe2.fbaseqty))/1000 TwoMaterialActualQty,	");
////				sumsql.append("   sum(tsbe2.fbaseqty)/1000 TwoMaterialActualQty,	");
//				sumsql.append("   max(tmm.TwoMaterialID) TwoMaterialID,	");
//				sumsql.append("   max(tmm.ThreeMaterialID) ThreeMaterialID,	");
//				sumsql.append(" 	");
//				sumsql.append("   max(tmm.ThreeMaterialPredictQty) ThreeMaterialPredictQty	");
//				sumsql.append(" from (	");
//				sumsql.append(" select max(tm.farmID) farmID,tm.stoOrgName, tm.batchName, tm.towerName, tm.currentDate, max(tm.towerid) towerID,	");
//				sumsql.append("   max(tm.OneMaterialPredictQty) OneMaterialPredictQty,	");
//				sumsql.append("   sum(decode(tsbem1.fid,null,0,tsbe1.fbaseqty))/1000 OneMaterialActualQty,	");
////				sumsql.append("   sum(tsbe1.fbaseqty)/1000 OneMaterialActualQty,	");
//				sumsql.append("   max(tm.TwoMaterialID) TwoMaterialID,	");
//				sumsql.append("   max(tm.ThreeMaterialID) ThreeMaterialID,	");
//				sumsql.append("   max(tm.TwoMaterialPredictQty) TwoMaterialPredictQty,	");
//				sumsql.append("   max(tm.ThreeMaterialPredictQty) ThreeMaterialPredictQty	");
//				sumsql.append(" 	");
//				sumsql.append("   from (select 	");
//				sumsql.append("                max(stoOrgID) farmID,	");
//				sumsql.append("                stoOrgName,	");
//				sumsql.append("                batchName,	");
//				sumsql.append("                towerName,	");
//				sumsql.append("                currentDate,	");
//				sumsql.append("                max(towerid) towerID,	");
//				sumsql.append("                max(OneMaterialID) OneMaterialID,	");
//				sumsql.append("                max(TwoMaterialID) TwoMaterialID,	");
//				sumsql.append("                max(ThreeMaterialID) ThreeMaterialID,	");
//				sumsql.append("                sum(OneMaterialPredictQty) / 1000 OneMaterialPredictQty,	");
//				sumsql.append("                sum(OneMaterialActualQty) / 1000 OneMaterialActualQty,	");
//				sumsql.append("                sum(TwoMaterialPredictQty) / 1000 TwoMaterialPredictQty,	");
//				sumsql.append("                sum(TwoMaterialActualQty) / 1000 TwoMaterialActualQty,	");
//				sumsql.append("                sum(ThreeMaterialPredictQty) / 1000 ThreeMaterialPredictQty,	");
//				sumsql.append("                sum(ThreeMaterialActualQty) / 1000 ThreeMaterialActualQty	");
//				sumsql.append(" from ");
//				sumsql.append(temptableName);
//				sumsql.append("          where 1 = 1	");
//				if(filterBeginDate != null){
//					sumsql.append(" and currentDate >= to_date('");
//					sumsql.append(sdf.format(filterBeginDate));
//					sumsql.append("','yyyy-mm-dd') ");
//				}
//				
//				if(filterEndDate != null){
//					sumsql.append(" and to_date(to_char(currentDate,'yyyy-mm-dd'),'yyyy-mm-dd')<= to_date('");
//					sumsql.append(sdf.format(filterEndDate));
//					sumsql.append("','yyyy-mm-dd') ");
//				}
//				
//				sumsql.append("          group by stoOrgName, batchName, towerName, currentDate	");
//				sumsql.append("          order by stoOrgName, batchName, towerName, currentDate) tm	");
//				sumsql.append("          	");
//				sumsql.append("           left join T_IM_StockTransferBill tsb1 on to_char(tsb1.FBizDate,'yyyy-mm-dd') = to_char(tm.currentDate,'yyyy-mm-dd') and tsb1.FBaseStatus in('4','7') and tm.farmid = tsb1.FReceiptStorageOrgUnitID and tsb1.FIssueStorageOrgUnitID='at4AAAAACFnM567U' ");
//				sumsql.append("          left join T_IM_StockTransferBillEntry tsbe1 on tsbe1.fparentid = tsb1.fid and tm.towerID = tsbe1.Freceiptwarehouseid	");
//				sumsql.append("          left join T_BD_Material tsbem1 on tsbe1.fmaterialid  = tsbem1.fid and tsbem1.fname_l2 like '%RJ-01%' ");
//				sumsql.append("          group by tm.stoOrgName, tm.batchName, tm.towerName, tm.currentDate	");
//				sumsql.append("          order by tm.stoOrgName, tm.batchName, tm.towerName, tm.currentDate	");
//				sumsql.append("         	");
//				sumsql.append("         	");
//				sumsql.append("         ) tmm 	");
//				sumsql.append("         left join T_IM_StockTransferBill tsb2 on to_char(tsb2.FBizDate,'yyyy-mm-dd') = to_char(tmm.currentDate,'yyyy-mm-dd') and tsb2.FBaseStatus in('4','7') and tmm.farmid = tsb2.FReceiptStorageOrgUnitID and tsb2.FIssueStorageOrgUnitID='at4AAAAACFnM567U' ");
//				sumsql.append(" 	");
//				sumsql.append("          left join T_IM_StockTransferBillEntry tsbe2 on  tsbe2.fparentid = tsb2.fid and tmm.towerID = tsbe2.Freceiptwarehouseid	");
//				sumsql.append("          left join T_BD_Material tsbem2 on tsbe2.fmaterialid  = tsbem2.fid and tsbem2.fname_l2 like '%RJ-02%' ");
//				sumsql.append("          group by tmm.stoOrgName, tmm.batchName, tmm.towerName, tmm.currentDate	");
//				sumsql.append("          order by tmm.stoOrgName, tmm.batchName, tmm.towerName, tmm.currentDate) tmmm	");
//				sumsql.append("          left join T_IM_StockTransferBill tsb3 on to_char(tsb3.FBizDate,'yyyy-mm-dd') = to_char(tmmm.currentDate,'yyyy-mm-dd') and tsb3.FBaseStatus in('4','7') and tmmm.farmid = tsb3.FReceiptStorageOrgUnitID	and tsb3.FIssueStorageOrgUnitID='at4AAAAACFnM567U' ");
//				sumsql.append("          left join T_IM_StockTransferBillEntry tsbe3 on  tsbe3.fparentid = tsb3.fid  and tmmm.towerID = tsbe3.Freceiptwarehouseid	");
//				sumsql.append("          left join T_BD_Material tsbem3 on tsbe3.fmaterialid  = tsbem3.fid and tsbem3.fname_l2 like '%RJ-03%' ");
//				sumsql.append("          group by tmmm.stoOrgName, tmmm.batchName, tmmm.towerName, tmmm.currentDate	");
//				sumsql.append("          order by tmmm.stoOrgName, tmmm.batchName, tmmm.towerName, tmmm.currentDate) tmmmm	");
//				sumsql.append("          	");
//				sumsql.append("          left join T_IM_StockTransferBill tsb4 on to_char(tsb4.FBizDate,'yyyy-mm-dd') = tmmmm.currentDate and tsb4.FBaseStatus in('4','7') and tmmmm.farmid = tsb4.FIssueStorageOrgUnitID	and tsb4.FReceiptStorageOrgUnitID='at4AAAAACFnM567U' ");
//				sumsql.append("          left join T_IM_StockTransferBillEntry tsbe4 on  tsbe4.fparentid = tsb4.fid  and tmmmm.towerID = tsbe4.Freceiptwarehouseid	");
//				sumsql.append("          left join T_BD_Material tsbem4 on tsbe4.fmaterialid  = tsbem4.fid and tsbem4.fname_l2 like '%RJ-01%' ");
//				sumsql.append("          group by tmmmm.stoOrgName, tmmmm.batchName, tmmmm.towerName, tmmmm.currentDate	");
//				sumsql.append("          order by tmmmm.stoOrgName, tmmmm.batchName, tmmmm.towerName, tmmmm.currentDate) tmmmmm	");
//				sumsql.append("          	");		
//				sumsql.append("          left join T_IM_StockTransferBill tsb5 on to_char(tsb5.FBizDate,'yyyy-mm-dd') = tmmmmm.currentDate and tsb5.FBaseStatus in('4','7') and tmmmmm.farmid = tsb5.FIssueStorageOrgUnitID	and tsb5.FReceiptStorageOrgUnitID='at4AAAAACFnM567U' ");
//				sumsql.append("          left join T_IM_StockTransferBillEntry tsbe5 on  tsbe5.fparentid = tsb5.fid  and tmmmmm.towerID = tsbe5.Freceiptwarehouseid	");
//				sumsql.append("          left join T_BD_Material tsbem5 on tsbe5.fmaterialid  = tsbem5.fid and tsbem5.fname_l2 like '%RJ-02%' ");
//				sumsql.append("          group by tmmmmm.stoOrgName, tmmmmm.batchName, tmmmmm.towerName, tmmmmm.currentDate	");
//				sumsql.append("          order by tmmmmm.stoOrgName, tmmmmm.batchName, tmmmmm.towerName, tmmmmm.currentDate) tmmmmmm	");
//				sumsql.append("          	");		
//				sumsql.append("          left join T_IM_StockTransferBill tsb6 on to_char(tsb6.FBizDate,'yyyy-mm-dd') = tmmmmmm.currentDate and tsb6.FBaseStatus in('4','7') and tmmmmmm.farmid = tsb6.FIssueStorageOrgUnitID	and tsb6.FReceiptStorageOrgUnitID='at4AAAAACFnM567U' ");
//				sumsql.append("          left join T_IM_StockTransferBillEntry tsbe6 on  tsbe6.fparentid = tsb6.fid  and tmmmmmm.towerID = tsbe6.Freceiptwarehouseid	");
//				sumsql.append("          left join T_BD_Material tsbem6 on tsbe6.fmaterialid  = tsbem6.fid and tsbem6.fname_l2 like '%RJ-02%' ");
//				sumsql.append("          group by tmmmmmm.stoOrgName, tmmmmmm.currentDate	");
//				sumsql.append("          order by tmmmmmm.stoOrgName, tmmmmmm.currentDate	");
//				sumsql.append("          	");	
//			
				IRowSet rs = DbUtil.executeQuery(ctx, sumsql.toString());
				System.out.println("查询结果结束：");
				System.out.println(new Date());
				return rs;
				
			
				
			}
			// 明细查询
			else if("2".equals(sumType)){
				StringBuilder sumsql = new StringBuilder();
				
				sumsql.append(" /*dialect*/	");
				sumsql.append(" select 	");
				sumsql.append(" max(farmID) farmID,	");
				sumsql.append("        stoOrgName,	");
//				sumsql.append("        max(batchName) batchName,	");
				sumsql.append("        '' batchName,	");
				sumsql.append("        towerName,	");
				sumsql.append("        currentDate,	");
				sumsql.append("        max(towerid) towerID,	'");
				sumsql.append(temptableName);
				sumsql.append("' temptableName,");
				sumsql.append("        max(ZeroMaterialID) ZeroMaterialID,	");
				sumsql.append("        max(OneMaterialID) OneMaterialID,	");
				sumsql.append("        max(TwoMaterialID) TwoMaterialID,	");
				sumsql.append("        max(ThreeMaterialID) ThreeMaterialID,	");
				sumsql.append("        sum(ZeroMaterialPredictQty)  ZeroMaterialPredictQty,	");
				sumsql.append("        sum(ZeroMaterialActualQty)  ZeroMaterialActualQty,	");
				sumsql.append("        sum(OneMaterialPredictQty)  OneMaterialPredictQty,	");
				sumsql.append("        sum(OneMaterialActualQty)  OneMaterialActualQty,	");
				sumsql.append("        sum(TwoMaterialPredictQty) TwoMaterialPredictQty,	");
				sumsql.append("        sum(TwoMaterialActualQty)  TwoMaterialActualQty,	");
				sumsql.append("        sum(ThreeMaterialPredictQty) ThreeMaterialPredictQty,	");
				sumsql.append("        sum(ThreeMaterialActualQty) ThreeMaterialActualQty	");
				sumsql.append("        from 	");
				sumsql.append("  (	");
				sumsql.append(" select max(stoOrgID) farmID,	");
				sumsql.append("        stoOrgName,	");
				sumsql.append("        batchName,	");
				sumsql.append("        towerName,	");
				sumsql.append("        to_char(currentDate, 'yyyy-mm-dd') currentDate,	");
				sumsql.append("        max(towerid) towerID,	");
				sumsql.append("        max(ZeroMaterialID) ZeroMaterialID,	");
				sumsql.append("        max(OneMaterialID) OneMaterialID,	");
				sumsql.append("        max(TwoMaterialID) TwoMaterialID,	");
				sumsql.append("        max(ThreeMaterialID) ThreeMaterialID,	");
				sumsql.append("        sum(ZeroMaterialPredictQty) / 1000 ZeroMaterialPredictQty,	");
				sumsql.append("        sum(ZeroMaterialActualQty) / 1000 ZeroMaterialActualQty,	");
				sumsql.append("        sum(OneMaterialPredictQty) / 1000 OneMaterialPredictQty,	");
				sumsql.append("        sum(OneMaterialActualQty) / 1000 OneMaterialActualQty,	");
				sumsql.append("        sum(TwoMaterialPredictQty) / 1000 TwoMaterialPredictQty,	");
				sumsql.append("        sum(TwoMaterialActualQty) / 1000 TwoMaterialActualQty,	");
				sumsql.append("        sum(ThreeMaterialPredictQty) / 1000 ThreeMaterialPredictQty,	");
				sumsql.append("        sum(ThreeMaterialActualQty) / 1000 ThreeMaterialActualQty	");
				sumsql.append("   from ");
				sumsql.append(temptableName);
				sumsql.append("          where 1 = 1	");
				if(filterBeginDate != null){
					sumsql.append(" and currentDate >= to_date('");
					sumsql.append(sdf.format(filterBeginDate));
					sumsql.append("','yyyy-mm-dd') ");
				}
				
				if(filterEndDate != null){
					sumsql.append(" and to_date(to_char(currentDate,'yyyy-mm-dd'),'yyyy-mm-dd')<= to_date('");
					sumsql.append(sdf.format(filterEndDate));
					sumsql.append("','yyyy-mm-dd') ");
				}
//				
//				sumsql.append("  where 1 = 1	");
//				sumsql.append("    and currentDate >=	");
//				sumsql.append("        to_date('2015-09-01',	");
//				sumsql.append("                'yyyy-mm-dd')	");
//				sumsql.append("    and to_date(to_char(currentDate,	");
//				sumsql.append("                        'yyyy-mm-dd'),	");
//				sumsql.append("                'yyyy-mm-dd') <=	");
//				sumsql.append("        to_date('2015-09-30',	");
//				sumsql.append("                'yyyy-mm-dd')	");
				sumsql.append("  group by stoOrgName,	");
				sumsql.append("           batchName,	");
				sumsql.append("           towerName,	");
				sumsql.append("           currentDate	");
				sumsql.append(" 	");
				sumsql.append("                                                           	");
				sumsql.append(" union all 	");
				sumsql.append(" 	");
				sumsql.append(" select 	");
				sumsql.append("     t.freceiptstorageorgunitid   farmID,	");
				sumsql.append("    max(tos.fname_l2) stoOrgName,	");
				sumsql.append("    '' batchName,	");
				sumsql.append("    max(tw.fname_l2) towerName,	");
				sumsql.append("    to_char(t.fbizdate, 'yyyy-mm-dd') currentDate,	");
				sumsql.append("    tw.fid towerID,	");
				sumsql.append("    '' ZeroMaterialID,	");
				sumsql.append("    '' OneMaterialID,	");
				sumsql.append("    '' TwoMaterialID,	");
				sumsql.append("   '' ThreeMaterialID,	");
				sumsql.append("    0 ZeroMaterialPredictQty,	");
				sumsql.append("    sum (case when tm1.fname_l2  like   '%RJ-00%'	");
				sumsql.append("   then tsbe1.fbaseqty	");
				sumsql.append("     else 0 end) / 1000 ZeroMaterialActualQty,	");
				sumsql.append("    0 OneMaterialPredictQty,	");
				sumsql.append("    sum (case when tm1.fname_l2  like   '%RJ-01%'	");
				sumsql.append("   then tsbe1.fbaseqty	");
				sumsql.append("     else 0 end) / 1000 OneMaterialActualQty,	");
				sumsql.append("    0 TwoMaterialPredictQty,	");
				sumsql.append("    sum (case when  tm1.fname_l2  like   '%RJ-02%'	");
				sumsql.append("   then tsbe1.fbaseqty	");
				sumsql.append("     else 0 end) / 1000 TwoMaterialActualQty,	");
				sumsql.append("    0 ThreeMaterialPredictQty,	");
				sumsql.append("    sum (case when  tm1.fname_l2  like   '%RJ-03%'	");
				sumsql.append("   then tsbe1.fbaseqty	");
				sumsql.append("     else 0 end) / 1000 ThreeMaterialActualQty	");
				sumsql.append(" 	");
				sumsql.append(" from T_IM_StockTransferBill t 	");
				sumsql.append(" inner join T_IM_StockTransferBillEntry tsbe1 on t.fid = tsbe1.fparentid	");
				sumsql.append(" inner join t_bd_material tm1 on tsbe1.fmaterialid = tm1.fid	");
				sumsql.append(" inner join t_org_storage tos on t.freceiptstorageorgunitid = tos.fid 	");
				sumsql.append(" inner join t_db_warehouse tw on tsbe1.freceiptwarehouseid = tw.fid	");
//				sumsql.append(" inner join ( select distinct STOORGID,BATCHNAME from  ");
//				sumsql.append(temptableName);
//				sumsql.append(" ) tb on tb.STOORGID = tos.fid	");
				sumsql.append(" where  tw.fname_l2 like '%料塔%'	 ");
				sumsql.append(" and tos.fid in ( select distinct STOORGID from ");
				sumsql.append(temptableName);
				sumsql.append(" )  ");
				if(filterBeginDate != null){
					sumsql.append(" and t.fbizdate >= to_date('");
					sumsql.append(sdf.format(filterBeginDate));
					sumsql.append("','yyyy-mm-dd') ");
				}
				
				if(filterEndDate != null){
					sumsql.append(" and to_date(to_char(t.fbizdate,'yyyy-mm-dd'),'yyyy-mm-dd')<= to_date('");
					sumsql.append(sdf.format(filterEndDate));
					sumsql.append("','yyyy-mm-dd') ");
				}
				sumsql.append(" group by t.freceiptstorageorgunitid,tw.fid,t.fbizdate	");
				sumsql.append(" union all	");
				sumsql.append(" select 	");
				sumsql.append(" t.fissuestorageorgunitid farmID,	");
				sumsql.append("    max(tos.fname_l2) stoOrgName,	");
				sumsql.append("    '' batchName,	");
				sumsql.append("    max(tw.fname_l2) towerName,	");
				sumsql.append("    to_char(t.fbizdate, 'yyyy-mm-dd') currentDate,	");
				sumsql.append("    tw.fid towerID,	");
				sumsql.append("    '' ZeroMaterialID,	");
				sumsql.append("    '' OneMaterialID,	");
				sumsql.append("    '' TwoMaterialID,	");
				sumsql.append("   '' ThreeMaterialID,	");
				sumsql.append("    0 ZeroMaterialPredictQty,	");
				sumsql.append("    sum (case when tm1.fname_l2  like   '%RJ-00%'	");
				sumsql.append("   then -1*tsbe1.fbaseqty	");
				sumsql.append("     else 0 end) / 1000 ZeroMaterialActualQty,	");
				sumsql.append("    0 OneMaterialPredictQty,	");
				sumsql.append("    sum (case when tm1.fname_l2  like   '%RJ-01%'	");
				sumsql.append("   then -1*tsbe1.fbaseqty	");
				sumsql.append("     else 0 end) / 1000 OneMaterialActualQty,	");
				sumsql.append("    0 TwoMaterialPredictQty,	");
				sumsql.append("    sum (case when  tm1.fname_l2  like   '%RJ-02%'	");
				sumsql.append("   then -1*tsbe1.fbaseqty	");
				sumsql.append("     else 0 end) / 1000 TwoMaterialActualQty,	");
				sumsql.append("    0 ThreeMaterialPredictQty,	");
				sumsql.append("    sum (case when  tm1.fname_l2  like   '%RJ-03%'	");
				sumsql.append("   then -1*tsbe1.fbaseqty	");
				sumsql.append("     else 0 end) / 1000 ThreeMaterialActualQty	");
				sumsql.append(" 	");
				sumsql.append(" from T_IM_StockTransferBill t 	");
				sumsql.append(" inner join T_IM_StockTransferBillEntry tsbe1 on t.fid = tsbe1.fparentid	");
				sumsql.append(" inner join t_bd_material tm1 on tsbe1.fmaterialid = tm1.fid	");
				sumsql.append(" inner join t_org_storage tos on t.fissuestorageorgunitid = tos.fid 	");
				sumsql.append(" inner join t_db_warehouse tw on tsbe1.fissuewarehouseid = tw.fid	");
//				sumsql.append(" inner join ( select distinct STOORGID,BATCHNAME from  ");
//				sumsql.append(temptableName);
//				sumsql.append(" ) tb on tb.STOORGID = tos.fid	");
				sumsql.append(" where  tw.fname_l2 like '%料塔%'	");
				sumsql.append(" and tos.fid in ( select distinct STOORGID from ");
				sumsql.append(temptableName);
				sumsql.append(" )  ");
				if(filterBeginDate != null){
					sumsql.append(" and t.fbizdate >= to_date('");
					sumsql.append(sdf.format(filterBeginDate));
					sumsql.append("','yyyy-mm-dd') ");
				}
				
				if(filterEndDate != null){
					sumsql.append(" and to_date(to_char(t.fbizdate,'yyyy-mm-dd'),'yyyy-mm-dd')<= to_date('");
					sumsql.append(sdf.format(filterEndDate));
					sumsql.append("','yyyy-mm-dd') ");
				}
				sumsql.append(" group by t.fissuestorageorgunitid,tw.fid,t.fbizdate	");
				sumsql.append(" )  group by stoOrgName,	");
				sumsql.append("           towerName,	");
				sumsql.append("           currentDate	");
				sumsql.append("  order by stoOrgName,	");
				sumsql.append("           towerName,	");
				sumsql.append("           currentDate	");
				

//				
//				sumsql.append(" /*dialect*/	");
//				sumsql.append(" select 	");
//				sumsql.append("   max(tmmmmmm.farmID) farmID,tmmmmmm.stoOrgName, tmmmmmm.batchName, tmmmmmm.towerName,");
//				sumsql.append(" tmmmmmm.currentDate currentDate, max(tmmmmmm.towerid) towerID,	'");
//				sumsql.append(temptableName);
//				sumsql.append("' temptableName,");
//				sumsql.append("   max(tmmmmmm.OneMaterialPredictQty) OneMaterialPredictQty,	");
//				sumsql.append("   max(tmmmmmm.OneMaterialActualQty) OneMaterialActualQty,	");
//				sumsql.append("   max(tmmmmmm.TwoMaterialPredictQty) TwoMaterialPredictQty,	");
//				sumsql.append("   max(tmmmmmm.TwoMaterialActualQty) TwoMaterialActualQty,	");
//				sumsql.append("   max(tmmmmmm.ThreeMaterialPredictQty) ThreeMaterialPredictQty,	");
//				sumsql.append("   max(tmmmmmm.ThreeMaterialActualQty)-sum(decode(tsbem6.fid,null,0,tsbe6.fbaseqty))/1000  ThreeMaterialActualQty	");
//				
//				sumsql.append(" from (select 	");
//				sumsql.append("   max(tmmmmm.farmID) farmID,tmmmmm.stoOrgName, tmmmmm.batchName, tmmmmm.towerName,");
//				sumsql.append(" tmmmmm.currentDate currentDate, max(tmmmmm.towerid) towerID,	'");
//				sumsql.append(temptableName);
//				sumsql.append("' temptableName,");
//				sumsql.append("   max(tmmmmm.OneMaterialPredictQty) OneMaterialPredictQty,	");
//				sumsql.append("   max(tmmmmm.OneMaterialActualQty) OneMaterialActualQty,	");
//				sumsql.append("   max(tmmmmm.TwoMaterialPredictQty) TwoMaterialPredictQty,	");
//				sumsql.append("   max(tmmmmm.TwoMaterialActualQty)-sum(decode(tsbem5.fid,null,0,tsbe5.fbaseqty))/1000  TwoMaterialActualQty,	");
//				sumsql.append("   max(tmmmmm.ThreeMaterialPredictQty) ThreeMaterialPredictQty,	");
//				sumsql.append("   max(tmmmmm.ThreeMaterialActualQty) ThreeMaterialActualQty	");
//				
//				sumsql.append(" from ( select 	");
//				sumsql.append("   max(tmmmm.farmID) farmID,tmmmm.stoOrgName, tmmmm.batchName, tmmmm.towerName,");
//				sumsql.append(" tmmmm.currentDate currentDate, max(tmmmm.towerid) towerID,	'");
//				sumsql.append(temptableName);
//				sumsql.append("' temptableName,");
//				sumsql.append("   max(tmmmm.OneMaterialPredictQty) OneMaterialPredictQty,	");
//				sumsql.append("   max(tmmmm.OneMaterialActualQty)-sum(decode(tsbem4.fid,null,0,tsbe4.fbaseqty))/1000 OneMaterialActualQty,	");
//				sumsql.append("   max(tmmmm.TwoMaterialPredictQty) TwoMaterialPredictQty,	");
//				sumsql.append("   max(tmmmm.TwoMaterialActualQty) TwoMaterialActualQty,	");
//				sumsql.append("   max(tmmmm.ThreeMaterialPredictQty) ThreeMaterialPredictQty,	");
//				sumsql.append("   max(tmmmm.ThreeMaterialActualQty) ThreeMaterialActualQty	");
////				sumsql.append("   sum(tsbe3.fbaseqty)/1000 ThreeMaterialActualQty	");
//				sumsql.append(" 	");
//				
//				sumsql.append(" from( select 	");
//				sumsql.append("   max(tmmm.farmID) farmID,tmmm.stoOrgName, tmmm.batchName, tmmm.towerName,");
//				sumsql.append(" to_char(tmmm.currentDate,'yyyy-mm-dd') currentDate, max(tmmm.towerid) towerID,	'");
//				sumsql.append(temptableName);
//				sumsql.append("' temptableName,");
//				sumsql.append("   max(tmmm.OneMaterialPredictQty) OneMaterialPredictQty,	");
//				sumsql.append("   max(tmmm.OneMaterialActualQty) OneMaterialActualQty,	");
//				sumsql.append("   max(tmmm.TwoMaterialPredictQty) TwoMaterialPredictQty,	");
//				sumsql.append("   max(tmmm.TwoMaterialActualQty) TwoMaterialActualQty,	");
//				sumsql.append("   max(tmmm.ThreeMaterialPredictQty) ThreeMaterialPredictQty,	");
//				sumsql.append("   sum(decode(tsbem3.fid,null,0,tsbe3.fbaseqty))/1000 ThreeMaterialActualQty	");
////				sumsql.append("   sum(tsbe3.fbaseqty)/1000 ThreeMaterialActualQty	");
//				sumsql.append(" 	");
//				sumsql.append(" from (select 	");
//				sumsql.append("  max(tmm.farmID) farmID,tmm.stoOrgName, tmm.batchName, tmm.towerName, tmm.currentDate, max(tmm.towerid) towerID,	");
//				sumsql.append("   max(tmm.OneMaterialPredictQty) OneMaterialPredictQty,	");
//				sumsql.append("   max(tmm.OneMaterialActualQty) OneMaterialActualQty,	");
//				sumsql.append("   max(tmm.TwoMaterialPredictQty) TwoMaterialPredictQty,	");
//				sumsql.append("   sum(decode(tsbem2.fid,null,0,tsbe2.fbaseqty))/1000 TwoMaterialActualQty,	");
////				sumsql.append("   sum(tsbe2.fbaseqty)/1000 TwoMaterialActualQty,	");
//				sumsql.append("   max(tmm.TwoMaterialID) TwoMaterialID,	");
//				sumsql.append("   max(tmm.ThreeMaterialID) ThreeMaterialID,	");
//				sumsql.append(" 	");
//				sumsql.append("   max(tmm.ThreeMaterialPredictQty) ThreeMaterialPredictQty	");
//				sumsql.append(" from (	");
//				sumsql.append(" select max(tm.farmID) farmID,tm.stoOrgName, tm.batchName, tm.towerName, tm.currentDate, max(tm.towerid) towerID,	");
//				sumsql.append("   max(tm.OneMaterialPredictQty) OneMaterialPredictQty,	");
//				sumsql.append("   sum(decode(tsbem1.fid,null,0,tsbe1.fbaseqty))/1000 OneMaterialActualQty,	");
////				sumsql.append("   sum(tsbe1.fbaseqty)/1000 OneMaterialActualQty,	");
//				sumsql.append("   max(tm.TwoMaterialID) TwoMaterialID,	");
//				sumsql.append("   max(tm.ThreeMaterialID) ThreeMaterialID,	");
//				sumsql.append("   max(tm.TwoMaterialPredictQty) TwoMaterialPredictQty,	");
//				sumsql.append("   max(tm.ThreeMaterialPredictQty) ThreeMaterialPredictQty	");
//				sumsql.append(" 	");
//				sumsql.append("   from (select 	");
//				sumsql.append("                max(stoOrgID) farmID,	");
//				sumsql.append("                stoOrgName,	");
//				sumsql.append("                batchName,	");
//				sumsql.append("                towerName,	");
//				sumsql.append("                currentDate,	");
//				sumsql.append("                max(towerid) towerID,	");
//				sumsql.append("                max(OneMaterialID) OneMaterialID,	");
//				sumsql.append("                max(TwoMaterialID) TwoMaterialID,	");
//				sumsql.append("                max(ThreeMaterialID) ThreeMaterialID,	");
//				sumsql.append("                sum(OneMaterialPredictQty) / 1000 OneMaterialPredictQty,	");
//				sumsql.append("                sum(OneMaterialActualQty) / 1000 OneMaterialActualQty,	");
//				sumsql.append("                sum(TwoMaterialPredictQty) / 1000 TwoMaterialPredictQty,	");
//				sumsql.append("                sum(TwoMaterialActualQty) / 1000 TwoMaterialActualQty,	");
//				sumsql.append("                sum(ThreeMaterialPredictQty) / 1000 ThreeMaterialPredictQty,	");
//				sumsql.append("                sum(ThreeMaterialActualQty) / 1000 ThreeMaterialActualQty	");
//				sumsql.append(" from ");
//				sumsql.append(temptableName);
//				sumsql.append("          where 1 = 1	");
//				if(filterBeginDate != null){
//					sumsql.append(" and currentDate >= to_date('");
//					sumsql.append(sdf.format(filterBeginDate));
//					sumsql.append("','yyyy-mm-dd') ");
//				}
//				
//				if(filterEndDate != null){
//					sumsql.append(" and to_date(to_char(currentDate,'yyyy-mm-dd'),'yyyy-mm-dd')<= to_date('");
//					sumsql.append(sdf.format(filterEndDate));
//					sumsql.append("','yyyy-mm-dd') ");
//				}
//				
//				sumsql.append("          group by stoOrgName, batchName, towerName, currentDate	");
//				sumsql.append("          order by stoOrgName, batchName, towerName, currentDate) tm	");
//				sumsql.append("          	");
//				sumsql.append("           left join T_IM_StockTransferBill tsb1 on to_char(tsb1.FBizDate,'yyyy-mm-dd') = to_char(tm.currentDate,'yyyy-mm-dd') and tsb1.FBaseStatus in('4','7') and tm.farmid = tsb1.FReceiptStorageOrgUnitID and tsb1.FIssueStorageOrgUnitID='at4AAAAACFnM567U' ");
//				sumsql.append("          left join T_IM_StockTransferBillEntry tsbe1 on tsbe1.fparentid = tsb1.fid and tm.towerID = tsbe1.Freceiptwarehouseid	");
//				sumsql.append("          left join T_BD_Material tsbem1 on tsbe1.fmaterialid  = tsbem1.fid and tsbem1.fname_l2 like '%RJ-01%' ");
//				sumsql.append("          group by tm.stoOrgName, tm.batchName, tm.towerName, tm.currentDate	");
//				sumsql.append("          order by tm.stoOrgName, tm.batchName, tm.towerName, tm.currentDate	");
//				sumsql.append("         	");
//				sumsql.append("         	");
//				sumsql.append("         ) tmm 	");
//				sumsql.append("         left join T_IM_StockTransferBill tsb2 on to_char(tsb2.FBizDate,'yyyy-mm-dd') = to_char(tmm.currentDate,'yyyy-mm-dd') and tsb2.FBaseStatus in('4','7') and tmm.farmid = tsb2.FReceiptStorageOrgUnitID and tsb2.FIssueStorageOrgUnitID='at4AAAAACFnM567U' ");
//				sumsql.append(" 	");
//				sumsql.append("          left join T_IM_StockTransferBillEntry tsbe2 on  tsbe2.fparentid = tsb2.fid and tmm.towerID = tsbe2.Freceiptwarehouseid	");
//				sumsql.append("          left join T_BD_Material tsbem2 on tsbe2.fmaterialid  = tsbem2.fid and tsbem2.fname_l2 like '%RJ-02%' ");
//				sumsql.append("          group by tmm.stoOrgName, tmm.batchName, tmm.towerName, tmm.currentDate	");
//				sumsql.append("          order by tmm.stoOrgName, tmm.batchName, tmm.towerName, tmm.currentDate) tmmm	");
//				sumsql.append("          left join T_IM_StockTransferBill tsb3 on to_char(tsb3.FBizDate,'yyyy-mm-dd') = to_char(tmmm.currentDate,'yyyy-mm-dd') and tsb3.FBaseStatus in('4','7') and tmmm.farmid = tsb3.FReceiptStorageOrgUnitID	and tsb3.FIssueStorageOrgUnitID='at4AAAAACFnM567U' ");
//				sumsql.append("          left join T_IM_StockTransferBillEntry tsbe3 on  tsbe3.fparentid = tsb3.fid  and tmmm.towerID = tsbe3.Freceiptwarehouseid	");
//				sumsql.append("          left join T_BD_Material tsbem3 on tsbe3.fmaterialid  = tsbem3.fid and tsbem3.fname_l2 like '%RJ-03%' ");
//				sumsql.append("          group by tmmm.stoOrgName, tmmm.batchName, tmmm.towerName, tmmm.currentDate	");
//				sumsql.append("          order by tmmm.stoOrgName, tmmm.batchName, tmmm.towerName, tmmm.currentDate) tmmmm	");
//				sumsql.append("          	");
//				sumsql.append("          left join T_IM_StockTransferBill tsb4 on to_char(tsb4.FBizDate,'yyyy-mm-dd') = tmmmm.currentDate and tsb4.FBaseStatus in('4','7') and tmmmm.farmid = tsb4.FIssueStorageOrgUnitID	and tsb4.FReceiptStorageOrgUnitID='at4AAAAACFnM567U' ");
//				sumsql.append("          left join T_IM_StockTransferBillEntry tsbe4 on  tsbe4.fparentid = tsb4.fid  and tmmmm.towerID = tsbe4.Freceiptwarehouseid	");
//				sumsql.append("          left join T_BD_Material tsbem4 on tsbe4.fmaterialid  = tsbem4.fid and tsbem4.fname_l2 like '%RJ-01%' ");
//				sumsql.append("          group by tmmmm.stoOrgName, tmmmm.batchName, tmmmm.towerName, tmmmm.currentDate	");
//				sumsql.append("          order by tmmmm.stoOrgName, tmmmm.batchName, tmmmm.towerName, tmmmm.currentDate) tmmmmm	");
//				sumsql.append("          	");		
//				sumsql.append("          left join T_IM_StockTransferBill tsb5 on to_char(tsb5.FBizDate,'yyyy-mm-dd') = tmmmmm.currentDate and tsb5.FBaseStatus in('4','7') and tmmmmm.farmid = tsb5.FIssueStorageOrgUnitID	and tsb5.FReceiptStorageOrgUnitID='at4AAAAACFnM567U' ");
//				sumsql.append("          left join T_IM_StockTransferBillEntry tsbe5 on  tsbe5.fparentid = tsb5.fid  and tmmmmm.towerID = tsbe5.Freceiptwarehouseid	");
//				sumsql.append("          left join T_BD_Material tsbem5 on tsbe5.fmaterialid  = tsbem5.fid and tsbem5.fname_l2 like '%RJ-02%' ");
//				sumsql.append("          group by tmmmmm.stoOrgName, tmmmmm.batchName, tmmmmm.towerName, tmmmmm.currentDate	");
//				sumsql.append("          order by tmmmmm.stoOrgName, tmmmmm.batchName, tmmmmm.towerName, tmmmmm.currentDate) tmmmmmm	");
//				sumsql.append("          	");		
//				sumsql.append("          left join T_IM_StockTransferBill tsb6 on to_char(tsb6.FBizDate,'yyyy-mm-dd') = tmmmmmm.currentDate and tsb6.FBaseStatus in('4','7') and tmmmmmm.farmid = tsb6.FIssueStorageOrgUnitID	and tsb6.FReceiptStorageOrgUnitID='at4AAAAACFnM567U' ");
//				sumsql.append("          left join T_IM_StockTransferBillEntry tsbe6 on  tsbe6.fparentid = tsb6.fid  and tmmmmmm.towerID = tsbe6.Freceiptwarehouseid	");
//				sumsql.append("          left join T_BD_Material tsbem6 on tsbe6.fmaterialid  = tsbem6.fid and tsbem6.fname_l2 like '%RJ-02%' ");
//				sumsql.append("          group by tmmmmmm.stoOrgName, tmmmmmm.batchName, tmmmmmm.towerName, tmmmmmm.currentDate	");
//				sumsql.append("          order by tmmmmmm.stoOrgName, tmmmmmm.batchName, tmmmmmm.towerName, tmmmmmm.currentDate	");
//				sumsql.append("          	");	
//			
				IRowSet rs = DbUtil.executeQuery(ctx, sumsql.toString());
				System.out.println("查询结果结束：");
				System.out.println(new Date());
				return rs;
			}if("3".equals(sumType)){
				StringBuilder sumsql = new StringBuilder();
				sumsql.append(" /*dialect*/	");
				sumsql.append(" select 	");
//				sumsql.append("   max(tmmmm.farmID) farmID,tmmmm.stoOrgName,");
				sumsql.append(" to_char(tmmmm.currentDate,'yyyy-mm-dd') currentDate, 	'");
				sumsql.append(temptableName);
				sumsql.append("' temptableName,");
				sumsql.append("   sum(tmmmm.ZeroMaterialPredictQty) ZeroMaterialPredictQty,	");
				sumsql.append("   sum(tmmmm.ZeroMaterialActualQty)ZeroMaterialActualQty,	");
				sumsql.append("   sum(tmmmm.OneMaterialPredictQty) OneMaterialPredictQty,	");
				sumsql.append("   sum(tmmmm.OneMaterialActualQty) OneMaterialActualQty,	");
				sumsql.append("   sum(tmmmm.TwoMaterialPredictQty) TwoMaterialPredictQty,	");
				sumsql.append("   sum(tmmmm.TwoMaterialActualQty) TwoMaterialActualQty,	");
				sumsql.append("   sum(tmmmm.ThreeMaterialPredictQty) ThreeMaterialPredictQty,	");
				sumsql.append("   sum(tmmmm.ThreeMaterialActualQty) ThreeMaterialActualQty	");
				sumsql.append(" from ( 	");
				
				sumsql.append(" select 	");
				sumsql.append("   max(tmmm.farmID) farmID,tmmm.stoOrgName, tmmm.batchName, tmmm.towerName,");
				sumsql.append(" tmmm.currentDate , max(tmmm.towerid) towerID,	'");
				sumsql.append(temptableName);
				sumsql.append("' temptableName,");
				sumsql.append("   max(tmmm.ZeroMaterialPredictQty) ZeroMaterialPredictQty,	");
				sumsql.append("   max(tmmm.ZeroMaterialActualQty) ZeroMaterialActualQty,	");
				sumsql.append("   max(tmmm.OneMaterialPredictQty) OneMaterialPredictQty,	");
				sumsql.append("   max(tmmm.OneMaterialActualQty) OneMaterialActualQty,	");
				sumsql.append("   max(tmmm.TwoMaterialPredictQty) TwoMaterialPredictQty,	");
				sumsql.append("   max(tmmm.TwoMaterialActualQty) TwoMaterialActualQty,	");
				sumsql.append("   max(tmmm.ThreeMaterialPredictQty) ThreeMaterialPredictQty,	");
				sumsql.append("   sum(decode(tsbem3.fid,null,0,tsbe3.fbaseqty))/1000 ThreeMaterialActualQty	");
//				sumsql.append("   sum(tsbe3.fbaseqty)/1000 ThreeMaterialActualQty	");
				sumsql.append(" 	");
				sumsql.append(" from (select 	"); 
				sumsql.append("  max(tmm.farmID) farmID,tmm.stoOrgName, tmm.batchName, tmm.towerName, tmm.currentDate, max(tmm.towerid) towerID,	");
				sumsql.append("   max(tmm.ZeroMaterialPredictQty) ZeroMaterialPredictQty,	");
				sumsql.append("   max(tmm.ZeroMaterialActualQty) ZeroMaterialActualQty,	");
				sumsql.append("   max(tmm.OneMaterialPredictQty) OneMaterialPredictQty,	");
				sumsql.append("   max(tmm.OneMaterialActualQty) OneMaterialActualQty,	");
				sumsql.append("   max(tmm.TwoMaterialPredictQty) TwoMaterialPredictQty,	");
				sumsql.append("   sum(decode(tsbem2.fid,null,0,tsbe2.fbaseqty))/1000 TwoMaterialActualQty,	");
//				sumsql.append("   sum(tsbe2.fbaseqty)/1000 TwoMaterialActualQty,	");
				sumsql.append("   max(tmm.TwoMaterialID) TwoMaterialID,	");
				sumsql.append("   max(tmm.ThreeMaterialID) ThreeMaterialID,	");
				sumsql.append(" 	");
				sumsql.append("   max(tmm.ThreeMaterialPredictQty) ThreeMaterialPredictQty	");
				sumsql.append(" from (	");
				sumsql.append(" select max(tm0.farmID) farmID,tm0.stoOrgName, tm0.batchName, tm0.towerName, tm0.currentDate, max(tm0.towerid) towerID,	");
				sumsql.append("   max(tm0.ZeroMaterialPredictQty) ZeroMaterialPredictQty,	");
				sumsql.append("   max(tm0.ZeroMaterialActualQty) ZeroMaterialActualQty,	");
				sumsql.append("   max(tm0.OneMaterialPredictQty) OneMaterialPredictQty,	");
				sumsql.append("   sum(decode(tsbem1.fid,null,0,tsbe1.fbaseqty))/1000 OneMaterialActualQty,	");
//				sumsql.append("   sum(tsbe1.fbaseqty)/1000 OneMaterialActualQty,	");
				sumsql.append("   max(tm0.TwoMaterialID) TwoMaterialID,	");
				sumsql.append("   max(tm0.ThreeMaterialID) ThreeMaterialID,	");
				sumsql.append("   max(tm0.TwoMaterialPredictQty) TwoMaterialPredictQty,	");
				sumsql.append("   max(tm0.ThreeMaterialPredictQty) ThreeMaterialPredictQty	");
				sumsql.append(" 	");
				
				sumsql.append(" from (	");
				sumsql.append(" select max(tm.farmID) farmID,tm.stoOrgName, tm.batchName, tm.towerName, tm.currentDate, max(tm.towerid) towerID,	");
				sumsql.append("   max(tm.ZeroMaterialPredictQty) ZeroMaterialPredictQty,	");
				sumsql.append("   sum(decode(tsbem0.fid,null,0,tsbe0.fbaseqty))/1000 ZeroMaterialActualQty,	");
				sumsql.append("   max(tm.OneMaterialPredictQty) OneMaterialPredictQty,	");
				sumsql.append("   max(tm.OneMaterialID) OneMaterialID,	");
//				sumsql.append("   sum(tsbe1.fbaseqty)/1000 OneMaterialActualQty,	");
				sumsql.append("   max(tm.TwoMaterialID) TwoMaterialID,	");
				sumsql.append("   max(tm.ThreeMaterialID) ThreeMaterialID,	");
				sumsql.append("   max(tm.TwoMaterialPredictQty) TwoMaterialPredictQty,	");
				sumsql.append("   max(tm.ThreeMaterialPredictQty) ThreeMaterialPredictQty	");
				sumsql.append(" 	");
				
				sumsql.append("   from (select 	");
				sumsql.append("                max(stoOrgID) farmID,	");
				sumsql.append("                stoOrgName,	");
				sumsql.append("                batchName,	");
				sumsql.append("                towerName,	");
				sumsql.append("                currentDate,	");
				sumsql.append("                max(towerid) towerID,	");
				sumsql.append("                max(ZeroMaterialID) ZeroMaterialID,	");
				sumsql.append("                max(OneMaterialID) OneMaterialID,	");
				sumsql.append("                max(TwoMaterialID) TwoMaterialID,	");
				sumsql.append("                max(ThreeMaterialID) ThreeMaterialID,	");
				sumsql.append("                sum(ZeroMaterialPredictQty) / 1000 ZeroMaterialPredictQty,	");
				sumsql.append("                sum(ZeroMaterialActualQty) / 1000 ZeroMaterialActualQty,	");
				sumsql.append("                sum(OneMaterialPredictQty) / 1000 OneMaterialPredictQty,	");
				sumsql.append("                sum(OneMaterialActualQty) / 1000 OneMaterialActualQty,	");
				sumsql.append("                sum(TwoMaterialPredictQty) / 1000 TwoMaterialPredictQty,	");
				sumsql.append("                sum(TwoMaterialActualQty) / 1000 TwoMaterialActualQty,	");
				sumsql.append("                sum(ThreeMaterialPredictQty) / 1000 ThreeMaterialPredictQty,	");
				sumsql.append("                sum(ThreeMaterialActualQty) / 1000 ThreeMaterialActualQty	");
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
				
				sumsql.append("          group by stoOrgName, batchName, towerName, currentDate	");
				sumsql.append("          order by stoOrgName, batchName, towerName, currentDate) tm	");
				
				sumsql.append("          	");
				sumsql.append("           left join T_IM_StockTransferBill tsb0 on to_char(tsb0.FBizDate,'yyyy-mm-dd') = to_char(tm.currentDate,'yyyy-mm-dd') and tsb0.FBaseStatus in('4','7') and tm.farmid = tsb0.FReceiptStorageOrgUnitID and tsb0.FIssueStorageOrgUnitID='at4AAAAACFnM567U' ");
				sumsql.append("          left join T_IM_StockTransferBillEntry tsbe0 on tsbe0.fparentid = tsb0.fid  and tm.towerID = tsbe0.Freceiptwarehouseid	");
				sumsql.append("          left join T_BD_Material tsbem0 on tsbe0.fmaterialid  = tsbem0.fid and tsbem0.fname_l2 like '%RJ-00%' ");
				sumsql.append("          group by tm.stoOrgName, tm.batchName, tm.towerName, tm.currentDate	");
				sumsql.append("          order by tm.stoOrgName, tm.batchName, tm.towerName, tm.currentDate	");
				sumsql.append("         	");
				sumsql.append("         	");
				sumsql.append("         ) tm0  	");
				
				
				sumsql.append("          	");
				sumsql.append("           left join T_IM_StockTransferBill tsb1 on to_char(tsb1.FBizDate,'yyyy-mm-dd') = to_char(tm0.currentDate,'yyyy-mm-dd') and tsb1.FBaseStatus in('4','7') and tm0.farmid = tsb1.FReceiptStorageOrgUnitID and tsb1.FIssueStorageOrgUnitID='at4AAAAACFnM567U' ");
				sumsql.append("          left join T_IM_StockTransferBillEntry tsbe1 on tsbe1.fparentid = tsb1.fid  and tm0.towerID = tsbe1.Freceiptwarehouseid	");
				sumsql.append("          left join T_BD_Material tsbem1 on tsbe1.fmaterialid  = tsbem1.fid and tsbem1.fname_l2 like '%RJ-01%' ");
				sumsql.append("          group by tm0.stoOrgName, tm0.batchName, tm0.towerName, tm0.currentDate	");
				sumsql.append("          order by tm0.stoOrgName, tm0.batchName, tm0.towerName, tm0.currentDate	");
				sumsql.append("         	");
				sumsql.append("         	");
				sumsql.append("         ) tmm 	");
				sumsql.append("         left join T_IM_StockTransferBill tsb2 on to_char(tsb2.FBizDate,'yyyy-mm-dd') = to_char(tmm.currentDate,'yyyy-mm-dd') and tsb2.FBaseStatus in('4','7') and tmm.farmid = tsb2.FReceiptStorageOrgUnitID and tsb2.FIssueStorageOrgUnitID='at4AAAAACFnM567U' ");
				sumsql.append(" 	");
				sumsql.append("          left join T_IM_StockTransferBillEntry tsbe2 on  tsbe2.fparentid = tsb2.fid    and tmm.towerID = tsbe2.Freceiptwarehouseid	");
				sumsql.append("          left join T_BD_Material tsbem2 on tsbe2.fmaterialid  = tsbem2.fid and tsbem2.fname_l2 like '%RJ-02%' ");
				sumsql.append("          group by tmm.stoOrgName, tmm.batchName, tmm.towerName, tmm.currentDate	");
				sumsql.append("          order by tmm.stoOrgName, tmm.batchName, tmm.towerName, tmm.currentDate) tmmm	");
				sumsql.append("          left join T_IM_StockTransferBill tsb3 on to_char(tsb3.FBizDate,'yyyy-mm-dd') = to_char(tmmm.currentDate,'yyyy-mm-dd') and tsb3.FBaseStatus in('4','7') and tmmm.farmid = tsb3.FReceiptStorageOrgUnitID	and tsb3.FIssueStorageOrgUnitID='at4AAAAACFnM567U' ");
				sumsql.append(" 	");
				sumsql.append("          left join T_IM_StockTransferBillEntry tsbe3 on  tsbe3.fparentid = tsb3.fid   and tmmm.towerID = tsbe3.Freceiptwarehouseid	");
				sumsql.append("          left join T_BD_Material tsbem3 on tsbe3.fmaterialid  = tsbem3.fid and tsbem3.fname_l2 like '%RJ-03%' ");
				sumsql.append("          group by tmmm.stoOrgName, tmmm.batchName, tmmm.towerName, tmmm.currentDate	");
				sumsql.append("          order by tmmm.stoOrgName, tmmm.batchName, tmmm.towerName, tmmm.currentDate) tmmmm	");
				sumsql.append("          group by tmmmm.currentDate	");
				sumsql.append("          order by tmmmm.currentDate ");
				
				IRowSet rs = DbUtil.executeQuery(ctx, sumsql.toString());
				System.out.println("查询结果结束：");
				System.out.println(new Date());
				return rs;
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
	 * 更新临时表 实际调拨数量
	 * @param temptable
	 * @throws BOSException 
	 */
	private void updateActualQty(Context ctx,String temptable) throws BOSException { 
		// 一号料
		StringBuilder upSql1 = new StringBuilder("/*dialect*/update ");
		upSql1.append(temptable);
		upSql1.append(" t set t.OneMaterialActualQty = (select sum(FBaseQty) from T_IM_StockTransferBillEntry tse inner join T_IM_StockTransferBill ts on tse.fparentid = ts.fid ");
		upSql1.append(" where to_char(ts.FBizDate,'yyyy-mm-dd') = to_char(t.currentDate,'yyyy-mm-dd') and tse.FReceiptWarehouseID = t.towerid and ts.FBaseStatus in('4','7') and tse.fmaterialid = t.OneMaterialID) ");
		DbUtil.execute(ctx, upSql1.toString());
		// 二号料
		upSql1 = new StringBuilder("/*dialect*/update ");
		
		upSql1.append(temptable);
		upSql1.append(" t set t.TwoMaterialActualQty = (select sum(FBaseQty) from T_IM_StockTransferBillEntry tse inner join T_IM_StockTransferBill ts on tse.fparentid = ts.fid ");
		upSql1.append(" where to_char(ts.FBizDate,'yyyy-mm-dd') = to_char(t.currentDate,'yyyy-mm-dd') and tse.FReceiptWarehouseID = t.towerid and ts.FBaseStatus in('4','7') and tse.fmaterialid = t.TwoMaterialID) ");
		// 三号料
		upSql1 = new StringBuilder("/*dialect*/update ");
		upSql1.append(temptable);
		upSql1.append(" t set t.ThreeMaterialActualQty = (select sum(FBaseQty) from T_IM_StockTransferBillEntry tse inner join T_IM_StockTransferBill ts on tse.fparentid = ts.fid ");
		upSql1.append(" where to_char(ts.FBizDate,'yyyy-mm-dd') = to_char(t.currentDate,'yyyy-mm-dd') and tse.FReceiptWarehouseID = t.towerid and ts.FBaseStatus in('4','7') and tse.fmaterialid = t.ThreeMaterialID) ");
		
		DbUtil.execute(ctx, upSql1.toString());
		
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
			sb.append(" te.cfhenhouseid,te.cfhenhouseName,th.fnumber henhouseNumber, ");
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
			List<String> entryHenhouseIDs = new ArrayList<String>();
			int currIncoopQty =0;
			int  currEntryDays;
			// 计数器
			int i = 0;
			while(rs.next()){
				
				String billID = rs.getString("billID");
				String entryID = rs.getString("entryID");
				String cfhenhouseid = rs.getString("cfhenhouseid");
				String henhouseNumber = rs.getString("henhouseNumber");
				String cfhenhouseName = rs.getString("cfhenhouseName");
				// 保存鸡舍信息
				stoBatchBean.setHenhouseID(cfhenhouseid);
				stoBatchBean.setHenhouseNumber(henhouseNumber);
				stoBatchBean.setHenhouseName(cfhenhouseName);
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
				
				if(cfincoopdate == null ){
					cfincoopdate = rs.getDate("billBizdate");
				}
				
				currEntryDateStr = sdf.format(cfincoopdate);
				entryHenhouseIDs = new ArrayList<String>();
				entryHenhouseIDs.add(cfhenhouseid);
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
			sb.append(" te.cfhenhouseid,te.cfhenhouseName,th.fnumber henhouseNumber, ");
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
//			String currEntryDateStr = "";
			List<String> entryHenhouseIDs = new ArrayList<String>();
//			int currIncoopQty =0;
//			int  currEntryDays;
			// 计数器
			int i = 0;
			while(rs.next()){
				
				String billID = rs.getString("billID");
				String entryID = rs.getString("entryID");
				String cfhenhouseid = rs.getString("cfhenhouseid");
				String henhouseNumber = rs.getString("henhouseNumber");
				String cfhenhouseName = rs.getString("cfhenhouseName");
				int cfinitqty = rs.getInt("cfinitqty");
				// 入栏日期
				Date cfincoopdate = rs.getDate("cfincoopdate");
				
				// 保存鸡舍信息
				stoBatchBean.setHenhouseID(cfhenhouseid);
				stoBatchBean.setHenhouseNumber(henhouseNumber);
				stoBatchBean.setHenhouseName(cfhenhouseName);
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
						cfinitqty
						);
//							batchEntryDetailBean.setPlan(true);
				batchDetailInfos.addAll(batchEntryDetailBeans);
			
				
				// 当前入栏日期指向 当前数据
//						currEntryInDate = cfincoopdate;
				
//				currEntryDateStr = sdf.format(cfincoopdate);
				entryHenhouseIDs = new ArrayList<String>();
				entryHenhouseIDs.add(cfhenhouseid);
				// 当前总入栏量等于当前行
//				currIncoopQty = cfinitqty;
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
			newRptBean.setPlanID(planID);
			
			newRptBean.setInhouseDate(incoopDate);
			newRptBean.setInhouseQty(qty);
			newRptBean.setCurrDateNum(i);
			newRptBean.setInhouseDate(incoopDate);
			newRptBean.setInhouseQty(incoopQty);
			newRptBean.setCurrDateNum(outDays);
			newRptBean.setDesc("");
			
			
			// 逐天匹配  匹配到的 根据当天分录明细设置 计算领料量 同时更新 存栏量
			BreedModelEntryInfo modelEntryInfo =  currentBreedModelDetails.get(Integer.valueOf(i));
			if(modelEntryInfo != null && modelEntryInfo.getMaterial() != null){
				MaterialInfo  modelEntryMaterial = modelEntryInfo.getMaterial();
				if(StringUtils.isBlank(modelEntryMaterial.getName())){
					modelEntryMaterial = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(modelEntryMaterial.getId()));
					modelEntryInfo.setMaterial(modelEntryMaterial);
					currentBreedModelDetails.put(Integer.valueOf(i), modelEntryInfo);
				}
				// 物料匹配 
//					if(currMaterial.getId().toString().equals(modelEntryMaterial.getId().toString())){
				// 批次 日死淘率
				BigDecimal dcRate = modelEntryInfo.getDailyDCRate();
				// 日饲喂量
				BigDecimal perQtyEveryone = modelEntryInfo.getQtyPerday();
				
				// 日总耗料
				BigDecimal perQtyAllday = perQtyEveryone.multiply(new BigDecimal(qty)).divide(new BigDecimal(1000),2,RoundingMode.HALF_UP);
				// 累计耗料
//						currTheoryQty = currTheoryQty.add(perQtyAllday);
				// 累加日理论耗料量
//				currTheoryQty = currTheoryQty.add(perQtyAllday);
				// 日死淘数量
				BigDecimal dayDCQty = ((new BigDecimal(qty)).multiply(dcRate)).divide(new BigDecimal(100),0,RoundingMode.HALF_UP);
				
				int dayDCQtyInt = dayDCQty.intValue();
				
				// 剩余数量
				qty = qty - dayDCQtyInt;
				
				prediDays ++;
//					}
//				}
				
				newRptBean.setPredictOuthouseDate(outcoopDate);
				newRptBean.setPredictOuthouseQty(qty);
				
				// 获得 鸡舍过滤条件
//				String henhouseIDStr = getHenhouseStr(henhouseIDs);
				// 物料的实际饲喂量 和饲喂天数
//				BigDecimal actualQty = new BigDecimal("0.00");
//				int actualDays  = 0;
				// 获取实际饲喂量
//				String materialName = BREED_CONSTANTS.CC_RJ01;
//					if(m ==1) materialName = BREED_CONSTANTS.CC_RJ01;
//					if(m ==2) materialName = BREED_CONSTANTS.CC_RJ02;
//					if(m ==3) materialName = BREED_CONSTANTS.CC_RJ03;
				
				// 当前物料理论饲喂量 设置到  结果集中 TODO 此处如果存在list或map会灵活~~~
				if(modelEntryMaterial.getName().indexOf(BREED_CONSTANTS.CC_RJ00) >= 0){
					newRptBean.setZeroMaterialID(modelEntryMaterial.getId().toString());
					newRptBean.setZeroMaterialName(modelEntryMaterial.getName());
					newRptBean.setZeroMaterialNumber(modelEntryMaterial.getNumber());
					newRptBean.setZeroMaterialPredictDays(prediDays);
					newRptBean.setOneMaterialPredictQty(perQtyAllday);
				}else if(modelEntryMaterial.getName().indexOf(BREED_CONSTANTS.CC_RJ01) >= 0){
					newRptBean.setOneMaterialID(modelEntryMaterial.getId().toString());
					newRptBean.setOneMaterialName(modelEntryMaterial.getName());
					newRptBean.setOneMaterialNumber(modelEntryMaterial.getNumber());
					newRptBean.setOneMaterialPredictDays(prediDays);
					newRptBean.setOneMaterialPredictQty(perQtyAllday);
				}else if(modelEntryMaterial.getName().indexOf(BREED_CONSTANTS.CC_RJ02) >= 0){
					newRptBean.setTwoMaterialID(modelEntryMaterial.getId().toString());
					newRptBean.setTwoMaterialName(modelEntryMaterial.getName());
					newRptBean.setTwoMaterialNumber(modelEntryMaterial.getNumber());
					newRptBean.setTwoMaterialPredictDays(prediDays);
					newRptBean.setTwoMaterialPredictQty(perQtyAllday);
				}else if(modelEntryMaterial.getName().indexOf(BREED_CONSTANTS.CC_RJ03) >= 0){
					newRptBean.setThreeMaterialID(modelEntryMaterial.getId().toString());
					newRptBean.setThreeMaterialName(modelEntryMaterial.getName());
					newRptBean.setThreeMaterialNumber(modelEntryMaterial.getNumber());
					newRptBean.setThreeMaterialPredictDays(prediDays);
					newRptBean.setThreeMaterialPredictQty(perQtyAllday);
				}
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
		
		// 获取对应批次 在过滤日期前的养殖状态和所处日龄，过滤日期前的饲喂量 取调拨数量，饲喂日期后的取 实际计算的理论数量
		
		for(int m = 0; m < currentBreedMaterials.size(); m++){
			MaterialInfo currMaterial = currentBreedMaterials.get(Integer.valueOf(m));
			if(StringUtils.isBlank(currMaterial.getName())){
				currMaterial = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(currMaterial.getId()));
				currentBreedMaterials.put(Integer.valueOf(m), currMaterial);
			}
			// 料号 总耗料
			BigDecimal currTheoryQty = new BigDecimal("0.00");
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
				if(qty <= 0){
					continue;
				}
				// 逐天匹配  匹配到的 根据当天分录明细设置 计算领料量 同时更新 存栏量
				BreedModelEntryInfo modelEntryInfo =  currentBreedModelDetails.get(Integer.valueOf(i));
				if(modelEntryInfo != null && modelEntryInfo.getMaterial() != null){
					
					MaterialInfo  modelEntryMaterial = modelEntryInfo.getMaterial();
					// 物料匹配 
					if(currMaterial.getId().toString().equals(modelEntryMaterial.getId().toString())){
						
						CCProductPlanRptBean newRptBean = new CCProductPlanRptBean();
						newRptBean.setStoOrgID(stoBatchInfo.getStoOrgID());
						newRptBean.setStoOrgName(stoBatchInfo.getStoOrgName());
						newRptBean.setStoOrgNumber(stoBatchInfo.getStoOrgNumber());
						
						newRptBean.setBatchID(batchID);
						newRptBean.setBatchEntryIDs(stoBatchInfo.getBatchEntryIDs());
						newRptBean.setBatchName(stoBatchInfo.getBatchName());
						newRptBean.setBatchNumber(stoBatchInfo.getBatchNumber());
						
						newRptBean.setCostObjectID(stoBatchInfo.getCostObjectID());
						
						newRptBean.setInhouseDate(incoopDate);
						newRptBean.setInhouseQty(qty);
						newRptBean.setCurrDateNum(i);
						
						newRptBean.setHenhouseID(stoBatchInfo.getHenhouseID());
						newRptBean.setHenhouseNumber(stoBatchInfo.getHenhouseNumber());
						newRptBean.setHenhouseName(stoBatchInfo.getHenhouseName());
												
						newRptBean.setTowerID(stoBatchInfo.getTowerID());
						newRptBean.setTowerNumber(stoBatchInfo.getTowerNumber());
						newRptBean.setTowerName(stoBatchInfo.getTowerName());
						
						
						newRptBean.setDesc("");
						
						// 设置计算日期
						newRptBean.setCurrentDate(currDate);
						
						// 批次 日死淘率
						BigDecimal dcRate = modelEntryInfo.getDailyDCRate();
						// 日饲喂量
						BigDecimal perQtyEveryone = modelEntryInfo.getQtyPerday();
						
						// 日总耗料
						BigDecimal perQtyAllday = perQtyEveryone.multiply(new BigDecimal(qty)).divide(new BigDecimal(1000),2,RoundingMode.HALF_UP);
						// 累计耗料
//						currTheoryQty = currTheoryQty.add(perQtyAllday);
						// 累加日理论耗料量
//						currTheoryQty = currTheoryQty.add(perQtyAllday);
						// 日死淘数量
						BigDecimal dayDCQty = ((new BigDecimal(qty)).multiply(dcRate)).divide(new BigDecimal(100),0,RoundingMode.HALF_UP);
						
						int dayDCQtyInt = dayDCQty.intValue();
						
						// 剩余数量
						qty = qty - dayDCQtyInt;
						
						prediDays ++;
						
						
						
						
						// 物料的实际饲喂量 和饲喂天数
						BigDecimal actualQty = new BigDecimal("0.00");
						int actualDays  = 0;
						// 获取实际饲喂量
						String materialName = BREED_CONSTANTS.CC_RJ01;
						if(m ==1) materialName = BREED_CONSTANTS.CC_RJ01;
						if(m ==2) materialName = BREED_CONSTANTS.CC_RJ02;
						if(m ==3) materialName = BREED_CONSTANTS.CC_RJ03;
						// 设置实际数据
//						setOuthouseDays(ctx,newRptBean,m,batchID,materialName,henhouseIDStr);
						
						// 当前物料理论饲喂量 设置到  结果集中TODO 此处如果存在list或map会灵活~~~
						if(m == 0){
							newRptBean.setZeroMaterialID(currMaterial.getId().toString());
							newRptBean.setZeroMaterialName(currMaterial.getName());
							newRptBean.setZeroMaterialNumber(currMaterial.getNumber());
							newRptBean.setZeroMaterialPredictDays(prediDays);
							newRptBean.setZeroMaterialPredictQty(perQtyAllday);
						}else if(m == 1){
							newRptBean.setOneMaterialID(currMaterial.getId().toString());
							newRptBean.setOneMaterialName(currMaterial.getName());
							newRptBean.setOneMaterialNumber(currMaterial.getNumber());
							newRptBean.setOneMaterialPredictDays(prediDays);
							newRptBean.setOneMaterialPredictQty(perQtyAllday);
						}else if(m == 2){
							newRptBean.setTwoMaterialID(currMaterial.getId().toString());
							newRptBean.setTwoMaterialName(currMaterial.getName());
							newRptBean.setTwoMaterialNumber(currMaterial.getNumber());
							newRptBean.setTwoMaterialPredictDays(prediDays);
							newRptBean.setTwoMaterialPredictQty(perQtyAllday);
						}else if(m == 3){
							newRptBean.setThreeMaterialID(currMaterial.getId().toString());
							newRptBean.setThreeMaterialName(currMaterial.getName());
							newRptBean.setThreeMaterialNumber(currMaterial.getNumber());
							newRptBean.setThreeMaterialPredictDays(prediDays);
							newRptBean.setThreeMaterialPredictQty(perQtyAllday);
						}
						
						
						// 如果日期 过滤日期范围内则添加到结果集中
						if(currDate.before(filterBeginDate) || currDate.after(filterEndDate)) continue;
						// 计算结果 存放到结果集中
						resutlRptBeans.add(newRptBean);
					}
				}
			}
			
		}

		return resutlRptBeans;
	}
	
	
	
	/**
	 * 批次饲喂明细，按天合计 当批次鸡 能吃饲料量
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
	private List<CCProductPlanRptBean> getBatchDetailFodders(Context ctx,CCProductPlanRptBean stoBatchInfo, String batchID,Date incoopDate,Date outcoopDate,int incoopQty,List<String> henhouseIDs) throws EASBizException, BOSException, SQLException{
		long timeLong = outcoopDate.getTime()-incoopDate.getTime();
		long days = timeLong / (1000 * 60 * 60 * 24);
		int outDays = (new Long(days)).intValue();
		
		
		List<CCProductPlanRptBean> result = new ArrayList<CCProductPlanRptBean>();
		

		
		
//		newRptBean.set
		// 根据料号 从小到大 逐个循环  计算用料量，同事 鸡只数量逐渐 减少
		// 数量
		int qty = incoopQty;
		
//		for(int m = 1; m <= currentBreedMaterials.size(); m++){
//			MaterialInfo currMaterial = currentBreedMaterials.get(Integer.valueOf(m));
//			if(StringUtils.isBlank(currMaterial.getName())){
//				currMaterial = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(currMaterial.getId()));
//				
//			}
			// 料号 总耗料
//			BigDecimal currTheoryQty = new BigDecimal("0.00");
			// 理论饲喂天数
//			int prediDays = 0;
		// 记录当前计算日期的 时间戳
		Calendar currCal = Calendar.getInstance();
			for(int i = 1; i <= days; i++){
				
				currCal.setTime(incoopDate);
				currCal.add(Calendar.DATE, i);
				
				// 获取当前循环到的日期
				Date currDate = currCal.getTime();
				// 逐天匹配  匹配到的 根据当天分录明细设置 计算领料量 同时更新 存栏量
				BreedModelEntryInfo modelEntryInfo =  currentBreedModelDetails.get(Integer.valueOf(i));
				if(modelEntryInfo != null && modelEntryInfo.getMaterial() != null){
					MaterialInfo  modelEntryMaterial = modelEntryInfo.getMaterial();
					
					
					CCProductPlanRptBean newRptBean = new CCProductPlanRptBean();
					newRptBean.setStoOrgID(stoBatchInfo.getStoOrgID());
					newRptBean.setStoOrgName(stoBatchInfo.getStoOrgName());
					newRptBean.setStoOrgNumber(stoBatchInfo.getStoOrgNumber());
					
					newRptBean.setBatchID(batchID);
					newRptBean.setBatchEntryIDs(stoBatchInfo.getBatchEntryIDs());
					newRptBean.setBatchName(stoBatchInfo.getBatchName());
					newRptBean.setBatchNumber(stoBatchInfo.getBatchNumber());
					
					newRptBean.setCostObjectID(stoBatchInfo.getCostObjectID());
					
					newRptBean.setInhouseDate(incoopDate);
					newRptBean.setInhouseQty(incoopQty);
					newRptBean.setCurrDateNum(outDays);
					newRptBean.setCurrentDate(currDate);
					newRptBean.setDesc("");
					
					// 物料名称如果为空 则加载物料
					if(StringUtils.isNotBlank(modelEntryMaterial.getName())){
						modelEntryMaterial = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(modelEntryMaterial.getId()));
					}
					// 物料匹配 
//					if(currMaterial.getId().toString().equals(modelEntryMaterial.getId().toString())){
						// 批次 日死淘率
					BigDecimal dcRate = modelEntryInfo.getDailyDCRate();
					// 日饲喂量
					BigDecimal perQtyEveryone = modelEntryInfo.getQtyPerday();
					
					// 日总耗料
					BigDecimal perQtyAllday = perQtyEveryone.multiply(new BigDecimal(qty)).divide(new BigDecimal(1000),2,RoundingMode.HALF_UP);
					// 累计耗料
//						currTheoryQty = currTheoryQty.add(perQtyAllday);
					// 累加日理论耗料量
//						currTheoryQty = currTheoryQty.add(perQtyAllday);
					// 日死淘数量
					BigDecimal dayDCQty = ((new BigDecimal(qty)).multiply(dcRate)).divide(new BigDecimal(100),0,RoundingMode.HALF_UP);
					
					int dayDCQtyInt = dayDCQty.intValue();
					
					// 剩余数量
					qty = qty - dayDCQtyInt;
					
//						prediDays ++;
					
					

					newRptBean.setPredictOuthouseDate(outcoopDate);
					newRptBean.setPredictOuthouseQty(qty);
					
					// 获得 鸡舍过滤条件
					String henhouseIDStr = getHenhouseStr(henhouseIDs);
					// 物料的实际饲喂量 和饲喂天数
					BigDecimal actualQty = new BigDecimal("0.00");
					int actualDays  = 0;
					// 获取实际饲喂量
					String materialName = BREED_CONSTANTS.CC_RJ01;
					
					// 设置实际数据
//						setOuthouseDays(ctx,newRptBean,m,batchID,materialName,henhouseIDStr);
					
					// 当前物料理论饲喂量 设置到  结果集中TODO 此处如果存在list或map会灵活~~~
					if(modelEntryMaterial.getName().indexOf(BREED_CONSTANTS.CC_RJ01) >= 0){
						newRptBean.setOneMaterialID(modelEntryMaterial.getId().toString());
						newRptBean.setOneMaterialName(modelEntryMaterial.getName());
						newRptBean.setOneMaterialNumber(modelEntryMaterial.getNumber());
//							newRptBean.setOneMaterialPredictDays(prediDays);
						newRptBean.setOneMaterialPredictQty(perQtyAllday);
					}else if(modelEntryMaterial.getName().indexOf(BREED_CONSTANTS.CC_RJ02) >= 0){
						newRptBean.setTwoMaterialID(modelEntryMaterial.getId().toString());
						newRptBean.setTwoMaterialName(modelEntryMaterial.getName());
						newRptBean.setTwoMaterialNumber(modelEntryMaterial.getNumber());
//							newRptBean.setTwoMaterialPredictDays(prediDays);
						newRptBean.setTwoMaterialPredictQty(perQtyAllday);
					}else if(modelEntryMaterial.getName().indexOf(BREED_CONSTANTS.CC_RJ03) >= 0){
						newRptBean.setThreeMaterialID(modelEntryMaterial.getId().toString());
						newRptBean.setThreeMaterialName(modelEntryMaterial.getName());
						newRptBean.setThreeMaterialNumber(modelEntryMaterial.getNumber());
//							newRptBean.setThreeMaterialPredictDays(prediDays);
						newRptBean.setThreeMaterialPredictQty(perQtyAllday);
					}
					
					// 如果日期 过滤日期范围内则添加到结果集中
					if(currDate.before(filterBeginDate) || currDate.after(filterEndDate)) continue;
					// 添加到结果集中
					result.add(newRptBean);
				}
				
			}
			
		
		
		
//		// 获得期间天数
//		for(int i = 1; i <= days; i++){
//			
//		}
		
		return result;
	}
	/**
	 * 设置实际喂料量、饲喂时长、实际出栏时间、实际出栏量
	 * @param ctx
	 * @param batchID
	 * @param materialNames
	 * @param henhouseIDs
	 * @return
	 * @throws BOSException 
	 * @throws SQLException 
	 */
	private CCProductPlanRptBean setOuthouseDays(Context ctx,CCProductPlanRptBean newRptBean,int mNum, String batchID, String materialName,String henhouseIDs) throws BOSException, SQLException{
		// 实际喂料量
		BigDecimal actualFeedQty = new BigDecimal("0");
		// 实际饲喂日长
		int actualDays = 0;
		// 实际出栏量
		int actualOutQty = 0;
		// 实际出栏日期
		Date actualOutDate = null;
		
		if(StringUtils.isNotBlank(batchID)){
			StringBuilder sb  =  new StringBuilder();
			sb.append("select sum(te.CFDailyQtyAll) qty ");
			sb.append(" from  CT_FM_CommecialChilkenDaily t inner join CT_FM_CommecialCDE te on t.fid = te.fparentid ");
			sb.append(" inner join t_bd_material tm on te.cfmaterialid = tm.fid ");
			sb.append(" where t.CFBreedBatchID =? and tm.fname_l2 like '%");
			sb.append(materialName);
			sb.append("%' and te.CFHenhouseID in ");
			sb.append(henhouseIDs);
			
			Object[] args = {batchID};
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString(),args);
			
			if(rs.next()){
				actualFeedQty = rs.getBigDecimal("qty");
	//			 actualDays = rs.getInt("days");
			}
			// 获取实际饲喂天数
			sb  =  new StringBuilder();
			sb.append("select count(distinct t.fbizdate) days ");
			sb.append(" from  CT_FM_CommecialChilkenDaily t inner join CT_FM_CommecialCDE te on t.fid = te.fparentid ");
			sb.append(" inner join t_bd_material tm on te.cfmaterialid = tm.fid ");
			sb.append(" where t.CFBreedBatchID =? and tm.fname_l2 like '%");
			sb.append(materialName);
			sb.append("%' and te.CFHenhouseID in ");
			sb.append(henhouseIDs);
			
			String[] args1 = {batchID};
			rs = DbUtil.executeQuery(ctx, sb.toString(),args1);
			if(rs.next()){
				 
				 actualDays = rs.getInt("days");
			}
			
			// 获取实际出栏日期
			sb  =  new StringBuilder();
			sb.append("select min(t.fbizdate) outDate ");
			sb.append(" from  CT_FM_CommecialChilkenDaily t inner join CT_FM_CommecialCDAE te on t.fid = te.fparentid ");
	//		sb.append(" inner join t_bd_material tm on te.cfmaterialid = tm.fid ");
			sb.append(" where (te.CFIsMarketed = 1 or(te.CFMarketQty > 0 and te.CFBreedingStock=0))  and  t.CFBreedBatchID =? ");
	//		sb.append(materialName);
			sb.append(" and te.CFHenhouseID in ");
			sb.append(henhouseIDs);
			
			String[] args3 = {batchID};
			rs = DbUtil.executeQuery(ctx, sb.toString(),args3);
			Date outDate = null;
			if(rs.next()){
				 
				outDate = rs.getDate("outDate");
			}
			newRptBean.setActualOuthouseDate(outDate);
			
			
			// 获取实际出栏量
			sb  =  new StringBuilder();
			sb.append("select sum(te.CFMarketQty) outQty ");
			sb.append(" from  CT_FM_CommecialChilkenDaily t inner join CT_FM_CommecialCDAE te on t.fid = te.fparentid ");
	//		sb.append(" inner join t_bd_material tm on te.cfmaterialid = tm.fid ");
			sb.append(" where t.CFBreedBatchID =? ");
	//		sb.append(materialName);
			sb.append(" and te.CFHenhouseID in ");
			sb.append(henhouseIDs);
			
			String[] args2 = {batchID};
			rs = DbUtil.executeQuery(ctx, sb.toString(),args2);
			if(rs.next()){
				 
				 actualOutQty = rs.getInt("outQty");
			}
			// 实际出栏量
			newRptBean.setActualOuthouseQty(actualOutQty);
			// 当前物料理论饲喂量 设置到  结果集中TODO 此处如果存在list或map会灵活~~~
			if(mNum == 0){
				
				newRptBean.setZeroMaterialActualDays(actualDays);
				newRptBean.setZeroMaterialActualQty(actualFeedQty);
			}else if(mNum == 1){
				
				newRptBean.setOneMaterialActualDays(actualDays);
				newRptBean.setOneMaterialActualQty(actualFeedQty);
			}else if(mNum == 2){
			
				newRptBean.setTwoMaterialActualDays(actualDays);
				newRptBean.setTwoMaterialActualQty(actualFeedQty);
			}else if(mNum == 3){
				
				newRptBean.setThreeMaterialActualDays(actualDays);
				newRptBean.setThreeMaterialActualQty(actualFeedQty);
			}
		}
		return newRptBean;
	}
	/**
	 * 获得指定 列表的鸡舍id的过滤条件  （'','','')
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
	 */
	private void addToCurrBreedMaterials(MaterialInfo currMaterial) {
		if(this.currentBreedMaterials == null) currentBreedMaterials = new HashMap<Integer, MaterialInfo>();
		int i = currentBreedMaterials.size() ;
		
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
		 sql.append(ccBean.getTowerID());
		 sql.append("','");
		 sql.append(ccBean.getTowerNumber());
		 sql.append("','");
		 sql.append(ccBean.getTowerName());
		
		 sql.append("',{ts'");
		 sql.append(sdf.format(ccBean.getInhouseDate()));
		 sql.append("'},");
		 sql.append(ccBean.getCurrDateNum());
		 sql.append(",");
		 sql.append(ccBean.getInhouseQty());
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
		 sql.append(ccBean.getZeroMaterialID());
		 sql.append("','");
		 sql.append(ccBean.getZeroMaterialNumber());
		 sql.append("','");
		 sql.append(ccBean.getZeroMaterialName());
		 sql.append("',");
		 sql.append(ccBean.getZeroMaterialPredictDays());
		 sql.append(",");
		 sql.append(ccBean.getZeroMaterialActualDays());
		 sql.append(",");
		 sql.append(ccBean.getZeroMaterialPredictQty().toPlainString());
		 sql.append(",");
		 sql.append(ccBean.getZeroMaterialActualQty().toPlainString());
		 sql.append(",'");
		 
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
	  sql.append(" stoOrgName nVARCHAR(80), \r\n");
	  
	  sql.append(" isPlan varchar(2), \r\n");
	  
	  sql.append(" batchID varchar(44), \r\n");
	  sql.append(" batchNumber varchar(44), \r\n");
	  sql.append(" batchName VARCHAR(80), \r\n");
	  
	  sql.append(" henhouseID VARCHAR(44), \r\n");
	  sql.append(" henhouseNumber VARCHAR(44), \r\n");
	  sql.append(" henhouseName nVARCHAR(80), \r\n");
	  
	  sql.append(" towerID VARCHAR(44), \r\n");
	  sql.append(" towerNumber VARCHAR(44), \r\n");
	  sql.append(" towerName nVARCHAR(80), \r\n");
	 
	  
	  sql.append(" inhouseDate DATETIME, \r\n");
	  sql.append(" currDateNum int, \r\n");
	  sql.append(" inhouseQty int, \r\n");
	  sql.append(" predictOuthouseDate DATETIME, \r\n");
	  sql.append(" predictOuthouseQty int, \r\n");
	  sql.append(" actualOuthouseDate DATETIME, \r\n");
	  sql.append(" actualOuthouseQty int, \r\n");
	  
	  sql.append(" currentDate DATETIME, \r\n");
	  
	  sql.append(" ZeroMaterialID VARCHAR(44), \r\n");
	  sql.append(" ZeroMaterialNumber VARCHAR(44), \r\n");
	  sql.append(" ZeroMaterialName VARCHAR(80), \r\n");
	  sql.append(" ZeroMaterialPredictDays int, \r\n");
	  sql.append(" ZeroMaterialActualDays int, \r\n");
	  sql.append(" ZeroMaterialPredictQty DECIMAL(28,10), \r\n");
	  sql.append(" ZeroMaterialActualQty DECIMAL(28,10), \r\n");
	  
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