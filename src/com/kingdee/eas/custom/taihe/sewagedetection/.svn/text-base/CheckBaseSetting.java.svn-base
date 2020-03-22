package com.kingdee.eas.custom.taihe.sewagedetection;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.taihe.sewagedetection.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlDataBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CheckBaseSetting extends WlhlDataBase implements ICheckBaseSetting
{
    public CheckBaseSetting()
    {
        super();
        registerInterface(ICheckBaseSetting.class, this);
    }
    public CheckBaseSetting(Context ctx)
    {
        super(ctx);
        registerInterface(ICheckBaseSetting.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E792FA54");
    }
    private CheckBaseSettingController getController() throws BOSException
    {
        return (CheckBaseSettingController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CheckBaseSettingInfo getCheckBaseSettingInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckBaseSettingInfo(getContext(), pk);
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
    public CheckBaseSettingInfo getCheckBaseSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckBaseSettingInfo(getContext(), pk, selector);
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
    public CheckBaseSettingInfo getCheckBaseSettingInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckBaseSettingInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CheckBaseSettingCollection getCheckBaseSettingCollection() throws BOSException
    {
        try {
            return getController().getCheckBaseSettingCollection(getContext());
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
    public CheckBaseSettingCollection getCheckBaseSettingCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCheckBaseSettingCollection(getContext(), view);
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
    public CheckBaseSettingCollection getCheckBaseSettingCollection(String oql) throws BOSException
    {
        try {
            return getController().getCheckBaseSettingCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}