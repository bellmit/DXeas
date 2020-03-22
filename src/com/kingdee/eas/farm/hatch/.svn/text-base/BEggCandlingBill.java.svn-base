package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.hatch.app.*;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BEggCandlingBill extends CoreBillBase implements IBEggCandlingBill
{
    public BEggCandlingBill()
    {
        super();
        registerInterface(IBEggCandlingBill.class, this);
    }
    public BEggCandlingBill(Context ctx)
    {
        super(ctx);
        registerInterface(IBEggCandlingBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D54999A2");
    }
    private BEggCandlingBillController getController() throws BOSException
    {
        return (BEggCandlingBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BEggCandlingBillCollection getBEggCandlingBillCollection() throws BOSException
    {
        try {
            return getController().getBEggCandlingBillCollection(getContext());
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
    public BEggCandlingBillCollection getBEggCandlingBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBEggCandlingBillCollection(getContext(), view);
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
    public BEggCandlingBillCollection getBEggCandlingBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getBEggCandlingBillCollection(getContext(), oql);
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
    public BEggCandlingBillInfo getBEggCandlingBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBEggCandlingBillInfo(getContext(), pk);
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
    public BEggCandlingBillInfo getBEggCandlingBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBEggCandlingBillInfo(getContext(), pk, selector);
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
    public BEggCandlingBillInfo getBEggCandlingBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBEggCandlingBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(BEggCandlingBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(BEggCandlingBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *调整-User defined method
     *@param model model
     */
    public void adjust(BEggCandlingBillInfo model) throws BOSException
    {
        try {
            getController().adjust(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}