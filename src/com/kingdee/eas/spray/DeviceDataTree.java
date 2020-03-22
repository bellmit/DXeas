package com.kingdee.eas.spray;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.spray.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DeviceDataTree extends TreeBase implements IDeviceDataTree
{
    public DeviceDataTree()
    {
        super();
        registerInterface(IDeviceDataTree.class, this);
    }
    public DeviceDataTree(Context ctx)
    {
        super(ctx);
        registerInterface(IDeviceDataTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6CCB1591");
    }
    private DeviceDataTreeController getController() throws BOSException
    {
        return (DeviceDataTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DeviceDataTreeInfo getDeviceDataTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDeviceDataTreeInfo(getContext(), pk);
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
    public DeviceDataTreeInfo getDeviceDataTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDeviceDataTreeInfo(getContext(), pk, selector);
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
    public DeviceDataTreeInfo getDeviceDataTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDeviceDataTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DeviceDataTreeCollection getDeviceDataTreeCollection() throws BOSException
    {
        try {
            return getController().getDeviceDataTreeCollection(getContext());
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
    public DeviceDataTreeCollection getDeviceDataTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDeviceDataTreeCollection(getContext(), view);
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
    public DeviceDataTreeCollection getDeviceDataTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getDeviceDataTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}