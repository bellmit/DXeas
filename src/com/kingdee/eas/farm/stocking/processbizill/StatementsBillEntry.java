package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.stocking.processbizill.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class StatementsBillEntry extends CoreBillEntryBase implements IStatementsBillEntry
{
    public StatementsBillEntry()
    {
        super();
        registerInterface(IStatementsBillEntry.class, this);
    }
    public StatementsBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IStatementsBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("00DD34A2");
    }
    private StatementsBillEntryController getController() throws BOSException
    {
        return (StatementsBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public StatementsBillEntryInfo getStatementsBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getStatementsBillEntryInfo(getContext(), pk);
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
    public StatementsBillEntryInfo getStatementsBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getStatementsBillEntryInfo(getContext(), pk, selector);
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
    public StatementsBillEntryInfo getStatementsBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getStatementsBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public StatementsBillEntryCollection getStatementsBillEntryCollection() throws BOSException
    {
        try {
            return getController().getStatementsBillEntryCollection(getContext());
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
    public StatementsBillEntryCollection getStatementsBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getStatementsBillEntryCollection(getContext(), view);
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
    public StatementsBillEntryCollection getStatementsBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getStatementsBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}