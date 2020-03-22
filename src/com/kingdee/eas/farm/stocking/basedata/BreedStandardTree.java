package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.stocking.basedata.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BreedStandardTree extends TreeBase implements IBreedStandardTree
{
    public BreedStandardTree()
    {
        super();
        registerInterface(IBreedStandardTree.class, this);
    }
    public BreedStandardTree(Context ctx)
    {
        super(ctx);
        registerInterface(IBreedStandardTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FA29705E");
    }
    private BreedStandardTreeController getController() throws BOSException
    {
        return (BreedStandardTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BreedStandardTreeInfo getBreedStandardTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedStandardTreeInfo(getContext(), pk);
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
    public BreedStandardTreeInfo getBreedStandardTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedStandardTreeInfo(getContext(), pk, selector);
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
    public BreedStandardTreeInfo getBreedStandardTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedStandardTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BreedStandardTreeCollection getBreedStandardTreeCollection() throws BOSException
    {
        try {
            return getController().getBreedStandardTreeCollection(getContext());
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
    public BreedStandardTreeCollection getBreedStandardTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBreedStandardTreeCollection(getContext(), view);
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
    public BreedStandardTreeCollection getBreedStandardTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getBreedStandardTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}