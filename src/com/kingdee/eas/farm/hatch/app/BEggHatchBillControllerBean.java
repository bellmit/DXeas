package com.kingdee.eas.farm.hatch.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.farm.hatch.BEggHatchBillFactory;
import com.kingdee.eas.farm.hatch.BEggHatchBillInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.DateCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.util.NumericExceptionSubItem;

public class BEggHatchBillControllerBean extends AbstractBEggHatchBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.hatch.app.BEggHatchBillControllerBean");
    

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// 状态设置为保存
		BEggHatchBillInfo info =  (BEggHatchBillInfo)model;
		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&&
				
				!info.getBaseStatus().NULL.equals(info.getBaseStatus()) && 
				info.getBaseStatus() != null ){
			throw new EASBizException(new NumericExceptionSubItem("001","只能保存暂存或者新增状态的单据"));
			
		}
		
//		// 校验转箱单是否已经存在于其他 单据中
//		if(checkTransBillExist(ctx,info)){
//			throw new EASBizException(new NumericExceptionSubItem("001","转箱单已经存在对应的出雏单，不能重复操作"));
//		}
		
		if(info.getAdminOrg() == null){
			info.setAdminOrg(ContextUtil.getCurrentAdminUnit(ctx));
			
		}
		info.setBizDate(DateUtilsComm.clearDateHMS(info.getBizDate()));
		
		info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, model);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		BEggHatchBillInfo info =  BEggHatchBillFactory.getLocalInstance(ctx).getBEggHatchBillInfo(pk);
		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&& 
				!BillBaseStatusEnum.SUBMITED.equals(info.getBaseStatus()) && 
				!info.getBaseStatus().NULL.equals(info.getBaseStatus()) && 
				info.getBaseStatus() != null ){
			throw new EASBizException(new NumericExceptionSubItem("001","只能删除暂存或者新增状态的单据"));
			
		}
		
		boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), pk.toString());
		if(exist){
			throw new FarmException("已经存在下游单据，不能删除");
		}
		super._delete(ctx, pk);
	}
	
	/**
	 * 提交
	 */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		BEggHatchBillInfo info = (BEggHatchBillInfo)model;
    	if(info != null  && 
    			(BillBaseStatusEnum.ADD.equals(info.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(info.getBaseStatus()) || 
    						info.getBaseStatus().NULL.equals(info.getBaseStatus()) || 
    						info.getBaseStatus() == null)){
    		info.setBaseStatus( BillBaseStatusEnum.SUBMITED);
    		
    		
    		
    		if(info.getAdminOrg() == null){
    			info.setAdminOrg(ContextUtil.getCurrentAdminUnit(ctx));
    			
    		}
    		
    		info.setBizDate(DateUtilsComm.clearDateHMS(info.getBizDate()));
//    		this._audit(ctx, model);
    		return super._submit(ctx, model);
    	}else{
    		throw new EASBizException(new NumericExceptionSubItem("001","只能提交新增或保存状态的单据"));
			
    	}
	}
	
//	/**
//	 * 校验上孵单是否已经存在于其他单据中
//	 * @param ctx
//	 * @param billInfo
//	 * @return
//	 * @throws BOSException 
//	 */
//	private boolean checkTransBillExist(Context ctx, BEggHatchBillInfo billInfo) throws BOSException{
//		String transID = "";
//		if(billInfo.getTransferBoxBill() != null){
//			transID = billInfo.getTransferBoxBill().getId().toString();
//			
//			String id = "";
//			if(billInfo.getId() != null){
//				id = billInfo.getId().toString();
//			}
//			StringBuilder sb = new StringBuilder("select 1 from CT_FM_BEggHatchBill where CFTransferBoxBillI ='");
//			sb.append(transID);
//			sb.append("' ");
//			if(StringUtils.isNotBlank(id)){
//				sb.append(" and fid <> '");
//				sb.append(id);
//				sb.append("'");
//				
//			}
//			try{
//				IRowSet rs  = DbUtil.executeQuery(ctx, sb.toString());
//				if(rs.next()){
//					return true;
//				}
//			}catch(SQLException sqle){
//				sqle.printStackTrace();
//				throw new BOSException(sqle);
//			}
//		}else{
//			return false;
//		}
//		return false;
//	}
	/**
     * 审核
	 * @throws EASBizException 
     */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException{
		BEggHatchBillInfo billInfo = (BEggHatchBillInfo)model;
			if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()) && billInfo.getId() != null){
				boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
				if(exist){
					throw new EASBizException(new NumericExceptionSubItem("001","已经存在下游单据，不能审核"));
				}	
				// 更新单据状态
				AppCommon.updateModelStatus(ctx, "CT_FM_BEggHatchBill", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
			}else{
				throw new EASBizException(new NumericExceptionSubItem("001","只能审核提交状态的单据"));
			}	
	}

	/**
	 * 反审核
	 * @throws EASBizException 
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		
		BEggHatchBillInfo billInfo = (BEggHatchBillInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new EASBizException(new NumericExceptionSubItem("001","已经存在下游单据，不能反审核"));
			}
			// 更新单据状态
			AppCommon.updateModelStatus(ctx, "CT_FM_BEggHatchBill", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);		
		}else{
			throw new EASBizException(new NumericExceptionSubItem("001","只能反审核审核状态的单据"));
		}
	}

	@Override
	protected void _adjust(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub
		
	}
    
    
    
}