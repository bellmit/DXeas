package com.kingdee.eas.custom.salepayment;

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
import com.kingdee.eas.custom.salepayment.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MonthFee extends CoreBillBase implements IMonthFee
{
    public MonthFee()
    {
        super();
        registerInterface(IMonthFee.class, this);
    }
    public MonthFee(Context ctx)
    {
        super(ctx);
        registerInterface(IMonthFee.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("AFB5FBDA");
    }
    private MonthFeeController getController() throws BOSException
    {
        return (MonthFeeController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MonthFeeCollection getMonthFeeCollection() throws BOSException
    {
        try {
            return getController().getMonthFeeCollection(getContext());
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
    public MonthFeeCollection getMonthFeeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMonthFeeCollection(getContext(), view);
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
    public MonthFeeCollection getMonthFeeCollection(String oql) throws BOSException
    {
        try {
            return getController().getMonthFeeCollection(getContext(), oql);
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
    public MonthFeeInfo getMonthFeeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthFeeInfo(getContext(), pk);
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
    public MonthFeeInfo getMonthFeeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthFeeInfo(getContext(), pk, selector);
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
    public MonthFeeInfo getMonthFeeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthFeeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}