package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.feemanager.basedata.app.*;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
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

public class OilPriceTree extends TreeBase implements IOilPriceTree
{
    public OilPriceTree()
    {
        super();
        registerInterface(IOilPriceTree.class, this);
    }
    public OilPriceTree(Context ctx)
    {
        super(ctx);
        registerInterface(IOilPriceTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9FE66081");
    }
    private OilPriceTreeController getController() throws BOSException
    {
        return (OilPriceTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public OilPriceTreeInfo getOilPriceTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getOilPriceTreeInfo(getContext(), pk);
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
    public OilPriceTreeInfo getOilPriceTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getOilPriceTreeInfo(getContext(), pk, selector);
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
    public OilPriceTreeInfo getOilPriceTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getOilPriceTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public OilPriceTreeCollection getOilPriceTreeCollection() throws BOSException
    {
        try {
            return getController().getOilPriceTreeCollection(getContext());
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
    public OilPriceTreeCollection getOilPriceTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getOilPriceTreeCollection(getContext(), view);
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
    public OilPriceTreeCollection getOilPriceTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getOilPriceTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}