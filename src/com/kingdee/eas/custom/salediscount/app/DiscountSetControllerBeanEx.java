package com.kingdee.eas.custom.salediscount.app;

import org.apache.log4j.Logger;
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

import java.lang.String;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.salediscount.DiscountSetEntryCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.basedata.scm.common.PriceCompDetailEnum;
import java.util.Map;
import java.util.HashMap;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.basedata.scm.sd.sale.PriceCompositionInfo;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import java.util.ArrayList;
import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.basedata.scm.sd.sale.PricePolicyException;
import com.kingdee.eas.custom.salediscount.DiscountSetCollection;
import com.kingdee.eas.custom.salediscount.DiscountSetInfo;
import com.kingdee.eas.basedata.scm.sd.sale.PriceCondition;

public class DiscountSetControllerBeanEx extends com.kingdee.eas.custom.salediscount.app.DiscountSetControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.salediscount.app.DiscountSetControllerBeanEx");
    protected void _audit(Context ctx, IObjectPK[] pks)throws BOSException, PricePolicyException, EASBizException
    {
	     super._audit(ctx, pks);
    }
    protected void _auditForEntries(Context ctx, IObjectPK[] pks)throws BOSException, PricePolicyException, EASBizException
    {
	     super._auditForEntries(ctx, pks);
    }
    protected void _unAudit(Context ctx, IObjectPK[] pks)throws BOSException, PricePolicyException, EASBizException
    {
	     super._unAudit(ctx, pks);
    }
    protected void _unAuditForEntries(Context ctx, IObjectPK[] pks)throws BOSException, PricePolicyException, EASBizException
    {
	     super._unAuditForEntries(ctx, pks);
    }
    protected void _block(Context ctx, IObjectPK[] pks)throws BOSException, PricePolicyException, EASBizException
    {
	     super._block(ctx, pks);
    }
    protected void _unBlock(Context ctx, IObjectPK[] pks)throws BOSException, PricePolicyException, EASBizException
    {
	     super._unBlock(ctx, pks);
    }
   
    protected ArrayList _getCustomerCollection(Context ctx, HashMap params)throws BOSException, EASBizException
    {
	    return  super._getCustomerCollection(ctx, params);
    }
    protected ArrayList _getMaterialCollection(Context ctx, HashMap params)throws BOSException, EASBizException
    {
	    return  super._getMaterialCollection(ctx, params);
    }
    protected Map _getPricePolicyWithCM(Context ctx, PriceCondition[] priceCondition, String pricepolicyid)throws BOSException, EASBizException
    {
	    return  super._getPricePolicyWithCM(ctx, priceCondition, pricepolicyid);
    }
    protected IObjectCollection _getPriceEntrys(Context ctx, PriceCompDetailEnum priceCompDetail, PriceCompositionInfo priceCompositionInfo, Map params)throws BOSException, EASBizException
    {
	    return  super._getPriceEntrys(ctx, priceCompDetail, priceCompositionInfo, params);
    }
    protected Map _getPriceParam(Context ctx, String saleorgid)throws BOSException, EASBizException
    {
	    return  super._getPriceParam(ctx, saleorgid);
    }
    protected Map _batchGetPricePolicyWithCM(Context ctx, PriceCondition[] priceConditions, String[] pricePolicyIds)throws BOSException, EASBizException
    {
	    return  super._batchGetPricePolicyWithCM(ctx, priceConditions, pricePolicyIds);
    }
    protected void _batchAddEntry(Context ctx, IObjectValue model)throws BOSException
    {
	     super._batchAddEntry(ctx, model);
    }
}				
