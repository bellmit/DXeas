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

public class OtherStorageBill extends CoreBillBase implements IOtherStorageBill
{
    public OtherStorageBill()
    {
        super();
        registerInterface(IOtherStorageBill.class, this);
    }
    public OtherStorageBill(Context ctx)
    {
        super(ctx);
        registerInterface(IOtherStorageBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("79CFD5CD");
    }
    private OtherStorageBillController getController() throws BOSException
    {
        return (OtherStorageBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public OtherStorageBillCollection getOtherStorageBillCollection() throws BOSException
    {
        try {
            return getController().getOtherStorageBillCollection(getContext());
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
    public OtherStorageBillCollection getOtherStorageBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getOtherStorageBillCollection(getContext(), view);
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
    public OtherStorageBillCollection getOtherStorageBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getOtherStorageBillCollection(getContext(), oql);
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
    public OtherStorageBillInfo getOtherStorageBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getOtherStorageBillInfo(getContext(), pk);
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
    public OtherStorageBillInfo getOtherStorageBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getOtherStorageBillInfo(getContext(), pk, selector);
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
    public OtherStorageBillInfo getOtherStorageBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getOtherStorageBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(OtherStorageBillInfo model) throws BOSException
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
    public void unAudit(OtherStorageBillInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *修改源单据-User defined method
     *@param model model
     */
    public void updateSourceBill(OtherStorageBillInfo model) throws BOSException
    {
        try {
            getController().updateSourceBill(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}