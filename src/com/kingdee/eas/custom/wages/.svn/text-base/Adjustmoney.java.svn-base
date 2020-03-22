package com.kingdee.eas.custom.wages;

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
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Adjustmoney extends CoreBillBase implements IAdjustmoney
{
    public Adjustmoney()
    {
        super();
        registerInterface(IAdjustmoney.class, this);
    }
    public Adjustmoney(Context ctx)
    {
        super(ctx);
        registerInterface(IAdjustmoney.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E7879989");
    }
    private AdjustmoneyController getController() throws BOSException
    {
        return (AdjustmoneyController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AdjustmoneyCollection getAdjustmoneyCollection() throws BOSException
    {
        try {
            return getController().getAdjustmoneyCollection(getContext());
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
    public AdjustmoneyCollection getAdjustmoneyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAdjustmoneyCollection(getContext(), view);
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
    public AdjustmoneyCollection getAdjustmoneyCollection(String oql) throws BOSException
    {
        try {
            return getController().getAdjustmoneyCollection(getContext(), oql);
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
    public AdjustmoneyInfo getAdjustmoneyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAdjustmoneyInfo(getContext(), pk);
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
    public AdjustmoneyInfo getAdjustmoneyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAdjustmoneyInfo(getContext(), pk, selector);
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
    public AdjustmoneyInfo getAdjustmoneyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAdjustmoneyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(AdjustmoneyInfo model) throws BOSException
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
    public void unaudit(AdjustmoneyInfo model) throws BOSException
    {
        try {
            getController().unaudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}