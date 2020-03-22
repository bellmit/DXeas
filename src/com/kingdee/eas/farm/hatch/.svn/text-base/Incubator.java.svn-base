package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.hatch.app.*;
import com.kingdee.bos.dao.IObjectPK;
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

public class Incubator extends DataBase implements IIncubator
{
    public Incubator()
    {
        super();
        registerInterface(IIncubator.class, this);
    }
    public Incubator(Context ctx)
    {
        super(ctx);
        registerInterface(IIncubator.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("31F1B473");
    }
    private IncubatorController getController() throws BOSException
    {
        return (IncubatorController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public IncubatorInfo getIncubatorInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getIncubatorInfo(getContext(), pk);
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
    public IncubatorInfo getIncubatorInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getIncubatorInfo(getContext(), pk, selector);
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
    public IncubatorInfo getIncubatorInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getIncubatorInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public IncubatorCollection getIncubatorCollection() throws BOSException
    {
        try {
            return getController().getIncubatorCollection(getContext());
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
    public IncubatorCollection getIncubatorCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getIncubatorCollection(getContext(), view);
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
    public IncubatorCollection getIncubatorCollection(String oql) throws BOSException
    {
        try {
            return getController().getIncubatorCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}