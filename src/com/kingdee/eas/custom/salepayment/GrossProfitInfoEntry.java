package com.kingdee.eas.custom.salepayment;

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
import com.kingdee.eas.custom.salepayment.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class GrossProfitInfoEntry extends CoreBillEntryBase implements IGrossProfitInfoEntry
{
    public GrossProfitInfoEntry()
    {
        super();
        registerInterface(IGrossProfitInfoEntry.class, this);
    }
    public GrossProfitInfoEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IGrossProfitInfoEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5AC45C90");
    }
    private GrossProfitInfoEntryController getController() throws BOSException
    {
        return (GrossProfitInfoEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public GrossProfitInfoEntryInfo getGrossProfitInfoEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getGrossProfitInfoEntryInfo(getContext(), pk);
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
    public GrossProfitInfoEntryInfo getGrossProfitInfoEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getGrossProfitInfoEntryInfo(getContext(), pk, selector);
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
    public GrossProfitInfoEntryInfo getGrossProfitInfoEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getGrossProfitInfoEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public GrossProfitInfoEntryCollection getGrossProfitInfoEntryCollection() throws BOSException
    {
        try {
            return getController().getGrossProfitInfoEntryCollection(getContext());
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
    public GrossProfitInfoEntryCollection getGrossProfitInfoEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getGrossProfitInfoEntryCollection(getContext(), view);
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
    public GrossProfitInfoEntryCollection getGrossProfitInfoEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getGrossProfitInfoEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}