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
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlDataBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WorkAgeAward extends WlhlDataBase implements IWorkAgeAward
{
    public WorkAgeAward()
    {
        super();
        registerInterface(IWorkAgeAward.class, this);
    }
    public WorkAgeAward(Context ctx)
    {
        super(ctx);
        registerInterface(IWorkAgeAward.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E64BF2D7");
    }
    private WorkAgeAwardController getController() throws BOSException
    {
        return (WorkAgeAwardController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WorkAgeAwardInfo getWorkAgeAwardInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkAgeAwardInfo(getContext(), pk);
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
    public WorkAgeAwardInfo getWorkAgeAwardInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkAgeAwardInfo(getContext(), pk, selector);
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
    public WorkAgeAwardInfo getWorkAgeAwardInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWorkAgeAwardInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WorkAgeAwardCollection getWorkAgeAwardCollection() throws BOSException
    {
        try {
            return getController().getWorkAgeAwardCollection(getContext());
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
    public WorkAgeAwardCollection getWorkAgeAwardCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWorkAgeAwardCollection(getContext(), view);
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
    public WorkAgeAwardCollection getWorkAgeAwardCollection(String oql) throws BOSException
    {
        try {
            return getController().getWorkAgeAwardCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}