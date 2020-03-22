package com.kingdee.eas.weighbridge;

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
import com.kingdee.eas.weighbridge.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WeighBridge extends DataBase implements IWeighBridge
{
    public WeighBridge()
    {
        super();
        registerInterface(IWeighBridge.class, this);
    }
    public WeighBridge(Context ctx)
    {
        super(ctx);
        registerInterface(IWeighBridge.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("71E0616A");
    }
    private WeighBridgeController getController() throws BOSException
    {
        return (WeighBridgeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WeighBridgeInfo getWeighBridgeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWeighBridgeInfo(getContext(), pk);
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
    public WeighBridgeInfo getWeighBridgeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWeighBridgeInfo(getContext(), pk, selector);
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
    public WeighBridgeInfo getWeighBridgeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWeighBridgeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WeighBridgeCollection getWeighBridgeCollection() throws BOSException
    {
        try {
            return getController().getWeighBridgeCollection(getContext());
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
    public WeighBridgeCollection getWeighBridgeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWeighBridgeCollection(getContext(), view);
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
    public WeighBridgeCollection getWeighBridgeCollection(String oql) throws BOSException
    {
        try {
            return getController().getWeighBridgeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}