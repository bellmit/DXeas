package com.kingdee.eas.farm.stocking.basedata.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.hatch.GenderType;
import com.kingdee.eas.farm.stocking.hatch.GenerateType;
import com.kingdee.eas.framework.Result;
import com.kingdee.util.NumericExceptionSubItem;

public class BreedDataControllerBean extends AbstractBreedDataControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.stocking.basedata.app.BreedDataControllerBean");

	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		BreedDataInfo info = (BreedDataInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未启用！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		BreedDataInfo info = (BreedDataInfo) model;
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已经启用！"));
		}
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}

		info.setBaseStatus(FarmBaseStatusEnum.enable);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BreedDataInfo info = (BreedDataInfo) model;
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已经核准或启用！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		try {
			this._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BreedDataInfo info = (BreedDataInfo) model;
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
		BreedDataInfo info = BreedDataFactory.getLocalInstance(ctx).getBreedDataInfo(pk);
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已经核准或启用！"));
		}
		super._delete(ctx, pk);
	}

	@Override
	protected void _checkNumberDup(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BreedDataInfo info = (BreedDataInfo) model;
		if(info.getGenerateType().equals(GenerateType.GrandParent))
			if(info.getGenderType().equals(null))
				throw new EASBizException(new NumericExceptionSubItem("001","祖代鸭必须填写父母系字段"));
		super._checkNumberDup(ctx, model);
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BreedDataInfo info = (BreedDataInfo) model;
		if(info.getGenerateType()==null)
			throw new EASBizException(new NumericExceptionSubItem("001","代系不能为空"));
		if(info.getGenerateType().equals(GenerateType.GrandParent))
			if(info.getGenderType()==null)
				throw new EASBizException(new NumericExceptionSubItem("001","祖代鸭必须填写父母系字段"));
		return super._save(ctx, model);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BreedDataInfo info = (BreedDataInfo) model;
		if(info.getGenerateType()==null)
			throw new EASBizException(new NumericExceptionSubItem("001","代系不能为空"));
		if(info.getGenerateType().equals(GenerateType.GrandParent))
			if(info.getGenderType()==null)
				throw new EASBizException(new NumericExceptionSubItem("001","祖代鸭必须填写父母系字段"));
		return super._submit(ctx, model);
	}



}