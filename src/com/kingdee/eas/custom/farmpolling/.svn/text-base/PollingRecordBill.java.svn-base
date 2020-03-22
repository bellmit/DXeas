package com.kingdee.eas.custom.farmpolling;

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
import com.kingdee.eas.custom.farmpolling.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PollingRecordBill extends CoreBillBase implements IPollingRecordBill
{
    public PollingRecordBill()
    {
        super();
        registerInterface(IPollingRecordBill.class, this);
    }
    public PollingRecordBill(Context ctx)
    {
        super(ctx);
        registerInterface(IPollingRecordBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9CFC4C15");
    }
    private PollingRecordBillController getController() throws BOSException
    {
        return (PollingRecordBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PollingRecordBillCollection getPollingRecordBillCollection() throws BOSException
    {
        try {
            return getController().getPollingRecordBillCollection(getContext());
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
    public PollingRecordBillCollection getPollingRecordBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPollingRecordBillCollection(getContext(), view);
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
    public PollingRecordBillCollection getPollingRecordBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getPollingRecordBillCollection(getContext(), oql);
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
    public PollingRecordBillInfo getPollingRecordBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPollingRecordBillInfo(getContext(), pk);
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
    public PollingRecordBillInfo getPollingRecordBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPollingRecordBillInfo(getContext(), pk, selector);
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
    public PollingRecordBillInfo getPollingRecordBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPollingRecordBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}