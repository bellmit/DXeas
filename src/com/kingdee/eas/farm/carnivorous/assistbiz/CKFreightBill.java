package com.kingdee.eas.farm.carnivorous.assistbiz;

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
import com.kingdee.eas.farm.carnivorous.assistbiz.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CKFreightBill extends CoreBillBase implements ICKFreightBill
{
    public CKFreightBill()
    {
        super();
        registerInterface(ICKFreightBill.class, this);
    }
    public CKFreightBill(Context ctx)
    {
        super(ctx);
        registerInterface(ICKFreightBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A9165033");
    }
    private CKFreightBillController getController() throws BOSException
    {
        return (CKFreightBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CKFreightBillCollection getCKFreightBillCollection() throws BOSException
    {
        try {
            return getController().getCKFreightBillCollection(getContext());
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
    public CKFreightBillCollection getCKFreightBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCKFreightBillCollection(getContext(), view);
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
    public CKFreightBillCollection getCKFreightBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getCKFreightBillCollection(getContext(), oql);
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
    public CKFreightBillInfo getCKFreightBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCKFreightBillInfo(getContext(), pk);
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
    public CKFreightBillInfo getCKFreightBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCKFreightBillInfo(getContext(), pk, selector);
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
    public CKFreightBillInfo getCKFreightBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCKFreightBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(CKFreightBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(CKFreightBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *计算运费-User defined method
     *@param model model
     */
    public void calFreight(CKFreightBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().calFreight(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}