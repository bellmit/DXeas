package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.dayratecost.app.*;
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

public class ArAmountOffsetDetailBill extends CoreBillBase implements IArAmountOffsetDetailBill
{
    public ArAmountOffsetDetailBill()
    {
        super();
        registerInterface(IArAmountOffsetDetailBill.class, this);
    }
    public ArAmountOffsetDetailBill(Context ctx)
    {
        super(ctx);
        registerInterface(IArAmountOffsetDetailBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6E8FC959");
    }
    private ArAmountOffsetDetailBillController getController() throws BOSException
    {
        return (ArAmountOffsetDetailBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ArAmountOffsetDetailBillCollection getArAmountOffsetDetailBillCollection() throws BOSException
    {
        try {
            return getController().getArAmountOffsetDetailBillCollection(getContext());
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
    public ArAmountOffsetDetailBillCollection getArAmountOffsetDetailBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getArAmountOffsetDetailBillCollection(getContext(), view);
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
    public ArAmountOffsetDetailBillCollection getArAmountOffsetDetailBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getArAmountOffsetDetailBillCollection(getContext(), oql);
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
    public ArAmountOffsetDetailBillInfo getArAmountOffsetDetailBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getArAmountOffsetDetailBillInfo(getContext(), pk);
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
    public ArAmountOffsetDetailBillInfo getArAmountOffsetDetailBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getArAmountOffsetDetailBillInfo(getContext(), pk, selector);
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
    public ArAmountOffsetDetailBillInfo getArAmountOffsetDetailBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getArAmountOffsetDetailBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(ArAmountOffsetDetailBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(ArAmountOffsetDetailBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}