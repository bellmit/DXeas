package com.kingdee.eas.custom.taihe.weight;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.taihe.weight.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class TransportCoe extends WlhlDataBase implements ITransportCoe
{
    public TransportCoe()
    {
        super();
        registerInterface(ITransportCoe.class, this);
    }
    public TransportCoe(Context ctx)
    {
        super(ctx);
        registerInterface(ITransportCoe.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FA931AC6");
    }
    private TransportCoeController getController() throws BOSException
    {
        return (TransportCoeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public TransportCoeInfo getTransportCoeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTransportCoeInfo(getContext(), pk);
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
    public TransportCoeInfo getTransportCoeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTransportCoeInfo(getContext(), pk, selector);
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
    public TransportCoeInfo getTransportCoeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTransportCoeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public TransportCoeCollection getTransportCoeCollection() throws BOSException
    {
        try {
            return getController().getTransportCoeCollection(getContext());
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
    public TransportCoeCollection getTransportCoeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTransportCoeCollection(getContext(), view);
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
    public TransportCoeCollection getTransportCoeCollection(String oql) throws BOSException
    {
        try {
            return getController().getTransportCoeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}