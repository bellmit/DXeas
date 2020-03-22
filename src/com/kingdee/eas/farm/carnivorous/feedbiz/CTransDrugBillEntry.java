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

public class CTransDrugBillEntry extends CoreBillEntryBase implements ICTransDrugBillEntry
{
    public CTransDrugBillEntry()
    {
        super();
        registerInterface(ICTransDrugBillEntry.class, this);
    }
    public CTransDrugBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICTransDrugBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("390DB002");
    }
    private CTransDrugBillEntryController getController() throws BOSException
    {
        return (CTransDrugBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CTransDrugBillEntryInfo getCTransDrugBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCTransDrugBillEntryInfo(getContext(), pk);
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
    public CTransDrugBillEntryInfo getCTransDrugBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCTransDrugBillEntryInfo(getContext(), pk, selector);
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
    public CTransDrugBillEntryInfo getCTransDrugBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCTransDrugBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CTransDrugBillEntryCollection getCTransDrugBillEntryCollection() throws BOSException
    {
        try {
            return getController().getCTransDrugBillEntryCollection(getContext());
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
    public CTransDrugBillEntryCollection getCTransDrugBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCTransDrugBillEntryCollection(getContext(), view);
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
    public CTransDrugBillEntryCollection getCTransDrugBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCTransDrugBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}