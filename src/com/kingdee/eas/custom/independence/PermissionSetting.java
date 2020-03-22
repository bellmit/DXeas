package com.kingdee.eas.custom.independence;

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
import com.kingdee.eas.custom.independence.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PermissionSetting extends DataBase implements IPermissionSetting
{
    public PermissionSetting()
    {
        super();
        registerInterface(IPermissionSetting.class, this);
    }
    public PermissionSetting(Context ctx)
    {
        super(ctx);
        registerInterface(IPermissionSetting.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("69804A7A");
    }
    private PermissionSettingController getController() throws BOSException
    {
        return (PermissionSettingController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PermissionSettingInfo getPermissionSettingInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPermissionSettingInfo(getContext(), pk);
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
    public PermissionSettingInfo getPermissionSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPermissionSettingInfo(getContext(), pk, selector);
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
    public PermissionSettingInfo getPermissionSettingInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPermissionSettingInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PermissionSettingCollection getPermissionSettingCollection() throws BOSException
    {
        try {
            return getController().getPermissionSettingCollection(getContext());
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
    public PermissionSettingCollection getPermissionSettingCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPermissionSettingCollection(getContext(), view);
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
    public PermissionSettingCollection getPermissionSettingCollection(String oql) throws BOSException
    {
        try {
            return getController().getPermissionSettingCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *采购订单更新发票信息-User defined method
     *@param model model
     */
    public void purOrderUpdateTax(PermissionSettingInfo model) throws BOSException
    {
        try {
            getController().purOrderUpdateTax(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *采购订单复核-User defined method
     *@param model model
     */
    public void purOrderCheck(PermissionSettingInfo model) throws BOSException
    {
        try {
            getController().purOrderCheck(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *采购订单反复核-User defined method
     *@param model model
     */
    public void purOrderUnCheck(PermissionSettingInfo model) throws BOSException
    {
        try {
            getController().purOrderUnCheck(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}