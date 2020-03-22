package com.kingdee.eas.farm.carnivorous.recyclebiz;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.farm.carnivorous.recyclebiz.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CKWeightBillEntry extends CoreBillEntryBase implements ICKWeightBillEntry
{
    public CKWeightBillEntry()
    {
        super();
        registerInterface(ICKWeightBillEntry.class, this);
    }
    public CKWeightBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICKWeightBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8410F4AE");
    }
    private CKWeightBillEntryController getController() throws BOSException
    {
        return (CKWeightBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CKWeightBillEntryInfo getCKWeightBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCKWeightBillEntryInfo(getContext(), pk);
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
    public CKWeightBillEntryInfo getCKWeightBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCKWeightBillEntryInfo(getContext(), pk, selector);
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
    public CKWeightBillEntryInfo getCKWeightBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCKWeightBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CKWeightBillEntryCollection getCKWeightBillEntryCollection() throws BOSException
    {
        try {
            return getController().getCKWeightBillEntryCollection(getContext());
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
    public CKWeightBillEntryCollection getCKWeightBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCKWeightBillEntryCollection(getContext(), view);
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
    public CKWeightBillEntryCollection getCKWeightBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCKWeightBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}