package com.kingdee.eas.farm.breed.app;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.farm.breed.BreedBatchCollection;
import com.kingdee.eas.farm.breed.BreedBatchEntryCollection;
import com.kingdee.eas.farm.breed.BreedBatchEntryInfo;
import com.kingdee.eas.farm.breed.BreedBatchFactory;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.farm.breed.BreedFacadeFactory;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.farm.breed.business.CCBreedPlanEntryFactory;
import com.kingdee.eas.farm.breed.business.CCBreedPlanEntryInfo;
import com.kingdee.eas.farm.breed.business.CCBreedPlanFactory;
import com.kingdee.eas.farm.breed.business.CCBreedPlanInfo;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.DateCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BreedBatchControllerBean extends AbstractBreedBatchControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.breed.app.BreedBatchControllerBean");

    
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
    	BreedBatchInfo billInfo = (BreedBatchInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) || BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) )){
    		billInfo.setBaseStatus( BillBaseStatusEnum.TEMPORARILYSAVED);
    		// 校验 成本对象是否已经被其他批次引用，如果已经被引用则不允许 提交
    		String costObjectID = (billInfo.getCostObject()==null?"":billInfo.getCostObject().getId().toString());
			String fid = (billInfo.getId()==null?"":billInfo.getId().toString());
			checkBatchCostObject(ctx,costObjectID,fid);
			
			// 校验养殖计划是否被其他批次引用
			String breedPlanID = (billInfo.getBreedPlan()==null?"":billInfo.getBreedPlan().getId().toString());
			checkBatchPlanUsedStatus(ctx,breedPlanID,fid);
			// 核对批次计划是否选错
			if(StringUtils.isNotBlank(breedPlanID)){
				checkBatchPlanMatchState(ctx,billInfo,breedPlanID);
			}
    		return super._save(ctx, model);
    	}else{
//    		throw new FarmException("只能保存新增或保存状态的单据");
    		throw  new EASBizException(new NumericExceptionSubItem("001","只能保存新增或保存状态的单据"));
    	}
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		BreedBatchInfo billInfo = (BreedBatchInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()))){
    		billInfo.setBaseStatus( BillBaseStatusEnum.SUBMITED);
    		// 校验 成本对象是否已经被其他批次引用，如果已经被引用则不允许 提交
    		String costObjectID = (billInfo.getCostObject()==null?"":billInfo.getCostObject().getId().toString());
			String fid = (billInfo.getId()==null?"":billInfo.getId().toString());
			checkBatchCostObject(ctx,costObjectID,fid);
			// 校验养殖计划是否被其他批次引用
			String breedPlanID = (billInfo.getBreedPlan()==null?"":billInfo.getBreedPlan().getId().toString());
			checkBatchPlanUsedStatus(ctx,breedPlanID,fid);
			// 核对批次计划是否选错
			if(StringUtils.isNotBlank(breedPlanID)){
				checkBatchPlanMatchState(ctx,billInfo,breedPlanID);
			}
    		return super._submit(ctx, model);
    	}else{
//    		throw new FarmException("只能保存新增或保存状态的单据");
    		throw  new EASBizException(new NumericExceptionSubItem("001","只能保存新增或保存状态的单据"));
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
		sb.append("select fid from ct_fm_breedbatch where cfbreedplanid='");
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

	/**
	 * 校验 养殖批次和 养殖计划是否匹配
	 * 目前暂时定义为  所有 鸡舍 入舍最大偏差不能超过20天
	 * @param billInfo
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public void checkBatchPlanMatchState(Context ctx, BreedBatchInfo billInfo,String breedPlanID) throws EASBizException, BOSException{
		int maxDiffDays = 0;
		// 先将批次鸡舍id和 入栏日期暂存map
		Map<String,Date> batchInDate = new HashMap<String, Date>();
		BreedBatchEntryCollection entryColl = billInfo.getEntrys();
		if(entryColl != null && entryColl.size() > 0){
			for(int i = 0; i < entryColl.size(); i++){
				BreedBatchEntryInfo entryInfo = entryColl.get(i);
				if(entryInfo.getHenHouse() != null && entryInfo.getIncoopDate() != null){
					batchInDate.put(entryInfo.getHenHouse().getId().toString(), entryInfo.getIncoopDate());
				}
			}
		}
		
		CCBreedPlanInfo planInfo = CCBreedPlanFactory.getLocalInstance(ctx).getCCBreedPlanInfo(new ObjectUuidPK(breedPlanID));
		if(planInfo != null && planInfo.getEntrys() != null && planInfo.getEntrys().size() > 0){
			for(int i = 0; i < planInfo.getEntrys().size(); i++){
				CCBreedPlanEntryInfo planEntryInfo = planInfo.getEntrys().get(i);
				if(planEntryInfo.getHenHouse() == null){
					planEntryInfo = CCBreedPlanEntryFactory.getLocalInstance(ctx).getCCBreedPlanEntryInfo(new ObjectUuidPK(planEntryInfo.getId()));
					
				}
				// 获取map中暂存的 鸡舍批次 入栏日期 并计算差额天数，
				Date planDate = planEntryInfo.getIncoopDate();
				if(planEntryInfo.getHenHouse() != null && planDate != null){
					Date batchDate = batchInDate.get(planEntryInfo.getHenHouse().getId().toString());
					int  diffDays = DateCommon.dateDiff(batchDate, planDate);
					
					if(diffDays > 20){
						throw  new EASBizException(new NumericExceptionSubItem("001","养殖批次与对应养殖计划入栏明细相差日期过大，请仔细核对是否选错养殖计划！"));
						
					}
//					if(diffDays > maxDiffDays ){
//						maxDiffDays = diffDays;
//						
//						
//					}
				}
				
			}
		}
	}
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
		sb.append("select fid from ct_fm_breedbatch where cfcostobjectid='");
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
		BreedBatchInfo billInfo = BreedBatchFactory.getLocalInstance(ctx).getBreedBatchInfo(pk);
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()))){
    		// 校验当前批次是否已经生成了 日报 
    		boolean isused = BreedFacadeFactory.getLocalInstance(ctx).isBatchGeneratedDailyInfos(billInfo.getId().toString(), billInfo.getHouseType().getValue());
    		if(isused){
//    			throw new FarmException("当前养殖批次已经填报过日报信息，不能删除");
    			throw  new EASBizException(new NumericExceptionSubItem("001","当前养殖批次已经填报过日报信息，不能删除"));
    		}
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
		BreedBatchInfo billInfo = (BreedBatchInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("已经存在下游单据，不能审核");
			}
			String costObjectID = billInfo.getCostObject().getId().toString();
			String fid = billInfo.getId().toString();
			try {
				checkBatchCostObject(ctx,costObjectID,fid);
			} catch (EASBizException e) {
				e.printStackTrace();
				throw new FarmException(e.getMessage());
			}
			// 更新单据状态
			AppCommon.updateModelStatus(ctx, "CT_FM_BreedBatch", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
			
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
		
		BreedBatchInfo billInfo = (BreedBatchInfo)model;
		
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
			AppCommon.updateModelStatus(ctx, "CT_FM_BreedBatch", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);
			
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
		BreedBatchInfo billInfo = (BreedBatchInfo)model;
		if(billInfo != null){
			BreedFacadeFactory.getLocalInstance(ctx).updateBatchOutState(billInfo.getId().toString());
		}
	}
	
	
	
	
	
	
}