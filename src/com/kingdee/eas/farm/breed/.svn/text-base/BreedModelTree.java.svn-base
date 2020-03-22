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

public class BreedModelTree extends TreeBase implements IBreedModelTree
{
    public BreedModelTree()
    {
        super();
        registerInterface(IBreedModelTree.class, this);
    }
    public BreedModelTree(Context ctx)
    {
        super(ctx);
        registerInterface(IBreedModelTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2B40E32D");
    }
    private BreedModelTreeController getController() throws BOSException
    {
        return (BreedModelTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BreedModelTreeInfo getBreedModelTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedModelTreeInfo(getContext(), pk);
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
    public BreedModelTreeInfo getBreedModelTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedModelTreeInfo(getContext(), pk, selector);
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
    public BreedModelTreeInfo getBreedModelTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedModelTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BreedModelTreeCollection getBreedModelTreeCollection() throws BOSException
    {
        try {
            return getController().getBreedModelTreeCollection(getContext());
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
    public BreedModelTreeCollection getBreedModelTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBreedModelTreeCollection(getContext(), view);
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
    public BreedModelTreeCollection getBreedModelTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getBreedModelTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}