package com.kingdee.eas.spray;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.spray.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DeviceData extends DataBase implements IDeviceData
{
    public DeviceData()
    {
        super();
        registerInterface(IDeviceData.class, this);
    }
    public DeviceData(Context ctx)
    {
        super(ctx);
        registerInterface(IDeviceData.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("95310F53");
    }
    private DeviceDataController getController() throws BOSException
    {
        return (DeviceDataController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DeviceDataInfo getDeviceDataInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDeviceDataInfo(getContext(), pk);
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
    public DeviceDataInfo getDeviceDataInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDeviceDataInfo(getContext(), pk, selector);
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
    public DeviceDataInfo getDeviceDataInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDeviceDataInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DeviceDataCollection getDeviceDataCollection() throws BOSException
    {
        try {
            return getController().getDeviceDataCollection(getContext());
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
    public DeviceDataCollection getDeviceDataCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDeviceDataCollection(getContext(), view);
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
    public DeviceDataCollection getDeviceDataCollection(String oql) throws BOSException
    {
        try {
            return getController().getDeviceDataCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}