package com.kingdee.eas.farm.feemanager.basedata.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.framework.app.DataBaseControllerBean;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo;

import com.kingdee.eas.farm.feemanager.basedata.DriverCollection;
import com.kingdee.eas.farm.feemanager.basedata.DriverFactory;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.farm.feemanager.basedata.DriverInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;

import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.ServerUtils;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DriverControllerBean extends AbstractDriverControllerBean
{
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		DriverInfo info = (DriverInfo) model;
//		if (info.getBaseStatus()!=null&&!FarmBaseStatusEnum.unApprove.equals(info.getBaseStatus())) {
//			throw new EASBizException(new NumericExceptionSubItem("001","资料已核准或禁用！"));
//		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		return super._save(ctx, model);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		DriverInfo info = (DriverInfo) model;
//		if (info.getBaseStatus()!=null&&!info.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
//			throw new EASBizException(new NumericExceptionSubItem("001","资料已核准或禁用！"));
//		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		return super._submit(ctx, model);
	}
	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		DriverInfo info = (DriverInfo) model;
//		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
//			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
//		}
		info.setBaseStatus(FarmBaseStatusEnum.frozen);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		DriverInfo info = (DriverInfo) model;
//		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
//			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未禁用！"));
//		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		DriverInfo info = (DriverInfo) model;
//		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
//			throw new EASBizException(new NumericExceptionSubItem("001","未核准资料才能执行此操作！"));
//		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		DriverInfo info = (DriverInfo) model;
		if (!info.getState().equals(BillBaseStatusEnum.cancelcancel) || info.getState().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		this._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		DriverInfo info = DriverFactory.getLocalInstance(ctx).getDriverInfo(pk);
		if (info.getState().equals(BillBaseStatusEnum.cancelcancel) || info.getState().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","已经核准或禁用，不能删除！"));
		}

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