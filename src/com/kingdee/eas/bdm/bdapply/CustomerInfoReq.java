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

public class CustomerInfoReq extends CoreBillBase implements ICustomerInfoReq
{
    public CustomerInfoReq()
    {
        super();
        registerInterface(ICustomerInfoReq.class, this);
    }
    public CustomerInfoReq(Context ctx)
    {
        super(ctx);
        registerInterface(ICustomerInfoReq.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8CE1C1FB");
    }
    private CustomerInfoReqController getController() throws BOSException
    {
        return (CustomerInfoReqController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CustomerInfoReqCollection getCustomerInfoReqCollection() throws BOSException
    {
        try {
            return getController().getCustomerInfoReqCollection(getContext());
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
    public CustomerInfoReqCollection getCustomerInfoReqCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCustomerInfoReqCollection(getContext(), view);
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
    public CustomerInfoReqCollection getCustomerInfoReqCollection(String oql) throws BOSException
    {
        try {
            return getController().getCustomerInfoReqCollection(getContext(), oql);
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
    public CustomerInfoReqInfo getCustomerInfoReqInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerInfoReqInfo(getContext(), pk);
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
    public CustomerInfoReqInfo getCustomerInfoReqInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerInfoReqInfo(getContext(), pk, selector);
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
    public CustomerInfoReqInfo getCustomerInfoReqInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerInfoReqInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *客户资料审核-User defined method
     *@param model model
     */
    public void customerInfoReqAudit(CustomerInfoReqInfo model) throws BOSException
    {
        try {
            getController().customerInfoReqAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *资料审核不通过-User defined method
     *@param model model
     */
    public void notby(CustomerInfoReqInfo model) throws BOSException
    {
        try {
            getController().notby(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *批量审核-User defined method
     *@param model model
     */
    public void allAudit(CustomerInfoReqInfo model) throws BOSException
    {
        try {
            getController().allAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}