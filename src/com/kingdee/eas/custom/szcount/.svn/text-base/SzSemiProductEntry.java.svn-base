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
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.custom.szcount.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SzSemiProductEntry extends CoreBillEntryBase implements ISzSemiProductEntry
{
    public SzSemiProductEntry()
    {
        super();
        registerInterface(ISzSemiProductEntry.class, this);
    }
    public SzSemiProductEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ISzSemiProductEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("84568C83");
    }
    private SzSemiProductEntryController getController() throws BOSException
    {
        return (SzSemiProductEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SzSemiProductEntryInfo getSzSemiProductEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSzSemiProductEntryInfo(getContext(), pk);
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
    public SzSemiProductEntryInfo getSzSemiProductEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSzSemiProductEntryInfo(getContext(), pk, selector);
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
    public SzSemiProductEntryInfo getSzSemiProductEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSzSemiProductEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SzSemiProductEntryCollection getSzSemiProductEntryCollection() throws BOSException
    {
        try {
            return getController().getSzSemiProductEntryCollection(getContext());
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
    public SzSemiProductEntryCollection getSzSemiProductEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSzSemiProductEntryCollection(getContext(), view);
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
    public SzSemiProductEntryCollection getSzSemiProductEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getSzSemiProductEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}