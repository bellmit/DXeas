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

public class OtherPayment extends CoreBillBase implements IOtherPayment
{
    public OtherPayment()
    {
        super();
        registerInterface(IOtherPayment.class, this);
    }
    public OtherPayment(Context ctx)
    {
        super(ctx);
        registerInterface(IOtherPayment.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D3D984BB");
    }
    private OtherPaymentController getController() throws BOSException
    {
        return (OtherPaymentController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public OtherPaymentCollection getOtherPaymentCollection() throws BOSException
    {
        try {
            return getController().getOtherPaymentCollection(getContext());
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
    public OtherPaymentCollection getOtherPaymentCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getOtherPaymentCollection(getContext(), view);
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
    public OtherPaymentCollection getOtherPaymentCollection(String oql) throws BOSException
    {
        try {
            return getController().getOtherPaymentCollection(getContext(), oql);
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
    public OtherPaymentInfo getOtherPaymentInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getOtherPaymentInfo(getContext(), pk);
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
    public OtherPaymentInfo getOtherPaymentInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getOtherPaymentInfo(getContext(), pk, selector);
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
    public OtherPaymentInfo getOtherPaymentInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getOtherPaymentInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(OtherPaymentInfo model) throws BOSException
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
    public void unAudit(OtherPaymentInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *计算母鸭代付生活费-User defined method
     *@param model model
     */
    public void calFemalAmount(OtherPaymentInfo model) throws BOSException
    {
        try {
            getController().calFemalAmount(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}