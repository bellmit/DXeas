package com.kingdee.eas.custom.signwasthetable;

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
import com.kingdee.eas.custom.signwasthetable.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class OverPayEntry extends CoreBillEntryBase implements IOverPayEntry
{
    public OverPayEntry()
    {
        super();
        registerInterface(IOverPayEntry.class, this);
    }
    public OverPayEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IOverPayEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6A2B19A8");
    }
    private OverPayEntryController getController() throws BOSException
    {
        return (OverPayEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public OverPayEntryInfo getOverPayEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getOverPayEntryInfo(getContext(), pk);
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
    public OverPayEntryInfo getOverPayEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getOverPayEntryInfo(getContext(), pk, selector);
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
    public OverPayEntryInfo getOverPayEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getOverPayEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public OverPayEntryCollection getOverPayEntryCollection() throws BOSException
    {
        try {
            return getController().getOverPayEntryCollection(getContext());
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
    public OverPayEntryCollection getOverPayEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getOverPayEntryCollection(getContext(), view);
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
    public OverPayEntryCollection getOverPayEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getOverPayEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}