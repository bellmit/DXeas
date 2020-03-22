package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.stocking.basedata.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BaseSysSetting extends DataBase implements IBaseSysSetting
{
    public BaseSysSetting()
    {
        super();
        registerInterface(IBaseSysSetting.class, this);
    }
    public BaseSysSetting(Context ctx)
    {
        super(ctx);
        registerInterface(IBaseSysSetting.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("22DDC205");
    }
    private BaseSysSettingController getController() throws BOSException
    {
        return (BaseSysSettingController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public BaseSysSettingInfo getBaseSysSettingInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBaseSysSettingInfo(getContext(), pk);
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
    public BaseSysSettingInfo getBaseSysSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBaseSysSettingInfo(getContext(), pk, selector);
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
    public BaseSysSettingInfo getBaseSysSettingInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBaseSysSettingInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public BaseSysSettingCollection getBaseSysSettingCollection() throws BOSException
    {
        try {
            return getController().getBaseSysSettingCollection(getContext());
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
    public BaseSysSettingCollection getBaseSysSettingCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBaseSysSettingCollection(getContext(), view);
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
    public BaseSysSettingCollection getBaseSysSettingCollection(String oql) throws BOSException
    {
        try {
            return getController().getBaseSysSettingCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}