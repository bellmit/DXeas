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

public class FodderApplyBill extends CoreBillBase implements IFodderApplyBill
{
    public FodderApplyBill()
    {
        super();
        registerInterface(IFodderApplyBill.class, this);
    }
    public FodderApplyBill(Context ctx)
    {
        super(ctx);
        registerInterface(IFodderApplyBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("37E98DBA");
    }
    private FodderApplyBillController getController() throws BOSException
    {
        return (FodderApplyBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FodderApplyBillCollection getFodderApplyBillCollection() throws BOSException
    {
        try {
            return getController().getFodderApplyBillCollection(getContext());
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
    public FodderApplyBillCollection getFodderApplyBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFodderApplyBillCollection(getContext(), view);
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
    public FodderApplyBillCollection getFodderApplyBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getFodderApplyBillCollection(getContext(), oql);
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
    public FodderApplyBillInfo getFodderApplyBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderApplyBillInfo(getContext(), pk);
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
    public FodderApplyBillInfo getFodderApplyBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderApplyBillInfo(getContext(), pk, selector);
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
    public FodderApplyBillInfo getFodderApplyBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderApplyBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(FodderApplyBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(FodderApplyBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}