package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.salediscount.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DiscountCompany extends DataBase implements IDiscountCompany
{
    public DiscountCompany()
    {
        super();
        registerInterface(IDiscountCompany.class, this);
    }
    public DiscountCompany(Context ctx)
    {
        super(ctx);
        registerInterface(IDiscountCompany.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("AFF2E9A1");
    }
    private DiscountCompanyController getController() throws BOSException
    {
        return (DiscountCompanyController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DiscountCompanyInfo getDiscountCompanyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountCompanyInfo(getContext(), pk);
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
    public DiscountCompanyInfo getDiscountCompanyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountCompanyInfo(getContext(), pk, selector);
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
    public DiscountCompanyInfo getDiscountCompanyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountCompanyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DiscountCompanyCollection getDiscountCompanyCollection() throws BOSException
    {
        try {
            return getController().getDiscountCompanyCollection(getContext());
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
    public DiscountCompanyCollection getDiscountCompanyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDiscountCompanyCollection(getContext(), view);
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
    public DiscountCompanyCollection getDiscountCompanyCollection(String oql) throws BOSException
    {
        try {
            return getController().getDiscountCompanyCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}