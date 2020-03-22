package com.kingdee.eas.custom.signwasthetable;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.signwasthetable.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Contract extends CoreBillBase implements IContract
{
    public Contract()
    {
        super();
        registerInterface(IContract.class, this);
    }
    public Contract(Context ctx)
    {
        super(ctx);
        registerInterface(IContract.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8C0AA21C");
    }
    private ContractController getController() throws BOSException
    {
        return (ContractController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public ContractCollection getContractCollection() throws BOSException
    {
        try {
            return getController().getContractCollection(getContext());
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
    public ContractCollection getContractCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getContractCollection(getContext(), view);
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
    public ContractCollection getContractCollection(String oql) throws BOSException
    {
        try {
            return getController().getContractCollection(getContext(), oql);
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
    public ContractInfo getContractInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getContractInfo(getContext(), pk);
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
    public ContractInfo getContractInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getContractInfo(getContext(), pk, selector);
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
    public ContractInfo getContractInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getContractInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audit(ContractInfo model) throws BOSException, EASBizException
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
    public void unAudit(ContractInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ͬ���-User defined method
     *@param model model
     */
    public void cmChange(ContractInfo model) throws BOSException
    {
        try {
            getController().cmChange(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����鿴-User defined method
     *@param model model
     */
    public void upVersion(ContractInfo model) throws BOSException
    {
        try {
            getController().upVersion(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ɸ�������-User defined method
     *@param model model
     */
    public void toPayReq(ContractInfo model) throws BOSException
    {
        try {
            getController().toPayReq(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ʷ�汾�鿴-User defined method
     *@param model model
     */
    public void viewHistory(ContractInfo model) throws BOSException
    {
        try {
            getController().viewHistory(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ʼ��-User defined method
     *@param model model
     */
    public void initial(ContractInfo model) throws BOSException
    {
        try {
            getController().initial(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ˢ��-User defined method
     *@param model model
     */
    public void refresh(ContractInfo model) throws BOSException
    {
        try {
            getController().refresh(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ñ�֤������-User defined method
     *@param model model
     */
    public void setBailDays(ContractInfo model) throws BOSException
    {
        try {
            getController().setBailDays(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����-User defined method
     *@param model model
     */
    public void overPay(ContractInfo model) throws BOSException
    {
        try {
            getController().overPay(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����鿴-User defined method
     *@param model model
     */
    public void overView(ContractInfo model) throws BOSException
    {
        try {
            getController().overView(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}