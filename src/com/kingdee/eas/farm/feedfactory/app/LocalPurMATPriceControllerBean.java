package com.kingdee.eas.farm.feedfactory.app;

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
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.IBatch;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo;
import com.kingdee.eas.farm.feedfactory.LocalPurMATPriceFactory;
import com.kingdee.eas.farm.feedfactory.LocalPurMATPriceInfo;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.feedfactory.LocalPurMATPriceCollection;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class LocalPurMATPriceControllerBean extends AbstractLocalPurMATPriceControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.feedfactory.app.LocalPurMATPriceControllerBean");
    

	protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		LocalPurMATPriceInfo info = LocalPurMATPriceFactory.getLocalInstance(ctx).getLocalPurMATPriceInfo(new ObjectUuidPK(((LocalPurMATPriceInfo) model).getId()));
		if(info.getBaseStatus()==null||!info.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有提交的单子才可以执行此操作"));
		try {
			info.setBaseStatus(BillBaseStatusEnum.AUDITED);
			super.save(ctx, info);
		} catch (Exception ex) {
			throw new EASBizException(new NumericExceptionSubItem("001",ex.getMessage()));
		}
	}
	
	

	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		LocalPurMATPriceInfo info = LocalPurMATPriceFactory.getLocalInstance(ctx).getLocalPurMATPriceInfo(new ObjectUuidPK(((LocalPurMATPriceInfo) model).getId()));
		if(info.getBaseStatus()==null||!info.getBaseStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才可以执行此操作"));
		if(DbUtil.executeQuery(ctx, "select * from T_BOT_Relation where FSrcObjectID='"+info.getString("id")+"'").size()>0)
			throw new EASBizException(new NumericExceptionSubItem("001","有下游单据的单据禁止反审核"));
		info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}


	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		LocalPurMATPriceInfo info = (LocalPurMATPriceInfo) model;
		if(info.getBaseStatus()!=null&&!info.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)&&!info.getBaseStatus().equals(BillBaseStatusEnum.CLOSED)) {
			info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		LocalPurMATPriceInfo info = (LocalPurMATPriceInfo) model;
		if(info.getBaseStatus()==null||info.getBaseStatus().getValue()==-1||info.getBaseStatus().equals(BillBaseStatusEnum.ADD)||info.getBaseStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)||info.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			info.setBaseStatus(BillBaseStatusEnum.SUBMITED);
		}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		LocalPurMATPriceInfo info = LocalPurMATPriceFactory.getLocalInstance(ctx).getLocalPurMATPriceInfo(pk);
		if (info.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)||info.getBaseStatus().equals(BillBaseStatusEnum.CLOSED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核或关闭，禁止删除！"));
		}

		super._delete(ctx, pk);
	}
    
    
}