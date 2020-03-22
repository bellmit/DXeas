package com.kingdee.eas.farm.breed.layegg.app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.scm.common.BizTypeInfo;
import com.kingdee.eas.basedata.scm.im.inv.LocationInfo;
import com.kingdee.eas.basedata.scm.im.inv.StoreFlagEnum;
import com.kingdee.eas.basedata.scm.im.inv.StoreTypeInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.BreedFacadeFactory;
import com.kingdee.eas.farm.breed.HenhouseFactory;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.farm.breed.ParentBreedBatchFactory;
import com.kingdee.eas.farm.breed.ParentBreedBatchInfo;
import com.kingdee.eas.farm.breed.ParentBreedBatchTransEntryFactory;
import com.kingdee.eas.farm.breed.ParentBreedBatchTransEntryInfo;
import com.kingdee.eas.farm.breed.parentFacadeFactory;
import com.kingdee.eas.farm.breed.comm.ExecBotpResultInfo;
import com.kingdee.eas.farm.breed.comm.ParentBreedBatchDetailInfo;
import com.kingdee.eas.farm.breed.comm.ParentBreedBatchEntryDetailInfo;
import com.kingdee.eas.farm.breed.layegg.EggConveyorFactory;
import com.kingdee.eas.farm.breed.layegg.EggConveyorInfo;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyConveyorCollection;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyConveyorFactory;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyConveyorInfo;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyCullDeathEntryCollection;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyCullDeathEntryInfo;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyEntryCollection;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyEntryInfo;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyLayEggEntryCollection;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyLayEggEntryInfo;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyTransHenhouseEntryCollection;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyTransHenhouseEntryFactory;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyTransHenhouseEntryInfo;
import com.kingdee.eas.farm.breed.layegg.LayEggFacadeFactory;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.im.inv.StockTransferBillEntryCollection;
import com.kingdee.eas.scm.im.inv.StockTransferBillEntryInfo;
import com.kingdee.eas.scm.im.inv.StockTransferBillFactory;
import com.kingdee.eas.scm.im.inv.StockTransferBillInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.BotpAppCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class LayEggDailyControllerBean extends AbstractLayEggDailyControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.breed.layegg.app.LayEggDailyControllerBean");
    

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// 状态设置为保存
		LayEggDailyInfo info =  (LayEggDailyInfo)model;
		if( info.getBaseStatus() != null &&  
				!info.getBaseStatus().equals(BillBaseStatusEnum.NULL) && 
				!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&&
				info.getBaseStatus() != null){
			throw new EASBizException(new NumericExceptionSubItem("001","只能保存暂存或者新增状态的单据"));
			
		}else{
//			// 校验是否当天已经填报过日报
//			String id = "";
//			if(info.getId() != null){
//				id = info.getId().toString();
//			}
//			boolean isExist = BreedFacadeFactory.getLocalInstance(ctx).checkDateDailyState(info.getParentBatch().getId().toString(),
//					info.getBizDate(), HenhouseType.LayEgg.getValue(), id);
//			if(isExist){
//				throw new EASBizException(new NumericExceptionSubItem("001","该批次对应业务日期已经填报过日报，请不要重复填报"));
//			}
//			// 校验成本对象设置
//			checkCostObject(ctx,info);
//			// 校验转栏数量
//			checkTransQty(ctx,info);
//			// 校验 饲料需求计划是否有重复
//			checkFodderPlan(ctx,info);
//			
//			// 设置折合数量
//			setTranEntryFixedInfo(ctx, info);
			
		}
		info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		
		// 设置已定栏
		if(info.isIsFixed()){
			info.setHadFixed(true);
		}else{
			boolean isfixed = LayEggFacadeFactory.getLocalInstance(ctx).isBatchFixed(info.getParentBatch().getId().toString(), info.getBizDate());
			if(isfixed){
				info.setHadFixed(true);
			}
		}
		return super._save(ctx, model);
	}

	/**
	 * 校验转栏 数量  
	 * 不能大于 来源批次  对应禽舍的  当前存栏量
	 * 单条分录数量不能大于 来源禽舍总数，合计数也不能大于 来源禽舍总数 
	 * @param ctx
	 * @param billInfo
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void checkTransQty(Context ctx, LayEggDailyInfo billInfo) throws BOSException, EASBizException{
		if(billInfo != null){
			LayEggDailyTransHenhouseEntryCollection transColl = billInfo.getTransHenhouseEntrys();
			
			// 缓存 单舍 和 整批次的转栏合计 
			Map<String,Integer> henHenhouseMap = new HashMap<String,Integer>();
			Map<String,Integer> cockHenhouseMap = new HashMap<String,Integer>();
			Map<String,Integer> batchMap = new HashMap<String,Integer>();
			// 暂存批次存栏信息
			Map<String,Map<String,ParentBreedBatchEntryDetailInfo>> batchDetails = new HashMap<String, Map<String,ParentBreedBatchEntryDetailInfo>>();
			// 转栏日期
			Date bizdate = billInfo.getBizDate();
			// 逐行判断来源批次 对应禽舍 存栏量 是否 大于转栏数量 ，
			if(transColl.size() > 0){
				for(int i = 0; i < transColl.size(); i++){
					LayEggDailyTransHenhouseEntryInfo transEntryInfo = transColl.get(i);
					if(transEntryInfo != null && transEntryInfo.getFromBatch() != null){
						HenhouseInfo fromHenhouse = transEntryInfo.getFromHenhouse();
						if(fromHenhouse == null){
							throw new EASBizException(new NumericExceptionSubItem("1","转栏分录第" + (i+1) + "行数据未选择转出禽舍"));
						}
						/*************************************累计 所有 转栏分录 相同转出禽舍 的 专栏数量******************/
						// 当前行 转栏数量
						int henTransQty = transEntryInfo.getTransHenQty();
						int cockTransQty = transEntryInfo.getTransCockQty();
						// 将相同禽舍的 数量累计
						Integer henhouseAllHen = henHenhouseMap.get(fromHenhouse.getId().toString());
						if(henhouseAllHen == null) {
							henhouseAllHen = 0;
						}
						henhouseAllHen = henhouseAllHen + henTransQty;
						henHenhouseMap.put(fromHenhouse.getId().toString(), henhouseAllHen);
						// 将相同禽舍的 数量累计
						Integer henhouseAllCock = cockHenhouseMap.get(fromHenhouse.getId().toString());
						if(henhouseAllCock == null) {
							henhouseAllCock = 0;
						}
						henhouseAllCock = henhouseAllCock + cockTransQty;
						cockHenhouseMap.put(fromHenhouse.getId().toString(), henhouseAllCock);
						/*************************************累计 所有 转栏分录 相同转出禽舍 的 专栏数量******************/
						// 转出批次  逐行  比较   并累积
						ParentBreedBatchInfo fromBatch = transEntryInfo.getFromBatch();
						Map<String,ParentBreedBatchEntryDetailInfo> henhouseDetails = batchDetails.get(fromBatch.getId().toString());
						if(henhouseDetails == null){
							// 存栏情况
							ParentBreedBatchDetailInfo batchDetailInfo = new ParentBreedBatchDetailInfo(ctx, fromBatch, bizdate);
							// 存栏明细
							henhouseDetails = batchDetailInfo.getHenhouseBreedingStock(ctx, bizdate);
							// 暂存
							batchDetails.put(fromBatch.getId().toString(), henhouseDetails);
						}
						
						// 指定栏位存栏数据
						ParentBreedBatchEntryDetailInfo detail = henhouseDetails.get(fromHenhouse.getId().toString());
						if(detail == null){
							throw new EASBizException(new NumericExceptionSubItem("1","转栏分录第" + (i+1) + "行对应禽舍[转出母禽]没有存栏数据"));
						}
						int batchHouseHenQty = detail.getHenNowQty();
						int batchHouseCockQty = detail.getCockNowQty();
						// 比较母禽
						if(henhouseAllHen > batchHouseHenQty){
							throw new EASBizException(new NumericExceptionSubItem("1","转栏分录第" + (i+1) + "行对应[转出禽舍]转出母禽总数大于当前存栏总数"));
						}
						// 比较公禽
						if(henhouseAllCock > batchHouseCockQty){
							throw new EASBizException(new NumericExceptionSubItem("1","转栏分录第" + (i+1) + "行对应[转出禽舍]转出公禽总数大于当前存栏总数"));
						}
						
					}
				}
			}
		}
	}
	/**
	 * 设置 转栏分录 折合 入栏数量和 折合产蛋量
	 * @param ctx
	 * @param billInfo
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void setTranEntryFixedInfo(Context ctx, LayEggDailyInfo billInfo) throws BOSException, EASBizException{
		LayEggDailyTransHenhouseEntryCollection transColl = billInfo.getTransHenhouseEntrys();
		if(billInfo.getParentBatch() != null && transColl != null){
			for(int i = 0; i < transColl.size(); i++){
				LayEggDailyTransHenhouseEntryInfo transEntryInfo = transColl.get(i);
				// 获取 来源批次  相关信息 
				HenhouseInfo henhouseInfo = transEntryInfo.getFromHenhouse();
				// 计算折合数量 
				ParentBreedBatchDetailInfo batchDetail = new ParentBreedBatchDetailInfo(ctx, transEntryInfo.getFromBatch(),billInfo.getBizDate());
				if(batchDetail != null){
					Map<String,ParentBreedBatchEntryDetailInfo> details = batchDetail.getHenhouseBreedingStock(ctx, billInfo.getBizDate());
					ParentBreedBatchEntryDetailInfo detailInfo = details.get(henhouseInfo.getId().toString());
					// 批次明细信息
					if(detailInfo != null){
						int henFixedInitQty = detailInfo.getHenFixedInitQty();
						int henNowQty = detailInfo.getHenNowQty();
						int cockFixedInitQty = detailInfo.getCockFixedInitQty();
						int cockNowQty = detailInfo.getCockNowQty();
						
						int henTransQty = transEntryInfo.getTransHenQty();
						int cockTransQty = transEntryInfo.getTransCockQty();
						
						int henAsFixedQty = 0;
						int cockAsFixedQty = 0;
						if(henFixedInitQty != 0){
							BigDecimal henAsFixedQtyBD = new BigDecimal(henTransQty).multiply(new BigDecimal(henNowQty).divide(new BigDecimal(henFixedInitQty),6,RoundingMode.HALF_UP));
							
							henAsFixedQty = henAsFixedQtyBD.intValue();
						}
						if(cockFixedInitQty != 0){
							BigDecimal cockAsFixedQtyBD = new BigDecimal(cockTransQty).multiply(new BigDecimal(cockNowQty).divide(new BigDecimal(cockFixedInitQty),6,RoundingMode.HALF_UP));
							cockAsFixedQty = cockAsFixedQtyBD.intValue();
						}
						// 保存 折合数量
						transEntryInfo.setHenAsFixedQty(henAsFixedQty);
						transEntryInfo.setCockAsFixedQty(cockAsFixedQty);
						
						
					}
				}
			}
		}
	}
	/**
	 * 提交
	 */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		LayEggDailyInfo billInfo = (LayEggDailyInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()) ||
    						billInfo.getBaseStatus() == null)){
    		billInfo.setBaseStatus( BillBaseStatusEnum.SUBMITED);
//    		
//    		// 校验成本对象设置
//			checkCostObject(ctx,billInfo);
//			// 校验转栏数量
//			checkTransQty(ctx,billInfo);
//    		// 校验是否当天已经填报过日报
//			String id = "";
//			if(billInfo.getId() != null){
//				id = billInfo.getId().toString();
//			}
//			boolean isExist = BreedFacadeFactory.getLocalInstance(ctx).checkDateDailyState(billInfo.getParentBatch().getId().toString(),
//					billInfo.getBizDate(), HenhouseType.LayEgg.getValue(), id);
//			
//			
//			
//			if(isExist){
//				throw new EASBizException(new NumericExceptionSubItem("001","该批次对应业务日期已经填报过日报，请不要重复填报"));
//			}
//				
//			// 校验 饲料需求计划是否有重复
//			checkFodderPlan(ctx,billInfo);
//			// 提交前分摊燃煤和 燃油
//			shareCoalAndDiesel(ctx,billInfo);
//    		
//			// 提交前分摊 合格蛋和畸形蛋
//			shareEggs(ctx,billInfo);
//			
//			// 设置 转育成
//			if(billInfo.isIsTransBrood()){
//				billInfo.setHadBrood(true);
//			}else{
//				boolean isfixed = parentFacadeFactory.getLocalInstance(ctx).isBatchBroodFixed(billInfo.getParentBatch().getId().toString(), billInfo.getBizDate());
//				if(isfixed){
//					
//					if(billInfo.isIsTransBrood()){
//						throw new EASBizException(new NumericExceptionSubItem("001","该批次已经转过育成， 不能重复转育成"));
//					}
//					billInfo.setHadBrood(true);
//				}
//			}
//			
//			// 设置已定栏
//			if(billInfo.isIsFixed()){
//				billInfo.setHadFixed(true);
//			}else{
//				boolean isfixed = parentFacadeFactory.getLocalInstance(ctx).isBatchFixed(billInfo.getParentBatch().getId().toString(), billInfo.getBizDate());
//				if(isfixed){
//					if(billInfo.isIsFixed()){
//						throw new EASBizException(new NumericExceptionSubItem("001","该批次已经定群 不能重复定群"));
//					}
//					
//					billInfo.setHadFixed(true);
//				}
//			}
//			
//			
//			// 设置折合数量
//			setTranEntryFixedInfo(ctx, billInfo);
//			
//			// 更新定栏状态
//			updateBatchFixedState(ctx,billInfo,true);
    		return super._submit(ctx, model);
    	}else{
    		
			throw new EASBizException(new NumericExceptionSubItem("001","只能提交暂存、提交或者新增状态的单据"));
    	}
	}
	
	/**
	 * 根据单据 状态设置对应批次的  是否已转育成、是否已转产蛋装填
	 * 
	 * @param ctx
	 * @param billInfo
	 * @param state 提交时  传入true  反审核时 传入false
	 * @throws BOSException 
	 */
	public void updateBatchFixedState(Context ctx,LayEggDailyInfo billInfo, boolean state) throws BOSException{
		if(billInfo != null && billInfo.getParentBatch() != null){
			String sql = "";
			if( billInfo.isIsFixed()){
				// 提交 转定栏 时更新批次  状态
				sql = "update CT_FM_ParentBreedBatch set CFIsToLayegg=? where fid = ?";
				Object[] args = {state, billInfo.getParentBatch().getId().toString()};
				DbUtil.execute(ctx, sql, args);
			}
		}
	}
	/**
	 * 保存和提交前校验养殖批次 的成本对象设置是否完整
	 * 
	 * @param ctx
	 * @param billInfo
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private  void checkCostObject(Context ctx, LayEggDailyInfo billInfo) throws EASBizException, BOSException{
		ParentBreedBatchInfo parentBreedBatch = billInfo.getParentBatch();
		if(parentBreedBatch != null){
			if(StringUtils.isBlank(parentBreedBatch.getNumber())){
				parentBreedBatch = ParentBreedBatchFactory.getLocalInstance(ctx).getParentBreedBatchInfo(new ObjectUuidPK(parentBreedBatch.getId()));
			}
			CostObjectInfo babyCostObject = parentBreedBatch.getBabyCostObject();
			CostObjectInfo youngCostObject = parentBreedBatch.getYoungCostObject();
//			CostObjectInfo adultCostObject = parentBreedBatch.getAdultCostObject();
			CostObjectInfo eggCostObject = parentBreedBatch.getEggCostObject();
			
			
//			if(babyCostObject == null){
//				throw new EASBizException(new NumericExceptionSubItem("001","批次育雏阶段成本对象尚未设置，不能填报日报"));
//			}
			// 如果已经转育成，则育成成本对象不能为空
			if(parentBreedBatch.isIsToBreed()){
				if(youngCostObject == null){
					throw new EASBizException(new NumericExceptionSubItem("001","批次已转育成，但是育成阶段成本对象尚未设置，不能填报日报"));
				}
			}
			
			// 如果已经转产蛋，则产蛋成本对象不能为空
			if(parentBreedBatch.isIsToLayegg()){
				
				if(eggCostObject == null){
					throw new EASBizException(new NumericExceptionSubItem("001","批次已转产蛋，但是种蛋成本对象尚未设置，不能填报日报"));
				}
			}
		}
	}
	/**
	 * 校验 产蛋日报 要料计划，同一天不能有重复要料计划
	 * @param ctx
	 * @param billInfo
	 * @throws EASBizException 
	 * @throws BOSException 
	 */
	private void checkFodderPlan(Context ctx,LayEggDailyInfo billInfo) throws EASBizException, BOSException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 单据内校验不能有重复记录
		StringBuilder dateStrs = new StringBuilder("(");
