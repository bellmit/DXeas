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

import java.util.ArrayList;
import java.lang.String;
import java.util.Date;
import com.kingdee.eas.common.EASBizException;



public abstract class AbstractCCQualityCheckBillFacadeControllerBean extends AbstractBizControllerBean implements CCQualityCheckBillFacadeController
{
    protected AbstractCCQualityCheckBillFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("871FF6B4");
    }

    public ArrayList getQualityCheckInfoByBizDate(Context ctx, Date bizDate, String stoOrgUnitID) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("4002cb79-e526-43ba-ae8a-747d28fd4e42"), new Object[]{ctx, bizDate, stoOrgUnitID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ArrayList retValue = (ArrayList)_getQualityCheckInfoByBizDate(ctx, bizDate, stoOrgUnitID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (ArrayList)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract ArrayList _getQualityCheckInfoByBizDate(Context ctx, Date bizDate, String stoOrgUnitID) throws BOSException, EASBizException;

}