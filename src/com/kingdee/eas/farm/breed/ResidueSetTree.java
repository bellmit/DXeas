package com.kingdee.eas.farm.breed;

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
import com.kingdee.eas.farm.breed.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ResidueSetTree extends TreeBase implements IResidueSetTree
{
    public ResidueSetTree()
    {
        super();
        registerInterface(IResidueSetTree.class, this);
    }
    public ResidueSetTree(Context ctx)
    {
        super(ctx);
        registerInterface(IResidueSetTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("84CC62EF");
    }
    private ResidueSetTreeController getController() throws BOSException
    {
        return (ResidueSetTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ResidueSetTreeInfo getResidueSetTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getResidueSetTreeInfo(getContext(), pk);
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
    public ResidueSetTreeInfo getResidueSetTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getResidueSetTreeInfo(getContext(), pk, selector);
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
    public ResidueSetTreeInfo getResidueSetTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getResidueSetTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ResidueSetTreeCollection getResidueSetTreeCollection() throws BOSException
    {
        try {
            return getController().getResidueSetTreeCollection(getContext());
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
    public ResidueSetTreeCollection getResidueSetTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getResidueSetTreeCollection(getContext(), view);
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
    public ResidueSetTreeCollection getResidueSetTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getResidueSetTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}