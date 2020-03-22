package com.kingdee.eas.custom.salaryvoucher;

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
import com.kingdee.eas.custom.salaryvoucher.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CmpItem extends DataBase implements ICmpItem
{
    public CmpItem()
    {
        super();
        registerInterface(ICmpItem.class, this);
    }
    public CmpItem(Context ctx)
    {
        super(ctx);
        registerInterface(ICmpItem.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("DA9E9C4A");
    }
    private CmpItemController getController() throws BOSException
    {
        return (CmpItemController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CmpItemInfo getCmpItemInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCmpItemInfo(getContext(), pk);
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
    public CmpItemInfo getCmpItemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCmpItemInfo(getContext(), pk, selector);
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
    public CmpItemInfo getCmpItemInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCmpItemInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CmpItemCollection getCmpItemCollection() throws BOSException
    {
        try {
            return getController().getCmpItemCollection(getContext());
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
    public CmpItemCollection getCmpItemCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCmpItemCollection(getContext(), view);
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
    public CmpItemCollection getCmpItemCollection(String oql) throws BOSException
    {
        try {
            return getController().getCmpItemCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *更新薪酬项目-User defined method
     *@param model model
     */
    public void updateCmpItem(CmpItemInfo model) throws BOSException
    {
        try {
            getController().updateCmpItem(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}