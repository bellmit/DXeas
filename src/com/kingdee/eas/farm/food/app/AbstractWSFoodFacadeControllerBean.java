package com.kingdee.eas.farm.food.app;

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



public abstract class AbstractWSFoodFacadeControllerBean extends AbstractBizControllerBean implements WSFoodFacadeController
{
    protected AbstractWSFoodFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("DD61C81E");
    }

    public String uploadBill(Context ctx, String jsonString) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("b8a82c68-2ea1-4bc3-81fb-6a1dbb78fc3d"), new Object[]{ctx, jsonString});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_uploadBill(ctx, jsonString);
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
    protected String _uploadBill(Context ctx, String jsonString) throws BOSException
    {    	
        return null;
    }

    public String getBaseData(Context ctx, String jsonStr) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("e271465f-70c5-44fe-bdd5-f37289f609f9"), new Object[]{ctx, jsonStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getBaseData(ctx, jsonStr);
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
    protected String _getBaseData(Context ctx, String jsonStr) throws BOSException
    {    	
        return null;
    }

    public String getBillList(Context ctx, String jsonString) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("b34aee56-bc8c-4bb3-92a6-952d5d660731"), new Object[]{ctx, jsonString});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getBillList(ctx, jsonString);
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
    protected String _getBillList(Context ctx, String jsonString) throws BOSException
    {    	
        return null;
    }

    public String getBillInfo(Context ctx, String jsonString) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("98e31d76-396f-4158-a64e-67581e364d63"), new Object[]{ctx, jsonString});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getBillInfo(ctx, jsonString);
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
    protected String _getBillInfo(Context ctx, String jsonString) throws BOSException
    {    	
        return null;
    }

}