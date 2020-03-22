package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.foodtrac.app.*;
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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class LeavecheckEntry extends CoreBillEntryBase implements ILeavecheckEntry
{
    public LeavecheckEntry()
    {
        super();
        registerInterface(ILeavecheckEntry.class, this);
    }
    public LeavecheckEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ILeavecheckEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5E42BADC");
    }
    private LeavecheckEntryController getController() throws BOSException
    {
        return (LeavecheckEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public LeavecheckEntryInfo getLeavecheckEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLeavecheckEntryInfo(getContext(), pk);
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
    public LeavecheckEntryInfo getLeavecheckEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLeavecheckEntryInfo(getContext(), pk, selector);
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
    public LeavecheckEntryInfo getLeavecheckEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLeavecheckEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public LeavecheckEntryCollection getLeavecheckEntryCollection() throws BOSException
    {
        try {
            return getController().getLeavecheckEntryCollection(getContext());
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
    public LeavecheckEntryCollection getLeavecheckEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLeavecheckEntryCollection(getContext(), view);
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
    public LeavecheckEntryCollection getLeavecheckEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getLeavecheckEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}