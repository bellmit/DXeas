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

public class BreedDataTree extends TreeBase implements IBreedDataTree
{
    public BreedDataTree()
    {
        super();
        registerInterface(IBreedDataTree.class, this);
    }
    public BreedDataTree(Context ctx)
    {
        super(ctx);
        registerInterface(IBreedDataTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("88C4AC4B");
    }
    private BreedDataTreeController getController() throws BOSException
    {
        return (BreedDataTreeController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public BreedDataTreeInfo getBreedDataTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedDataTreeInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public BreedDataTreeInfo getBreedDataTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedDataTreeInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public BreedDataTreeInfo getBreedDataTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedDataTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public BreedDataTreeCollection getBreedDataTreeCollection() throws BOSException
    {
        try {
            return getController().getBreedDataTreeCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public BreedDataTreeCollection getBreedDataTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBreedDataTreeCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public BreedDataTreeCollection getBreedDataTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getBreedDataTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}