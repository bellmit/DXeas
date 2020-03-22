package com.kingdee.eas.custom.lhsm;

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
import com.kingdee.eas.custom.lhsm.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SaleForecastEntry extends CoreBillEntryBase implements ISaleForecastEntry
{
    public SaleForecastEntry()
    {
        super();
        registerInterface(ISaleForecastEntry.class, this);
    }
    public SaleForecastEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ISaleForecastEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B5CFF663");
    }
    private SaleForecastEntryController getController() throws BOSException
    {
        return (SaleForecastEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SaleForecastEntryInfo getSaleForecastEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleForecastEntryInfo(getContext(), pk);
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
    public SaleForecastEntryInfo getSaleForecastEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleForecastEntryInfo(getContext(), pk, selector);
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
    public SaleForecastEntryInfo getSaleForecastEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSaleForecastEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SaleForecastEntryCollection getSaleForecastEntryCollection() throws BOSException
    {
        try {
            return getController().getSaleForecastEntryCollection(getContext());
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
    public SaleForecastEntryCollection getSaleForecastEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSaleForecastEntryCollection(getContext(), view);
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
    public SaleForecastEntryCollection getSaleForecastEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getSaleForecastEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}