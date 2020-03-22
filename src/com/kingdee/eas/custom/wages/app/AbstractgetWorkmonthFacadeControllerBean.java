package com.kingdee.eas.custom.wages.app;

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



public abstract class AbstractgetWorkmonthFacadeControllerBean extends AbstractBizControllerBean implements getWorkmonthFacadeController
{
    protected AbstractgetWorkmonthFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("545B333B");
    }

    public int getworkmonth(Context ctx, String date) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("9198a8fb-da06-4c48-b0bc-b5efa2877a0d"), new Object[]{ctx, date});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            int retValue = (int)_getworkmonth(ctx, date);
            svcCtx.setMethodReturnValue(new Integer(retValue));
            }
            invokeServiceAfter(svcCtx);
            return ((Integer)svcCtx.getMethodReturnValue()).intValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected int _getworkmonth(Context ctx, String date) throws BOSException
    {    	
        return 0;
    }

    public String getdkgs(Context ctx, String yssd, String companyID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("afad29ea-167d-4ffb-a6b8-f9d73f6ff5b1"), new Object[]{ctx, yssd, companyID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getdkgs(ctx, yssd, companyID);
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
    protected String _getdkgs(Context ctx, String yssd, String companyID) throws BOSException
    {    	
        return null;
    }

    public String getDaySub(Context ctx, String begindate, String enddate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("c0eef141-ee06-4057-94f2-6e2f80e5bb8b"), new Object[]{ctx, begindate, enddate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getDaySub(ctx, begindate, enddate);
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
    protected String _getDaySub(Context ctx, String begindate, String enddate) throws BOSException
    {    	
        return null;
    }

}