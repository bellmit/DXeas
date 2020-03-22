package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class InsuranceRegistEntry extends CoreBillEntryBase implements IInsuranceRegistEntry
{
    public InsuranceRegistEntry()
    {
        super();
        registerInterface(IInsuranceRegistEntry.class, this);
    }
    public InsuranceRegistEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IInsuranceRegistEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FE46476A");
    }
    private InsuranceRegistEntryController getController() throws BOSException
    {
        return (InsuranceRegistEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public InsuranceRegistEntryInfo getInsuranceRegistEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getInsuranceRegistEntryInfo(getContext(), pk);
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
    public InsuranceRegistEntryInfo getInsuranceRegistEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getInsuranceRegistEntryInfo(getContext(), pk, selector);
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
    public InsuranceRegistEntryInfo getInsuranceRegistEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getInsuranceRegistEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public InsuranceRegistEntryCollection getInsuranceRegistEntryCollection() throws BOSException
    {
        try {
            return getController().getInsuranceRegistEntryCollection(getContext());
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
    public InsuranceRegistEntryCollection getInsuranceRegistEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getInsuranceRegistEntryCollection(getContext(), view);
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
    public InsuranceRegistEntryCollection getInsuranceRegistEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getInsuranceRegistEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}