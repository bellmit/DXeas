package com.kingdee.eas.weighbridge.app;

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

import com.kingdee.jdbc.rowset.IRowSet;
import java.lang.String;



public abstract class AbstractCommSqlFacadeControllerBean extends AbstractBizControllerBean implements CommSqlFacadeController
{
    protected AbstractCommSqlFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("A2BC1A61");
    }

    public IRowSet executeQuery(Context ctx, String sqlStr) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("5643a3f1-975f-401c-94ad-4f7846e62c61"), new Object[]{ctx, sqlStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            IRowSet retValue = (IRowSet)_executeQuery(ctx, sqlStr);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (IRowSet)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IRowSet _executeQuery(Context ctx, String sqlStr) throws BOSException
    {    	
        return null;
    }

    public IRowSet executeQuery(Context ctx, String sqlStr, Object[] params) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("dde81dc5-7241-4520-8c33-9eda1ffd337c"), new Object[]{ctx, sqlStr, params});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            IRowSet retValue = (IRowSet)_executeQuery(ctx, sqlStr, params);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (IRowSet)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IRowSet _executeQuery(Context ctx, String sqlStr, Object[] params) throws BOSException
    {    	
        return null;
    }

    public void execute(Context ctx, String sqlStr) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("4e6ad0a0-5b0d-466f-b04d-00aaaa561c3d"), new Object[]{ctx, sqlStr});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _execute(ctx, sqlStr);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _execute(Context ctx, String sqlStr) throws BOSException
    {    	
        return;
    }

    public void execute(Context ctx, String sqlStr, Object[] params) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("979eb9ec-2fb4-483f-bfe0-67ddbf7dc8b9"), new Object[]{ctx, sqlStr, params});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _execute(ctx, sqlStr, params);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _execute(Context ctx, String sqlStr, Object[] params) throws BOSException
    {    	
        return;
    }

}