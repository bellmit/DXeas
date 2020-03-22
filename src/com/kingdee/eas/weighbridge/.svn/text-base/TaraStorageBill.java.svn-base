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

public class TaraStorageBill extends CoreBillBase implements ITaraStorageBill
{
    public TaraStorageBill()
    {
        super();
        registerInterface(ITaraStorageBill.class, this);
    }
    public TaraStorageBill(Context ctx)
    {
        super(ctx);
        registerInterface(ITaraStorageBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("49252CEB");
    }
    private TaraStorageBillController getController() throws BOSException
    {
        return (TaraStorageBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public TaraStorageBillCollection getTaraStorageBillCollection() throws BOSException
    {
        try {
            return getController().getTaraStorageBillCollection(getContext());
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
    public TaraStorageBillCollection getTaraStorageBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTaraStorageBillCollection(getContext(), view);
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
    public TaraStorageBillCollection getTaraStorageBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getTaraStorageBillCollection(getContext(), oql);
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
    public TaraStorageBillInfo getTaraStorageBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTaraStorageBillInfo(getContext(), pk);
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
    public TaraStorageBillInfo getTaraStorageBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTaraStorageBillInfo(getContext(), pk, selector);
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
    public TaraStorageBillInfo getTaraStorageBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTaraStorageBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(TaraStorageBillInfo model) throws BOSException
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
    public void unAudit(TaraStorageBillInfo model) throws BOSException
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
    public void updateSourceBill(TaraStorageBillInfo model) throws BOSException
    {
        try {
            getController().updateSourceBill(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}