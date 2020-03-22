package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.stocking.processbizill.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class TheEggTableEntry extends CoreBillEntryBase implements ITheEggTableEntry
{
    public TheEggTableEntry()
    {
        super();
        registerInterface(ITheEggTableEntry.class, this);
    }
    public TheEggTableEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ITheEggTableEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F0FE2F9D");
    }
    private TheEggTableEntryController getController() throws BOSException
    {
        return (TheEggTableEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public TheEggTableEntryInfo getTheEggTableEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTheEggTableEntryInfo(getContext(), pk);
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
    public TheEggTableEntryInfo getTheEggTableEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTheEggTableEntryInfo(getContext(), pk, selector);
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
    public TheEggTableEntryInfo getTheEggTableEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTheEggTableEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public TheEggTableEntryCollection getTheEggTableEntryCollection() throws BOSException
    {
        try {
            return getController().getTheEggTableEntryCollection(getContext());
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
    public TheEggTableEntryCollection getTheEggTableEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTheEggTableEntryCollection(getContext(), view);
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
    public TheEggTableEntryCollection getTheEggTableEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getTheEggTableEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}