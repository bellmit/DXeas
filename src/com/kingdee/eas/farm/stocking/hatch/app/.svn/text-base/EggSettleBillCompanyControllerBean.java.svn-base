package com.kingdee.eas.farm.stocking.hatch.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyFactory;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.util.NumericExceptionSubItem;

public class EggSettleBillCompanyControllerBean extends AbstractEggSettleBillCompanyControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.stocking.hatch.app.EggSettleBillCompanyCompanyControllerBean");
    
    protected void _audit(Context ctx, IObjectValue model)throws BOSException
    {
    	try {
    		EggSettleBillCompanyInfo info = (EggSettleBillCompanyInfo) model;
    		
			info.setBillStatus(BillBaseStatusEnum.AUDITED);
			info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));

//			super.submit(ctx, info);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
    }
    
    protected void _unAudit(Context ctx, IObjectValue model)throws BOSException
    {
    	try {
    		EggSettleBillCompanyInfo info = (EggSettleBillCompanyInfo) model;
    		boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), info.getId().toString());
			if(exist){
				throw new FarmException("已经存在下游单据，不能反审核");
			}
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			info.setAuditTime(null);
			info.setAuditor(null);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
    }
    
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
    	EggSettleBillCompanyInfo info = (EggSettleBillCompanyInfo) model;
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
    		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
    	}
		return super._save(ctx, info);
	}
    
    @Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
    	EggSettleBillCompanyInfo info = (EggSettleBillCompanyInfo) model;
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
    		info.setBillStatus(BillBaseStatusEnum.SUBMITED);
    	}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		EggSettleBillCompanyInfo info = EggSettleBillCompanyFactory.getLocalInstance(ctx).getEggSettleBillCompanyInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		super._delete(ctx, pk);
//		rewriteReviceBillFlag(ctx,info.getSourceBillId());
	}
	
	  /**
     * 反写接收单标志
     * @param ctx
     */
	private void rewriteReviceBillFlag(Context ctx,String billID) {
    	try {
    		StringBuffer sql=new StringBuffer();
    		sql.append(" /*disalect*/ update CT_FM_HatchEggReceivingBill t1 set t1.CFIsCSettleBill=0")
    		.append(" where t1.fid='").append(billID).append("'")
    		.append(" and not exists(")
    		.append(" select 1 from CT_FM_EggSettleBillCompany t2")
    		.append(" where t2.fsourcebillID=t1.fid")
    		.append(" and t2.fid!='").append(billID).append("'")
    		.append(" )");
    		DbUtil.execute(ctx,sql.toString());
    	}catch(Exception err){
    		err.printStackTrace();
    	}
    }
    
    
    /**
     * 执行结算
     * @throws EASBizException 
     */
    protected void _exeSettle(Context ctx, IObjectValue model)throws BOSException, EASBizException
    {
    	model=(IObjectValue) new StockingHatchFacadeControllerBeanCompany()._exeEggSettleCompany(ctx, model);
    	super._save(ctx, model);
    }
}