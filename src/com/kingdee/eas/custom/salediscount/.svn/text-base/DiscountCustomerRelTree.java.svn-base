package com.kingdee.eas.custom.salediscount;

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
import com.kingdee.eas.custom.salediscount.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DiscountCustomerRelTree extends TreeBase implements IDiscountCustomerRelTree
{
    public DiscountCustomerRelTree()
    {
        super();
        registerInterface(IDiscountCustomerRelTree.class, this);
    }
    public DiscountCustomerRelTree(Context ctx)
    {
        super(ctx);
        registerInterface(IDiscountCustomerRelTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A867173D");
    }
    private DiscountCustomerRelTreeController getController() throws BOSException
    {
        return (DiscountCustomerRelTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DiscountCustomerRelTreeInfo getDiscountCustomerRelTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountCustomerRelTreeInfo(getContext(), pk);
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
    public DiscountCustomerRelTreeInfo getDiscountCustomerRelTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountCustomerRelTreeInfo(getContext(), pk, selector);
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
    public DiscountCustomerRelTreeInfo getDiscountCustomerRelTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountCustomerRelTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DiscountCustomerRelTreeCollection getDiscountCustomerRelTreeCollection() throws BOSException
    {
        try {
            return getController().getDiscountCustomerRelTreeCollection(getContext());
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
    public DiscountCustomerRelTreeCollection getDiscountCustomerRelTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDiscountCustomerRelTreeCollection(getContext(), view);
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
    public DiscountCustomerRelTreeCollection getDiscountCustomerRelTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getDiscountCustomerRelTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}