package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Coefficient extends DataBase implements ICoefficient
{
    public Coefficient()
    {
        super();
        registerInterface(ICoefficient.class, this);
    }
    public Coefficient(Context ctx)
    {
        super(ctx);
        registerInterface(ICoefficient.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D1EAF82D");
    }
    private CoefficientController getController() throws BOSException
    {
        return (CoefficientController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CoefficientInfo getCoefficientInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCoefficientInfo(getContext(), pk);
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
    public CoefficientInfo getCoefficientInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCoefficientInfo(getContext(), pk, selector);
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
    public CoefficientInfo getCoefficientInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCoefficientInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CoefficientCollection getCoefficientCollection() throws BOSException
    {
        try {
            return getController().getCoefficientCollection(getContext());
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
    public CoefficientCollection getCoefficientCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCoefficientCollection(getContext(), view);
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
    public CoefficientCollection getCoefficientCollection(String oql) throws BOSException
    {
        try {
            return getController().getCoefficientCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}