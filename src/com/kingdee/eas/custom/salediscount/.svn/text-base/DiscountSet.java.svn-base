package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import java.util.ArrayList;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.basedata.scm.common.PriceCompDetailEnum;
import java.util.Map;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import com.kingdee.eas.basedata.scm.sd.sale.PriceCondition;
import java.lang.String;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.eas.basedata.scm.sd.sale.PricePolicyException;
import com.kingdee.eas.custom.salediscount.app.*;
import com.kingdee.eas.basedata.scm.sd.sale.PriceCompositionInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DiscountSet extends CoreBillBase implements IDiscountSet
{
    public DiscountSet()
    {
        super();
        registerInterface(IDiscountSet.class, this);
    }
    public DiscountSet(Context ctx)
    {
        super(ctx);
        registerInterface(IDiscountSet.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("32599B86");
    }
    private DiscountSetController getController() throws BOSException
    {
        return (DiscountSetController)getBizController();
    }
    /**
     *审核-User defined method
     *@param pks pks
     */
    public void audit(IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException
    {
        try {
            getController().audit(getContext(), pks);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *明细审核-User defined method
     *@param pks pks
     */
    public void auditForEntries(IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException
    {
        try {
            getController().auditForEntries(getContext(), pks);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param pks pks
     */
    public void unAudit(IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException
    {
        try {
            getController().unAudit(getContext(), pks);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *明细反审核-User defined method
     *@param pks pks
     */
    public void unAuditForEntries(IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException
    {
        try {
            getController().unAuditForEntries(getContext(), pks);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *冻结（禁用）-User defined method
     *@param pks pks
     */
    public void block(IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException
    {
        try {
            getController().block(getContext(), pks);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反冻结（禁用）-User defined method
     *@param pks pks
     */
    public void unBlock(IObjectPK[] pks) throws BOSException, PricePolicyException, EASBizException
    {
        try {
            getController().unBlock(getContext(), pks);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *价格明细是否唯一-User defined method
     *@param pk pk
     *@return
     */
    public boolean isUniquePriceDetialForPolicy(IObjectPK pk) throws BOSException, PricePolicyException
    {
        try {
            return getController().isUniquePriceDetialForPolicy(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *价格明细是否唯一-User defined method
     *@param pk pk
     *@return
     */
    public boolean isUniquePriceDetial(IObjectPK pk) throws BOSException, PricePolicyException
    {
        try {
            return getController().isUniquePriceDetial(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DiscountSetInfo getDiscountSetInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountSetInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@param selector 取值
     *@return
     */
    public DiscountSetInfo getDiscountSetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountSetInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param oql 取值
     *@return
     */
    public DiscountSetInfo getDiscountSetInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountSetInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DiscountSetCollection getDiscountSetCollection() throws BOSException
    {
        try {
            return getController().getDiscountSetCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param view 取集合
     *@return
     */
    public DiscountSetCollection getDiscountSetCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDiscountSetCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param oql 取集合
     *@return
     */
    public DiscountSetCollection getDiscountSetCollection(String oql) throws BOSException
    {
        try {
            return getController().getDiscountSetCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *客户是属于某一客户组的。客户组是有层次结构的，所以客户组，客户可以树展示。根据某一客户组id或客户id获取下属所有的客户组或客户。-User defined method
     *@param groupStandardId groupStandardId
     *@param parentId parentId
     *@param isCustomerGroup true:是客户组；false:是客户
     *@return
     */
    public ArrayList getCustomerCollection(String groupStandardId, String parentId, boolean isCustomerGroup) throws BOSException, PricePolicyException
    {
        try {
            return getController().getCustomerCollection(getContext(), groupStandardId, parentId, isCustomerGroup);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取物料组或物料-User defined method
     *@param parentId parentId
     *@param isMaterialGroup isMaterialGroup
     *@return
     */
    public ArrayList getMaterialCollection(String parentId, boolean isMaterialGroup) throws BOSException, PricePolicyException
    {
        try {
            return getController().getMaterialCollection(getContext(), parentId, isMaterialGroup);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核与禁用的价格政策不能删除-User defined method
     *@param pricePolicyId 价格政策id
     *@return
     */
    public boolean isCanDelete(String pricePolicyId) throws BOSException, PricePolicyException
    {
        try {
            return getController().isCanDelete(getContext(), pricePolicyId);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *客户是属于某一客户组的。客户组是有层次结构的，所以客户组，客户可以树展示。根据某一客户组id或客户id获取下属所有的客户组或客户。-User defined method
     *@param params groupStandardId：分类标准id；parentId：上级id；isCustomerGroup：true:是客户组；false:是客户
     *@return
     */
    public ArrayList getCustomerCollection(HashMap params) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerCollection(getContext(), params);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取物料组或物料-User defined method
     *@param params parentId：上级ID；isMaterialGroup：true:是物料组；false:是物料
     *@return
     */
    public ArrayList getMaterialCollection(HashMap params) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialCollection(getContext(), params);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据条件批量取相关价格-User defined method
     *@param priceCondition priceCondition
     *@param pricepolicyid pricepolicyid
     *@return
     */
    public Map getPricePolicyWithCM(PriceCondition[] priceCondition, String pricepolicyid) throws BOSException, EASBizException
    {
        try {
            return getController().getPricePolicyWithCM(getContext(), priceCondition, pricepolicyid);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据树节点动态取价格政策分录值-User defined method
     *@param priceCompDetail 价格组合明细
     *@param priceCompositionInfo 树节点对象
     *@param params params
     *@return
     */
    public DiscountSetEntryCollection getPriceEntrys(PriceCompDetailEnum priceCompDetail, PriceCompositionInfo priceCompositionInfo, Map params) throws BOSException, EASBizException
    {
        try {
            return getController().getPriceEntrys(getContext(), priceCompDetail, priceCompositionInfo, params);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取价格政策相关参数-User defined method
     *@param saleorgid saleorgid
     *@return
     */
    public Map getPriceParam(String saleorgid) throws BOSException, EASBizException
    {
        try {
            return getController().getPriceParam(getContext(), saleorgid);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据条件批量取相关价格（批量）-User defined method
     *@param priceConditions 价格条件数组
     *@param pricePolicyIds 价格政策id数组
     *@return
     */
    public Map batchGetPricePolicyWithCM(PriceCondition[] priceConditions, String[] pricePolicyIds) throws BOSException, EASBizException
    {
        try {
            return getController().batchGetPricePolicyWithCM(getContext(), priceConditions, pricePolicyIds);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *批量添加分录-User defined method
     *@param model model
     */
    public void batchAddEntry(DiscountSetInfo model) throws BOSException
    {
        try {
            getController().batchAddEntry(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *启用分录-User defined method
     *@param model model
     */
    public void enableEntry(DiscountSetInfo model) throws BOSException
    {
        try {
            getController().enableEntry(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *禁用分录-User defined method
     *@param model model
     */
    public void forbiddenEntry(DiscountSetInfo model) throws BOSException
    {
        try {
            getController().forbiddenEntry(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}