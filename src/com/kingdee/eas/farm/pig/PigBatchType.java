package com.kingdee.eas.farm.pig;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.pig.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PigBatchType extends DataBase implements IPigBatchType
{
    public PigBatchType()
    {
        super();
        registerInterface(IPigBatchType.class, this);
    }
    public PigBatchType(Context ctx)
    {
        super(ctx);
        registerInterface(IPigBatchType.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("4297D5E6");
    }
    private PigBatchTypeController getController() throws BOSException
    {
        return (PigBatchTypeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PigBatchTypeInfo getPigBatchTypeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPigBatchTypeInfo(getContext(), pk);
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
    public PigBatchTypeInfo getPigBatchTypeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPigBatchTypeInfo(getContext(), pk, selector);
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
    public PigBatchTypeInfo getPigBatchTypeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPigBatchTypeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PigBatchTypeCollection getPigBatchTypeCollection() throws BOSException
    {
        try {
            return getController().getPigBatchTypeCollection(getContext());
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
    public PigBatchTypeCollection getPigBatchTypeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPigBatchTypeCollection(getContext(), view);
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
    public PigBatchTypeCollection getPigBatchTypeCollection(String oql) throws BOSException
    {
        try {
            return getController().getPigBatchTypeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}