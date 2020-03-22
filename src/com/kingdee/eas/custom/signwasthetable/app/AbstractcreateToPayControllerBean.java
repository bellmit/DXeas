package com.kingdee.eas.custom.signwasthetable.app;

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
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.eas.custom.signwasthetable.ContractInfo;
import com.kingdee.eas.fi.ap.PayRequestBillInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo;



public abstract class AbstractcreateToPayControllerBean extends AbstractBizControllerBean implements createToPayController
{
    protected AbstractcreateToPayControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("C686B367");
    }

    public PayRequestBillInfo createPayReq(Context ctx, ContractInfo model) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("cc55d2d4-e056-4e8a-9f30-14be8dea6d7d"), new Object[]{ctx, model});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            PayRequestBillInfo retValue = (PayRequestBillInfo)_createPayReq(ctx, model);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (PayRequestBillInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract IObjectValue _createPayReq(Context ctx, IObjectValue model) throws BOSException;

    public PayRequestBillInfo toPayReqFromSignTable(Context ctx, SignWasTheTableInfo model, ArrayList entryList, BOTMappingInfo botMappingInfo) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("598e5205-4487-4789-9937-23fb92baea43"), new Object[]{ctx, model, entryList, botMappingInfo});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            PayRequestBillInfo retValue = (PayRequestBillInfo)_toPayReqFromSignTable(ctx, model, entryList, botMappingInfo);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (PayRequestBillInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract IObjectValue _toPayReqFromSignTable(Context ctx, IObjectValue model, ArrayList entryList, BOTMappingInfo botMappingInfo) throws BOSException, EASBizException;

    public BOTMappingCollection getCanUsedBotMapping(Context ctx, SignWasTheTableInfo model) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("a2370822-df07-49f5-a1e6-ad91693f0a4a"), new Object[]{ctx, model});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            BOTMappingCollection retValue = (BOTMappingCollection)_getCanUsedBotMapping(ctx, model);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (BOTMappingCollection)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract BOTMappingCollection _getCanUsedBotMapping(Context ctx, IObjectValue model) throws BOSException, EASBizException;

}