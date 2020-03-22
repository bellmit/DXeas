package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.foodtrac.app.*;
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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Thirdpartycheck extends CoreBillBase implements IThirdpartycheck
{
    public Thirdpartycheck()
    {
        super();
        registerInterface(IThirdpartycheck.class, this);
    }
    public Thirdpartycheck(Context ctx)
    {
        super(ctx);
        registerInterface(IThirdpartycheck.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D040E724");
    }
    private ThirdpartycheckController getController() throws BOSException
    {
        return (ThirdpartycheckController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ThirdpartycheckCollection getThirdpartycheckCollection() throws BOSException
    {
        try {
            return getController().getThirdpartycheckCollection(getContext());
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
    public ThirdpartycheckCollection getThirdpartycheckCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getThirdpartycheckCollection(getContext(), view);
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
    public ThirdpartycheckCollection getThirdpartycheckCollection(String oql) throws BOSException
    {
        try {
            return getController().getThirdpartycheckCollection(getContext(), oql);
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
    public ThirdpartycheckInfo getThirdpartycheckInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getThirdpartycheckInfo(getContext(), pk);
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
    public ThirdpartycheckInfo getThirdpartycheckInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getThirdpartycheckInfo(getContext(), pk, selector);
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
    public ThirdpartycheckInfo getThirdpartycheckInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getThirdpartycheckInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}