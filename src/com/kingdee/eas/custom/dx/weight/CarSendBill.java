package com.kingdee.eas.custom.dx.weight;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.dx.weight.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CarSendBill extends WlhlBillBase implements ICarSendBill
{
    public CarSendBill()
    {
        super();
        registerInterface(ICarSendBill.class, this);
    }
    public CarSendBill(Context ctx)
    {
        super(ctx);
        registerInterface(ICarSendBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9BC90962");
    }
    private CarSendBillController getController() throws BOSException
    {
        return (CarSendBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CarSendBillCollection getCarSendBillCollection() throws BOSException
    {
        try {
            return getController().getCarSendBillCollection(getContext());
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
    public CarSendBillCollection getCarSendBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCarSendBillCollection(getContext(), view);
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
    public CarSendBillCollection getCarSendBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getCarSendBillCollection(getContext(), oql);
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
    public CarSendBillInfo getCarSendBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCarSendBillInfo(getContext(), pk);
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
    public CarSendBillInfo getCarSendBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCarSendBillInfo(getContext(), pk, selector);
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
    public CarSendBillInfo getCarSendBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCarSendBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}