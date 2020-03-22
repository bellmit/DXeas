package com.kingdee.eas.farm.breed.business;

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
import com.kingdee.eas.farm.breed.business.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CCSendFodderStandardTree extends TreeBase implements ICCSendFodderStandardTree
{
    public CCSendFodderStandardTree()
    {
        super();
        registerInterface(ICCSendFodderStandardTree.class, this);
    }
    public CCSendFodderStandardTree(Context ctx)
    {
        super(ctx);
        registerInterface(ICCSendFodderStandardTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1DE0F7E7");
    }
    private CCSendFodderStandardTreeController getController() throws BOSException
    {
        return (CCSendFodderStandardTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CCSendFodderStandardTreeInfo getCCSendFodderStandardTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCCSendFodderStandardTreeInfo(getContext(), pk);
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
    public CCSendFodderStandardTreeInfo getCCSendFodderStandardTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCCSendFodderStandardTreeInfo(getContext(), pk, selector);
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
    public CCSendFodderStandardTreeInfo getCCSendFodderStandardTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCCSendFodderStandardTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CCSendFodderStandardTreeCollection getCCSendFodderStandardTreeCollection() throws BOSException
    {
        try {
            return getController().getCCSendFodderStandardTreeCollection(getContext());
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
    public CCSendFodderStandardTreeCollection getCCSendFodderStandardTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCCSendFodderStandardTreeCollection(getContext(), view);
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
    public CCSendFodderStandardTreeCollection getCCSendFodderStandardTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getCCSendFodderStandardTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}