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

public class HatchingBoxTree extends TreeBase implements IHatchingBoxTree
{
    public HatchingBoxTree()
    {
        super();
        registerInterface(IHatchingBoxTree.class, this);
    }
    public HatchingBoxTree(Context ctx)
    {
        super(ctx);
        registerInterface(IHatchingBoxTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9863EE39");
    }
    private HatchingBoxTreeController getController() throws BOSException
    {
        return (HatchingBoxTreeController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public HatchingBoxTreeInfo getHatchingBoxTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchingBoxTreeInfo(getContext(), pk);
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
    public HatchingBoxTreeInfo getHatchingBoxTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchingBoxTreeInfo(getContext(), pk, selector);
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
    public HatchingBoxTreeInfo getHatchingBoxTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchingBoxTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public HatchingBoxTreeCollection getHatchingBoxTreeCollection() throws BOSException
    {
        try {
            return getController().getHatchingBoxTreeCollection(getContext());
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
    public HatchingBoxTreeCollection getHatchingBoxTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getHatchingBoxTreeCollection(getContext(), view);
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
    public HatchingBoxTreeCollection getHatchingBoxTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getHatchingBoxTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}