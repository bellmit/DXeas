package com.kingdee.eas.custom.tocloud;

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
import com.kingdee.eas.custom.tocloud.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SynDateLog extends CoreBillBase implements ISynDateLog
{
    public SynDateLog()
    {
        super();
        registerInterface(ISynDateLog.class, this);
    }
    public SynDateLog(Context ctx)
    {
        super(ctx);
        registerInterface(ISynDateLog.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("892A58A7");
    }
    private SynDateLogController getController() throws BOSException
    {
        return (SynDateLogController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SynDateLogCollection getSynDateLogCollection() throws BOSException
    {
        try {
            return getController().getSynDateLogCollection(getContext());
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
    public SynDateLogCollection getSynDateLogCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSynDateLogCollection(getContext(), view);
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
    public SynDateLogCollection getSynDateLogCollection(String oql) throws BOSException
    {
        try {
            return getController().getSynDateLogCollection(getContext(), oql);
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
    public SynDateLogInfo getSynDateLogInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSynDateLogInfo(getContext(), pk);
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
    public SynDateLogInfo getSynDateLogInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSynDateLogInfo(getContext(), pk, selector);
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
    public SynDateLogInfo getSynDateLogInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSynDateLogInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *删除分录-User defined method
     *@param model model
     */
    public void deleteEntry(SynDateLogInfo model) throws BOSException
    {
        try {
            getController().deleteEntry(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}