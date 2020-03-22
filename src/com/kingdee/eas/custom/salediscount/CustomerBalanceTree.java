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

public class CustomerBalanceTree extends TreeBase implements ICustomerBalanceTree
{
    public CustomerBalanceTree()
    {
        super();
        registerInterface(ICustomerBalanceTree.class, this);
    }
    public CustomerBalanceTree(Context ctx)
    {
        super(ctx);
        registerInterface(ICustomerBalanceTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("26BD2501");
    }
    private CustomerBalanceTreeController getController() throws BOSException
    {
        return (CustomerBalanceTreeController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public CustomerBalanceTreeInfo getCustomerBalanceTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerBalanceTreeInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public CustomerBalanceTreeInfo getCustomerBalanceTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerBalanceTreeInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public CustomerBalanceTreeInfo getCustomerBalanceTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerBalanceTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public CustomerBalanceTreeCollection getCustomerBalanceTreeCollection() throws BOSException
    {
        try {
            return getController().getCustomerBalanceTreeCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public CustomerBalanceTreeCollection getCustomerBalanceTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCustomerBalanceTreeCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public CustomerBalanceTreeCollection getCustomerBalanceTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getCustomerBalanceTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}