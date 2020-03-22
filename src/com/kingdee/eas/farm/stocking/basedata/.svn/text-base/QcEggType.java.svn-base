package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.stocking.basedata.app.*;
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

public class QcEggType extends DataBase implements IQcEggType
{
    public QcEggType()
    {
        super();
        registerInterface(IQcEggType.class, this);
    }
    public QcEggType(Context ctx)
    {
        super(ctx);
        registerInterface(IQcEggType.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A84C223C");
    }
    private QcEggTypeController getController() throws BOSException
    {
        return (QcEggTypeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public QcEggTypeInfo getQcEggTypeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getQcEggTypeInfo(getContext(), pk);
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
    public QcEggTypeInfo getQcEggTypeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getQcEggTypeInfo(getContext(), pk, selector);
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
    public QcEggTypeInfo getQcEggTypeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getQcEggTypeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public QcEggTypeCollection getQcEggTypeCollection() throws BOSException
    {
        try {
            return getController().getQcEggTypeCollection(getContext());
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
    public QcEggTypeCollection getQcEggTypeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getQcEggTypeCollection(getContext(), view);
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
    public QcEggTypeCollection getQcEggTypeCollection(String oql) throws BOSException
    {
        try {
            return getController().getQcEggTypeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}