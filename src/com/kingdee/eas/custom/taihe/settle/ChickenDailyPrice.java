package com.kingdee.eas.custom.taihe.settle;

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
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlDataBase;
import com.kingdee.eas.custom.taihe.settle.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ChickenDailyPrice extends WlhlDataBase implements IChickenDailyPrice
{
    public ChickenDailyPrice()
    {
        super();
        registerInterface(IChickenDailyPrice.class, this);
    }
    public ChickenDailyPrice(Context ctx)
    {
        super(ctx);
        registerInterface(IChickenDailyPrice.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("96BCA162");
    }
    private ChickenDailyPriceController getController() throws BOSException
    {
        return (ChickenDailyPriceController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ChickenDailyPriceInfo getChickenDailyPriceInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getChickenDailyPriceInfo(getContext(), pk);
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
    public ChickenDailyPriceInfo getChickenDailyPriceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getChickenDailyPriceInfo(getContext(), pk, selector);
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
    public ChickenDailyPriceInfo getChickenDailyPriceInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getChickenDailyPriceInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ChickenDailyPriceCollection getChickenDailyPriceCollection() throws BOSException
    {
        try {
            return getController().getChickenDailyPriceCollection(getContext());
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
    public ChickenDailyPriceCollection getChickenDailyPriceCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getChickenDailyPriceCollection(getContext(), view);
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
    public ChickenDailyPriceCollection getChickenDailyPriceCollection(String oql) throws BOSException
    {
        try {
            return getController().getChickenDailyPriceCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}