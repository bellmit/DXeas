package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PostAllocation extends CoreBillBase implements IPostAllocation
{
    public PostAllocation()
    {
        super();
        registerInterface(IPostAllocation.class, this);
    }
    public PostAllocation(Context ctx)
    {
        super(ctx);
        registerInterface(IPostAllocation.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B5832BA8");
    }
    private PostAllocationController getController() throws BOSException
    {
        return (PostAllocationController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PostAllocationCollection getPostAllocationCollection() throws BOSException
    {
        try {
            return getController().getPostAllocationCollection(getContext());
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
    public PostAllocationCollection getPostAllocationCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPostAllocationCollection(getContext(), view);
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
    public PostAllocationCollection getPostAllocationCollection(String oql) throws BOSException
    {
        try {
            return getController().getPostAllocationCollection(getContext(), oql);
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
    public PostAllocationInfo getPostAllocationInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPostAllocationInfo(getContext(), pk);
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
    public PostAllocationInfo getPostAllocationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPostAllocationInfo(getContext(), pk, selector);
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
    public PostAllocationInfo getPostAllocationInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPostAllocationInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(PostAllocationInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param model model
     */
    public void unaudit(PostAllocationInfo model) throws BOSException
    {
        try {
            getController().unaudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}