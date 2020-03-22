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

import com.kingdee.eas.framework.app.DataBaseControllerBean;
import com.kingdee.eas.farm.hatch.HatchBaseDataCollection;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class HatchBaseDataControllerBean extends AbstractHatchBaseDataControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.hatch.app.HatchBaseDataControllerBean");



	/**
	 * 禁用
	 */
	@Override
	public void cancel(Context ctx, IObjectPK pk, CoreBaseInfo model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		HatchBaseDataInfo info = (HatchBaseDataInfo)model;
		info.setBillStatus(com.kingdee.eas.farm.hatch.billStatus.save);
		super.cancel(ctx, pk, model);
	}
	
	/**
	 * 启用
	 */
	@Override
	public void cancelCancel(Context ctx, IObjectPK pk, CoreBaseInfo model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		HatchBaseDataInfo info = (HatchBaseDataInfo)model;
		info.setBillStatus(com.kingdee.eas.farm.hatch.billStatus.cancelcancel);
		super.cancelCancel(ctx, pk, model);
	}



	/**
	 * 保存
	 */
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		HatchBaseDataInfo info = (HatchBaseDataInfo)model;
		info.setBillStatus(com.kingdee.eas.farm.hatch.billStatus.save);
		return super._save(ctx, model);
	}
	/**
	 * 提交
	 */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		HatchBaseDataInfo info = (HatchBaseDataInfo)model;
		info.setBillStatus(com.kingdee.eas.farm.hatch.billStatus.submit);
		return super._submit(ctx, model);
	}
	/**
	 * 审核
	 */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub
		HatchBaseDataInfo info = (HatchBaseDataInfo)model;
		info.setBillStatus(com.kingdee.eas.farm.hatch.billStatus.audit);
		try {
			super._save(ctx, info);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * 反审核
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
	throws BOSException {
		// TODO Auto-generated method stub
		HatchBaseDataInfo info = (HatchBaseDataInfo)model;
		info.setBillStatus(com.kingdee.eas.farm.hatch.billStatus.save);
		try {
			super._save(ctx, info);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}