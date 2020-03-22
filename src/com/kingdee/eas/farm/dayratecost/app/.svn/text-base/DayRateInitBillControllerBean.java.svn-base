package com.kingdee.eas.farm.dayratecost.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.dayratecost.DayRateBaseSettingFactory;
import com.kingdee.eas.farm.dayratecost.DayRateBaseSettingInfo;
import com.kingdee.eas.farm.dayratecost.DayRateInitBillFactory;
import com.kingdee.eas.farm.dayratecost.DayRateInitBillInfo;
import com.kingdee.eas.farm.dayratecost.comm.DayrateUtils;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class DayRateInitBillControllerBean extends AbstractDayRateInitBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.dayratecost.app.DayRateInitBillControllerBean");
    protected void _audit(Context ctx, IObjectValue model)throws BOSException
    {
    	try {
    		DayRateInitBillInfo info = (DayRateInitBillInfo) model;
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
    		DayRateInitBillInfo info = (DayRateInitBillInfo) model;
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
    	DayRateInitBillInfo info = (DayRateInitBillInfo) model;
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
    		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
    	}
		return super._save(ctx, info);
	}
    
    @Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
    	DayRateInitBillInfo info = (DayRateInitBillInfo) model;
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
    		info.setBillStatus(BillBaseStatusEnum.SUBMITED);
    	}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		DayRateInitBillInfo info = DayRateInitBillFactory.getLocalInstance(ctx).getDayRateInitBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		super._delete(ctx, pk);
	}

	
	@Override
	/**
	 * 初始化
	 */
	protected void _initialize(Context ctx, IObjectValue model)	throws BOSException, EASBizException {
		DayRateInitBillInfo info = (DayRateInitBillInfo) model;
		DayRateBaseSettingInfo bdInfo = DayrateUtils.getBaseSetting(ctx, info.getCompany().getString("id"));
		if(bdInfo==null) {
			throw new EASBizException(new NumericExceptionSubItem("001","请先设置系统参数！"));
		}
		if(bdInfo.isIsInit()) {
			throw new EASBizException(new NumericExceptionSubItem("001","已经初始化完成，禁止再次初始化！"));
		}
		
		
		StringBuffer sql=new StringBuffer();
		sql.append(" select 1 from T_FM_DayRateInitBill")
		.append(" where fcompanyid='").append(info.getCompany().getString("id")).append("'")
		.append(" and fbillStatus!=4")
		.append(" and (FIsInit=0 or FIsInit is null)")
		.append(" ");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		if(rs.size()>0) {
			throw new EASBizException(new NumericExceptionSubItem("001","存在尚未审核的初始化单据！"));
		}
		
		bdInfo.setIsInit(true);
		bdInfo.setCurrentPeriod(info.getPeriod());
		DayRateBaseSettingFactory.getLocalInstance(ctx).update(new ObjectUuidPK(bdInfo.getId()),bdInfo);
	}

	@Override
	/**
	 * 反初始化
	 */
	protected void _unInitialize(Context ctx, IObjectValue model)	throws BOSException, EASBizException {
		DayRateInitBillInfo info = (DayRateInitBillInfo) model;
		DayRateBaseSettingInfo bdInfo = DayrateUtils.getBaseSetting(ctx, info.getCompany().getString("id"));
		if(bdInfo==null) {
			throw new EASBizException(new NumericExceptionSubItem("001","请先设置系统参数！"));
		}
		if(!bdInfo.isIsInit()) {
			throw new EASBizException(new NumericExceptionSubItem("001","尚未完成初始化！"));
		}
		bdInfo.setIsInit(false);
		bdInfo.setCurrentPeriod(null);
		DayRateBaseSettingFactory.getLocalInstance(ctx).update(new ObjectUuidPK(bdInfo.getId()),bdInfo);
	}
}