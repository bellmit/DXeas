package com.kingdee.eas.farm.stocking.basebizbill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.stocking.basebizbill.app.*;
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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FarmerApplyBillEntry extends CoreBillEntryBase implements IFarmerApplyBillEntry
{
    public FarmerApplyBillEntry()
    {
        super();
        registerInterface(IFarmerApplyBillEntry.class, this);
    }
    public FarmerApplyBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IFarmerApplyBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9564B781");
    }
    private FarmerApplyBillEntryController getController() throws BOSException
    {
        return (FarmerApplyBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FarmerApplyBillEntryInfo getFarmerApplyBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerApplyBillEntryInfo(getContext(), pk);
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
    public FarmerApplyBillEntryInfo getFarmerApplyBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerApplyBillEntryInfo(getContext(), pk, selector);
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
    public FarmerApplyBillEntryInfo getFarmerApplyBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerApplyBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FarmerApplyBillEntryCollection getFarmerApplyBillEntryCollection() throws BOSException
    {
        try {
            return getController().getFarmerApplyBillEntryCollection(getContext());
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
    public FarmerApplyBillEntryCollection getFarmerApplyBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFarmerApplyBillEntryCollection(getContext(), view);
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
    public FarmerApplyBillEntryCollection getFarmerApplyBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getFarmerApplyBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}