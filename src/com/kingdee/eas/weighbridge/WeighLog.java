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

public class WeighLog extends DataBase implements IWeighLog
{
    public WeighLog()
    {
        super();
        registerInterface(IWeighLog.class, this);
    }
    public WeighLog(Context ctx)
    {
        super(ctx);
        registerInterface(IWeighLog.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BE8A9903");
    }
    private WeighLogController getController() throws BOSException
    {
        return (WeighLogController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WeighLogInfo getWeighLogInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWeighLogInfo(getContext(), pk);
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
    public WeighLogInfo getWeighLogInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWeighLogInfo(getContext(), pk, selector);
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
    public WeighLogInfo getWeighLogInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWeighLogInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WeighLogCollection getWeighLogCollection() throws BOSException
    {
        try {
            return getController().getWeighLogCollection(getContext());
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
    public WeighLogCollection getWeighLogCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWeighLogCollection(getContext(), view);
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
    public WeighLogCollection getWeighLogCollection(String oql) throws BOSException
    {
        try {
            return getController().getWeighLogCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}