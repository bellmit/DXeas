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
     *取集合-System defined method
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
     *取集合-System defined method
     *@param view 取集合
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
     *取集合-System defined method
     *@param oql 取集合
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
     *取值-System defined method
     *@param pk 取值
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
     *取值-System defined method
     *@param pk 取值
     *@param selector 取值
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
     *取值-System defined method
     *@param oql 取值
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
     *审核-User defined method
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
     *反审核-User defined method
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
     *合同变更-User defined method
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
     *变更查看-User defined method
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
     *生成付款申请-User defined method
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
     *历史版本查看-User defined method
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
     *初始化-User defined method
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
     *刷新-User defined method
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
     *设置保证金天数-User defined method
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
     *超额付款-User defined method
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
     *超额付款查看-User defined method
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