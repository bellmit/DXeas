package com.kingdee.eas.farm.food.stocount.app;

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
import com.kingdee.eas.farm.food.stocount.CountPositionSetInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.farm.food.stocount.CountPositionSetCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CountPositionSetControllerBean extends AbstractCountPositionSetControllerBean
{
	 /**
     * Ω˚”√
     */
    @Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
    	String sql = "update CT_FM_CountPositionSet CFBaseUnit = 2 where fid = '"+pk+"'";
    	System.out.println(pk);
    	System.out.println(ctx.get("fid"));
    	//System.out.println(ctx.get("id"));
    	//DbUtil.execute(ctx, sql);
		super._cancel(ctx, pk, model);
	}

    /**
     * ∆Ù”√
     */
	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		String sql = "update CT_FM_CountPositionSet CFBaseUnit = 2 where fid = '"+pk+"'";
    	System.out.println(pk);
    	System.out.println(ctx.get("fid"));
    	//System.out.println(ctx.get("id"));
    	//DbUtil.execute(ctx, sql);
		super._cancelCancel(ctx, pk, model);
	}

	private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.food.stocount.app.CountPositionSetControllerBean");
}