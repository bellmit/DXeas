package com.kingdee.eas.custom.settlebill.app;

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

import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import java.util.Map;
import java.lang.String;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;



public abstract class AbstractSettleBillFacdeControllerBean extends AbstractBizControllerBean implements SettleBillFacdeController
{
    protected AbstractSettleBillFacdeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("6D7814A6");
    }

    public String[] importData(Context ctx, String xml) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d75d366e-b230-4461-925a-f8b6dce350c2"), new Object[]{ctx, xml});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String[] retValue = (String[])_importData(ctx, xml);
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
    protected String[] _importData(Context ctx, String xml) throws BOSException
    {    	
        return null;
    }

    public Map getCostAmtOfMLY(Context ctx, CompanyOrgUnitInfo company, String lot, AdminOrgUnitInfo adminOrgUnitInfo) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("4e3bcc38-da18-4376-93dc-129d736c2dc7"), new Object[]{ctx, company, lot, adminOrgUnitInfo});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Map retValue = (Map)_getCostAmtOfMLY(ctx, company, lot, adminOrgUnitInfo);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (Map)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected Map _getCostAmtOfMLY(Context ctx, CompanyOrgUnitInfo company, String lot, AdminOrgUnitInfo adminOrgUnitInfo) throws BOSException
    {    	
        return null;
    }

    public boolean updateVoucherFlag(Context ctx, String sqlStr) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("df226db8-7eb9-4e6e-a9ca-e2d1c22d4e60"), new Object[]{ctx, sqlStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_updateVoucherFlag(ctx, sqlStr);
            svcCtx.setMethodReturnValue(new Boolean(retValue));
            }
            invokeServiceAfter(svcCtx);
            return ((Boolean)svcCtx.getMethodReturnValue()).booleanValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected boolean _updateVoucherFlag(Context ctx, String sqlStr) throws BOSException, EASBizException
    {    	
        return false;
    }

}