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
     *ȡ����-System defined method
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
     *ȡ����-System defined method
     *@param view ȡ����
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
     *ȡ����-System defined method
     *@param oql ȡ����
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
     *ȡֵ-System defined method
     *@param pk ȡֵ
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
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
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
     *ȡֵ-System defined method
     *@param oql ȡֵ
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
     *���-User defined method
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
     *�����-User defined method
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
     *�������ε���-User defined method
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