package com.kingdee.eas.custom.salaryvoucher.app;

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

import com.kingdee.eas.basedata.assistant.PeriodInfo;
import java.lang.String;
import com.kingdee.eas.custom.salaryvoucher.SalaryVoucherInfo;



public abstract class AbstractsalaryVoucherFacadeControllerBean extends AbstractBizControllerBean implements salaryVoucherFacadeController
{
    protected AbstractsalaryVoucherFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("8582D4AF");
    }

    public String[] createSalaryVoucher(Context ctx, PeriodInfo periodInfo, SalaryVoucherInfo salaryVoucher, String[] conInfo) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("e9b6b8b0-1fa5-4983-99e0-cb651685b943"), new Object[]{ctx, periodInfo, salaryVoucher, conInfo});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String[] retValue = (String[])_createSalaryVoucher(ctx, periodInfo, salaryVoucher, conInfo);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (String[])svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract String[] _createSalaryVoucher(Context ctx, IObjectValue periodInfo, IObjectValue salaryVoucher, String[] conInfo) throws BOSException;

    public String[] getSHRPerson(Context ctx, String EASNumber, String[] conInfo) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3ec887d5-1165-4bb9-b28d-f58fde8ded0d"), new Object[]{ctx, EASNumber, conInfo});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String[] retValue = (String[])_getSHRPerson(ctx, EASNumber, conInfo);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (String[])svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract String[] _getSHRPerson(Context ctx, String EASNumber, String[] conInfo) throws BOSException;

    public String getSHRAdmin(Context ctx, String sHRAdminCode, String[] conInfo) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3a6d50c7-3546-40ae-b9d6-4f3db9a6467b"), new Object[]{ctx, sHRAdminCode, conInfo});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getSHRAdmin(ctx, sHRAdminCode, conInfo);
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
    protected abstract String _getSHRAdmin(Context ctx, String sHRAdminCode, String[] conInfo) throws BOSException;

    public boolean getbooleanAdminOrgUnit(Context ctx, String personNum) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("c6a4031c-1e9d-464f-9ab1-a6435a1b0c2d"), new Object[]{ctx, personNum});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_getbooleanAdminOrgUnit(ctx, personNum);
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
    protected abstract boolean _getbooleanAdminOrgUnit(Context ctx, String personNum) throws BOSException;

    public void updateSCalScheme(Context ctx, String[] conInfo) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("74d0aede-f344-4c3e-bd3b-c0b201a099aa"), new Object[]{ctx, conInfo});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _updateSCalScheme(ctx, conInfo);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract void _updateSCalScheme(Context ctx, String[] conInfo) throws BOSException;

    public void updateCmpItem(Context ctx, String[] conInfo) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3cf6e7ea-cd16-4bc3-a264-399c4a26c27e"), new Object[]{ctx, conInfo});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _updateCmpItem(ctx, conInfo);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract void _updateCmpItem(Context ctx, String[] conInfo) throws BOSException;

    public boolean getConnection(Context ctx, String[] conInfo) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("2b5a38b0-e823-4fce-96ef-94b75ccdd679"), new Object[]{ctx, conInfo});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_getConnection(ctx, conInfo);
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
    protected abstract boolean _getConnection(Context ctx, String[] conInfo) throws BOSException;

}