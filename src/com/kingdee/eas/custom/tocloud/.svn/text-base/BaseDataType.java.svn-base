package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.tocloud.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BaseDataType extends DataBase implements IBaseDataType
{
    public BaseDataType()
    {
        super();
        registerInterface(IBaseDataType.class, this);
    }
    public BaseDataType(Context ctx)
    {
        super(ctx);
        registerInterface(IBaseDataType.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BB17C18E");
    }
    private BaseDataTypeController getController() throws BOSException
    {
        return (BaseDataTypeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BaseDataTypeInfo getBaseDataTypeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBaseDataTypeInfo(getContext(), pk);
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
    public BaseDataTypeInfo getBaseDataTypeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBaseDataTypeInfo(getContext(), pk, selector);
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
    public BaseDataTypeInfo getBaseDataTypeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBaseDataTypeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BaseDataTypeCollection getBaseDataTypeCollection() throws BOSException
    {
        try {
            return getController().getBaseDataTypeCollection(getContext());
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
    public BaseDataTypeCollection getBaseDataTypeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBaseDataTypeCollection(getContext(), view);
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
    public BaseDataTypeCollection getBaseDataTypeCollection(String oql) throws BOSException
    {
        try {
            return getController().getBaseDataTypeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}