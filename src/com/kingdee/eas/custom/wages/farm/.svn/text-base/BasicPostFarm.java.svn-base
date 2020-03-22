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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BasicPostFarm extends DataBase implements IBasicPostFarm
{
    public BasicPostFarm()
    {
        super();
        registerInterface(IBasicPostFarm.class, this);
    }
    public BasicPostFarm(Context ctx)
    {
        super(ctx);
        registerInterface(IBasicPostFarm.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0781235A");
    }
    private BasicPostFarmController getController() throws BOSException
    {
        return (BasicPostFarmController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BasicPostFarmInfo getBasicPostFarmInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBasicPostFarmInfo(getContext(), pk);
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
    public BasicPostFarmInfo getBasicPostFarmInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBasicPostFarmInfo(getContext(), pk, selector);
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
    public BasicPostFarmInfo getBasicPostFarmInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBasicPostFarmInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BasicPostFarmCollection getBasicPostFarmCollection() throws BOSException
    {
        try {
            return getController().getBasicPostFarmCollection(getContext());
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
    public BasicPostFarmCollection getBasicPostFarmCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBasicPostFarmCollection(getContext(), view);
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
    public BasicPostFarmCollection getBasicPostFarmCollection(String oql) throws BOSException
    {
        try {
            return getController().getBasicPostFarmCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}