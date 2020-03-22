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

public class BatchBreedApplyBill extends CoreBillBase implements IBatchBreedApplyBill
{
    public BatchBreedApplyBill()
    {
        super();
        registerInterface(IBatchBreedApplyBill.class, this);
    }
    public BatchBreedApplyBill(Context ctx)
    {
        super(ctx);
        registerInterface(IBatchBreedApplyBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C7EFCBD6");
    }
    private BatchBreedApplyBillController getController() throws BOSException
    {
        return (BatchBreedApplyBillController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public BatchBreedApplyBillCollection getBatchBreedApplyBillCollection() throws BOSException
    {
        try {
            return getController().getBatchBreedApplyBillCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public BatchBreedApplyBillCollection getBatchBreedApplyBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBatchBreedApplyBillCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public BatchBreedApplyBillCollection getBatchBreedApplyBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getBatchBreedApplyBillCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public BatchBreedApplyBillInfo getBatchBreedApplyBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBatchBreedApplyBillInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public BatchBreedApplyBillInfo getBatchBreedApplyBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBatchBreedApplyBillInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public BatchBreedApplyBillInfo getBatchBreedApplyBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBatchBreedApplyBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(BatchBreedApplyBillInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����-User defined method
     *@param model model
     */
    public void unAudit(BatchBreedApplyBillInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}