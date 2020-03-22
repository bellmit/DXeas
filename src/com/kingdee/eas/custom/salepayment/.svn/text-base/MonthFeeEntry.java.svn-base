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

public class MonthFeeEntry extends CoreBillEntryBase implements IMonthFeeEntry
{
    public MonthFeeEntry()
    {
        super();
        registerInterface(IMonthFeeEntry.class, this);
    }
    public MonthFeeEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IMonthFeeEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A1CF74B8");
    }
    private MonthFeeEntryController getController() throws BOSException
    {
        return (MonthFeeEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public MonthFeeEntryInfo getMonthFeeEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthFeeEntryInfo(getContext(), pk);
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
    public MonthFeeEntryInfo getMonthFeeEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthFeeEntryInfo(getContext(), pk, selector);
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
    public MonthFeeEntryInfo getMonthFeeEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthFeeEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MonthFeeEntryCollection getMonthFeeEntryCollection() throws BOSException
    {
        try {
            return getController().getMonthFeeEntryCollection(getContext());
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
    public MonthFeeEntryCollection getMonthFeeEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMonthFeeEntryCollection(getContext(), view);
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
    public MonthFeeEntryCollection getMonthFeeEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getMonthFeeEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}