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

public class HatchBabyBillEntry extends CoreBillEntryBase implements IHatchBabyBillEntry
{
    public HatchBabyBillEntry()
    {
        super();
        registerInterface(IHatchBabyBillEntry.class, this);
    }
    public HatchBabyBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IHatchBabyBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("71BDE6A3");
    }
    private HatchBabyBillEntryController getController() throws BOSException
    {
        return (HatchBabyBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public HatchBabyBillEntryInfo getHatchBabyBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchBabyBillEntryInfo(getContext(), pk);
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
    public HatchBabyBillEntryInfo getHatchBabyBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchBabyBillEntryInfo(getContext(), pk, selector);
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
    public HatchBabyBillEntryInfo getHatchBabyBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchBabyBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public HatchBabyBillEntryCollection getHatchBabyBillEntryCollection() throws BOSException
    {
        try {
            return getController().getHatchBabyBillEntryCollection(getContext());
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
    public HatchBabyBillEntryCollection getHatchBabyBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getHatchBabyBillEntryCollection(getContext(), view);
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
    public HatchBabyBillEntryCollection getHatchBabyBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getHatchBabyBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}