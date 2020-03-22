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

public class OtherReceptionBill extends CoreBillBase implements IOtherReceptionBill
{
    public OtherReceptionBill()
    {
        super();
        registerInterface(IOtherReceptionBill.class, this);
    }
    public OtherReceptionBill(Context ctx)
    {
        super(ctx);
        registerInterface(IOtherReceptionBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("01986E6B");
    }
    private OtherReceptionBillController getController() throws BOSException
    {
        return (OtherReceptionBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public OtherReceptionBillCollection getOtherReceptionBillCollection() throws BOSException
    {
        try {
            return getController().getOtherReceptionBillCollection(getContext());
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
    public OtherReceptionBillCollection getOtherReceptionBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getOtherReceptionBillCollection(getContext(), view);
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
    public OtherReceptionBillCollection getOtherReceptionBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getOtherReceptionBillCollection(getContext(), oql);
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
    public OtherReceptionBillInfo getOtherReceptionBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getOtherReceptionBillInfo(getContext(), pk);
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
    public OtherReceptionBillInfo getOtherReceptionBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getOtherReceptionBillInfo(getContext(), pk, selector);
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
    public OtherReceptionBillInfo getOtherReceptionBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getOtherReceptionBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(OtherReceptionBillInfo model) throws BOSException
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
    public void unAudit(OtherReceptionBillInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}