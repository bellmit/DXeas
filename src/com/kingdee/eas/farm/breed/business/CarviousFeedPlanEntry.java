package com.kingdee.eas.farm.breed.business;

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
import com.kingdee.eas.farm.breed.business.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CarviousFeedPlanEntry extends CoreBillEntryBase implements ICarviousFeedPlanEntry
{
    public CarviousFeedPlanEntry()
    {
        super();
        registerInterface(ICarviousFeedPlanEntry.class, this);
    }
    public CarviousFeedPlanEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICarviousFeedPlanEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2BE8F577");
    }
    private CarviousFeedPlanEntryController getController() throws BOSException
    {
        return (CarviousFeedPlanEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CarviousFeedPlanEntryInfo getCarviousFeedPlanEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCarviousFeedPlanEntryInfo(getContext(), pk);
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
    public CarviousFeedPlanEntryInfo getCarviousFeedPlanEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCarviousFeedPlanEntryInfo(getContext(), pk, selector);
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
    public CarviousFeedPlanEntryInfo getCarviousFeedPlanEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCarviousFeedPlanEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CarviousFeedPlanEntryCollection getCarviousFeedPlanEntryCollection() throws BOSException
    {
        try {
            return getController().getCarviousFeedPlanEntryCollection(getContext());
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
    public CarviousFeedPlanEntryCollection getCarviousFeedPlanEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCarviousFeedPlanEntryCollection(getContext(), view);
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
    public CarviousFeedPlanEntryCollection getCarviousFeedPlanEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCarviousFeedPlanEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}