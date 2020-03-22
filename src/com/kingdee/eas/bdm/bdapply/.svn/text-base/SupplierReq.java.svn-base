package com.kingdee.eas.bdm.bdapply;

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
import com.kingdee.eas.bdm.bdapply.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SupplierReq extends CoreBillBase implements ISupplierReq
{
    public SupplierReq()
    {
        super();
        registerInterface(ISupplierReq.class, this);
    }
    public SupplierReq(Context ctx)
    {
        super(ctx);
        registerInterface(ISupplierReq.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("034B4A5B");
    }
    private SupplierReqController getController() throws BOSException
    {
        return (SupplierReqController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SupplierReqCollection getSupplierReqCollection() throws BOSException
    {
        try {
            return getController().getSupplierReqCollection(getContext());
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
    public SupplierReqCollection getSupplierReqCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSupplierReqCollection(getContext(), view);
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
    public SupplierReqCollection getSupplierReqCollection(String oql) throws BOSException
    {
        try {
            return getController().getSupplierReqCollection(getContext(), oql);
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
    public SupplierReqInfo getSupplierReqInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSupplierReqInfo(getContext(), pk);
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
    public SupplierReqInfo getSupplierReqInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSupplierReqInfo(getContext(), pk, selector);
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
    public SupplierReqInfo getSupplierReqInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSupplierReqInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *供应商资料审核-User defined method
     *@param model model
     */
    public void supplierAudit(SupplierReqInfo model) throws BOSException
    {
        try {
            getController().supplierAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *资料审核不通过-User defined method
     *@param model model
     */
    public void basenotby(SupplierReqInfo model) throws BOSException
    {
        try {
            getController().basenotby(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *批量审核-User defined method
     *@param model model
     */
    public void allAudit(SupplierReqInfo model) throws BOSException
    {
        try {
            getController().allAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}