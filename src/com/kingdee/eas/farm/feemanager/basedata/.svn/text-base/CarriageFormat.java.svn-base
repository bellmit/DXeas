package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.feemanager.basedata.app.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
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

public class CarriageFormat extends DataBase implements ICarriageFormat
{
    public CarriageFormat()
    {
        super();
        registerInterface(ICarriageFormat.class, this);
    }
    public CarriageFormat(Context ctx)
    {
        super(ctx);
        registerInterface(ICarriageFormat.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("78A06FD7");
    }
    private CarriageFormatController getController() throws BOSException
    {
        return (CarriageFormatController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CarriageFormatInfo getCarriageFormatInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCarriageFormatInfo(getContext(), pk);
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
    public CarriageFormatInfo getCarriageFormatInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCarriageFormatInfo(getContext(), pk, selector);
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
    public CarriageFormatInfo getCarriageFormatInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCarriageFormatInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CarriageFormatCollection getCarriageFormatCollection() throws BOSException
    {
        try {
            return getController().getCarriageFormatCollection(getContext());
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
    public CarriageFormatCollection getCarriageFormatCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCarriageFormatCollection(getContext(), view);
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
    public CarriageFormatCollection getCarriageFormatCollection(String oql) throws BOSException
    {
        try {
            return getController().getCarriageFormatCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void review(CarriageFormatInfo model) throws BOSException
    {
        try {
            getController().review(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param model model
     */
    public void unreview(CarriageFormatInfo model) throws BOSException
    {
        try {
            getController().unreview(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}