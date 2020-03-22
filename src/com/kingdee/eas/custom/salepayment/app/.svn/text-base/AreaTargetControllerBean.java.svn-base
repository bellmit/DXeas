package com.kingdee.eas.custom.salepayment.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.salepayment.AreaTargetFactory;
import com.kingdee.eas.custom.salepayment.AreaTargetInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.util.NumericExceptionSubItem;

public class AreaTargetControllerBean extends AbstractAreaTargetControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.salepayment.app.AreaTargetControllerBean");
    
    
    

    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
    	AreaTargetInfo billInfo = (AreaTargetInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) || BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) )){
    		billInfo.setBaseStatus( BillBaseStatusEnum.TEMPORARILYSAVED);
    		
    		return super._save(ctx, model);
    	}else{
//    		throw new BOSException("只能保存新增或保存状态的单据");
    		throw  new EASBizException(new NumericExceptionSubItem("001","只能保存新增或保存状态的单据"));
    	}
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		AreaTargetInfo billInfo = (AreaTargetInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()))){
    		billInfo.setBaseStatus( BillBaseStatusEnum.SUBMITED);
    		
		
    		return super._submit(ctx, model);
    	}else{
//    		throw new BOSException("只能保存新增或保存状态的单据");
    		throw  new EASBizException(new NumericExceptionSubItem("001","只能保存新增或保存状态的单据"));
    	}
	}
	
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		AreaTargetInfo billInfo = AreaTargetFactory.getLocalInstance(ctx).getAreaTargetInfo(pk);
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()))){
    		
    		super._delete(ctx, pk);
    		
    	}else{
//    		throw new BOSException("只能删除新增或保存状态的单据");
    		throw  new EASBizException(new NumericExceptionSubItem("001","只能删除新增或保存状态的单据"));
    	}
		
	}
	/**
     * 审核
     */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		AreaTargetInfo billInfo = (AreaTargetInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new BOSException("已经存在下游单据，不能审核");
			}
			
			// 更新单据状态
			AppCommon.updateBaseDataModelStatus(ctx, "CT_SP_AreaTarget", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
			
		}else{
			throw new BOSException("只能审核提交状态的单据");
		}
		
	}


	/**
	 * 反审核
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException {
		
		AreaTargetInfo billInfo = (AreaTargetInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new BOSException("已经存在下游单据，不能反审核");
			}else{
				// 校验当前批次是否已经生成了 日报  
				// 20151221 不再校验是否存在下游单据，而是改为通过权限控制
//				boolean isused = BreedFacadeFactory.getLocalInstance(ctx).isBatchGeneratedDailyInfos(billInfo.getId().toString(), billInfo.getHouseType().getValue());
//				if(isused){
//					throw new BOSException("当前养殖批次已经填报过日报信息，不能反审核");
//				}
			}
			
			
			// 更新单据状态
			AppCommon.updateBaseDataModelStatus(ctx, "CT_SP_AreaTarget", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);
			
		}else{
			throw new BOSException("只能反审核审核状态的单据");
		}
	}

}