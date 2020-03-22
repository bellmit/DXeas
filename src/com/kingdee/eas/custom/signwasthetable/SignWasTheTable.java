package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.signwasthetable.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SignWasTheTable extends CoreBillBase implements ISignWasTheTable
{
    public SignWasTheTable()
    {
        super();
        registerInterface(ISignWasTheTable.class, this);
    }
    public SignWasTheTable(Context ctx)
    {
        super(ctx);
        registerInterface(ISignWasTheTable.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F132319F");
    }
    private SignWasTheTableController getController() throws BOSException
    {
        return (SignWasTheTableController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SignWasTheTableCollection getSignWasTheTableCollection() throws BOSException
    {
        try {
            return getController().getSignWasTheTableCollection(getContext());
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
    public SignWasTheTableCollection getSignWasTheTableCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSignWasTheTableCollection(getContext(), view);
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
    public SignWasTheTableCollection getSignWasTheTableCollection(String oql) throws BOSException
    {
        try {
            return getController().getSignWasTheTableCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SignWasTheTableInfo getSignWasTheTableInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSignWasTheTableInfo(getContext(), pk);
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
    public SignWasTheTableInfo getSignWasTheTableInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSignWasTheTableInfo(getContext(), pk, selector);
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
    public SignWasTheTableInfo getSignWasTheTableInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSignWasTheTableInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void check(SignWasTheTableInfo model) throws BOSException, EASBizException
    {
        try {
            getController().check(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *删除行-User defined method
     *@param model model
     */
    public void deleteLine(SignWasTheTableInfo model) throws BOSException
    {
        try {
            getController().deleteLine(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *监听-User defined method
     *@param model model
     */
    public void listener(SignWasTheTableInfo model) throws BOSException
    {
        try {
            getController().listener(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param model model
     */
    public void unAudit(SignWasTheTableInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *刷新-User defined method
     *@param model model
     */
    public void btnRefresh(SignWasTheTableInfo model) throws BOSException
    {
        try {
            getController().btnRefresh(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}