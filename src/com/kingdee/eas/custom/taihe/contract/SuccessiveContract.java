package com.kingdee.eas.custom.taihe.contract;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import com.kingdee.eas.custom.taihe.contract.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SuccessiveContract extends CoreBillBase implements ISuccessiveContract
{
    public SuccessiveContract()
    {
        super();
        registerInterface(ISuccessiveContract.class, this);
    }
    public SuccessiveContract(Context ctx)
    {
        super(ctx);
        registerInterface(ISuccessiveContract.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6C7F3E43");
    }
    private SuccessiveContractController getController() throws BOSException
    {
        return (SuccessiveContractController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public SuccessiveContractCollection getSuccessiveContractCollection() throws BOSException
    {
        try {
            return getController().getSuccessiveContractCollection(getContext());
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
    public SuccessiveContractCollection getSuccessiveContractCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSuccessiveContractCollection(getContext(), view);
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
    public SuccessiveContractCollection getSuccessiveContractCollection(String oql) throws BOSException
    {
        try {
            return getController().getSuccessiveContractCollection(getContext(), oql);
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
    public SuccessiveContractInfo getSuccessiveContractInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSuccessiveContractInfo(getContext(), pk);
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
    public SuccessiveContractInfo getSuccessiveContractInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSuccessiveContractInfo(getContext(), pk, selector);
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
    public SuccessiveContractInfo getSuccessiveContractInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSuccessiveContractInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��֤�����-User defined method
     *@param model model
     */
    public void balanceBond(SuccessiveContractInfo model) throws BOSException
    {
        try {
            getController().balanceBond(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ͬ����-User defined method
     *@param model model
     */
    public void viewOtherContract(SuccessiveContractInfo model) throws BOSException
    {
        try {
            getController().viewOtherContract(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(SuccessiveContractInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����-User defined method
     *@param model model
     */
    public void unAudit(SuccessiveContractInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}