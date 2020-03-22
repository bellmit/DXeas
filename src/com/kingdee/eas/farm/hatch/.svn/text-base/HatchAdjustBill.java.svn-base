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

public class HatchAdjustBill extends CoreBillBase implements IHatchAdjustBill
{
    public HatchAdjustBill()
    {
        super();
        registerInterface(IHatchAdjustBill.class, this);
    }
    public HatchAdjustBill(Context ctx)
    {
        super(ctx);
        registerInterface(IHatchAdjustBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6A51F4C8");
    }
    private HatchAdjustBillController getController() throws BOSException
    {
        return (HatchAdjustBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public HatchAdjustBillCollection getHatchAdjustBillCollection() throws BOSException
    {
        try {
            return getController().getHatchAdjustBillCollection(getContext());
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
    public HatchAdjustBillCollection getHatchAdjustBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getHatchAdjustBillCollection(getContext(), view);
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
    public HatchAdjustBillCollection getHatchAdjustBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getHatchAdjustBillCollection(getContext(), oql);
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
    public HatchAdjustBillInfo getHatchAdjustBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchAdjustBillInfo(getContext(), pk);
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
    public HatchAdjustBillInfo getHatchAdjustBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchAdjustBillInfo(getContext(), pk, selector);
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
    public HatchAdjustBillInfo getHatchAdjustBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchAdjustBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(HatchAdjustBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(HatchAdjustBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}