package com.kingdee.eas.custom.shr.app;

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

import java.util.ArrayList;
import java.lang.String;



public abstract class AbstractshrBaseDataQueryFacadeControllerBean extends AbstractBizControllerBean implements shrBaseDataQueryFacadeController
{
    protected AbstractshrBaseDataQueryFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("31F946A0");
    }

    public ArrayList queryForBusList(Context ctx, String queryStr) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("c68450f6-4d44-453a-8990-2d16460dba21"), new Object[]{ctx, queryStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ArrayList retValue = (ArrayList)_queryForBusList(ctx, queryStr);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (ArrayList)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract ArrayList _queryForBusList(Context ctx, String queryStr) throws BOSException;

    public ArrayList queryForStopList(Context ctx, String sqlStopList) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("943315ba-0a69-447e-8679-4a8368c2484b"), new Object[]{ctx, sqlStopList});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ArrayList retValue = (ArrayList)_queryForStopList(ctx, sqlStopList);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (ArrayList)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract ArrayList _queryForStopList(Context ctx, String sqlStopList) throws BOSException;

    public void excuteBusAndStop(Context ctx, String excuteStr) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("f38b142e-ecf5-4b9f-a819-29fdc3e86292"), new Object[]{ctx, excuteStr});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _excuteBusAndStop(ctx, excuteStr);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract void _excuteBusAndStop(Context ctx, String excuteStr) throws BOSException;

    public ArrayList queryForEmpInfo(Context ctx, String sqlPerson) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("ce080e4f-5470-4c69-8061-973df5aa258e"), new Object[]{ctx, sqlPerson});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ArrayList retValue = (ArrayList)_queryForEmpInfo(ctx, sqlPerson);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (ArrayList)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract ArrayList _queryForEmpInfo(Context ctx, String sqlPerson) throws BOSException;

    public String queryForOtherPerson(Context ctx, String updateDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d8f3a9a3-ea7f-47fb-a457-776086656ece"), new Object[]{ctx, updateDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_queryForOtherPerson(ctx, updateDate);
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
    protected abstract String _queryForOtherPerson(Context ctx, String updateDate) throws BOSException;

}