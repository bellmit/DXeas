package com.kingdee.eas.farm.pig.ccpig;

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
import com.kingdee.eas.farm.pig.ccpig.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CCPigBreedModelTree extends TreeBase implements ICCPigBreedModelTree
{
    public CCPigBreedModelTree()
    {
        super();
        registerInterface(ICCPigBreedModelTree.class, this);
    }
    public CCPigBreedModelTree(Context ctx)
    {
        super(ctx);
        registerInterface(ICCPigBreedModelTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6D384B61");
    }
    private CCPigBreedModelTreeController getController() throws BOSException
    {
        return (CCPigBreedModelTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CCPigBreedModelTreeInfo getCCPigBreedModelTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCCPigBreedModelTreeInfo(getContext(), pk);
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
    public CCPigBreedModelTreeInfo getCCPigBreedModelTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCCPigBreedModelTreeInfo(getContext(), pk, selector);
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
    public CCPigBreedModelTreeInfo getCCPigBreedModelTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCCPigBreedModelTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CCPigBreedModelTreeCollection getCCPigBreedModelTreeCollection() throws BOSException
    {
        try {
            return getController().getCCPigBreedModelTreeCollection(getContext());
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
    public CCPigBreedModelTreeCollection getCCPigBreedModelTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCCPigBreedModelTreeCollection(getContext(), view);
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
    public CCPigBreedModelTreeCollection getCCPigBreedModelTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getCCPigBreedModelTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}