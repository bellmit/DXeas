package com.kingdee.eas.farm.dayratecost.app;

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
import com.kingdee.eas.common.EASBizException;



public abstract class AbstractDayrateCalFacadeControllerBean extends AbstractBizControllerBean implements DayrateCalFacadeController
{
    protected AbstractDayrateCalFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("95361A51");
    }

    public Object exeCalDayrate(Context ctx, String jsonStr) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("41c86de2-f42e-4801-8099-082180903ecc"), new Object[]{ctx, jsonStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Object retValue = (Object)_exeCalDayrate(ctx, jsonStr);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (Object)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract Object _exeCalDayrate(Context ctx, String jsonStr) throws BOSException, EASBizException;

    public void exeClose(Context ctx, String companyID, String periodID) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("39f735e8-34c0-4bc4-8b30-438f7b186954"), new Object[]{ctx, companyID, periodID});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _exeClose(ctx, companyID, periodID);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract void _exeClose(Context ctx, String companyID, String periodID) throws BOSException, EASBizException;

    public void exeUnClose(Context ctx, String companyID, String periodID) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("b479056d-bcbe-41f8-a141-c2fe42859f6a"), new Object[]{ctx, companyID, periodID});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _exeUnClose(ctx, companyID, periodID);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract void _exeUnClose(Context ctx, String companyID, String periodID) throws BOSException, EASBizException;

}