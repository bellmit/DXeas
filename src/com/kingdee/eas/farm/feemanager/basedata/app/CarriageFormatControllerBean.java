package com.kingdee.eas.farm.feemanager.basedata.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
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
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordFactory;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo;
import com.kingdee.eas.farm.feemanager.basedata.CarriageFormatFactory;
import com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo;
import com.kingdee.eas.farm.feemanager.basedata.DriverInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.farm.feemanager.basedata.CarriageFormatCollection;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CarriageFormatControllerBean extends AbstractCarriageFormatControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.feemanager.basedata.app.CarriageFormatControllerBean");

	@Override
	protected void _review(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub
		CarriageFormatInfo info = (CarriageFormatInfo) model;
		// Ω˚÷π÷ÿ∏¥…Û∫À ∑«Ã·Ωª≤ª…Û∫À
		if (!info.getState().equals(BillBaseStatusEnum.SUBMITED)) {
			return;
		}
		try {
			info.setState(BillBaseStatusEnum.AUDITED);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
	}

	@Override
	protected void _unreview(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		CarriageFormatInfo info = (CarriageFormatInfo) model;
		// ∑¥Ω˚÷π÷ÿ∏¥…Û∫À
		if (!info.getState().equals(BillBaseStatusEnum.AUDITED)) {
			return;
		}
		try {
			info.setState(BillBaseStatusEnum.TEMPORARILYSAVED);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			logger.error(e);
			throw new BOSException(e);
		}
		
		
	}
	
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		// TODO Auto-generated method stub
		CarriageFormatInfo info = CarriageFormatFactory.getLocalInstance(ctx).getCarriageFormatInfo(pk);
		if (info.getState().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","µ•æ›“—æ≠…Û∫À£¨Ω˚÷π…æ≥˝£°"));
		}
		super._delete(ctx, pk);
	}
	
	
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CarriageFormatInfo  tinfo=(CarriageFormatInfo)model;
		//prinfo.setStata(BillBaseStatusEnum.SUBMITED);
		tinfo.setState(BillBaseStatusEnum.SUBMITED);
//		super._update(ctx, new ObjectUuidPK(prinfo.getId().toString()), prinfo);
		return super._submit(ctx, tinfo);
	}
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CarriageFormatInfo tinfo=(CarriageFormatInfo)model;
		tinfo.setState(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, model);
	}
}