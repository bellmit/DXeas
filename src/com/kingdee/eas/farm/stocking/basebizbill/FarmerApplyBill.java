package com.kingdee.eas.farm.stocking.basebizbill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.stocking.basebizbill.app.*;
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

public class FarmerApplyBill extends CoreBillBase implements IFarmerApplyBill
{
    public FarmerApplyBill()
    {
        super();
        registerInterface(IFarmerApplyBill.class, this);
    }
    public FarmerApplyBill(Context ctx)
    {
        super(ctx);
        registerInterface(IFarmerApplyBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E7125F71");
    }
    private FarmerApplyBillController getController() throws BOSException
    {
        return (FarmerApplyBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FarmerApplyBillCollection getFarmerApplyBillCollection() throws BOSException
    {
        try {
            return getController().getFarmerApplyBillCollection(getContext());
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
    public FarmerApplyBillCollection getFarmerApplyBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFarmerApplyBillCollection(getContext(), view);
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
    public FarmerApplyBillCollection getFarmerApplyBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getFarmerApplyBillCollection(getContext(), oql);
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
    public FarmerApplyBillInfo getFarmerApplyBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerApplyBillInfo(getContext(), pk);
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
    public FarmerApplyBillInfo getFarmerApplyBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerApplyBillInfo(getContext(), pk, selector);
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
    public FarmerApplyBillInfo getFarmerApplyBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmerApplyBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(FarmerApplyBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(FarmerApplyBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *是否模板-User defined method
     *@param model model
     */
    public void isTemplate(FarmerApplyBillInfo model) throws BOSException
    {
        try {
            getController().isTemplate(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *评定项目修改-User defined method
     *@param model model
     */
    public void isCheckItemEntry(FarmerApplyBillInfo model) throws BOSException
    {
        try {
            getController().isCheckItemEntry(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}