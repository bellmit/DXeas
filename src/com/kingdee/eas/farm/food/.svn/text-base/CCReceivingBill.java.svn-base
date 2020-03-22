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

public class CCReceivingBill extends CoreBillBase implements ICCReceivingBill
{
    public CCReceivingBill()
    {
        super();
        registerInterface(ICCReceivingBill.class, this);
    }
    public CCReceivingBill(Context ctx)
    {
        super(ctx);
        registerInterface(ICCReceivingBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("4C3F10BD");
    }
    private CCReceivingBillController getController() throws BOSException
    {
        return (CCReceivingBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CCReceivingBillCollection getCCReceivingBillCollection() throws BOSException
    {
        try {
            return getController().getCCReceivingBillCollection(getContext());
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
    public CCReceivingBillCollection getCCReceivingBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCCReceivingBillCollection(getContext(), view);
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
    public CCReceivingBillCollection getCCReceivingBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getCCReceivingBillCollection(getContext(), oql);
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
    public CCReceivingBillInfo getCCReceivingBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCCReceivingBillInfo(getContext(), pk);
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
    public CCReceivingBillInfo getCCReceivingBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCCReceivingBillInfo(getContext(), pk, selector);
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
    public CCReceivingBillInfo getCCReceivingBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCCReceivingBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(CCReceivingBillInfo model) throws BOSException
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
    public void unAudit(CCReceivingBillInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}