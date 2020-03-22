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

public class Processtech extends CoreBillBase implements IProcesstech
{
    public Processtech()
    {
        super();
        registerInterface(IProcesstech.class, this);
    }
    public Processtech(Context ctx)
    {
        super(ctx);
        registerInterface(IProcesstech.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("698223A0");
    }
    private ProcesstechController getController() throws BOSException
    {
        return (ProcesstechController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ProcesstechCollection getProcesstechCollection() throws BOSException
    {
        try {
            return getController().getProcesstechCollection(getContext());
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
    public ProcesstechCollection getProcesstechCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getProcesstechCollection(getContext(), view);
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
    public ProcesstechCollection getProcesstechCollection(String oql) throws BOSException
    {
        try {
            return getController().getProcesstechCollection(getContext(), oql);
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
    public ProcesstechInfo getProcesstechInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getProcesstechInfo(getContext(), pk);
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
    public ProcesstechInfo getProcesstechInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getProcesstechInfo(getContext(), pk, selector);
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
    public ProcesstechInfo getProcesstechInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getProcesstechInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}