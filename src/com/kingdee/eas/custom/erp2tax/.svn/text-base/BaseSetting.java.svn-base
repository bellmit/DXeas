package com.kingdee.eas.custom.erp2tax;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.erp2tax.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BaseSetting extends DataBase implements IBaseSetting
{
    public BaseSetting()
    {
        super();
        registerInterface(IBaseSetting.class, this);
    }
    public BaseSetting(Context ctx)
    {
        super(ctx);
        registerInterface(IBaseSetting.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("78177308");
    }
    private BaseSettingController getController() throws BOSException
    {
        return (BaseSettingController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BaseSettingInfo getBaseSettingInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBaseSettingInfo(getContext(), pk);
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
    public BaseSettingInfo getBaseSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBaseSettingInfo(getContext(), pk, selector);
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
    public BaseSettingInfo getBaseSettingInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBaseSettingInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BaseSettingCollection getBaseSettingCollection() throws BOSException
    {
        try {
            return getController().getBaseSettingCollection(getContext());
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
    public BaseSettingCollection getBaseSettingCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBaseSettingCollection(getContext(), view);
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
    public BaseSettingCollection getBaseSettingCollection(String oql) throws BOSException
    {
        try {
            return getController().getBaseSettingCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}