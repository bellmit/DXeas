package com.kingdee.eas.farm.pig;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.pig.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PigBatchEntry extends CoreBillEntryBase implements IPigBatchEntry
{
    public PigBatchEntry()
    {
        super();
        registerInterface(IPigBatchEntry.class, this);
    }
    public PigBatchEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IPigBatchEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0F8A9746");
    }
    private PigBatchEntryController getController() throws BOSException
    {
        return (PigBatchEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PigBatchEntryInfo getPigBatchEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPigBatchEntryInfo(getContext(), pk);
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
    public PigBatchEntryInfo getPigBatchEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPigBatchEntryInfo(getContext(), pk, selector);
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
    public PigBatchEntryInfo getPigBatchEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPigBatchEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PigBatchEntryCollection getPigBatchEntryCollection() throws BOSException
    {
        try {
            return getController().getPigBatchEntryCollection(getContext());
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
    public PigBatchEntryCollection getPigBatchEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPigBatchEntryCollection(getContext(), view);
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
    public PigBatchEntryCollection getPigBatchEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getPigBatchEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}