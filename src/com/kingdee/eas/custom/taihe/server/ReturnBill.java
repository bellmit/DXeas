package com.kingdee.eas.custom.taihe.server;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.taihe.server.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ReturnBill extends WlhlBillBase implements IReturnBill
{
    public ReturnBill()
    {
        super();
        registerInterface(IReturnBill.class, this);
    }
    public ReturnBill(Context ctx)
    {
        super(ctx);
        registerInterface(IReturnBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("76E5DBE2");
    }
    private ReturnBillController getController() throws BOSException
    {
        return (ReturnBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ReturnBillCollection getReturnBillCollection() throws BOSException
    {
        try {
            return getController().getReturnBillCollection(getContext());
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
    public ReturnBillCollection getReturnBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getReturnBillCollection(getContext(), view);
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
    public ReturnBillCollection getReturnBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getReturnBillCollection(getContext(), oql);
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
    public ReturnBillInfo getReturnBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getReturnBillInfo(getContext(), pk);
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
    public ReturnBillInfo getReturnBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getReturnBillInfo(getContext(), pk, selector);
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
    public ReturnBillInfo getReturnBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getReturnBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}