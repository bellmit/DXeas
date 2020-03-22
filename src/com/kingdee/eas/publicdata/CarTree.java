package com.kingdee.eas.publicdata;

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
import com.kingdee.eas.publicdata.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CarTree extends TreeBase implements ICarTree
{
    public CarTree()
    {
        super();
        registerInterface(ICarTree.class, this);
    }
    public CarTree(Context ctx)
    {
        super(ctx);
        registerInterface(ICarTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("ECBEA84F");
    }
    private CarTreeController getController() throws BOSException
    {
        return (CarTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CarTreeInfo getCarTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCarTreeInfo(getContext(), pk);
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
    public CarTreeInfo getCarTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCarTreeInfo(getContext(), pk, selector);
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
    public CarTreeInfo getCarTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCarTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CarTreeCollection getCarTreeCollection() throws BOSException
    {
        try {
            return getController().getCarTreeCollection(getContext());
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
    public CarTreeCollection getCarTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCarTreeCollection(getContext(), view);
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
    public CarTreeCollection getCarTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getCarTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}