package com.kingdee.eas.custom.znck.app;

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

import java.util.List;



public abstract class AbstractMaterialLedRelFacadeControllerBean extends AbstractBizControllerBean implements MaterialLedRelFacadeController
{
    protected AbstractMaterialLedRelFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("CCF96F76");
    }

    public List getMaterialRelLEDNumbers(Context ctx, List materials) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("97e68ff6-e027-4837-b152-dcd1652e3d10"), new Object[]{ctx, materials});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            List retValue = (List)_getMaterialRelLEDNumbers(ctx, materials);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (List)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected List _getMaterialRelLEDNumbers(Context ctx, List materials) throws BOSException
    {    	
        return null;
    }

}