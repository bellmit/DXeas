package com.kingdee.eas.farm.pig.breedingboar;

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
import com.kingdee.eas.farm.pig.breedingboar.app.*;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BoarDailyEntry extends CoreBillEntryBase implements IBoarDailyEntry
{
    public BoarDailyEntry()
    {
        super();
        registerInterface(IBoarDailyEntry.class, this);
    }
    public BoarDailyEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IBoarDailyEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("20C93673");
    }
    private BoarDailyEntryController getController() throws BOSException
    {
        return (BoarDailyEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BoarDailyEntryInfo getBoarDailyEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBoarDailyEntryInfo(getContext(), pk);
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
    public BoarDailyEntryInfo getBoarDailyEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBoarDailyEntryInfo(getContext(), pk, selector);
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
    public BoarDailyEntryInfo getBoarDailyEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBoarDailyEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BoarDailyEntryCollection getBoarDailyEntryCollection() throws BOSException
    {
        try {
            return getController().getBoarDailyEntryCollection(getContext());
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
    public BoarDailyEntryCollection getBoarDailyEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBoarDailyEntryCollection(getContext(), view);
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
    public BoarDailyEntryCollection getBoarDailyEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getBoarDailyEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}