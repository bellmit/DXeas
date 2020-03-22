package com.kingdee.eas.custom.app;

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

import com.kingdee.eas.base.permission.UserInfo;
import java.lang.String;
import java.util.Date;
import com.kingdee.eas.common.EASBizException;



public abstract class AbstractpayReqBillFacadeControllerBean extends AbstractBizControllerBean implements payReqBillFacadeController
{
    protected AbstractpayReqBillFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("E367431C");
    }

    public Date setPayReqBillCloseStatus(Context ctx, String payRequestBillID, boolean closeStatus, UserInfo closeUser, Date closeDate) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7a702a40-1d32-4c7a-9e1f-8c15a4dcb3ca"), new Object[]{ctx, payRequestBillID, new Boolean(closeStatus), closeUser, closeDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Date retValue = (Date)_setPayReqBillCloseStatus(ctx, payRequestBillID, closeStatus, closeUser, closeDate);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (Date)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract Date _setPayReqBillCloseStatus(Context ctx, String payRequestBillID, boolean closeStatus, IObjectValue closeUser, Date closeDate) throws BOSException, EASBizException;

}