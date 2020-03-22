package com.kingdee.eas.farm.feemanager.basebizbill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.feemanager.basebizbill.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class TransportationrecordEntry extends CoreBillEntryBase implements ITransportationrecordEntry
{
    public TransportationrecordEntry()
    {
        super();
        registerInterface(ITransportationrecordEntry.class, this);
    }
    public TransportationrecordEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ITransportationrecordEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FFF843CF");
    }
    private TransportationrecordEntryController getController() throws BOSException
    {
        return (TransportationrecordEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public TransportationrecordEntryInfo getTransportationrecordEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTransportationrecordEntryInfo(getContext(), pk);
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
    public TransportationrecordEntryInfo getTransportationrecordEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTransportationrecordEntryInfo(getContext(), pk, selector);
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
    public TransportationrecordEntryInfo getTransportationrecordEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTransportationrecordEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public TransportationrecordEntryCollection getTransportationrecordEntryCollection() throws BOSException
    {
        try {
            return getController().getTransportationrecordEntryCollection(getContext());
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
    public TransportationrecordEntryCollection getTransportationrecordEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTransportationrecordEntryCollection(getContext(), view);
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
    public TransportationrecordEntryCollection getTransportationrecordEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getTransportationrecordEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}