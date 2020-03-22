package com.kingdee.eas.custom.festival.app;

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



public abstract class AbstractOtherBillNewFacadeControllerBean extends AbstractBizControllerBean implements OtherBillNewFacadeController
{
    protected AbstractOtherBillNewFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("B1F9A42E");
    }

    public String[] submit(Context ctx, String xmlData) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("be075397-9c7b-4fc7-8f53-7f05f83ef254"), new Object[]{ctx, xmlData});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String[] retValue = (String[])_submit(ctx, xmlData);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (String[])svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract String[] _submit(Context ctx, String xmlData) throws BOSException;

}