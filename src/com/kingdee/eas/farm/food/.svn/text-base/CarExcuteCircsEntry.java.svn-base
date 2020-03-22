package com.kingdee.eas.farm.food;

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
import com.kingdee.eas.farm.food.app.*;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CarExcuteCircsEntry extends CoreBillEntryBase implements ICarExcuteCircsEntry
{
    public CarExcuteCircsEntry()
    {
        super();
        registerInterface(ICarExcuteCircsEntry.class, this);
    }
    public CarExcuteCircsEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICarExcuteCircsEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BA2F48D6");
    }
    private CarExcuteCircsEntryController getController() throws BOSException
    {
        return (CarExcuteCircsEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CarExcuteCircsEntryInfo getCarExcuteCircsEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCarExcuteCircsEntryInfo(getContext(), pk);
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
    public CarExcuteCircsEntryInfo getCarExcuteCircsEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCarExcuteCircsEntryInfo(getContext(), pk, selector);
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
    public CarExcuteCircsEntryInfo getCarExcuteCircsEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCarExcuteCircsEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CarExcuteCircsEntryCollection getCarExcuteCircsEntryCollection() throws BOSException
    {
        try {
            return getController().getCarExcuteCircsEntryCollection(getContext());
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
    public CarExcuteCircsEntryCollection getCarExcuteCircsEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCarExcuteCircsEntryCollection(getContext(), view);
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
    public CarExcuteCircsEntryCollection getCarExcuteCircsEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCarExcuteCircsEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}