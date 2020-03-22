package com.kingdee.eas.farm.stocking.basedata.app;

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
import com.kingdee.eas.framework.Result;
import com.kingdee.eas.framework.LineResult;
import com.kingdee.eas.framework.exception.EASMultiException;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;

import java.lang.String;



public abstract class AbstractStockingFacadeControllerBean extends AbstractBizControllerBean implements StockingFacadeController
{
    protected AbstractStockingFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("14FA3E57");
    }

    public String CreateCostObject(Context ctx, Object param) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("25bea573-f5db-497b-96ad-35f9185e436f"), new Object[]{ctx, param});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_CreateCostObject(ctx, param);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (String)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected String _CreateCostObject(Context ctx, Object param) throws BOSException
    {    	
        return null;
    }

    public void Internal2StockingDaily(Context ctx, String param) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("ef2b56c6-f990-428f-888e-d990f9c8a6e8"), new Object[]{ctx, param});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _Internal2StockingDaily(ctx, param);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _Internal2StockingDaily(Context ctx, String param) throws BOSException
    {    	
        return;
    }

}