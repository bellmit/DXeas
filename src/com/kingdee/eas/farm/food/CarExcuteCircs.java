package com.kingdee.eas.farm.food;

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
import com.kingdee.eas.farm.food.app.*;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CarExcuteCircs extends CoreBillBase implements ICarExcuteCircs
{
    public CarExcuteCircs()
    {
        super();
        registerInterface(ICarExcuteCircs.class, this);
    }
    public CarExcuteCircs(Context ctx)
    {
        super(ctx);
        registerInterface(ICarExcuteCircs.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5A6D8CFC");
    }
    private CarExcuteCircsController getController() throws BOSException
    {
        return (CarExcuteCircsController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public CarExcuteCircsCollection getCarExcuteCircsCollection() throws BOSException
    {
        try {
            return getController().getCarExcuteCircsCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public CarExcuteCircsCollection getCarExcuteCircsCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCarExcuteCircsCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public CarExcuteCircsCollection getCarExcuteCircsCollection(String oql) throws BOSException
    {
        try {
            return getController().getCarExcuteCircsCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public CarExcuteCircsInfo getCarExcuteCircsInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCarExcuteCircsInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public CarExcuteCircsInfo getCarExcuteCircsInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCarExcuteCircsInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public CarExcuteCircsInfo getCarExcuteCircsInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCarExcuteCircsInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(CarExcuteCircsInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����-User defined method
     *@param model model
     */
    public void unAudit(CarExcuteCircsInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}