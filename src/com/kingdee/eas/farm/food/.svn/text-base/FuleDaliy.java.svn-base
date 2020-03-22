package com.kingdee.eas.farm.food;

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
import com.kingdee.eas.farm.food.app.*;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FuleDaliy extends CoreBillBase implements IFuleDaliy
{
    public FuleDaliy()
    {
        super();
        registerInterface(IFuleDaliy.class, this);
    }
    public FuleDaliy(Context ctx)
    {
        super(ctx);
        registerInterface(IFuleDaliy.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("677C6DED");
    }
    private FuleDaliyController getController() throws BOSException
    {
        return (FuleDaliyController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FuleDaliyCollection getFuleDaliyCollection() throws BOSException
    {
        try {
            return getController().getFuleDaliyCollection(getContext());
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
    public FuleDaliyCollection getFuleDaliyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFuleDaliyCollection(getContext(), view);
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
    public FuleDaliyCollection getFuleDaliyCollection(String oql) throws BOSException
    {
        try {
            return getController().getFuleDaliyCollection(getContext(), oql);
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
    public FuleDaliyInfo getFuleDaliyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFuleDaliyInfo(getContext(), pk);
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
    public FuleDaliyInfo getFuleDaliyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFuleDaliyInfo(getContext(), pk, selector);
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
    public FuleDaliyInfo getFuleDaliyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFuleDaliyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(FuleDaliyInfo model) throws BOSException
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
    public void unAudit(FuleDaliyInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}