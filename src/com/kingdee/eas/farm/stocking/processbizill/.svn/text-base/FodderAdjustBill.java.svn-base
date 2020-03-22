package com.kingdee.eas.farm.stocking.processbizill;

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
import com.kingdee.eas.farm.stocking.processbizill.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FodderAdjustBill extends CoreBillBase implements IFodderAdjustBill
{
    public FodderAdjustBill()
    {
        super();
        registerInterface(IFodderAdjustBill.class, this);
    }
    public FodderAdjustBill(Context ctx)
    {
        super(ctx);
        registerInterface(IFodderAdjustBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3755BBB1");
    }
    private FodderAdjustBillController getController() throws BOSException
    {
        return (FodderAdjustBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FodderAdjustBillCollection getFodderAdjustBillCollection() throws BOSException
    {
        try {
            return getController().getFodderAdjustBillCollection(getContext());
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
    public FodderAdjustBillCollection getFodderAdjustBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFodderAdjustBillCollection(getContext(), view);
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
    public FodderAdjustBillCollection getFodderAdjustBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getFodderAdjustBillCollection(getContext(), oql);
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
    public FodderAdjustBillInfo getFodderAdjustBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderAdjustBillInfo(getContext(), pk);
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
    public FodderAdjustBillInfo getFodderAdjustBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderAdjustBillInfo(getContext(), pk, selector);
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
    public FodderAdjustBillInfo getFodderAdjustBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderAdjustBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(FodderAdjustBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(FodderAdjustBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}