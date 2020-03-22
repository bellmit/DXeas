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

public class OilStandPriceTree extends TreeBase implements IOilStandPriceTree
{
    public OilStandPriceTree()
    {
        super();
        registerInterface(IOilStandPriceTree.class, this);
    }
    public OilStandPriceTree(Context ctx)
    {
        super(ctx);
        registerInterface(IOilStandPriceTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("48A7F197");
    }
    private OilStandPriceTreeController getController() throws BOSException
    {
        return (OilStandPriceTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public OilStandPriceTreeInfo getOilStandPriceTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getOilStandPriceTreeInfo(getContext(), pk);
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
    public OilStandPriceTreeInfo getOilStandPriceTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getOilStandPriceTreeInfo(getContext(), pk, selector);
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
    public OilStandPriceTreeInfo getOilStandPriceTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getOilStandPriceTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public OilStandPriceTreeCollection getOilStandPriceTreeCollection() throws BOSException
    {
        try {
            return getController().getOilStandPriceTreeCollection(getContext());
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
    public OilStandPriceTreeCollection getOilStandPriceTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getOilStandPriceTreeCollection(getContext(), view);
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
    public OilStandPriceTreeCollection getOilStandPriceTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getOilStandPriceTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}