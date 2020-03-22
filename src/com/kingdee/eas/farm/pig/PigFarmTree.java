package com.kingdee.eas.farm.pig;

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
import com.kingdee.eas.farm.pig.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PigFarmTree extends TreeBase implements IPigFarmTree
{
    public PigFarmTree()
    {
        super();
        registerInterface(IPigFarmTree.class, this);
    }
    public PigFarmTree(Context ctx)
    {
        super(ctx);
        registerInterface(IPigFarmTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("22E63A62");
    }
    private PigFarmTreeController getController() throws BOSException
    {
        return (PigFarmTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PigFarmTreeInfo getPigFarmTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPigFarmTreeInfo(getContext(), pk);
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
    public PigFarmTreeInfo getPigFarmTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPigFarmTreeInfo(getContext(), pk, selector);
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
    public PigFarmTreeInfo getPigFarmTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPigFarmTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PigFarmTreeCollection getPigFarmTreeCollection() throws BOSException
    {
        try {
            return getController().getPigFarmTreeCollection(getContext());
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
    public PigFarmTreeCollection getPigFarmTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPigFarmTreeCollection(getContext(), view);
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
    public PigFarmTreeCollection getPigFarmTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getPigFarmTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}