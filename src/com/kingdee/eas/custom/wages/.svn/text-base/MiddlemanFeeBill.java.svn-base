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

public class MiddlemanFeeBill extends WlhlBillBase implements IMiddlemanFeeBill
{
    public MiddlemanFeeBill()
    {
        super();
        registerInterface(IMiddlemanFeeBill.class, this);
    }
    public MiddlemanFeeBill(Context ctx)
    {
        super(ctx);
        registerInterface(IMiddlemanFeeBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("56FDF950");
    }
    private MiddlemanFeeBillController getController() throws BOSException
    {
        return (MiddlemanFeeBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MiddlemanFeeBillCollection getMiddlemanFeeBillCollection() throws BOSException
    {
        try {
            return getController().getMiddlemanFeeBillCollection(getContext());
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
    public MiddlemanFeeBillCollection getMiddlemanFeeBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMiddlemanFeeBillCollection(getContext(), view);
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
    public MiddlemanFeeBillCollection getMiddlemanFeeBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getMiddlemanFeeBillCollection(getContext(), oql);
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
    public MiddlemanFeeBillInfo getMiddlemanFeeBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMiddlemanFeeBillInfo(getContext(), pk);
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
    public MiddlemanFeeBillInfo getMiddlemanFeeBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMiddlemanFeeBillInfo(getContext(), pk, selector);
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
    public MiddlemanFeeBillInfo getMiddlemanFeeBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMiddlemanFeeBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}