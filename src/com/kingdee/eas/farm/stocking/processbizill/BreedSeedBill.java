package com.kingdee.eas.farm.stocking.processbizill;

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
import com.kingdee.eas.farm.stocking.processbizill.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BreedSeedBill extends CoreBillBase implements IBreedSeedBill
{
    public BreedSeedBill()
    {
        super();
        registerInterface(IBreedSeedBill.class, this);
    }
    public BreedSeedBill(Context ctx)
    {
        super(ctx);
        registerInterface(IBreedSeedBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("896D0067");
    }
    private BreedSeedBillController getController() throws BOSException
    {
        return (BreedSeedBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BreedSeedBillCollection getBreedSeedBillCollection() throws BOSException
    {
        try {
            return getController().getBreedSeedBillCollection(getContext());
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
    public BreedSeedBillCollection getBreedSeedBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBreedSeedBillCollection(getContext(), view);
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
    public BreedSeedBillCollection getBreedSeedBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getBreedSeedBillCollection(getContext(), oql);
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
    public BreedSeedBillInfo getBreedSeedBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedSeedBillInfo(getContext(), pk);
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
    public BreedSeedBillInfo getBreedSeedBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedSeedBillInfo(getContext(), pk, selector);
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
    public BreedSeedBillInfo getBreedSeedBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedSeedBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(BreedSeedBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(BreedSeedBillInfo model) throws BOSException, EASBizException
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
    public void chkVoucherAll(BreedSeedBillInfo model) throws BOSException
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
    public void chkVoucherFlag(BreedSeedBillInfo model) throws BOSException
    {
        try {
            getController().chkVoucherFlag(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}