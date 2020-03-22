package com.kingdee.eas.custom.taihe.sale;

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
import com.kingdee.eas.custom.taihe.sale.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ComplainedTypeTree extends TreeBase implements IComplainedTypeTree
{
    public ComplainedTypeTree()
    {
        super();
        registerInterface(IComplainedTypeTree.class, this);
    }
    public ComplainedTypeTree(Context ctx)
    {
        super(ctx);
        registerInterface(IComplainedTypeTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("84EAAC27");
    }
    private ComplainedTypeTreeController getController() throws BOSException
    {
        return (ComplainedTypeTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ComplainedTypeTreeInfo getComplainedTypeTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getComplainedTypeTreeInfo(getContext(), pk);
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
    public ComplainedTypeTreeInfo getComplainedTypeTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getComplainedTypeTreeInfo(getContext(), pk, selector);
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
    public ComplainedTypeTreeInfo getComplainedTypeTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getComplainedTypeTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ComplainedTypeTreeCollection getComplainedTypeTreeCollection() throws BOSException
    {
        try {
            return getController().getComplainedTypeTreeCollection(getContext());
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
    public ComplainedTypeTreeCollection getComplainedTypeTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getComplainedTypeTreeCollection(getContext(), view);
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
    public ComplainedTypeTreeCollection getComplainedTypeTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getComplainedTypeTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}