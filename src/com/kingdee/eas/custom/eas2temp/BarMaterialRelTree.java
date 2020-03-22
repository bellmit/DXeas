package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import java.lang.String;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.custom.eas2temp.app.*;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.util.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.TreeBase;

public class BarMaterialRelTree extends TreeBase implements IBarMaterialRelTree
{
    public BarMaterialRelTree()
    {
        super();
        registerInterface(IBarMaterialRelTree.class, this);
    }
    public BarMaterialRelTree(Context ctx)
    {
        super(ctx);
        registerInterface(IBarMaterialRelTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E8F4CCF1");
    }
    private BarMaterialRelTreeController getController() throws BOSException
    {
        return (BarMaterialRelTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BarMaterialRelTreeInfo getBarMaterialRelTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBarMaterialRelTreeInfo(getContext(), pk);
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
    public BarMaterialRelTreeInfo getBarMaterialRelTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBarMaterialRelTreeInfo(getContext(), pk, selector);
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
    public BarMaterialRelTreeInfo getBarMaterialRelTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBarMaterialRelTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BarMaterialRelTreeCollection getBarMaterialRelTreeCollection() throws BOSException
    {
        try {
            return getController().getBarMaterialRelTreeCollection(getContext());
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
    public BarMaterialRelTreeCollection getBarMaterialRelTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBarMaterialRelTreeCollection(getContext(), view);
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
    public BarMaterialRelTreeCollection getBarMaterialRelTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getBarMaterialRelTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}