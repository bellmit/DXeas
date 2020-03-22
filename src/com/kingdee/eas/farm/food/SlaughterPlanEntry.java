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

public class SlaughterPlanEntry extends CoreBillEntryBase implements ISlaughterPlanEntry
{
    public SlaughterPlanEntry()
    {
        super();
        registerInterface(ISlaughterPlanEntry.class, this);
    }
    public SlaughterPlanEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ISlaughterPlanEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5940FAC0");
    }
    private SlaughterPlanEntryController getController() throws BOSException
    {
        return (SlaughterPlanEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SlaughterPlanEntryInfo getSlaughterPlanEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSlaughterPlanEntryInfo(getContext(), pk);
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
    public SlaughterPlanEntryInfo getSlaughterPlanEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSlaughterPlanEntryInfo(getContext(), pk, selector);
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
    public SlaughterPlanEntryInfo getSlaughterPlanEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSlaughterPlanEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SlaughterPlanEntryCollection getSlaughterPlanEntryCollection() throws BOSException
    {
        try {
            return getController().getSlaughterPlanEntryCollection(getContext());
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
    public SlaughterPlanEntryCollection getSlaughterPlanEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSlaughterPlanEntryCollection(getContext(), view);
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
    public SlaughterPlanEntryCollection getSlaughterPlanEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getSlaughterPlanEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}