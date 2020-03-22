package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.hatch.app.*;
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

public class HatchEggReceivingBill extends CoreBillBase implements IHatchEggReceivingBill
{
    public HatchEggReceivingBill()
    {
        super();
        registerInterface(IHatchEggReceivingBill.class, this);
    }
    public HatchEggReceivingBill(Context ctx)
    {
        super(ctx);
        registerInterface(IHatchEggReceivingBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("08FC7214");
    }
    private HatchEggReceivingBillController getController() throws BOSException
    {
        return (HatchEggReceivingBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public HatchEggReceivingBillCollection getHatchEggReceivingBillCollection() throws BOSException
    {
        try {
            return getController().getHatchEggReceivingBillCollection(getContext());
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
    public HatchEggReceivingBillCollection getHatchEggReceivingBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getHatchEggReceivingBillCollection(getContext(), view);
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
    public HatchEggReceivingBillCollection getHatchEggReceivingBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getHatchEggReceivingBillCollection(getContext(), oql);
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
    public HatchEggReceivingBillInfo getHatchEggReceivingBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchEggReceivingBillInfo(getContext(), pk);
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
    public HatchEggReceivingBillInfo getHatchEggReceivingBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchEggReceivingBillInfo(getContext(), pk, selector);
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
    public HatchEggReceivingBillInfo getHatchEggReceivingBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchEggReceivingBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(HatchEggReceivingBillInfo model) throws BOSException
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
    public void unAudit(HatchEggReceivingBillInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}