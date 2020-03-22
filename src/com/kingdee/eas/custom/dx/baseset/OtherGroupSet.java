package com.kingdee.eas.custom.dx.baseset;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.dx.baseset.app.*;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlDataBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class OtherGroupSet extends WlhlDataBase implements IOtherGroupSet
{
    public OtherGroupSet()
    {
        super();
        registerInterface(IOtherGroupSet.class, this);
    }
    public OtherGroupSet(Context ctx)
    {
        super(ctx);
        registerInterface(IOtherGroupSet.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F135A1C7");
    }
    private OtherGroupSetController getController() throws BOSException
    {
        return (OtherGroupSetController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public OtherGroupSetInfo getOtherGroupSetInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getOtherGroupSetInfo(getContext(), pk);
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
    public OtherGroupSetInfo getOtherGroupSetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getOtherGroupSetInfo(getContext(), pk, selector);
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
    public OtherGroupSetInfo getOtherGroupSetInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getOtherGroupSetInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public OtherGroupSetCollection getOtherGroupSetCollection() throws BOSException
    {
        try {
            return getController().getOtherGroupSetCollection(getContext());
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
    public OtherGroupSetCollection getOtherGroupSetCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getOtherGroupSetCollection(getContext(), view);
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
    public OtherGroupSetCollection getOtherGroupSetCollection(String oql) throws BOSException
    {
        try {
            return getController().getOtherGroupSetCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}