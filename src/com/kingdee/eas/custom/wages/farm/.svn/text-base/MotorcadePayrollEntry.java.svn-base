package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.wages.farm.app.*;
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

public class MotorcadePayrollEntry extends CoreBillEntryBase implements IMotorcadePayrollEntry
{
    public MotorcadePayrollEntry()
    {
        super();
        registerInterface(IMotorcadePayrollEntry.class, this);
    }
    public MotorcadePayrollEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IMotorcadePayrollEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("60B23DD7");
    }
    private MotorcadePayrollEntryController getController() throws BOSException
    {
        return (MotorcadePayrollEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public MotorcadePayrollEntryInfo getMotorcadePayrollEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMotorcadePayrollEntryInfo(getContext(), pk);
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
    public MotorcadePayrollEntryInfo getMotorcadePayrollEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMotorcadePayrollEntryInfo(getContext(), pk, selector);
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
    public MotorcadePayrollEntryInfo getMotorcadePayrollEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMotorcadePayrollEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MotorcadePayrollEntryCollection getMotorcadePayrollEntryCollection() throws BOSException
    {
        try {
            return getController().getMotorcadePayrollEntryCollection(getContext());
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
    public MotorcadePayrollEntryCollection getMotorcadePayrollEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMotorcadePayrollEntryCollection(getContext(), view);
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
    public MotorcadePayrollEntryCollection getMotorcadePayrollEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getMotorcadePayrollEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}