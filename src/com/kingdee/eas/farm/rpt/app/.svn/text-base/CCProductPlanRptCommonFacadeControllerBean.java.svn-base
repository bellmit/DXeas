package com.kingdee.eas.farm.rpt.app;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.BreedModelEntryCollection;
import com.kingdee.eas.farm.breed.BreedModelEntryFactory;
import com.kingdee.eas.farm.breed.BreedModelEntryInfo;
import com.kingdee.eas.farm.breed.BreedModelFactory;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.jdbc.rowset.IRowSet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.HashMap;

public class CCProductPlanRptCommonFacadeControllerBean extends AbstractCCProductPlanRptCommonFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.rpt.app.CCProductPlanRptCommonFacadeControllerBean");
    
    

	/**
	 * 获得 符合条件的 养殖场设置到 结果集
	 * @param param
	 * @return
	 * @throws BOSException 
	 */
    @Override
	public List<CCProductPlanRptBean> getRptBeanStorageInfos(Context ctx,HashMap param) throws BOSException{
		// 养殖场
		String orgID = (String) param.get("stoOrgID");
		
		List<CCProductPlanRptBean> rptBeans = new ArrayList<CCProductPlanRptBean>();
		
		StringBuffer ssb  = new StringBuffer("select t.CFStoOrgID,max(ts.fnumber) stoOrgNumber,max(ts.fname_l2) stoOrgName from CT_FM_BreedStoorgSet t inner join t_org_storage ts on t.CFStoOrgID = ts.fid ");
//		ssb.append(" left join CT_FM_BreedBatch tb on ts.fid = tb.CFStoOrgID ");
		ssb.append(" where t.CFHenhouseType='3'  and CFStatus = 1 ");
		if(StringUtils.isNotBlank(orgID)){
			ssb.append(" and t.CFStoOrgID='");
			ssb.append(orgID);
			ssb.append("' ");
		}
		ssb.append(" group by t.CFStoOrgID ");
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, ssb.toString());
			while(rs.next()){
				String stoOrgID = rs.getString("CFStoOrgID");
				String stoOrgNumber = rs.getString("stoOrgNumber");
				String stoOrgName = rs.getString("stoOrgName");
				
				CCProductPlanRptBean bean = new CCProductPlanRptBean();
				bean.setStoOrgID(stoOrgID);
				bean.setStoOrgNumber(stoOrgNumber);
				bean.setStoOrgName(stoOrgName);
				
				rptBeans.add(bean);
			}
		}catch(SQLException sqle){
			throw new BOSException(sqle);
		}
		return rptBeans;
	}
	
    
    
    /**
     *     
	 * 获得养殖计划信息,排除和已经在养的批次的交叉部分，及 计划已经开始执行的部分  排除在外
	 * 饲料量  取理论数量  
     * @param ctx
     * @param ccRptBean 包含 养殖场库存信息的  bean
     * @param inValidPlanIDs 已经失效的 计划id列表
     * @param filterBeginDate 过滤开始日期
     * @param filterEndDate 过滤结束日期
     * @param breedDays 养殖周期
     * @return
     * @throws BOSException
     * @throws SQLException
     */
	public List<CCProductPlanRptBean> getStoorgPlanInfo(Context ctx,
			CCProductPlanRptBean ccRptBean,
			List inValidPlanIDs,
			Date filterBeginDate,
			Date filterEndDate,
			int breedDays) throws BOSException{
		
		// 默认养殖周期
//		int preBreedDays = this.currentBreedModel.getBreedDays();

		List<CCProductPlanRptBean> plans = new ArrayList<CCProductPlanRptBean>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder ssb = new StringBuilder();
		
		String batchPlanID = "";
		if(inValidPlanIDs != null && inValidPlanIDs.size() > 0){
			batchPlanID = AppCommon.getIDRangeStr(inValidPlanIDs);
			
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(filterBeginDate);
		cal.add(Calendar.DATE, -breedDays);
		Date filterLowDate = cal.getTime();
		
		// 获得养殖计划 数据
		StringBuilder sql = new StringBuilder(" select distinct t.fid,t.fnumber from CT_FM_CCBreedPlan t ");
		sql.append(" inner join CT_FM_CCBreedPlanEntry te on t.fid = te.fparentid ");
		sql.append(" where t.CFStoOrgID = '");
		
		sql.append(ccRptBean.getStoOrgID());
		sql.append("' and  te.cfincoopdate >= {ts'");
		sql.append(sdf.format(filterLowDate));
		
		sql.append("'} ");
		sql.append(" and  te.cfincoopdate <= {ts'");
		sql.append(sdf.format(filterEndDate));
		
		sql.append("'} ");
		if(StringUtils.isNotBlank(batchPlanID)){
			sql.append(" and t.fid not in ");
			sql.append(batchPlanID);
		}
		
		IRowSet rs1 = DbUtil.executeQuery(ctx, sql.toString());
		
		try{
			while(rs1.next()){
				String fid = rs1.getString("fid");
				String fnumber = rs1.getString("fnumber");
				
				CCProductPlanRptBean newRptBean = new CCProductPlanRptBean();
				
				newRptBean.setStoOrgID(ccRptBean.getStoOrgID());
				newRptBean.setStoOrgName(ccRptBean.getStoOrgName());
				newRptBean.setStoOrgNumber(ccRptBean.getStoOrgNumber());
				
				newRptBean.setPlan(true);
				newRptBean.setBatchID(fid);
				newRptBean.setPlanID(fid);
				newRptBean.setBatchNumber(fnumber);
				newRptBean.setBatchName("入栏计划："+fnumber);
				plans.add(newRptBean);
			}
		}catch(SQLException sqle){
			throw new BOSException(sqle);
		}
		
		
		return plans;
	}
	
	

	/**
	 * 获得养殖批次信息,
	 * 
	 * @param ccRptBean
	 * @param filterBeginDate
	 * @param filterEndDate 
	 * @param breedDays 
	 * @return
	 * @throws BOSException 
	 * @throws SQLException 
	 */
	public List<CCProductPlanRptBean> getStoorgBatchInfo(Context ctx,
			CCProductPlanRptBean ccRptBean,
			Date filterBeginDate,
			Date filterEndDate,
			int breedDays) throws BOSException{
		
		// 默认养殖周期
//		int preBreedDays = this.currentBreedModel.getBreedDays();
		
		List<CCProductPlanRptBean> batchs = new ArrayList<CCProductPlanRptBean>();
		
		// 取开始日期前的最后一次日报批次
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(filterBeginDate);
		cal.add(Calendar.DATE, -breedDays);
		Date filterLowDate = cal.getTime();
		
		try
		{
			// 取开始日期前推养殖日龄天数的日期到结束日期 内 入栏的养殖批次
			StringBuilder sql = new StringBuilder(" select distinct t.fid batchID,t.CFBREEDPLANID,t.fnumber batchNumber,tbc.fid costObjectID,tbc.fname_l2 batchName from CT_FM_BreedBatch t ");
			sql.append(" inner join CT_FM_BreedBatchEntry te on t.fid = te.fparentid ");
			sql.append(" inner join T_BD_CostObject tbc on t.CFCostObjectID = tbc.fid ");
			sql.append(" where t.CFStoOrgID = '");
			
			sql.append(ccRptBean.getStoOrgID());
			sql.append("' and  te.cfincoopdate >= {ts'");
			sql.append(sdf.format(filterLowDate));
			
			sql.append("'} ");
			sql.append(" and  te.cfincoopdate <= {ts'");
			sql.append(sdf.format(filterEndDate));
			
			sql.append("'} ");

			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				String batchID = rs.getString("batchID");
				String planID = rs.getString("CFBREEDPLANID");
				String batchNumber = rs.getString("batchNumber");
				String batchName = rs.getString("batchName");
				String costObjectID = rs.getString("costObjectID");
				
				// 判断对应批次是否已经完全出栏，如果完全出栏  则 跳到 设置 计划 逻辑
				CCProductPlanRptBean ccBean = new CCProductPlanRptBean();
				ccBean.setStoOrgID(ccRptBean.getStoOrgID());
				ccBean.setStoOrgName(ccRptBean.getStoOrgName());
				ccBean.setStoOrgNumber(ccRptBean.getStoOrgNumber());
				
				// 设置批次信息
				ccBean.setPlan(false);
				ccBean.setBatchID(batchID);
				ccBean.setPlanID(planID);
				ccBean.setBatchNumber(batchNumber);
				ccBean.setBatchName("养殖批次："+batchName);
				ccBean.setCostObjectID(costObjectID);
			
				batchs.add(ccBean);
			}
			
			/** 取 指定时间段内填报过日报的批次*
			// 取在过滤时间段内 填报过日报的批次
			StringBuilder ssb = new StringBuilder();
			ssb.append(" select  t.cfstoorgid stoorgID, t.CFBreedBatchID batchID, ");
		    ssb.append(" max(t.fbizdate) bizdate , sum(te.CFBreedingStock) breedingStock , ");
		    ssb.append(" max(tbb.fnumber) batchNumber,max(tbc.fname_l2) batchName, max(tbb.CFCostObjectID) costObjectID ");
		    
		    ssb.append(" from  ct_fm_commecialchilkendaily t ");
			ssb.append(" inner join CT_FM_CommecialCDAE te on t.fid = te.fparentid ");
			ssb.append(" inner join CT_FM_BreedBatch tbb on t.CFBreedBatchID = tbb.fid ");
			ssb.append(" inner join T_BD_CostObject tbc on tbb.CFCostObjectID = tbc.fid ");
			ssb.append(" where  ");
			ssb.append(" t.fbizdate >= {ts'");
			ssb.append(sdf.format(filterBeginDate));
			ssb.append("'} and  t.fbizdate <= {ts'");
			ssb.append(sdf.format(filterEndDate));
			
			ssb.append("'} and  t.cfstoorgid='");
			ssb.append(ccRptBean.getStoOrgID());
			
			ssb.append("' group by t.cfstoorgid,t.CFBreedBatchID ");
			ssb.append(" order by bizdate desc,breedingStock asc ");
		    
		    
			
			IRowSet rs = DbUtil.executeQuery(ctx, ssb.toString());
			while(rs.next()){
				// 判断 对应
				int breedingStock = rs.getInt("breedingStock");
//				if(breedingStock > 0){
					
					String batchID = rs.getString("batchID");
					String batchNumber = rs.getString("batchNumber");
					String batchName = rs.getString("batchName");
					String costObjectID = rs.getString("costObjectID");
					
					// 判断对应批次是否已经完全出栏，如果完全出栏  则 跳到 设置 计划 逻辑
					CCProductPlanRptBean ccBean = new CCProductPlanRptBean();
					ccBean.setStoOrgID(ccRptBean.getStoOrgID());
					ccBean.setStoOrgName(ccRptBean.getStoOrgName());
					ccBean.setStoOrgNumber(ccRptBean.getStoOrgNumber());
					
					// 设置批次信息
					ccBean.setPlan(false);
					ccBean.setBatchID(batchID);
					ccBean.setBatchNumber(batchNumber);
					ccBean.setBatchName("养殖批次："+batchName);
					ccBean.setCostObjectID(costObjectID);
				
					batchs.add(ccBean);
					
					
//				}
				
				
			}
		*/
		}catch(SQLException sqle){
			throw new BOSException(sqle);
		}
		return batchs;
		
		
	}
	
	/**
	 * 获取当前养殖规范
	 * @param ctx
	 * @return
	 * @throws BOSException 
	 * @throws SQLException 
	 * @throws EASBizException 
	 */
	public BreedModelInfo getCurrentBreedModelInfo(Context ctx,HenhouseType houseType) throws BOSException{
		String  sql = "select fid from CT_FM_BreedModel where CFHouseType = '" + houseType.getValue() +"' and CFDeletedStatus = 1 ";
		IRowSet rs = DbUtil.executeQuery(ctx, sql);
		if(rs.size() > 1){
			throw new BOSException("当前启用的鸡养殖规范数多于一条，请将多于规范禁用后再查询");
		}else if(rs.size() == 0){
			throw new BOSException("没有启用的养殖规范");
		}else{
			try{
				// 读取数据
				rs.next();
				String fid = rs.getString("fid");
				
				BreedModelInfo currentBreedModel = BreedModelFactory.getLocalInstance(ctx).getBreedModelInfo(new ObjectUuidPK(fid));
				
	//			BreedModelEntryCollection entryCol = currentBreedModel.getEntrys();
	//			try{
	//				if(entryCol != null && entryCol.size() > 0){
	//					if(currentBreedModelDetails == null){
	//						currentBreedModelDetails = new HashMap<Integer, BreedModelEntryInfo>();
	//					}
	//					for(int i =0; i < entryCol.size(); i++){
	//						BreedModelEntryInfo entryInfo = entryCol.get(i);
	//						entryInfo = BreedModelEntryFactory.getLocalInstance(ctx).getBreedModelEntryInfo(new ObjectUuidPK(entryInfo.getId()));
	//						// 日龄明细存到内存中
	//						currentBreedModelDetails.put(Integer.valueOf(entryInfo.getDays()), entryInfo);
	//						MaterialInfo currMaterial = entryInfo.getMaterial();
	//						// 整理 饲喂 物料列表
	//						addToCurrBreedMaterials(currMaterial);
	//						
	//					}
	//				}
	//			}catch (SQLException e) {
	//				e.printStackTrace();
	//				throw new BOSException(e);
	//			}
				return currentBreedModel;
			}catch(SQLException sqle){
				sqle.printStackTrace();
				throw new BOSException(sqle);
			} catch (EASBizException e) {
				e.printStackTrace();
				throw new BOSException(e);
			}
		}
		
	}


	/**
	 * 获取商品鸡前一天存栏量
	 * 如果前一天填报了日报，则取日报对应的存栏量，如果没有则直接返回传入的理论存栏量
	 * 计算送料计划、存栏量统计都会用到 谨慎修改
	 */
	@Override
	protected int _getCCPredateHenqty(Context ctx, String stoorgID,
			String batchID, Date bizdate,String henhouseIDs, String henhouseID, int theoryQty)
			throws BOSException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(bizdate);
		cal.add(Calendar.DATE, -1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String yestodayStr = sdf.format(cal.getTime());
		
		StringBuilder sql = new StringBuilder("/*dialect*/select sum(te.cfbreedingstock) cfbreedingstock,max(t.fid) fid from CT_FM_CommecialChilkenDaily t ");
		sql.append(" inner join CT_FM_CommecialCDAE te on t.fid = te.fparentid ");
		sql.append(" where t.cfstoorgid =? and t.cfbreedbatchid=? and to_char(t.fbizdate,'yyyy-mm-dd') = '");
		sql.append(yestodayStr);
		sql.append("' ");
		if(StringUtils.isNotBlank(henhouseIDs)){
			sql.append(" and te.cfhenhouseid in ");
			sql.append(henhouseIDs);
			sql.append("' ");
		}
		if(StringUtils.isNotBlank(henhouseID)){
			sql.append(" and te.cfhenhouseid ='");
			sql.append(henhouseID);
			sql.append("' ");
		}
		Object[] args = {stoorgID,batchID};
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString(), args);
		try{
			if(rs.next()){
				String fid = rs.getString("fid");
				if(StringUtils.isBlank(fid)){
					return theoryQty;
				}else{
					int cfbreedingstock = rs.getInt("cfbreedingstock");
					return cfbreedingstock;
				}
			}else{
				return theoryQty;
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
	}
	
	
	/**
	 * 获取 指定日期的实际出栏量  TODO 单日期查询 存在性能问题
	 * @param ctx
	 * @param stoorgID
	 * @param batchID
	 * @param bizdate
	 * @param henhouseIDs
	 * @param henhouseID
	 * @param theoryQty
	 * @return
	 * @throws BOSException
	 */
	@Override
	@Deprecated
	protected int _getCCActualOutHenqty(Context ctx, String stoorgID,
			String batchID, Date bizdate,String henhouseIDs, String henhouseID)
			throws BOSException {
		Calendar cal = Calendar.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String bizDateStr = sdf.format(cal.getTime());
		
		StringBuilder sql = new StringBuilder("/*dialect*/select sum(te.CFMARKETQTY) CFMARKETQTY,max(t.fid) fid from CT_FM_CommecialChilkenDaily t ");
		sql.append(" inner join CT_FM_CommecialCDAE te on t.fid = te.fparentid ");
		sql.append(" where t.cfstoorgid =? and t.cfbreedbatchid=? and to_char(t.fbizdate,'yyyy-mm-dd') = '");
		sql.append(bizDateStr);
		sql.append("' ");
		if(StringUtils.isNotBlank(henhouseIDs)){
			sql.append(" and te.cfhenhouseid in ");
			sql.append(henhouseIDs);
			sql.append("' ");
		}
		if(StringUtils.isNotBlank(henhouseID)){
			sql.append(" and te.cfhenhouseid ='");
			sql.append(henhouseID);
			sql.append("' ");
		}
		Object[] args = {stoorgID,batchID};
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString(), args);
		try{
			if(rs.next()){
				String fid = rs.getString("fid");
				if(StringUtils.isBlank(fid)){
					return 0;
				}else{
					int cfbreedingstock = rs.getInt("CFMARKETQTY");
					return cfbreedingstock;
				}
			}else{
				return 0;
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
	}
	
}