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

public class QeggAndDuckSeedEarlyEntry extends CoreBillEntryBase implements IQeggAndDuckSeedEarlyEntry
{
    public QeggAndDuckSeedEarlyEntry()
    {
        super();
        registerInterface(IQeggAndDuckSeedEarlyEntry.class, this);
    }
    public QeggAndDuckSeedEarlyEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IQeggAndDuckSeedEarlyEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("16186E17");
    }
    private QeggAndDuckSeedEarlyEntryController getController() throws BOSException
    {
        return (QeggAndDuckSeedEarlyEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public QeggAndDuckSeedEarlyEntryInfo getQeggAndDuckSeedEarlyEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getQeggAndDuckSeedEarlyEntryInfo(getContext(), pk);
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
    public QeggAndDuckSeedEarlyEntryInfo getQeggAndDuckSeedEarlyEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getQeggAndDuckSeedEarlyEntryInfo(getContext(), pk, selector);
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
    public QeggAndDuckSeedEarlyEntryInfo getQeggAndDuckSeedEarlyEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getQeggAndDuckSeedEarlyEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public QeggAndDuckSeedEarlyEntryCollection getQeggAndDuckSeedEarlyEntryCollection() throws BOSException
    {
        try {
            return getController().getQeggAndDuckSeedEarlyEntryCollection(getContext());
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
    public QeggAndDuckSeedEarlyEntryCollection getQeggAndDuckSeedEarlyEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getQeggAndDuckSeedEarlyEntryCollection(getContext(), view);
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
    public QeggAndDuckSeedEarlyEntryCollection getQeggAndDuckSeedEarlyEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getQeggAndDuckSeedEarlyEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}