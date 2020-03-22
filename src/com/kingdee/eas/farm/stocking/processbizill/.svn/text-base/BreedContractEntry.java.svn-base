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

public class BreedContractEntry extends CoreBillEntryBase implements IBreedContractEntry
{
    public BreedContractEntry()
    {
        super();
        registerInterface(IBreedContractEntry.class, this);
    }
    public BreedContractEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IBreedContractEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("AB31C191");
    }
    private BreedContractEntryController getController() throws BOSException
    {
        return (BreedContractEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BreedContractEntryInfo getBreedContractEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedContractEntryInfo(getContext(), pk);
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
    public BreedContractEntryInfo getBreedContractEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedContractEntryInfo(getContext(), pk, selector);
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
    public BreedContractEntryInfo getBreedContractEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedContractEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BreedContractEntryCollection getBreedContractEntryCollection() throws BOSException
    {
        try {
            return getController().getBreedContractEntryCollection(getContext());
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
    public BreedContractEntryCollection getBreedContractEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBreedContractEntryCollection(getContext(), view);
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
    public BreedContractEntryCollection getBreedContractEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getBreedContractEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}