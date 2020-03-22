package com.kingdee.eas.farm.foodtrac;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.foodtrac.app.*;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FarmCode extends DataBase implements IFarmCode
{
    public FarmCode()
    {
        super();
        registerInterface(IFarmCode.class, this);
    }
    public FarmCode(Context ctx)
    {
        super(ctx);
        registerInterface(IFarmCode.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CDD7F34D");
    }
    private FarmCodeController getController() throws BOSException
    {
        return (FarmCodeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FarmCodeInfo getFarmCodeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmCodeInfo(getContext(), pk);
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
    public FarmCodeInfo getFarmCodeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmCodeInfo(getContext(), pk, selector);
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
    public FarmCodeInfo getFarmCodeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmCodeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FarmCodeCollection getFarmCodeCollection() throws BOSException
    {
        try {
            return getController().getFarmCodeCollection(getContext());
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
    public FarmCodeCollection getFarmCodeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFarmCodeCollection(getContext(), view);
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
    public FarmCodeCollection getFarmCodeCollection(String oql) throws BOSException
    {
        try {
            return getController().getFarmCodeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}