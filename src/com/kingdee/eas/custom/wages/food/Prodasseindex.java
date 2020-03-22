package com.kingdee.eas.custom.wages.food;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.custom.wages.food.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Prodasseindex extends DataBase implements IProdasseindex
{
    public Prodasseindex()
    {
        super();
        registerInterface(IProdasseindex.class, this);
    }
    public Prodasseindex(Context ctx)
    {
        super(ctx);
        registerInterface(IProdasseindex.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("015C8215");
    }
    private ProdasseindexController getController() throws BOSException
    {
        return (ProdasseindexController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ProdasseindexInfo getProdasseindexInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getProdasseindexInfo(getContext(), pk);
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
    public ProdasseindexInfo getProdasseindexInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getProdasseindexInfo(getContext(), pk, selector);
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
    public ProdasseindexInfo getProdasseindexInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getProdasseindexInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ProdasseindexCollection getProdasseindexCollection() throws BOSException
    {
        try {
            return getController().getProdasseindexCollection(getContext());
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
    public ProdasseindexCollection getProdasseindexCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getProdasseindexCollection(getContext(), view);
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
    public ProdasseindexCollection getProdasseindexCollection(String oql) throws BOSException
    {
        try {
            return getController().getProdasseindexCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}