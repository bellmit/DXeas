package com.kingdee.eas.farm.pig.ccpig.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.pig.ccpig.CCPigBatchInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.util.NumericExceptionSubItem;

public class CCPigBatchControllerBean extends AbstractCCPigBatchControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.pig.ccpig.app.CCPigBatchControllerBean");
    
    
    
    
    
    	@Override
    	protected IObjectPK _save(Context ctx, IObjectValue model)
    			throws BOSException, EASBizException {
    		// 状态设置为保存
    		CCPigBatchInfo info =  (CCPigBatchInfo)model;
    		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
    				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&&
    				info.getBaseStatus() != null){
    			throw new EASBizException(new NumericExceptionSubItem("001","只能保存暂存或者新增状态的单据"));
    			
    		}else{
    			
    		}
    		info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
    		return super._save(ctx, model);
    	}
    
    	@Override
    	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
    			EASBizException {
    		// 状态设置为保存
    		CCPigBatchInfo info =  this.getCCPigBatchInfo(ctx, pk);
    		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
    				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&& 
    				!BillBaseStatusEnum.SUBMITED.equals(info.getBaseStatus())){
    			throw new EASBizException(new NumericExceptionSubItem("001","只能删除暂存或者新增状态的单据"));
    			
    		}
    		super._delete(ctx, pk);
    	}
    	
    	/**
    	 * 提交
    	 */
    	@Override
    	protected IObjectPK _submit(Context ctx, IObjectValue model)
    			throws BOSException, EASBizException {
    		CCPigBatchInfo billInfo = (CCPigBatchInfo)model;
        	if(billInfo != null  && 
        			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
        						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
        						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()) || 
        						billInfo.getBaseStatus() == null)){
        		billInfo.setBaseStatus( BillBaseStatusEnum.SUBMITED);
        		
        		return super._submit(ctx, model);
        	}else{
        		throw new EASBizException(new NumericExceptionSubItem("001","只能提交新增或保存状态的单据"));
    			
        	}
    	}
    	
    	
    
    	/**
         * 审核
         */
    	@Override
    	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
    		CCPigBatchInfo billInfo = (CCPigBatchInfo)model;
    		
    		try {
    			if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
    				boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
    				if(exist){
    					throw new FarmException("已经存在下游单据，不能审核");
    				}
    				
    				// 更新单据状态
    				AppCommon.updateModelStatus(ctx, "CT_PIG_CCPigBatch", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
    				
    			}else{
    				throw new FarmException("只能审核提交状态的单据");
    			}
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    			throw new BOSException(e);
    		}
    		
    	}
    
    	/**
    	 * 反审核
    	 */
    	@Override
    	protected void _unAudit(Context ctx, IObjectValue model)
    			throws BOSException {
    		
    		CCPigBatchInfo billInfo = (CCPigBatchInfo)model;
    		try{
    			if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
    				boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
    				if(exist){
    					throw new FarmException("已经存在下游单据，不能反审核");
    				}else{
    					// 校验当前批次是否已经生成了 日报 
    					// TODO 
    				}
    				// 更新单据状态
    				AppCommon.updateModelStatus(ctx, "CT_PIG_CCPigBatch", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);
    				
    			}else{
    				throw new FarmException("只能反审核审核状态的单据");
    			}
    			
    		}catch (Exception e) {
    			
    			e.printStackTrace();
    			throw new FarmException(e);
    		}
    	}
}