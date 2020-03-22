package com.kingdee.eas.farm.food;

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
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.farm.food.app.*;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FreshCountBill extends CoreBillBase implements IFreshCountBill
{
    public FreshCountBill()
    {
        super();
        registerInterface(IFreshCountBill.class, this);
    }
    public FreshCountBill(Context ctx)
    {
        super(ctx);
        registerInterface(IFreshCountBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3E438F52");
    }
    private FreshCountBillController getController() throws BOSException
    {
        return (FreshCountBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FreshCountBillCollection getFreshCountBillCollection() throws BOSException
    {
        try {
            return getController().getFreshCountBillCollection(getContext());
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
    public FreshCountBillCollection getFreshCountBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFreshCountBillCollection(getContext(), view);
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
    public FreshCountBillCollection getFreshCountBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getFreshCountBillCollection(getContext(), oql);
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
    public FreshCountBillInfo getFreshCountBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFreshCountBillInfo(getContext(), pk);
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
    public FreshCountBillInfo getFreshCountBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFreshCountBillInfo(getContext(), pk, selector);
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
    public FreshCountBillInfo getFreshCountBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFreshCountBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(FreshCountBillInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param model model
     */
    public void unAudit(FreshCountBillInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}