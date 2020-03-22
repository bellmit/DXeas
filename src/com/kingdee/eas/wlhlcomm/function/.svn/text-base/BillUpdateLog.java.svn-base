package com.kingdee.eas.wlhlcomm.function;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.wlhlcomm.function.app.*;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BillUpdateLog extends CoreBillBase implements IBillUpdateLog
{
    public BillUpdateLog()
    {
        super();
        registerInterface(IBillUpdateLog.class, this);
    }
    public BillUpdateLog(Context ctx)
    {
        super(ctx);
        registerInterface(IBillUpdateLog.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("AA9B08B5");
    }
    private BillUpdateLogController getController() throws BOSException
    {
        return (BillUpdateLogController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BillUpdateLogCollection getBillUpdateLogCollection() throws BOSException
    {
        try {
            return getController().getBillUpdateLogCollection(getContext());
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
    public BillUpdateLogCollection getBillUpdateLogCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBillUpdateLogCollection(getContext(), view);
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
    public BillUpdateLogCollection getBillUpdateLogCollection(String oql) throws BOSException
    {
        try {
            return getController().getBillUpdateLogCollection(getContext(), oql);
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
    public BillUpdateLogInfo getBillUpdateLogInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBillUpdateLogInfo(getContext(), pk);
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
    public BillUpdateLogInfo getBillUpdateLogInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBillUpdateLogInfo(getContext(), pk, selector);
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
    public BillUpdateLogInfo getBillUpdateLogInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBillUpdateLogInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}