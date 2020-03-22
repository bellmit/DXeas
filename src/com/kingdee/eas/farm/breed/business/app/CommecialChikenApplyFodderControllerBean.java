package com.kingdee.eas.farm.breed.business.app;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.business.CommecialChikenApplyFodderInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class CommecialChikenApplyFodderControllerBean extends AbstractCommecialChikenApplyFodderControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.breed.business.app.CommecialChikenApplyFodderControllerBean");
    


	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// 状态设置为保存
		CommecialChikenApplyFodderInfo info =  (CommecialChikenApplyFodderInfo)model;
		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&&
				info.getBaseStatus() != null){
			throw new EASBizException(new NumericExceptionSubItem("001","只能保存暂存或者新增状态的单据"));
			
		}else{
			boolean isExistEntry = true;
			if(info.getFodderPlanEntrys() == null || info.getFodderPlanEntrys().size()<= 0){
				isExistEntry = false;
			}
			if(!isExistEntry){
				throw new EASBizException(new NumericExceptionSubItem("001","要料计划必须包含至少一条分录"));
			}
			
			// 如果已经填报过日报 则要料计划只能在日报中填报
			boolean isExistCB = isCostobjectExistInCD(ctx,info);
    		if(isExistCB){
    			throw new EASBizException(new NumericExceptionSubItem("001","对应养殖批次已经填报过日报，要料计划请在养殖日报中填写"));
    		}
		}
		info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, model);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		// 状态设置为保存
		CommecialChikenApplyFodderInfo info =  this.getCommecialChikenApplyFodderInfo(ctx, pk);
		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	){
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
		CommecialChikenApplyFodderInfo billInfo = (CommecialChikenApplyFodderInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()) || 
    						billInfo.getBaseStatus() == null)){
    		billInfo.setBaseStatus( BillBaseStatusEnum.SUBMITED);
    		
    		// 校验是否存在分录
		
			boolean isExistEntry = true;
			if(billInfo.getFodderPlanEntrys() == null || billInfo.getFodderPlanEntrys().size()<= 0){
				isExistEntry = false;
			}
			if(!isExistEntry){
				throw new EASBizException(new NumericExceptionSubItem("001","要料计划必须包含至少一条分录"));
			}
			
			// 如果已经填报过日报 则要料计划只能在日报中填报
			boolean isExistCB = isCostobjectExistInCD(ctx,billInfo);
    		if(isExistCB){
    			throw new EASBizException(new NumericExceptionSubItem("001","对应养殖批次已经填报过日报，要料计划请在养殖日报中填写"));
    		}
    		return super._submit(ctx, model);
    	}else{
    		throw new EASBizException(new NumericExceptionSubItem("001","只能提交新增或保存状态的单据"));
			
    	}
	}
	
	/**
	 * 校验成本对象状态，是否已经存在于养殖批次中且 日期
	 * 是的话返回true  否的话返回
	 * @param ctx
	 * @param coInfo
	 * @return
	 * @throws BOSException 
	 */
	public boolean isCostobjectExistInCD(Context ctx, CommecialChikenApplyFodderInfo info) throws BOSException{
		
		if(info != null && info.getCostObject() != null){
			String sql = "select 1 from ct_fm_commecialchilkendaily t  inner join ct_fm_breedbatch tb on t.cfbreedbatchid = tb.fid where tb.cfcostobjectid =?";
			Object[] args = {info.getCostObject().getId().toString()};
			
			IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
			try {
				if(rs.next()){
					return true;
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw new BOSException(e);
			}
		}
		return false;
	}
	
	/**
     * 审核
     */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		CommecialChikenApplyFodderInfo billInfo = (CommecialChikenApplyFodderInfo)model;
	
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("已经存在下游单据，不能审核");
			}
			
			// 更新单据状态
			AppCommon.updateModelStatus(ctx, "CT_FM_CommecialCAF", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
			
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
		
		CommecialChikenApplyFodderInfo billInfo = (CommecialChikenApplyFodderInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("已经存在下游单据，不能反审核");
			}else{
				// 校验当前批次是否已经生成了 日报 
				// TODO 
			}
		
			// 更新单据状态
			AppCommon.updateModelStatus(ctx, "CT_FM_CommecialCAF", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);
			
		}else{
			throw new FarmException("只能反审核审核状态的单据");
		}
		
		
	}

	

}