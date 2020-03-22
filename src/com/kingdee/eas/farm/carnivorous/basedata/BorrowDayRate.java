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

public class BorrowDayRate extends DataBase implements IBorrowDayRate
{
    public BorrowDayRate()
    {
        super();
        registerInterface(IBorrowDayRate.class, this);
    }
    public BorrowDayRate(Context ctx)
    {
        super(ctx);
        registerInterface(IBorrowDayRate.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("369EFC85");
    }
    private BorrowDayRateController getController() throws BOSException
    {
        return (BorrowDayRateController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BorrowDayRateInfo getBorrowDayRateInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBorrowDayRateInfo(getContext(), pk);
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
    public BorrowDayRateInfo getBorrowDayRateInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBorrowDayRateInfo(getContext(), pk, selector);
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
    public BorrowDayRateInfo getBorrowDayRateInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBorrowDayRateInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BorrowDayRateCollection getBorrowDayRateCollection() throws BOSException
    {
        try {
            return getController().getBorrowDayRateCollection(getContext());
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
    public BorrowDayRateCollection getBorrowDayRateCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBorrowDayRateCollection(getContext(), view);
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
    public BorrowDayRateCollection getBorrowDayRateCollection(String oql) throws BOSException
    {
        try {
            return getController().getBorrowDayRateCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *核准-User defined method
     *@param model model
     */
    public void audit(BorrowDayRateInfo model) throws BOSException, EASBizException
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
    public void unAudit(BorrowDayRateInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}