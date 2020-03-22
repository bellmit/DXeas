package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.eas.farm.hatch.app.*;
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

public class HatchHouseTree extends TreeBase implements IHatchHouseTree
{
    public HatchHouseTree()
    {
        super();
        registerInterface(IHatchHouseTree.class, this);
    }
    public HatchHouseTree(Context ctx)
    {
        super(ctx);
        registerInterface(IHatchHouseTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D1E3C00C");
    }
    private HatchHouseTreeController getController() throws BOSException
    {
        return (HatchHouseTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public HatchHouseTreeInfo getHatchHouseTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchHouseTreeInfo(getContext(), pk);
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
    public HatchHouseTreeInfo getHatchHouseTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchHouseTreeInfo(getContext(), pk, selector);
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
    public HatchHouseTreeInfo getHatchHouseTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchHouseTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public HatchHouseTreeCollection getHatchHouseTreeCollection() throws BOSException
    {
        try {
            return getController().getHatchHouseTreeCollection(getContext());
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
    public HatchHouseTreeCollection getHatchHouseTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getHatchHouseTreeCollection(getContext(), view);
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
    public HatchHouseTreeCollection getHatchHouseTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getHatchHouseTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}