package com.kingdee.eas.custom.taihe.settle;

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
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlDataBase;
import com.kingdee.eas.custom.taihe.settle.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ThSettleItem extends WlhlDataBase implements IThSettleItem
{
    public ThSettleItem()
    {
        super();
        registerInterface(IThSettleItem.class, this);
    }
    public ThSettleItem(Context ctx)
    {
        super(ctx);
        registerInterface(IThSettleItem.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A3EAE355");
    }
    private ThSettleItemController getController() throws BOSException
    {
        return (ThSettleItemController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ThSettleItemInfo getThSettleItemInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getThSettleItemInfo(getContext(), pk);
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
    public ThSettleItemInfo getThSettleItemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getThSettleItemInfo(getContext(), pk, selector);
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
    public ThSettleItemInfo getThSettleItemInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getThSettleItemInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ThSettleItemCollection getThSettleItemCollection() throws BOSException
    {
        try {
            return getController().getThSettleItemCollection(getContext());
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
    public ThSettleItemCollection getThSettleItemCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getThSettleItemCollection(getContext(), view);
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
    public ThSettleItemCollection getThSettleItemCollection(String oql) throws BOSException
    {
        try {
            return getController().getThSettleItemCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}