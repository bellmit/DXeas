package com.kingdee.eas.custom.erp2tax.app;

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



public abstract class AbstractERP2TaxFacadeControllerBean extends AbstractBizControllerBean implements ERP2TaxFacadeController
{
    protected AbstractERP2TaxFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("9BA5303F");
    }

    public void execute(Context ctx, String sqlStr) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("1f7d089b-7d50-451a-9dc7-b4ffcd97ccf0"), new Object[]{ctx, sqlStr});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _execute(ctx, sqlStr);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract void _execute(Context ctx, String sqlStr) throws BOSException;

    public String exeExport2Tax(Context ctx, String jsonStr) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("dc1456c4-d30c-47b0-8750-75e439e49803"), new Object[]{ctx, jsonStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_exeExport2Tax(ctx, jsonStr);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (String)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract String _exeExport2Tax(Context ctx, String jsonStr) throws BOSException, EASBizException;

    public String exeSynResult(Context ctx, String jsonStr) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("34248cf2-fe6f-4dfd-8813-08a452fba780"), new Object[]{ctx, jsonStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_exeSynResult(ctx, jsonStr);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (String)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract String _exeSynResult(Context ctx, String jsonStr) throws BOSException, EASBizException;

    public String ExportWriteBack2Tax(Context ctx, String jsonStr) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3618473f-e869-4086-ac88-2a5c8b3760dc"), new Object[]{ctx, jsonStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_ExportWriteBack2Tax(ctx, jsonStr);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (String)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract String _ExportWriteBack2Tax(Context ctx, String jsonStr) throws BOSException, EASBizException;

}