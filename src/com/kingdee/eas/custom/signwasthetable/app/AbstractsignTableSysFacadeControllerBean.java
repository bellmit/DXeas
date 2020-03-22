package com.kingdee.eas.custom.signwasthetable.app;

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



public abstract class AbstractsignTableSysFacadeControllerBean extends AbstractBizControllerBean implements signTableSysFacadeController
{
    protected AbstractsignTableSysFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("E1118520");
    }

    public void signTypeCancel(Context ctx, String id) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("bdf7468a-c4ca-42f8-ab61-283a35111d4d"), new Object[]{ctx, id});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _signTypeCancel(ctx, id);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract void _signTypeCancel(Context ctx, String id) throws BOSException;

    public void signTypeCancelcancel(Context ctx, String id) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("1bc4fdc5-be89-4279-9df2-59cf776defa8"), new Object[]{ctx, id});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _signTypeCancelcancel(ctx, id);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract void _signTypeCancelcancel(Context ctx, String id) throws BOSException;

    public void engProjectCancel(Context ctx, String id) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("ecb58e87-57e8-4753-a17c-6c5aa00ff0db"), new Object[]{ctx, id});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _engProjectCancel(ctx, id);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract void _engProjectCancel(Context ctx, String id) throws BOSException;

    public void engProjectCancelCancel(Context ctx, String id) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("f5203b86-f167-4e63-8463-c950d118420a"), new Object[]{ctx, id});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _engProjectCancelCancel(ctx, id);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract void _engProjectCancelCancel(Context ctx, String id) throws BOSException;

    public void cTypeCancel(Context ctx, String id) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7feccb2e-8d87-4fa6-a577-95cffbf10daf"), new Object[]{ctx, id});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _cTypeCancel(ctx, id);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract void _cTypeCancel(Context ctx, String id) throws BOSException;

    public void cTypeCancelCancel(Context ctx, String id) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("44eea2e2-5e36-4000-88dd-eabada3bfb8b"), new Object[]{ctx, id});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _cTypeCancelCancel(ctx, id);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract void _cTypeCancelCancel(Context ctx, String id) throws BOSException;

}