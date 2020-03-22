package com.kingdee.eas.farm.stocking.hatch;

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
import com.kingdee.eas.farm.stocking.hatch.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class EggSettleBillCompanyEntry extends CoreBillEntryBase implements IEggSettleBillCompanyEntry
{
    public EggSettleBillCompanyEntry()
    {
        super();
        registerInterface(IEggSettleBillCompanyEntry.class, this);
    }
    public EggSettleBillCompanyEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IEggSettleBillCompanyEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("17DF70C2");
    }
    private EggSettleBillCompanyEntryController getController() throws BOSException
    {
        return (EggSettleBillCompanyEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public EggSettleBillCompanyEntryInfo getEggSettleBillCompanyEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEggSettleBillCompanyEntryInfo(getContext(), pk);
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
    public EggSettleBillCompanyEntryInfo getEggSettleBillCompanyEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEggSettleBillCompanyEntryInfo(getContext(), pk, selector);
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
    public EggSettleBillCompanyEntryInfo getEggSettleBillCompanyEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEggSettleBillCompanyEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public EggSettleBillCompanyEntryCollection getEggSettleBillCompanyEntryCollection() throws BOSException
    {
        try {
            return getController().getEggSettleBillCompanyEntryCollection(getContext());
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
    public EggSettleBillCompanyEntryCollection getEggSettleBillCompanyEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEggSettleBillCompanyEntryCollection(getContext(), view);
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
    public EggSettleBillCompanyEntryCollection getEggSettleBillCompanyEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getEggSettleBillCompanyEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}