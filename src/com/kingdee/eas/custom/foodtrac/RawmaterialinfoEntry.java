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

public class RawmaterialinfoEntry extends CoreBillEntryBase implements IRawmaterialinfoEntry
{
    public RawmaterialinfoEntry()
    {
        super();
        registerInterface(IRawmaterialinfoEntry.class, this);
    }
    public RawmaterialinfoEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IRawmaterialinfoEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FDC9203A");
    }
    private RawmaterialinfoEntryController getController() throws BOSException
    {
        return (RawmaterialinfoEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public RawmaterialinfoEntryInfo getRawmaterialinfoEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getRawmaterialinfoEntryInfo(getContext(), pk);
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
    public RawmaterialinfoEntryInfo getRawmaterialinfoEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getRawmaterialinfoEntryInfo(getContext(), pk, selector);
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
    public RawmaterialinfoEntryInfo getRawmaterialinfoEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getRawmaterialinfoEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public RawmaterialinfoEntryCollection getRawmaterialinfoEntryCollection() throws BOSException
    {
        try {
            return getController().getRawmaterialinfoEntryCollection(getContext());
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
    public RawmaterialinfoEntryCollection getRawmaterialinfoEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getRawmaterialinfoEntryCollection(getContext(), view);
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
    public RawmaterialinfoEntryCollection getRawmaterialinfoEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getRawmaterialinfoEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}