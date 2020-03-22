package com.kingdee.eas.spray;

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
import com.kingdee.eas.spray.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SparyRecordEntry extends CoreBillEntryBase implements ISparyRecordEntry
{
    public SparyRecordEntry()
    {
        super();
        registerInterface(ISparyRecordEntry.class, this);
    }
    public SparyRecordEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ISparyRecordEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2CC670A9");
    }
    private SparyRecordEntryController getController() throws BOSException
    {
        return (SparyRecordEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SparyRecordEntryInfo getSparyRecordEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSparyRecordEntryInfo(getContext(), pk);
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
    public SparyRecordEntryInfo getSparyRecordEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSparyRecordEntryInfo(getContext(), pk, selector);
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
    public SparyRecordEntryInfo getSparyRecordEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSparyRecordEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SparyRecordEntryCollection getSparyRecordEntryCollection() throws BOSException
    {
        try {
            return getController().getSparyRecordEntryCollection(getContext());
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
    public SparyRecordEntryCollection getSparyRecordEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSparyRecordEntryCollection(getContext(), view);
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
    public SparyRecordEntryCollection getSparyRecordEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getSparyRecordEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}