package com.kingdee.eas.farm.breed.layegg.app;

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
import com.kingdee.eas.farm.breed.layegg.ParentEggDailyInfo;
import com.kingdee.bos.dao.IObjectPK;
import java.util.List;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.layegg.ParentEggDailyCollection;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ParentEggDailyControllerBeanEx extends com.kingdee.eas.farm.breed.layegg.app.ParentEggDailyControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.breed.layegg.app.ParentEggDailyControllerBeanEx");
    protected void _audit(Context ctx, IObjectValue model)throws BOSException
    {
	     super._audit(ctx, model);
    }
    protected void _unAudit(Context ctx, IObjectValue model)throws BOSException
    {
	     super._unAudit(ctx, model);
    }
    protected List _genNextBill(Context ctx, IObjectValue model)throws BOSException
    {
	    return  super._genNextBill(ctx, model);
    }
    protected void _reShareInfos(Context ctx, IObjectValue model)throws BOSException
    {
	     super._reShareInfos(ctx, model);
    }
    protected void _refreshInventory(Context ctx, IObjectValue model)throws BOSException
    {
	     super._refreshInventory(ctx, model);
    }
}				
