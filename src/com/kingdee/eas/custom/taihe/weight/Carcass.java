package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.taihe.weight.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Carcass extends WlhlBillBase implements ICarcass
{
    public Carcass()
    {
        super();
        registerInterface(ICarcass.class, this);
    }
    public Carcass(Context ctx)
    {
        super(ctx);
        registerInterface(ICarcass.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2B05421C");
    }
    private CarcassController getController() throws BOSException
    {
        return (CarcassController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CarcassCollection getCarcassCollection() throws BOSException
    {
        try {
            return getController().getCarcassCollection(getContext());
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
    public CarcassCollection getCarcassCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCarcassCollection(getContext(), view);
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
    public CarcassCollection getCarcassCollection(String oql) throws BOSException
    {
        try {
            return getController().getCarcassCollection(getContext(), oql);
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
    public CarcassInfo getCarcassInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCarcassInfo(getContext(), pk);
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
    public CarcassInfo getCarcassInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCarcassInfo(getContext(), pk, selector);
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
    public CarcassInfo getCarcassInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCarcassInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}