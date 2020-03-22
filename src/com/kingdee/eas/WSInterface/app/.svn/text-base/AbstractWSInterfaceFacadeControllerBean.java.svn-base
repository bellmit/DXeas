package com.kingdee.eas.WSInterface.app;

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
import com.kingdee.eas.fi.gl.WSVoucherCollection;



public abstract class AbstractWSInterfaceFacadeControllerBean extends AbstractBizControllerBean implements WSInterfaceFacadeController
{
    protected AbstractWSInterfaceFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("3E2587C1");
    }

    public String getBaseData(Context ctx, String queryStr) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("a1ef492f-34ee-463b-a5a9-012115f7151a"), new Object[]{ctx, queryStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getBaseData(ctx, queryStr);
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
    protected String _getBaseData(Context ctx, String queryStr) throws BOSException
    {    	
        return null;
    }

    public String importVoucher(Context ctx, WSVoucherCollection col, int isVerify, int isCashflow) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("023a9771-0add-4fde-af5f-3f413d0bba7b"), new Object[]{ctx, col, new Integer(isVerify), new Integer(isCashflow)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_importVoucher(ctx, col, isVerify, isCashflow);
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
    protected String _importVoucher(Context ctx, WSVoucherCollection col, int isVerify, int isCashflow) throws BOSException
    {    	
        return null;
    }

    public String importBill(Context ctx, String BosType, String BillJSON, int BillStatus) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("46833ce1-a9f7-40dc-a38b-46c0c1ed379f"), new Object[]{ctx, BosType, BillJSON, new Integer(BillStatus)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_importBill(ctx, BosType, BillJSON, BillStatus);
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
    protected String _importBill(Context ctx, String BosType, String BillJSON, int BillStatus) throws BOSException
    {    	
        return null;
    }

    public String getVoucher(Context ctx, String orgNumber, String year, String period, int fromRow, int toRow) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("9e9142ef-ff42-4003-a0cc-4161c1d1e201"), new Object[]{ctx, orgNumber, year, period, new Integer(fromRow), new Integer(toRow)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getVoucher(ctx, orgNumber, year, period, fromRow, toRow);
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
    protected String _getVoucher(Context ctx, String orgNumber, String year, String period, int fromRow, int toRow) throws BOSException
    {    	
        return null;
    }

    public String findVoucher(Context ctx, String orgNumber, int year, int period) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("1ee2c7a2-bb8d-4300-b632-8ffcbbc15737"), new Object[]{ctx, orgNumber, new Integer(year), new Integer(period)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_findVoucher(ctx, orgNumber, year, period);
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
    protected String _findVoucher(Context ctx, String orgNumber, int year, int period) throws BOSException
    {    	
        return null;
    }

    public String ImpBaseData(Context ctx, String billType, String JSON, int billStatus) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("a6dddbf0-4d2f-452b-ad68-9a9f6ca18237"), new Object[]{ctx, billType, JSON, new Integer(billStatus)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_ImpBaseData(ctx, billType, JSON, billStatus);
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
    protected String _ImpBaseData(Context ctx, String billType, String JSON, int billStatus) throws BOSException
    {    	
        return null;
    }

    public String getBaseDataByOrgNum(Context ctx, String queryStr) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("0adfd129-b70a-4b42-b8a0-df59f34885d0"), new Object[]{ctx, queryStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getBaseDataByOrgNum(ctx, queryStr);
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
    protected String _getBaseDataByOrgNum(Context ctx, String queryStr) throws BOSException
    {    	
        return null;
    }

    public String getVoucher(Context ctx, String OrgUnitID, String year, String period, String numbers) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("18ba5067-0ace-49e8-a63d-d060e6a6739d"), new Object[]{ctx, OrgUnitID, year, period, numbers});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getVoucher(ctx, OrgUnitID, year, period, numbers);
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
    protected String _getVoucher(Context ctx, String OrgUnitID, String year, String period, String numbers) throws BOSException
    {    	
        return null;
    }

}