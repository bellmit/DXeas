package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ByThePieceBill extends WlhlBillBase implements IByThePieceBill
{
    public ByThePieceBill()
    {
        super();
        registerInterface(IByThePieceBill.class, this);
    }
    public ByThePieceBill(Context ctx)
    {
        super(ctx);
        registerInterface(IByThePieceBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9D9C8EA3");
    }
    private ByThePieceBillController getController() throws BOSException
    {
        return (ByThePieceBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ByThePieceBillCollection getByThePieceBillCollection() throws BOSException
    {
        try {
            return getController().getByThePieceBillCollection(getContext());
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
    public ByThePieceBillCollection getByThePieceBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getByThePieceBillCollection(getContext(), view);
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
    public ByThePieceBillCollection getByThePieceBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getByThePieceBillCollection(getContext(), oql);
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
    public ByThePieceBillInfo getByThePieceBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getByThePieceBillInfo(getContext(), pk);
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
    public ByThePieceBillInfo getByThePieceBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getByThePieceBillInfo(getContext(), pk, selector);
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
    public ByThePieceBillInfo getByThePieceBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getByThePieceBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}