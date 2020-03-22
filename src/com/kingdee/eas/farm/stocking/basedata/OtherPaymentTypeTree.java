package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.stocking.basedata.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class OtherPaymentTypeTree extends TreeBase implements IOtherPaymentTypeTree
{
    public OtherPaymentTypeTree()
    {
        super();
        registerInterface(IOtherPaymentTypeTree.class, this);
    }
    public OtherPaymentTypeTree(Context ctx)
    {
        super(ctx);
        registerInterface(IOtherPaymentTypeTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6B02D9BF");
    }
    private OtherPaymentTypeTreeController getController() throws BOSException
    {
        return (OtherPaymentTypeTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public OtherPaymentTypeTreeInfo getOtherPaymentTypeTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getOtherPaymentTypeTreeInfo(getContext(), pk);
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
    public OtherPaymentTypeTreeInfo getOtherPaymentTypeTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getOtherPaymentTypeTreeInfo(getContext(), pk, selector);
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
    public OtherPaymentTypeTreeInfo getOtherPaymentTypeTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getOtherPaymentTypeTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public OtherPaymentTypeTreeCollection getOtherPaymentTypeTreeCollection() throws BOSException
    {
        try {
            return getController().getOtherPaymentTypeTreeCollection(getContext());
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
    public OtherPaymentTypeTreeCollection getOtherPaymentTypeTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getOtherPaymentTypeTreeCollection(getContext(), view);
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
    public OtherPaymentTypeTreeCollection getOtherPaymentTypeTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getOtherPaymentTypeTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}