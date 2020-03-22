package com.kingdee.eas.farm.breed.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.BreedBatchEditBillEntryCollection;
import com.kingdee.eas.farm.breed.BreedBatchEditBillEntryInfo;
import com.kingdee.eas.farm.breed.BreedBatchEditBillFactory;
import com.kingdee.eas.farm.breed.BreedBatchEditBillInfo;
import com.kingdee.eas.farm.breed.BreedBatchEditEntryFactory;
import com.kingdee.eas.farm.breed.BreedBatchEditEntryInfo;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.farm.breed.ParentBreedBatchInfo;
import com.kingdee.eas.farm.breed.ParentBreedBatchTransEntryFactory;
import com.kingdee.eas.farm.breed.ParentBreedBatchTransEntryInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.util.NumericExceptionSubItem;

public class BreedBatchEditBillControllerBean extends AbstractBreedBatchEditBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.breed.app.BreedBatchEditBillControllerBean");
    
    
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
    	BreedBatchEditBillInfo billInfo = (BreedBatchEditBillInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) || BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) )){
    		billInfo.setBaseStatus( BillBaseStatusEnum.TEMPORARILYSAVED);
    		return super._save(ctx, model);
    	}else{
//    		throw new FarmException("只能保存新增或保存状态的单据");
    		throw  new EASBizException(new NumericExceptionSubItem("001","只能保存新增或保存状态的单据"));
    	}
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		BreedBatchEditBillInfo billInfo = (BreedBatchEditBillInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()))){
    		billInfo.setBaseStatus( BillBaseStatusEnum.SUBMITED);
    		return super._submit(ctx, model);
    	}else{
//    		throw new FarmException("只能保存新增或保存状态的单据");
    		throw  new EASBizException(new NumericExceptionSubItem("001","只能保存新增或保存状态的单据"));
    	}
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		BreedBatchEditBillInfo billInfo = BreedBatchEditBillFactory.getLocalInstance(ctx).getBreedBatchEditBillInfo(pk);
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()))){
//    		// 校验当前批次是否已经生成了 日报 
//    		boolean isused = BreedFacadeFactory.getLocalInstance(ctx).isBatchGeneratedDailyInfos(billInfo.getId().toString(), billInfo.getHouseType().getValue());
//    		if(isused){
//    			throw new FarmException("当前养殖批次已经填报过日报信息，不能删除");
//    		}
    		
    		// 更新对应批次 分录
			BreedBatchEditBillEntryCollection entryCol = billInfo.getEntrys();
			if(entryCol != null && entryCol.size() > 0){
				for(int i = 0; i < entryCol.size(); i++){
					BreedBatchEditBillEntryInfo entryInfo = entryCol.get(i);
					try{
						// 更新 对应批次信息
						updateBreedBatchEditEntrys(ctx,billInfo,entryInfo,false);
					}catch(EASBizException easb){
						throw new FarmException(easb.getMessage());
					}
				}
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
		BreedBatchEditBillInfo billInfo = (BreedBatchEditBillInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("已经存在下游单据，不能审核");
//				throw  new EASBizException(new NumericExceptionSubItem("001","养殖规范不能删除，只能停用"));
			}
			// 更新对应批次 分录
			BreedBatchEditBillEntryCollection entryCol = billInfo.getEntrys();
			if(entryCol != null && entryCol.size() > 0){
				for(int i = 0; i < entryCol.size(); i++){
					BreedBatchEditBillEntryInfo entryInfo = entryCol.get(i);
					try{
						// 更新 对应批次信息
						updateBreedBatchEditEntrys(ctx,billInfo,entryInfo,true);
					}catch(EASBizException easb){
						throw new FarmException(easb.getMessage());
					}
				}
			}
			
			
			// 更新单据状态
			AppCommon.updateModelStatus(ctx, "CT_FM_BreedBatchEditBill", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
			
		}else{
			throw new FarmException("只能审核提交状态的单据");
//			throw  new EASBizException(new NumericExceptionSubItem("001","养殖规范不能删除，只能停用"));
		}
		
	}

	/**
	 * 更新 变更单对应的  变更分录
	 * @param ctx
	 * @param editBillInfo
	 * @param editEntryInfo
	 * @param isAdd 是否增加，true 增加 false 删除
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void  updateBreedBatchEditEntrys(Context ctx,
			BreedBatchEditBillInfo editBillInfo,
			BreedBatchEditBillEntryInfo editEntryInfo,
			boolean isAdd) throws EASBizException, BOSException{
		ParentBreedBatchInfo breedBatch = editBillInfo.getBreedBatch();
		if(breedBatch != null){
			// 增加时，直接在 批次 编辑分录中增加
			if(isAdd){
				ParentBreedBatchTransEntryInfo bbEditEntryInfo = new ParentBreedBatchTransEntryInfo();
				bbEditEntryInfo.setParent(breedBatch);
//				bbEditEntryInfo.setAddDate(editEntryInfo.getEditDate());
//				bbEditEntryInfo.setAddQty(editEntryInfo.getAddQty());
//				bbEditEntryInfo.setChikenType(editEntryInfo.getChikenType());
//				bbEditEntryInfo.setHenhouse(editEntryInfo.getHenHouse());
//				bbEditEntryInfo.setHenhouseName(editEntryInfo.getHenhouseName());
//				bbEditEntryInfo.setSourceID(editBillInfo.getId().toString());
//				bbEditEntryInfo.setSourceEntryID(editEntryInfo.getId().toString());
//				bbEditEntryInfo.setReason(editEntryInfo.getDescription());
				
//				bbEditEntryInfo.set(editEntryInfo.getEditDate());
//				bbEditEntryInfo.setAddQty(editEntryInfo.getAddQty());
//				bbEditEntryInfo.setChikenType(editEntryInfo.getChikenType());
//				bbEditEntryInfo.setHenhouse(editEntryInfo.getHenHouse());
//				bbEditEntryInfo.setHenhouseName(editEntryInfo.getHenhouseName());
//				bbEditEntryInfo.setSourceID(editBillInfo.getId().toString());
//				bbEditEntryInfo.setSourceEntryID(editEntryInfo.getId().toString());
//				bbEditEntryInfo.setReason(editEntryInfo.getDescription());
				// 保存
				ParentBreedBatchTransEntryFactory.getLocalInstance(ctx).addnew(bbEditEntryInfo);
			}else{
				// 删除对应分录
				String delSql = "delete from CT_FM_BreedBatchEditEntrys where cfsourceid=? and cfsourceEntryID=? ";
				Object[] args = {editBillInfo.getId().toString(),editEntryInfo.getId().toString()};
				DbUtil.execute(ctx, delSql,args);
			}
		}
		
		return ;
	}

	/**
	 * 反审核
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException {
		
		BreedBatchEditBillInfo billInfo = (BreedBatchEditBillInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("已经存在下游单据，不能反审核");
//				throw  new EASBizException(new NumericExceptionSubItem("001","养殖规范不能删除，只能停用"));
			}else{
//				// 校验当前批次是否已经生成了 日报 
//				boolean isused = BreedFacadeFactory.getLocalInstance(ctx).isBatchGeneratedDailyInfos(billInfo.getId().toString(), billInfo.getHouseType().getValue());
//				if(isused){
//					throw new FarmException("当前养殖批次已经填报过日报信息，不能反审核");
//				}
			}
			// 更新对应批次 分录
			BreedBatchEditBillEntryCollection entryCol = billInfo.getEntrys();
			if(entryCol != null && entryCol.size() > 0){
				for(int i = 0; i < entryCol.size(); i++){
					BreedBatchEditBillEntryInfo entryInfo = entryCol.get(i);
					try{
						// 更新 对应批次信息
						updateBreedBatchEditEntrys(ctx,billInfo,entryInfo,false);
					}catch(EASBizException easb){
						throw new FarmException(easb.getMessage());
					}
				}
			}
			
			// 更新单据状态
			AppCommon.updateModelStatus(ctx, "CT_FM_BreedBatchEditBill", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);
			
		}else{
			throw new FarmException("只能反审核审核状态的单据");
//			throw  new EASBizException(new NumericExceptionSubItem("001","只能反审核审核状态的单据"));
		}
	}
	
}