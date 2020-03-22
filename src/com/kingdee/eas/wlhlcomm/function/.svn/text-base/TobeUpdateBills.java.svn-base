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

public class TobeUpdateBills extends CoreBillBase implements ITobeUpdateBills
{
    public TobeUpdateBills()
    {
        super();
        registerInterface(ITobeUpdateBills.class, this);
    }
    public TobeUpdateBills(Context ctx)
    {
        super(ctx);
        registerInterface(ITobeUpdateBills.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("85129626");
    }
    private TobeUpdateBillsController getController() throws BOSException
    {
        return (TobeUpdateBillsController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public TobeUpdateBillsCollection getTobeUpdateBillsCollection() throws BOSException
    {
        try {
            return getController().getTobeUpdateBillsCollection(getContext());
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
    public TobeUpdateBillsCollection getTobeUpdateBillsCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTobeUpdateBillsCollection(getContext(), view);
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
    public TobeUpdateBillsCollection getTobeUpdateBillsCollection(String oql) throws BOSException
    {
        try {
            return getController().getTobeUpdateBillsCollection(getContext(), oql);
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
    public TobeUpdateBillsInfo getTobeUpdateBillsInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTobeUpdateBillsInfo(getContext(), pk);
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
    public TobeUpdateBillsInfo getTobeUpdateBillsInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTobeUpdateBillsInfo(getContext(), pk, selector);
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
    public TobeUpdateBillsInfo getTobeUpdateBillsInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTobeUpdateBillsInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}