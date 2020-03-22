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

public class BHatchBabyBill extends CoreBillBase implements IBHatchBabyBill
{
    public BHatchBabyBill()
    {
        super();
        registerInterface(IBHatchBabyBill.class, this);
    }
    public BHatchBabyBill(Context ctx)
    {
        super(ctx);
        registerInterface(IBHatchBabyBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CF8246A9");
    }
    private BHatchBabyBillController getController() throws BOSException
    {
        return (BHatchBabyBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BHatchBabyBillCollection getBHatchBabyBillCollection() throws BOSException
    {
        try {
            return getController().getBHatchBabyBillCollection(getContext());
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
    public BHatchBabyBillCollection getBHatchBabyBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBHatchBabyBillCollection(getContext(), view);
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
    public BHatchBabyBillCollection getBHatchBabyBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getBHatchBabyBillCollection(getContext(), oql);
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
    public BHatchBabyBillInfo getBHatchBabyBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBHatchBabyBillInfo(getContext(), pk);
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
    public BHatchBabyBillInfo getBHatchBabyBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBHatchBabyBillInfo(getContext(), pk, selector);
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
    public BHatchBabyBillInfo getBHatchBabyBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBHatchBabyBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(BHatchBabyBillInfo model) throws BOSException
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
    public void unAudit(BHatchBabyBillInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *批量审核-User defined method
     *@param model model
     */
    public void multiAudit(BHatchBabyBillInfo model) throws BOSException
    {
        try {
            getController().multiAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *批量审核-User defined method
     *@param model model
     */
    public void multiAudits(BHatchBabyBillInfo model) throws BOSException
    {
        try {
            getController().multiAudits(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}