package com.kingdee.eas.farm.carnivorous.basedata.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

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

import com.kingdee.eas.farm.carnivorous.basedata.DailyOutSaleCPriceFactory;
import com.kingdee.eas.farm.carnivorous.basedata.DailyOutSaleCPriceInfo;
import com.kingdee.eas.framework.app.DataBaseControllerBean;
import com.kingdee.eas.farm.carnivorous.basedata.DailyOutSaleCPriceCollection;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DailyOutSaleCPriceControllerBean extends AbstractDailyOutSaleCPriceControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.basedata.app.DailyOutSaleCPriceControllerBean");

	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		DailyOutSaleCPriceInfo info = (DailyOutSaleCPriceInfo ) model;		
		if(info.getBaseStatus()!=null&&!FarmBaseStatusEnum.unApprove.equals(info.getBaseStatus())) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已核准或禁用！"));
		}
		if(checkIsHasSame(ctx, info)){
			throw new EASBizException(new NumericExceptionSubItem("001","当天已有同一品种的价格单,执行失败!"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		return super._save(ctx, model);
	}

	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		DailyOutSaleCPriceInfo info = (DailyOutSaleCPriceInfo ) model;	
		if(info.getBaseStatus()!=null&&!FarmBaseStatusEnum.unApprove.equals(info.getBaseStatus())) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已核准或禁用！"));
		}
		if(checkIsHasSame(ctx, info)){
			throw new EASBizException(new NumericExceptionSubItem("001","当天已有同一品种的价格单,执行失败!"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		return super._submit(ctx, model);
	}


	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		DailyOutSaleCPriceInfo info = (DailyOutSaleCPriceInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}

		info.setBaseStatus(FarmBaseStatusEnum.frozen);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		DailyOutSaleCPriceInfo info = (DailyOutSaleCPriceInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未禁用！"));
		}
		if(checkIsHasSame(ctx, info)){
			throw new EASBizException(new NumericExceptionSubItem("001","当天已有同一品种的价格单,执行失败!"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		DailyOutSaleCPriceInfo info = (DailyOutSaleCPriceInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
			throw new EASBizException(new NumericExceptionSubItem("001","未核准资料才能执行此操作！"));
		}
		if(checkIsHasSame(ctx, info)){
			throw new EASBizException(new NumericExceptionSubItem("001","当天已有同一品种的价格单,执行失败!"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		DailyOutSaleCPriceInfo info = (DailyOutSaleCPriceInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		this._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		DailyOutSaleCPriceInfo info = DailyOutSaleCPriceFactory.getLocalInstance(ctx).getDailyOutSaleCPriceInfo(pk);
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","已经核准或禁用，不能删除！"));
		}
		super._delete(ctx, pk);
	}

	private Boolean checkIsHasSame(Context ctx,DailyOutSaleCPriceInfo info) {
		// TODO Auto-generated method stub
		Boolean isHas=false;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/select * from CT_FM_DailyOutSaleCPrice where CFBaseStatus =2 and to_char(CFBizDate,'yyyy-mm-dd')='"+sdf.format(info.getBizDate())+"'  ")
		.append(" and CFBreedDataID='"+info.getBreedData().getId().toString()+"' ")
		.append(" and CFFICompanyID='"+info.getFICompany().getId().toString()+"' ");	
		try {
			if(DbUtil.executeQuery(ctx, sqlBuf.toString()).size()>0){
				isHas=true;
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isHas;
	}
}