package com.kingdee.eas.custom.wages;

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
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DailyOutPut extends CoreBillBase implements IDailyOutPut
{
    public DailyOutPut()
    {
        super();
        registerInterface(IDailyOutPut.class, this);
    }
    public DailyOutPut(Context ctx)
    {
        super(ctx);
        registerInterface(IDailyOutPut.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8CDF0352");
    }
    private DailyOutPutController getController() throws BOSException
    {
        return (DailyOutPutController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DailyOutPutCollection getDailyOutPutCollection() throws BOSException
    {
        try {
            return getController().getDailyOutPutCollection(getContext());
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
    public DailyOutPutCollection getDailyOutPutCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDailyOutPutCollection(getContext(), view);
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
    public DailyOutPutCollection getDailyOutPutCollection(String oql) throws BOSException
    {
        try {
            return getController().getDailyOutPutCollection(getContext(), oql);
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
    public DailyOutPutInfo getDailyOutPutInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDailyOutPutInfo(getContext(), pk);
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
    public DailyOutPutInfo getDailyOutPutInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDailyOutPutInfo(getContext(), pk, selector);
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
    public DailyOutPutInfo getDailyOutPutInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDailyOutPutInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(DailyOutPutInfo model) throws BOSException
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
    public void unaudit(DailyOutPutInfo model) throws BOSException
    {
        try {
            getController().unaudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *计算日工资-User defined method
     *@param model model
     */
    public void salaryCount(DailyOutPutInfo model) throws BOSException
    {
        try {
            getController().salaryCount(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}