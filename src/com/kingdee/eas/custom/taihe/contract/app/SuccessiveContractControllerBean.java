package com.kingdee.eas.custom.taihe.contract.app;

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

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.ServerUtils;
import com.kingdee.eas.custom.taihe.contract.SuccessiveContractCollection;
import java.lang.String;
import com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SuccessiveContractControllerBean extends AbstractSuccessiveContractControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.taihe.contract.app.SuccessiveContractControllerBean");

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		model = ServerUtils.audit(ctx, model, null);
		super._save(ctx, model);
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		model = ServerUtils.unAudit(ctx, model, null);
		super._save(ctx, model);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		// TODO Auto-generated method stub
		ServerUtils.delete(ctx, pk, null);
		super._delete(ctx, pk);
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		if(model.getInt("billStatus")!=-1&&model.getInt("billStatus")!=0&&model.getInt("billStatus")!=1)
			throw new EASBizException(ServerUtils.CHECKSAVE);

		
		model.setDate("bizDate", DateUtilsComm.clearDateHMS(model.getDate("bizDate")));
		model.setInt("billStatus", 1);
		return super._save(ctx, model);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		if(model.getInt("billStatus")!=-1&&model.getInt("billStatus")!=0&&model.getInt("billStatus")!=1)
			throw new EASBizException(ServerUtils.CHECKSUBMIT);

		
		model.setDate("bizDate", DateUtilsComm.clearDateHMS(model.getDate("bizDate")));
		model.setInt("billStatus", 2);
		return super._submit(ctx, model);
	}
	
}