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

public class DrugReceiveBill extends CoreBillBase implements IDrugReceiveBill
{
    public DrugReceiveBill()
    {
        super();
        registerInterface(IDrugReceiveBill.class, this);
    }
    public DrugReceiveBill(Context ctx)
    {
        super(ctx);
        registerInterface(IDrugReceiveBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0E74B6E6");
    }
    private DrugReceiveBillController getController() throws BOSException
    {
        return (DrugReceiveBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DrugReceiveBillCollection getDrugReceiveBillCollection() throws BOSException
    {
        try {
            return getController().getDrugReceiveBillCollection(getContext());
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
    public DrugReceiveBillCollection getDrugReceiveBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDrugReceiveBillCollection(getContext(), view);
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
    public DrugReceiveBillCollection getDrugReceiveBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getDrugReceiveBillCollection(getContext(), oql);
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
    public DrugReceiveBillInfo getDrugReceiveBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDrugReceiveBillInfo(getContext(), pk);
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
    public DrugReceiveBillInfo getDrugReceiveBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDrugReceiveBillInfo(getContext(), pk, selector);
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
    public DrugReceiveBillInfo getDrugReceiveBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDrugReceiveBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(DrugReceiveBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(DrugReceiveBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *全部校验凭证-User defined method
     *@param model model
     */
    public void chkVoucherAll(DrugReceiveBillInfo model) throws BOSException
    {
        try {
            getController().chkVoucherAll(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *校验凭证-User defined method
     *@param model model
     */
    public void chkVoucherFlag(DrugReceiveBillInfo model) throws BOSException
    {
        try {
            getController().chkVoucherFlag(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *关闭-User defined method
     *@param model model
     */
    public void close(DrugReceiveBillInfo model) throws BOSException, EASBizException
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
    public void unClose(DrugReceiveBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unClose(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}