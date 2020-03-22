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

public class InStorageBill extends CoreBillBase implements IInStorageBill
{
    public InStorageBill()
    {
        super();
        registerInterface(IInStorageBill.class, this);
    }
    public InStorageBill(Context ctx)
    {
        super(ctx);
        registerInterface(IInStorageBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("52D6BAC2");
    }
    private InStorageBillController getController() throws BOSException
    {
        return (InStorageBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public InStorageBillCollection getInStorageBillCollection() throws BOSException
    {
        try {
            return getController().getInStorageBillCollection(getContext());
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
    public InStorageBillCollection getInStorageBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getInStorageBillCollection(getContext(), view);
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
    public InStorageBillCollection getInStorageBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getInStorageBillCollection(getContext(), oql);
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
    public InStorageBillInfo getInStorageBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getInStorageBillInfo(getContext(), pk);
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
    public InStorageBillInfo getInStorageBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getInStorageBillInfo(getContext(), pk, selector);
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
    public InStorageBillInfo getInStorageBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getInStorageBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(InStorageBillInfo model) throws BOSException
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
    public void unAudit(InStorageBillInfo model) throws BOSException
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
    public void updateSourceBill(InStorageBillInfo model) throws BOSException
    {
        try {
            getController().updateSourceBill(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}