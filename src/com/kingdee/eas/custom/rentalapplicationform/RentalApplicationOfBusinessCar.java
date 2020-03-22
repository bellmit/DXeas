package com.kingdee.eas.custom.rentalapplicationform;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.rentalapplicationform.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class RentalApplicationOfBusinessCar extends CoreBillBase implements IRentalApplicationOfBusinessCar
{
    public RentalApplicationOfBusinessCar()
    {
        super();
        registerInterface(IRentalApplicationOfBusinessCar.class, this);
    }
    public RentalApplicationOfBusinessCar(Context ctx)
    {
        super(ctx);
        registerInterface(IRentalApplicationOfBusinessCar.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F6743734");
    }
    private RentalApplicationOfBusinessCarController getController() throws BOSException
    {
        return (RentalApplicationOfBusinessCarController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public RentalApplicationOfBusinessCarCollection getRentalApplicationOfBusinessCarCollection() throws BOSException
    {
        try {
            return getController().getRentalApplicationOfBusinessCarCollection(getContext());
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
    public RentalApplicationOfBusinessCarCollection getRentalApplicationOfBusinessCarCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getRentalApplicationOfBusinessCarCollection(getContext(), view);
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
    public RentalApplicationOfBusinessCarCollection getRentalApplicationOfBusinessCarCollection(String oql) throws BOSException
    {
        try {
            return getController().getRentalApplicationOfBusinessCarCollection(getContext(), oql);
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
    public RentalApplicationOfBusinessCarInfo getRentalApplicationOfBusinessCarInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getRentalApplicationOfBusinessCarInfo(getContext(), pk);
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
    public RentalApplicationOfBusinessCarInfo getRentalApplicationOfBusinessCarInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getRentalApplicationOfBusinessCarInfo(getContext(), pk, selector);
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
    public RentalApplicationOfBusinessCarInfo getRentalApplicationOfBusinessCarInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getRentalApplicationOfBusinessCarInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(RentalApplicationOfBusinessCarInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param model model
     */
    public void unAudit(RentalApplicationOfBusinessCarInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}