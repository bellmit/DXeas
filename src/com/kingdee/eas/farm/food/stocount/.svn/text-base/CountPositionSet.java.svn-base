package com.kingdee.eas.farm.food.stocount;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.food.stocount.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CountPositionSet extends DataBase implements ICountPositionSet
{
    public CountPositionSet()
    {
        super();
        registerInterface(ICountPositionSet.class, this);
    }
    public CountPositionSet(Context ctx)
    {
        super(ctx);
        registerInterface(ICountPositionSet.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D338AAA7");
    }
    private CountPositionSetController getController() throws BOSException
    {
        return (CountPositionSetController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CountPositionSetInfo getCountPositionSetInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCountPositionSetInfo(getContext(), pk);
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
    public CountPositionSetInfo getCountPositionSetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCountPositionSetInfo(getContext(), pk, selector);
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
    public CountPositionSetInfo getCountPositionSetInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCountPositionSetInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CountPositionSetCollection getCountPositionSetCollection() throws BOSException
    {
        try {
            return getController().getCountPositionSetCollection(getContext());
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
    public CountPositionSetCollection getCountPositionSetCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCountPositionSetCollection(getContext(), view);
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
    public CountPositionSetCollection getCountPositionSetCollection(String oql) throws BOSException
    {
        try {
            return getController().getCountPositionSetCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}