package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.hatch.app.*;
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

public class EggCandlingBillEntry extends CoreBillEntryBase implements IEggCandlingBillEntry
{
    public EggCandlingBillEntry()
    {
        super();
        registerInterface(IEggCandlingBillEntry.class, this);
    }
    public EggCandlingBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IEggCandlingBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F39918CA");
    }
    private EggCandlingBillEntryController getController() throws BOSException
    {
        return (EggCandlingBillEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public EggCandlingBillEntryInfo getEggCandlingBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEggCandlingBillEntryInfo(getContext(), pk);
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
    public EggCandlingBillEntryInfo getEggCandlingBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEggCandlingBillEntryInfo(getContext(), pk, selector);
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
    public EggCandlingBillEntryInfo getEggCandlingBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEggCandlingBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public EggCandlingBillEntryCollection getEggCandlingBillEntryCollection() throws BOSException
    {
        try {
            return getController().getEggCandlingBillEntryCollection(getContext());
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
    public EggCandlingBillEntryCollection getEggCandlingBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEggCandlingBillEntryCollection(getContext(), view);
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
    public EggCandlingBillEntryCollection getEggCandlingBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getEggCandlingBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}