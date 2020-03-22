package com.kingdee.eas.farm.hatch.app;

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
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.hatch.EarlyEggStockCollection;
import com.kingdee.eas.farm.hatch.EarlyEggStockFactory;
import com.kingdee.eas.farm.hatch.IEarlyEggStock;
import com.kingdee.eas.farm.hatch.billStatus;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.hatch.EarlyEggStockInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class EarlyEggStockControllerBean extends AbstractEarlyEggStockControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.hatch.app.EarlyEggStockControllerBean");

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		EarlyEggStockInfo info=(EarlyEggStockInfo) model;
		info.setBillStatus(billStatus.save);
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		EarlyEggStockInfo info=(EarlyEggStockInfo) model;
		info.setBillStatus(billStatus.submit);
		return super._submit(ctx, info);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue Info) throws BOSException,
	EASBizException {
		EarlyEggStockInfo info = (EarlyEggStockInfo) Info;
		info.setBillStatus(billStatus.audit);
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		try {
			super._update(ctx, new ObjectUuidPK(info.getId().toString()), info);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
		super._audit(ctx, Info);
	}
}