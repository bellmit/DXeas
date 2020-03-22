package com.kingdee.eas.farm.stocking.basedata.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.StatementsPolicyFactory;
import com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class StatementsPolicyControllerBean extends AbstractStatementsPolicyControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.StatementsPolicy.stocking.basedata.app.StatementsPolicyControllerBean");

	@Override
	protected void _isTemplate(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		StatementsPolicyInfo info = (StatementsPolicyInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未启用！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		StatementsPolicyInfo info = (StatementsPolicyInfo) model;
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
		StatementsPolicyInfo info = (StatementsPolicyInfo) model;
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已经核准或启用！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		try {
			info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			this._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		StatementsPolicyInfo info = (StatementsPolicyInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准或已经启用！"));
		}
//		if(checkHasUsed(ctx, info.getCompany().getString("id"), info.getString("id"))) {
//			throw new EASBizException(new NumericExceptionSubItem("001","资料已经被使用，禁止反审核！"));
//		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		try {
			this._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 判断结算政策是否被使用
	 * @param ctx
	 * @param companyID
	 * @param id
	 * @return
	 * @throws BOSException 
	 */
	private boolean checkHasUsed(Context ctx,String companyID,String id) throws BOSException {
		IRowSet rs = DbUtil.executeQuery(ctx,"select fid from T_FM_BatchContract where FbillStatus=4 and fcompanyid=? and FSettlementPolicyI=?",new Object[]{companyID,id});
		if(rs.size()>0) {
			return true;
		}
		return false;
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		StatementsPolicyInfo info = StatementsPolicyFactory.getLocalInstance(ctx).getStatementsPolicyInfo(pk);
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已经核准或启用！"));
		}
		super._delete(ctx, pk);
	}
	
}