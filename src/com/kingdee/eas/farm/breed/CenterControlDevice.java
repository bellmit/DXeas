package com.kingdee.eas.farm.breed;

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
import com.kingdee.eas.farm.breed.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CenterControlDevice extends DataBase implements ICenterControlDevice
{
    public CenterControlDevice()
    {
        super();
        registerInterface(ICenterControlDevice.class, this);
    }
    public CenterControlDevice(Context ctx)
    {
        super(ctx);
        registerInterface(ICenterControlDevice.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("00E5D024");
    }
    private CenterControlDeviceController getController() throws BOSException
    {
        return (CenterControlDeviceController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public CenterControlDeviceInfo getCenterControlDeviceInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCenterControlDeviceInfo(getContext(), pk);
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
    public CenterControlDeviceInfo getCenterControlDeviceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCenterControlDeviceInfo(getContext(), pk, selector);
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
    public CenterControlDeviceInfo getCenterControlDeviceInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCenterControlDeviceInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public CenterControlDeviceCollection getCenterControlDeviceCollection() throws BOSException
    {
        try {
            return getController().getCenterControlDeviceCollection(getContext());
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
    public CenterControlDeviceCollection getCenterControlDeviceCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCenterControlDeviceCollection(getContext(), view);
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
    public CenterControlDeviceCollection getCenterControlDeviceCollection(String oql) throws BOSException
    {
        try {
            return getController().getCenterControlDeviceCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}