//		StringBuilder towerIDs = new StringBuilder("(");
		String billID = "";
		if(billInfo != null && billInfo.getId() != null){
			billID = billInfo.getId().toString();
		}
		// 单据要料计划分录
		if(billInfo.getFodderEntrys() != null && billInfo.getFodderEntrys().size() > 0){
			// 查询重复的日期
			String sql = "select 1 from CT_FM_LayEggDailyFodderEntrys te where  te.CFFodderTowerID = ? and to_char(te.CFFodderDate,'yyyy-mm-dd') =? ";
			if(StringUtils.isNotBlank(billID)){
				sql = "select 1 from CT_FM_LayEggDailyFodderEntrys te  where te.CFFodderTowerID = ? and to_char(te.CFFodderDate,'yyyy-mm-dd') =? and te.fparentid <> ?";
			}
			for(int i = 0; i < billInfo.getFodderEntrys().size(); i++){
				String currPlanDateStr = sdf.format(billInfo.getFodderEntrys().get(i).getFodderDate());
				String towerID = billInfo.getFodderEntrys().get(i).getFodderTower().getId().toString();
				// 同一个料塔 有重复要料信息
				if( dateStrs.indexOf(currPlanDateStr+towerID) >= 0){
					throw new EASBizException(new NumericExceptionSubItem("001","要料计划分录中存在日期重复的数据"));
				}
				
				// 数据暂存
				dateStrs.append("'").append(currPlanDateStr).append(towerID).append("',");
//				towerIDs.append("'").append(towerID).append("',");
				
				Object[] args1  = {towerID,currPlanDateStr};
				Object[] args2  = {towerID,currPlanDateStr,billID};
				
				
				try{
					
					IRowSet rs ;
					if(StringUtils.isNotBlank(billID)){
						rs = DbUtil.executeQuery(ctx, sql,args2);
					}else{
						rs = DbUtil.executeQuery(ctx, sql,args1);
					}
					if(rs.next()){
						throw new EASBizException(new NumericExceptionSubItem("001","要料计划分录中第" + (i+1) +"行分录料塔已经存在对应要料日期的要料计划，不能重复要料"));
					}
				}catch(SQLException sqle){
					sqle.printStackTrace();
					throw new BOSException(sqle);
				}
				
			}
			
			
		}
	}
	
	/**
	 * 更新批次 定栏信息
	 * @param ctx 
	 * @param billInfo
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void updateBatchFixedInfo(Context ctx, LayEggDailyInfo billInfo) throws BOSException, EASBizException{
		// 如果选中了是否 定栏，则校验是否已经存在定栏 日报，如果不存在则 提交 同时更新批次定栏信息
		if(billInfo.isIsFixed()){
			// 校验是否之前已经定过栏
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String sql = "select 1 from CT_FM_LayEggDaily where cfisfixed= 1 and CFBreedBatchID =? and CFfarmID=? and FBizDate< {ts'" + sdf.format(billInfo.getBizDate()) +"'} ";
			Object[] args = {billInfo.getParentBatch().getId().toString(),
					billInfo.getFarm().getId().toString()
					};
			IRowSet rs = DbUtil.executeQuery(ctx, sql,args);
			try{
				if(rs.next()){
					throw new EASBizException(new NumericExceptionSubItem("001","当前日报对应批次已经已经定栏 过，不能多次定栏"));
				}else{
					LayEggDailyCullDeathEntryCollection cullAndDeathCol = billInfo.getCullDeathEntrys();
					ParentBreedBatchInfo batchInfo = billInfo.getParentBatch();
					for(int i = 0; i < cullAndDeathCol.size(); i++){
						// 逐个循环 更新对应批次的  分录定栏信息
						LayEggDailyCullDeathEntryInfo entryInfo = cullAndDeathCol.get(i);
						HenhouseInfo houseInfo = entryInfo.getHenhouse();
						int henfixedQty = entryInfo.getHenhouseBreekingStock();
						int cockfixedQty = entryInfo.getCockBreekingStock();
						
						String upsql = "update CT_FM_BreedBatchEntry  set CFHenFixedQty=?, CFCockFixedQty=? where CFHenHouseID =? and fparentid =? ";
						Object[] upargs = {henfixedQty,
								cockfixedQty,
								houseInfo.getId().toString(),
								batchInfo.getId().toString()};
						
						DbUtil.execute(ctx, upsql, upargs);
						
//						StringBuilder upsql = new StringBuilder("update CT_FM_BreedBatchEntry  set CFHenFixedQty=");
//						upsql.append(henfixedQty);
//						upsql.append(" and CFCockFixedQty=");
//						upsql.append(cockfixedQty);
//						upsql.append(" where CFHenHouseID ='");
//						upsql.append(houseInfo.getId().toString());
//						upsql.append("' and fparentid ='");
//						upsql.append(batchInfo.getId().toString());
//						upsql.append("'");
//						
//						DbUtil.execute(ctx, upsql.toString());
					}
				}
			}catch(SQLException sqle){
				throw new EASBizException(new NumericExceptionSubItem("001","更新批次定栏信息报错：" + sqle.getMessage()));
			}
		}
	}
	
	/**
	 * 分摊合格蛋、畸形蛋、双黄蛋、碎蛋
	 * @param ctx
	 * @param billInfo
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private LayEggDailyInfo shareEggs(Context ctx,LayEggDailyInfo billInfo) throws EASBizException, BOSException{
		Map<String,Object> eggEntryInfos = new HashMap<String, Object>();
		
		
		if(billInfo != null){
			// 产蛋分录
			LayEggDailyLayEggEntryCollection layEggColl = billInfo.getLayEggEntrys();
			// 传送带分录
			LayEggDailyConveyorCollection conveyorColl = billInfo.getConveyor();
			
			// 将每个传送带的数据均分到对应的 鸡舍
			
			if(layEggColl != null &&
					layEggColl.size() > 0 && 
					conveyorColl != null && 
					conveyorColl.size() > 0){
				// 按传送带分组
				Map<LayEggDailyConveyorInfo,List<LayEggDailyLayEggEntryInfo>> conveyorLayeggentrys = new HashMap<LayEggDailyConveyorInfo, List<LayEggDailyLayEggEntryInfo>>();
				// 将传送带与 产蛋分录进行匹配
				for(int i = 0; i < conveyorColl.size();i++){
					LayEggDailyConveyorInfo conveyorInfo = conveyorColl.get(i);
					if(conveyorInfo != null){
						// 传送带信息完整才能分摊
						if(conveyorInfo.getConveyorNumber() == null){
							conveyorInfo = LayEggDailyConveyorFactory.getLocalInstance(ctx).getLayEggDailyConveyorInfo(new ObjectUuidPK(conveyorInfo.getId()));
							
						}
						if(conveyorInfo.getConveyorNumber() == null){
							continue;
						}
						
						
					}
					// 传送带分录添加到 map中
					List<LayEggDailyLayEggEntryInfo> layeggs = new ArrayList<LayEggDailyLayEggEntryInfo>();
					conveyorLayeggentrys.put(conveyorInfo, layeggs);
					
					int conveyorHouseEggs = 0;
					// 循环 产蛋分录 逐个判断属于哪条传送带，然后添加到对应列表中
					for(int j = 0; j < layEggColl.size(); j++){
						LayEggDailyLayEggEntryInfo layeggEntry = layEggColl.get(j);
						if(layeggEntry != null && layeggEntry.getHenhouse() != null){
							HenhouseInfo henhouseInfo = layeggEntry.getHenhouse();
							if(henhouseInfo != null){
								if(henhouseInfo.getConveyor() == null){
									henhouseInfo = HenhouseFactory.getLocalInstance(ctx).getHenhouseInfo(new ObjectUuidPK(henhouseInfo.getId()));
								}
								if(henhouseInfo.getConveyor() != null){
									// 产蛋分录的鸡舍中的  传送带与 传送带分录的 传送带一致则添加到 map中
									if(henhouseInfo.getConveyor().getId().toString().equals(conveyorInfo.getConveyorNumber().getId().toString())){
										layeggs.add(layeggEntry);
										
										conveyorHouseEggs = conveyorHouseEggs + layeggEntry.getAllEggs();
									}
								}else{
									continue;
								}
							}
						}
						
						
						
					}
					
					// 对应蛋带 产蛋总数与所包含鸡舍 产蛋总数比对，如果不一致 则提示
					int conveyoreggs = conveyorInfo.getQualifiedEggs()+ conveyorInfo.getFreakEggs()+conveyorInfo.getDoubleYolkedEggs()+conveyorInfo.getBrokenEggs();
					// 有差额 则提示用户
					int diff = conveyoreggs-conveyorHouseEggs;
					if(diff != 0){
						EggConveyorInfo conInfo =  conveyorInfo.getConveyorNumber();
						if(conInfo.getNumber() == null) conInfo = EggConveyorFactory.getLocalInstance(ctx).getEggConveyorInfo(new ObjectUuidPK(conInfo.getId()));
						throw new BOSException(conInfo.getNumber()+"号蛋带总蛋量与对应鸡舍总蛋量之和不相等，相差 " + diff );
					}
					
				}
				
				
				}
			}
			BigDecimal coal = billInfo.getCoalFual()==null?BigDecimal.ZERO : billInfo.getCoalFual();
			BigDecimal diesel = billInfo.getDieselFual()==null?BigDecimal.ZERO : billInfo.getDieselFual();
			
			LayEggDailyEntryCollection entryColl = billInfo.getEntrys();
			if(entryColl != null && entryColl.size() > 0){
				BigDecimal coalShare = coal.divide(new BigDecimal(entryColl.size()), 2,RoundingMode.HALF_UP);
				BigDecimal dieselShare = diesel.divide(new BigDecimal(entryColl.size()), 2,RoundingMode.HALF_UP);
				// 尾差放到最后一条分录中
				BigDecimal coalResidue = coal.subtract(coalShare.multiply(new BigDecimal(entryColl.size())));
				BigDecimal dieselResidue = diesel.subtract(dieselShare.multiply(new BigDecimal(entryColl.size())));
				for(int i = 0; i < entryColl.size(); i++){
					LayEggDailyEntryInfo entryInfo = entryColl.get(i);
					if(i == entryColl.size() - 1){
						entryInfo.setCoalShare(coalShare.add(coalResidue));
						entryInfo.setDieselShare(dieselShare.add(dieselResidue));
					}else{
						entryInfo.setCoalShare(coalShare);
						entryInfo.setDieselShare(dieselShare);
					}
				}
				
			}
		
		return billInfo;
	}
	/**
	 * 分摊燃煤和 柴油
	 * @param ctx
	 * @param billInfo
	 */
	private LayEggDailyInfo shareCoalAndDiesel(Context ctx,LayEggDailyInfo billInfo){
		if(billInfo != null){
			BigDecimal coal = billInfo.getCoalFual()==null?BigDecimal.ZERO : billInfo.getCoalFual();
			BigDecimal diesel = billInfo.getDieselFual()==null?BigDecimal.ZERO : billInfo.getDieselFual();
			
			LayEggDailyEntryCollection entryColl = billInfo.getEntrys();
			if(entryColl != null && entryColl.size() > 0){
				BigDecimal coalShare = coal.divide(new BigDecimal(entryColl.size()), 2,RoundingMode.HALF_UP);
				BigDecimal dieselShare = diesel.divide(new BigDecimal(entryColl.size()), 2,RoundingMode.HALF_UP);
				// 尾差放到最后一条分录中
				BigDecimal coalResidue = coal.subtract(coalShare.multiply(new BigDecimal(entryColl.size())));
				BigDecimal dieselResidue = diesel.subtract(dieselShare.multiply(new BigDecimal(entryColl.size())));
				for(int i = 0; i < entryColl.size(); i++){
					LayEggDailyEntryInfo entryInfo = entryColl.get(i);
					if(i == entryColl.size() - 1){
						entryInfo.setCoalShare(coalShare.add(coalResidue));
						entryInfo.setDieselShare(dieselShare.add(dieselResidue));
					}else{
						entryInfo.setCoalShare(coalShare);
						entryInfo.setDieselShare(dieselShare);
					}
				}
				
			}
		}
		
		return billInfo;
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		// 状态设置为保存
		LayEggDailyInfo info =  this.getLayEggDailyInfo(ctx, pk);
		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	){
			throw new EASBizException(new NumericExceptionSubItem("001","只能删除暂存或者新增状态的单据"));
		}
		super._delete(ctx, pk);
	}
	
	/**
     * 审核
     */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		LayEggDailyInfo billInfo = (LayEggDailyInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				
				throw new FarmException("已经存在下游单据，不能审核");
			}
			// 更新单据状态
			AppCommon.updateModelStatus(ctx, "CT_FM_LayEggDaily", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
			// 生成批次调拨信息
			updateTransToBatch(ctx,billInfo);
		}else{
			throw new FarmException("只能审核提交状态的单据");
		}
		
	}

	/**
	 * 反审核
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException {
		
		LayEggDailyInfo billInfo = (LayEggDailyInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("已经存在下游单据，不能反审核");
			}else{
				// 校验当前批次是否已经生成了 日报 
				// TODO 
			}
			// 移除定栏信息 TODO 保存操作日志
//			removeBatchFixedInfo(ctx,billInfo);
			// 更新定栏状态
			updateBatchFixedState(ctx,billInfo,false);
			// 更新单据状态
			AppCommon.updateModelStatus(ctx, "CT_FM_LayEggDaily", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);
			// 删除关联 批次的转栏信息
			removeBatchTransInfos(ctx,billInfo);
		}else{
			throw new FarmException("只能反审核审核状态的单据");
		}
	}
	
	
	/**
	 * 删除批次 定栏信息
	 * @param ctx 
	 * @param billInfo
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void removeBatchFixedInfo(Context ctx, LayEggDailyInfo billInfo) throws BOSException{
		// 如果选中了是否 定栏，则校验是否已经存在定栏 日报，如果不存在则 提交 同时更新批次定栏信息
		if(billInfo.isIsFixed()){
			// 校验是否之前已经定过栏
		
				LayEggDailyCullDeathEntryCollection cullAndDeathCol = billInfo.getCullDeathEntrys();
				ParentBreedBatchInfo batchInfo = billInfo.getParentBatch();
				for(int i = 0; i < cullAndDeathCol.size(); i++){
					// 逐个循环 更新对应批次的  分录定栏信息
					LayEggDailyCullDeathEntryInfo entryInfo = cullAndDeathCol.get(i);
					HenhouseInfo houseInfo = entryInfo.getHenhouse();
					
					
					String upsql = "update CT_FM_BreedBatchEntry  set CFHenFixedQty=0, CFCockFixedQty=0 where fparentid =? ";
					Object[] upargs = {
							batchInfo.getId().toString()};
					
					DbUtil.execute(ctx, upsql, upargs);
					

				}
				
			
		}
	}
	/**
	 * 生成下游单据
	 */
	@Override
	protected List _genNextBill(Context ctx, IObjectValue model)
			throws BOSException {
		
		// 状态校验
		LayEggDailyInfo billInfo = (LayEggDailyInfo) model;
		if(!BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			throw new FarmException("只有审核状态的单据才能生成下游单据");
		}
		// 下游单据校验
		boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
		if(exist){
			throw new FarmException("已经存在下游单据，不能再次生成");
		}
		
		
		
		
		
//		List<String> botIDs = AppCommon.getBillBotMappings(ctx, this.getBOSType().toString(), DefineSysEnum.BTP, true);
		CoreBaseCollection destCol=new CoreBaseCollection();
		// 转换规则ID
		
		// 结果
		List<ExecBotpResultInfo>  execResults = new ArrayList<ExecBotpResultInfo>();
		try{
			
			// 获取所有可用的botcoll
			String srcBillType = this.getBOSType().toString();
			String[] srcBillIDs = {billInfo.getId().toString()};
			String[] entryNames = {"entrys"};
			List entriesKey = new ArrayList<String>();
			LayEggDailyEntryCollection entryColl = billInfo.getEntrys();
			if(entryColl.size() > 0){
				for(int i = 0; i < entryColl.size(); i++){
					LayEggDailyEntryInfo entryInfo = entryColl.get(i);
					if(entryInfo != null && entryInfo.getId() != null){
						entriesKey.add(entryInfo.getId().toString());
					}
				}
			}
			
			SelectorItemCollection botpSelectors = null;
			
			BotpAppCommon botpAppComm = new BotpAppCommon();
			BOTMappingCollection botColl = botpAppComm.getAllCanUsedBots(ctx,srcBillType,srcBillIDs,entryNames,entriesKey,botpSelectors);
			
			// 获取所有可用的botp 后逐个执行操作
			if(botColl != null && botColl.size() > 0){
				
				BOTMappingCollection inbots = new BOTMappingCollection();
				BOTMappingCollection outbots = new BOTMappingCollection();
				for(int i = 0; i < botColl.size(); i++){
					
					
					BOTMappingInfo botMappingInfo = botColl.get(i);
					
					if(botMappingInfo.getAlias().indexOf("入库") > -1){
						inbots.add(botMappingInfo);
					}else{
						outbots.add(botMappingInfo);
					}
					
				}
				
				// 执行结果 
				ExecBotpResultInfo  resultInfo;
				// 先生成入库单据
				for(int i = 0; i < inbots.size(); i++)
				{
					{
						BOTMappingInfo botMappingInfo = inbots.get(i);
						resultInfo = this.getEmptyExecresult(ctx, billInfo);
						resultInfo.setMappingName(botMappingInfo.getAlias());
						resultInfo.setMappingNumber(botMappingInfo.getName());
						
						try{
							
							IObjectValue destObj = botpAppComm.transformForBotp(ctx, 
									srcBillIDs,
									entryNames, 
									entriesKey, 
									botpSelectors,
									botMappingInfo.getDestEntityName(), 
									new ObjectUuidPK(botMappingInfo.getId()), 
									srcBillType,
									resultInfo);
							// 增加到结果列表中
							execResults.add(resultInfo);
						}catch(Exception e){
							System.out.println(botMappingInfo.getAlias());
	//						if(e.getMessage().indexOf("不符合") > -1){
								e.printStackTrace();
								// 增加到结果列表中
								execResults.add(resultInfo);
								continue;
	//						}else{
	//							e.printStackTrace();
	//						}
						}
	//					// 生成下游单据后
	//					if(destObj != null ){
	//						destCol.add((CoreBaseInfo) destObj);
	//						
	//					}
					}
				}
				
				// 后生成调拨单据 和出库单据
				for(int i = 0; i < outbots.size(); i++)
				{
					{
						BOTMappingInfo botMappingInfo = outbots.get(i);
						resultInfo = this.getEmptyExecresult(ctx, billInfo);
						resultInfo.setMappingName(botMappingInfo.getAlias());
						resultInfo.setMappingNumber(botMappingInfo.getName());
						try{
							
							IObjectValue destObj = botpAppComm.transformForBotp(ctx, 
									srcBillIDs,
									entryNames, 
									entriesKey, 
									botpSelectors, 
									botMappingInfo.getDestEntityName(), 
									new ObjectUuidPK(botMappingInfo.getId()),
									srcBillType,
									resultInfo);
							
							// 库存调拨单执行直接调拨操作
							if(botMappingInfo.getAlias().indexOf("调拨") > 0){
								StockTransferBillInfo transferBillInfo = (StockTransferBillInfo) destObj;
								try{
									if(autoTransfer(ctx,transferBillInfo)){
										resultInfo.setDestBillStatus("关闭");
									}
								}catch(Exception e){
									resultInfo.setError(resultInfo.getError() + e.getMessage());
									throw e;
								}
							}
							// 增加到结果列表中
							execResults.add(resultInfo);
						}catch(Exception e){
							System.out.println(botMappingInfo.getAlias());
							e.printStackTrace();
							// 增加到结果列表中
							execResults.add(resultInfo);
	//						if(e.getMessage().indexOf("不符合") > -1){
								continue;
	//						}else{
	//							throw e;
	//						}
						}
						
					}
				}
			}
			
		}catch(Exception e){
			AppCommon.deleteBTPBills(ctx, destCol);
			e.printStackTrace();
			throw new FarmException(e);
		}
		
		return execResults;
	}
	
	/**
	 * 库存调拨单直接调拨
	 * @param ctx
	 * @param transferBillInfo
	 * @throws Exception 
	 */
	private boolean autoTransfer(Context ctx,StockTransferBillInfo transferBillInfo) throws Exception{
		// 先校验 ，然后执行操作
		if(transferBillInfo != null){
			BizTypeInfo bizTypeInfo = transferBillInfo.getBizType();
			if(bizTypeInfo == null){
				return false;
			}
			
			StockTransferBillEntryCollection entryCol = transferBillInfo.getEntry();
			// 逐个分录执行
			if(entryCol != null && entryCol.size() > 0){
				for(int i = 0; i < entryCol.size();i++){
					StockTransferBillEntryInfo entryInfo = entryCol.get(i);
					if(entryInfo.getMaterial() == null){
						continue;
					}else{
						// 校验仓库
						WarehouseInfo outWsInfo = entryInfo.getIssueWarehouse();
						WarehouseInfo inWsInfo = entryInfo.getReceiptWarehouse();
						LocationInfo outLocationInfo = entryInfo.getIssueLocation();
						LocationInfo inLocationInfo = entryInfo.getReceiptLocation();
						
						if(outWsInfo == null){
							throw new Exception("分录中调出仓库为空");
						}
						if(inWsInfo == null){
							throw new Exception("分录中调入仓库为空");
						}
//						if(outLocationInfo == null){
//							throw new Exception("分录中调出仓位为空");
//						}
//						if(inLocationInfo == null){
//							throw new Exception("分录中调入仓位为空");
//						}
						
						
					}
				}
				
				// 执行直接调拨  功能
				
				UserInfo aUserInfo = ContextUtil.getCurrentUserInfo(ctx);
				IObjectPK userPK = new ObjectUuidPK(aUserInfo.getId());
				IObjectPK moveOutStoragePK = new ObjectUuidPK(transferBillInfo
						.getIssueStorageOrgUnit().getId());
				IObjectPK moveInStoragePK = new ObjectUuidPK(transferBillInfo
						.getReceiptStorageOrgUnit().getId());

//				SCMClientUtils.checkFunctionPermission(userPK, moveOutStoragePK,
//						"moveissue_new");
//				SCMClientUtils.checkFunctionPermission(userPK, moveOutStoragePK,
//						"moveissue_audit");
//
//				SCMClientUtils.checkFunctionPermission(userPK, moveInStoragePK,
//						"moveinwarehs_new");
//				SCMClientUtils.checkFunctionPermission(userPK, moveInStoragePK,
//						"moveinwarehs_audit");

				if ((transferBillInfo != null) && (transferBillInfo.getId() != null)) {
					
//					StockTransferBillFactory.getLocalInstance(ctx).checkAutoTransferForLot(transferBillInfo.getId().toString());
					StockTransferBillFactory.getLocalInstance(ctx).checkAutoTransfer(transferBillInfo.getId().toString());
				}
				String[] billNumber = StockTransferBillFactory.getLocalInstance(ctx)
						.autoTransfer(transferBillInfo);

				
			}else{
				return false;
			}
		}else{
			return false;
		}
		
		return true;
	}
	private void autoTransfer() throws EASBizException, Exception {
		
	}
	private boolean isAboutCustomerStore(StoreTypeInfo storeTypeInfo) {
		StoreFlagEnum storeFlag = (storeTypeInfo == null) ? null
				: storeTypeInfo.getStoreFlag();
		int storeFlagValue = (storeFlag == null) ? -1 : storeFlag.getValue();
		return ((storeFlagValue == 3) || (storeFlagValue == 4));
	}
	
	private boolean isAboutSupplierStore(StoreTypeInfo storeTypeInfo) {
		StoreFlagEnum storeFlag = (storeTypeInfo == null) ? null
				: storeTypeInfo.getStoreFlag();
		int storeFlagValue = (storeFlag == null) ? -1 : storeFlag.getValue();
		return ((storeFlagValue == 2) || (storeFlagValue == 5));
	}
	
	/**
	 * 根据当前单据获得空（不包含目标单据信息）的返回结果信息
	 * @param ctx
	 * @param billInfo
	 * @return
	 */
	private ExecBotpResultInfo getEmptyExecresult(Context ctx,LayEggDailyInfo billInfo){
		ExecBotpResultInfo execResult = new ExecBotpResultInfo();
		execResult.setSrcEntiryName("产蛋鸡日报");
		execResult.setSrcObjectNumber(billInfo.getNumber());
		execResult.setSrcEntityBostype(this.getBOSType().toString());
//		execResult.se
		return execResult;
		
		
	}

	/**
	 * 重新分摊 合格蛋、  燃煤、柴油
	 */
	@Override
	protected void _reShareInfos(Context ctx, IObjectValue model)
			throws BOSException {
		
		LayEggDailyInfo billInfo = (LayEggDailyInfo) model;
		try{
			billInfo = this.getLayEggDailyInfo(ctx, new ObjectUuidPK(billInfo.getId()));
			// 提交前分摊燃煤和 燃油
			shareCoalAndDiesel(ctx,billInfo);
			
			// 提交前分摊 合格蛋和畸形蛋
//			shareEggs(ctx,billInfo);
			
			
			this._update(ctx, new ObjectUuidPK(billInfo.getId()),billInfo);
		}catch(EASBizException bizE){
			throw new BOSException(bizE);
		}
	}
	
	
	/**
	 * 根据当前  设置的   成本对象信息更新批次 相关 成本对象
	 * @throws BOSException 
	 */
	private void updateBatchCost(Context ctx,LayEggDailyInfo billInfo) throws BOSException{
//		// 转育成
//		if(billInfo.isIsTransBrood()){
//			CostObjectInfo broodCostObject = billInfo.getBroodCostObject();
//			ParentBreedBatchInfo batchInfo = billInfo.getParentBatch();
//			if(batchInfo != null && broodCostObject != null){
//				String cosID = broodCostObject.getId().toString();
//				String batchID = batchInfo.getId().toString();
//				
//				String sql = "update CT_FM_ParentBreedBatch set CFYoungCostObjectI =? where fid=? ";
//				String[] args = {cosID,batchID};
//				DbUtil.execute(ctx, sql, args);
//				
//			}
//		}
//		// 定栏
//		if(billInfo.isIsFixed()){
//			CostObjectInfo adultCostObject = billInfo.getLayEggCostObject();
//			ParentBreedBatchInfo batchInfo = billInfo.getParentBatch();
//			if(batchInfo != null && adultCostObject != null){
//				String cosID = adultCostObject.getId().toString();
//				String batchID = batchInfo.getId().toString();
//				
//				String sql = "update CT_FM_ParentBreedBatch set CFAdultCostObjectI =? where fid=? ";
//				String[] args = {cosID,batchID};
//				DbUtil.execute(ctx, sql, args);
//				
//			}
//		}
	}
	
	/**
	 * 更新批次 转栏数据 
	 * @throws BOSException 
	 */
	private void updateTransToBatch(Context ctx, LayEggDailyInfo dailyInfo) throws BOSException{
		try{
			if(dailyInfo != null ){
				LayEggDailyTransHenhouseEntryCollection transEntryColl = dailyInfo.getTransHenhouseEntrys();
				// 如果存在转栏 明细  则更新对应批次信息
				if(transEntryColl != null && transEntryColl.size() > 0){
					for(int i = 0; i < transEntryColl.size(); i++){
						LayEggDailyTransHenhouseEntryInfo transInfo = transEntryColl.get(i);
						transInfo = LayEggDailyTransHenhouseEntryFactory.getLocalInstance(ctx).getLayEggDailyTransHenhouseEntryInfo(new ObjectUuidPK(transInfo.getId()));
						if(transInfo.isIsFromOtherBatch()){
							// 生成转出批次的  转栏记录  
	//						transInfo.getf
							ParentBreedBatchInfo fromBatch = transInfo.getFromBatch();
							if(fromBatch == null){
								throw new BOSException("生成跨批次转栏信息时未取到转出批次，请核对转栏信息维护是否完整");
							}else{
//								fromBatch = ParentBreedBatchFactory.getLocalInstance(ctx).getParentBreedBatchInfo(new ObjectUuidPK(fromBatch.getId()));
//								ParentBreedBatchTransEntryCollection batchTransColl = fromBatch.getTransEntrys();
								ParentBreedBatchTransEntryInfo newBatchTransEntry = new ParentBreedBatchTransEntryInfo();
								newBatchTransEntry.setParent(fromBatch);
								newBatchTransEntry.setIsTransOut(true);
								
								newBatchTransEntry.setIsFromOtherBatch(true);
								
								newBatchTransEntry.setFromBatch(transInfo.getFromBatch());
								newBatchTransEntry.setFromHenhouse(transInfo.getFromHenhouse());
								newBatchTransEntry.setOutHousefield(transInfo.getFromField());
								newBatchTransEntry.setToBatch(dailyInfo.getParentBatch());
								newBatchTransEntry.setToHenhouse(transInfo.getToHenhouse());
								newBatchTransEntry.setInHousefield(transInfo.getToField());
								newBatchTransEntry.setTransDate(dailyInfo.getBizDate());
								newBatchTransEntry.setTransHenQty(transInfo.getTransHenQty());
								newBatchTransEntry.setTransCockQty(transInfo.getTransCockQty());
								
								newBatchTransEntry.setTransWeeks(dailyInfo.getWeek());
								newBatchTransEntry.setTransWeekDays(dailyInfo.getWeekDay());
								
								newBatchTransEntry.setSourceBillID(dailyInfo.getId().toString());
								newBatchTransEntry.setSourceEntryID(transInfo.getId().toString());
								ParentBreedBatchTransEntryFactory.getLocalInstance(ctx).addnew(newBatchTransEntry);
								// 计算折合 入栏量 TODO
								// 折合 种蛋 TODO 
								
							}
							
						}
						
						
						// 生成当前批次的 转栏记录
						ParentBreedBatchTransEntryInfo newBatchTransEntry = new ParentBreedBatchTransEntryInfo();
						newBatchTransEntry.setParent(dailyInfo.getParentBatch());
						newBatchTransEntry.setIsTransOut(false);
						newBatchTransEntry.setIsFromOtherBatch(transInfo.isIsFromOtherBatch());
						newBatchTransEntry.setIsBuy(transInfo.isIsBuy());
						newBatchTransEntry.setSupplier(transInfo.getSupplier());
						
						newBatchTransEntry.setFromBatch(transInfo.getFromBatch());
						newBatchTransEntry.setFromHenhouse(transInfo.getFromHenhouse());
						newBatchTransEntry.setOutHousefield(transInfo.getFromField());
						newBatchTransEntry.setToBatch(dailyInfo.getParentBatch());
						newBatchTransEntry.setToHenhouse(transInfo.getToHenhouse());
						newBatchTransEntry.setInHousefield(transInfo.getToField());
						newBatchTransEntry.setTransDate(dailyInfo.getBizDate());
						newBatchTransEntry.setTransHenQty(transInfo.getTransHenQty());
						newBatchTransEntry.setTransCockQty(transInfo.getTransCockQty());
						
						newBatchTransEntry.setTransWeeks(dailyInfo.getWeek());
						newBatchTransEntry.setTransWeekDays(dailyInfo.getWeekDay());
						
						newBatchTransEntry.setSourceBillID(dailyInfo.getId().toString());
						newBatchTransEntry.setSourceEntryID(transInfo.getId().toString());
						ParentBreedBatchTransEntryFactory.getLocalInstance(ctx).addnew(newBatchTransEntry);
						// 计算折合 入栏量 TODO
						// 折合 种蛋 TODO 
						
						
					}
				}
			}
		}catch(EASBizException bize){
			bize.printStackTrace();
			throw new BOSException(bize);
		}
		
	}
	
	/**
	 * 删除批次 转栏数据 
	 * @throws BOSException 
	 */
	private void removeBatchTransInfos(Context ctx, LayEggDailyInfo dailyInfo) throws BOSException{
		
		
		if(dailyInfo != null ){
			LayEggDailyTransHenhouseEntryCollection transEntryColl = dailyInfo.getTransHenhouseEntrys();
			// 如果存在转栏 明细  则更新对应批次信息
			if(transEntryColl != null && transEntryColl.size() > 0){
				for(int i = 0; i < transEntryColl.size(); i++){
					LayEggDailyTransHenhouseEntryInfo transInfo = transEntryColl.get(i);
					String sql = "delete from CT_FM_ParentBBTE where CFSourceBillID=? and CFSourceEntryID=? ";
					Object[] args = {dailyInfo.getId().toString(),transInfo.getId().toString()};
					DbUtil.execute(ctx, sql, args);
				}
			}
		}
							
		
	}
}