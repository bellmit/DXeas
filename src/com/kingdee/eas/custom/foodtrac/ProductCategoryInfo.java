package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.foodtrac.app.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ProductCategoryInfo extends CoreBillBase implements IProductCategoryInfo
{
    public ProductCategoryInfo()
    {
        super();
        registerInterface(IProductCategoryInfo.class, this);
    }
    public ProductCategoryInfo(Context ctx)
    {
        super(ctx);
        registerInterface(IProductCategoryInfo.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("51A46076");
    }
    private ProductCategoryInfoController getController() throws BOSException
    {
        return (ProductCategoryInfoController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ProductCategoryInfoCollection getProductCategoryInfoCollection() throws BOSException
    {
        try {
            return getController().getProductCategoryInfoCollection(getContext());
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
    public ProductCategoryInfoCollection getProductCategoryInfoCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getProductCategoryInfoCollection(getContext(), view);
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
    public ProductCategoryInfoCollection getProductCategoryInfoCollection(String oql) throws BOSException
    {
        try {
            return getController().getProductCategoryInfoCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ProductCategoryInfoInfo getProductCategoryInfoInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getProductCategoryInfoInfo(getContext(), pk);
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
    public ProductCategoryInfoInfo getProductCategoryInfoInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getProductCategoryInfoInfo(getContext(), pk, selector);
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
    public ProductCategoryInfoInfo getProductCategoryInfoInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getProductCategoryInfoInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}