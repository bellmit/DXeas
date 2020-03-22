package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Welfarecategory extends DataBase implements IWelfarecategory
{
    public Welfarecategory()
    {
        super();
        registerInterface(IWelfarecategory.class, this);
    }
    public Welfarecategory(Context ctx)
    {
        super(ctx);
        registerInterface(IWelfarecategory.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CB994882");
    }
    private WelfarecategoryController getController() throws BOSException
    {
        return (WelfarecategoryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WelfarecategoryInfo getWelfarecategoryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWelfarecategoryInfo(getContext(), pk);
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
    public WelfarecategoryInfo getWelfarecategoryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWelfarecategoryInfo(getContext(), pk, selector);
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
    public WelfarecategoryInfo getWelfarecategoryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWelfarecategoryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WelfarecategoryCollection getWelfarecategoryCollection() throws BOSException
    {
        try {
            return getController().getWelfarecategoryCollection(getContext());
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
    public WelfarecategoryCollection getWelfarecategoryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWelfarecategoryCollection(getContext(), view);
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
    public WelfarecategoryCollection getWelfarecategoryCollection(String oql) throws BOSException
    {
        try {
            return getController().getWelfarecategoryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}