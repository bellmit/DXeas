package com.kingdee.eas.farm.breed;

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
import com.kingdee.eas.farm.breed.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BreedBatchEditBill extends CoreBillBase implements IBreedBatchEditBill
{
    public BreedBatchEditBill()
    {
        super();
        registerInterface(IBreedBatchEditBill.class, this);
    }
    public BreedBatchEditBill(Context ctx)
    {
        super(ctx);
        registerInterface(IBreedBatchEditBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("82DD3C51");
    }
    private BreedBatchEditBillController getController() throws BOSException
    {
        return (BreedBatchEditBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BreedBatchEditBillCollection getBreedBatchEditBillCollection() throws BOSException
    {
        try {
            return getController().getBreedBatchEditBillCollection(getContext());
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
    public BreedBatchEditBillCollection getBreedBatchEditBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBreedBatchEditBillCollection(getContext(), view);
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
    public BreedBatchEditBillCollection getBreedBatchEditBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getBreedBatchEditBillCollection(getContext(), oql);
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
    public BreedBatchEditBillInfo getBreedBatchEditBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedBatchEditBillInfo(getContext(), pk);
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
    public BreedBatchEditBillInfo getBreedBatchEditBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedBatchEditBillInfo(getContext(), pk, selector);
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
    public BreedBatchEditBillInfo getBreedBatchEditBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedBatchEditBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(BreedBatchEditBillInfo model) throws BOSException
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
    public void unAudit(BreedBatchEditBillInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}