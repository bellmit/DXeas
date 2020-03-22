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

public class AchievementEntry extends CoreBillEntryBase implements IAchievementEntry
{
    public AchievementEntry()
    {
        super();
        registerInterface(IAchievementEntry.class, this);
    }
    public AchievementEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IAchievementEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("09F43F85");
    }
    private AchievementEntryController getController() throws BOSException
    {
        return (AchievementEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AchievementEntryInfo getAchievementEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAchievementEntryInfo(getContext(), pk);
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
    public AchievementEntryInfo getAchievementEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAchievementEntryInfo(getContext(), pk, selector);
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
    public AchievementEntryInfo getAchievementEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAchievementEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AchievementEntryCollection getAchievementEntryCollection() throws BOSException
    {
        try {
            return getController().getAchievementEntryCollection(getContext());
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
    public AchievementEntryCollection getAchievementEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAchievementEntryCollection(getContext(), view);
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
    public AchievementEntryCollection getAchievementEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getAchievementEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}