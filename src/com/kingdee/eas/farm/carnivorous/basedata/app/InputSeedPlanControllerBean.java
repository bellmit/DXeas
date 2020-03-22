package com.kingdee.eas.farm.carnivorous.basedata.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

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

import com.kingdee.eas.farm.carnivorous.basedata.InputSeedPlanFactory;
import com.kingdee.eas.farm.carnivorous.basedata.InputSeedPlanInfo;
import com.kingdee.eas.framework.app.DataBaseControllerBean;
import com.kingdee.eas.farm.carnivorous.basedata.InputSeedPlanCollection;
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
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class InputSeedPlanControllerBean extends AbstractInputSeedPlanControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.carnivorous.basedata.app.InputSeedPlanControllerBean");
    
    protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		InputSeedPlanInfo info = (InputSeedPlanInfo ) model;		
		if(info.getBaseStatus()!=null&&!FarmBaseStatusEnum.unApprove.equals(info.getBaseStatus())) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已核准或禁用！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		return super._save(ctx, model);
	}

	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		InputSeedPlanInfo info = (InputSeedPlanInfo ) model;	
		if(info.getBaseStatus()!=null&&!FarmBaseStatusEnum.unApprove.equals(info.getBaseStatus())) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已核准或禁用！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		return super._submit(ctx, model);
	}

	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		InputSeedPlanInfo info = (InputSeedPlanInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.frozen);
		this._update(ctx, pk, info);
	}

	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		InputSeedPlanInfo info = (InputSeedPlanInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未禁用！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, pk, info);
	}

	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		InputSeedPlanInfo info = (InputSeedPlanInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
			throw new EASBizException(new NumericExceptionSubItem("001","未核准资料才能执行此操作！"));
		}
		checkIsUnique(ctx);
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		InputSeedPlanInfo info = (InputSeedPlanInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		this._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		InputSeedPlanInfo info = InputSeedPlanFactory.getLocalInstance(ctx).getInputSeedPlanInfo(pk);
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","已经核准或禁用，不能删除！"));
		}
		super._delete(ctx, pk);
	}
	
	
	private void checkIsUnique(Context ctx) throws EASBizException {
		// TODO Auto-generated method stub
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" select * from (SELECT  ")
		.append(" t2.CFDate CFDate, ")
		.append(" count(*) time ")
		.append(" FROM CT_FM_InputSeedPlan t1 ")
		.append(" inner join CT_FM_InputSeedPlanEntry t2 on t1.fid=t2.fparentid ")
		.append(" where t1.CFBaseStatus =2 ")
		.append(" group by t2.CFDate,t1.CFBreedDataID)t ")
		.append(" where t.time>1 ");
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sqlBuf.toString());
			if(rs.next()){
				throw new EASBizException(new NumericExceptionSubItem("001","存在多个重复数据,当前操作失败,请核查!"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}