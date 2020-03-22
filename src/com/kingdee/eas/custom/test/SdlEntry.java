package com.kingdee.eas.custom.test;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.test.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SdlEntry extends CoreBillEntryBase implements ISdlEntry
{
    public SdlEntry()
    {
        super();
        registerInterface(ISdlEntry.class, this);
    }
    public SdlEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ISdlEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("857FC528");
    }
    private SdlEntryController getController() throws BOSException
    {
        return (SdlEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SdlEntryInfo getSdlEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSdlEntryInfo(getContext(), pk);
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
    public SdlEntryInfo getSdlEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSdlEntryInfo(getContext(), pk, selector);
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
    public SdlEntryInfo getSdlEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSdlEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SdlEntryCollection getSdlEntryCollection() throws BOSException
    {
        try {
            return getController().getSdlEntryCollection(getContext());
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
    public SdlEntryCollection getSdlEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSdlEntryCollection(getContext(), view);
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
    public SdlEntryCollection getSdlEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getSdlEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}