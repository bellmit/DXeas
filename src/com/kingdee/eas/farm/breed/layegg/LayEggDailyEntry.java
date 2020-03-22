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

public class LayEggDailyEntry extends CoreBillEntryBase implements ILayEggDailyEntry
{
    public LayEggDailyEntry()
    {
        super();
        registerInterface(ILayEggDailyEntry.class, this);
    }
    public LayEggDailyEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ILayEggDailyEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8EA4D707");
    }
    private LayEggDailyEntryController getController() throws BOSException
    {
        return (LayEggDailyEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public LayEggDailyEntryInfo getLayEggDailyEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLayEggDailyEntryInfo(getContext(), pk);
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
    public LayEggDailyEntryInfo getLayEggDailyEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLayEggDailyEntryInfo(getContext(), pk, selector);
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
    public LayEggDailyEntryInfo getLayEggDailyEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLayEggDailyEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public LayEggDailyEntryCollection getLayEggDailyEntryCollection() throws BOSException
    {
        try {
            return getController().getLayEggDailyEntryCollection(getContext());
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
    public LayEggDailyEntryCollection getLayEggDailyEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLayEggDailyEntryCollection(getContext(), view);
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
    public LayEggDailyEntryCollection getLayEggDailyEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getLayEggDailyEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}