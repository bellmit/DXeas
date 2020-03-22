package com.kingdee.eas.farm.breed.business.app;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.business.CCBreedPlanEntryCollection;
import com.kingdee.eas.farm.breed.business.CCBreedPlanEntryInfo;
import com.kingdee.eas.farm.breed.business.CCBreedPlanFactory;
import com.kingdee.eas.farm.breed.business.CCBreedPlanInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class CCBreedPlanControllerBean extends AbstractCCBreedPlanControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.breed.business.app.CCBreedPlanControllerBean");
    
    
    
    

    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
    	CCBreedPlanInfo billInfo = (CCBreedPlanInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) || BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) )){
    		billInfo.setBaseStatus( BillBaseStatusEnum.TEMPORARILYSAVED);
    		
    		
    		
    		
    		// 校验计划重复问题
    		checkIsExist(ctx,billInfo);
    		// 校验计划是否已经被引用，被引用后不能修改
    		if(billInfo.getId() != null){
    			checkPlanRelated(ctx,billInfo.getId().toString());
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
		CCBreedPlanInfo billInfo = (CCBreedPlanInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()))){
    		
    		// 校验计划重复问题
    		checkIsExist(ctx,billInfo);
    		// 校验计划是否已经被引用，被引用后不能修改
    		if(billInfo.getId() != null){
    			checkPlanRelated(ctx,billInfo.getId().toString());
    		}
    		
    		billInfo.setBaseStatus( BillBaseStatusEnum.SUBMITED);
    		return super._submit(ctx, model);
    	}else{
//    		throw new FarmException("只能保存新增或保存状态的单据");
    		throw  new EASBizException(new NumericExceptionSubItem("001","只能提交新增或保存状态的单据"));
    	}
	}

	/**
	 * 校验指定的日期10天内是否有养殖计划 TODO ....
	 * @param ctx
	 * @param planID
	 * @param inhouseDate
	 * @throws EASBizException 
	 * @throws BOSException 
	 */
	private void checkIsExist(Context ctx, CCBreedPlanInfo billInfo) throws EASBizException, BOSException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		
		
		CCBreedPlanEntryCollection entryCol = billInfo.getEntrys();
		if(entryCol != null && entryCol.size() > 0){
			for(int i = 0; i < entryCol.size(); i++){
			CCBreedPlanEntryInfo entryInfo = entryCol.get(i);
			
			Date inhouseDate = entryInfo.getIncoopDate();
			if(inhouseDate == null){
				throw new EASBizException(new NumericExceptionSubItem("001","分录入栏日期不能为空"));
			}
			
				cal.setTime(inhouseDate);
				cal.add(Calendar.DATE, -30);
				Date beginDate = cal.getTime();
				String beginDateStr = sdf.format(beginDate);
				cal.add(Calendar.DATE, 60);
				Date endDate = cal.getTime();
				
				
				String endDateStr = sdf.format(endDate);
				StringBuilder sb = new StringBuilder("select t.fid from CT_FM_CCBreedPlan t inner join CT_FM_CCBreedPlanentry te on t.fid = te.fparentid where ");
				sb.append(" te.CFINCOOPDATE >= {d '");
				sb.append(beginDateStr);
				sb.append("'} and te.CFINCOOPDATE <={d '");
				sb.append(endDateStr);
				sb.append("'} ");
				sb.append(" and t.CFStoOrgID='").append(billInfo.getStoOrg().getString("id")).append("'");//add by dai 20150824
				if(billInfo != null && billInfo.getId() != null ){
					sb.append(" and t.fid != '");
					sb.append(billInfo.getId().toString());
					sb.append("'");
				}
				
				IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
				try{
					if(rs.next()){
						throw new EASBizException(new NumericExceptionSubItem("001","分录入栏日期最近时间内已经存在入栏计划，时间间隔过短"));
					}
				}catch(SQLException sqle){
					throw new BOSException(sqle);
				}
			}
		}else{
			throw new EASBizException(new NumericExceptionSubItem("001","请按照计划内容填写分录，各个鸡舍的入栏计划"));
		}
	}
	
	/**
	 * 
	 * @param ctx
	 * @param planID
	 * @throws EASBizException 
	 * @throws BOSException 
	 */
	public void checkPlanRelated(Context ctx,String planID) throws EASBizException, BOSException{
		// 校验计划是否已经被引用，被引用后不能删除
		String sql = "select 1 from ct_fm_breedbatch where CFBREEDPLANID = ?";
		Object[] args = {planID};
		IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
		try {
			if(rs.next()){
				throw  new EASBizException(new NumericExceptionSubItem("001","已经被养殖批次引用，不能操作"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BOSException(e);
		}
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		CCBreedPlanInfo billInfo = CCBreedPlanFactory.getLocalInstance(ctx).getCCBreedPlanInfo(pk);
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()))){
    		boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
    			throw  new EASBizException(new NumericExceptionSubItem("001","已经存在下游单据，不能删除"));
    		}
			// 校验计划是否已经被引用，被引用后不能删除
			checkPlanRelated(ctx,pk.toString());
		
			
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
		CCBreedPlanInfo billInfo = (CCBreedPlanInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("已经存在下游单据，不能审核");
			}
			// 更新单据状态
			AppCommon.updateModelStatus(ctx, "CT_FM_CCBreedPlan", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
			
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
		
		CCBreedPlanInfo billInfo = (CCBreedPlanInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("已经存在下游单据，不能反审核");
			}
			
			
			// 更新单据状态
			AppCommon.updateModelStatus(ctx, "CT_FM_CCBreedPlan", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);
			
		}else{
			throw new FarmException("只能反审核审核状态的单据");
		}
	}

	@Override
	protected void _getCCBreedPlan(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}
	
}