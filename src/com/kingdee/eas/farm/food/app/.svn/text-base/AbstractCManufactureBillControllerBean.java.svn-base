package com.kingdee.eas.farm.food.app;

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

import com.kingdee.eas.farm.food.CManufactureBillInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.scm.im.inv.app.InvBillBaseControllerBean;
import java.lang.String;
import com.kingdee.eas.farm.food.CManufactureBillCollection;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.scm.common.SCMBillBaseCollection;
import com.kingdee.eas.scm.im.inv.InvBillBaseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;



public abstract class AbstractCManufactureBillControllerBean extends InvBillBaseControllerBean implements CManufactureBillController
{
    protected AbstractCManufactureBillControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("D66B122F");
    }

    public CManufactureBillInfo getCManufactureBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("20df5d8c-febd-4574-b907-2a143b51678a"), new Object[]{ctx, pk});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CManufactureBillInfo retValue = (CManufactureBillInfo)_getValue(ctx, pk);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (CManufactureBillInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectValue _getValue(Context ctx, IObjectPK pk) throws BOSException, EASBizException
    {
        return super._getValue(ctx, pk);
    }

    public CManufactureBillInfo getCManufactureBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("754d1985-f8be-4b27-946d-fde358e736cc"), new Object[]{ctx, pk, selector});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CManufactureBillInfo retValue = (CManufactureBillInfo)_getValue(ctx, pk, selector);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (CManufactureBillInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectValue _getValue(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        return super._getValue(ctx, pk, selector);
    }

    public CManufactureBillInfo getCManufactureBillInfo(Context ctx, String oql) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("20a3ea6b-a6d2-4b49-9fc8-51a027cf566c"), new Object[]{ctx, oql});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CManufactureBillInfo retValue = (CManufactureBillInfo)_getValue(ctx, oql);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (CManufactureBillInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectValue _getValue(Context ctx, String oql) throws BOSException, EASBizException
    {
        return super._getValue(ctx, oql);
    }

    public CManufactureBillCollection getCManufactureBillCollection(Context ctx) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("44aeb783-04df-475e-a929-88200f238bad"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CManufactureBillCollection retValue = (CManufactureBillCollection)_getCollection(ctx, svcCtx);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (CManufactureBillCollection)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectCollection _getCollection(Context ctx, IServiceContext svcCtx) throws BOSException
    {
        return super._getCollection(ctx, svcCtx);
    }

    public CManufactureBillCollection getCManufactureBillCollection(Context ctx, EntityViewInfo view) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("bece190c-b628-4a0f-a834-a284a5e30a24"), new Object[]{ctx, view});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CManufactureBillCollection retValue = (CManufactureBillCollection)_getCollection(ctx, svcCtx, view);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (CManufactureBillCollection)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectCollection _getCollection(Context ctx, IServiceContext svcCtx, EntityViewInfo view) throws BOSException
    {
        return super._getCollection(ctx, svcCtx, view);
    }

    public CManufactureBillCollection getCManufactureBillCollection(Context ctx, String oql) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("603b5a19-9321-4e5a-907a-d83b97198b72"), new Object[]{ctx, oql});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CManufactureBillCollection retValue = (CManufactureBillCollection)_getCollection(ctx, svcCtx, oql);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (CManufactureBillCollection)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectCollection _getCollection(Context ctx, IServiceContext svcCtx, String oql) throws BOSException
    {
        return super._getCollection(ctx, svcCtx, oql);
    }

    public CManufactureBillInfo getDefaultCostObject(Context ctx, String materialId, String companyId, String lot) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("bef32e5e-60b3-4e7c-8f56-248976b67e54"), new Object[]{ctx, materialId, companyId, lot});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CManufactureBillInfo retValue = (CManufactureBillInfo)_getDefaultCostObject(ctx, materialId, companyId, lot);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (CManufactureBillInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            this.setRollbackOnly();
            throw ex;
        } catch (EASBizException ex0) {
            this.setRollbackOnly();
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectValue _getDefaultCostObject(Context ctx, String materialId, String companyId, String lot) throws BOSException, EASBizException
    {    	
        return null;
    }

    public int associateManufactureRecBill(Context ctx, String fsourcebillid) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("067e2f3d-8053-4b79-af80-d4782012379a"), new Object[]{ctx, fsourcebillid});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            int retValue = (int)_associateManufactureRecBill(ctx, fsourcebillid);
            svcCtx.setMethodReturnValue(new Integer(retValue));
            }
            invokeServiceAfter(svcCtx);
            return ((Integer)svcCtx.getMethodReturnValue()).intValue();
        } catch (BOSException ex) {
            this.setRollbackOnly();
            throw ex;
        } catch (EASBizException ex0) {
            this.setRollbackOnly();
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected int _associateManufactureRecBill(Context ctx, String fsourcebillid) throws BOSException, EASBizException
    {    	
        return 0;
    }

    public InvBillBaseCollection getInvBillBaseCollection (Context ctx) throws BOSException
    {
    	return (InvBillBaseCollection)(getCManufactureBillCollection(ctx).cast(InvBillBaseCollection.class));
    }
    public InvBillBaseCollection getInvBillBaseCollection (Context ctx, EntityViewInfo view) throws BOSException
    {
    	return (InvBillBaseCollection)(getCManufactureBillCollection(ctx, view).cast(InvBillBaseCollection.class));
    }
    public InvBillBaseCollection getInvBillBaseCollection (Context ctx, String oql) throws BOSException
    {
    	return (InvBillBaseCollection)(getCManufactureBillCollection(ctx, oql).cast(InvBillBaseCollection.class));
    }
    public SCMBillBaseCollection getSCMBillBaseCollection (Context ctx) throws BOSException
    {
    	return (SCMBillBaseCollection)(getCManufactureBillCollection(ctx).cast(SCMBillBaseCollection.class));
    }
    public SCMBillBaseCollection getSCMBillBaseCollection (Context ctx, EntityViewInfo view) throws BOSException
    {
    	return (SCMBillBaseCollection)(getCManufactureBillCollection(ctx, view).cast(SCMBillBaseCollection.class));
    }
    public SCMBillBaseCollection getSCMBillBaseCollection (Context ctx, String oql) throws BOSException
    {
    	return (SCMBillBaseCollection)(getCManufactureBillCollection(ctx, oql).cast(SCMBillBaseCollection.class));
    }
    public CoreBillBaseCollection getCoreBillBaseCollection (Context ctx) throws BOSException
    {
    	return (CoreBillBaseCollection)(getCManufactureBillCollection(ctx).cast(CoreBillBaseCollection.class));
    }
    public CoreBillBaseCollection getCoreBillBaseCollection (Context ctx, EntityViewInfo view) throws BOSException
    {
    	return (CoreBillBaseCollection)(getCManufactureBillCollection(ctx, view).cast(CoreBillBaseCollection.class));
    }
    public CoreBillBaseCollection getCoreBillBaseCollection (Context ctx, String oql) throws BOSException
    {
    	return (CoreBillBaseCollection)(getCManufactureBillCollection(ctx, oql).cast(CoreBillBaseCollection.class));
    }
    public ObjectBaseCollection getObjectBaseCollection (Context ctx) throws BOSException
    {
    	return (ObjectBaseCollection)(getCManufactureBillCollection(ctx).cast(ObjectBaseCollection.class));
    }
    public ObjectBaseCollection getObjectBaseCollection (Context ctx, EntityViewInfo view) throws BOSException
    {
    	return (ObjectBaseCollection)(getCManufactureBillCollection(ctx, view).cast(ObjectBaseCollection.class));
    }
    public ObjectBaseCollection getObjectBaseCollection (Context ctx, String oql) throws BOSException
    {
    	return (ObjectBaseCollection)(getCManufactureBillCollection(ctx, oql).cast(ObjectBaseCollection.class));
    }
    public CoreBaseCollection getCoreBaseCollection (Context ctx) throws BOSException
    {
    	return (CoreBaseCollection)(getCManufactureBillCollection(ctx).cast(CoreBaseCollection.class));
    }
    public CoreBaseCollection getCoreBaseCollection (Context ctx, EntityViewInfo view) throws BOSException
    {
    	return (CoreBaseCollection)(getCManufactureBillCollection(ctx, view).cast(CoreBaseCollection.class));
    }
    public CoreBaseCollection getCoreBaseCollection (Context ctx, String oql) throws BOSException
    {
    	return (CoreBaseCollection)(getCManufactureBillCollection(ctx, oql).cast(CoreBaseCollection.class));
    }
}