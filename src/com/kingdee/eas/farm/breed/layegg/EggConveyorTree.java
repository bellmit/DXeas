package com.kingdee.eas.farm.breed.layegg;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.layegg.app.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class EggConveyorTree extends TreeBase implements IEggConveyorTree
{
    public EggConveyorTree()
    {
        super();
        registerInterface(IEggConveyorTree.class, this);
    }
    public EggConveyorTree(Context ctx)
    {
        super(ctx);
        registerInterface(IEggConveyorTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D808B981");
    }
    private EggConveyorTreeController getController() throws BOSException
    {
        return (EggConveyorTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public EggConveyorTreeInfo getEggConveyorTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEggConveyorTreeInfo(getContext(), pk);
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
    public EggConveyorTreeInfo getEggConveyorTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEggConveyorTreeInfo(getContext(), pk, selector);
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
    public EggConveyorTreeInfo getEggConveyorTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEggConveyorTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public EggConveyorTreeCollection getEggConveyorTreeCollection() throws BOSException
    {
        try {
            return getController().getEggConveyorTreeCollection(getContext());
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
    public EggConveyorTreeCollection getEggConveyorTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEggConveyorTreeCollection(getContext(), view);
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
    public EggConveyorTreeCollection getEggConveyorTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getEggConveyorTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}