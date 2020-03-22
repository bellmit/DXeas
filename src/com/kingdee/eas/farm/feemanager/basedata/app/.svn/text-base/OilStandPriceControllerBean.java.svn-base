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
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.farm.feemanager.basedata.OilPriceFactory;
import com.kingdee.eas.farm.feemanager.basedata.OilPriceInfo;
import com.kingdee.eas.farm.feemanager.basedata.OilStandPriceCollection;
import com.kingdee.eas.farm.feemanager.basedata.OilStandPriceFactory;

import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.farm.feemanager.basedata.OilStandPriceInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class OilStandPriceControllerBean extends AbstractOilStandPriceControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.feemanager.basedata.app.OilStandPriceControllerBean");
    @Override
	protected void _review(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub
    	OilStandPriceInfo info = (OilStandPriceInfo) model;
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
		OilStandPriceInfo info = (OilStandPriceInfo) model;
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
		OilStandPriceInfo info = OilStandPriceFactory.getLocalInstance(ctx).getOilStandPriceInfo(pk);
		if (info.getState().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","µ•æ›“—æ≠…Û∫À£¨Ω˚÷π…æ≥˝£°"));
		}
		super._delete(ctx, pk);
	}
	
	
	
	
	
	

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		OilStandPriceInfo  tinfo=(OilStandPriceInfo)model;
		tinfo.setState(BillBaseStatusEnum.SUBMITED);
		return super._submit(ctx, tinfo);
	}
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		OilStandPriceInfo tinfo=(OilStandPriceInfo)model;
		tinfo.setState(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, model);
	}
	
}