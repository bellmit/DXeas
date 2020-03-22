package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.settlebill.app.*;
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

public class CarcassRateTree extends TreeBase implements ICarcassRateTree
{
    public CarcassRateTree()
    {
        super();
        registerInterface(ICarcassRateTree.class, this);
    }
    public CarcassRateTree(Context ctx)
    {
        super(ctx);
        registerInterface(ICarcassRateTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B3F85BBF");
    }
    private CarcassRateTreeController getController() throws BOSException
    {
        return (CarcassRateTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CarcassRateTreeInfo getCarcassRateTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCarcassRateTreeInfo(getContext(), pk);
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
    public CarcassRateTreeInfo getCarcassRateTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCarcassRateTreeInfo(getContext(), pk, selector);
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
    public CarcassRateTreeInfo getCarcassRateTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCarcassRateTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CarcassRateTreeCollection getCarcassRateTreeCollection() throws BOSException
    {
        try {
            return getController().getCarcassRateTreeCollection(getContext());
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
    public CarcassRateTreeCollection getCarcassRateTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCarcassRateTreeCollection(getContext(), view);
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
    public CarcassRateTreeCollection getCarcassRateTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getCarcassRateTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}