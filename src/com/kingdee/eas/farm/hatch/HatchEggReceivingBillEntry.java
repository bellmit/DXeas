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

public class HatchEggReceivingBillEntry extends CoreBillEntryBase implements IHatchEggReceivingBillEntry
{
    public HatchEggReceivingBillEntry()
    {
        super();
        registerInterface(IHatchEggReceivingBillEntry.class, this);
    }
    public HatchEggReceivingBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IHatchEggReceivingBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E31BD2BE");
    }
    private HatchEggReceivingBillEntryController getController() throws BOSException
    {
        return (HatchEggReceivingBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public HatchEggReceivingBillEntryInfo getHatchEggReceivingBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchEggReceivingBillEntryInfo(getContext(), pk);
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
    public HatchEggReceivingBillEntryInfo getHatchEggReceivingBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchEggReceivingBillEntryInfo(getContext(), pk, selector);
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
    public HatchEggReceivingBillEntryInfo getHatchEggReceivingBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchEggReceivingBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public HatchEggReceivingBillEntryCollection getHatchEggReceivingBillEntryCollection() throws BOSException
    {
        try {
            return getController().getHatchEggReceivingBillEntryCollection(getContext());
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
    public HatchEggReceivingBillEntryCollection getHatchEggReceivingBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getHatchEggReceivingBillEntryCollection(getContext(), view);
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
    public HatchEggReceivingBillEntryCollection getHatchEggReceivingBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getHatchEggReceivingBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}