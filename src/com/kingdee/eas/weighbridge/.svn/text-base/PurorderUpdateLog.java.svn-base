package com.kingdee.eas.weighbridge;

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
import com.kingdee.eas.weighbridge.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PurorderUpdateLog extends DataBase implements IPurorderUpdateLog
{
    public PurorderUpdateLog()
    {
        super();
        registerInterface(IPurorderUpdateLog.class, this);
    }
    public PurorderUpdateLog(Context ctx)
    {
        super(ctx);
        registerInterface(IPurorderUpdateLog.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("958DC3DF");
    }
    private PurorderUpdateLogController getController() throws BOSException
    {
        return (PurorderUpdateLogController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PurorderUpdateLogInfo getPurorderUpdateLogInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPurorderUpdateLogInfo(getContext(), pk);
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
    public PurorderUpdateLogInfo getPurorderUpdateLogInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPurorderUpdateLogInfo(getContext(), pk, selector);
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
    public PurorderUpdateLogInfo getPurorderUpdateLogInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPurorderUpdateLogInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PurorderUpdateLogCollection getPurorderUpdateLogCollection() throws BOSException
    {
        try {
            return getController().getPurorderUpdateLogCollection(getContext());
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
    public PurorderUpdateLogCollection getPurorderUpdateLogCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPurorderUpdateLogCollection(getContext(), view);
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
    public PurorderUpdateLogCollection getPurorderUpdateLogCollection(String oql) throws BOSException
    {
        try {
            return getController().getPurorderUpdateLogCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}