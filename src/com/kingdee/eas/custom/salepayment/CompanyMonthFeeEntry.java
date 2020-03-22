package com.kingdee.eas.custom.salepayment;

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
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.eas.custom.salepayment.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CompanyMonthFeeEntry extends CoreBillEntryBase implements ICompanyMonthFeeEntry
{
    public CompanyMonthFeeEntry()
    {
        super();
        registerInterface(ICompanyMonthFeeEntry.class, this);
    }
    public CompanyMonthFeeEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICompanyMonthFeeEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A4150AA3");
    }
    private CompanyMonthFeeEntryController getController() throws BOSException
    {
        return (CompanyMonthFeeEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CompanyMonthFeeEntryInfo getCompanyMonthFeeEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyMonthFeeEntryInfo(getContext(), pk);
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
    public CompanyMonthFeeEntryInfo getCompanyMonthFeeEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyMonthFeeEntryInfo(getContext(), pk, selector);
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
    public CompanyMonthFeeEntryInfo getCompanyMonthFeeEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyMonthFeeEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CompanyMonthFeeEntryCollection getCompanyMonthFeeEntryCollection() throws BOSException
    {
        try {
            return getController().getCompanyMonthFeeEntryCollection(getContext());
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
    public CompanyMonthFeeEntryCollection getCompanyMonthFeeEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCompanyMonthFeeEntryCollection(getContext(), view);
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
    public CompanyMonthFeeEntryCollection getCompanyMonthFeeEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCompanyMonthFeeEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}