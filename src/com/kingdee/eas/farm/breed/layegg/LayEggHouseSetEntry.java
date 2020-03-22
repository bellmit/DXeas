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

public class LayEggHouseSetEntry extends CoreBillEntryBase implements ILayEggHouseSetEntry
{
    public LayEggHouseSetEntry()
    {
        super();
        registerInterface(ILayEggHouseSetEntry.class, this);
    }
    public LayEggHouseSetEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ILayEggHouseSetEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A97AE882");
    }
    private LayEggHouseSetEntryController getController() throws BOSException
    {
        return (LayEggHouseSetEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public LayEggHouseSetEntryInfo getLayEggHouseSetEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLayEggHouseSetEntryInfo(getContext(), pk);
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
    public LayEggHouseSetEntryInfo getLayEggHouseSetEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLayEggHouseSetEntryInfo(getContext(), pk, selector);
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
    public LayEggHouseSetEntryInfo getLayEggHouseSetEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLayEggHouseSetEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public LayEggHouseSetEntryCollection getLayEggHouseSetEntryCollection() throws BOSException
    {
        try {
            return getController().getLayEggHouseSetEntryCollection(getContext());
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
    public LayEggHouseSetEntryCollection getLayEggHouseSetEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLayEggHouseSetEntryCollection(getContext(), view);
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
    public LayEggHouseSetEntryCollection getLayEggHouseSetEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getLayEggHouseSetEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}