package com.kingdee.eas.weighbridge;

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
import com.kingdee.eas.weighbridge.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class StorageBillEditBill extends CoreBillBase implements IStorageBillEditBill
{
    public StorageBillEditBill()
    {
        super();
        registerInterface(IStorageBillEditBill.class, this);
    }
    public StorageBillEditBill(Context ctx)
    {
        super(ctx);
        registerInterface(IStorageBillEditBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CDD394B8");
    }
    private StorageBillEditBillController getController() throws BOSException
    {
        return (StorageBillEditBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public StorageBillEditBillCollection getStorageBillEditBillCollection() throws BOSException
    {
        try {
            return getController().getStorageBillEditBillCollection(getContext());
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
    public StorageBillEditBillCollection getStorageBillEditBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getStorageBillEditBillCollection(getContext(), view);
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
    public StorageBillEditBillCollection getStorageBillEditBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getStorageBillEditBillCollection(getContext(), oql);
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
    public StorageBillEditBillInfo getStorageBillEditBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getStorageBillEditBillInfo(getContext(), pk);
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
    public StorageBillEditBillInfo getStorageBillEditBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getStorageBillEditBillInfo(getContext(), pk, selector);
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
    public StorageBillEditBillInfo getStorageBillEditBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getStorageBillEditBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}