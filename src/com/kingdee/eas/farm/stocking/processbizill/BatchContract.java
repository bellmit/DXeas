package com.kingdee.eas.farm.stocking.processbizill;

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
import com.kingdee.eas.farm.stocking.processbizill.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BatchContract extends CoreBillBase implements IBatchContract
{
    public BatchContract()
    {
        super();
        registerInterface(IBatchContract.class, this);
    }
    public BatchContract(Context ctx)
    {
        super(ctx);
        registerInterface(IBatchContract.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CBC4A327");
    }
    private BatchContractController getController() throws BOSException
    {
        return (BatchContractController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BatchContractCollection getBatchContractCollection() throws BOSException
    {
        try {
            return getController().getBatchContractCollection(getContext());
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
    public BatchContractCollection getBatchContractCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBatchContractCollection(getContext(), view);
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
    public BatchContractCollection getBatchContractCollection(String oql) throws BOSException
    {
        try {
            return getController().getBatchContractCollection(getContext(), oql);
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
    public BatchContractInfo getBatchContractInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBatchContractInfo(getContext(), pk);
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
    public BatchContractInfo getBatchContractInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBatchContractInfo(getContext(), pk, selector);
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
    public BatchContractInfo getBatchContractInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBatchContractInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(BatchContractInfo model) throws BOSException, EASBizException
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
    public void unAudit(BatchContractInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *是否模板-User defined method
     *@param model model
     */
    public void isTemplate(BatchContractInfo model) throws BOSException
    {
        try {
            getController().isTemplate(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *初始化-User defined method
     *@param model model
     */
    public void isInit(BatchContractInfo model) throws BOSException
    {
        try {
            getController().isInit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}