package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.dayratecost.app.*;
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

public class DayRateCostDetailEntry extends CoreBillEntryBase implements IDayRateCostDetailEntry
{
    public DayRateCostDetailEntry()
    {
        super();
        registerInterface(IDayRateCostDetailEntry.class, this);
    }
    public DayRateCostDetailEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IDayRateCostDetailEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("63E8CDFD");
    }
    private DayRateCostDetailEntryController getController() throws BOSException
    {
        return (DayRateCostDetailEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public DayRateCostDetailEntryInfo getDayRateCostDetailEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDayRateCostDetailEntryInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public DayRateCostDetailEntryInfo getDayRateCostDetailEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDayRateCostDetailEntryInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public DayRateCostDetailEntryInfo getDayRateCostDetailEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDayRateCostDetailEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public DayRateCostDetailEntryCollection getDayRateCostDetailEntryCollection() throws BOSException
    {
        try {
            return getController().getDayRateCostDetailEntryCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public DayRateCostDetailEntryCollection getDayRateCostDetailEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDayRateCostDetailEntryCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public DayRateCostDetailEntryCollection getDayRateCostDetailEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getDayRateCostDetailEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}