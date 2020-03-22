package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.util.List;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.breed.business.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CommecialChilkenDaily extends CoreBillBase implements ICommecialChilkenDaily
{
    public CommecialChilkenDaily()
    {
        super();
        registerInterface(ICommecialChilkenDaily.class, this);
    }
    public CommecialChilkenDaily(Context ctx)
    {
        super(ctx);
        registerInterface(ICommecialChilkenDaily.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8506D469");
    }
    private CommecialChilkenDailyController getController() throws BOSException
    {
        return (CommecialChilkenDailyController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CommecialChilkenDailyCollection getCommecialChilkenDailyCollection() throws BOSException
    {
        try {
            return getController().getCommecialChilkenDailyCollection(getContext());
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
    public CommecialChilkenDailyCollection getCommecialChilkenDailyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCommecialChilkenDailyCollection(getContext(), view);
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
    public CommecialChilkenDailyCollection getCommecialChilkenDailyCollection(String oql) throws BOSException
    {
        try {
            return getController().getCommecialChilkenDailyCollection(getContext(), oql);
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
    public CommecialChilkenDailyInfo getCommecialChilkenDailyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCommecialChilkenDailyInfo(getContext(), pk);
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
    public CommecialChilkenDailyInfo getCommecialChilkenDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCommecialChilkenDailyInfo(getContext(), pk, selector);
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
    public CommecialChilkenDailyInfo getCommecialChilkenDailyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCommecialChilkenDailyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(CommecialChilkenDailyInfo model) throws BOSException
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
    public void unAudit(CommecialChilkenDailyInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *生成下游单据-User defined method
     *@param model model
     *@return
     */
    public List genNextBill(CommecialChilkenDailyInfo model) throws BOSException
    {
        try {
            return getController().genNextBill(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}