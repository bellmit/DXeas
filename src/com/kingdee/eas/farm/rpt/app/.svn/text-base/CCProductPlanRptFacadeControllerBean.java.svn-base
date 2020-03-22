package com.kingdee.eas.farm.rpt.app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
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
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
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
import com.kingdee.eas.farm.breed.business.CCBreedPlanFactory;
import com.kingdee.eas.farm.breed.business.CCBreedPlanInfo;
import com.kingdee.eas.farm.breed.comm.BREED_CONSTANTS;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class CCProductPlanRptFacadeControllerBean extends AbstractCCProductPlanRptFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.rpt.app.CCProductPlanRptFacadeControllerBean");

    // 符合条件的 结果集
//  private List<CCProductPlanRptBean> beans;
    // 养殖规范
    private BreedModelInfo currentBreedModel;
    // 养殖规范明细
    private Map<Integer,BreedModelEntryInfo> currentBreedModelDetails;
    // 当前养殖规范包含的饲料信息
    private Map<Integer,MaterialInfo> currentBreedMaterials;
	@Override
	protected IRowSet _getRptData(Context ctx, HashMap param)
			throws BOSException {
		// TODO Auto-generated method stub
//		return super._getRptData(ctx, param);
		List<CCProductPlanRptBean> resultBeans = new ArrayList<CCProductPlanRptBean>();
		try{
			// 获取 养殖规范
			getCurrentCCBreedModelInfo(ctx);
			
			List<CCProductPlanRptBean> storageBeans = getRptBeanStorageInfos(ctx, param);
			// 逐个养殖场  计算获得对应的批次信息
			for(CCProductPlanRptBean ccRptBean : storageBeans){
				ccRptBean = this.getStoorgBatchInfos(ctx, ccRptBean, param);
				if(ccRptBean.isPlan()){
					// 如果是计划的话调用计划逻辑
					List<CCProductPlanRptBean> storageResultBeans =  this.setPlanDetailInfos(ctx,ccRptBean,ccRptBean.getBatchID(),param);
					if(storageResultBeans != null && storageResultBeans.size() > 0){
						// 添加到 结果集
						resultBeans.addAll(storageResultBeans);
					}
				}else{
					// 实际批次按照批次计算
					List<CCProductPlanRptBean> storageResultBeans =  this.setBatchDetailInfos(ctx,ccRptBean,ccRptBean.getBatchID(),param);
					if(storageResultBeans != null && storageResultBeans.size() > 0){
						// 添加到 结果集
						resultBeans.addAll(storageResultBeans);
					}
				}
			}
			
			// 添加到数据库中
			// 创建临时表
			String temptable = TableManagerFacadeFactory.getLocalInstance(ctx).getTableName("CCProductPlanRpt");
			TableManagerFacadeFactory.getLocalInstance(ctx).createTempTable(getTempTableCreateSql(temptable));
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < resultBeans.size(); i++){
				CCProductPlanRptBean bean = resultBeans.get(i);
				// 插入语句添加
				sb.append(this.getInsertSql(temptable, bean));
				if(i < resultBeans.size()) sb.append(";");
	//			DbUtil.ex
			}
			
			// 有数据则插入临时表返回结果
			if(sb.length() > 10){
				//System.out.println(sb.toString());
				DbUtil.execute(ctx, sb.toString()); 
				
				IRowSet rs = DbUtil.executeQuery(ctx, "select * from "+ temptable +" order by stoOrgNumber,batchNumber,inhouseDate ");
				return rs;
			}
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BOSException(e);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BOSException(e);
		}
		return null;
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
			BreedBatchInfo batchInfo = BreedBatchFactory.getLocalInstance(ctx).getBreedBatchInfo(new ObjectUuidPK(batchID));
			if(batchInfo != null){
				// 判断批次 入栏日期  和当前时间比较  批次是否在 当前时间内
				StringBuilder sb = new StringBuilder();
				sb.append("select t.fid billID,te.fid entryID,te.cfhenhouseid,te.cfhenhouseName, ");
				sb.append(" te.cfinitqty,te.cfincoopdate,t.fbizdate billBizdate ");
				sb.append(" from CT_FM_BreedBatch t inner join CT_FM_BreedBatchEntry te on t.fid = te.fparentid ");
				sb.append(" where t.fid ='");
				sb.append(batchInfo.getId().toString());
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
					String cfhenhouseName = rs.getString("cfhenhouseName");
					int cfinitqty = rs.getInt("cfinitqty");
					// 入栏日期
					Date cfincoopdate = rs.getDate("cfincoopdate");
					
					if(cfincoopdate == null ){
						cfincoopdate = rs.getDate("billBizdate");
					}
//					String incoopdateStr = sdf.format(cfincoopdate);
					
					// 获得 实际出栏或者理论出栏日期
					
					// 入栏日期变化和 未变化  分别处理
					if(cfincoopdate!= null && currEntryDateStr.equals(sdf.format(cfincoopdate))){
						currIncoopQty = currIncoopQty + cfinitqty;
						// 记录 鸡舍id
						entryHenhouseIDs.add(cfhenhouseid);
					}else{
						
						// 日龄变化处理，保存 之前数据，清空临时记录字段
						if(StringUtils.isNotBlank(currEntryDateStr)){
							// 获取批次日龄明细信息
							CCProductPlanRptBean batchEntryDetailBean = getBatchFodders(ctx, stoBatchBean, batchID, sdf.parse(currEntryDateStr), currEntryOutDate,currIncoopQty, entryHenhouseIDs);
							batchDetailInfos.add(batchEntryDetailBean);
						}
						
						// 当前入栏日期指向 当前数据
//						currEntryInDate = cfincoopdate;
						
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
							cal.add(Calendar.DATE, currentBreedModel.getBreedDays());
							
							currEntryOutDate = cal.getTime();
							
						}
					}
					
					// 最后一行 添加合计到 列表中
					if(i == rs.size() -1){
						// 获取批次日龄明细信息
						CCProductPlanRptBean batchEntryDetailBean = getBatchFodders(ctx, stoBatchBean, batchID, sdf.parse(currEntryDateStr), currEntryOutDate,currIncoopQty, entryHenhouseIDs);
						batchDetailInfos.add(batchEntryDetailBean);
					}
					// 计数器累加
					i++;
				}
				
				
				
