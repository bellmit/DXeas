package com.kingdee.eas.farm.dayratecost.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.dayratecost.ArAmountOffsetDetailBillFactory;
import com.kingdee.eas.farm.dayratecost.ArAmountOffsetDetailBillInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.util.NumericExceptionSubItem;

public class ArAmountOffsetDetailBillControllerBean extends AbstractArAmountOffsetDetailBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.dayratecost.app.ArAmountOffsetDetailBillControllerBean");
    protected void _audit(Context ctx, IObjectValue model)throws BOSException
    {
    	try {
    		ArAmountOffsetDetailBillInfo info = (ArAmountOffsetDetailBillInfo) model;
			info.setBillStatus(BillBaseStatusEnum.AUDITED);
			info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
    }
    
    protected void _unAudit(Context ctx, IObjectValue model)throws BOSException
    {
    	try {
    		ArAmountOffsetDetailBillInfo info = (ArAmountOffsetDetailBillInfo) model;
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
    	ArAmountOffsetDetailBillInfo info = (ArAmountOffsetDetailBillInfo) model;
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
    		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
    	}
		return super._save(ctx, info);
	}
    
    @Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
    	ArAmountOffsetDetailBillInfo info = (ArAmountOffsetDetailBillInfo) model;
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
    		info.setBillStatus(BillBaseStatusEnum.SUBMITED);
    	}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ArAmountOffsetDetailBillInfo info = ArAmountOffsetDetailBillFactory.getLocalInstance(ctx).getArAmountOffsetDetailBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		super._delete(ctx, pk);
	}

}