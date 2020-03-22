package com.kingdee.eas.custom.wages.food;

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
import com.kingdee.eas.custom.wages.food.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AdjustFoodmoneyEntry extends CoreBillEntryBase implements IAdjustFoodmoneyEntry
{
    public AdjustFoodmoneyEntry()
    {
        super();
        registerInterface(IAdjustFoodmoneyEntry.class, this);
    }
    public AdjustFoodmoneyEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IAdjustFoodmoneyEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C4467BE1");
    }
    private AdjustFoodmoneyEntryController getController() throws BOSException
    {
        return (AdjustFoodmoneyEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AdjustFoodmoneyEntryInfo getAdjustFoodmoneyEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAdjustFoodmoneyEntryInfo(getContext(), pk);
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
    public AdjustFoodmoneyEntryInfo getAdjustFoodmoneyEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAdjustFoodmoneyEntryInfo(getContext(), pk, selector);
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
    public AdjustFoodmoneyEntryInfo getAdjustFoodmoneyEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAdjustFoodmoneyEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AdjustFoodmoneyEntryCollection getAdjustFoodmoneyEntryCollection() throws BOSException
    {
        try {
            return getController().getAdjustFoodmoneyEntryCollection(getContext());
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
    public AdjustFoodmoneyEntryCollection getAdjustFoodmoneyEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAdjustFoodmoneyEntryCollection(getContext(), view);
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
    public AdjustFoodmoneyEntryCollection getAdjustFoodmoneyEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getAdjustFoodmoneyEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}