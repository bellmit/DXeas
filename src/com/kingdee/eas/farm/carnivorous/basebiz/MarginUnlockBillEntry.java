package com.kingdee.eas.farm.carnivorous.basebiz;

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
import com.kingdee.eas.farm.carnivorous.basebiz.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MarginUnlockBillEntry extends CoreBillEntryBase implements IMarginUnlockBillEntry
{
    public MarginUnlockBillEntry()
    {
        super();
        registerInterface(IMarginUnlockBillEntry.class, this);
    }
    public MarginUnlockBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IMarginUnlockBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FE69BA02");
    }
    private MarginUnlockBillEntryController getController() throws BOSException
    {
        return (MarginUnlockBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public MarginUnlockBillEntryInfo getMarginUnlockBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMarginUnlockBillEntryInfo(getContext(), pk);
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
    public MarginUnlockBillEntryInfo getMarginUnlockBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMarginUnlockBillEntryInfo(getContext(), pk, selector);
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
    public MarginUnlockBillEntryInfo getMarginUnlockBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMarginUnlockBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MarginUnlockBillEntryCollection getMarginUnlockBillEntryCollection() throws BOSException
    {
        try {
            return getController().getMarginUnlockBillEntryCollection(getContext());
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
    public MarginUnlockBillEntryCollection getMarginUnlockBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMarginUnlockBillEntryCollection(getContext(), view);
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
    public MarginUnlockBillEntryCollection getMarginUnlockBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getMarginUnlockBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}