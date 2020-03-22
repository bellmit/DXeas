package com.kingdee.eas.farm.carnivorous.recyclebiz;

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
import com.kingdee.eas.farm.carnivorous.recyclebiz.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CKWeightBill extends CoreBillBase implements ICKWeightBill
{
    public CKWeightBill()
    {
        super();
        registerInterface(ICKWeightBill.class, this);
    }
    public CKWeightBill(Context ctx)
    {
        super(ctx);
        registerInterface(ICKWeightBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CEF5DA24");
    }
    private CKWeightBillController getController() throws BOSException
    {
        return (CKWeightBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CKWeightBillCollection getCKWeightBillCollection() throws BOSException
    {
        try {
            return getController().getCKWeightBillCollection(getContext());
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
    public CKWeightBillCollection getCKWeightBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCKWeightBillCollection(getContext(), view);
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
    public CKWeightBillCollection getCKWeightBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getCKWeightBillCollection(getContext(), oql);
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
    public CKWeightBillInfo getCKWeightBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCKWeightBillInfo(getContext(), pk);
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
    public CKWeightBillInfo getCKWeightBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCKWeightBillInfo(getContext(), pk, selector);
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
    public CKWeightBillInfo getCKWeightBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCKWeightBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(CKWeightBillInfo model) throws BOSException
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
    public void unAudit(CKWeightBillInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *修改源单据-User defined method
     *@param model model
     */
    public void updateSourceBill(CKWeightBillInfo model) throws BOSException
    {
        try {
            getController().updateSourceBill(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}