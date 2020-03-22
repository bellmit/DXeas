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

public class ExtractFrom extends DataBase implements IExtractFrom
{
    public ExtractFrom()
    {
        super();
        registerInterface(IExtractFrom.class, this);
    }
    public ExtractFrom(Context ctx)
    {
        super(ctx);
        registerInterface(IExtractFrom.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0EFD8EC3");
    }
    private ExtractFromController getController() throws BOSException
    {
        return (ExtractFromController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ExtractFromInfo getExtractFromInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getExtractFromInfo(getContext(), pk);
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
    public ExtractFromInfo getExtractFromInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getExtractFromInfo(getContext(), pk, selector);
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
    public ExtractFromInfo getExtractFromInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getExtractFromInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ExtractFromCollection getExtractFromCollection() throws BOSException
    {
        try {
            return getController().getExtractFromCollection(getContext());
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
    public ExtractFromCollection getExtractFromCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getExtractFromCollection(getContext(), view);
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
    public ExtractFromCollection getExtractFromCollection(String oql) throws BOSException
    {
        try {
            return getController().getExtractFromCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}