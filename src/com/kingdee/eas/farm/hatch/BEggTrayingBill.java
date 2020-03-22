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

public class BEggTrayingBill extends CoreBillBase implements IBEggTrayingBill
{
    public BEggTrayingBill()
    {
        super();
        registerInterface(IBEggTrayingBill.class, this);
    }
    public BEggTrayingBill(Context ctx)
    {
        super(ctx);
        registerInterface(IBEggTrayingBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("92957B02");
    }
    private BEggTrayingBillController getController() throws BOSException
    {
        return (BEggTrayingBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BEggTrayingBillCollection getBEggTrayingBillCollection() throws BOSException
    {
        try {
            return getController().getBEggTrayingBillCollection(getContext());
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
    public BEggTrayingBillCollection getBEggTrayingBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBEggTrayingBillCollection(getContext(), view);
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
    public BEggTrayingBillCollection getBEggTrayingBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getBEggTrayingBillCollection(getContext(), oql);
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
    public BEggTrayingBillInfo getBEggTrayingBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBEggTrayingBillInfo(getContext(), pk);
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
    public BEggTrayingBillInfo getBEggTrayingBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBEggTrayingBillInfo(getContext(), pk, selector);
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
    public BEggTrayingBillInfo getBEggTrayingBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBEggTrayingBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(BEggTrayingBillInfo model) throws BOSException, EASBizException
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
    public void unAudit(BEggTrayingBillInfo model) throws BOSException, EASBizException
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
    public void adjust(BEggTrayingBillInfo model) throws BOSException
    {
        try {
            getController().adjust(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}