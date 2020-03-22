package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.carnivorous.basedata.app.*;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BasePriceAdjustPolicy extends DataBase implements IBasePriceAdjustPolicy
{
    public BasePriceAdjustPolicy()
    {
        super();
        registerInterface(IBasePriceAdjustPolicy.class, this);
    }
    public BasePriceAdjustPolicy(Context ctx)
    {
        super(ctx);
        registerInterface(IBasePriceAdjustPolicy.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5D3A3E57");
    }
    private BasePriceAdjustPolicyController getController() throws BOSException
    {
        return (BasePriceAdjustPolicyController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BasePriceAdjustPolicyInfo getBasePriceAdjustPolicyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBasePriceAdjustPolicyInfo(getContext(), pk);
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
    public BasePriceAdjustPolicyInfo getBasePriceAdjustPolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBasePriceAdjustPolicyInfo(getContext(), pk, selector);
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
    public BasePriceAdjustPolicyInfo getBasePriceAdjustPolicyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBasePriceAdjustPolicyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BasePriceAdjustPolicyCollection getBasePriceAdjustPolicyCollection() throws BOSException
    {
        try {
            return getController().getBasePriceAdjustPolicyCollection(getContext());
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
    public BasePriceAdjustPolicyCollection getBasePriceAdjustPolicyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBasePriceAdjustPolicyCollection(getContext(), view);
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
    public BasePriceAdjustPolicyCollection getBasePriceAdjustPolicyCollection(String oql) throws BOSException
    {
        try {
            return getController().getBasePriceAdjustPolicyCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *核准-User defined method
     *@param model model
     */
    public void audit(BasePriceAdjustPolicyInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反核准-User defined method
     *@param model model
     */
    public void unAudit(BasePriceAdjustPolicyInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}