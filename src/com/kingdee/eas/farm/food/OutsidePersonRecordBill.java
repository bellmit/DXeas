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

public class OutsidePersonRecordBill extends CoreBillBase implements IOutsidePersonRecordBill
{
    public OutsidePersonRecordBill()
    {
        super();
        registerInterface(IOutsidePersonRecordBill.class, this);
    }
    public OutsidePersonRecordBill(Context ctx)
    {
        super(ctx);
        registerInterface(IOutsidePersonRecordBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("590B1908");
    }
    private OutsidePersonRecordBillController getController() throws BOSException
    {
        return (OutsidePersonRecordBillController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public OutsidePersonRecordBillCollection getOutsidePersonRecordBillCollection() throws BOSException
    {
        try {
            return getController().getOutsidePersonRecordBillCollection(getContext());
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
    public OutsidePersonRecordBillCollection getOutsidePersonRecordBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getOutsidePersonRecordBillCollection(getContext(), view);
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
    public OutsidePersonRecordBillCollection getOutsidePersonRecordBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getOutsidePersonRecordBillCollection(getContext(), oql);
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
    public OutsidePersonRecordBillInfo getOutsidePersonRecordBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getOutsidePersonRecordBillInfo(getContext(), pk);
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
    public OutsidePersonRecordBillInfo getOutsidePersonRecordBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getOutsidePersonRecordBillInfo(getContext(), pk, selector);
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
    public OutsidePersonRecordBillInfo getOutsidePersonRecordBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getOutsidePersonRecordBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(OutsidePersonRecordBillInfo model) throws BOSException
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
    public void unAudit(OutsidePersonRecordBillInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}