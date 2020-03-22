package com.kingdee.eas.farm.breed.layegg;

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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.layegg.app.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class LifeFeeEntry extends CoreBillEntryBase implements ILifeFeeEntry
{
    public LifeFeeEntry()
    {
        super();
        registerInterface(ILifeFeeEntry.class, this);
    }
    public LifeFeeEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ILifeFeeEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E106F0B5");
    }
    private LifeFeeEntryController getController() throws BOSException
    {
        return (LifeFeeEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public LifeFeeEntryInfo getLifeFeeEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLifeFeeEntryInfo(getContext(), pk);
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
    public LifeFeeEntryInfo getLifeFeeEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLifeFeeEntryInfo(getContext(), pk, selector);
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
    public LifeFeeEntryInfo getLifeFeeEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLifeFeeEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public LifeFeeEntryCollection getLifeFeeEntryCollection() throws BOSException
    {
        try {
            return getController().getLifeFeeEntryCollection(getContext());
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
    public LifeFeeEntryCollection getLifeFeeEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLifeFeeEntryCollection(getContext(), view);
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
    public LifeFeeEntryCollection getLifeFeeEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getLifeFeeEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}