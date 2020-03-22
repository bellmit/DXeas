package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.eas.farm.feedfactory.app.*;
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

public class JournalTimesTree extends TreeBase implements IJournalTimesTree
{
    public JournalTimesTree()
    {
        super();
        registerInterface(IJournalTimesTree.class, this);
    }
    public JournalTimesTree(Context ctx)
    {
        super(ctx);
        registerInterface(IJournalTimesTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("69B6A46F");
    }
    private JournalTimesTreeController getController() throws BOSException
    {
        return (JournalTimesTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public JournalTimesTreeInfo getJournalTimesTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getJournalTimesTreeInfo(getContext(), pk);
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
    public JournalTimesTreeInfo getJournalTimesTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getJournalTimesTreeInfo(getContext(), pk, selector);
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
    public JournalTimesTreeInfo getJournalTimesTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getJournalTimesTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public JournalTimesTreeCollection getJournalTimesTreeCollection() throws BOSException
    {
        try {
            return getController().getJournalTimesTreeCollection(getContext());
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
    public JournalTimesTreeCollection getJournalTimesTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getJournalTimesTreeCollection(getContext(), view);
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
    public JournalTimesTreeCollection getJournalTimesTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getJournalTimesTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}