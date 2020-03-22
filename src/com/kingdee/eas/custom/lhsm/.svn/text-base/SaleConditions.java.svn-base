package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.lhsm.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SaleConditions extends DataBase implements ISaleConditions
{
    public SaleConditions()
    {
        super();
        registerInterface(ISaleConditions.class, this);
    }
    public SaleConditions(Context ctx)
    {
        super(ctx);
        registerInterface(ISaleConditions.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2D23430C");
    }
    private SaleConditionsController getController() throws BOSException
    {
        return (SaleConditionsController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SaleConditionsInfo getSaleConditionsInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleConditionsInfo(getContext(), pk);
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
    public SaleConditionsInfo getSaleConditionsInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleConditionsInfo(getContext(), pk, selector);
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
    public SaleConditionsInfo getSaleConditionsInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleConditionsInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SaleConditionsCollection getSaleConditionsCollection() throws BOSException
    {
        try {
            return getController().getSaleConditionsCollection(getContext());
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
    public SaleConditionsCollection getSaleConditionsCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSaleConditionsCollection(getContext(), view);
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
    public SaleConditionsCollection getSaleConditionsCollection(String oql) throws BOSException
    {
        try {
            return getController().getSaleConditionsCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}