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

public class EggHatchBillEntry extends CoreBillEntryBase implements IEggHatchBillEntry
{
    public EggHatchBillEntry()
    {
        super();
        registerInterface(IEggHatchBillEntry.class, this);
    }
    public EggHatchBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IEggHatchBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9DF59B62");
    }
    private EggHatchBillEntryController getController() throws BOSException
    {
        return (EggHatchBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public EggHatchBillEntryInfo getEggHatchBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEggHatchBillEntryInfo(getContext(), pk);
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
    public EggHatchBillEntryInfo getEggHatchBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEggHatchBillEntryInfo(getContext(), pk, selector);
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
    public EggHatchBillEntryInfo getEggHatchBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEggHatchBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public EggHatchBillEntryCollection getEggHatchBillEntryCollection() throws BOSException
    {
        try {
            return getController().getEggHatchBillEntryCollection(getContext());
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
    public EggHatchBillEntryCollection getEggHatchBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEggHatchBillEntryCollection(getContext(), view);
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
    public EggHatchBillEntryCollection getEggHatchBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getEggHatchBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}