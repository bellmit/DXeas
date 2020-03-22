package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FractionBill extends WlhlBillBase implements IFractionBill
{
    public FractionBill()
    {
        super();
        registerInterface(IFractionBill.class, this);
    }
    public FractionBill(Context ctx)
    {
        super(ctx);
        registerInterface(IFractionBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("76451931");
    }
    private FractionBillController getController() throws BOSException
    {
        return (FractionBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FractionBillCollection getFractionBillCollection() throws BOSException
    {
        try {
            return getController().getFractionBillCollection(getContext());
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
    public FractionBillCollection getFractionBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFractionBillCollection(getContext(), view);
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
    public FractionBillCollection getFractionBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getFractionBillCollection(getContext(), oql);
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
    public FractionBillInfo getFractionBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFractionBillInfo(getContext(), pk);
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
    public FractionBillInfo getFractionBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFractionBillInfo(getContext(), pk, selector);
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
    public FractionBillInfo getFractionBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFractionBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}