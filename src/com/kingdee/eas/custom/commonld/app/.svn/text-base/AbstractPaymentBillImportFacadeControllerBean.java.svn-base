package com.kingdee.eas.custom.commonld.app;

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

import com.kingdee.eas.common.EASBizException;
import java.util.HashMap;



public abstract class AbstractPaymentBillImportFacadeControllerBean extends AbstractBizControllerBean implements PaymentBillImportFacadeController
{
    protected AbstractPaymentBillImportFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("8D73E0AC");
    }

    public HashMap importPaymentBill(Context ctx, HashMap param) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("fc105a70-afb2-4974-be7e-e8e4e3598ca1"), new Object[]{ctx, param});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            HashMap retValue = (HashMap)_importPaymentBill(ctx, param);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (HashMap)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract HashMap _importPaymentBill(Context ctx, HashMap param) throws BOSException, EASBizException;

}