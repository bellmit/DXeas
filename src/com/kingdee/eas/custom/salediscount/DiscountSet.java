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
     *���-User defined method
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
     *��ϸ���-User defined method
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
     *�����-User defined method
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
     *��ϸ�����-User defined method
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
     *���ᣨ���ã�-User defined method
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
     *�����ᣨ���ã�-User defined method
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
     *�۸���ϸ�Ƿ�Ψһ-User defined method
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
     *�۸���ϸ�Ƿ�Ψһ-User defined method
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
     *ȡֵ-System defined method
     *@param pk ȡֵ
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
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
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
     *ȡֵ-System defined method
     *@param oql ȡֵ
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
     *ȡ����-System defined method
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
     *ȡ����-System defined method
     *@param view ȡ����
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
     *ȡ����-System defined method
     *@param oql ȡ����
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
     *�ͻ�������ĳһ�ͻ���ġ��ͻ������в�νṹ�ģ����Կͻ��飬�ͻ�������չʾ������ĳһ�ͻ���id��ͻ�id��ȡ�������еĿͻ����ͻ���-User defined method
     *@param groupStandardId groupStandardId
     *@param parentId parentId
     *@param isCustomerGroup true:�ǿͻ��飻false:�ǿͻ�
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
     *��ȡ�����������-User defined method
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
     *�������õļ۸����߲���ɾ��-User defined method
     *@param pricePolicyId �۸�����id
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
     *�ͻ�������ĳһ�ͻ���ġ��ͻ������в�νṹ�ģ����Կͻ��飬�ͻ�������չʾ������ĳһ�ͻ���id��ͻ�id��ȡ�������еĿͻ����ͻ���-User defined method
     *@param params groupStandardId�������׼id��parentId���ϼ�id��isCustomerGroup��true:�ǿͻ��飻false:�ǿͻ�
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
     *��ȡ�����������-User defined method
     *@param params parentId���ϼ�ID��isMaterialGroup��true:�������飻false:������
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
     *������������ȡ��ؼ۸�-User defined method
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
     *�������ڵ㶯̬ȡ�۸����߷�¼ֵ-User defined method
     *@param priceCompDetail �۸������ϸ
     *@param priceCompositionInfo ���ڵ����
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
     *��ȡ�۸�������ز���-User defined method
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
     *������������ȡ��ؼ۸�������-User defined method
     *@param priceConditions �۸���������
     *@param pricePolicyIds �۸�����id����
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
     *������ӷ�¼-User defined method
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
     *���÷�¼-User defined method
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
     *���÷�¼-User defined method
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