package com.kingdee.eas.custom.applicationofsocialsecurity.app;

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
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionInfo;
import java.util.HashMap;
import com.kingdee.eas.common.EASBizException;



public abstract class AbstractsocialSecurityFacadeControllerBean extends AbstractBizControllerBean implements socialSecurityFacadeController
{
    protected AbstractsocialSecurityFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("D72C1686");
    }

    public HashMap getInfoOfPersonBaseOnNumberOrName(Context ctx, String personNum, String personName, DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("87fea3b6-76d4-438c-9874-e2c14d31679d"), new Object[]{ctx, personNum, personName, dataBaseConnectionIngfo});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            HashMap retValue = (HashMap)_getInfoOfPersonBaseOnNumberOrName(ctx, personNum, personName, dataBaseConnectionIngfo);
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
    protected abstract HashMap _getInfoOfPersonBaseOnNumberOrName(Context ctx, String personNum, String personName, IObjectValue dataBaseConnectionIngfo) throws BOSException, EASBizException;

    public ArrayList getSHRSIStatus(Context ctx, DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("26e832c9-24e0-4353-b0d2-dd0e3d9f9594"), new Object[]{ctx, dataBaseConnectionIngfo});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ArrayList retValue = (ArrayList)_getSHRSIStatus(ctx, dataBaseConnectionIngfo);
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
    protected abstract ArrayList _getSHRSIStatus(Context ctx, IObjectValue dataBaseConnectionIngfo) throws BOSException, EASBizException;

    public String getSIStatusIDBaseOnHisName(Context ctx, String SIStatusName, DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("1860be6f-c5e5-4ba9-8b56-2d060e343e01"), new Object[]{ctx, SIStatusName, dataBaseConnectionIngfo});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getSIStatusIDBaseOnHisName(ctx, SIStatusName, dataBaseConnectionIngfo);
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
    protected abstract String _getSIStatusIDBaseOnHisName(Context ctx, String SIStatusName, IObjectValue dataBaseConnectionIngfo) throws BOSException, EASBizException;

    public String updateSIStatusBaseOnPersonNumAndSIStatusID(Context ctx, String SIStatusID, String personNum, DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("ebe002c2-eb1d-4202-bd5d-17d68ea3443e"), new Object[]{ctx, SIStatusID, personNum, dataBaseConnectionIngfo});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_updateSIStatusBaseOnPersonNumAndSIStatusID(ctx, SIStatusID, personNum, dataBaseConnectionIngfo);
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
    protected abstract String _updateSIStatusBaseOnPersonNumAndSIStatusID(Context ctx, String SIStatusID, String personNum, IObjectValue dataBaseConnectionIngfo) throws BOSException, EASBizException;

    public ArrayList getCompanyNameFromSHR(Context ctx, DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("2e1fdaa1-0453-4d61-9d25-5a670acd55b7"), new Object[]{ctx, dataBaseConnectionIngfo});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ArrayList retValue = (ArrayList)_getCompanyNameFromSHR(ctx, dataBaseConnectionIngfo);
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
    protected abstract ArrayList _getCompanyNameFromSHR(Context ctx, IObjectValue dataBaseConnectionIngfo) throws BOSException, EASBizException;

    public ArrayList getPersonInfoByFilterItem(Context ctx, Date dateBegin, Date dateEnd, DataBaseConnectionInfo dataBaseConnectionInfo, boolean isIn, String company, String SIStatus, String personName, String personNum) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("ffa6bb8e-c7f5-46c0-829a-043392579fcd"), new Object[]{ctx, dateBegin, dateEnd, dataBaseConnectionInfo, new Boolean(isIn), company, SIStatus, personName, personNum});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ArrayList retValue = (ArrayList)_getPersonInfoByFilterItem(ctx, dateBegin, dateEnd, dataBaseConnectionInfo, isIn, company, SIStatus, personName, personNum);
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
    protected abstract ArrayList _getPersonInfoByFilterItem(Context ctx, Date dateBegin, Date dateEnd, IObjectValue dataBaseConnectionInfo, boolean isIn, String company, String SIStatus, String personName, String personNum) throws BOSException, EASBizException;

}