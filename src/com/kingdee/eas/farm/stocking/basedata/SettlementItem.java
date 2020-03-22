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

public class SettlementItem extends DataBase implements ISettlementItem
{
    public SettlementItem()
    {
        super();
        registerInterface(ISettlementItem.class, this);
    }
    public SettlementItem(Context ctx)
    {
        super(ctx);
        registerInterface(ISettlementItem.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3BC1156D");
    }
    private SettlementItemController getController() throws BOSException
    {
        return (SettlementItemController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SettlementItemInfo getSettlementItemInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSettlementItemInfo(getContext(), pk);
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
    public SettlementItemInfo getSettlementItemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSettlementItemInfo(getContext(), pk, selector);
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
    public SettlementItemInfo getSettlementItemInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSettlementItemInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SettlementItemCollection getSettlementItemCollection() throws BOSException
    {
        try {
            return getController().getSettlementItemCollection(getContext());
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
    public SettlementItemCollection getSettlementItemCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSettlementItemCollection(getContext(), view);
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
    public SettlementItemCollection getSettlementItemCollection(String oql) throws BOSException
    {
        try {
            return getController().getSettlementItemCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *核准-User defined method
     *@param model model
     */
    public void audit(SettlementItemInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反核准-User defined method
     *@param model model
     */
    public void unAudit(SettlementItemInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}