package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.breed.brood.app.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BroodCoopSet extends CoreBillBase implements IBroodCoopSet
{
    public BroodCoopSet()
    {
        super();
        registerInterface(IBroodCoopSet.class, this);
    }
    public BroodCoopSet(Context ctx)
    {
        super(ctx);
        registerInterface(IBroodCoopSet.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A16BE215");
    }
    private BroodCoopSetController getController() throws BOSException
    {
        return (BroodCoopSetController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BroodCoopSetCollection getBroodCoopSetCollection() throws BOSException
    {
        try {
            return getController().getBroodCoopSetCollection(getContext());
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
    public BroodCoopSetCollection getBroodCoopSetCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBroodCoopSetCollection(getContext(), view);
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
    public BroodCoopSetCollection getBroodCoopSetCollection(String oql) throws BOSException
    {
        try {
            return getController().getBroodCoopSetCollection(getContext(), oql);
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
    public BroodCoopSetInfo getBroodCoopSetInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBroodCoopSetInfo(getContext(), pk);
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
    public BroodCoopSetInfo getBroodCoopSetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBroodCoopSetInfo(getContext(), pk, selector);
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
    public BroodCoopSetInfo getBroodCoopSetInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBroodCoopSetInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}