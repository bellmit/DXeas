package com.kingdee.eas.farm.carnivorous.basedata.app;

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
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.farm.carnivorous.basedata.MarginBreedPolicyCollection;
import com.kingdee.eas.farm.carnivorous.basedata.MarginBreedPolicyFactory;
import com.kingdee.eas.farm.carnivorous.basedata.MarginGetPolicyFactory;
import com.kingdee.eas.farm.carnivorous.basedata.MarginGetPolicyInfo;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.farm.carnivorous.basedata.MarginBreedPolicyInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MarginBreedPolicyControllerBean extends AbstractMarginBreedPolicyControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.basedata.app.MarginBreedPolicyControllerBean");


	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		MarginBreedPolicyInfo info = (MarginBreedPolicyInfo ) model;		
		if(info.getBillStatue()!=null&&!FarmBaseStatusEnum.unApprove.equals(info.getBillStatue())) {
			throw new EASBizException(new NumericExceptionSubItem("001","�����Ѻ�׼����ã�"));
		}

		info.setBillStatue(FarmBaseStatusEnum.unApprove);
		return super._save(ctx, model);
	}

	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		MarginBreedPolicyInfo info = (MarginBreedPolicyInfo ) model;	
		if(info.getBillStatue()!=null&&!FarmBaseStatusEnum.unApprove.equals(info.getBillStatue())) {
			throw new EASBizException(new NumericExceptionSubItem("001","�����Ѻ�׼����ã�"));
		}

		info.setBillStatue(FarmBaseStatusEnum.unApprove);
		return super._submit(ctx, model);
	}


	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		MarginBreedPolicyInfo info = (MarginBreedPolicyInfo) model;
		if (!info.getBillStatue().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","������δ��׼��"));
		}

		info.setBillStatue(FarmBaseStatusEnum.frozen);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		MarginBreedPolicyInfo info = (MarginBreedPolicyInfo) model;
		if (!info.getBillStatue().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","������δ���ã�"));
		}

		info.setBillStatue(FarmBaseStatusEnum.approve);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _audtit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		MarginBreedPolicyInfo info = (MarginBreedPolicyInfo) model;
		if (!info.getBillStatue().equals(FarmBaseStatusEnum.unApprove)) {
			throw new EASBizException(new NumericExceptionSubItem("001","δ��׼���ϲ���ִ�д˲�����"));
		}
		info.setBillStatue(FarmBaseStatusEnum.approve);
		this._update(ctx, new ObjectUuidPK(info.getId()), info);
	}




	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		MarginBreedPolicyInfo info = (MarginBreedPolicyInfo) model;
		if (!info.getBillStatue().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","������δ��׼��"));
		}
		info.setBillStatue(FarmBaseStatusEnum.unApprove);
		this._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		MarginBreedPolicyInfo info = MarginBreedPolicyFactory.getLocalInstance(ctx).getMarginBreedPolicyInfo(pk);
		if (info.getBillStatue().equals(FarmBaseStatusEnum.approve) || info.getBillStatue().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","�Ѿ���׼����ã�����ɾ����"));
		}
		super._delete(ctx, pk);
	}



}