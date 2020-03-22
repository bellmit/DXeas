package com.kingdee.eas.custom.taihe.weight;

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
import com.kingdee.eas.custom.taihe.weight.app.*;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WgtItem extends DataBase implements IWgtItem
{
    public WgtItem()
    {
        super();
        registerInterface(IWgtItem.class, this);
    }
    public WgtItem(Context ctx)
    {
        super(ctx);
        registerInterface(IWgtItem.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("574F99E1");
    }
    private WgtItemController getController() throws BOSException
    {
        return (WgtItemController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public WgtItemInfo getWgtItemInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWgtItemInfo(getContext(), pk);
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
    public WgtItemInfo getWgtItemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWgtItemInfo(getContext(), pk, selector);
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
    public WgtItemInfo getWgtItemInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWgtItemInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public WgtItemCollection getWgtItemCollection() throws BOSException
    {
        try {
            return getController().getWgtItemCollection(getContext());
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
    public WgtItemCollection getWgtItemCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWgtItemCollection(getContext(), view);
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
    public WgtItemCollection getWgtItemCollection(String oql) throws BOSException
    {
        try {
            return getController().getWgtItemCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}