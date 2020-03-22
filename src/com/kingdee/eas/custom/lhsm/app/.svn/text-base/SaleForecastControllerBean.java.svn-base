package com.kingdee.eas.custom.lhsm.app;

import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.bi.model.DB.DBUtil;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.lhsm.ForecastEnum;
import com.kingdee.eas.custom.lhsm.SaleForecastInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class SaleForecastControllerBean extends AbstractSaleForecastControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.lhsm.app.SaleForecastControllerBean");

	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		SaleForecastInfo info=(SaleForecastInfo)model;
		info.setState(ForecastEnum.SAVE);
		return super._save(ctx, model);
	}

	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		SaleForecastInfo info=(SaleForecastInfo)model;
		info.setState(ForecastEnum.SUBMIT);
		return super._submit(ctx, model);
	}
	
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		SaleForecastInfo info=(SaleForecastInfo)model;
		/*StringBuffer sql=new StringBuffer();
		if(info.getId()!=null){
			sql=new StringBuffer();
			sql.append(" update CT_LHS_SALEFORECAST set CFSTATE='3' ");
			sql.append(" where fid='"+info.getId().toString()+"' ");
			com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
		}
		super._audit(ctx, model);*/
		info.setState(ForecastEnum.AUDIT);
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		info.setAuditTime(new Date());
		try {
			super.update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			throw new BOSException(e);
		}
	 }
	
	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException {
		SaleForecastInfo info=(SaleForecastInfo)model;
		if(info.getState()!=null&&!info.getState().equals(ForecastEnum.AUDIT)) {
			throw new EASBizException(new NumericExceptionSubItem("","该单据尚未审核，禁止反审核！"));
		}
 		/*StringBuffer sql=new StringBuffer();
		if(info.getId()!=null){
			sql=new StringBuffer();
			sql.append(" update CT_LHS_SALEFORECAST set CFSTATE='1' ");
			sql.append(" where fid='"+info.getId().toString()+"' ");
			com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
		}
		super._unAudit(ctx, model);*/
		
		if(info.getId()!=null) {
			IRowSet rs = DbUtil.executeQuery(ctx, "select 1 from t_sd_saleorder where fsourcebillid='"+info.getString("id")+"'");
			if(rs.size()>0) {
				throw new EASBizException(new NumericExceptionSubItem("","该单据已经生成销售订单，禁止反审核！"));
			}
		}
		
		info.setState(ForecastEnum.SAVE);
		info.setAuditor(null);
		info.setAuditTime(null);
		try {
			super.update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			throw new BOSException(e);
		}
	}

	@Override
	protected void _progressView(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void _viewPro(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		SaleForecastInfo editData = getSaleForecastInfo(ctx, pk);
		ForecastEnum baseStatus = editData.getState();
		if(baseStatus != null){
			int baseStatusValue = Integer.parseInt(baseStatus.getValue());
			if(baseStatusValue==3||baseStatusValue==5){
				throw new EASBizException(new NumericExceptionSubItem("","经审核或者分配，不能删除！"));
			}
		}
		
		super._delete(ctx, pk);
	}
	
	
}