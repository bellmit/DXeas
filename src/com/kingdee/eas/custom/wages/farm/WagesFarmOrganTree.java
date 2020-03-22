package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.wages.farm.app.*;
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

public class WagesFarmOrganTree extends TreeBase implements IWagesFarmOrganTree
{
    public WagesFarmOrganTree()
    {
        super();
        registerInterface(IWagesFarmOrganTree.class, this);
    }
    public WagesFarmOrganTree(Context ctx)
    {
        super(ctx);
        registerInterface(IWagesFarmOrganTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E05814D8");
    }
    private WagesFarmOrganTreeController getController() throws BOSException
    {
        return (WagesFarmOrganTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WagesFarmOrganTreeInfo getWagesFarmOrganTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWagesFarmOrganTreeInfo(getContext(), pk);
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
    public WagesFarmOrganTreeInfo getWagesFarmOrganTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWagesFarmOrganTreeInfo(getContext(), pk, selector);
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
    public WagesFarmOrganTreeInfo getWagesFarmOrganTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWagesFarmOrganTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WagesFarmOrganTreeCollection getWagesFarmOrganTreeCollection() throws BOSException
    {
        try {
            return getController().getWagesFarmOrganTreeCollection(getContext());
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
    public WagesFarmOrganTreeCollection getWagesFarmOrganTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWagesFarmOrganTreeCollection(getContext(), view);
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
    public WagesFarmOrganTreeCollection getWagesFarmOrganTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getWagesFarmOrganTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}