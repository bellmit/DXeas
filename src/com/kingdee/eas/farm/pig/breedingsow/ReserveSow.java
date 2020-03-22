package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.eas.farm.pig.breedingsow.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ReserveSow extends CoreBillBase implements IReserveSow
{
    public ReserveSow()
    {
        super();
        registerInterface(IReserveSow.class, this);
    }
    public ReserveSow(Context ctx)
    {
        super(ctx);
        registerInterface(IReserveSow.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A438F020");
    }
    private ReserveSowController getController() throws BOSException
    {
        return (ReserveSowController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ReserveSowCollection getReserveSowCollection() throws BOSException
    {
        try {
            return getController().getReserveSowCollection(getContext());
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
    public ReserveSowCollection getReserveSowCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getReserveSowCollection(getContext(), view);
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
    public ReserveSowCollection getReserveSowCollection(String oql) throws BOSException
    {
        try {
            return getController().getReserveSowCollection(getContext(), oql);
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
    public ReserveSowInfo getReserveSowInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getReserveSowInfo(getContext(), pk);
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
    public ReserveSowInfo getReserveSowInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getReserveSowInfo(getContext(), pk, selector);
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
    public ReserveSowInfo getReserveSowInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getReserveSowInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}