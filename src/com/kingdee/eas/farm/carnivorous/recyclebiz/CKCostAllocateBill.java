package com.kingdee.eas.farm.carnivorous.recyclebiz;

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
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CKCostAllocateBill extends CoreBillBase implements ICKCostAllocateBill
{
    public CKCostAllocateBill()
    {
        super();
        registerInterface(ICKCostAllocateBill.class, this);
    }
    public CKCostAllocateBill(Context ctx)
    {
        super(ctx);
        registerInterface(ICKCostAllocateBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EDCBFD16");
    }
    private CKCostAllocateBillController getController() throws BOSException
    {
        return (CKCostAllocateBillController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public CKCostAllocateBillCollection getCKCostAllocateBillCollection() throws BOSException
    {
        try {
            return getController().getCKCostAllocateBillCollection(getContext());
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
    public CKCostAllocateBillCollection getCKCostAllocateBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCKCostAllocateBillCollection(getContext(), view);
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
    public CKCostAllocateBillCollection getCKCostAllocateBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getCKCostAllocateBillCollection(getContext(), oql);
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
    public CKCostAllocateBillInfo getCKCostAllocateBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCKCostAllocateBillInfo(getContext(), pk);
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
    public CKCostAllocateBillInfo getCKCostAllocateBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCKCostAllocateBillInfo(getContext(), pk, selector);
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
    public CKCostAllocateBillInfo getCKCostAllocateBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCKCostAllocateBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ִ�з�̯-User defined method
     *@param model model
     */
    public void execAllocate(CKCostAllocateBillInfo model) throws BOSException
    {
        try {
            getController().execAllocate(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(CKCostAllocateBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(CKCostAllocateBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡ���ý��-User defined method
     *@param model model
     */
    public void costAmt(CKCostAllocateBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().costAmt(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}