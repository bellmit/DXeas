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

public class SzProdCountEntry extends CoreBillEntryBase implements ISzProdCountEntry
{
    public SzProdCountEntry()
    {
        super();
        registerInterface(ISzProdCountEntry.class, this);
    }
    public SzProdCountEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ISzProdCountEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("DD72510C");
    }
    private SzProdCountEntryController getController() throws BOSException
    {
        return (SzProdCountEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SzProdCountEntryInfo getSzProdCountEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSzProdCountEntryInfo(getContext(), pk);
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
    public SzProdCountEntryInfo getSzProdCountEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSzProdCountEntryInfo(getContext(), pk, selector);
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
    public SzProdCountEntryInfo getSzProdCountEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSzProdCountEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SzProdCountEntryCollection getSzProdCountEntryCollection() throws BOSException
    {
        try {
            return getController().getSzProdCountEntryCollection(getContext());
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
    public SzProdCountEntryCollection getSzProdCountEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSzProdCountEntryCollection(getContext(), view);
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
    public SzProdCountEntryCollection getSzProdCountEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getSzProdCountEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}