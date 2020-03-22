package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.wages.farm.app.*;
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

public class FarmRatingEntry extends CoreBillEntryBase implements IFarmRatingEntry
{
    public FarmRatingEntry()
    {
        super();
        registerInterface(IFarmRatingEntry.class, this);
    }
    public FarmRatingEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IFarmRatingEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E9104955");
    }
    private FarmRatingEntryController getController() throws BOSException
    {
        return (FarmRatingEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FarmRatingEntryInfo getFarmRatingEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmRatingEntryInfo(getContext(), pk);
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
    public FarmRatingEntryInfo getFarmRatingEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmRatingEntryInfo(getContext(), pk, selector);
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
    public FarmRatingEntryInfo getFarmRatingEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmRatingEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FarmRatingEntryCollection getFarmRatingEntryCollection() throws BOSException
    {
        try {
            return getController().getFarmRatingEntryCollection(getContext());
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
    public FarmRatingEntryCollection getFarmRatingEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFarmRatingEntryCollection(getContext(), view);
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
    public FarmRatingEntryCollection getFarmRatingEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getFarmRatingEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}