package com.kingdee.eas.farm.carnivorous.feedbiz;

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
import com.kingdee.eas.farm.carnivorous.feedbiz.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CTransFodderBill extends CoreBillBase implements ICTransFodderBill
{
    public CTransFodderBill()
    {
        super();
        registerInterface(ICTransFodderBill.class, this);
    }
    public CTransFodderBill(Context ctx)
    {
        super(ctx);
        registerInterface(ICTransFodderBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("77754AE6");
    }
    private CTransFodderBillController getController() throws BOSException
    {
        return (CTransFodderBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CTransFodderBillCollection getCTransFodderBillCollection() throws BOSException
    {
        try {
            return getController().getCTransFodderBillCollection(getContext());
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
    public CTransFodderBillCollection getCTransFodderBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCTransFodderBillCollection(getContext(), view);
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
    public CTransFodderBillCollection getCTransFodderBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getCTransFodderBillCollection(getContext(), oql);
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
    public CTransFodderBillInfo getCTransFodderBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCTransFodderBillInfo(getContext(), pk);
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
    public CTransFodderBillInfo getCTransFodderBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCTransFodderBillInfo(getContext(), pk, selector);
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
    public CTransFodderBillInfo getCTransFodderBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCTransFodderBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(CTransFodderBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(CTransFodderBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}