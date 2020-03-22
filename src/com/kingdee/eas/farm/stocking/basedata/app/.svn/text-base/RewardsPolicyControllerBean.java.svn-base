package com.kingdee.eas.farm.stocking.basedata.app;

import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.RewardsPolicyFactory;
import com.kingdee.eas.farm.stocking.basedata.RewardsPolicyInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.util.NumericExceptionSubItem;

public class RewardsPolicyControllerBean extends AbstractRewardsPolicyControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.stocking.basedata.app.RewardsPolicyControllerBean");
    
    @Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		RewardsPolicyInfo info = (RewardsPolicyInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未启用！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		RewardsPolicyInfo info = (RewardsPolicyInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已经启用！"));
		}

		info.setBaseStatus(FarmBaseStatusEnum.enable);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		RewardsPolicyInfo info = (RewardsPolicyInfo) model;
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已经核准或启用！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		try {
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			info.setAuditTime(new Date());
			this._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		RewardsPolicyInfo info = (RewardsPolicyInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准或已经启用！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		try {
			this._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		RewardsPolicyInfo info = RewardsPolicyFactory.getLocalInstance(ctx).getRewardsPolicyInfo(pk);
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已经核准或启用！"));
		}
		super._delete(ctx, pk);
	}
}