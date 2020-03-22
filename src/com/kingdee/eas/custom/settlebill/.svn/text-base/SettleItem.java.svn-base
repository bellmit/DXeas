package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.settlebill.app.*;
import java.lang.String;
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

public class SettleItem extends DataBase implements ISettleItem
{
    public SettleItem()
    {
        super();
        registerInterface(ISettleItem.class, this);
    }
    public SettleItem(Context ctx)
    {
        super(ctx);
        registerInterface(ISettleItem.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2B6BF5AF");
    }
    private SettleItemController getController() throws BOSException
    {
        return (SettleItemController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SettleItemInfo getSettleItemInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSettleItemInfo(getContext(), pk);
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
    public SettleItemInfo getSettleItemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSettleItemInfo(getContext(), pk, selector);
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
    public SettleItemInfo getSettleItemInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSettleItemInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SettleItemCollection getSettleItemCollection() throws BOSException
    {
        try {
            return getController().getSettleItemCollection(getContext());
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
    public SettleItemCollection getSettleItemCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSettleItemCollection(getContext(), view);
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
    public SettleItemCollection getSettleItemCollection(String oql) throws BOSException
    {
        try {
            return getController().getSettleItemCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}