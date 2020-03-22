package com.kingdee.eas.farm.breed;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.breed.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Henhouse extends CoreBillBase implements IHenhouse
{
    public Henhouse()
    {
        super();
        registerInterface(IHenhouse.class, this);
    }
    public Henhouse(Context ctx)
    {
        super(ctx);
        registerInterface(IHenhouse.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EFA27609");
    }
    private HenhouseController getController() throws BOSException
    {
        return (HenhouseController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public HenhouseCollection getHenhouseCollection() throws BOSException
    {
        try {
            return getController().getHenhouseCollection(getContext());
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
    public HenhouseCollection getHenhouseCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getHenhouseCollection(getContext(), view);
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
    public HenhouseCollection getHenhouseCollection(String oql) throws BOSException
    {
        try {
            return getController().getHenhouseCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public HenhouseInfo getHenhouseInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getHenhouseInfo(getContext(), pk);
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
    public HenhouseInfo getHenhouseInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getHenhouseInfo(getContext(), pk, selector);
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
    public HenhouseInfo getHenhouseInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getHenhouseInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}