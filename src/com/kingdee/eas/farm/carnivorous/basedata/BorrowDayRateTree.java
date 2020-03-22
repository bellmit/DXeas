package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.eas.farm.carnivorous.basedata.app.*;
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

public class BorrowDayRateTree extends TreeBase implements IBorrowDayRateTree
{
    public BorrowDayRateTree()
    {
        super();
        registerInterface(IBorrowDayRateTree.class, this);
    }
    public BorrowDayRateTree(Context ctx)
    {
        super(ctx);
        registerInterface(IBorrowDayRateTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9E3B19C3");
    }
    private BorrowDayRateTreeController getController() throws BOSException
    {
        return (BorrowDayRateTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BorrowDayRateTreeInfo getBorrowDayRateTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBorrowDayRateTreeInfo(getContext(), pk);
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
    public BorrowDayRateTreeInfo getBorrowDayRateTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBorrowDayRateTreeInfo(getContext(), pk, selector);
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
    public BorrowDayRateTreeInfo getBorrowDayRateTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBorrowDayRateTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BorrowDayRateTreeCollection getBorrowDayRateTreeCollection() throws BOSException
    {
        try {
            return getController().getBorrowDayRateTreeCollection(getContext());
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
    public BorrowDayRateTreeCollection getBorrowDayRateTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBorrowDayRateTreeCollection(getContext(), view);
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
    public BorrowDayRateTreeCollection getBorrowDayRateTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getBorrowDayRateTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}