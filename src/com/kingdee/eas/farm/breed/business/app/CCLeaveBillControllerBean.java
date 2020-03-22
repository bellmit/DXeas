package com.kingdee.eas.farm.breed.business.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.business.CCLeaveBillFactory;
import com.kingdee.eas.farm.breed.business.CCLeaveBillInfo;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.util.NumericExceptionSubItem;

public class CCLeaveBillControllerBean extends AbstractCCLeaveBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.breed.business.app.CCLeaveBillControllerBean");
    @Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		CCLeaveBillInfo info = (CCLeaveBillInfo) model;
		// 禁止重复审核 非提交不审核
		if (!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			return;
		}
		try {
			info.setBillStatus(BillBaseStatusEnum.AUDITED);
			info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
		logger.info("trans ok");
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CCLeaveBillInfo info = (CCLeaveBillInfo) model;
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		CCLeaveBillInfo info = (CCLeaveBillInfo) model;
		info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		return super._submit(ctx, info);
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException {
		CCLeaveBillInfo info = (CCLeaveBillInfo) model;
		// 反禁止重复审核
		if (!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			return;
		}
		try {
			FarmCommUtils.isExitBTPBill(ctx, new ObjectUuidPK(info.getId()), info);
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			info.setAuditTime(null);
			info.setAuditor(null);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			logger.error(e);
			throw new BOSException(e);
		}
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CCLeaveBillInfo info = CCLeaveBillFactory.getLocalInstance(ctx).getCCLeaveBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":单据已经审核，禁止删除"));
		}
		if (info.getBillStatus().equals(BillBaseStatusEnum.FINISH)) {
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":单据已经完成，禁止删除"));
		}
		super._delete(ctx, pk);
	}
}