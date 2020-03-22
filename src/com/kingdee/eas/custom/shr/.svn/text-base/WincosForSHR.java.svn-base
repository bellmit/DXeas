package com.kingdee.eas.custom.shr;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.shr.app.*;
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

public class WincosForSHR extends DataBase implements IWincosForSHR
{
    public WincosForSHR()
    {
        super();
        registerInterface(IWincosForSHR.class, this);
    }
    public WincosForSHR(Context ctx)
    {
        super(ctx);
        registerInterface(IWincosForSHR.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F4928315");
    }
    private WincosForSHRController getController() throws BOSException
    {
        return (WincosForSHRController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WincosForSHRInfo getWincosForSHRInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWincosForSHRInfo(getContext(), pk);
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
    public WincosForSHRInfo getWincosForSHRInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWincosForSHRInfo(getContext(), pk, selector);
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
    public WincosForSHRInfo getWincosForSHRInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWincosForSHRInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WincosForSHRCollection getWincosForSHRCollection() throws BOSException
    {
        try {
            return getController().getWincosForSHRCollection(getContext());
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
    public WincosForSHRCollection getWincosForSHRCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWincosForSHRCollection(getContext(), view);
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
    public WincosForSHRCollection getWincosForSHRCollection(String oql) throws BOSException
    {
        try {
            return getController().getWincosForSHRCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}