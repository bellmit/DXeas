package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.carnivorous.feedbiz.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BatchContractBill extends CoreBillBase implements IBatchContractBill
{
    public BatchContractBill()
    {
        super();
        registerInterface(IBatchContractBill.class, this);
    }
    public BatchContractBill(Context ctx)
    {
        super(ctx);
        registerInterface(IBatchContractBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F66F7EAF");
    }
    private BatchContractBillController getController() throws BOSException
    {
        return (BatchContractBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BatchContractBillCollection getBatchContractBillCollection() throws BOSException
    {
        try {
            return getController().getBatchContractBillCollection(getContext());
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
    public BatchContractBillCollection getBatchContractBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBatchContractBillCollection(getContext(), view);
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
    public BatchContractBillCollection getBatchContractBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getBatchContractBillCollection(getContext(), oql);
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
    public BatchContractBillInfo getBatchContractBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBatchContractBillInfo(getContext(), pk);
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
    public BatchContractBillInfo getBatchContractBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBatchContractBillInfo(getContext(), pk, selector);
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
    public BatchContractBillInfo getBatchContractBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBatchContractBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(BatchContractBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(BatchContractBillInfo model) throws BOSException, EASBizException
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
    public void isTemplate(BatchContractBillInfo model) throws BOSException
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
    public void isInit(BatchContractBillInfo model) throws BOSException
    {
        try {
            getController().isInit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *查看担保书-User defined method
     *@param model model
     */
    public void viewGuaranteeBill(BatchContractBillInfo model) throws BOSException
    {
        try {
            getController().viewGuaranteeBill(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *作废-User defined method
     *@param model model
     */
    public void revoke(BatchContractBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().revoke(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *养大鸡变更-User defined method
     *@param model model
     */
    public void changeIsFeedBig(IObjectValue model) throws BOSException, EASBizException
    {
        try {
            getController().changeIsFeedBig(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}