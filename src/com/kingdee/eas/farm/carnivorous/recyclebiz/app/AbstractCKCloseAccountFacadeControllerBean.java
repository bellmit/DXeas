package com.kingdee.eas.farm.carnivorous.recyclebiz.app;

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



public abstract class AbstractCKCloseAccountFacadeControllerBean extends AbstractBizControllerBean implements CKCloseAccountFacadeController
{
    protected AbstractCKCloseAccountFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("05367C94");
    }

    public boolean checkIsClosed(Context ctx, String companyID, String periodID) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("9a827bb9-3673-43b3-840f-54c8009070a6"), new Object[]{ctx, companyID, periodID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_checkIsClosed(ctx, companyID, periodID);
            svcCtx.setMethodReturnValue(new Boolean(retValue));
            }
            invokeServiceAfter(svcCtx);
            return ((Boolean)svcCtx.getMethodReturnValue()).booleanValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected boolean _checkIsClosed(Context ctx, String companyID, String periodID) throws BOSException, EASBizException
    {    	
        return false;
    }

    public void closeAccount(Context ctx, String companyID, String periodID) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("cd215749-8c8d-4ede-b063-9eadcebcc1dc"), new Object[]{ctx, companyID, periodID});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _closeAccount(ctx, companyID, periodID);
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
    protected void _closeAccount(Context ctx, String companyID, String periodID) throws BOSException, EASBizException
    {    	
        return;
    }

    public void unCloseAccount(Context ctx, String companyID, String periodID) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("70dedc1a-adc1-47ee-b52b-fc7b0e2e8ad9"), new Object[]{ctx, companyID, periodID});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _unCloseAccount(ctx, companyID, periodID);
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
    protected void _unCloseAccount(Context ctx, String companyID, String periodID) throws BOSException, EASBizException
    {    	
        return;
    }

}