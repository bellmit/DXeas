package com.kingdee.eas.custom.wages;

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
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WageOrganizationTree extends TreeBase implements IWageOrganizationTree
{
    public WageOrganizationTree()
    {
        super();
        registerInterface(IWageOrganizationTree.class, this);
    }
    public WageOrganizationTree(Context ctx)
    {
        super(ctx);
        registerInterface(IWageOrganizationTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A22190C1");
    }
    private WageOrganizationTreeController getController() throws BOSException
    {
        return (WageOrganizationTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WageOrganizationTreeInfo getWageOrganizationTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWageOrganizationTreeInfo(getContext(), pk);
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
    public WageOrganizationTreeInfo getWageOrganizationTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWageOrganizationTreeInfo(getContext(), pk, selector);
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
    public WageOrganizationTreeInfo getWageOrganizationTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWageOrganizationTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WageOrganizationTreeCollection getWageOrganizationTreeCollection() throws BOSException
    {
        try {
            return getController().getWageOrganizationTreeCollection(getContext());
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
    public WageOrganizationTreeCollection getWageOrganizationTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWageOrganizationTreeCollection(getContext(), view);
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
    public WageOrganizationTreeCollection getWageOrganizationTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getWageOrganizationTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}