package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.wages.farm.app.*;
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

public class TAttendFarmRecordEntry extends CoreBillEntryBase implements ITAttendFarmRecordEntry
{
    public TAttendFarmRecordEntry()
    {
        super();
        registerInterface(ITAttendFarmRecordEntry.class, this);
    }
    public TAttendFarmRecordEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ITAttendFarmRecordEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("DD1F8F27");
    }
    private TAttendFarmRecordEntryController getController() throws BOSException
    {
        return (TAttendFarmRecordEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public TAttendFarmRecordEntryInfo getTAttendFarmRecordEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTAttendFarmRecordEntryInfo(getContext(), pk);
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
    public TAttendFarmRecordEntryInfo getTAttendFarmRecordEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTAttendFarmRecordEntryInfo(getContext(), pk, selector);
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
    public TAttendFarmRecordEntryInfo getTAttendFarmRecordEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTAttendFarmRecordEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public TAttendFarmRecordEntryCollection getTAttendFarmRecordEntryCollection() throws BOSException
    {
        try {
            return getController().getTAttendFarmRecordEntryCollection(getContext());
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
    public TAttendFarmRecordEntryCollection getTAttendFarmRecordEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTAttendFarmRecordEntryCollection(getContext(), view);
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
    public TAttendFarmRecordEntryCollection getTAttendFarmRecordEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getTAttendFarmRecordEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}