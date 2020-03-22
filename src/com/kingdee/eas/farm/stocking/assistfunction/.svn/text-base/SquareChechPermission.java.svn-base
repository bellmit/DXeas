package com.kingdee.eas.farm.stocking.assistfunction;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.stocking.assistfunction.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SquareChechPermission extends DataBase implements ISquareChechPermission
{
    public SquareChechPermission()
    {
        super();
        registerInterface(ISquareChechPermission.class, this);
    }
    public SquareChechPermission(Context ctx)
    {
        super(ctx);
        registerInterface(ISquareChechPermission.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("506C83AC");
    }
    private SquareChechPermissionController getController() throws BOSException
    {
        return (SquareChechPermissionController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SquareChechPermissionInfo getSquareChechPermissionInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSquareChechPermissionInfo(getContext(), pk);
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
    public SquareChechPermissionInfo getSquareChechPermissionInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSquareChechPermissionInfo(getContext(), pk, selector);
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
    public SquareChechPermissionInfo getSquareChechPermissionInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSquareChechPermissionInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SquareChechPermissionCollection getSquareChechPermissionCollection() throws BOSException
    {
        try {
            return getController().getSquareChechPermissionCollection(getContext());
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
    public SquareChechPermissionCollection getSquareChechPermissionCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSquareChechPermissionCollection(getContext(), view);
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
    public SquareChechPermissionCollection getSquareChechPermissionCollection(String oql) throws BOSException
    {
        try {
            return getController().getSquareChechPermissionCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}