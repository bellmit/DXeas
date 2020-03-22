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

public class HatchBaseDataTree extends TreeBase implements IHatchBaseDataTree
{
    public HatchBaseDataTree()
    {
        super();
        registerInterface(IHatchBaseDataTree.class, this);
    }
    public HatchBaseDataTree(Context ctx)
    {
        super(ctx);
        registerInterface(IHatchBaseDataTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0E62A46B");
    }
    private HatchBaseDataTreeController getController() throws BOSException
    {
        return (HatchBaseDataTreeController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public HatchBaseDataTreeInfo getHatchBaseDataTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchBaseDataTreeInfo(getContext(), pk);
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
    public HatchBaseDataTreeInfo getHatchBaseDataTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchBaseDataTreeInfo(getContext(), pk, selector);
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
    public HatchBaseDataTreeInfo getHatchBaseDataTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchBaseDataTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public HatchBaseDataTreeCollection getHatchBaseDataTreeCollection() throws BOSException
    {
        try {
            return getController().getHatchBaseDataTreeCollection(getContext());
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
    public HatchBaseDataTreeCollection getHatchBaseDataTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getHatchBaseDataTreeCollection(getContext(), view);
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
    public HatchBaseDataTreeCollection getHatchBaseDataTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getHatchBaseDataTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}