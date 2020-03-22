package com.kingdee.eas.custom.mobileRPT;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.mobileRPT.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class RPTRole extends DataBase implements IRPTRole
{
    public RPTRole()
    {
        super();
        registerInterface(IRPTRole.class, this);
    }
    public RPTRole(Context ctx)
    {
        super(ctx);
        registerInterface(IRPTRole.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("77C90EAD");
    }
    private RPTRoleController getController() throws BOSException
    {
        return (RPTRoleController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public RPTRoleInfo getRPTRoleInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getRPTRoleInfo(getContext(), pk);
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
    public RPTRoleInfo getRPTRoleInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getRPTRoleInfo(getContext(), pk, selector);
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
    public RPTRoleInfo getRPTRoleInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getRPTRoleInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public RPTRoleCollection getRPTRoleCollection() throws BOSException
    {
        try {
            return getController().getRPTRoleCollection(getContext());
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
    public RPTRoleCollection getRPTRoleCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getRPTRoleCollection(getContext(), view);
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
    public RPTRoleCollection getRPTRoleCollection(String oql) throws BOSException
    {
        try {
            return getController().getRPTRoleCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *移动端推送-User defined method
     *@param model model
     */
    public void sendMessage(RPTRoleInfo model) throws BOSException
    {
        try {
            getController().sendMessage(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}