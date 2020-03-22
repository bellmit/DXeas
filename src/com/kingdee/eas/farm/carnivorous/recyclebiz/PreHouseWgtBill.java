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

public class PreHouseWgtBill extends CoreBillBase implements IPreHouseWgtBill
{
    public PreHouseWgtBill()
    {
        super();
        registerInterface(IPreHouseWgtBill.class, this);
    }
    public PreHouseWgtBill(Context ctx)
    {
        super(ctx);
        registerInterface(IPreHouseWgtBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CF04EA91");
    }
    private PreHouseWgtBillController getController() throws BOSException
    {
        return (PreHouseWgtBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PreHouseWgtBillCollection getPreHouseWgtBillCollection() throws BOSException
    {
        try {
            return getController().getPreHouseWgtBillCollection(getContext());
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
    public PreHouseWgtBillCollection getPreHouseWgtBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPreHouseWgtBillCollection(getContext(), view);
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
    public PreHouseWgtBillCollection getPreHouseWgtBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getPreHouseWgtBillCollection(getContext(), oql);
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
    public PreHouseWgtBillInfo getPreHouseWgtBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPreHouseWgtBillInfo(getContext(), pk);
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
    public PreHouseWgtBillInfo getPreHouseWgtBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPreHouseWgtBillInfo(getContext(), pk, selector);
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
    public PreHouseWgtBillInfo getPreHouseWgtBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPreHouseWgtBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(PreHouseWgtBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(PreHouseWgtBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}