//				sb.append("")
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
		// 获取批次明细信息 
		if(StringUtils.isNotBlank(planID)){
			// 获取 批次明细信息
			CCBreedPlanInfo planInfo = CCBreedPlanFactory.getLocalInstance(ctx).getCCBreedPlanInfo(new ObjectUuidPK(planID));
			if(planInfo != null){
				// 判断批次 计划入栏日期  和当前时间比较  批次是否在 当前时间内
				StringBuilder sb = new StringBuilder();
				sb.append("select t.fid billID,te.fid entryID,te.cfhenhouseid,te.cfhenhouseName, ");
				sb.append(" te.cfinitqty,te.cfincoopdate,t.fbizdate billBizdate ");
				sb.append(" from CT_FM_CCBreedPlan t inner join CT_FM_CCBreedPlanEntry te on t.fid = te.fparentid ");
				sb.append(" where t.fid ='");
				sb.append(planInfo.getId().toString());
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
					String cfhenhouseName = rs.getString("cfhenhouseName");
					int cfinitqty = rs.getInt("cfinitqty");
					// 入栏日期
					Date cfincoopdate = rs.getDate("cfincoopdate");
					
					if(cfincoopdate == null ){
						cfincoopdate = rs.getDate("billBizdate");
					}
//					String incoopdateStr = sdf.format(cfincoopdate);
					
					// 获得 实际出栏或者理论出栏日期
					
					// 入栏日期变化和 未变化  分别处理
					if(cfincoopdate!= null && currEntryDateStr.equals(sdf.format(cfincoopdate))){
						currIncoopQty = currIncoopQty + cfinitqty;
						// 记录 鸡舍id
						entryHenhouseIDs.add(cfhenhouseid);
					}else{
						
						// 日龄变化处理，保存 之前数据，清空临时记录字段
						if(StringUtils.isNotBlank(currEntryDateStr)){
							// 获取批次日龄明细信息
							CCProductPlanRptBean batchEntryDetailBean = getPlanFodders(ctx, stoBatchBean, planID, sdf.parse(currEntryDateStr), currEntryOutDate,currIncoopQty, entryHenhouseIDs);
							batchEntryDetailBean.setPlan(true);
							batchDetailInfos.add(batchEntryDetailBean);
						}
						
						// 当前入栏日期指向 当前数据
//						currEntryInDate = cfincoopdate;
						
						currEntryDateStr = sdf.format(cfincoopdate);
						entryHenhouseIDs = new ArrayList<String>();
						entryHenhouseIDs.add(cfhenhouseid);
						// 当前总入栏量等于当前行
						currIncoopQty = cfinitqty;
						// 获得 出栏日期
//						currEntryOutDate = getBatchEntryOutcoopDate(ctx, billID, cfhenhouseid, cfincoopdate);
						Calendar cal = Calendar.getInstance();
						
						// 如果取得的出栏日期为null，则计算理论出栏时间     入栏日期加上  38天
						if(currEntryOutDate == null){
							cal.setTime(cfincoopdate);
							cal.add(Calendar.DATE, currentBreedModel.getBreedDays());
							
							currEntryOutDate = cal.getTime();
							
						}
					}
					
					// 最后一行 添加合计到 列表中
					if(i == rs.size() -1){
						// 获取批次日龄明细信息
						CCProductPlanRptBean batchEntryDetailBean = getPlanFodders(ctx, stoBatchBean, planID, sdf.parse(currEntryDateStr), currEntryOutDate,currIncoopQty, entryHenhouseIDs);
						batchEntryDetailBean.setPlan(true);
						batchDetailInfos.add(batchEntryDetailBean);
					}
					// 计数器累加
					i++;
				}
				
				
				
//				sb.append("")
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
	private CCProductPlanRptBean getPlanFodders(Context ctx,CCProductPlanRptBean stoBatchInfo, String planID,Date incoopDate,Date outcoopDate,int incoopQty,List<String> henhouseIDs) throws EASBizException, BOSException, SQLException{
		long timeLong = outcoopDate.getTime()-incoopDate.getTime();
		long days = timeLong / (1000 * 60 * 60 * 24);
		int outDays = (new Long(days)).intValue();
		
		CCProductPlanRptBean newRptBean = new CCProductPlanRptBean();
		newRptBean.setStoOrgID(stoBatchInfo.getStoOrgID());
		newRptBean.setStoOrgName(stoBatchInfo.getStoOrgName());
		newRptBean.setStoOrgNumber(stoBatchInfo.getStoOrgNumber());
		
		newRptBean.setBatchID(planID);
		newRptBean.setBatchEntryIDs(stoBatchInfo.getBatchEntryIDs());
		newRptBean.setBatchName(stoBatchInfo.getBatchName());
		newRptBean.setBatchNumber(stoBatchInfo.getBatchNumber());
		
		newRptBean.setCostObjectID(stoBatchInfo.getCostObjectID());
		
		newRptBean.setInhouseDate(incoopDate);
		newRptBean.setInhouseQty(incoopQty);
		newRptBean.setCurrDateNum(outDays);
		newRptBean.setDesc("");
		
//		newRptBean.set
		// 根据料号 从小到大 逐个循环  计算用料量，同事 鸡只数量逐渐 减少
		// 数量
		int qty = incoopQty;
		
		for(int m = 1; m <= currentBreedMaterials.size(); m++){
			MaterialInfo currMaterial = currentBreedMaterials.get(Integer.valueOf(m));
			if(StringUtils.isBlank(currMaterial.getName())){
				currMaterial = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(currMaterial.getId()));
				
			}
			// 料号 总耗料
			BigDecimal currTheoryQty = new BigDecimal("0.00");
			// 理论饲喂天数
			int prediDays = 0;
			for(int i = 1; i <= days; i++){
				// 逐天匹配  匹配到的 根据当天分录明细设置 计算领料量 同时更新 存栏量
				BreedModelEntryInfo modelEntryInfo =  currentBreedModelDetails.get(Integer.valueOf(i));
				if(modelEntryInfo != null && modelEntryInfo.getMaterial() != null){
					MaterialInfo  modelEntryMaterial = modelEntryInfo.getMaterial();
					// 物料匹配 
					if(currMaterial.getId().toString().equals(modelEntryMaterial.getId().toString())){
						// 批次 日死淘率
						BigDecimal dcRate = modelEntryInfo.getDailyDCRate();
						// 日饲喂量
						BigDecimal perQtyEveryone = modelEntryInfo.getQtyPerday();
						
						// 日总耗料
						BigDecimal perQtyAllday = perQtyEveryone.multiply(new BigDecimal(qty)).divide(new BigDecimal(1000),2,RoundingMode.HALF_UP);
						// 累计耗料
//						currTheoryQty = currTheoryQty.add(perQtyAllday);
						// 累加日理论耗料量
						currTheoryQty = currTheoryQty.add(perQtyAllday);
						// 日死淘数量
						BigDecimal dayDCQty = ((new BigDecimal(qty)).multiply(dcRate)).divide(new BigDecimal(100),0,RoundingMode.HALF_UP);
						
						int dayDCQtyInt = dayDCQty.intValue();
						
						// 剩余数量
						qty = qty - dayDCQtyInt;
						
						prediDays ++;
					}
				}
			}
			
			newRptBean.setPredictOuthouseDate(outcoopDate);
			newRptBean.setPredictOuthouseQty(qty);
			
			// 获得 鸡舍过滤条件
			String henhouseIDStr = getHenhouseStr(henhouseIDs);
			// 物料的实际饲喂量 和饲喂天数
			BigDecimal actualQty = new BigDecimal("0.00");
			int actualDays  = 0;
			// 获取实际饲喂量
			String materialName = BREED_CONSTANTS.CC_RJ01;
			if(m ==1) materialName = BREED_CONSTANTS.CC_RJ01;
			if(m ==2) materialName = BREED_CONSTANTS.CC_RJ02;
			if(m ==3) materialName = BREED_CONSTANTS.CC_RJ03;
			
			// 当前物料理论饲喂量 设置到  结果集中TODO 此处如果存在list或map会灵活~~~
			if(m == 1){
				newRptBean.setOneMaterialID(currMaterial.getId().toString());
				newRptBean.setOneMaterialName(currMaterial.getName());
				newRptBean.setOneMaterialNumber(currMaterial.getNumber());
				newRptBean.setOneMaterialPredictDays(prediDays);
				newRptBean.setOneMaterialPredictQty(currTheoryQty);
			}else if(m == 2){
				newRptBean.setTwoMaterialID(currMaterial.getId().toString());
				newRptBean.setTwoMaterialName(currMaterial.getName());
				newRptBean.setTwoMaterialNumber(currMaterial.getNumber());
				newRptBean.setTwoMaterialPredictDays(prediDays);
				newRptBean.setTwoMaterialPredictQty(currTheoryQty);
			}else if(m == 3){
				newRptBean.setThreeMaterialID(currMaterial.getId().toString());
				newRptBean.setThreeMaterialName(currMaterial.getName());
				newRptBean.setThreeMaterialNumber(currMaterial.getNumber());
				newRptBean.setThreeMaterialPredictDays(prediDays);
				newRptBean.setThreeMaterialPredictQty(currTheoryQty);
			}
			
		}
		
		
//		// 获得期间天数
//		for(int i = 1; i <= days; i++){
//			
//		}
		
		return newRptBean;
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
	private List<CCProductPlanRptBean> getPlanDetailFodders(Context ctx,CCProductPlanRptBean stoBatchInfo, String planID,Date incoopDate,Date outcoopDate,Date filterDate,int incoopQty,List<String> henhouseIDs) throws EASBizException, BOSException, SQLException{
		long timeLong = outcoopDate.getTime()-incoopDate.getTime();
		long days = timeLong / (1000 * 60 * 60 * 24);
		int outDays = (new Long(days)).intValue();
		
		List<CCProductPlanRptBean> result = new ArrayList<CCProductPlanRptBean>();
		
		
//		newRptBean.set
		// 根据料号 从小到大 逐个循环  计算用料量，同时 鸡只数量逐渐 减少
		// 数量
		int qty = incoopQty;
		
//		for(int m = 1; m <= currentBreedMaterials.size(); m++){
//			MaterialInfo currMaterial = currentBreedMaterials.get(Integer.valueOf(m));
//			if(StringUtils.isBlank(currMaterial.getName())){
//				currMaterial = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(currMaterial.getId()));
//				
//			}
		// 料号 总耗料
//		BigDecimal currTheoryQty = new BigDecimal("0.00");
		// 理论饲喂天数
		int prediDays = 0;
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(incoopDate);
		for(int i = 1; i <= days; i++){
			// 获取 对应日龄所在日期
			cal.add(Calendar.DATE, 1);
			Date currDate = cal.getTime();
			
			CCProductPlanRptBean newRptBean = new CCProductPlanRptBean();
			newRptBean.setStoOrgID(stoBatchInfo.getStoOrgID());
			newRptBean.setStoOrgName(stoBatchInfo.getStoOrgName());
			newRptBean.setStoOrgNumber(stoBatchInfo.getStoOrgNumber());
			
			newRptBean.setPlan(true);
			newRptBean.setBatchID(planID);
			newRptBean.setBatchEntryIDs(stoBatchInfo.getBatchEntryIDs());
			newRptBean.setBatchName(stoBatchInfo.getBatchName());
			newRptBean.setBatchNumber(stoBatchInfo.getBatchNumber());
			
			newRptBean.setCostObjectID(stoBatchInfo.getCostObjectID());
			
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
				if(modelEntryMaterial.getName().indexOf(BREED_CONSTANTS.CC_RJ01) >= 0){
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
	private CCProductPlanRptBean getBatchFodders(Context ctx,CCProductPlanRptBean stoBatchInfo, String batchID,Date incoopDate,Date outcoopDate,int incoopQty,List<String> henhouseIDs) throws EASBizException, BOSException, SQLException{
		long timeLong = outcoopDate.getTime()-incoopDate.getTime();
		long days = timeLong / (1000 * 60 * 60 * 24);
		int outDays = (new Long(days)).intValue();
		
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
		newRptBean.setDesc("");
		
//		newRptBean.set
		// 根据料号 从小到大 逐个循环  计算用料量，同事 鸡只数量逐渐 减少
		// 数量
		int qty = incoopQty;
		
		for(int m = 1; m <= currentBreedMaterials.size(); m++){
			MaterialInfo currMaterial = currentBreedMaterials.get(Integer.valueOf(m));
			if(StringUtils.isBlank(currMaterial.getName())){
				currMaterial = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(currMaterial.getId()));
				
			}
			// 料号 总耗料
			BigDecimal currTheoryQty = new BigDecimal("0.00");
			// 理论饲喂天数
			int prediDays = 0;
			for(int i = 1; i <= days; i++){
				// 逐天匹配  匹配到的 根据当天分录明细设置 计算领料量 同时更新 存栏量
				BreedModelEntryInfo modelEntryInfo =  currentBreedModelDetails.get(Integer.valueOf(i));
				if(modelEntryInfo != null && modelEntryInfo.getMaterial() != null){
					MaterialInfo  modelEntryMaterial = modelEntryInfo.getMaterial();
					// 物料匹配 
					if(currMaterial.getId().toString().equals(modelEntryMaterial.getId().toString())){
						// 批次 日死淘率
						BigDecimal dcRate = modelEntryInfo.getDailyDCRate();
						// 日饲喂量
						BigDecimal perQtyEveryone = modelEntryInfo.getQtyPerday();
						
						// 日总耗料
						BigDecimal perQtyAllday = perQtyEveryone.multiply(new BigDecimal(qty)).divide(new BigDecimal(1000),2,RoundingMode.HALF_UP);
						// 累计耗料
//						currTheoryQty = currTheoryQty.add(perQtyAllday);
						// 累加日理论耗料量
						currTheoryQty = currTheoryQty.add(perQtyAllday);
						// 日死淘数量
						BigDecimal dayDCQty = ((new BigDecimal(qty)).multiply(dcRate)).divide(new BigDecimal(100),0,RoundingMode.HALF_UP);
						
						int dayDCQtyInt = dayDCQty.intValue();
						
						// 剩余数量
						qty = qty - dayDCQtyInt;
						
						prediDays ++;
					}
				}
			}
			
			newRptBean.setPredictOuthouseDate(outcoopDate);
			newRptBean.setPredictOuthouseQty(qty);
			
			// 获得 鸡舍过滤条件
			String henhouseIDStr = getHenhouseStr(henhouseIDs);
			// 物料的实际饲喂量 和饲喂天数
			BigDecimal actualQty = new BigDecimal("0.00");
			int actualDays  = 0;
			// 获取实际饲喂量
			String materialName = BREED_CONSTANTS.CC_RJ01;
			if(m ==1) materialName = BREED_CONSTANTS.CC_RJ01;
			if(m ==2) materialName = BREED_CONSTANTS.CC_RJ02;
			if(m ==3) materialName = BREED_CONSTANTS.CC_RJ03;
			// 设置实际数据
			setOuthouseDays(ctx,newRptBean,m,batchID,materialName,henhouseIDStr);
			
			// 当前物料理论饲喂量 设置到  结果集中TODO 此处如果存在list或map会灵活~~~
			if(m == 1){
				newRptBean.setOneMaterialID(currMaterial.getId().toString());
				newRptBean.setOneMaterialName(currMaterial.getName());
				newRptBean.setOneMaterialNumber(currMaterial.getNumber());
				newRptBean.setOneMaterialPredictDays(prediDays);
				newRptBean.setOneMaterialPredictQty(currTheoryQty);
			}else if(m == 2){
				newRptBean.setTwoMaterialID(currMaterial.getId().toString());
				newRptBean.setTwoMaterialName(currMaterial.getName());
				newRptBean.setTwoMaterialNumber(currMaterial.getNumber());
				newRptBean.setTwoMaterialPredictDays(prediDays);
				newRptBean.setTwoMaterialPredictQty(currTheoryQty);
			}else if(m == 3){
				newRptBean.setThreeMaterialID(currMaterial.getId().toString());
				newRptBean.setThreeMaterialName(currMaterial.getName());
				newRptBean.setThreeMaterialNumber(currMaterial.getNumber());
				newRptBean.setThreeMaterialPredictDays(prediDays);
				newRptBean.setThreeMaterialPredictQty(currTheoryQty);
			}
			
		}
		
		
//		// 获得期间天数
//		for(int i = 1; i <= days; i++){
//			
//		}
		
		return newRptBean;
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
			for(int i = 1; i <= days; i++){
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
			if(mNum == 1){
				
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
	 * 获取当前养殖规范
	 * @param ctx
	 * @return
	 * @throws BOSException 
	 * @throws SQLException 
	 * @throws EASBizException 
	 */
	private BreedModelInfo getCurrentCCBreedModelInfo(Context ctx) throws BOSException, SQLException, EASBizException{
		String  sql = "select fid from CT_FM_BreedModel where CFHouseType = '3' and CFDeletedStatus = 1 ";
		IRowSet rs = DbUtil.executeQuery(ctx, sql);
		if(rs.size() > 1){
			throw new BOSException("当前启用的商品鸡养殖规范数多于一条，请将多于规范禁用后再查询");
		}else if(rs.size() == 0){
			throw new BOSException("没有启用的商品鸡养殖规范");
		}else{
			// 读取数据
			rs.next();
			String fid = rs.getString("fid");
			
			currentBreedModel = BreedModelFactory.getLocalInstance(ctx).getBreedModelInfo(new ObjectUuidPK(fid));
			
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
			
			return currentBreedModel;
		}
		
	}
	
	/**
	 * 判断指定物料是否已经包含在当前饲喂 物料中，如果不包含则添加上
	 * 顺序 按照 养殖规范 分录顺序添加
	 * @param currMaterial
	 */
	private void addToCurrBreedMaterials(MaterialInfo currMaterial) {
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
	 * 获得养殖批次信息,如果在养，则直接 设置当前批次信息，如果处在养殖间歇期则根据上一批次 设置预计 入栏数量，如果从未养过 则设置 理论可养数量
	 * 饲料量  已经 取实际领料数量，其他取理论数量  
	 * @param ccRptBean
	 * @return
	 * @throws BOSException 
	 * @throws SQLException 
	 */
	private CCProductPlanRptBean getStoorgBatchInfos(Context ctx,CCProductPlanRptBean ccRptBean,HashMap param) throws BOSException, SQLException{
		
		// 默认养殖周期
		int preBreedDays = this.currentBreedModel.getBreedDays();
		
		// 过滤日期
		Date filterDate = (Date) param.get("filterDate");
		if(filterDate == null){
			filterDate = new Date();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder ssb = new StringBuilder();
		
		
	    ssb.append(" select top 1 t.cfstoorgid stoorgID, t.CFBreedBatchID batchID, ");
	    ssb.append(" max(t.fbizdate) bizdate , sum(te.CFBreedingStock) breedingStock , ");
	    ssb.append(" max(tbb.fnumber) batchNumber,max(tbc.fname_l2) batchName, tbb.CFCostObjectID costObjectID ");
	    
	    ssb.append(" from  ct_fm_commecialchilkendaily t ");
		ssb.append(" inner join CT_FM_CommecialCDAE te on t.fid = te.fparentid ");
		ssb.append(" inner join CT_FM_BreedBatch tbb on t.CFBreedBatchID = tbb.fid ");
		ssb.append(" inner join T_BD_CostObject tbc on tbb.CFCostObjectID = tbc.fid ");
		ssb.append(" where  ");
		ssb.append(" t.fbizdate <= {ts'");
		ssb.append(sdf.format(filterDate));
		
		ssb.append("'} and  t.cfstoorgid='");
		ssb.append(ccRptBean.getStoOrgID());
		
		ssb.append("' group by t.cfstoorgid,t.CFBreedBatchID,tbb.CFCostObjectID ");
		//ssb.append("' group by t.cfstoorgid,t.CFBreedBatchID,t.fid ");
		ssb.append(" order by bizdate desc,breedingStock asc ");
	    
	    
	    
//		ssb.append("select  top 1 t.fid batchID,t.fnumber batchNumber,tc.fname_l2 batchName,tc.fid costObjectID ");
////		ssb.append("t.fbizdate  ");
//		
//		ssb.append(" from CT_FM_BreedBatch t ");
//		
//		ssb.append(" inner join t_org_storage ts on t.CFStoOrgID = ts.fid ");
////		ssb.append(" inner join CT_FM_BreedBatchEntry te on t.fid = te.fparentid ");
//		ssb.append(" inner join t_bd_costobject tc on t.CFCostObjectID = tc.fid ");
//		ssb.append(" where ts.fid ='");
//		ssb.append(ccRptBean.getStoOrgID());
//		ssb.append("' ");
		
//		ssb.append(" and t.fbizdate<= {ts'");
//		ssb.append(sdf.format(filterDate));
//		ssb.append("'} ");
		
//		ssb.append(" order by t.fbizdate desc ");
		
		IRowSet rs = DbUtil.executeQuery(ctx, ssb.toString());
		boolean isInBatch = false;
		if(rs.next()){
			// 判断 对应
			int breedingStock = rs.getInt("breedingStock");
			if(breedingStock > 0){
				// 设置在养殖批次中
				isInBatch = true;
				
				String batchID = rs.getString("batchID");
				String batchNumber = rs.getString("batchNumber");
				String batchName = rs.getString("batchName");
				String costObjectID = rs.getString("costObjectID");
				
				// 判断对应批次是否已经完全出栏，如果完全出栏  则 跳到 设置 计划 逻辑
				
				// 设置批次信息
				ccRptBean.setBatchID(batchID);
				ccRptBean.setBatchNumber(batchNumber);
				ccRptBean.setBatchName(batchName);
				ccRptBean.setCostObjectID(costObjectID);
			
			}
			
			
		}
		// 如果没有在养殖批次中 则查询对应 库存组织的 养殖计划
		if(!isInBatch){
			// 获得养殖计划 数据
			StringBuilder sql = new StringBuilder(" select top 1 t.fid,t.fnumber from CT_FM_CCBreedPlan t where t.CFStoOrgID = '");
			
			sql.append(ccRptBean.getStoOrgID());
			sql.append("' and  t.fbizdate <= {ts'");
			sql.append(sdf.format(filterDate));
			
			sql.append("' }");
			
			IRowSet rs1 = DbUtil.executeQuery(ctx, sql.toString());
			if(rs1.next()){
				String fid = rs1.getString("fid");
				String fnumber = rs1.getString("fnumber");
				ccRptBean.setPlan(true);
				ccRptBean.setBatchID(fid);
				ccRptBean.setBatchNumber(fnumber);
			}
			
		}
		
		
		
		return ccRptBean;
	}
	
	
	
	/**
	 * 获得 符合条件的 养殖场和当前 批次信息或者下批批次，设置到 结果集
	 * @param param
	 * @return
	 * @throws BOSException 
	 */
	private List<CCProductPlanRptBean> getRptBeanStorageInfos(Context ctx,HashMap param) throws BOSException{
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
		 sql.append("',{ts'");
		 sql.append(sdf.format(ccBean.getInhouseDate()));
		 sql.append("'},");
		 sql.append(ccBean.getCurrDateNum());
		 sql.append(",");
		 sql.append(ccBean.getInhouseQty());
		 sql.append(",{ts'");
		 sql.append(sdf.format(ccBean.getPredictOuthouseDate()));
		 sql.append("'},");
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
			 sql.append(",null");
		 }
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
	  sql.append(" stoOrgName VARCHAR(80), \r\n");
	  
	  sql.append(" isPlan varchar(2), \r\n");
	  
	  sql.append(" batchID varchar(44), \r\n");
	  sql.append(" batchNumber varchar(44), \r\n");
	  sql.append(" batchName VARCHAR(80), \r\n");
	  
	  sql.append(" inhouseDate DATETIME, \r\n");
	  sql.append(" currDateNum int, \r\n");
	  sql.append(" inhouseQty int, \r\n");
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
	
    
}