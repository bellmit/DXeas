package com.kingdee.eas.custom.salepayment;

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
import com.kingdee.eas.custom.salepayment.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CustomerSaleTargetTree extends TreeBase implements ICustomerSaleTargetTree
{
    public CustomerSaleTargetTree()
    {
        super();
        registerInterface(ICustomerSaleTargetTree.class, this);
    }
    public CustomerSaleTargetTree(Context ctx)
    {
        super(ctx);
        registerInterface(ICustomerSaleTargetTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2B1067E8");
    }
    private CustomerSaleTargetTreeController getController() throws BOSException
    {
        return (CustomerSaleTargetTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CustomerSaleTargetTreeInfo getCustomerSaleTargetTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerSaleTargetTreeInfo(getContext(), pk);
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
    public CustomerSaleTargetTreeInfo getCustomerSaleTargetTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerSaleTargetTreeInfo(getContext(), pk, selector);
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
    public CustomerSaleTargetTreeInfo getCustomerSaleTargetTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerSaleTargetTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CustomerSaleTargetTreeCollection getCustomerSaleTargetTreeCollection() throws BOSException
    {
        try {
            return getController().getCustomerSaleTargetTreeCollection(getContext());
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
    public CustomerSaleTargetTreeCollection getCustomerSaleTargetTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCustomerSaleTargetTreeCollection(getContext(), view);
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
    public CustomerSaleTargetTreeCollection getCustomerSaleTargetTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getCustomerSaleTargetTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}