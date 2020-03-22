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
import com.kingdee.eas.farm.carnivorous.basedata.BrowerItemNewFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BrowerItemNewInfo;
import com.kingdee.eas.farm.carnivorous.basedata.MarginBorrowPolicyFactory;
import com.kingdee.eas.farm.carnivorous.basedata.MarginBorrowPolicyInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.farm.carnivorous.basedata.MarginBorrowPolicyCollection;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MarginBorrowPolicyControllerBean extends AbstractMarginBorrowPolicyControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.carnivorous.basedata.app.MarginBorrowPolicyControllerBean");
    

    protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
    	MarginBorrowPolicyInfo info = (MarginBorrowPolicyInfo ) model;		
		if(info.getBillStatus()!=null&&!FarmBaseStatusEnum.unApprove.equals(info.getBillStatus())) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已核准或禁用！"));
		}
		
		info.setBillStatus(FarmBaseStatusEnum.unApprove);
		return super._save(ctx, model);
	}

	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		MarginBorrowPolicyInfo info = (MarginBorrowPolicyInfo ) model;	
		if(info.getBillStatus()!=null&&!FarmBaseStatusEnum.unApprove.equals(info.getBillStatus())) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已核准或禁用！"));
		}
		
		info.setBillStatus(FarmBaseStatusEnum.unApprove);
		return super._submit(ctx, model);
	}


	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		MarginBorrowPolicyInfo info = (MarginBorrowPolicyInfo) model;
		if (!info.getBillStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}

		info.setBillStatus(FarmBaseStatusEnum.frozen);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		MarginBorrowPolicyInfo info = (MarginBorrowPolicyInfo) model;
		if (!info.getBillStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未禁用！"));
		}
		
		info.setBillStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		MarginBorrowPolicyInfo info = (MarginBorrowPolicyInfo) model;
		if (!info.getBillStatus().equals(FarmBaseStatusEnum.unApprove)) {
			throw new EASBizException(new NumericExceptionSubItem("001","未核准资料才能执行此操作！"));
		}
		
		info.setBillStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		MarginBorrowPolicyInfo info = (MarginBorrowPolicyInfo) model;
		if (!info.getBillStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}
		info.setBillStatus(FarmBaseStatusEnum.unApprove);
		this._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		MarginBorrowPolicyInfo info = MarginBorrowPolicyFactory.getLocalInstance(ctx).getMarginBorrowPolicyInfo(pk);
		if (info.getBillStatus().equals(FarmBaseStatusEnum.approve) || info.getBillStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","已经核准或禁用，不能删除！"));
		}
		super._delete(ctx, pk);
	}

    
}