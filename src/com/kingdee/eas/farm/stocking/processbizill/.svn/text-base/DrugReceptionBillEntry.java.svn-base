package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.stocking.processbizill.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DrugReceptionBillEntry extends CoreBillEntryBase implements IDrugReceptionBillEntry
{
    public DrugReceptionBillEntry()
    {
        super();
        registerInterface(IDrugReceptionBillEntry.class, this);
    }
    public DrugReceptionBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IDrugReceptionBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F9735001");
    }
    private DrugReceptionBillEntryController getController() throws BOSException
    {
        return (DrugReceptionBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DrugReceptionBillEntryInfo getDrugReceptionBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDrugReceptionBillEntryInfo(getContext(), pk);
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
    public DrugReceptionBillEntryInfo getDrugReceptionBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDrugReceptionBillEntryInfo(getContext(), pk, selector);
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
    public DrugReceptionBillEntryInfo getDrugReceptionBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDrugReceptionBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DrugReceptionBillEntryCollection getDrugReceptionBillEntryCollection() throws BOSException
    {
        try {
            return getController().getDrugReceptionBillEntryCollection(getContext());
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
    public DrugReceptionBillEntryCollection getDrugReceptionBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDrugReceptionBillEntryCollection(getContext(), view);
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
    public DrugReceptionBillEntryCollection getDrugReceptionBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getDrugReceptionBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}