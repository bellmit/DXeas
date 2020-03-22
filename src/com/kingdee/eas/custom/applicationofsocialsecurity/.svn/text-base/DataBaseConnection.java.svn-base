package com.kingdee.eas.custom.applicationofsocialsecurity;

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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.custom.applicationofsocialsecurity.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DataBaseConnection extends DataBase implements IDataBaseConnection
{
    public DataBaseConnection()
    {
        super();
        registerInterface(IDataBaseConnection.class, this);
    }
    public DataBaseConnection(Context ctx)
    {
        super(ctx);
        registerInterface(IDataBaseConnection.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("38328C78");
    }
    private DataBaseConnectionController getController() throws BOSException
    {
        return (DataBaseConnectionController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DataBaseConnectionInfo getDataBaseConnectionInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDataBaseConnectionInfo(getContext(), pk);
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
    public DataBaseConnectionInfo getDataBaseConnectionInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDataBaseConnectionInfo(getContext(), pk, selector);
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
    public DataBaseConnectionInfo getDataBaseConnectionInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDataBaseConnectionInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DataBaseConnectionCollection getDataBaseConnectionCollection() throws BOSException
    {
        try {
            return getController().getDataBaseConnectionCollection(getContext());
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
    public DataBaseConnectionCollection getDataBaseConnectionCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDataBaseConnectionCollection(getContext(), view);
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
    public DataBaseConnectionCollection getDataBaseConnectionCollection(String oql) throws BOSException
    {
        try {
            return getController().getDataBaseConnectionCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(DataBaseConnectionInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param model model
     */
    public void unAudit(DataBaseConnectionInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}