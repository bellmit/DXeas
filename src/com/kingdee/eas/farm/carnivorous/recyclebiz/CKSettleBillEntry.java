package com.kingdee.eas.farm.carnivorous.recyclebiz;

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
import com.kingdee.eas.farm.carnivorous.recyclebiz.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CKSettleBillEntry extends CoreBillEntryBase implements ICKSettleBillEntry
{
    public CKSettleBillEntry()
    {
        super();
        registerInterface(ICKSettleBillEntry.class, this);
    }
    public CKSettleBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICKSettleBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C38F233B");
    }
    private CKSettleBillEntryController getController() throws BOSException
    {
        return (CKSettleBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CKSettleBillEntryInfo getCKSettleBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCKSettleBillEntryInfo(getContext(), pk);
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
    public CKSettleBillEntryInfo getCKSettleBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCKSettleBillEntryInfo(getContext(), pk, selector);
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
    public CKSettleBillEntryInfo getCKSettleBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCKSettleBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CKSettleBillEntryCollection getCKSettleBillEntryCollection() throws BOSException
    {
        try {
            return getController().getCKSettleBillEntryCollection(getContext());
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
    public CKSettleBillEntryCollection getCKSettleBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCKSettleBillEntryCollection(getContext(), view);
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
    public CKSettleBillEntryCollection getCKSettleBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCKSettleBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}