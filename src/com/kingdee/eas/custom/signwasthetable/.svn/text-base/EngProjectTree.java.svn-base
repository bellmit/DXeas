package com.kingdee.eas.custom.signwasthetable;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.signwasthetable.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class EngProjectTree extends TreeBase implements IEngProjectTree
{
    public EngProjectTree()
    {
        super();
        registerInterface(IEngProjectTree.class, this);
    }
    public EngProjectTree(Context ctx)
    {
        super(ctx);
        registerInterface(IEngProjectTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8F4EA823");
    }
    private EngProjectTreeController getController() throws BOSException
    {
        return (EngProjectTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public EngProjectTreeInfo getEngProjectTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEngProjectTreeInfo(getContext(), pk);
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
    public EngProjectTreeInfo getEngProjectTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEngProjectTreeInfo(getContext(), pk, selector);
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
    public EngProjectTreeInfo getEngProjectTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEngProjectTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public EngProjectTreeCollection getEngProjectTreeCollection() throws BOSException
    {
        try {
            return getController().getEngProjectTreeCollection(getContext());
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
    public EngProjectTreeCollection getEngProjectTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEngProjectTreeCollection(getContext(), view);
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
    public EngProjectTreeCollection getEngProjectTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getEngProjectTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}