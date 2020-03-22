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

public class CTransDrugBill extends CoreBillBase implements ICTransDrugBill
{
    public CTransDrugBill()
    {
        super();
        registerInterface(ICTransDrugBill.class, this);
    }
    public CTransDrugBill(Context ctx)
    {
        super(ctx);
        registerInterface(ICTransDrugBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B25E5A50");
    }
    private CTransDrugBillController getController() throws BOSException
    {
        return (CTransDrugBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CTransDrugBillCollection getCTransDrugBillCollection() throws BOSException
    {
        try {
            return getController().getCTransDrugBillCollection(getContext());
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
    public CTransDrugBillCollection getCTransDrugBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCTransDrugBillCollection(getContext(), view);
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
    public CTransDrugBillCollection getCTransDrugBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getCTransDrugBillCollection(getContext(), oql);
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
    public CTransDrugBillInfo getCTransDrugBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCTransDrugBillInfo(getContext(), pk);
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
    public CTransDrugBillInfo getCTransDrugBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCTransDrugBillInfo(getContext(), pk, selector);
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
    public CTransDrugBillInfo getCTransDrugBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCTransDrugBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(CTransDrugBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(CTransDrugBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}