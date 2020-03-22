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

public class StrainTree extends TreeBase implements IStrainTree
{
    public StrainTree()
    {
        super();
        registerInterface(IStrainTree.class, this);
    }
    public StrainTree(Context ctx)
    {
        super(ctx);
        registerInterface(IStrainTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("44C1D0F3");
    }
    private StrainTreeController getController() throws BOSException
    {
        return (StrainTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public StrainTreeInfo getStrainTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getStrainTreeInfo(getContext(), pk);
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
    public StrainTreeInfo getStrainTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getStrainTreeInfo(getContext(), pk, selector);
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
    public StrainTreeInfo getStrainTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getStrainTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public StrainTreeCollection getStrainTreeCollection() throws BOSException
    {
        try {
            return getController().getStrainTreeCollection(getContext());
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
    public StrainTreeCollection getStrainTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getStrainTreeCollection(getContext(), view);
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
    public StrainTreeCollection getStrainTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getStrainTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}