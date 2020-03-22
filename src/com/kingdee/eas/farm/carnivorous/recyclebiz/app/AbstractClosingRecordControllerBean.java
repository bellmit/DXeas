package com.kingdee.eas.farm.carnivorous.recyclebiz.app;

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

import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ClosingRecordCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ClosingRecordInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;



public abstract class AbstractClosingRecordControllerBean extends AbstractEntityControllerBean implements ClosingRecordController
{
    protected AbstractClosingRecordControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("C9486FE9");
    }

    public boolean exists(Context ctx, IObjectPK pk) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7288ce1d-10dd-48b4-9174-21b8162a35ec"), new Object[]{ctx, pk});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_exists(ctx, pk);
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
    protected boolean _exists(Context ctx, IObjectPK pk) throws BOSException
    {
        return innerExists(ctx, pk);
    }

    public boolean exists(Context ctx, FilterInfo filter) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("03e139aa-bdb4-440b-9c6b-695be1d30e7d"), new Object[]{ctx, filter});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_exists(ctx, filter);
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
    protected boolean _exists(Context ctx, FilterInfo filter) throws BOSException
    {
        return innerExists(ctx, filter);
    }

    public boolean exists(Context ctx, String oql) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("20510c02-b21e-47a7-8186-fe966233b7b1"), new Object[]{ctx, oql});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_exists(ctx, oql);
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
    protected boolean _exists(Context ctx, String oql) throws BOSException
    {
        return innerExists(ctx, oql);
    }

    public ClosingRecordInfo getValue(Context ctx, IObjectPK pk) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("4d4e942c-bc98-4733-a1bc-bea687483ccc"), new Object[]{ctx, pk});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ClosingRecordInfo retValue = (ClosingRecordInfo)_getValue(ctx, pk);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (ClosingRecordInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectValue _getValue(Context ctx, IObjectPK pk) throws BOSException
    {
        return innerGetValue(ctx, pk);
    }

    public ClosingRecordInfo getValue(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("caf3c599-2110-4a13-8eec-99c98e7e4546"), new Object[]{ctx, pk, selector});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ClosingRecordInfo retValue = (ClosingRecordInfo)_getValue(ctx, pk, selector);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (ClosingRecordInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectValue _getValue(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException
    {
        return innerGetValue(ctx, pk, selector);
    }

    public ClosingRecordInfo getValue(Context ctx, String oql) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("86d7eb48-4491-4c88-b45e-749936ec8f0e"), new Object[]{ctx, oql});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ClosingRecordInfo retValue = (ClosingRecordInfo)_getValue(ctx, oql);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (ClosingRecordInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectValue _getValue(Context ctx, String oql) throws BOSException
    {
        return innerGetValue(ctx, oql);
    }

    public IObjectPK addnew(Context ctx, ClosingRecordInfo model) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("37af3582-e7bd-43cc-82ea-7d34e52d3e9e"), new Object[]{ctx, model});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            IObjectPK retValue = (IObjectPK)_addnew(ctx, model);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (IObjectPK)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            this.setRollbackOnly();
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectPK _addnew(Context ctx, IObjectValue model) throws BOSException
    {
        return innerAddnew(ctx, model);
    }

    public void addnew(Context ctx, IObjectPK pk, ClosingRecordInfo model) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("5342c5b7-9ec0-417d-866b-e197f8d1a3e1"), new Object[]{ctx, pk, model});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()){
            _addnew(ctx, pk, model);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            this.setRollbackOnly();
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _addnew(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException
    {
        innerAddnew(ctx, pk, model);
    }

    public void update(Context ctx, IObjectPK pk, ClosingRecordInfo model) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("cd02a4e1-01eb-4938-a631-4ed65e67ff40"), new Object[]{ctx, pk, model});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()){
            _update(ctx, pk, model);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            this.setRollbackOnly();
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _update(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException
    {
        innerUpdate(ctx, pk, model);
    }

    public void updatePartial(Context ctx, ClosingRecordInfo model, SelectorItemCollection selector) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("629a6f54-d6ee-4d89-a562-4ff49424c962"), new Object[]{ctx, model, selector});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()){
            _updatePartial(ctx, model, selector);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            this.setRollbackOnly();
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _updatePartial(Context ctx, IObjectValue model, SelectorItemCollection selector) throws BOSException
    {
        innerUpdatePartial(ctx, model, selector);
    }

    public void updateBigObject(Context ctx, IObjectPK pk, ClosingRecordInfo model) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("6cf05401-8b38-4606-90df-1ba9628510d2"), new Object[]{ctx, pk, model});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()){
            _updateBigObject(ctx, pk, model);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            this.setRollbackOnly();
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _updateBigObject(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException
    {
        innerUpdateBigObject(ctx, pk, model);
    }

    public void delete(Context ctx, IObjectPK pk) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("74df5c16-d993-41b7-9f72-0907284606a5"), new Object[]{ctx, pk});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()){
            _delete(ctx, pk);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            this.setRollbackOnly();
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _delete(Context ctx, IObjectPK pk) throws BOSException
    {
        innerDelete(ctx, pk);
    }

    public IObjectPK[] getPKList(Context ctx) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("fd268c1f-6ed6-41dc-9282-34a01e3a56ad"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            IObjectPK[] retValue = (IObjectPK[])_getPKList(ctx);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (IObjectPK[])svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectPK[] _getPKList(Context ctx) throws BOSException
    {
        return innerGetPKList(ctx);
    }

    public IObjectPK[] getPKList(Context ctx, String oql) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3542a5a9-f5e3-4d17-a27d-2d80b06f7bcb"), new Object[]{ctx, oql});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            IObjectPK[] retValue = (IObjectPK[])_getPKList(ctx, oql);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (IObjectPK[])svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectPK[] _getPKList(Context ctx, String oql) throws BOSException
    {
        return innerGetPKList(ctx, oql);
    }

    public IObjectPK[] getPKList(Context ctx, FilterInfo filter, SorterItemCollection sorter) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("8cf4a484-ad67-4e21-8618-aaaca81624d4"), new Object[]{ctx, filter, sorter});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            IObjectPK[] retValue = (IObjectPK[])_getPKList(ctx, filter, sorter);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (IObjectPK[])svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectPK[] _getPKList(Context ctx, FilterInfo filter, SorterItemCollection sorter) throws BOSException
    {
        return innerGetPKList(ctx, filter, sorter);
    }

    public ClosingRecordCollection getCollection(Context ctx) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("29bd9268-b1b8-4d89-b3dd-26cda46e7cb9"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ClosingRecordCollection retValue = (ClosingRecordCollection)_getCollection(ctx, svcCtx);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (ClosingRecordCollection)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectCollection _getCollection(Context ctx, IServiceContext svcCtx) throws BOSException
    {
        return innerGetCollection(ctx, svcCtx);
    }

    public ClosingRecordCollection getCollection(Context ctx, EntityViewInfo view) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("10a26ae1-e8eb-4616-a0be-0f41392880f2"), new Object[]{ctx, view});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ClosingRecordCollection retValue = (ClosingRecordCollection)_getCollection(ctx, svcCtx, view);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (ClosingRecordCollection)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectCollection _getCollection(Context ctx, IServiceContext svcCtx, EntityViewInfo view) throws BOSException
    {
        return innerGetCollection(ctx, svcCtx, view);
    }

    public ClosingRecordCollection getCollection(Context ctx, String oql) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("412e6553-10c0-479a-b957-84aad1198528"), new Object[]{ctx, oql});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ClosingRecordCollection retValue = (ClosingRecordCollection)_getCollection(ctx, svcCtx, oql);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (ClosingRecordCollection)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectCollection _getCollection(Context ctx, IServiceContext svcCtx, String oql) throws BOSException
    {
        return innerGetCollection(ctx, svcCtx, oql);
    }

    public IObjectPK[] delete(Context ctx, FilterInfo filter) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("89f160a0-43fe-419a-ad0b-edff631f94ae"), new Object[]{ctx, filter});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            IObjectPK[] retValue = (IObjectPK[])_delete(ctx, filter);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (IObjectPK[])svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            this.setRollbackOnly();
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectPK[] _delete(Context ctx, FilterInfo filter) throws BOSException
    {
        return innerDelete(ctx, filter);
    }

    public IObjectPK[] delete(Context ctx, String oql) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("f5f88c70-c34a-4fb8-8f7e-c14bfc5da5cf"), new Object[]{ctx, oql});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            IObjectPK[] retValue = (IObjectPK[])_delete(ctx, oql);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (IObjectPK[])svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            this.setRollbackOnly();
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectPK[] _delete(Context ctx, String oql) throws BOSException
    {
        return innerDelete(ctx, oql);
    }

    public void delete(Context ctx, IObjectPK[] arrayPK) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("f99164fc-4659-4d71-a156-1a87b0a1a1bc"), new Object[]{ctx, arrayPK});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()){
            _delete(ctx, arrayPK);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            this.setRollbackOnly();
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _delete(Context ctx, IObjectPK[] arrayPK) throws BOSException
    {
        innerDelete(ctx, arrayPK);
    }

}