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

public class AdjustFarmmoneyEntry extends CoreBillEntryBase implements IAdjustFarmmoneyEntry
{
    public AdjustFarmmoneyEntry()
    {
        super();
        registerInterface(IAdjustFarmmoneyEntry.class, this);
    }
    public AdjustFarmmoneyEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IAdjustFarmmoneyEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9D6410E1");
    }
    private AdjustFarmmoneyEntryController getController() throws BOSException
    {
        return (AdjustFarmmoneyEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AdjustFarmmoneyEntryInfo getAdjustFarmmoneyEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAdjustFarmmoneyEntryInfo(getContext(), pk);
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
    public AdjustFarmmoneyEntryInfo getAdjustFarmmoneyEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAdjustFarmmoneyEntryInfo(getContext(), pk, selector);
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
    public AdjustFarmmoneyEntryInfo getAdjustFarmmoneyEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAdjustFarmmoneyEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AdjustFarmmoneyEntryCollection getAdjustFarmmoneyEntryCollection() throws BOSException
    {
        try {
            return getController().getAdjustFarmmoneyEntryCollection(getContext());
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
    public AdjustFarmmoneyEntryCollection getAdjustFarmmoneyEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAdjustFarmmoneyEntryCollection(getContext(), view);
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
    public AdjustFarmmoneyEntryCollection getAdjustFarmmoneyEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getAdjustFarmmoneyEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}