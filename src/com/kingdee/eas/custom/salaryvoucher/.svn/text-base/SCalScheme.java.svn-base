package com.kingdee.eas.custom.salaryvoucher;

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
import com.kingdee.eas.custom.salaryvoucher.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SCalScheme extends DataBase implements ISCalScheme
{
    public SCalScheme()
    {
        super();
        registerInterface(ISCalScheme.class, this);
    }
    public SCalScheme(Context ctx)
    {
        super(ctx);
        registerInterface(ISCalScheme.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("DDE6036F");
    }
    private SCalSchemeController getController() throws BOSException
    {
        return (SCalSchemeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SCalSchemeInfo getSCalSchemeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSCalSchemeInfo(getContext(), pk);
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
    public SCalSchemeInfo getSCalSchemeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSCalSchemeInfo(getContext(), pk, selector);
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
    public SCalSchemeInfo getSCalSchemeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSCalSchemeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SCalSchemeCollection getSCalSchemeCollection() throws BOSException
    {
        try {
            return getController().getSCalSchemeCollection(getContext());
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
    public SCalSchemeCollection getSCalSchemeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSCalSchemeCollection(getContext(), view);
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
    public SCalSchemeCollection getSCalSchemeCollection(String oql) throws BOSException
    {
        try {
            return getController().getSCalSchemeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取薪酬方案-User defined method
     *@param model model
     */
    public void getSCalScheme(SCalSchemeInfo model) throws BOSException
    {
        try {
            getController().getSCalScheme(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}