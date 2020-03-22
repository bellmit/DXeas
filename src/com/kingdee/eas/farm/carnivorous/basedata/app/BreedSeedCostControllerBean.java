package com.kingdee.eas.farm.carnivorous.basedata.app;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.carnivorous.basedata.BreedSeedCostFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BreedSeedCostInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.util.NumericExceptionSubItem;

public class BreedSeedCostControllerBean extends AbstractBreedSeedCostControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.basedata.app.BreedSeedCostControllerBean");
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BreedSeedCostInfo info = (BreedSeedCostInfo) model;
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED) ) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已经核准或启用！"));
		}
		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setAuditTime(new java.util.Date());
		try {
			this._update(ctx, new ObjectUuidPK(info.getId()), info);
			DbUtil.execute(ctx, "update T_FM_BreedSeedCost set FBillStatus=3 where  fid<>'"+info.getString("id")+"' and FCompanyID='"+info.getCompany().getId().toString()+"'");
		} catch (EASBizException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BreedSeedCostInfo info = (BreedSeedCostInfo) model;
		if (!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED) ) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准或已经启用！"));
		}
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		try {
			info.setAuditor(null);
			info.setAuditTime(null);
			this._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		return super._save(ctx, model);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		return super._submit(ctx, model);
	}


	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BreedSeedCostInfo info = BreedSeedCostFactory.getLocalInstance(ctx).getBreedSeedCostInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED) ) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已经核准或启用！"));
		}
		super._delete(ctx, pk);
	}
}