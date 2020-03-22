package com.kingdee.eas.custom.taihe.vehicledetection;

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
import com.kingdee.eas.custom.taihe.vehicledetection.app.*;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class VdChannelSetting extends DataBase implements IVdChannelSetting
{
    public VdChannelSetting()
    {
        super();
        registerInterface(IVdChannelSetting.class, this);
    }
    public VdChannelSetting(Context ctx)
    {
        super(ctx);
        registerInterface(IVdChannelSetting.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("7CF024D0");
    }
    private VdChannelSettingController getController() throws BOSException
    {
        return (VdChannelSettingController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public VdChannelSettingInfo getVdChannelSettingInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getVdChannelSettingInfo(getContext(), pk);
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
    public VdChannelSettingInfo getVdChannelSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getVdChannelSettingInfo(getContext(), pk, selector);
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
    public VdChannelSettingInfo getVdChannelSettingInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getVdChannelSettingInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public VdChannelSettingCollection getVdChannelSettingCollection() throws BOSException
    {
        try {
            return getController().getVdChannelSettingCollection(getContext());
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
    public VdChannelSettingCollection getVdChannelSettingCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getVdChannelSettingCollection(getContext(), view);
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
    public VdChannelSettingCollection getVdChannelSettingCollection(String oql) throws BOSException
    {
        try {
            return getController().getVdChannelSettingCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}