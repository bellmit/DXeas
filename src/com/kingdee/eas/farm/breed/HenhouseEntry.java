package com.kingdee.eas.farm.breed;

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
import com.kingdee.eas.farm.breed.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class HenhouseEntry extends CoreBillEntryBase implements IHenhouseEntry
{
    public HenhouseEntry()
    {
        super();
        registerInterface(IHenhouseEntry.class, this);
    }
    public HenhouseEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IHenhouseEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F4D2FFE9");
    }
    private HenhouseEntryController getController() throws BOSException
    {
        return (HenhouseEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public HenhouseEntryInfo getHenhouseEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getHenhouseEntryInfo(getContext(), pk);
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
    public HenhouseEntryInfo getHenhouseEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getHenhouseEntryInfo(getContext(), pk, selector);
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
    public HenhouseEntryInfo getHenhouseEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getHenhouseEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public HenhouseEntryCollection getHenhouseEntryCollection() throws BOSException
    {
        try {
            return getController().getHenhouseEntryCollection(getContext());
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
    public HenhouseEntryCollection getHenhouseEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getHenhouseEntryCollection(getContext(), view);
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
    public HenhouseEntryCollection getHenhouseEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getHenhouseEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}