package com.kingdee.eas.custom.shr;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.shr.app.*;
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

public class PrePersonToPersonEntry extends CoreBillEntryBase implements IPrePersonToPersonEntry
{
    public PrePersonToPersonEntry()
    {
        super();
        registerInterface(IPrePersonToPersonEntry.class, this);
    }
    public PrePersonToPersonEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IPrePersonToPersonEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("526D3800");
    }
    private PrePersonToPersonEntryController getController() throws BOSException
    {
        return (PrePersonToPersonEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PrePersonToPersonEntryInfo getPrePersonToPersonEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPrePersonToPersonEntryInfo(getContext(), pk);
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
    public PrePersonToPersonEntryInfo getPrePersonToPersonEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPrePersonToPersonEntryInfo(getContext(), pk, selector);
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
    public PrePersonToPersonEntryInfo getPrePersonToPersonEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPrePersonToPersonEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PrePersonToPersonEntryCollection getPrePersonToPersonEntryCollection() throws BOSException
    {
        try {
            return getController().getPrePersonToPersonEntryCollection(getContext());
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
    public PrePersonToPersonEntryCollection getPrePersonToPersonEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPrePersonToPersonEntryCollection(getContext(), view);
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
    public PrePersonToPersonEntryCollection getPrePersonToPersonEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getPrePersonToPersonEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}