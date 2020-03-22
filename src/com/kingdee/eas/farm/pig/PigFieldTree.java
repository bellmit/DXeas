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

public class PigFieldTree extends TreeBase implements IPigFieldTree
{
    public PigFieldTree()
    {
        super();
        registerInterface(IPigFieldTree.class, this);
    }
    public PigFieldTree(Context ctx)
    {
        super(ctx);
        registerInterface(IPigFieldTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C858A40A");
    }
    private PigFieldTreeController getController() throws BOSException
    {
        return (PigFieldTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PigFieldTreeInfo getPigFieldTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPigFieldTreeInfo(getContext(), pk);
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
    public PigFieldTreeInfo getPigFieldTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPigFieldTreeInfo(getContext(), pk, selector);
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
    public PigFieldTreeInfo getPigFieldTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPigFieldTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PigFieldTreeCollection getPigFieldTreeCollection() throws BOSException
    {
        try {
            return getController().getPigFieldTreeCollection(getContext());
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
    public PigFieldTreeCollection getPigFieldTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPigFieldTreeCollection(getContext(), view);
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
    public PigFieldTreeCollection getPigFieldTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getPigFieldTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}