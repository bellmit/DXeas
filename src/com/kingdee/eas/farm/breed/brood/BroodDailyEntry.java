package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.breed.brood.app.*;
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
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BroodDailyEntry extends CoreBillEntryBase implements IBroodDailyEntry
{
    public BroodDailyEntry()
    {
        super();
        registerInterface(IBroodDailyEntry.class, this);
    }
    public BroodDailyEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IBroodDailyEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9E3A0D99");
    }
    private BroodDailyEntryController getController() throws BOSException
    {
        return (BroodDailyEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BroodDailyEntryInfo getBroodDailyEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBroodDailyEntryInfo(getContext(), pk);
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
    public BroodDailyEntryInfo getBroodDailyEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBroodDailyEntryInfo(getContext(), pk, selector);
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
    public BroodDailyEntryInfo getBroodDailyEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBroodDailyEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BroodDailyEntryCollection getBroodDailyEntryCollection() throws BOSException
    {
        try {
            return getController().getBroodDailyEntryCollection(getContext());
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
    public BroodDailyEntryCollection getBroodDailyEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBroodDailyEntryCollection(getContext(), view);
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
    public BroodDailyEntryCollection getBroodDailyEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getBroodDailyEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}