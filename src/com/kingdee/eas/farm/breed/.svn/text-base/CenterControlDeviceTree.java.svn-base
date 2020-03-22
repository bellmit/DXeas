package com.kingdee.eas.farm.breed;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.eas.farm.breed.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CenterControlDeviceTree extends TreeBase implements ICenterControlDeviceTree
{
    public CenterControlDeviceTree()
    {
        super();
        registerInterface(ICenterControlDeviceTree.class, this);
    }
    public CenterControlDeviceTree(Context ctx)
    {
        super(ctx);
        registerInterface(ICenterControlDeviceTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("7BA105E2");
    }
    private CenterControlDeviceTreeController getController() throws BOSException
    {
        return (CenterControlDeviceTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CenterControlDeviceTreeInfo getCenterControlDeviceTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCenterControlDeviceTreeInfo(getContext(), pk);
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
    public CenterControlDeviceTreeInfo getCenterControlDeviceTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCenterControlDeviceTreeInfo(getContext(), pk, selector);
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
    public CenterControlDeviceTreeInfo getCenterControlDeviceTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCenterControlDeviceTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CenterControlDeviceTreeCollection getCenterControlDeviceTreeCollection() throws BOSException
    {
        try {
            return getController().getCenterControlDeviceTreeCollection(getContext());
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
    public CenterControlDeviceTreeCollection getCenterControlDeviceTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCenterControlDeviceTreeCollection(getContext(), view);
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
    public CenterControlDeviceTreeCollection getCenterControlDeviceTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getCenterControlDeviceTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}