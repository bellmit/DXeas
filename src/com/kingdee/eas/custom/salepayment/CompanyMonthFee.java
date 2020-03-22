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

public class CompanyMonthFee extends CoreBillBase implements ICompanyMonthFee
{
    public CompanyMonthFee()
    {
        super();
        registerInterface(ICompanyMonthFee.class, this);
    }
    public CompanyMonthFee(Context ctx)
    {
        super(ctx);
        registerInterface(ICompanyMonthFee.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("7B1F1F0F");
    }
    private CompanyMonthFeeController getController() throws BOSException
    {
        return (CompanyMonthFeeController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CompanyMonthFeeCollection getCompanyMonthFeeCollection() throws BOSException
    {
        try {
            return getController().getCompanyMonthFeeCollection(getContext());
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
    public CompanyMonthFeeCollection getCompanyMonthFeeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCompanyMonthFeeCollection(getContext(), view);
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
    public CompanyMonthFeeCollection getCompanyMonthFeeCollection(String oql) throws BOSException
    {
        try {
            return getController().getCompanyMonthFeeCollection(getContext(), oql);
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
    public CompanyMonthFeeInfo getCompanyMonthFeeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyMonthFeeInfo(getContext(), pk);
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
    public CompanyMonthFeeInfo getCompanyMonthFeeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyMonthFeeInfo(getContext(), pk, selector);
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
    public CompanyMonthFeeInfo getCompanyMonthFeeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyMonthFeeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}