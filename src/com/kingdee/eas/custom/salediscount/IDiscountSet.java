package com.kingdee.eas.custom.salediscount;

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
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.eas.basedata.scm.sd.sale.PricePolicyException;
import com.kingdee.eas.basedata.scm.sd.sale.PriceCompositionInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public interface IDiscountSet extends ICoreBillBase
{
    public void audit(IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException;
    public void auditForEntries(IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException;
    public void unAudit(IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException;
    public void unAuditForEntries(IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException;
    public void block(IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException;
    public void unBlock(IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException;
    public boolean isUniquePriceDetialForPolicy(IObjectPK pk) throws BOSException, PricePolicyException;
    public boolean isUniquePriceDetial(IObjectPK pk) throws BOSException, PricePolicyException;
    public DiscountSetInfo getDiscountSetInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DiscountSetInfo getDiscountSetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DiscountSetInfo getDiscountSetInfo(String oql) throws BOSException, EASBizException;
    public DiscountSetCollection getDiscountSetCollection() throws BOSException;
    public DiscountSetCollection getDiscountSetCollection(EntityViewInfo view) throws BOSException;
    public DiscountSetCollection getDiscountSetCollection(String oql) throws BOSException;
    public ArrayList getCustomerCollection(String groupStandardId, String parentId, boolean isCustomerGroup) throws BOSException, PricePolicyException;
    public ArrayList getMaterialCollection(String parentId, boolean isMaterialGroup) throws BOSException, PricePolicyException;
    public boolean isCanDelete(String pricePolicyId) throws BOSException, PricePolicyException;
    public ArrayList getCustomerCollection(HashMap params) throws BOSException, EASBizException;
    public ArrayList getMaterialCollection(HashMap params) throws BOSException, EASBizException;
    public Map getPricePolicyWithCM(PriceCondition[] priceCondition, String pricepolicyid) throws BOSException, EASBizException;
    public DiscountSetEntryCollection getPriceEntrys(PriceCompDetailEnum priceCompDetail, PriceCompositionInfo priceCompositionInfo, Map params) throws BOSException, EASBizException;
    public Map getPriceParam(String saleorgid) throws BOSException, EASBizException;
    public Map batchGetPricePolicyWithCM(PriceCondition[] priceConditions, String[] pricePolicyIds) throws BOSException, EASBizException;
    public void batchAddEntry(DiscountSetInfo model) throws BOSException;
    public void enableEntry(DiscountSetInfo model) throws BOSException;
    public void forbiddenEntry(DiscountSetInfo model) throws BOSException;
}