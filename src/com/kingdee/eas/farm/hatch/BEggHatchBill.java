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

public class BEggHatchBill extends CoreBillBase implements IBEggHatchBill
{
    public BEggHatchBill()
    {
        super();
        registerInterface(IBEggHatchBill.class, this);
    }
    public BEggHatchBill(Context ctx)
    {
        super(ctx);
        registerInterface(IBEggHatchBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D2F77416");
    }
    private BEggHatchBillController getController() throws BOSException
    {
        return (BEggHatchBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BEggHatchBillCollection getBEggHatchBillCollection() throws BOSException
    {
        try {
            return getController().getBEggHatchBillCollection(getContext());
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
    public BEggHatchBillCollection getBEggHatchBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBEggHatchBillCollection(getContext(), view);
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
    public BEggHatchBillCollection getBEggHatchBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getBEggHatchBillCollection(getContext(), oql);
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
    public BEggHatchBillInfo getBEggHatchBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBEggHatchBillInfo(getContext(), pk);
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
    public BEggHatchBillInfo getBEggHatchBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBEggHatchBillInfo(getContext(), pk, selector);
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
    public BEggHatchBillInfo getBEggHatchBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBEggHatchBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(BEggHatchBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(BEggHatchBillInfo model) throws BOSException, EASBizException
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
    public void adjust(BEggHatchBillInfo model) throws BOSException
    {
        try {
            getController().adjust(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}