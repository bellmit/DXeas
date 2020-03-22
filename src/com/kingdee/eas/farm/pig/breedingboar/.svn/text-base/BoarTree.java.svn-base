package com.kingdee.eas.farm.pig.breedingboar;

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
import com.kingdee.eas.farm.pig.breedingboar.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BoarTree extends TreeBase implements IBoarTree
{
    public BoarTree()
    {
        super();
        registerInterface(IBoarTree.class, this);
    }
    public BoarTree(Context ctx)
    {
        super(ctx);
        registerInterface(IBoarTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F2D483B8");
    }
    private BoarTreeController getController() throws BOSException
    {
        return (BoarTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BoarTreeInfo getBoarTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBoarTreeInfo(getContext(), pk);
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
    public BoarTreeInfo getBoarTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBoarTreeInfo(getContext(), pk, selector);
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
    public BoarTreeInfo getBoarTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBoarTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BoarTreeCollection getBoarTreeCollection() throws BOSException
    {
        try {
            return getController().getBoarTreeCollection(getContext());
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
    public BoarTreeCollection getBoarTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBoarTreeCollection(getContext(), view);
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
    public BoarTreeCollection getBoarTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getBoarTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}