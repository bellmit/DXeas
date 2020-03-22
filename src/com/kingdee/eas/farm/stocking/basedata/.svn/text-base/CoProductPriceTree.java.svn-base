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

public class CoProductPriceTree extends TreeBase implements ICoProductPriceTree
{
    public CoProductPriceTree()
    {
        super();
        registerInterface(ICoProductPriceTree.class, this);
    }
    public CoProductPriceTree(Context ctx)
    {
        super(ctx);
        registerInterface(ICoProductPriceTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("16E55DF5");
    }
    private CoProductPriceTreeController getController() throws BOSException
    {
        return (CoProductPriceTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CoProductPriceTreeInfo getCoProductPriceTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCoProductPriceTreeInfo(getContext(), pk);
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
    public CoProductPriceTreeInfo getCoProductPriceTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCoProductPriceTreeInfo(getContext(), pk, selector);
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
    public CoProductPriceTreeInfo getCoProductPriceTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCoProductPriceTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CoProductPriceTreeCollection getCoProductPriceTreeCollection() throws BOSException
    {
        try {
            return getController().getCoProductPriceTreeCollection(getContext());
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
    public CoProductPriceTreeCollection getCoProductPriceTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCoProductPriceTreeCollection(getContext(), view);
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
    public CoProductPriceTreeCollection getCoProductPriceTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getCoProductPriceTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}