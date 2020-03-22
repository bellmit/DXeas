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

public class TranferBoxBillEntry extends CoreBillEntryBase implements ITranferBoxBillEntry
{
    public TranferBoxBillEntry()
    {
        super();
        registerInterface(ITranferBoxBillEntry.class, this);
    }
    public TranferBoxBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ITranferBoxBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("63360EFA");
    }
    private TranferBoxBillEntryController getController() throws BOSException
    {
        return (TranferBoxBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public TranferBoxBillEntryInfo getTranferBoxBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTranferBoxBillEntryInfo(getContext(), pk);
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
    public TranferBoxBillEntryInfo getTranferBoxBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTranferBoxBillEntryInfo(getContext(), pk, selector);
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
    public TranferBoxBillEntryInfo getTranferBoxBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTranferBoxBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public TranferBoxBillEntryCollection getTranferBoxBillEntryCollection() throws BOSException
    {
        try {
            return getController().getTranferBoxBillEntryCollection(getContext());
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
    public TranferBoxBillEntryCollection getTranferBoxBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTranferBoxBillEntryCollection(getContext(), view);
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
    public TranferBoxBillEntryCollection getTranferBoxBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getTranferBoxBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}