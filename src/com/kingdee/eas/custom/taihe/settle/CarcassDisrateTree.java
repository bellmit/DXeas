package com.kingdee.eas.custom.taihe.settle;

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
import com.kingdee.eas.custom.taihe.settle.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CarcassDisrateTree extends TreeBase implements ICarcassDisrateTree
{
    public CarcassDisrateTree()
    {
        super();
        registerInterface(ICarcassDisrateTree.class, this);
    }
    public CarcassDisrateTree(Context ctx)
    {
        super(ctx);
        registerInterface(ICarcassDisrateTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("7CA34B3D");
    }
    private CarcassDisrateTreeController getController() throws BOSException
    {
        return (CarcassDisrateTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CarcassDisrateTreeInfo getCarcassDisrateTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCarcassDisrateTreeInfo(getContext(), pk);
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
    public CarcassDisrateTreeInfo getCarcassDisrateTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCarcassDisrateTreeInfo(getContext(), pk, selector);
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
    public CarcassDisrateTreeInfo getCarcassDisrateTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCarcassDisrateTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CarcassDisrateTreeCollection getCarcassDisrateTreeCollection() throws BOSException
    {
        try {
            return getController().getCarcassDisrateTreeCollection(getContext());
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
    public CarcassDisrateTreeCollection getCarcassDisrateTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCarcassDisrateTreeCollection(getContext(), view);
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
    public CarcassDisrateTreeCollection getCarcassDisrateTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getCarcassDisrateTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}