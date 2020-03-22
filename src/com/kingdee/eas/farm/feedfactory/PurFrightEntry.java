package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.feedfactory.app.*;
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

public class PurFrightEntry extends CoreBillEntryBase implements IPurFrightEntry
{
    public PurFrightEntry()
    {
        super();
        registerInterface(IPurFrightEntry.class, this);
    }
    public PurFrightEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IPurFrightEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CD1F35B1");
    }
    private PurFrightEntryController getController() throws BOSException
    {
        return (PurFrightEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PurFrightEntryInfo getPurFrightEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPurFrightEntryInfo(getContext(), pk);
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
    public PurFrightEntryInfo getPurFrightEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPurFrightEntryInfo(getContext(), pk, selector);
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
    public PurFrightEntryInfo getPurFrightEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPurFrightEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PurFrightEntryCollection getPurFrightEntryCollection() throws BOSException
    {
        try {
            return getController().getPurFrightEntryCollection(getContext());
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
    public PurFrightEntryCollection getPurFrightEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPurFrightEntryCollection(getContext(), view);
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
    public PurFrightEntryCollection getPurFrightEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getPurFrightEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}