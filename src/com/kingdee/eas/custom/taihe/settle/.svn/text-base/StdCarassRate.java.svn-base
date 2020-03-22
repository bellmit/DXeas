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

public class StdCarassRate extends WlhlDataBase implements IStdCarassRate
{
    public StdCarassRate()
    {
        super();
        registerInterface(IStdCarassRate.class, this);
    }
    public StdCarassRate(Context ctx)
    {
        super(ctx);
        registerInterface(IStdCarassRate.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BC1A28CD");
    }
    private StdCarassRateController getController() throws BOSException
    {
        return (StdCarassRateController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public StdCarassRateInfo getStdCarassRateInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getStdCarassRateInfo(getContext(), pk);
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
    public StdCarassRateInfo getStdCarassRateInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getStdCarassRateInfo(getContext(), pk, selector);
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
    public StdCarassRateInfo getStdCarassRateInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getStdCarassRateInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public StdCarassRateCollection getStdCarassRateCollection() throws BOSException
    {
        try {
            return getController().getStdCarassRateCollection(getContext());
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
    public StdCarassRateCollection getStdCarassRateCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getStdCarassRateCollection(getContext(), view);
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
    public StdCarassRateCollection getStdCarassRateCollection(String oql) throws BOSException
    {
        try {
            return getController().getStdCarassRateCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}