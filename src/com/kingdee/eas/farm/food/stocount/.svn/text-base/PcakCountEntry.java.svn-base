package com.kingdee.eas.farm.food.stocount;

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
import com.kingdee.eas.farm.food.stocount.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PcakCountEntry extends CoreBillEntryBase implements IPcakCountEntry
{
    public PcakCountEntry()
    {
        super();
        registerInterface(IPcakCountEntry.class, this);
    }
    public PcakCountEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IPcakCountEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1CFBADDD");
    }
    private PcakCountEntryController getController() throws BOSException
    {
        return (PcakCountEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PcakCountEntryInfo getPcakCountEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPcakCountEntryInfo(getContext(), pk);
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
    public PcakCountEntryInfo getPcakCountEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPcakCountEntryInfo(getContext(), pk, selector);
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
    public PcakCountEntryInfo getPcakCountEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPcakCountEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PcakCountEntryCollection getPcakCountEntryCollection() throws BOSException
    {
        try {
            return getController().getPcakCountEntryCollection(getContext());
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
    public PcakCountEntryCollection getPcakCountEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPcakCountEntryCollection(getContext(), view);
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
    public PcakCountEntryCollection getPcakCountEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getPcakCountEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}