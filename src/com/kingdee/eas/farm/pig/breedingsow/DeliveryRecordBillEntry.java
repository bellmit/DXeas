package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.pig.breedingsow.app.*;
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

public class DeliveryRecordBillEntry extends CoreBillEntryBase implements IDeliveryRecordBillEntry
{
    public DeliveryRecordBillEntry()
    {
        super();
        registerInterface(IDeliveryRecordBillEntry.class, this);
    }
    public DeliveryRecordBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IDeliveryRecordBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("349C8985");
    }
    private DeliveryRecordBillEntryController getController() throws BOSException
    {
        return (DeliveryRecordBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DeliveryRecordBillEntryInfo getDeliveryRecordBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDeliveryRecordBillEntryInfo(getContext(), pk);
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
    public DeliveryRecordBillEntryInfo getDeliveryRecordBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDeliveryRecordBillEntryInfo(getContext(), pk, selector);
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
    public DeliveryRecordBillEntryInfo getDeliveryRecordBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDeliveryRecordBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DeliveryRecordBillEntryCollection getDeliveryRecordBillEntryCollection() throws BOSException
    {
        try {
            return getController().getDeliveryRecordBillEntryCollection(getContext());
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
    public DeliveryRecordBillEntryCollection getDeliveryRecordBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDeliveryRecordBillEntryCollection(getContext(), view);
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
    public DeliveryRecordBillEntryCollection getDeliveryRecordBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getDeliveryRecordBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}