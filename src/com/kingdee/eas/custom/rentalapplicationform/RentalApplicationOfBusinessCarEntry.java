package com.kingdee.eas.custom.rentalapplicationform;

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
import com.kingdee.eas.custom.rentalapplicationform.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class RentalApplicationOfBusinessCarEntry extends CoreBillEntryBase implements IRentalApplicationOfBusinessCarEntry
{
    public RentalApplicationOfBusinessCarEntry()
    {
        super();
        registerInterface(IRentalApplicationOfBusinessCarEntry.class, this);
    }
    public RentalApplicationOfBusinessCarEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IRentalApplicationOfBusinessCarEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2952419E");
    }
    private RentalApplicationOfBusinessCarEntryController getController() throws BOSException
    {
        return (RentalApplicationOfBusinessCarEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public RentalApplicationOfBusinessCarEntryInfo getRentalApplicationOfBusinessCarEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getRentalApplicationOfBusinessCarEntryInfo(getContext(), pk);
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
    public RentalApplicationOfBusinessCarEntryInfo getRentalApplicationOfBusinessCarEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getRentalApplicationOfBusinessCarEntryInfo(getContext(), pk, selector);
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
    public RentalApplicationOfBusinessCarEntryInfo getRentalApplicationOfBusinessCarEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getRentalApplicationOfBusinessCarEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public RentalApplicationOfBusinessCarEntryCollection getRentalApplicationOfBusinessCarEntryCollection() throws BOSException
    {
        try {
            return getController().getRentalApplicationOfBusinessCarEntryCollection(getContext());
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
    public RentalApplicationOfBusinessCarEntryCollection getRentalApplicationOfBusinessCarEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getRentalApplicationOfBusinessCarEntryCollection(getContext(), view);
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
    public RentalApplicationOfBusinessCarEntryCollection getRentalApplicationOfBusinessCarEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getRentalApplicationOfBusinessCarEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}