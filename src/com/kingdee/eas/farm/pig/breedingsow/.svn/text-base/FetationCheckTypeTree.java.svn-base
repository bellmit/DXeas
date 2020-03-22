package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.pig.breedingsow.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FetationCheckTypeTree extends TreeBase implements IFetationCheckTypeTree
{
    public FetationCheckTypeTree()
    {
        super();
        registerInterface(IFetationCheckTypeTree.class, this);
    }
    public FetationCheckTypeTree(Context ctx)
    {
        super(ctx);
        registerInterface(IFetationCheckTypeTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C8F77EFF");
    }
    private FetationCheckTypeTreeController getController() throws BOSException
    {
        return (FetationCheckTypeTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FetationCheckTypeTreeInfo getFetationCheckTypeTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFetationCheckTypeTreeInfo(getContext(), pk);
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
    public FetationCheckTypeTreeInfo getFetationCheckTypeTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFetationCheckTypeTreeInfo(getContext(), pk, selector);
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
    public FetationCheckTypeTreeInfo getFetationCheckTypeTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFetationCheckTypeTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FetationCheckTypeTreeCollection getFetationCheckTypeTreeCollection() throws BOSException
    {
        try {
            return getController().getFetationCheckTypeTreeCollection(getContext());
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
    public FetationCheckTypeTreeCollection getFetationCheckTypeTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFetationCheckTypeTreeCollection(getContext(), view);
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
    public FetationCheckTypeTreeCollection getFetationCheckTypeTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getFetationCheckTypeTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}