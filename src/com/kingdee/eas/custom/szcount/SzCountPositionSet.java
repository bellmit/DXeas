package com.kingdee.eas.custom.szcount;

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
import com.kingdee.eas.custom.szcount.app.*;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SzCountPositionSet extends DataBase implements ISzCountPositionSet
{
    public SzCountPositionSet()
    {
        super();
        registerInterface(ISzCountPositionSet.class, this);
    }
    public SzCountPositionSet(Context ctx)
    {
        super(ctx);
        registerInterface(ISzCountPositionSet.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("382C2B1C");
    }
    private SzCountPositionSetController getController() throws BOSException
    {
        return (SzCountPositionSetController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SzCountPositionSetInfo getSzCountPositionSetInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSzCountPositionSetInfo(getContext(), pk);
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
    public SzCountPositionSetInfo getSzCountPositionSetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSzCountPositionSetInfo(getContext(), pk, selector);
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
    public SzCountPositionSetInfo getSzCountPositionSetInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSzCountPositionSetInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SzCountPositionSetCollection getSzCountPositionSetCollection() throws BOSException
    {
        try {
            return getController().getSzCountPositionSetCollection(getContext());
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
    public SzCountPositionSetCollection getSzCountPositionSetCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSzCountPositionSetCollection(getContext(), view);
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
    public SzCountPositionSetCollection getSzCountPositionSetCollection(String oql) throws BOSException
    {
        try {
            return getController().getSzCountPositionSetCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *excel导入-User defined method
     *@param model model
     */
    public void importforEx(SzCountPositionSetInfo model) throws BOSException
    {
        try {
            getController().importforEx(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}