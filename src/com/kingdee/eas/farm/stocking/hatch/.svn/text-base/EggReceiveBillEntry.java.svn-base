package com.kingdee.eas.farm.stocking.hatch;

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
import com.kingdee.eas.farm.stocking.hatch.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class EggReceiveBillEntry extends CoreBillEntryBase implements IEggReceiveBillEntry
{
    public EggReceiveBillEntry()
    {
        super();
        registerInterface(IEggReceiveBillEntry.class, this);
    }
    public EggReceiveBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IEggReceiveBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E9378F03");
    }
    private EggReceiveBillEntryController getController() throws BOSException
    {
        return (EggReceiveBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public EggReceiveBillEntryInfo getEggReceiveBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEggReceiveBillEntryInfo(getContext(), pk);
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
    public EggReceiveBillEntryInfo getEggReceiveBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEggReceiveBillEntryInfo(getContext(), pk, selector);
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
    public EggReceiveBillEntryInfo getEggReceiveBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEggReceiveBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public EggReceiveBillEntryCollection getEggReceiveBillEntryCollection() throws BOSException
    {
        try {
            return getController().getEggReceiveBillEntryCollection(getContext());
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
    public EggReceiveBillEntryCollection getEggReceiveBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEggReceiveBillEntryCollection(getContext(), view);
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
    public EggReceiveBillEntryCollection getEggReceiveBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getEggReceiveBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}