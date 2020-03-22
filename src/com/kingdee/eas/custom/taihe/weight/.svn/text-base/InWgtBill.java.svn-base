package com.kingdee.eas.custom.taihe.weight;

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
import com.kingdee.eas.custom.taihe.weight.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class InWgtBill extends CoreBillBase implements IInWgtBill
{
    public InWgtBill()
    {
        super();
        registerInterface(IInWgtBill.class, this);
    }
    public InWgtBill(Context ctx)
    {
        super(ctx);
        registerInterface(IInWgtBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B2478F70");
    }
    private InWgtBillController getController() throws BOSException
    {
        return (InWgtBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public InWgtBillCollection getInWgtBillCollection() throws BOSException
    {
        try {
            return getController().getInWgtBillCollection(getContext());
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
    public InWgtBillCollection getInWgtBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getInWgtBillCollection(getContext(), view);
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
    public InWgtBillCollection getInWgtBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getInWgtBillCollection(getContext(), oql);
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
    public InWgtBillInfo getInWgtBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getInWgtBillInfo(getContext(), pk);
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
    public InWgtBillInfo getInWgtBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getInWgtBillInfo(getContext(), pk, selector);
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
    public InWgtBillInfo getInWgtBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getInWgtBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}