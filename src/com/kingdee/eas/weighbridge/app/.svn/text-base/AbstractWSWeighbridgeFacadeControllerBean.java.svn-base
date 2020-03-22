package com.kingdee.eas.weighbridge.app;

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
import java.util.Date;



public abstract class AbstractWSWeighbridgeFacadeControllerBean extends AbstractBizControllerBean implements WSWeighbridgeFacadeController
{
    protected AbstractWSWeighbridgeFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("BB1525E8");
    }

    public String uploadBill(Context ctx, String billJSON) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("32a9d2e1-c353-4ba4-9712-1cfed6e6c1d9"), new Object[]{ctx, billJSON});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_uploadBill(ctx, billJSON);
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
    protected String _uploadBill(Context ctx, String billJSON) throws BOSException
    {    	
        return null;
    }

    public boolean isStorageOrgIsFirstIn(Context ctx, String ctrlUnitID, String stoOrgUnitID, Date bizDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("dcf70754-4a7a-4f2b-afd5-ee720a0d3def"), new Object[]{ctx, ctrlUnitID, stoOrgUnitID, bizDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_isStorageOrgIsFirstIn(ctx, ctrlUnitID, stoOrgUnitID, bizDate);
            svcCtx.setMethodReturnValue(new Boolean(retValue));
            }
            invokeServiceAfter(svcCtx);
            return ((Boolean)svcCtx.getMethodReturnValue()).booleanValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected boolean _isStorageOrgIsFirstIn(Context ctx, String ctrlUnitID, String stoOrgUnitID, Date bizDate) throws BOSException
    {    	
        return false;
    }

}