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

public class BatchContractEntry extends CoreBillEntryBase implements IBatchContractEntry
{
    public BatchContractEntry()
    {
        super();
        registerInterface(IBatchContractEntry.class, this);
    }
    public BatchContractEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IBatchContractEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5B36558B");
    }
    private BatchContractEntryController getController() throws BOSException
    {
        return (BatchContractEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BatchContractEntryInfo getBatchContractEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBatchContractEntryInfo(getContext(), pk);
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
    public BatchContractEntryInfo getBatchContractEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBatchContractEntryInfo(getContext(), pk, selector);
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
    public BatchContractEntryInfo getBatchContractEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBatchContractEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BatchContractEntryCollection getBatchContractEntryCollection() throws BOSException
    {
        try {
            return getController().getBatchContractEntryCollection(getContext());
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
    public BatchContractEntryCollection getBatchContractEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBatchContractEntryCollection(getContext(), view);
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
    public BatchContractEntryCollection getBatchContractEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getBatchContractEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}