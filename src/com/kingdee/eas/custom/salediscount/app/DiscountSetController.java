package com.kingdee.eas.custom.salediscount.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.util.ArrayList;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.basedata.scm.common.PriceCompDetailEnum;
import java.util.Map;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.basedata.scm.sd.sale.PriceCondition;
import java.lang.String;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.bos.Context;
import com.kingdee.eas.basedata.scm.sd.sale.PricePolicyException;
import com.kingdee.eas.custom.salediscount.DiscountSetEntryCollection;
import com.kingdee.eas.basedata.scm.sd.sale.PriceCompositionInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.custom.salediscount.DiscountSetCollection;
import com.kingdee.eas.custom.salediscount.DiscountSetInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DiscountSetController extends CoreBillBaseController
{
    public void audit(Context ctx, IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException, RemoteException;
    public void auditForEntries(Context ctx, IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException, RemoteException;
    public void unAudit(Context ctx, IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException, RemoteException;
    public void unAuditForEntries(Context ctx, IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException, RemoteException;
    public void block(Context ctx, IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException, RemoteException;
    public void unBlock(Context ctx, IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException, RemoteException;
    public boolean isUniquePriceDetialForPolicy(Context ctx, IObjectPK pk) throws BOSException, PricePolicyException, RemoteException;
    public boolean isUniquePriceDetial(Context ctx, IObjectPK pk) throws BOSException, PricePolicyException, RemoteException;
    public DiscountSetInfo getDiscountSetInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DiscountSetInfo getDiscountSetInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DiscountSetInfo getDiscountSetInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public DiscountSetCollection getDiscountSetCollection(Context ctx) throws BOSException, RemoteException;
    public DiscountSetCollection getDiscountSetCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DiscountSetCollection getDiscountSetCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public ArrayList getCustomerCollection(Context ctx, String groupStandardId, String parentId, boolean isCustomerGroup) throws BOSException, PricePolicyException, RemoteException;
    public ArrayList getMaterialCollection(Context ctx, String parentId, boolean isMaterialGroup) throws BOSException, PricePolicyException, RemoteException;
    public boolean isCanDelete(Context ctx, String pricePolicyId) throws BOSException, PricePolicyException, RemoteException;
    public ArrayList getCustomerCollection(Context ctx, HashMap params) throws BOSException, EASBizException, RemoteException;
    public ArrayList getMaterialCollection(Context ctx, HashMap params) throws BOSException, EASBizException, RemoteException;
    public Map getPricePolicyWithCM(Context ctx, PriceCondition[] priceCondition, String pricepolicyid) throws BOSException, EASBizException, RemoteException;
    public DiscountSetEntryCollection getPriceEntrys(Context ctx, PriceCompDetailEnum priceCompDetail, PriceCompositionInfo priceCompositionInfo, Map params) throws BOSException, EASBizException, RemoteException;
    public Map getPriceParam(Context ctx, String saleorgid) throws BOSException, EASBizException, RemoteException;
    public Map batchGetPricePolicyWithCM(Context ctx, PriceCondition[] priceConditions, String[] pricePolicyIds) throws BOSException, EASBizException, RemoteException;
    public void batchAddEntry(Context ctx, DiscountSetInfo model) throws BOSException, RemoteException;
    public void enableEntry(Context ctx, DiscountSetInfo model) throws BOSException, RemoteException;
    public void forbiddenEntry(Context ctx, DiscountSetInfo model) throws BOSException, RemoteException;
}