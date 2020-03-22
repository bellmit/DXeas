package com.kingdee.eas.farm.breed.business;

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
import com.kingdee.eas.farm.breed.business.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CCLeaveBillEntry extends CoreBillEntryBase implements ICCLeaveBillEntry
{
    public CCLeaveBillEntry()
    {
        super();
        registerInterface(ICCLeaveBillEntry.class, this);
    }
    public CCLeaveBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICCLeaveBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C0DDEF62");
    }
    private CCLeaveBillEntryController getController() throws BOSException
    {
        return (CCLeaveBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CCLeaveBillEntryInfo getCCLeaveBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCCLeaveBillEntryInfo(getContext(), pk);
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
    public CCLeaveBillEntryInfo getCCLeaveBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCCLeaveBillEntryInfo(getContext(), pk, selector);
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
    public CCLeaveBillEntryInfo getCCLeaveBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCCLeaveBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CCLeaveBillEntryCollection getCCLeaveBillEntryCollection() throws BOSException
    {
        try {
            return getController().getCCLeaveBillEntryCollection(getContext());
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
    public CCLeaveBillEntryCollection getCCLeaveBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCCLeaveBillEntryCollection(getContext(), view);
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
    public CCLeaveBillEntryCollection getCCLeaveBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCCLeaveBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}