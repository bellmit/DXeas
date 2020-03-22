package com.kingdee.eas.farm.carnivorous.feedbiz;

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
import com.kingdee.eas.farm.carnivorous.feedbiz.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FodderReception extends CoreBillBase implements IFodderReception
{
    public FodderReception()
    {
        super();
        registerInterface(IFodderReception.class, this);
    }
    public FodderReception(Context ctx)
    {
        super(ctx);
        registerInterface(IFodderReception.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("713C6B15");
    }
    private FodderReceptionController getController() throws BOSException
    {
        return (FodderReceptionController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FodderReceptionCollection getFodderReceptionCollection() throws BOSException
    {
        try {
            return getController().getFodderReceptionCollection(getContext());
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
    public FodderReceptionCollection getFodderReceptionCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFodderReceptionCollection(getContext(), view);
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
    public FodderReceptionCollection getFodderReceptionCollection(String oql) throws BOSException
    {
        try {
            return getController().getFodderReceptionCollection(getContext(), oql);
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
    public FodderReceptionInfo getFodderReceptionInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderReceptionInfo(getContext(), pk);
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
    public FodderReceptionInfo getFodderReceptionInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderReceptionInfo(getContext(), pk, selector);
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
    public FodderReceptionInfo getFodderReceptionInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderReceptionInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(FodderReceptionInfo model) throws BOSException, EASBizException
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
    public void unAudit(FodderReceptionInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *饲喂量查询-User defined method
     *@param model model
     */
    public void viewStdUse(FodderReceptionInfo model) throws BOSException
    {
        try {
            getController().viewStdUse(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *校验凭证-User defined method
     *@param model model
     */
    public void chkVoucherFlag(FodderReceptionInfo model) throws BOSException
    {
        try {
            getController().chkVoucherFlag(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *全部校验凭证-User defined method
     *@param model model
     */
    public void chkVoucherAll(FodderReceptionInfo model) throws BOSException
    {
        try {
            getController().chkVoucherAll(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *批量提交-User defined method
     *@param model model
     */
    public void batchSubmit(FodderReceptionInfo model) throws BOSException
    {
        try {
            getController().batchSubmit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *关闭-User defined method
     *@param model model
     */
    public void close(FodderReceptionInfo model) throws BOSException, EASBizException
    {
        try {
            getController().close(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反关闭-User defined method
     *@param model model
     */
    public void unClose(FodderReceptionInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unClose(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}