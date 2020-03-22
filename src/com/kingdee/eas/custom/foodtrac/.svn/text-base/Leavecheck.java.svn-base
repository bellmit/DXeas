package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.foodtrac.app.*;
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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Leavecheck extends CoreBillBase implements ILeavecheck
{
    public Leavecheck()
    {
        super();
        registerInterface(ILeavecheck.class, this);
    }
    public Leavecheck(Context ctx)
    {
        super(ctx);
        registerInterface(ILeavecheck.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8DD06F36");
    }
    private LeavecheckController getController() throws BOSException
    {
        return (LeavecheckController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public LeavecheckCollection getLeavecheckCollection() throws BOSException
    {
        try {
            return getController().getLeavecheckCollection(getContext());
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
    public LeavecheckCollection getLeavecheckCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLeavecheckCollection(getContext(), view);
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
    public LeavecheckCollection getLeavecheckCollection(String oql) throws BOSException
    {
        try {
            return getController().getLeavecheckCollection(getContext(), oql);
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
    public LeavecheckInfo getLeavecheckInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLeavecheckInfo(getContext(), pk);
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
    public LeavecheckInfo getLeavecheckInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLeavecheckInfo(getContext(), pk, selector);
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
    public LeavecheckInfo getLeavecheckInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLeavecheckInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}