package com.kingdee.eas.farm.pig;

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
import com.kingdee.eas.farm.pig.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PigBatchTypeTree extends TreeBase implements IPigBatchTypeTree
{
    public PigBatchTypeTree()
    {
        super();
        registerInterface(IPigBatchTypeTree.class, this);
    }
    public PigBatchTypeTree(Context ctx)
    {
        super(ctx);
        registerInterface(IPigBatchTypeTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E5765AA4");
    }
    private PigBatchTypeTreeController getController() throws BOSException
    {
        return (PigBatchTypeTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PigBatchTypeTreeInfo getPigBatchTypeTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPigBatchTypeTreeInfo(getContext(), pk);
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
    public PigBatchTypeTreeInfo getPigBatchTypeTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPigBatchTypeTreeInfo(getContext(), pk, selector);
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
    public PigBatchTypeTreeInfo getPigBatchTypeTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPigBatchTypeTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PigBatchTypeTreeCollection getPigBatchTypeTreeCollection() throws BOSException
    {
        try {
            return getController().getPigBatchTypeTreeCollection(getContext());
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
    public PigBatchTypeTreeCollection getPigBatchTypeTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPigBatchTypeTreeCollection(getContext(), view);
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
    public PigBatchTypeTreeCollection getPigBatchTypeTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getPigBatchTypeTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}