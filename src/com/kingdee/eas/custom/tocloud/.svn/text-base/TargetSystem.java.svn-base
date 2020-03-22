package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.tocloud.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class TargetSystem extends DataBase implements ITargetSystem
{
    public TargetSystem()
    {
        super();
        registerInterface(ITargetSystem.class, this);
    }
    public TargetSystem(Context ctx)
    {
        super(ctx);
        registerInterface(ITargetSystem.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("940248B9");
    }
    private TargetSystemController getController() throws BOSException
    {
        return (TargetSystemController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public TargetSystemInfo getTargetSystemInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTargetSystemInfo(getContext(), pk);
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
    public TargetSystemInfo getTargetSystemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTargetSystemInfo(getContext(), pk, selector);
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
    public TargetSystemInfo getTargetSystemInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTargetSystemInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public TargetSystemCollection getTargetSystemCollection() throws BOSException
    {
        try {
            return getController().getTargetSystemCollection(getContext());
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
    public TargetSystemCollection getTargetSystemCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTargetSystemCollection(getContext(), view);
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
    public TargetSystemCollection getTargetSystemCollection(String oql) throws BOSException
    {
        try {
            return getController().getTargetSystemCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}