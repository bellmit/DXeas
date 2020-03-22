package com.kingdee.eas.custom.salepayment;

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
import com.kingdee.eas.custom.salepayment.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AreaSet extends DataBase implements IAreaSet
{
    public AreaSet()
    {
        super();
        registerInterface(IAreaSet.class, this);
    }
    public AreaSet(Context ctx)
    {
        super(ctx);
        registerInterface(IAreaSet.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2C5E4321");
    }
    private AreaSetController getController() throws BOSException
    {
        return (AreaSetController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AreaSetInfo getAreaSetInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAreaSetInfo(getContext(), pk);
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
    public AreaSetInfo getAreaSetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAreaSetInfo(getContext(), pk, selector);
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
    public AreaSetInfo getAreaSetInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAreaSetInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AreaSetCollection getAreaSetCollection() throws BOSException
    {
        try {
            return getController().getAreaSetCollection(getContext());
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
    public AreaSetCollection getAreaSetCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAreaSetCollection(getContext(), view);
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
    public AreaSetCollection getAreaSetCollection(String oql) throws BOSException
    {
        try {
            return getController().getAreaSetCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}