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

import com.kingdee.eas.farm.food.DeliveryCarInfo;
import java.lang.String;



public abstract class AbstractDeliveryCarEditFacadeControllerBean extends AbstractBizControllerBean implements DeliveryCarEditFacadeController
{
    protected AbstractDeliveryCarEditFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("61ADB03A");
    }

    public DeliveryCarInfo getDeliveryCarDetails(Context ctx, String carNumber) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("854c1f9a-4539-4b48-912e-12b45bf79841"), new Object[]{ctx, carNumber});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            DeliveryCarInfo retValue = (DeliveryCarInfo)_getDeliveryCarDetails(ctx, carNumber);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (DeliveryCarInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected DeliveryCarInfo _getDeliveryCarDetails(Context ctx, String carNumber) throws BOSException
    {    	
        return null;
    }

    public void saveOrUpdateCarInfo(Context ctx, DeliveryCarInfo car) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("88ebf1e1-c861-4820-961e-d52664960f56"), new Object[]{ctx, car});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _saveOrUpdateCarInfo(ctx, car);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _saveOrUpdateCarInfo(Context ctx, DeliveryCarInfo car) throws BOSException
    {    	
        return;
    }

    public DeliveryCarInfo getDeliveryCarDetailsByPersonName(Context ctx, String personName) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("0fb7e103-3553-441b-abd9-62742fba18ab"), new Object[]{ctx, personName});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            DeliveryCarInfo retValue = (DeliveryCarInfo)_getDeliveryCarDetailsByPersonName(ctx, personName);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (DeliveryCarInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected DeliveryCarInfo _getDeliveryCarDetailsByPersonName(Context ctx, String personName) throws BOSException
    {    	
        return null;
    }

}