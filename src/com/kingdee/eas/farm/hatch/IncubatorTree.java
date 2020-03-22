package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.eas.farm.hatch.app.*;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class IncubatorTree extends TreeBase implements IIncubatorTree
{
    public IncubatorTree()
    {
        super();
        registerInterface(IIncubatorTree.class, this);
    }
    public IncubatorTree(Context ctx)
    {
        super(ctx);
        registerInterface(IIncubatorTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C0742AB1");
    }
    private IncubatorTreeController getController() throws BOSException
    {
        return (IncubatorTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public IncubatorTreeInfo getIncubatorTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getIncubatorTreeInfo(getContext(), pk);
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
    public IncubatorTreeInfo getIncubatorTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getIncubatorTreeInfo(getContext(), pk, selector);
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
    public IncubatorTreeInfo getIncubatorTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getIncubatorTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public IncubatorTreeCollection getIncubatorTreeCollection() throws BOSException
    {
        try {
            return getController().getIncubatorTreeCollection(getContext());
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
    public IncubatorTreeCollection getIncubatorTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getIncubatorTreeCollection(getContext(), view);
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
    public IncubatorTreeCollection getIncubatorTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getIncubatorTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}