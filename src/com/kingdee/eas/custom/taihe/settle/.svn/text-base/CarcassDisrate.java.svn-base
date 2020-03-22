package com.kingdee.eas.custom.taihe.settle;

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
import com.kingdee.eas.custom.taihe.settle.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CarcassDisrate extends WlhlDataBase implements ICarcassDisrate
{
    public CarcassDisrate()
    {
        super();
        registerInterface(ICarcassDisrate.class, this);
    }
    public CarcassDisrate(Context ctx)
    {
        super(ctx);
        registerInterface(ICarcassDisrate.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1A7EFAFF");
    }
    private CarcassDisrateController getController() throws BOSException
    {
        return (CarcassDisrateController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CarcassDisrateInfo getCarcassDisrateInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCarcassDisrateInfo(getContext(), pk);
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
    public CarcassDisrateInfo getCarcassDisrateInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCarcassDisrateInfo(getContext(), pk, selector);
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
    public CarcassDisrateInfo getCarcassDisrateInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCarcassDisrateInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CarcassDisrateCollection getCarcassDisrateCollection() throws BOSException
    {
        try {
            return getController().getCarcassDisrateCollection(getContext());
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
    public CarcassDisrateCollection getCarcassDisrateCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCarcassDisrateCollection(getContext(), view);
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
    public CarcassDisrateCollection getCarcassDisrateCollection(String oql) throws BOSException
    {
        try {
            return getController().getCarcassDisrateCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}