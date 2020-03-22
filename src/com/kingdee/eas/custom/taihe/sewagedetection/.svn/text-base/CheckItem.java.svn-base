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

public class CheckItem extends WlhlDataBase implements ICheckItem
{
    public CheckItem()
    {
        super();
        registerInterface(ICheckItem.class, this);
    }
    public CheckItem(Context ctx)
    {
        super(ctx);
        registerInterface(ICheckItem.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("AAE6C09E");
    }
    private CheckItemController getController() throws BOSException
    {
        return (CheckItemController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CheckItemInfo getCheckItemInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckItemInfo(getContext(), pk);
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
    public CheckItemInfo getCheckItemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckItemInfo(getContext(), pk, selector);
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
    public CheckItemInfo getCheckItemInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckItemInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CheckItemCollection getCheckItemCollection() throws BOSException
    {
        try {
            return getController().getCheckItemCollection(getContext());
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
    public CheckItemCollection getCheckItemCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCheckItemCollection(getContext(), view);
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
    public CheckItemCollection getCheckItemCollection(String oql) throws BOSException
    {
        try {
            return getController().getCheckItemCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}