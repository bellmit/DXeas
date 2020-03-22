package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.carnivorous.basedata.app.*;
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

public class DailyOutSaleCPrice extends DataBase implements IDailyOutSaleCPrice
{
    public DailyOutSaleCPrice()
    {
        super();
        registerInterface(IDailyOutSaleCPrice.class, this);
    }
    public DailyOutSaleCPrice(Context ctx)
    {
        super(ctx);
        registerInterface(IDailyOutSaleCPrice.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E3F55344");
    }
    private DailyOutSaleCPriceController getController() throws BOSException
    {
        return (DailyOutSaleCPriceController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DailyOutSaleCPriceInfo getDailyOutSaleCPriceInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDailyOutSaleCPriceInfo(getContext(), pk);
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
    public DailyOutSaleCPriceInfo getDailyOutSaleCPriceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDailyOutSaleCPriceInfo(getContext(), pk, selector);
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
    public DailyOutSaleCPriceInfo getDailyOutSaleCPriceInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDailyOutSaleCPriceInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DailyOutSaleCPriceCollection getDailyOutSaleCPriceCollection() throws BOSException
    {
        try {
            return getController().getDailyOutSaleCPriceCollection(getContext());
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
    public DailyOutSaleCPriceCollection getDailyOutSaleCPriceCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDailyOutSaleCPriceCollection(getContext(), view);
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
    public DailyOutSaleCPriceCollection getDailyOutSaleCPriceCollection(String oql) throws BOSException
    {
        try {
            return getController().getDailyOutSaleCPriceCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *核准-User defined method
     *@param model model
     */
    public void audit(DailyOutSaleCPriceInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反核准-User defined method
     *@param model model
     */
    public void unAudit(DailyOutSaleCPriceInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}