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

public class BreedSeedReceiveBillEntry extends CoreBillEntryBase implements IBreedSeedReceiveBillEntry
{
    public BreedSeedReceiveBillEntry()
    {
        super();
        registerInterface(IBreedSeedReceiveBillEntry.class, this);
    }
    public BreedSeedReceiveBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IBreedSeedReceiveBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("7B27A749");
    }
    private BreedSeedReceiveBillEntryController getController() throws BOSException
    {
        return (BreedSeedReceiveBillEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public BreedSeedReceiveBillEntryInfo getBreedSeedReceiveBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedSeedReceiveBillEntryInfo(getContext(), pk);
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
    public BreedSeedReceiveBillEntryInfo getBreedSeedReceiveBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedSeedReceiveBillEntryInfo(getContext(), pk, selector);
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
    public BreedSeedReceiveBillEntryInfo getBreedSeedReceiveBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedSeedReceiveBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public BreedSeedReceiveBillEntryCollection getBreedSeedReceiveBillEntryCollection() throws BOSException
    {
        try {
            return getController().getBreedSeedReceiveBillEntryCollection(getContext());
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
    public BreedSeedReceiveBillEntryCollection getBreedSeedReceiveBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBreedSeedReceiveBillEntryCollection(getContext(), view);
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
    public BreedSeedReceiveBillEntryCollection getBreedSeedReceiveBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getBreedSeedReceiveBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}