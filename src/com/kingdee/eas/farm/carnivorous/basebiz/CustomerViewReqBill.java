package com.kingdee.eas.farm.carnivorous.basebiz;

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
import com.kingdee.eas.farm.carnivorous.basebiz.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CustomerViewReqBill extends CoreBillBase implements ICustomerViewReqBill
{
    public CustomerViewReqBill()
    {
        super();
        registerInterface(ICustomerViewReqBill.class, this);
    }
    public CustomerViewReqBill(Context ctx)
    {
        super(ctx);
        registerInterface(ICustomerViewReqBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B45036AB");
    }
    private CustomerViewReqBillController getController() throws BOSException
    {
        return (CustomerViewReqBillController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public CustomerViewReqBillCollection getCustomerViewReqBillCollection() throws BOSException
    {
        try {
            return getController().getCustomerViewReqBillCollection(getContext());
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
    public CustomerViewReqBillCollection getCustomerViewReqBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCustomerViewReqBillCollection(getContext(), view);
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
    public CustomerViewReqBillCollection getCustomerViewReqBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getCustomerViewReqBillCollection(getContext(), oql);
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
    public CustomerViewReqBillInfo getCustomerViewReqBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerViewReqBillInfo(getContext(), pk);
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
    public CustomerViewReqBillInfo getCustomerViewReqBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerViewReqBillInfo(getContext(), pk, selector);
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
    public CustomerViewReqBillInfo getCustomerViewReqBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerViewReqBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(CustomerViewReqBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(CustomerViewReqBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����-User defined method
     *@param model model
     */
    public void revoke(CustomerViewReqBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().revoke(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}