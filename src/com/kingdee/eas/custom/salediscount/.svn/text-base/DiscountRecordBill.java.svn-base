package com.kingdee.eas.custom.salediscount;

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
import com.kingdee.eas.custom.salediscount.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DiscountRecordBill extends CoreBillBase implements IDiscountRecordBill
{
    public DiscountRecordBill()
    {
        super();
        registerInterface(IDiscountRecordBill.class, this);
    }
    public DiscountRecordBill(Context ctx)
    {
        super(ctx);
        registerInterface(IDiscountRecordBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BB4F0454");
    }
    private DiscountRecordBillController getController() throws BOSException
    {
        return (DiscountRecordBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DiscountRecordBillCollection getDiscountRecordBillCollection() throws BOSException
    {
        try {
            return getController().getDiscountRecordBillCollection(getContext());
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
    public DiscountRecordBillCollection getDiscountRecordBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDiscountRecordBillCollection(getContext(), view);
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
    public DiscountRecordBillCollection getDiscountRecordBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getDiscountRecordBillCollection(getContext(), oql);
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
    public DiscountRecordBillInfo getDiscountRecordBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountRecordBillInfo(getContext(), pk);
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
    public DiscountRecordBillInfo getDiscountRecordBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountRecordBillInfo(getContext(), pk, selector);
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
    public DiscountRecordBillInfo getDiscountRecordBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountRecordBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(DiscountRecordBillInfo model) throws BOSException
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
    public void unAudit(DiscountRecordBillInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}