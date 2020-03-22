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

public class OilStandPrice extends DataBase implements IOilStandPrice
{
    public OilStandPrice()
    {
        super();
        registerInterface(IOilStandPrice.class, this);
    }
    public OilStandPrice(Context ctx)
    {
        super(ctx);
        registerInterface(IOilStandPrice.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6738DE59");
    }
    private OilStandPriceController getController() throws BOSException
    {
        return (OilStandPriceController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public OilStandPriceInfo getOilStandPriceInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getOilStandPriceInfo(getContext(), pk);
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
    public OilStandPriceInfo getOilStandPriceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getOilStandPriceInfo(getContext(), pk, selector);
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
    public OilStandPriceInfo getOilStandPriceInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getOilStandPriceInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public OilStandPriceCollection getOilStandPriceCollection() throws BOSException
    {
        try {
            return getController().getOilStandPriceCollection(getContext());
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
    public OilStandPriceCollection getOilStandPriceCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getOilStandPriceCollection(getContext(), view);
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
    public OilStandPriceCollection getOilStandPriceCollection(String oql) throws BOSException
    {
        try {
            return getController().getOilStandPriceCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void review(OilStandPriceInfo model) throws BOSException
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
    public void unreview(OilStandPriceInfo model) throws BOSException
    {
        try {
            getController().unreview(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}