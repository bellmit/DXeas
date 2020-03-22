package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FractionOtherBillEntry extends CoreBillEntryBase implements IFractionOtherBillEntry
{
    public FractionOtherBillEntry()
    {
        super();
        registerInterface(IFractionOtherBillEntry.class, this);
    }
    public FractionOtherBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IFractionOtherBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2B3DFC25");
    }
    private FractionOtherBillEntryController getController() throws BOSException
    {
        return (FractionOtherBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FractionOtherBillEntryInfo getFractionOtherBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFractionOtherBillEntryInfo(getContext(), pk);
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
    public FractionOtherBillEntryInfo getFractionOtherBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFractionOtherBillEntryInfo(getContext(), pk, selector);
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
    public FractionOtherBillEntryInfo getFractionOtherBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFractionOtherBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FractionOtherBillEntryCollection getFractionOtherBillEntryCollection() throws BOSException
    {
        try {
            return getController().getFractionOtherBillEntryCollection(getContext());
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
    public FractionOtherBillEntryCollection getFractionOtherBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFractionOtherBillEntryCollection(getContext(), view);
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
    public FractionOtherBillEntryCollection getFractionOtherBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getFractionOtherBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}