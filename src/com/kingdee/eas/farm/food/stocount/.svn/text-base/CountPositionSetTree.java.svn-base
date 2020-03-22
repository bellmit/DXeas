package com.kingdee.eas.farm.food.stocount;

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
import com.kingdee.eas.farm.food.stocount.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CountPositionSetTree extends TreeBase implements ICountPositionSetTree
{
    public CountPositionSetTree()
    {
        super();
        registerInterface(ICountPositionSetTree.class, this);
    }
    public CountPositionSetTree(Context ctx)
    {
        super(ctx);
        registerInterface(ICountPositionSetTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("DC2CE6E5");
    }
    private CountPositionSetTreeController getController() throws BOSException
    {
        return (CountPositionSetTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CountPositionSetTreeInfo getCountPositionSetTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCountPositionSetTreeInfo(getContext(), pk);
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
    public CountPositionSetTreeInfo getCountPositionSetTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCountPositionSetTreeInfo(getContext(), pk, selector);
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
    public CountPositionSetTreeInfo getCountPositionSetTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCountPositionSetTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CountPositionSetTreeCollection getCountPositionSetTreeCollection() throws BOSException
    {
        try {
            return getController().getCountPositionSetTreeCollection(getContext());
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
    public CountPositionSetTreeCollection getCountPositionSetTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCountPositionSetTreeCollection(getContext(), view);
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
    public CountPositionSetTreeCollection getCountPositionSetTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getCountPositionSetTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}