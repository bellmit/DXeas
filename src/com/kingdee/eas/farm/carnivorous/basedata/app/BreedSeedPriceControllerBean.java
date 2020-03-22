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
import com.kingdee.eas.farm.carnivorous.basedata.BreedSeedPriceFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BreedSeedPriceInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.util.NumericExceptionSubItem;

public class BreedSeedPriceControllerBean extends AbstractBreedSeedPriceControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.carnivorous.basedata.app.BreedSeedPriceControllerBean");
    @Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BreedSeedPriceInfo info = (BreedSeedPriceInfo) model;
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED) ) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已经核准或启用！"));
		}
		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		Date beginDate = info.getBeginDate();
		Calendar cal = Calendar.getInstance();
		cal.setTime(beginDate);
		cal.add(Calendar.DATE, -1);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			info.setAuditTime(new java.util.Date());
			this._update(ctx, new ObjectUuidPK(info.getId()), info);
			DbUtil.execute(ctx, "update T_FM_BreedSeedPrice set FEndDate={ts '"+sdf.format(cal.getTime())+" 23:59:59'} where fenddate is null and fid<>'"+info.getString("id")+"' and FCompanyID='"+info.getString("id")+"'");
		} catch (EASBizException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BreedSeedPriceInfo info = (BreedSeedPriceInfo) model;
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
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BreedSeedPriceInfo info = BreedSeedPriceFactory.getLocalInstance(ctx).getBreedSeedPriceInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED) ) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已经核准或启用！"));
		}
		super._delete(ctx, pk);
	}
}