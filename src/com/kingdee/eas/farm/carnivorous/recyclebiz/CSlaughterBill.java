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

public class CSlaughterBill extends CoreBillBase implements ICSlaughterBill
{
    public CSlaughterBill()
    {
        super();
        registerInterface(ICSlaughterBill.class, this);
    }
    public CSlaughterBill(Context ctx)
    {
        super(ctx);
        registerInterface(ICSlaughterBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5A968454");
    }
    private CSlaughterBillController getController() throws BOSException
    {
        return (CSlaughterBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CSlaughterBillCollection getCSlaughterBillCollection() throws BOSException
    {
        try {
            return getController().getCSlaughterBillCollection(getContext());
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
    public CSlaughterBillCollection getCSlaughterBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCSlaughterBillCollection(getContext(), view);
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
    public CSlaughterBillCollection getCSlaughterBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getCSlaughterBillCollection(getContext(), oql);
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
    public CSlaughterBillInfo getCSlaughterBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCSlaughterBillInfo(getContext(), pk);
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
    public CSlaughterBillInfo getCSlaughterBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCSlaughterBillInfo(getContext(), pk, selector);
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
    public CSlaughterBillInfo getCSlaughterBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCSlaughterBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(CSlaughterBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(CSlaughterBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}