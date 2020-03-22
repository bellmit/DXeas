package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AdjustmoneyEntry extends CoreBillEntryBase implements IAdjustmoneyEntry
{
    public AdjustmoneyEntry()
    {
        super();
        registerInterface(IAdjustmoneyEntry.class, this);
    }
    public AdjustmoneyEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IAdjustmoneyEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B8180C69");
    }
    private AdjustmoneyEntryController getController() throws BOSException
    {
        return (AdjustmoneyEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AdjustmoneyEntryInfo getAdjustmoneyEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAdjustmoneyEntryInfo(getContext(), pk);
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
    public AdjustmoneyEntryInfo getAdjustmoneyEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAdjustmoneyEntryInfo(getContext(), pk, selector);
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
    public AdjustmoneyEntryInfo getAdjustmoneyEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAdjustmoneyEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AdjustmoneyEntryCollection getAdjustmoneyEntryCollection() throws BOSException
    {
        try {
            return getController().getAdjustmoneyEntryCollection(getContext());
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
    public AdjustmoneyEntryCollection getAdjustmoneyEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAdjustmoneyEntryCollection(getContext(), view);
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
    public AdjustmoneyEntryCollection getAdjustmoneyEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getAdjustmoneyEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}