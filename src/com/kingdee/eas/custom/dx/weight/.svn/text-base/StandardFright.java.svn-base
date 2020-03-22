package com.kingdee.eas.custom.dx.weight;

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
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlDataBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.dx.weight.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class StandardFright extends WlhlDataBase implements IStandardFright
{
    public StandardFright()
    {
        super();
        registerInterface(IStandardFright.class, this);
    }
    public StandardFright(Context ctx)
    {
        super(ctx);
        registerInterface(IStandardFright.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E8803874");
    }
    private StandardFrightController getController() throws BOSException
    {
        return (StandardFrightController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public StandardFrightInfo getStandardFrightInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getStandardFrightInfo(getContext(), pk);
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
    public StandardFrightInfo getStandardFrightInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getStandardFrightInfo(getContext(), pk, selector);
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
    public StandardFrightInfo getStandardFrightInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getStandardFrightInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public StandardFrightCollection getStandardFrightCollection() throws BOSException
    {
        try {
            return getController().getStandardFrightCollection(getContext());
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
    public StandardFrightCollection getStandardFrightCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getStandardFrightCollection(getContext(), view);
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
    public StandardFrightCollection getStandardFrightCollection(String oql) throws BOSException
    {
        try {
            return getController().getStandardFrightCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}