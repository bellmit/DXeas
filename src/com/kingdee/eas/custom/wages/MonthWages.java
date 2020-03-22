package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MonthWages extends WlhlBillBase implements IMonthWages
{
    public MonthWages()
    {
        super();
        registerInterface(IMonthWages.class, this);
    }
    public MonthWages(Context ctx)
    {
        super(ctx);
        registerInterface(IMonthWages.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B43603B3");
    }
    private MonthWagesController getController() throws BOSException
    {
        return (MonthWagesController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MonthWagesCollection getMonthWagesCollection() throws BOSException
    {
        try {
            return getController().getMonthWagesCollection(getContext());
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
    public MonthWagesCollection getMonthWagesCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMonthWagesCollection(getContext(), view);
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
    public MonthWagesCollection getMonthWagesCollection(String oql) throws BOSException
    {
        try {
            return getController().getMonthWagesCollection(getContext(), oql);
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
    public MonthWagesInfo getMonthWagesInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthWagesInfo(getContext(), pk);
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
    public MonthWagesInfo getMonthWagesInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthWagesInfo(getContext(), pk, selector);
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
    public MonthWagesInfo getMonthWagesInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthWagesInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}