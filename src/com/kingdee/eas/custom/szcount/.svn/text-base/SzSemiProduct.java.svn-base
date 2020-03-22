package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

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
import com.kingdee.eas.custom.szcount.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SzSemiProduct extends CoreBillBase implements ISzSemiProduct
{
    public SzSemiProduct()
    {
        super();
        registerInterface(ISzSemiProduct.class, this);
    }
    public SzSemiProduct(Context ctx)
    {
        super(ctx);
        registerInterface(ISzSemiProduct.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("02ABF12F");
    }
    private SzSemiProductController getController() throws BOSException
    {
        return (SzSemiProductController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SzSemiProductCollection getSzSemiProductCollection() throws BOSException
    {
        try {
            return getController().getSzSemiProductCollection(getContext());
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
    public SzSemiProductCollection getSzSemiProductCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSzSemiProductCollection(getContext(), view);
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
    public SzSemiProductCollection getSzSemiProductCollection(String oql) throws BOSException
    {
        try {
            return getController().getSzSemiProductCollection(getContext(), oql);
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
    public SzSemiProductInfo getSzSemiProductInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSzSemiProductInfo(getContext(), pk);
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
    public SzSemiProductInfo getSzSemiProductInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSzSemiProductInfo(getContext(), pk, selector);
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
    public SzSemiProductInfo getSzSemiProductInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSzSemiProductInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(SzSemiProductInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param model model
     */
    public void unaudit(SzSemiProductInfo model) throws BOSException
    {
        try {
            getController().unaudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *计数界面-User defined method
     *@param model model
     */
    public void countInterface(SzSemiProductInfo model) throws BOSException
    {
        try {
            getController().countInterface(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *批量审核-User defined method
     *@param model model
     */
    public void allAudit(SzSemiProductInfo model) throws BOSException
    {
        try {
            getController().allAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}