package com.kingdee.eas.farm.stocking.hatch;

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
import com.kingdee.eas.farm.stocking.hatch.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SecondAllot extends DataBase implements ISecondAllot
{
    public SecondAllot()
    {
        super();
        registerInterface(ISecondAllot.class, this);
    }
    public SecondAllot(Context ctx)
    {
        super(ctx);
        registerInterface(ISecondAllot.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E44F1D08");
    }
    private SecondAllotController getController() throws BOSException
    {
        return (SecondAllotController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SecondAllotInfo getSecondAllotInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSecondAllotInfo(getContext(), pk);
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
    public SecondAllotInfo getSecondAllotInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSecondAllotInfo(getContext(), pk, selector);
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
    public SecondAllotInfo getSecondAllotInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSecondAllotInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SecondAllotCollection getSecondAllotCollection() throws BOSException
    {
        try {
            return getController().getSecondAllotCollection(getContext());
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
    public SecondAllotCollection getSecondAllotCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSecondAllotCollection(getContext(), view);
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
    public SecondAllotCollection getSecondAllotCollection(String oql) throws BOSException
    {
        try {
            return getController().getSecondAllotCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}