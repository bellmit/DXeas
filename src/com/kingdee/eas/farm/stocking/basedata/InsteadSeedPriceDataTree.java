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

public class InsteadSeedPriceDataTree extends TreeBase implements IInsteadSeedPriceDataTree
{
    public InsteadSeedPriceDataTree()
    {
        super();
        registerInterface(IInsteadSeedPriceDataTree.class, this);
    }
    public InsteadSeedPriceDataTree(Context ctx)
    {
        super(ctx);
        registerInterface(IInsteadSeedPriceDataTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0EDCE10F");
    }
    private InsteadSeedPriceDataTreeController getController() throws BOSException
    {
        return (InsteadSeedPriceDataTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public InsteadSeedPriceDataTreeInfo getInsteadSeedPriceDataTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getInsteadSeedPriceDataTreeInfo(getContext(), pk);
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
    public InsteadSeedPriceDataTreeInfo getInsteadSeedPriceDataTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getInsteadSeedPriceDataTreeInfo(getContext(), pk, selector);
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
    public InsteadSeedPriceDataTreeInfo getInsteadSeedPriceDataTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getInsteadSeedPriceDataTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public InsteadSeedPriceDataTreeCollection getInsteadSeedPriceDataTreeCollection() throws BOSException
    {
        try {
            return getController().getInsteadSeedPriceDataTreeCollection(getContext());
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
    public InsteadSeedPriceDataTreeCollection getInsteadSeedPriceDataTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getInsteadSeedPriceDataTreeCollection(getContext(), view);
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
    public InsteadSeedPriceDataTreeCollection getInsteadSeedPriceDataTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getInsteadSeedPriceDataTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}