package com.kingdee.eas.farm.food.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.food.FreshCountBillFactory;
import com.kingdee.eas.farm.food.FreshCountBillInfo;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.util.NumericExceptionSubItem;

public class FreshCountBillControllerBean extends AbstractFreshCountBillControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.farm.food.app.FreshCountBillControllerBean");

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FreshCountBillInfo info = (FreshCountBillInfo) model;
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		FreshCountBillInfo info = (FreshCountBillInfo) model;
		info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		return super._submit(ctx, info);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		FreshCountBillInfo info = (FreshCountBillInfo) model;
		// Ω˚÷π÷ÿ∏¥…Û∫À ∑«Ã·Ωª≤ª…Û∫À
		if (!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			return;
		}
		try {
			info.setBillStatus(BillBaseStatusEnum.AUDITED);
			//info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException {
		FreshCountBillInfo info = (FreshCountBillInfo) model;
		// ∑¥Ω˚÷π÷ÿ∏¥…Û∫À
		if (!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			return;
		}
		try {
			FarmCommUtils.isExitBTPBill(ctx, new ObjectUuidPK(info.getId()), info);
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			// info.setAuditTime(null);
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
		FreshCountBillInfo info = FreshCountBillFactory.getLocalInstance(ctx).getFreshCountBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":µ•æ›“—æ≠…Û∫À£¨Ω˚÷π…æ≥˝"));
		}
		super._delete(ctx, pk);
	}
}