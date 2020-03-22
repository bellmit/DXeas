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

public class HatchBillEntry extends CoreBillEntryBase implements IHatchBillEntry
{
    public HatchBillEntry()
    {
        super();
        registerInterface(IHatchBillEntry.class, this);
    }
    public HatchBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IHatchBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FF4101D9");
    }
    private HatchBillEntryController getController() throws BOSException
    {
        return (HatchBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public HatchBillEntryInfo getHatchBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchBillEntryInfo(getContext(), pk);
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
    public HatchBillEntryInfo getHatchBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchBillEntryInfo(getContext(), pk, selector);
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
    public HatchBillEntryInfo getHatchBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public HatchBillEntryCollection getHatchBillEntryCollection() throws BOSException
    {
        try {
            return getController().getHatchBillEntryCollection(getContext());
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
    public HatchBillEntryCollection getHatchBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getHatchBillEntryCollection(getContext(), view);
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
    public HatchBillEntryCollection getHatchBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getHatchBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}