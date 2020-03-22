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

public class TranferBoxBill extends CoreBillBase implements ITranferBoxBill
{
    public TranferBoxBill()
    {
        super();
        registerInterface(ITranferBoxBill.class, this);
    }
    public TranferBoxBill(Context ctx)
    {
        super(ctx);
        registerInterface(ITranferBoxBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9DC48058");
    }
    private TranferBoxBillController getController() throws BOSException
    {
        return (TranferBoxBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public TranferBoxBillCollection getTranferBoxBillCollection() throws BOSException
    {
        try {
            return getController().getTranferBoxBillCollection(getContext());
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
    public TranferBoxBillCollection getTranferBoxBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTranferBoxBillCollection(getContext(), view);
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
    public TranferBoxBillCollection getTranferBoxBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getTranferBoxBillCollection(getContext(), oql);
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
    public TranferBoxBillInfo getTranferBoxBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTranferBoxBillInfo(getContext(), pk);
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
    public TranferBoxBillInfo getTranferBoxBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTranferBoxBillInfo(getContext(), pk, selector);
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
    public TranferBoxBillInfo getTranferBoxBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTranferBoxBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(TranferBoxBillInfo model) throws BOSException
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
    public void unAudit(TranferBoxBillInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}