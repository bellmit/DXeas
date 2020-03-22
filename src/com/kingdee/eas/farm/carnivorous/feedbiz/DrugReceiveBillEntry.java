package com.kingdee.eas.farm.carnivorous.feedbiz;

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
import com.kingdee.eas.farm.carnivorous.feedbiz.app.*;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DrugReceiveBillEntry extends CoreBillEntryBase implements IDrugReceiveBillEntry
{
    public DrugReceiveBillEntry()
    {
        super();
        registerInterface(IDrugReceiveBillEntry.class, this);
    }
    public DrugReceiveBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IDrugReceiveBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F887C12C");
    }
    private DrugReceiveBillEntryController getController() throws BOSException
    {
        return (DrugReceiveBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DrugReceiveBillEntryInfo getDrugReceiveBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDrugReceiveBillEntryInfo(getContext(), pk);
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
    public DrugReceiveBillEntryInfo getDrugReceiveBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDrugReceiveBillEntryInfo(getContext(), pk, selector);
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
    public DrugReceiveBillEntryInfo getDrugReceiveBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDrugReceiveBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DrugReceiveBillEntryCollection getDrugReceiveBillEntryCollection() throws BOSException
    {
        try {
            return getController().getDrugReceiveBillEntryCollection(getContext());
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
    public DrugReceiveBillEntryCollection getDrugReceiveBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDrugReceiveBillEntryCollection(getContext(), view);
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
    public DrugReceiveBillEntryCollection getDrugReceiveBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getDrugReceiveBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}