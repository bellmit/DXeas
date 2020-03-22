package com.kingdee.eas.custom.szcount;

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
import com.kingdee.eas.custom.szcount.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FreshDaily extends WlhlBillBase implements IFreshDaily
{
    public FreshDaily()
    {
        super();
        registerInterface(IFreshDaily.class, this);
    }
    public FreshDaily(Context ctx)
    {
        super(ctx);
        registerInterface(IFreshDaily.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("19270D36");
    }
    private FreshDailyController getController() throws BOSException
    {
        return (FreshDailyController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FreshDailyCollection getFreshDailyCollection() throws BOSException
    {
        try {
            return getController().getFreshDailyCollection(getContext());
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
    public FreshDailyCollection getFreshDailyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFreshDailyCollection(getContext(), view);
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
    public FreshDailyCollection getFreshDailyCollection(String oql) throws BOSException
    {
        try {
            return getController().getFreshDailyCollection(getContext(), oql);
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
    public FreshDailyInfo getFreshDailyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFreshDailyInfo(getContext(), pk);
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
    public FreshDailyInfo getFreshDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFreshDailyInfo(getContext(), pk, selector);
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
    public FreshDailyInfo getFreshDailyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFreshDailyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取数据-User defined method
     *@param model model
     */
    public void getData(FreshDailyInfo model) throws BOSException
    {
        try {
            getController().getData(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}