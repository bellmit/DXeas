package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.wages.farm.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FarmPostStand extends DataBase implements IFarmPostStand
{
    public FarmPostStand()
    {
        super();
        registerInterface(IFarmPostStand.class, this);
    }
    public FarmPostStand(Context ctx)
    {
        super(ctx);
        registerInterface(IFarmPostStand.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("64902796");
    }
    private FarmPostStandController getController() throws BOSException
    {
        return (FarmPostStandController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FarmPostStandInfo getFarmPostStandInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmPostStandInfo(getContext(), pk);
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
    public FarmPostStandInfo getFarmPostStandInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmPostStandInfo(getContext(), pk, selector);
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
    public FarmPostStandInfo getFarmPostStandInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmPostStandInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FarmPostStandCollection getFarmPostStandCollection() throws BOSException
    {
        try {
            return getController().getFarmPostStandCollection(getContext());
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
    public FarmPostStandCollection getFarmPostStandCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFarmPostStandCollection(getContext(), view);
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
    public FarmPostStandCollection getFarmPostStandCollection(String oql) throws BOSException
    {
        try {
            return getController().getFarmPostStandCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}