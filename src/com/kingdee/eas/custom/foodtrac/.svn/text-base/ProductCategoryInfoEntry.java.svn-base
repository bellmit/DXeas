package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.foodtrac.app.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ProductCategoryInfoEntry extends CoreBillEntryBase implements IProductCategoryInfoEntry
{
    public ProductCategoryInfoEntry()
    {
        super();
        registerInterface(IProductCategoryInfoEntry.class, this);
    }
    public ProductCategoryInfoEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IProductCategoryInfoEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B373919C");
    }
    private ProductCategoryInfoEntryController getController() throws BOSException
    {
        return (ProductCategoryInfoEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ProductCategoryInfoEntryInfo getProductCategoryInfoEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getProductCategoryInfoEntryInfo(getContext(), pk);
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
    public ProductCategoryInfoEntryInfo getProductCategoryInfoEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getProductCategoryInfoEntryInfo(getContext(), pk, selector);
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
    public ProductCategoryInfoEntryInfo getProductCategoryInfoEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getProductCategoryInfoEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ProductCategoryInfoEntryCollection getProductCategoryInfoEntryCollection() throws BOSException
    {
        try {
            return getController().getProductCategoryInfoEntryCollection(getContext());
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
    public ProductCategoryInfoEntryCollection getProductCategoryInfoEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getProductCategoryInfoEntryCollection(getContext(), view);
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
    public ProductCategoryInfoEntryCollection getProductCategoryInfoEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getProductCategoryInfoEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}