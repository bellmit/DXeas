package com.kingdee.eas.publicdata.app;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.ServerUtils;
import com.kingdee.eas.farm.feemanager.basedata.CarState;
import com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo;
import com.kingdee.eas.farm.feemanager.basedata.DriverInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.publicdata.CarFactory;
import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class CarControllerBean extends AbstractCarControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.publicdata.app.CarControllerBean");




	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		CarInfo info = (CarInfo) model;
		if (info.getBaseStatus()!=null&&!FarmBaseStatusEnum.unApprove.equals(info.getBaseStatus())) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已核准或禁用！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		return super._save(ctx, model);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		CarInfo info = (CarInfo) model;
		if (info.getBaseStatus()!=null&&!FarmBaseStatusEnum.unApprove.equals(info.getBaseStatus())) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已核准或禁用！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		return super._submit(ctx, model);
	}

	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		CarInfo info = (CarInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.frozen);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		CarInfo info = (CarInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未禁用！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CarInfo info = (CarInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
			throw new EASBizException(new NumericExceptionSubItem("001","未核准资料才能执行此操作！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CarInfo info = (CarInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		this._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CarInfo info = CarFactory.getLocalInstance(ctx).getCarInfo(pk);
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","已经核准或禁用，不能删除！"));
		}
		//		StringBuffer sql=new StringBuffer();
		//		sql.append(" select fid from T_FM_FodderReception where CFCarID=?");
		//		IRowSet rs=DbUtil.executeQuery(ctx, sql.toString(),new Object[]{pk.toString(),pk.toString()});
		//		try {
		//			if(rs.next()) {
		//				throw new EASBizException(new NumericExceptionSubItem("001","该资料已经被使用，禁止删除"));
		//			}
		//			rs.next();
		//		} catch (SQLException e) {
		//			e.printStackTrace();
		//		}
		super._delete(ctx, pk);
	}

	@Override
	protected void _review(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void _unreview(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}


}