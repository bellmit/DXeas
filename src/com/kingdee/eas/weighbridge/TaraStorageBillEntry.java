package com.kingdee.eas.weighbridge;

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
import com.kingdee.eas.weighbridge.app.*;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class TaraStorageBillEntry extends CoreBillEntryBase implements ITaraStorageBillEntry
{
    public TaraStorageBillEntry()
    {
        super();
        registerInterface(ITaraStorageBillEntry.class, this);
    }
    public TaraStorageBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ITaraStorageBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("50394647");
    }
    private TaraStorageBillEntryController getController() throws BOSException
    {
        return (TaraStorageBillEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public TaraStorageBillEntryInfo getTaraStorageBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTaraStorageBillEntryInfo(getContext(), pk);
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
    public TaraStorageBillEntryInfo getTaraStorageBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTaraStorageBillEntryInfo(getContext(), pk, selector);
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
    public TaraStorageBillEntryInfo getTaraStorageBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTaraStorageBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public TaraStorageBillEntryCollection getTaraStorageBillEntryCollection() throws BOSException
    {
        try {
            return getController().getTaraStorageBillEntryCollection(getContext());
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
    public TaraStorageBillEntryCollection getTaraStorageBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTaraStorageBillEntryCollection(getContext(), view);
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
    public TaraStorageBillEntryCollection getTaraStorageBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getTaraStorageBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}