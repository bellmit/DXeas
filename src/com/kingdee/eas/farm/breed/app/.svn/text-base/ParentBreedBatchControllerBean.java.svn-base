package com.kingdee.eas.farm.breed.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.BreedAreaFactory;
import com.kingdee.eas.farm.breed.BreedAreaInfo;
import com.kingdee.eas.farm.breed.HenhouseFactory;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.HouseFieldFactory;
import com.kingdee.eas.farm.breed.HouseFieldInfo;
import com.kingdee.eas.farm.breed.ParentBreedBatchEntryCollection;
import com.kingdee.eas.farm.breed.ParentBreedBatchEntryFieldDetailEntryCollection;
import com.kingdee.eas.farm.breed.ParentBreedBatchEntryFieldDetailEntryInfo;
import com.kingdee.eas.farm.breed.ParentBreedBatchEntryInfo;
import com.kingdee.eas.farm.breed.ParentBreedBatchFactory;
import com.kingdee.eas.farm.breed.ParentBreedBatchInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class ParentBreedBatchControllerBean extends AbstractParentBreedBatchControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.breed.app.ParentBreedBatchControllerBean");
    

    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
    	ParentBreedBatchInfo billInfo = (ParentBreedBatchInfo)model;
    	if(billInfo != null  && 
    			( billInfo.getBaseStatus() == null ||  billInfo.getBaseStatus().equals(BillBaseStatusEnum.NULL) || BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) || BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) )){
    		billInfo.setBaseStatus( BillBaseStatusEnum.TEMPORARILYSAVED);
    		// 校验数据
    		checkEntrysData(ctx,billInfo);
//    		// 校验 成本对象是否已经被其他批次引用，如果已经被引用则不允许 提交
//    		String costObjectID = (billInfo.getCostObject()==null?"":billInfo.getCostObject().getId().toString());
//			String fid = (billInfo.getId()==null?"":billInfo.getId().toString());
//			checkBatchCostObject(ctx,costObjectID,fid);
//			
//			// 校验养殖计划是否被其他批次引用
//			String breedPlanID = (billInfo.getBreedPlan()==null?"":billInfo.getBreedPlan().getId().toString());
//			checkBatchPlanUsedStatus(ctx,breedPlanID,fid);
//			// 核对批次计划是否选错
//			checkBatchPlanMatchState(ctx,billInfo,breedPlanID);
    		return super._save(ctx, model);
    	}else{
//    		throw new FarmException("只能保存新增或保存状态的单据");
    		throw  new EASBizException(new NumericExceptionSubItem("001","只能保存新增或保存状态的单据"));
    	}
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		ParentBreedBatchInfo billInfo = (ParentBreedBatchInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()))){
    		billInfo.setBaseStatus( BillBaseStatusEnum.SUBMITED);
    		// 校验数据
    		checkEntrysData(ctx,billInfo);
//    		// 校验 成本对象是否已经被其他批次引用，如果已经被引用则不允许 提交
//    		String costObjectID = (billInfo.getCostObject()==null?"":billInfo.getCostObject().getId().toString());
//			String fid = (billInfo.getId()==null?"":billInfo.getId().toString());
//			checkBatchCostObject(ctx,costObjectID,fid);
//			// 校验养殖计划是否被其他批次引用
//			String breedPlanID = (billInfo.getBreedPlan()==null?"":billInfo.getBreedPlan().getId().toString());
//			checkBatchPlanUsedStatus(ctx,breedPlanID,fid);
//			// 核对批次计划是否选错
//			checkBatchPlanMatchState(ctx,billInfo,breedPlanID);
    		return super._submit(ctx, model);
    	}else{
//    		throw new FarmException("只能保存新增或保存状态的单据");
    		throw  new EASBizException(new NumericExceptionSubItem("001","只能保存新增或保存状态的单据"));
    	}
	}
	
	/**
	 * 校验批次 分录数据合法性
	 * @param billInfo
	 * @throws EASBizException 
	 * @throws BOSException 
	 */
	private void checkEntrysData(Context ctx,ParentBreedBatchInfo billInfo) throws EASBizException, BOSException{
		// 首先校验 区是否属于养殖场 TODO
		BreedAreaInfo areaInfo = billInfo.getBreedArea();
		if(areaInfo == null){
			throw  new EASBizException(new NumericExceptionSubItem("001","批次所属 区未选择"));
		}
		areaInfo = BreedAreaFactory.getLocalInstance(ctx).getBreedAreaInfo(new ObjectUuidPK(areaInfo.getId()));
		if(areaInfo.getFarm() == null){
			throw  new EASBizException(new NumericExceptionSubItem("001","批次所属 区 未设置养殖场"));
		}else if(!areaInfo.getFarm().getId().toString().equals(billInfo.getFarm().getId().toString())){
			throw  new EASBizException(new NumericExceptionSubItem("001","批次所属 区 所在养殖场与当前批次选择养殖场不一致"));
		}
		// 校验 分录 禽舍 是否与 养殖场、区匹配 TODO
		
		// 娇艳 单舍  栏位明细是否匹配，栏位是否重复 数量是否 相等  TODO
		
		ParentBreedBatchEntryCollection entryColl = billInfo.getEntrys();
		
		if(entryColl != null && entryColl.size() > 0){
			for(int i = 0; i < entryColl.size(); i++){
				ParentBreedBatchEntryInfo entryInfo = entryColl.get(i);
				HenhouseInfo currHenhouseInfo = entryInfo.getHenhouse();
				if(currHenhouseInfo == null){
					throw  new EASBizException(new NumericExceptionSubItem("001","入栏明细第" + (i+1)+"行未设置禽舍"));
				}
				currHenhouseInfo = HenhouseFactory.getLocalInstance(ctx).getHenhouseInfo(new ObjectUuidPK(currHenhouseInfo.getId()));
				
				if(currHenhouseInfo.getBreedArea() == null){
					throw  new EASBizException(new NumericExceptionSubItem("001","入栏明细第" + (i+1)+"行禽舍未设置区"));
				}
				if(!currHenhouseInfo.getBreedArea().getId().toString().equals(areaInfo.getId().toString())){
					throw  new EASBizException(new NumericExceptionSubItem("001","入栏明细第" + (i+1)+"行禽舍所属区与当前批次所选择区不一致"));
				}
				int henQty = entryInfo.getHenInitQty();
				int cockQty = entryInfo.getCockInitQty();
				List<String> fieldIDs = new ArrayList<String>();
				if(entryInfo != null){
					ParentBreedBatchEntryFieldDetailEntryCollection fieldsDetailColl = entryInfo.getFieldDetailEntrys();
					// 存在明细信息   则校验
					if(fieldsDetailColl!= null && fieldsDetailColl.size() > 0){
						int detailHenQty = 0;
						int detailCockQty = 0;
						for(int j = 0; j < fieldsDetailColl.size(); j++){
							ParentBreedBatchEntryFieldDetailEntryInfo detailInfo = fieldsDetailColl.get(j);
							HouseFieldInfo fieldInfo = detailInfo.getHousefield();
							
							if(fieldInfo == null){
								throw  new EASBizException(new NumericExceptionSubItem("001","入栏明细第" + (i+1)+"行分录的 栏位明细中存在 未设置栏位信息的记录"));
							}
							// 校验栏位是否 正确
							fieldInfo = HouseFieldFactory.getLocalInstance(ctx).getHouseFieldInfo(new ObjectUuidPK(fieldInfo.getId()));
							if(fieldInfo.getHenhouse() == null){
								throw  new EASBizException(new NumericExceptionSubItem("001","入栏明细第" + (i+1)+"行分录的 栏位"+fieldInfo.getName()+ "未设置禽舍信息"));
							}
							if(!fieldInfo.getHenhouse().getId().toString().equals(currHenhouseInfo.getId().toString())){
								throw  new EASBizException(new NumericExceptionSubItem("001","入栏明细第" + (i+1)+"行分录的禽舍 信息与 栏位"+fieldInfo.getName()+ "禽舍信息不一致"));
							}
							// 去重校验栏位不能重复
							if(fieldIDs.contains(fieldInfo.getId().toString())){
								throw  new EASBizException(new NumericExceptionSubItem("001","入栏明细第" + (i+1)+"行分录的 栏位明细中存在 重复的栏位设置"));
							}else{
								fieldIDs.add(fieldInfo.getId().toString());
							}
							detailHenQty = detailHenQty + detailInfo.getHenInitQty();
							detailCockQty = detailCockQty + detailInfo.getCockInitQty();
						}
						// 数量是否一致
						if(detailHenQty != henQty){
							throw  new EASBizException(new NumericExceptionSubItem("001","入栏明细第" + (i+1)+"行母禽入栏量与栏位明细入栏量合计不相等"));
						}
						// 数量是否一致
						if(detailCockQty != cockQty){
							throw  new EASBizException(new NumericExceptionSubItem("001","入栏明细第" + (i+1)+"行公禽入栏量与栏位明细入栏量合计不相等"));
						}
					}
				}
				
			}
		}
	}
	
	
	
	/**
	 * 校验 养殖计划是否被其他批次引用，如果已经被引用则 报错
	 * @param ctx
	 * @param costObjectID
	 * @param batchID
	 * @throws EASBizException 
	 * @throws BOSException 
	 */
	private void checkBatchPlanUsedStatus(Context ctx, String planID, String batchID) throws EASBizException, BOSException{
		StringBuilder sb  = new StringBuilder("");
		sb.append("select fid from ct_fm_Parentbreedbatch where cfbreedplanid='");
		sb.append(planID);
		sb.append("' ");
		if(StringUtils.isNotBlank(batchID)){
			sb.append(" and fid <> '");
			sb.append(batchID);
			sb.append("' ");
		}
		
		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		try{
			if(rs.next()){
				throw new EASBizException(new NumericExceptionSubItem("001","养殖计划已经被其他批次引用，不能重复引用"));
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
	}

//	/**
//	 * 校验 养殖批次和 养殖计划是否匹配
//	 * 目前暂时定义为  所有 鸡舍 入舍最大偏差不能超过20天
//	 * @param billInfo
//	 * @throws BOSException 
//	 * @throws EASBizException 
//	 */
//	public void checkBatchPlanMatchState(Context ctx, BreedBatchInfo billInfo,String breedPlanID) throws EASBizException, BOSException{
//		int maxDiffDays = 0;
//		// 先将批次鸡舍id和 入栏日期暂存map
//		Map<String,Date> batchInDate = new HashMap<String, Date>();
//		BreedBatchEntryCollection entryColl = billInfo.getEntrys();
//		if(entryColl != null && entryColl.size() > 0){
//			for(int i = 0; i < entryColl.size(); i++){
//				BreedBatchEntryInfo entryInfo = entryColl.get(i);
//				if(entryInfo.getHenHouse() != null && entryInfo.getIncoopDate() != null){
//					batchInDate.put(entryInfo.getHenHouse().getId().toString(), entryInfo.getIncoopDate());
//				}
//			}
//		}
//		
//		CCBreedPlanInfo planInfo = CCBreedPlanFactory.getLocalInstance(ctx).getCCBreedPlanInfo(new ObjectUuidPK(breedPlanID));
//		if(planInfo != null && planInfo.getEntrys() != null && planInfo.getEntrys().size() > 0){
//			for(int i = 0; i < planInfo.getEntrys().size(); i++){
//				CCBreedPlanEntryInfo planEntryInfo = planInfo.getEntrys().get(i);
//				if(planEntryInfo.getHenHouse() == null){
//					planEntryInfo = CCBreedPlanEntryFactory.getLocalInstance(ctx).getCCBreedPlanEntryInfo(new ObjectUuidPK(planEntryInfo.getId()));
//					
//				}
//				// 获取map中暂存的 鸡舍批次 入栏日期 并计算差额天数，
//				Date planDate = planEntryInfo.getIncoopDate();
//				if(planEntryInfo.getHenHouse() != null && planDate != null){
//					Date batchDate = batchInDate.get(planEntryInfo.getHenHouse().getId().toString());
//					int  diffDays = DateCommon.dateDiff(batchDate, planDate);
//					
//					if(diffDays > 20){
//						throw  new EASBizException(new NumericExceptionSubItem("001","养殖批次与对应养殖计划入栏明细相差日期过大，请仔细核对是否选错养殖计划！"));
//						
//					}
////					if(diffDays > maxDiffDays ){
////						maxDiffDays = diffDays;
////						
////						
////					}
//				}
//				
//			}
//		}
//	}
	/**
	 * 校验 成本对象是否被其他批次引用，如果已经被引用则 报错
	 * @param ctx
	 * @param costObjectID
	 * @param batchID
	 * @throws EASBizException 
	 * @throws BOSException 
	 */
	private void checkBatchCostObject(Context ctx, String costObjectID, String batchID) throws EASBizException, BOSException{
		StringBuilder sb  = new StringBuilder("");
		sb.append("select fid from ct_fm_Parentbreedbatch where cfcostobjectid='");
		sb.append(costObjectID);
		sb.append("' ");
		if(StringUtils.isNotBlank(batchID)){
			sb.append(" and fid <> '");
			sb.append(batchID);
			sb.append("' ");
		}
		
		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		try{
			if(rs.next()){
				throw new EASBizException(new NumericExceptionSubItem("001","成本对象已经被其他批次引用，不能重复引用"));
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		ParentBreedBatchInfo billInfo = ParentBreedBatchFactory.getLocalInstance(ctx).getParentBreedBatchInfo(pk);
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()))){
//    		// 校验当前批次是否已经生成了 日报 
//    		boolean isused = BreedFacadeFactory.getLocalInstance(ctx).isBatchGeneratedDailyInfos(billInfo.getId().toString(), billInfo.getHouseType().getValue());
//    		if(isused){
////    			throw new FarmException("当前养殖批次已经填报过日报信息，不能删除");
//    			throw  new EASBizException(new NumericExceptionSubItem("001","当前养殖批次已经填报过日报信息，不能删除"));
//    		}
    		super._delete(ctx, pk);
    		
    	}else{
//    		throw new FarmException("只能删除新增或保存状态的单据");
    		throw  new EASBizException(new NumericExceptionSubItem("001","只能删除新增或保存状态的单据"));
    	}
		
	}
	/**
     * 审核
     */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		ParentBreedBatchInfo billInfo = (ParentBreedBatchInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("已经存在下游单据，不能审核");
			}
//			String costObjectID = billInfo.getCostObject().getId().toString();
//			String fid = billInfo.getId().toString();
//			try {
//				checkBatchCostObject(ctx,costObjectID,fid);
//			} catch (EASBizException e) {
//				e.printStackTrace();
//				throw new FarmException(e.getMessage());
//			}
			// 更新单据状态
			AppCommon.updateModelStatus(ctx, "CT_FM_ParentBreedBatch", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
			
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
		
		ParentBreedBatchInfo billInfo = (ParentBreedBatchInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("已经存在下游单据，不能反审核");
			}else{
				// 校验当前批次是否已经生成了 日报  
				// 20151221 不再校验是否存在下游单据，而是改为通过权限控制
//				boolean isused = BreedFacadeFactory.getLocalInstance(ctx).isBatchGeneratedDailyInfos(billInfo.getId().toString(), billInfo.getHouseType().getValue());
//				if(isused){
//					throw new FarmException("当前养殖批次已经填报过日报信息，不能反审核");
//				}
			}
			
			
			// 更新单据状态
			AppCommon.updateModelStatus(ctx, "CT_FM_ParentBreedBatch", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);
			
		}else{
			throw new FarmException("只能反审核审核状态的单据");
		}
	}

	/**
	 * 更新 养殖批次分录的  是否完全出栏状态 和数量
	 */
	@Override
	protected void _updateBatchMarket(Context ctx, IObjectValue model)
			throws BOSException {
//		BreedBatchInfo billInfo = (BreedBatchInfo)model;
//		if(billInfo != null){
//			BreedFacadeFactory.getLocalInstance(ctx).updateBatchOutState(billInfo.getId().toString());
//		}
	}
	
	
    
}