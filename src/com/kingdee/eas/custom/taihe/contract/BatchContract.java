package com.kingdee.eas.custom.taihe.contract;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.taihe.contract.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BatchContract extends WlhlBillBase implements IBatchContract
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
        return new BOSObjectType("8193F8D0");
    }
    private BatchContractController getController() throws BOSException
    {
        return (BatchContractController)getBizController();
    }
    /**
     *ȡ����-System defined method
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
     *ȡ����-System defined method
     *@param view ȡ����
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
     *ȡ����-System defined method
     *@param oql ȡ����
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
     *ȡֵ-System defined method
     *@param pk ȡֵ
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
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
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
     *ȡֵ-System defined method
     *@param oql ȡֵ
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
     *����-User defined method
     *@param model model
     */
    public void distribution(BatchContractInfo model) throws BOSException
    {
        try {
            getController().distribution(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�ر�-User defined method
     *@param model model
     */
    public void close(BatchContractInfo model) throws BOSException
    {
        try {
            getController().close(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ر�-User defined method
     *@param model model
     */
    public void backClose(BatchContractInfo model) throws BOSException
    {
        try {
            getController().backClose(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�������-User defined method
     *@param model model
     */
    public void allAudit(BatchContractInfo model) throws BOSException
    {
        try {
            getController().allAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}