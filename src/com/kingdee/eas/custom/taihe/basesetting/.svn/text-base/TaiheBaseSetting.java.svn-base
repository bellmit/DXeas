package com.kingdee.eas.custom.taihe.basesetting;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.taihe.basesetting.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlDataBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class TaiheBaseSetting extends WlhlDataBase implements ITaiheBaseSetting
{
    public TaiheBaseSetting()
    {
        super();
        registerInterface(ITaiheBaseSetting.class, this);
    }
    public TaiheBaseSetting(Context ctx)
    {
        super(ctx);
        registerInterface(ITaiheBaseSetting.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FA9DEB0F");
    }
    private TaiheBaseSettingController getController() throws BOSException
    {
        return (TaiheBaseSettingController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public TaiheBaseSettingInfo getTaiheBaseSettingInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTaiheBaseSettingInfo(getContext(), pk);
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
    public TaiheBaseSettingInfo getTaiheBaseSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTaiheBaseSettingInfo(getContext(), pk, selector);
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
    public TaiheBaseSettingInfo getTaiheBaseSettingInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTaiheBaseSettingInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public TaiheBaseSettingCollection getTaiheBaseSettingCollection() throws BOSException
    {
        try {
            return getController().getTaiheBaseSettingCollection(getContext());
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
    public TaiheBaseSettingCollection getTaiheBaseSettingCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTaiheBaseSettingCollection(getContext(), view);
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
    public TaiheBaseSettingCollection getTaiheBaseSettingCollection(String oql) throws BOSException
    {
        try {
            return getController().getTaiheBaseSettingCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}