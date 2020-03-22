package com.kingdee.eas.custom.salediscount.app;

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
import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import java.util.Map;
import com.kingdee.eas.basedata.scm.common.PriceCompDetailEnum;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.basedata.scm.sd.sale.PriceCondition;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import java.util.HashMap;
import com.kingdee.eas.basedata.scm.sd.sale.PricePolicyException;
import com.kingdee.eas.custom.salediscount.DiscountSetEntryCollection;
import com.kingdee.eas.basedata.scm.sd.sale.PriceCompositionInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.custom.salediscount.DiscountSetCollection;
import com.kingdee.eas.custom.salediscount.DiscountSetInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;



public abstract class AbstractDiscountSetControllerBean extends CoreBillBaseControllerBean implements DiscountSetController
{
    protected AbstractDiscountSetControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("32599B86");
    }

    public void audit(Context ctx, IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("a691e76a-c81f-4e72-9f41-30a114a081b3"), new Object[]{ctx, pks});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _audit(ctx, pks);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } catch (PricePolicyException ex0) {
            throw ex0;
        } catch (EASBizException ex1) {
            throw ex1;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _audit(Context ctx, IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException
    {    	
        return;
    }

    public void auditForEntries(Context ctx, IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7548546d-3bd1-4329-a4f7-86b423f8639a"), new Object[]{ctx, pks});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _auditForEntries(ctx, pks);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } catch (PricePolicyException ex0) {
            throw ex0;
        } catch (EASBizException ex1) {
            throw ex1;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _auditForEntries(Context ctx, IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException
    {    	
        return;
    }

    public void unAudit(Context ctx, IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("468591fd-90c3-4d16-8c4e-017a60cd2079"), new Object[]{ctx, pks});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _unAudit(ctx, pks);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } catch (PricePolicyException ex0) {
            throw ex0;
        } catch (EASBizException ex1) {
            throw ex1;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _unAudit(Context ctx, IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException
    {    	
        return;
    }

    public void unAuditForEntries(Context ctx, IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("b21cd282-d41f-482f-84e5-c8e25129d876"), new Object[]{ctx, pks});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _unAuditForEntries(ctx, pks);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } catch (PricePolicyException ex0) {
            throw ex0;
        } catch (EASBizException ex1) {
            throw ex1;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _unAuditForEntries(Context ctx, IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException
    {    	
        return;
    }

    public void block(Context ctx, IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("bf6eed8a-9cb4-456d-9809-2aa7f747ef1b"), new Object[]{ctx, pks});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _block(ctx, pks);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } catch (PricePolicyException ex0) {
            throw ex0;
        } catch (EASBizException ex1) {
            throw ex1;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _block(Context ctx, IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException
    {    	
        return;
    }

    public void unBlock(Context ctx, IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("bcb8a83a-ee84-4275-be34-2298d4e4033f"), new Object[]{ctx, pks});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _unBlock(ctx, pks);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } catch (PricePolicyException ex0) {
            throw ex0;
        } catch (EASBizException ex1) {
            throw ex1;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _unBlock(Context ctx, IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException
    {    	
        return;
    }

    public boolean isUniquePriceDetialForPolicy(Context ctx, IObjectPK pk) throws BOSException, PricePolicyException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("a561a2f0-6c14-432b-8260-4ff7655ecfde"), new Object[]{ctx, pk});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_isUniquePriceDetialForPolicy(ctx, pk);
            svcCtx.setMethodReturnValue(new Boolean(retValue));
            }
            invokeServiceAfter(svcCtx);
            return ((Boolean)svcCtx.getMethodReturnValue()).booleanValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (PricePolicyException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected boolean _isUniquePriceDetialForPolicy(Context ctx, IObjectPK pk) throws BOSException, PricePolicyException
    {    	
        return false;
    }

    public boolean isUniquePriceDetial(Context ctx, IObjectPK pk) throws BOSException, PricePolicyException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("b9d5580f-b0b1-4c11-a045-d555381e71b6"), new Object[]{ctx, pk});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_isUniquePriceDetial(ctx, pk);
            svcCtx.setMethodReturnValue(new Boolean(retValue));
            }
            invokeServiceAfter(svcCtx);
            return ((Boolean)svcCtx.getMethodReturnValue()).booleanValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (PricePolicyException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected boolean _isUniquePriceDetial(Context ctx, IObjectPK pk) throws BOSException, PricePolicyException
    {    	
        return false;
    }

    public DiscountSetInfo getDiscountSetInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("822a75d0-9ded-404b-b0c3-a2c62bb03bf4"), new Object[]{ctx, pk});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            DiscountSetInfo retValue = (DiscountSetInfo)_getValue(ctx, pk);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (DiscountSetInfo)svcCtx.getMethodReturnValue();
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

    public DiscountSetInfo getDiscountSetInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("f4fcee51-e74f-4b38-a014-d49a3ace4e08"), new Object[]{ctx, pk, selector});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            DiscountSetInfo retValue = (DiscountSetInfo)_getValue(ctx, pk, selector);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (DiscountSetInfo)svcCtx.getMethodReturnValue();
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

    public DiscountSetInfo getDiscountSetInfo(Context ctx, String oql) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("eff426a8-3801-4b15-923f-f4da70a55b55"), new Object[]{ctx, oql});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            DiscountSetInfo retValue = (DiscountSetInfo)_getValue(ctx, oql);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (DiscountSetInfo)svcCtx.getMethodReturnValue();
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

    public DiscountSetCollection getDiscountSetCollection(Context ctx) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7d5af59a-fb17-4e13-a1e3-fb4dff9b0dd5"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            DiscountSetCollection retValue = (DiscountSetCollection)_getCollection(ctx, svcCtx);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (DiscountSetCollection)svcCtx.getMethodReturnValue();
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

    public DiscountSetCollection getDiscountSetCollection(Context ctx, EntityViewInfo view) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("aff73a80-277d-41d0-9f9a-8e6d2165f4cf"), new Object[]{ctx, view});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            DiscountSetCollection retValue = (DiscountSetCollection)_getCollection(ctx, svcCtx, view);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (DiscountSetCollection)svcCtx.getMethodReturnValue();
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

    public DiscountSetCollection getDiscountSetCollection(Context ctx, String oql) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7857a446-36cd-41bd-8aa6-d325ea31fa86"), new Object[]{ctx, oql});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            DiscountSetCollection retValue = (DiscountSetCollection)_getCollection(ctx, svcCtx, oql);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
        
          return (DiscountSetCollection)svcCtx.getMethodReturnValue();
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

    public ArrayList getCustomerCollection(Context ctx, String groupStandardId, String parentId, boolean isCustomerGroup) throws BOSException, PricePolicyException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("a2d5e07a-19cf-45ba-a545-4da0f7c0f528"), new Object[]{ctx, groupStandardId, parentId, new Boolean(isCustomerGroup)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ArrayList retValue = (ArrayList)_getCustomerCollection(ctx, groupStandardId, parentId, isCustomerGroup);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (ArrayList)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            this.setRollbackOnly();
            throw ex;
        } catch (PricePolicyException ex0) {
            this.setRollbackOnly();
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected ArrayList _getCustomerCollection(Context ctx, String groupStandardId, String parentId, boolean isCustomerGroup) throws BOSException, PricePolicyException
    {    	
        return null;
    }

    public ArrayList getMaterialCollection(Context ctx, String parentId, boolean isMaterialGroup) throws BOSException, PricePolicyException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("e7a42372-dabc-44bc-b63e-b07f486c40d0"), new Object[]{ctx, parentId, new Boolean(isMaterialGroup)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ArrayList retValue = (ArrayList)_getMaterialCollection(ctx, parentId, isMaterialGroup);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (ArrayList)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            this.setRollbackOnly();
            throw ex;
        } catch (PricePolicyException ex0) {
            this.setRollbackOnly();
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected ArrayList _getMaterialCollection(Context ctx, String parentId, boolean isMaterialGroup) throws BOSException, PricePolicyException
    {    	
        return null;
    }

    public boolean isCanDelete(Context ctx, String pricePolicyId) throws BOSException, PricePolicyException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("b86ba7ea-53e9-4467-851b-9a41db439446"), new Object[]{ctx, pricePolicyId});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_isCanDelete(ctx, pricePolicyId);
            svcCtx.setMethodReturnValue(new Boolean(retValue));
            }
            invokeServiceAfter(svcCtx);
            return ((Boolean)svcCtx.getMethodReturnValue()).booleanValue();
        } catch (BOSException ex) {
            this.setRollbackOnly();
            throw ex;
        } catch (PricePolicyException ex0) {
            this.setRollbackOnly();
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected boolean _isCanDelete(Context ctx, String pricePolicyId) throws BOSException, PricePolicyException
    {    	
        return false;
    }

    public ArrayList getCustomerCollection(Context ctx, HashMap params) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("01fc514c-608f-40cd-b3a3-3754dac6c36d"), new Object[]{ctx, params});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ArrayList retValue = (ArrayList)_getCustomerCollection(ctx, params);
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
    protected ArrayList _getCustomerCollection(Context ctx, HashMap params) throws BOSException, EASBizException
    {    	
        return null;
    }

    public ArrayList getMaterialCollection(Context ctx, HashMap params) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("03295fd0-b9ef-42df-a4a3-d4fa7f213e2f"), new Object[]{ctx, params});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ArrayList retValue = (ArrayList)_getMaterialCollection(ctx, params);
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
    protected ArrayList _getMaterialCollection(Context ctx, HashMap params) throws BOSException, EASBizException
    {    	
        return null;
    }

    public Map getPricePolicyWithCM(Context ctx, PriceCondition[] priceCondition, String pricepolicyid) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("f663d72a-d812-4ebe-b8be-eb0814793cc1"), new Object[]{ctx, priceCondition, pricepolicyid});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Map retValue = (Map)_getPricePolicyWithCM(ctx, priceCondition, pricepolicyid);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (Map)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected Map _getPricePolicyWithCM(Context ctx, PriceCondition[] priceCondition, String pricepolicyid) throws BOSException, EASBizException
    {    	
        return null;
    }

    public DiscountSetEntryCollection getPriceEntrys(Context ctx, PriceCompDetailEnum priceCompDetail, PriceCompositionInfo priceCompositionInfo, Map params) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d018635c-7084-48ef-97f9-ad5df337b5b7"), new Object[]{ctx, priceCompDetail, priceCompositionInfo, params});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            DiscountSetEntryCollection retValue = (DiscountSetEntryCollection)_getPriceEntrys(ctx, priceCompDetail, priceCompositionInfo, params);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (DiscountSetEntryCollection)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectCollection _getPriceEntrys(Context ctx, PriceCompDetailEnum priceCompDetail, PriceCompositionInfo priceCompositionInfo, Map params) throws BOSException, EASBizException
    {    	
        return null;
    }

    public Map getPriceParam(Context ctx, String saleorgid) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("8c23ea27-37af-46f2-9db4-467c10688432"), new Object[]{ctx, saleorgid});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Map retValue = (Map)_getPriceParam(ctx, saleorgid);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (Map)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected Map _getPriceParam(Context ctx, String saleorgid) throws BOSException, EASBizException
    {    	
        return null;
    }

    public Map batchGetPricePolicyWithCM(Context ctx, PriceCondition[] priceConditions, String[] pricePolicyIds) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("ae3e313d-32e2-48a7-ae1d-4be6bcad44cd"), new Object[]{ctx, priceConditions, pricePolicyIds});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Map retValue = (Map)_batchGetPricePolicyWithCM(ctx, priceConditions, pricePolicyIds);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (Map)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected Map _batchGetPricePolicyWithCM(Context ctx, PriceCondition[] priceConditions, String[] pricePolicyIds) throws BOSException, EASBizException
    {    	
        return null;
    }

    public void batchAddEntry(Context ctx, DiscountSetInfo model) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("5649ba9a-0197-41f1-9d1d-635960ca8508"), new Object[]{ctx, model});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _batchAddEntry(ctx, model);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _batchAddEntry(Context ctx, IObjectValue model) throws BOSException
    {    	
        return;
    }

    public void enableEntry(Context ctx, DiscountSetInfo model) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("c777a234-0a9d-4a05-9008-c6dac6434aaf"), new Object[]{ctx, model});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _enableEntry(ctx, model);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _enableEntry(Context ctx, IObjectValue model) throws BOSException
    {    	
        return;
    }

    public void forbiddenEntry(Context ctx, DiscountSetInfo model) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7d5cfc35-c63e-4323-a2b5-351fcfd74f87"), new Object[]{ctx, model});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _forbiddenEntry(ctx, model);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _forbiddenEntry(Context ctx, IObjectValue model) throws BOSException
    {    	
        return;
    }

    public CoreBillBaseCollection getCoreBillBaseCollection (Context ctx) throws BOSException
    {
    	return (CoreBillBaseCollection)(getDiscountSetCollection(ctx).cast(CoreBillBaseCollection.class));
    }
    public CoreBillBaseCollection getCoreBillBaseCollection (Context ctx, EntityViewInfo view) throws BOSException
    {
    	return (CoreBillBaseCollection)(getDiscountSetCollection(ctx, view).cast(CoreBillBaseCollection.class));
    }
    public CoreBillBaseCollection getCoreBillBaseCollection (Context ctx, String oql) throws BOSException
    {
    	return (CoreBillBaseCollection)(getDiscountSetCollection(ctx, oql).cast(CoreBillBaseCollection.class));
    }
    public ObjectBaseCollection getObjectBaseCollection (Context ctx) throws BOSException
    {
    	return (ObjectBaseCollection)(getDiscountSetCollection(ctx).cast(ObjectBaseCollection.class));
    }
    public ObjectBaseCollection getObjectBaseCollection (Context ctx, EntityViewInfo view) throws BOSException
    {
    	return (ObjectBaseCollection)(getDiscountSetCollection(ctx, view).cast(ObjectBaseCollection.class));
    }
    public ObjectBaseCollection getObjectBaseCollection (Context ctx, String oql) throws BOSException
    {
    	return (ObjectBaseCollection)(getDiscountSetCollection(ctx, oql).cast(ObjectBaseCollection.class));
    }
    public CoreBaseCollection getCoreBaseCollection (Context ctx) throws BOSException
    {
    	return (CoreBaseCollection)(getDiscountSetCollection(ctx).cast(CoreBaseCollection.class));
    }
    public CoreBaseCollection getCoreBaseCollection (Context ctx, EntityViewInfo view) throws BOSException
    {
    	return (CoreBaseCollection)(getDiscountSetCollection(ctx, view).cast(CoreBaseCollection.class));
    }
    public CoreBaseCollection getCoreBaseCollection (Context ctx, String oql) throws BOSException
    {
    	return (CoreBaseCollection)(getDiscountSetCollection(ctx, oql).cast(CoreBaseCollection.class));
    }
}