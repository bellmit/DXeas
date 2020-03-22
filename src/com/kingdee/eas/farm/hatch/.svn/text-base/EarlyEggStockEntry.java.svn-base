package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.hatch.app.*;
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

public class EarlyEggStockEntry extends CoreBillEntryBase implements IEarlyEggStockEntry
{
    public EarlyEggStockEntry()
    {
        super();
        registerInterface(IEarlyEggStockEntry.class, this);
    }
    public EarlyEggStockEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IEarlyEggStockEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("AF7118CC");
    }
    private EarlyEggStockEntryController getController() throws BOSException
    {
        return (EarlyEggStockEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public EarlyEggStockEntryInfo getEarlyEggStockEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEarlyEggStockEntryInfo(getContext(), pk);
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
    public EarlyEggStockEntryInfo getEarlyEggStockEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEarlyEggStockEntryInfo(getContext(), pk, selector);
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
    public EarlyEggStockEntryInfo getEarlyEggStockEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEarlyEggStockEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public EarlyEggStockEntryCollection getEarlyEggStockEntryCollection() throws BOSException
    {
        try {
            return getController().getEarlyEggStockEntryCollection(getContext());
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
    public EarlyEggStockEntryCollection getEarlyEggStockEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEarlyEggStockEntryCollection(getContext(), view);
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
    public EarlyEggStockEntryCollection getEarlyEggStockEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getEarlyEggStockEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}