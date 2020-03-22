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

public class DrugApplyBill extends CoreBillBase implements IDrugApplyBill
{
    public DrugApplyBill()
    {
        super();
        registerInterface(IDrugApplyBill.class, this);
    }
    public DrugApplyBill(Context ctx)
    {
        super(ctx);
        registerInterface(IDrugApplyBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("08CA30F1");
    }
    private DrugApplyBillController getController() throws BOSException
    {
        return (DrugApplyBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DrugApplyBillCollection getDrugApplyBillCollection() throws BOSException
    {
        try {
            return getController().getDrugApplyBillCollection(getContext());
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
    public DrugApplyBillCollection getDrugApplyBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDrugApplyBillCollection(getContext(), view);
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
    public DrugApplyBillCollection getDrugApplyBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getDrugApplyBillCollection(getContext(), oql);
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
    public DrugApplyBillInfo getDrugApplyBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDrugApplyBillInfo(getContext(), pk);
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
    public DrugApplyBillInfo getDrugApplyBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDrugApplyBillInfo(getContext(), pk, selector);
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
    public DrugApplyBillInfo getDrugApplyBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDrugApplyBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(DrugApplyBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(DrugApplyBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *关闭-User defined method
     *@param model model
     */
    public void close(DrugApplyBillInfo model) throws BOSException, EASBizException
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
    public void unClose(DrugApplyBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unClose(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}